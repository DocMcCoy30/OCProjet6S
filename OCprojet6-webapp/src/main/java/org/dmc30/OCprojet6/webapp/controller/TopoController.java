package org.dmc30.OCprojet6.webapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.bean.Topo;
import org.dmc30.OCprojet6.model.bean.TopoReservation;
import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.dmc30.OCprojet6.webapp.resource.AuthenticationResource;
import org.dmc30.OCprojet6.webapp.resource.SiteResource;
import org.dmc30.OCprojet6.webapp.resource.TopoResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Controller
public class TopoController {

    Logger logger = LogManager.getLogger(TopoController.class);

    @Inject
    SiteResource siteResource;
    @Inject
    TopoResource topoResource;
    @Inject
    AuthenticationResource authenticationResource;


    @GetMapping("/showTopoPage")
    public ModelAndView showTopoPage(@RequestParam(value = "siteId") Integer pSiteId,
                                     String pMessageSucces, String pMessageAlert) {
        ModelAndView vMaV = new ModelAndView();
        String vMessageSuccess, vMessageAlert;
        if (pMessageSucces == null) {
            vMessageSuccess = "";
        } else {
            vMessageSuccess = pMessageSucces;
        }
        if (pMessageAlert == null) {
            vMessageAlert = "";
        } else {
            vMessageAlert = pMessageAlert;
        }
        //récupérer le site
        Site vSite = siteResource.getSiteById(pSiteId);
        //récupérer les topos pour le site concerné
        List<Topo> vListTopo = topoResource.getTopoBySiteId(pSiteId);
        //récupérer les réservations antérieures à la date du jour pour les topos
        for (Topo vTopo : vListTopo
        ) {
            List<TopoReservation> vListReservations = topoResource.getTopoReservationsByTopoId(vTopo.getId());
            vTopo.setListReservations(vListReservations);
        }
        vMaV.addObject("topos", vListTopo);
        vMaV.addObject("site", vSite);
        vMaV.addObject("messageAlert", vMessageAlert);
        vMaV.addObject("messageSuccess", vMessageSuccess);
        vMaV.setViewName("topos");
        return vMaV;
    }

    @PostMapping("/createTopo")
    public ModelAndView createTopo(@RequestParam(value = "siteId") Integer pSiteId,
                                   @RequestParam(value = "topoNom") String vTopoNom,
                                   @RequestParam(value = "dateParution") String vDateParution,
                                   @RequestParam(value = "username") String pUsername) throws TechnicalException {
//        ModelAndView vMaV = new ModelAndView();
        String vMessageSuccess = "";
        String vMessageAlert = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date vDate = null;
        Site vSite = siteResource.getSiteById(pSiteId);
        Users vUser = authenticationResource.getUserByName(pUsername);
        try {
            vDate = formatter.parse(vDateParution);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Topo vTopo = new Topo(vTopoNom, vDate, vSite, vUser);
        try {
            topoResource.createTopo(vTopo);
            vMessageSuccess = "Le topo " + vTopoNom + " a été ajouté.";
        } catch (TechnicalException e) {
            vMessageAlert = e.getMessage();
        }
        return showTopoPage(pSiteId, vMessageSuccess, vMessageAlert);
    }

    @PostMapping("/reserveTopo")
    public ModelAndView reserveTopo(@RequestParam(value = "siteId") Integer pSiteId,
                                    @RequestParam(value = "reservationTopoId") Integer pTopoId,
                                    @RequestParam(value = "dateReservation", required = false) String pDateReservation,
                                    @RequestParam(value = "username") String pUsername) throws TechnicalException {

        ModelAndView vMaV = new ModelAndView();
        String vMessageSuccess = "";
        String vMessageAlert = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date vDateReservation = null;
        List<String> vDates = new ArrayList<>();
        String vDate = "";
        Boolean vReservation = false;

        //verifier la saisie de l'utilisateur
        try {
            if ((pDateReservation.matches("^,+") || (pDateReservation.isEmpty()))) {
                vMessageAlert = "Veuillez indiquer une date de réservation !";
            } else {
                Pattern p = Pattern.compile(",");
                String[] dates = p.split(pDateReservation, 10);
                for (int i = 0; i < dates.length; i++) {
                    if (!(dates[i].isEmpty())) {
                        vDates.add(dates[i]);
                    }
                }
                if (vDates.size() > 1) {
                    vMessageAlert = "Merci de ne saisir qu'une seule réservation à la fois !";
                } else {
                    vDate = vDates.get(0);
                    vReservation = true;
                }
            }

            if (vReservation) {
                vDateReservation = formatter.parse(vDate);
                try {
                    //récupérer les topos pour le site concerné
                    Users vUser = authenticationResource.getUserByName(pUsername);
                    Topo vTopo = topoResource.getTopoById(pTopoId);
                    TopoReservation vTopoReservation = new TopoReservation(vDateReservation, vTopo, vUser);
                    //vérifier que la date de réservation est disponible
                    if (rechercheDoublonDate(vDateReservation, pTopoId)) {
                        vMessageAlert = "Le topo " + vTopo.getNom() + " est déjà reservée pour le " + vDate + ".";
                    } else {
                        topoResource.createTopoReservation(vTopoReservation);
                        vMessageSuccess = "La réservation du topo " + vTopo.getNom() + " le " + vDate + " par " + pUsername + " est effectuée.";
                    }
                } catch (TechnicalException e) {
                    vMessageAlert = e.getMessage();
                }
            }
        } catch (
                ParseException e) {
            e.printStackTrace();
        }
        return showTopoPage(pSiteId, vMessageSuccess, vMessageAlert);
    }

    public boolean rechercheDoublonDate(Date pDate, int pTopoId) {
        boolean doublon = false;
        int i = 0;
        List<TopoReservation> vListReservations = topoResource.getTopoReservationsByTopoId(pTopoId);
        for (TopoReservation vReservation : vListReservations
        ) {
            if (pDate.equals(vReservation.getDateReservation())) {
                i++;
            }
        }
        if (i > 0) {
            doublon = true;
        }
        return doublon;
    }
}
