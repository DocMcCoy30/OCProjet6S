package org.dmc30.OCprojet6.webapp.controller;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.*;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.dmc30.OCprojet6.webapp.resource.PhotoResource;
import org.dmc30.OCprojet6.webapp.resource.SiteResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SiteController extends AbstractController {

    @Inject
    SiteResource siteResource;
    @Inject
    PhotoResource photoResource;

    final Logger logger = LogManager.getLogger(SiteController.class);


    /**
     * Affiche le site selectionné dans la page site.
     *
     * @param pSiteId L'identifiant du site selectionné.
     * @return Le ModelAndView : les données du site selectionné dans Model, la page site dans View.
     */
    @GetMapping("/showSitePage")
    public ModelAndView showSitePage(@RequestParam("siteId") int pSiteId,
                                     String pMessage) {
        ModelAndView vMaV = new ModelAndView();
        List<Photo> vListPhotos;
        String vMessage;

        if (pMessage == null) {
            vMessage = "";
        } else {
            vMessage = pMessage;
        }
        // création du site à retourner
        Site vSite = siteResource.getSiteById(pSiteId);
        // création de la liste de photo correspondantes au site ou logo si absence de photo
        if (!(photoResource.getPhotoByRefId(pSiteId, "site")).isEmpty()) {
            vListPhotos = photoResource.getPhotoByRefId(pSiteId, "site");
            vSite.setListPhotos(vListPhotos);
        } else {
            vListPhotos = photoResource.getPhotoByRefId(0, "logo");
            vSite.setListPhotos(vListPhotos);
            logger.debug("Logo = " + vListPhotos.get(0).getNom());
        }

        vMaV.addObject("site", vSite);
        vMaV.addObject("message", vMessage);
        vMaV.setViewName("sites");
        return vMaV;
    }


    /**
     * Afficher le formulaire de création de site.
     *
     * @param pModel Les données de listes déroulantes.
     * @return La page de création de site.
     */
    @GetMapping("/showSiteForm")
    public ModelAndView showSiteForm(Model pModel,
                                     @RequestParam(value = "siteId", required = false) Integer pSiteId) {
        ModelAndView vMaV = new ModelAndView();
        if (pSiteId != null) {
            Site vSite = siteResource.getSiteById(pSiteId);
            vMaV.addObject("site", vSite);
        }
        vMaV.setViewName("formulaire-creation-site");
        afficherListe(pModel);
        return vMaV;
    }

    /**
     * Crée ou modifie un site dans la base de données et l'affiche dans la page site.
     *
     * @param pModel           Les données des listes déroulantes à renvoyer à la page.
     * @param pNomSite         Le nom du nouveau site.
     * @param pDescription     La description du nouveau site.
     * @param pNomVille        Le nom de la ville du nouveau site.
     * @param pRegionId        L'identifiant de la région du nouveau site.
     * @param pDepartementCode Le code du département du nouveau site.
     * @param pTypeRocheId     L'identifiant du type de roche du nouveau site.
     * @return Le ModelAndView : les données du nouveau site + les données des listes déroulantes dans Model,
     * la page de recherche dans View.
     */
    @PostMapping("/createUpdateSite")
    public ModelAndView createUpdateSite(Model pModel,
                                         @RequestParam(value = "nom", required = false) String pNomSite,
                                         @RequestParam(value = "description", required = false) String pDescription,
                                         @RequestParam(value = "ville", required = false) String pNomVille,
                                         @RequestParam(value = "region", required = false) Integer pRegionId,
                                         @RequestParam(value = "departement", required = false) Integer pDepartementCode,
                                         @RequestParam(value = "typeRoche", required = false) Integer pTypeRocheId,
                                         @RequestParam(value = "siteId", required = false) Integer pSiteId,
                                         @RequestParam(value = "descriptionId", required = false) Integer pDescriptionId,
                                         @RequestParam(value = "action") String pAction) throws TechnicalException {

        String vMessage = "";
        int vSiteId = 0;

        //construction de l'objet site
        Site vSite = setSiteCommonsAttributes(pNomSite, pNomVille, pRegionId, pDepartementCode, pTypeRocheId);
        //fixation de l'id
        if (pSiteId != null) {
            vSite.setId(pSiteId);
        }
        //fixation de la description
        Description vNewDescription = new Description();
        if (pDescriptionId != null) {
            vNewDescription.setId(pDescriptionId);
        }
        if (pDescription.isEmpty()) {
            pDescription = "Ajouter une description pour ce site.";
        }
        vNewDescription.setDescription(pDescription);
        String vInfo = pNomSite + " est un site d'escalade de type " + vSite.getTypeRoche().getNom() + ", situé à " + pNomSite +
                ", dans le département " + vSite.getDepartement().getNom() + " (" + vSite.getRegion().getNom() + ").";
        vNewDescription.setInfo(vInfo);
        vSite.setDescription(vNewDescription);
        //création ou modification du site
        try {
            switch (pAction) {
                case "update":
                    vSite = siteResource.updateSite(vSite);
                    vMessage = "Le site " + pNomSite + " a été modifié.";
                    break;
                case "create":
                    vSite = siteResource.createSite(vSite);
                    vSiteId = siteResource.getLastId();
                    vSite.setId(vSiteId);
                    vMessage = "Le nouveau site " + pNomSite + " a été créé !";
                    break;
            }
        } catch (TechnicalException e) {
            vMessage = e.getMessage();
        }
        return showSitePage(vSite.getId(), vMessage);
    }

    /**
     * Alimente la liste des départements en fonction de la région choisie dans le formulaire de création de sites.
     *
     * @param pId      L'identifiant de la région selectionnée.
     * @param response La réponse envoyée sous forme d'objet JSON.
     * @throws IOException
     */
    @GetMapping("/autoPopulateDepartements")
    public void autoPopulate(@RequestParam(value = "region") int pId,
                             HttpServletResponse response) throws IOException {
        List<Departement> vListDepartement = geographicResource.getDepartementsByRegion(pId);
        // Creation de la liste de noms correspondants à la recherche en format JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String vJSONSearchResult = new Gson().toJson(vListDepartement);
        logger.debug("JSON searchList = " + vJSONSearchResult);
        response.getWriter().write(vJSONSearchResult);

    }

    @PostMapping("/rendreOfficiel")
    public void rendreOfficiel(@RequestParam(value = "siteId") Integer pSiteId,
                                       @RequestParam(value = "checked") Boolean pChecked,
                                       HttpServletResponse response) throws TechnicalException, IOException {
        ModelAndView vMav = new ModelAndView();
        logger.debug(pSiteId);
        Site vSite = siteResource.getSiteById(pSiteId);
        logger.debug(pChecked);
        if (pChecked) {
            vSite.setOfficiel(true);
        } else if (!pChecked){
            vSite.setOfficiel(false);
        }
        vSite = siteResource.updateSite(vSite);
        // Creation de la réponse en JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String vJSONSite = new Gson().toJson(vSite);
        logger.debug("vJSONSite = " + vJSONSite);
        response.getWriter().write(vJSONSite);
    }

    /**
     * Fixe les attributs d'un objet Site pour création ou modification.
     *
     * @param pNomSite         Le nom du Site.
     * @param pNomVille        Le nom de la ville.
     * @param pRegionId        L'identifiant de la région.
     * @param pDepartementCode Le code du département.
     * @param pTypeRocheId     Le type de roche.
     */
    private Site setSiteCommonsAttributes(String pNomSite, String pNomVille, Integer pRegionId, Integer pDepartementCode, Integer pTypeRocheId) {
        Site vSite = new Site();
        //fixation de l'attribut nom
        vSite.setNom(pNomSite);
        //recuperation de la Region et fixation de l'attribut
        Region vRegion = geographicResource.getRegionById(pRegionId);
        vSite.setRegion(vRegion);
        //recuperation du Departement et fixation de l'attribut
        Departement vDepartement = geographicResource.getDepartementByCode(pDepartementCode);
        vSite.setDepartement(vDepartement);
        //fixation de l'attribut ville
        Ville vVille = new Ville();
        vVille.setNom(pNomVille);
        vVille.setDepartement(vDepartement);
        //fixation de l'attribut ville
        vSite.setVille(vVille);
        //recuperation du TypeRoche et fixation de l'attribut
        TypeRoche vTypeRoche = allCaracteristiqueResource.getTypeRocheById(pTypeRocheId);
        vSite.setTypeRoche(vTypeRoche);
        //fixation de l'attribut officiel
        vSite.setOfficiel(false);

        return vSite;
    }

    /**
     * Recherche de sites multicritères dynamique (listes déroulantes de choix interdépendantes).
     *
     * @param pModel           Les données à renvoyer pour alimenter les listes déroulantes.
     * @param pOptionRef       L'option de recherche selectionnée (javascript : onchange).
     * @param pSiteId          L'identifiant du site selectionné.
     * @param pRegionId        L'identifiant de la région selectionnée.
     * @param pDepartementCode Le code du département selectionné.
     * @param pVilleId         L'identifiant de la ville selectionnée.
     * @return La liste des sites visés par la recherche et la vue.
     */
    @PostMapping("/searchSites")
    public ModelAndView searchSites(Model pModel,
                                    @RequestParam(value = "optionRef", required = false) Integer pOptionRef,
                                    @RequestParam(value = "site", required = false) Integer pSiteId,
                                    @RequestParam(value = "region", required = false) Integer pRegionId,
                                    @RequestParam(value = "departement", required = false) Integer pDepartementCode,
                                    @RequestParam(value = "ville", required = false) Integer pVilleId) {
        ModelAndView vMaV = new ModelAndView();
        List<Site> vListSites = new ArrayList<>();
        List<Region> vListRegions = new ArrayList<>();
        List<Departement> vListDepartements = new ArrayList<>();
        List<Ville> vListVilles = new ArrayList<>();
        List<Photo> vListPhotos = new ArrayList<>();
        String vInfoDeRecherche = "";

        //option de recherche par nom de site
        if ((pOptionRef != null) && (pOptionRef == 1)) {
            //renvoyer le site selectionné à la jsp
            Site vSite = siteResource.getSiteById(pSiteId);
            vListSites.add(siteResource.getSiteById(pSiteId));
            //renvoyer les infos de recherche
            vInfoDeRecherche = "Site recherché : " + vSite.getNom() + ".";

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
            //Dans ce cas, renvoie de toutes les données pour les listes déroulantes
            afficherListe(pModel);
            vMaV.setViewName("recherche-site");
        }
        //option de recherche par région
        //dans ce cas, on renvoie les données correspondantes à la région choisie (sites, départements, villes) + toutes les régions
        else if ((pOptionRef != null) && (pOptionRef == 2)) {
            //renvoyer la region selectionnée à la jsp
//            vListRegions.add(geographicResource.getRegionById(pRegionId));
//            pModel.addAttribute("regions", vListRegions);
            //renvoyer toutes les régions
            vListRegions = geographicResource.getListRegions();
            pModel.addAttribute("regions", vListRegions);
            //renvoyer la liste des departements correspondants à la région choisie à la jsp
            vListDepartements = geographicResource.getDepartementsByRegion(pRegionId);
            pModel.addAttribute("departements", vListDepartements);
            //renvoyer la liste des villes correspondantes à la région choisie à la jsp
            for (Departement vDepartement : vListDepartements
            ) {
                vListVilles.addAll(geographicResource.getVillesByDepartement(vDepartement.getCode()));
            }
            pModel.addAttribute("villes", vListVilles);
            //renvoyer la liste de sites correspondants à la région choisie à la jsp
            vListSites = siteResource.getSitesByRegion(pRegionId);
            pModel.addAttribute("sites", vListSites);
            //renvoyer les infos de recherche
            vInfoDeRecherche = "Région recherchée : " + geographicResource.getRegionById(pRegionId).getNom() + ".";
            //renvoyer la jsp
            vMaV.setViewName("recherche-site");
        }
        //option de recherche par département
        //dans ce cas, on renvoie toutes les régions et tous les départements + la listes des villes et sites correspondants au département choisi
        else if (((pOptionRef != null) && (pOptionRef == 3))) {
            //renvoyer la region correspondant au département à la jsp
//            Departement vDepartement = geographicResource.getDepartementByCode(pDepartementCode);
//            logger.debug("Departement choisi = "+vDepartement.getNom());
//            Region vRegion = geographicResource.getRegionById(vDepartement.getRegion().getId());
//            logger.debug("Région correspondante = "+vRegion.getNom());
//            vListRegions.add(vRegion);
//            logger.debug("Taille de la liste des régions pour le département "+vDepartement.getNom()+" = "+vListRegions.size());
//            pModel.addAttribute("regions", vListRegions);
            //renvoyer toutes les régions
            vListRegions = geographicResource.getListRegions();
            pModel.addAttribute("regions", vListRegions);
            //renvoyer le departement selectionné à la jsp
//            vListDepartements.add(geographicResource.getDepartementByCode(pDepartementCode));
//            pModel.addAttribute("departements", vListDepartements);
            //renvoyer tous les département
            vListDepartements = geographicResource.getListDepartements();
            pModel.addAttribute("departements", vListDepartements);
            //renvoyer la liste de sites correspondant au département choisi à la jsp
            vListSites = siteResource.getSitesByDepartement(pDepartementCode);
            logger.debug("Taille de la liste des sites pour le département " + geographicResource.getDepartementByCode(pDepartementCode).getNom() + " = " + vListSites.size());
            pModel.addAttribute("sites", vListSites);
            //renvoyer la liste des villes correspondantes au département choisie
            vListVilles = geographicResource.getVillesByDepartement(pDepartementCode);
            pModel.addAttribute("villes", vListVilles);
            //renvoyer les infos de recherche
            vInfoDeRecherche = "Département recherché : " + geographicResource.getDepartementByCode(pDepartementCode).getNom() + ".";
            //renvoyer la jsp
            vMaV.setViewName("recherche-site");
        }
        //option de recherche par ville
        //dans ce cas, on renvoie la liste des sites correspondants à la ville + toutes les régions, département, villes
        else if (((pOptionRef != null) && (pOptionRef == 4))) {
            //renvoyer la liste de sites correspondants à la ville choisie à la jsp
            vListSites = (siteResource.getSitesByVille(pVilleId));
            pModel.addAttribute("sites", vListSites);
            //renvoyer la région correspondante à la ville choisie à la jsp
//            Ville vVille = geographicResource.getVilleById(pVilleId);
//            Departement vDepartement = geographicResource.getDepartementByCode(vVille.getDepartement().getCode());
//            Region vRegion = geographicResource.getRegionById(vDepartement.getRegion().getId());
//            vListRegions.add(vRegion);
//            pModel.addAttribute("regions", vListRegions);
            //renvoyer toutes les régions
            vListRegions = geographicResource.getListRegions();
            pModel.addAttribute("regions", vListRegions);
            //renvoyer le departement correspondant à la ville choisie à la jsp
//            vListDepartements.add(geographicResource.getDepartementByCode(geographicResource.getVilleById(pVilleId).getDepartement().getCode()));
//            pModel.addAttribute("departements", vListDepartements);
            //renvoyer tous les départements
            vListDepartements = geographicResource.getListDepartements();
            pModel.addAttribute("departements", vListDepartements);
            //renvoyer la ville choisie à la jsp
//            vListVilles.add(geographicResource.getVilleById(pVilleId));
//            pModel.addAttribute("villes", vListVilles);
            //renvoyer toutes les villes
            vListVilles = geographicResource.getListVilles();
            pModel.addAttribute("villes", vListVilles);
            //renvoyer les infos de recherche
            vInfoDeRecherche = "Ville recherchée : " + geographicResource.getVilleById(pVilleId).getNom() + ".";
            //renvoyer la jsp
            vMaV.setViewName("recherche-site");
        }

        // création de la liste des photos correspondantes aux sites recherchés
        for (Site vSite : vListSites) {
            logger.info(vSite.getNom() + vSite.getId());
            vListPhotos = photoResource.getPhotoByRefId(vSite.getId(), "site");
            if (!vListPhotos.isEmpty()) {
                logger.info("La liste de photos pour " + vSite.getNom() + " contient " + vListPhotos.size() + " photos");
                vSite.setListPhotos(vListPhotos);
            } else {
                vListPhotos = photoResource.getPhotoByRefId(0, "logo");
                logger.info("La liste de photo pour " + vSite.getNom() + " est vide");
                vSite.setListPhotos(vListPhotos);
            }
        }
        vMaV.addObject("listSites", vListSites);
        vMaV.addObject("messageInfoRecherche", vInfoDeRecherche);
        return vMaV;
    }
}
