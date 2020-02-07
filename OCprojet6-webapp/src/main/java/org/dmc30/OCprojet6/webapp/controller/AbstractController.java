package org.dmc30.OCprojet6.webapp.controller;

import org.dmc30.OCprojet6.model.bean.*;
import org.dmc30.OCprojet6.webapp.resource.AllCaracteristiqueResource;
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
    @Inject
    AllCaracteristiqueResource allCaracteristiqueResource;

    protected void afficherListe(Model pModel) {
        List<Site> vListSites = siteResource.getListSites();
        pModel.addAttribute("sites", vListSites);
        List<Region> vListRegions = geographicResource.getListRegions();
        pModel.addAttribute("regions", vListRegions);
        List<Departement> vListDepartements = geographicResource.getListDepartements();
        pModel.addAttribute("departements", vListDepartements);
        List<Ville> vListVilles = geographicResource.getListVilles();
        pModel.addAttribute("villes", vListVilles);
        List<TypeRoche> vListTypeRoches = allCaracteristiqueResource.getListTypeRoche();
        pModel.addAttribute("typeRoche", vListTypeRoches);
    }
}
