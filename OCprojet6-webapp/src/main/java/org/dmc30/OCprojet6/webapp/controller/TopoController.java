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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public ModelAndView showTopoPage(@RequestParam(value = "siteId") Integer pSiteId) {
        ModelAndView vMaV = new ModelAndView();
        //récupérer le site
        Site vSite = siteResource.getSiteById(pSiteId);
        //récupérer les topos pour le site concerné
        List<Topo> vListTopo = topoResource.getTopoBySiteId(pSiteId);
        //récupérer les réservations pour les topos
        for (Topo vTopo:vListTopo
             ) {
            List<TopoReservation> vListReservations = topoResource.getTopoReservationsByTopoId(vTopo.getId());
            vTopo.setListReservations(vListReservations);
            logger.debug(vListReservations.get(0).getDateReservation());
            for (TopoReservation vReservation:vListReservations
                 ) {
                logger.debug(vReservation.getDateReservation());
            }
        }

        vMaV.addObject("topos", vListTopo);
        vMaV.addObject("site", vSite);
        vMaV.setViewName("topos");
        return vMaV;
    }

    @PostMapping("/createTopo")
    public ModelAndView createTopo(@RequestParam(value = "siteId") Integer pSiteId,
                                   @RequestParam(value = "topoNom") String vTopoNom,
                                   @RequestParam(value = "dateParution") String vDateParution,
                                   @RequestParam(value = "username") String pUsername) throws TechnicalException {
        ModelAndView vMaV = new ModelAndView();
        String vMessage = "";
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
            vMessage = "Le topo " + vTopoNom + " a été ajouté.";
        } catch (TechnicalException e) {
            vMessage = e.getMessage();
        }
        List<Topo> vListTopo = topoResource.getTopoBySiteId(pSiteId);
        vMaV.addObject("topos", vListTopo);
        vMaV.addObject("site", vSite);
        vMaV.addObject("message", vMessage);
        vMaV.setViewName("topos");
        return vMaV;
    }

    @PostMapping("/reserveTopo")
    public ModelAndView reserveTopo(@RequestParam(value = "siteId") Integer pSiteId,
                                    @RequestParam(value = "topoId") Integer vTopoId,
                                    @RequestParam(value = "dateReservation") String vDateReservation,
                                    @RequestParam(value = "username") String pUsername) throws TechnicalException {

        ModelAndView vMaV = new ModelAndView();
        Topo vTopo = new Topo();
        Users vUser = new Users();
        Site vSite = new Site();
        List<Topo> vListTopo = new ArrayList<>();
        String vMessage = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date vDate = null;

        try {
            vDate = formatter.parse(vDateReservation);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            //récupérer le site
            vSite = siteResource.getSiteById(pSiteId);
            //récupérer les topos pour le site concerné
            vListTopo = topoResource.getTopoBySiteId(pSiteId);
            vUser = authenticationResource.getUserByName(pUsername);
            vTopo = topoResource.getTopoById(vTopoId);
            TopoReservation vTopoReservation = new TopoReservation(vDate, vTopo, vUser);
            topoResource.createTopoReservation(vTopoReservation);
            vMessage = "Le topo est réservé le " + vDateReservation + " par " + pUsername + ".";
        } catch (TechnicalException e) {
            vMessage = e.getMessage();
        }

        vMaV.addObject("topos", vListTopo);
        vMaV.addObject("site", vSite);
        vMaV.addObject("message", vMessage);
        vMaV.setViewName("topos");
        return vMaV;
    }
}
