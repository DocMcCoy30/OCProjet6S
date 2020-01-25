package org.dmc30.OCprojet6.webapp.controller;

import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.webapp.resource.SiteResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class SiteController extends AbstractController{

    @Inject
    SiteResource siteResource;

    @PostMapping("/searchSites")
    public ModelAndView searchSites(Model model,
                                    @RequestParam(value = "site", required = false) Integer pSiteId,
                                    @RequestParam(value = "region", required = false) Integer pRegionId,
                                    @RequestParam(value = "departement", required = false) Integer pDepartementCode,
                                    @RequestParam(value = "ville", required = false) Integer pVilleId) {
        ModelAndView vModel = new ModelAndView();
        List<Site> vListSite = null;
        Site vSite = null;
        //DEBUG
        System.out.println("VilleId = "+pVilleId);
        System.out.println("DepartementCode = "+pDepartementCode);
        System.out.println("RegionId = "+pRegionId);
        System.out.println("SiteId = " +pSiteId);
        if (pVilleId != null) {
            vListSite = siteResource.getSitesByVille(pVilleId);
        } else if (pDepartementCode != null) {
            vListSite = siteResource.getSitesByDepartement(pDepartementCode);
        } else if (pRegionId != null) {
            vListSite = siteResource.getSitesByRegion(pRegionId);
        } else if (pSiteId != null) {
            vSite = siteResource.getSiteById(pSiteId);
        }
        vModel.addObject("siteSearchResult", vSite);
        vModel.addObject("listeSitesSearchResult", vListSite);
        vModel.setViewName("accueil");
        afficherListe(model);
        return vModel;
    }
}
