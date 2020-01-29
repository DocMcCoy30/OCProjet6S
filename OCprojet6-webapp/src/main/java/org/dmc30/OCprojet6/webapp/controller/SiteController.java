package org.dmc30.OCprojet6.webapp.controller;

import org.dmc30.OCprojet6.model.bean.Description;
import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.webapp.resource.DescriptionResource;
import org.dmc30.OCprojet6.webapp.resource.SecteurResource;
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
public class SiteController extends AbstractController {

    @Inject
    SiteResource siteResource;
    @Inject
    SecteurResource secteurResource;

    @PostMapping("/searchSites")
    public ModelAndView searchSites(Model pModel,
                                    @RequestParam(value = "site", required = false) Integer pSiteId,
                                    @RequestParam(value = "region", required = false) Integer pRegionId,
                                    @RequestParam(value = "departement", required = false) Integer pDepartementCode,
                                    @RequestParam(value = "ville", required = false) Integer pVilleId) {
        ModelAndView vMaV = new ModelAndView();
        List<Site> vListSite = new ArrayList<>();
        Site vSite;
        if (pVilleId != null) {
            vListSite = siteResource.getSitesByVille(pVilleId);
        } else if (pDepartementCode != null) {
            vListSite = siteResource.getSitesByDepartement(pDepartementCode);
        } else if (pRegionId != null) {
            vListSite = siteResource.getSitesByRegion(pRegionId);
        } else if (pSiteId != null) {
            vListSite.add(siteResource.getSiteById(pSiteId));
        }
        vMaV.addObject("listSites", vListSite);
        vMaV.setViewName("accueil");
        afficherListe(pModel);
        return vMaV;
    }


//    @PostMapping("/searchSites")
//    public ModelAndView searchSites(Model pModel,
//                                    @RequestParam(value = "site", required = false) Integer pSiteId,
//                                    @RequestParam(value = "region", required = false) Integer pRegionId,
//                                    @RequestParam(value = "departement", required = false) Integer pDepartementCode,
//                                    @RequestParam(value = "ville", required = false) Integer pVilleId) {
//        ModelAndView vMaV = new ModelAndView();
//        List<Site> vListSite = null;
//        //DEBUG
//        System.out.println("VilleId = " + pVilleId);
//        System.out.println("DepartementCode = " + pDepartementCode);
//        System.out.println("RegionId = " + pRegionId);
//        System.out.println("SiteId = " + pSiteId);
//        vListSite = siteResource.searchSites(pSiteId, pRegionId, pDepartementCode, pVilleId);
//
//        if (vListSite.size() == 0) {
//            //DEBUG
//            System.out.println("liste = 0");
//            vMaV.addObject("message", "Aucun site ne correspond à vos critères de recherche !");
//        } else {
//            //DEBUG
//            System.out.println("liste > 0");
//            vMaV.addObject("listeSitesSearchResult", vListSite);
//        }
//
//        vMaV.setViewName("accueil");
//        afficherListe(pModel);
//        return vMaV;
//    }

    @GetMapping("/showCreationSiteForm")
    public String showCreationSiteForm(Model model) {
        afficherListe(model);
        return "formulaire-creation-site";
    }

    @PostMapping("/creationSite")
    public ModelAndView createSite(Model pModel,
                                   @RequestParam(value = "nom", required = false) String pNomSite,
                                   @RequestParam(value = "description", required = false) String pDescription,
                                   @RequestParam(value = "ville", required = false) String pNomVille,
                                   @RequestParam(value = "region", required = false) Integer pRegionId,
                                   @RequestParam(value = "departement", required = false) Integer pDepartementCode,
                                   @RequestParam(value = "typeRoche", required = false) Integer pTypeRocheId) {

        Site vNewSite = null;
        List<Site> vListSites = new ArrayList<>();
        ModelAndView vMaV = new ModelAndView();
        try {
            vNewSite = siteResource.createSite(pNomSite, pDescription, pNomVille, pRegionId, pDepartementCode, pTypeRocheId);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            String vMessageCreationSite = "Le nouveau site " + pNomSite + " est créé !";
            // debug
            vNewSite.setId(siteResource.getLastId());
            vListSites.add(vNewSite);
            vMaV.addObject("messageCreationSite", vMessageCreationSite);
            vMaV.addObject("listSites", vListSites);
            vMaV.setViewName("accueil");
            afficherListe(pModel);
        }
        return vMaV;
    }

    @GetMapping("/showSitePage")
    public ModelAndView showSitePage(@RequestParam("siteId") int pSiteId) {
        ModelAndView vMaV = new ModelAndView();
        Site vSite = siteResource.getSiteById(pSiteId);
        List<Secteur> vListSecteurs = secteurResource.getSecteursBySiteId(pSiteId);
        vMaV.addObject("listSecteurs", vListSecteurs);
        vMaV.addObject("site", vSite);
        vMaV.setViewName("sites");
        return vMaV;
    }

}
