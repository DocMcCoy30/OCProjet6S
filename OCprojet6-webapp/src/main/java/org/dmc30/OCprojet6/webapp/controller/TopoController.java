package org.dmc30.OCprojet6.webapp.controller;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.*;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.dmc30.OCprojet6.webapp.resource.UserResource;
import org.dmc30.OCprojet6.webapp.resource.SiteResource;
import org.dmc30.OCprojet6.webapp.resource.TopoResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    UserResource userResource;
    @Inject
    AccueilController accueilController;


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
        //récupérer les réservations validées et en attente pour les topos
        for (Topo vTopo : vListTopo
        ) {
            List<TopoReservation> vListReservations = topoResource.getTopoReservationsByTopoId(vTopo.getId());
            for (TopoReservation vTopoReservation:vListReservations
                 ) {
                if (vTopoReservation.getStatut().getId()<3) {
                    vTopo.setListReservations(vListReservations);
                }
            }
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
                                   @RequestParam(value = "dateParution") int vDateParution,
                                   @RequestParam(value = "description") String vDescription,
                                   @RequestParam(value = "username") String pUsername) throws TechnicalException {
        String vMessageSucces = "";
        String vMessageAlert = "";
        Site vSite = siteResource.getSiteById(pSiteId);
        Users vUser = userResource.getUserByName(pUsername);
        Topo vTopo;

        if (String.valueOf(vDateParution).matches("\\d{4}")) {
            if (vDescription.isEmpty()) {
                vDescription = "Aucune description pour ce topo";
            }
            vTopo = new Topo(vTopoNom, vDateParution, vDescription, vSite, vUser);
            try {
                    topoResource.createTopo(vTopo);
                    vMessageSucces = "Le topo " + vTopoNom + " a été ajouté.";
                } catch (TechnicalException e) {
                    vMessageAlert = e.getMessage();
                }

        }
        else {
            vMessageAlert = "L'année de publication n'est pas valide";
        }
        return showTopoPage(pSiteId, vMessageSucces, vMessageAlert);
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
                    Users vUser = userResource.getUserByName(pUsername);
                    Topo vTopo = topoResource.getTopoById(pTopoId);
                    Statut vStatut = topoResource.getStatutById(2);
                    TopoReservation vTopoReservation = new TopoReservation(vDateReservation, vTopo, vUser, vStatut);
                    //vérifier que la date de réservation est disponible
                    if (rechercheDoublonDate(vDateReservation, pTopoId)) {
                        vMessageAlert = "Le topo " + vTopo.getNom() + " est déjà reservée pour le " + vDate + ".";
                    } else {
                        topoResource.createTopoReservation(vTopoReservation);
                        vMessageSuccess = "La demande de réservation du topo " + vTopo.getNom() + " le " + vDate + " est enregistrée et en attente " +
                                "de confirmation par le propriétaire. Vous pouvez retrouver l'état de la demande et les coordonnées du propriétaire" +
                                " dans votre page personnelle.";
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

    @PostMapping("/updateTopoReservation")
    public void updateTopoReservation (@RequestParam(value = "reservationId") Integer pReservationId,
                                       @RequestParam(value = "action") String pAction,
                                       HttpServletResponse response) throws TechnicalException, IOException {
        logger.debug("Reservation Id = " + pReservationId);
        logger.debug("Action = " + pAction);
        String vMessageError = "";
        TopoReservation vTopoReservation = topoResource.getTopoReservationById(pReservationId);
        switch (pAction) {
            case "accepter" :
                vTopoReservation.setStatut(topoResource.getStatutById(1));
                try {
                    topoResource.updateTopoReservation(vTopoReservation);
                }
                catch (TechnicalException e) {
                    vMessageError = e.getMessage();
                }
                break;
            case "refuser" :
                vTopoReservation.setStatut(topoResource.getStatutById(3));
                try {
                    topoResource.updateTopoReservation(vTopoReservation);
                }
                catch (TechnicalException e) {
                    vMessageError = e.getMessage();
                }
                break;
        }
        // Creation de la réponse en JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String vJSONCommentaire = new Gson().toJson("done");
        logger.debug("vJSONCommentaire = " + vJSONCommentaire);
        response.getWriter().write(vJSONCommentaire);
    }

    @PostMapping("/annulerReservation")
    public ModelAndView annulerReservation (@RequestParam(value = "reservation-id") Integer pReservationId,
                                            @RequestParam(value = "username") String pUsername) throws TechnicalException {
        TopoReservation vTopoReservation = topoResource.getTopoReservationById(pReservationId);
        vTopoReservation.setStatut(topoResource.getStatutById(3));
        topoResource.updateTopoReservation(vTopoReservation);
        return accueilController.showPagePerso(pUsername);
    }
}
