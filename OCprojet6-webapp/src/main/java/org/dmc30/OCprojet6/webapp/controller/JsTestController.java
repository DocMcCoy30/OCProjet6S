package org.dmc30.OCprojet6.webapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.Departement;
import org.dmc30.OCprojet6.model.bean.Region;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.webapp.resource.PhotoResource;
import org.dmc30.OCprojet6.webapp.resource.SiteResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Controller
public class JsTestController extends AbstractController {

    @Inject
    SiteResource siteResource;
    @Inject
    PhotoResource photoResource;

    final Logger logger = LogManager.getLogger(SiteController.class);

    @GetMapping("/jsTestPage")
    public ModelAndView jsTestPage(Model pModel) {
        ModelAndView vMav = new ModelAndView();
        afficherListe(pModel);
        return vMav;
    }

    @PostMapping("/searchSites")
    public ModelAndView searchSites(Model pModel,
                                    @RequestParam(value = "site", required = false) Integer pSiteId,
                                    @RequestParam(value = "optionRef", required = false) Integer pOptionRef,
                                    @RequestParam(value = "region", required = false) Integer pRegionId,
                                    @RequestParam(value = "departement", required = false) Integer pDepartementCode,
                                    @RequestParam(value = "ville", required = false) Integer pVilleId) {
        ModelAndView vMaV = new ModelAndView();
        List<Site> vListSites = new ArrayList<>();
        List<Region> vListRegions = new ArrayList<>();
        List<Departement> vListDepartements = new ArrayList<>();

        //option de recherche par nom de site
        if ((pOptionRef != null) && (pOptionRef == 1)) {

        }

            //option de recherche par région
        else if ((pOptionRef != null) && (pOptionRef == 2)) {
            //renvoyer la region selectionnée à la jsp
            vListRegions.add(geographicResource.getRegionById(pRegionId));
            pModel.addAttribute("regions", vListRegions);
            //renvoyer la liste des departements correspondants à la région à la jsp
            vListDepartements = geographicResource.getDepartementsByRegion(pRegionId);
            pModel.addAttribute("departements", vListDepartements);
            //renvoyer la liste de sites correspondants à la région choisie à la jsp
            vListSites = siteResource.getSitesByRegion(pRegionId);
            vMaV.addObject("listSites", vListSites);
            //renvoyer la jsp
            vMaV.setViewName("recherche-site");
        }
            //option de recherche par département
        else if (((pOptionRef != null) && (pOptionRef == 3))) {
            //renvoyer la region correspondant au département à la jsp
            Region vRegion = geographicResource.getRegionById(geographicResource.getDepartementByCode(pDepartementCode).getRegion().getId());
            vListRegions.add(vRegion);
            pModel.addAttribute("regions", vRegion);
            //renvoyer le departement selectionné à la jsp
            vListDepartements.add(geographicResource.getDepartementByCode(pDepartementCode));
            pModel.addAttribute("departements", vListDepartements);
            //renvoyer la liste de sites correspondant au département choisi à la jsp
            vListSites = siteResource.getSitesByDepartement(pDepartementCode);
            vMaV.addObject("listSites", vListSites);
            vMaV.setViewName("recherche-site");
        }

            //option de recherche par ville
        else if (((pOptionRef != null) && (pOptionRef == 4))) {

        }
        return vMaV;
    }
}




