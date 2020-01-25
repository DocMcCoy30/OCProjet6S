package org.dmc30.OCprojet6.webapp.controller;

import org.dmc30.OCprojet6.model.bean.Departement;
import org.dmc30.OCprojet6.model.bean.Region;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.bean.Ville;
import org.dmc30.OCprojet6.webapp.resource.GeographicResource;
import org.dmc30.OCprojet6.webapp.resource.SiteResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping({"/", "/accueil"})
public class AccueilController {

    @Inject
    GeographicResource geographicResource;
    @Inject
    SiteResource siteResource;

    @GetMapping
    public String welcomePage(Model model) {
        List<Site> vListSites = siteResource.getListSites();
        model.addAttribute("sites", vListSites);
        List<Region> vListRegions = geographicResource.getListRegions();
        model.addAttribute("regions", vListRegions);

//        Region vRegion = geographicResource.getRegionById(3);  //DEBUG
//        model.addAttribute("region", vRegion);

        List<Departement> vListDepartements = geographicResource.getListDepartements();
        model.addAttribute("departements", vListDepartements);
        List<Ville> vListVilles = geographicResource.getListVilles();
        model.addAttribute("villes", vListVilles);
        return "accueil";
    }

    @RequestMapping(value = "/searchSites", method = RequestMethod.GET)
    public ModelAndView searchSites (@RequestParam ("sites" ) Site pSite,
                                     @RequestParam ("regions") Region pRegion,
                                     @RequestParam("departements") Departement pDepartement,
                                     @RequestParam("villes") Ville pVille) {
        ModelAndView vModel = new ModelAndView();
        if (pSite != null) {
            siteResource.getSiteById(pSite.getId());
        }

        vModel.setViewName("accueil");
        return vModel;
    }

}

