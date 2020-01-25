package org.dmc30.OCprojet6.webapp.controller;

import org.dmc30.OCprojet6.model.bean.Departement;
import org.dmc30.OCprojet6.model.bean.Region;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.bean.Ville;
import org.dmc30.OCprojet6.webapp.resource.GeographicResource;
import org.dmc30.OCprojet6.webapp.resource.SiteResource;
import org.springframework.ui.Model;

import javax.inject.Inject;
import java.util.List;

public class AbstractController {

    @Inject
    SiteResource siteResource;
    @Inject
    GeographicResource geographicResource;

    protected void afficherListeCommune(Model model) {
        List<Site> vListSites = siteResource.getListSites();
        model.addAttribute("sites", vListSites);
        List<Region> vListRegions = geographicResource.getListRegions();
        model.addAttribute("regions", vListRegions);
        List<Departement> vListDepartements = geographicResource.getListDepartements();
        model.addAttribute("departements", vListDepartements);
        List<Ville> vListVilles = geographicResource.getListVilles();
        model.addAttribute("villes", vListVilles);
    }
}
