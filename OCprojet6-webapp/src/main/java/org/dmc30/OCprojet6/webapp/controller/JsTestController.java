package org.dmc30.OCprojet6.webapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.*;
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

//    /**
//     * recherche de sites multicritère dynamique
//     * @param pModel le modèle à renvoyer pour alimenter les listes déroulantes
//     * @param pOptionRef l'option de recherche selectionnée (javascript : onchange)
//     * @param pSiteId l'identifiant du site selectionné
//     * @param pRegionId l'identifiant de la région selectionnée
//     * @param pDepartementCode le code du département selectionné
//     * @param pVilleId l'identifiant de la ville selectionnée
//     * @return
//     */
//    @PostMapping("/searchSites")
//    public ModelAndView searchSites(Model pModel,
//                                    @RequestParam(value = "optionRef", required = false) Integer pOptionRef,
//                                    @RequestParam(value = "site", required = false) Integer pSiteId,
//                                    @RequestParam(value = "region", required = false) Integer pRegionId,
//                                    @RequestParam(value = "departement", required = false) Integer pDepartementCode,
//                                    @RequestParam(value = "ville", required = false) Integer pVilleId) {
//        ModelAndView vMaV = new ModelAndView();
//        List<Site> vListSites = new ArrayList<>();
//        List<Region> vListRegions = new ArrayList<>();
//        List<Departement> vListDepartements = new ArrayList<>();
//        List<Ville> vListVilles = new ArrayList<>();
//        List<Photo> vListPhotos = new ArrayList<>();
//
//        //option de recherche par nom de site
//        if ((pOptionRef != null) && (pOptionRef == 1)) {
//            //renvoyer le site selectionné à la jsp
//            Site vSite = siteResource.getSiteById(pSiteId);
//            vListSites.add(siteResource.getSiteById(pSiteId));
//            pModel.addAttribute("sites", vListSites);
//            //renvoyer les données géographique correspondant au site choisi à la jsp
//            //region
//            vListRegions.add(geographicResource.getRegionById(vSite.getRegion().getId()));
//            pModel.addAttribute("regions", vListRegions);
//            //departement
//            vListDepartements.add(geographicResource.getDepartementByCode(vSite.getDepartement().getCode()));
//            pModel.addAttribute("departements", vListDepartements);
//            //ville
//            vListVilles.add(geographicResource.getVilleById(vSite.getVille().getId()));
//            pModel.addAttribute("villes", vListVilles);
//            vMaV.setViewName("recherche-site");
//        }
//        //option de recherche par région
//        else if ((pOptionRef != null) && (pOptionRef == 2)) {
//            //renvoyer la region selectionnée à la jsp
//            vListRegions.add(geographicResource.getRegionById(pRegionId));
//            pModel.addAttribute("regions", vListRegions);
//            //renvoyer la liste des departements correspondants à la région choisie à la jsp
//            vListDepartements = geographicResource.getDepartementsByRegion(pRegionId);
//            pModel.addAttribute("departements", vListDepartements);
//            //renvoyer la liste des villes correspondantes à la région choisie à la jsp
//            for (Departement vDepartement : vListDepartements
//            ) {
//                vListVilles.addAll(geographicResource.getVillesByDepartement(vDepartement.getCode()));
//            }
//            pModel.addAttribute("villes", vListVilles);
//            //renvoyer la liste de sites correspondants à la région choisie à la jsp
//            vListSites = siteResource.getSitesByRegion(pRegionId);
//            pModel.addAttribute("sites", vListSites);
//            //renvoyer la jsp
//            vMaV.setViewName("recherche-site");
//        }
//        //option de recherche par département
//        else if (((pOptionRef != null) && (pOptionRef == 3))) {
//            //renvoyer la region correspondant au département à la jsp
//            Region vRegion = geographicResource.getRegionById(geographicResource.getDepartementByCode(pDepartementCode).getRegion().getId());
//            vListRegions.add(vRegion);
//            pModel.addAttribute("regions", vRegion);
//            //renvoyer le departement selectionné à la jsp
//            vListDepartements.add(geographicResource.getDepartementByCode(pDepartementCode));
//            pModel.addAttribute("departements", vListDepartements);
//            //renvoyer la liste de sites correspondant au département choisi à la jsp
//            vListSites = siteResource.getSitesByDepartement(pDepartementCode);
//            pModel.addAttribute("listSites", vListSites);
//            //renvoyer la jsp
//            vMaV.setViewName("recherche-site");
//        }
//        //option de recherche par ville
//        else if (((pOptionRef != null) && (pOptionRef == 4))) {
//            //renvoyer la liste de sites correspondants à la ville choisie à la jsp
//            vListSites = (siteResource.getSitesByVille(pVilleId));
//            pModel.addAttribute("sites", vListSites);
//            //renvoyer le departement correspondant à la ville choisie à la jsp
//            vListDepartements.add(geographicResource.getDepartementByCode(geographicResource.getVilleById(pVilleId).getDepartement().getCode()));
//            pModel.addAttribute("departements", vListDepartements);
//            //renvoyer la région correspondante à la ville choisie à la jsp
//            Ville vVille = geographicResource.getVilleById(pVilleId);
//            Departement vDepartement = geographicResource.getDepartementByCode(vVille.getDepartement().getCode());
//            Region vRegion = geographicResource.getRegionById(vDepartement.getRegion().getId());
//            vListRegions.add(vRegion);
//            pModel.addAttribute("regions", vListRegions);
//            //renvoyer la ville choisie à la jsp
//            vListVilles.add(geographicResource.getVilleById(pVilleId));
//            pModel.addAttribute("villes", vListVilles);
//            //renvoyer la jsp
//            vMaV.setViewName("recherche-site");
//        }
//
//        // création de la liste des photos correspondantes aux sites recherchés
//        for (Site vSite : vListSites) {
//            logger.info(vSite.getNom() + vSite.getId());
//            vListPhotos = photoResource.getPhotoByRefId(vSite.getId(), "site");
//            if (!vListPhotos.isEmpty()) {
//                logger.info("La liste de photos pour " + vSite.getNom() + " contient " + vListPhotos.size() + " photos");
//                vSite.setListPhotos(vListPhotos);
//            }
//        }
//        vMaV.addObject("listSites", vListSites);
//        return vMaV;
//    }
}




