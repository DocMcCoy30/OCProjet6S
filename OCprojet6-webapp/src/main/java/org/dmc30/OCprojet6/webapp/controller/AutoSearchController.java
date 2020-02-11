package org.dmc30.OCprojet6.webapp.controller;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.*;
import org.dmc30.OCprojet6.webapp.resource.GeographicResource;
import org.dmc30.OCprojet6.webapp.resource.PhotoResource;
import org.dmc30.OCprojet6.webapp.resource.SiteResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AutoSearchController extends AbstractController {

    Logger logger = LogManager.getLogger(AutoSearchController.class);

    @Inject
    SiteResource siteResource;
    @Inject
    GeographicResource geographicResource;
    @Inject
    PhotoResource photoResource;

    @GetMapping("/AutocompleteController")
    public void autocompleteTheSearchInput(@RequestParam(value = "term") String pMotCle,
                                           HttpServletResponse response) throws IOException {

        List<String> vListSearchResult = new ArrayList<>();
        logger.debug("le Term est = " + pMotCle);

        //Liste des sites correspondant à la recherche
        List<Site> vListSites = siteResource.getMatchingSites(pMotCle);
        for (Site vSite : vListSites
        ) {
            String vNomSite = vSite.getNom();
            logger.debug("Noms des sites : " + vNomSite);
            vListSearchResult.add(vNomSite);
            logger.debug("Liste des sites correspondants au mot clé = " + vSite.getNom());
        }

        //Liste des regions correspondant à la recherche
        List<Region> vListRegions = geographicResource.getMatchingRegions(pMotCle);
        for (Region vRegion : vListRegions
        ) {
            String vNomRegion = vRegion.getNom();
            vListSearchResult.add(vNomRegion);
        }

        //Liste des departements correspondant à la recherche
        List<Departement> vListDepartements = geographicResource.getMatchingDepartements(pMotCle);
        for (Departement vDepartement : vListDepartements
        ) {
            String vNomDepartement = vDepartement.getNom();
            vListSearchResult.add(vNomDepartement);
        }

        //Liste des departements correspondant à la recherche
        List<Ville> vListVilles = geographicResource.getMatchingVilles(pMotCle);
        for (Ville vVille : vListVilles
        ) {
            String vNomVille = vVille.getNom();
            vListSearchResult.add(vNomVille);
        }

        // Creation de la liste de noms correspondants à la recherche en format JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String vJSONSearchResult = new Gson().toJson(vListSearchResult);
        logger.debug("JSON searchList = " + vJSONSearchResult);
        response.getWriter().write(vJSONSearchResult);
    }

    @PostMapping("/searchAll")
    public ModelAndView searchAll(Model pModel,
                                  @RequestParam(value = "motCle") String pMotCle) {
        ModelAndView vMaV = new ModelAndView();
        List<Site> vListSitesRecherches = new ArrayList<>();
        List<Site> vListSitesFromRegions = new ArrayList<>();
        List<Site> vListSitesFromDepartements = new ArrayList<>();
        List<Site> vListSitesFromVilles = new ArrayList<>();
        List<Photo> vListPhotos = new ArrayList<>();

        //Liste des sites recherchés
        List<Site> vListSitesFromSites = siteResource.getMatchingSites(pMotCle);
        //Liste des sites de la région recherchée
        logger.debug("Into sites par région");
        List<Region> vListRegions = geographicResource.getMatchingRegions(pMotCle);
        for (Region vRegion : vListRegions
        ) {
            int vRegionId = vRegion.getId();
            vListSitesFromRegions = siteResource.getSitesByRegion(vRegionId);
        }
        //Liste des sites du département recherché
        logger.debug("Into sites par département");
        List<Departement> vListDepartements = geographicResource.getMatchingDepartements(pMotCle);
        for (Departement vDepartement : vListDepartements
        ) {
            int vDepartementCode = vDepartement.getCode();
            vListSitesFromDepartements = siteResource.getSitesByDepartement(vDepartementCode);
        }
        //Liste des sites de la ville recherchée
        logger.debug("Into sites par ville");
        List<Ville> vListVilles = geographicResource.getMatchingVilles(pMotCle);
        for (Ville vVille : vListVilles
        ) {
            int vVilleId = vVille.getId();
            vListSitesFromVilles = siteResource.getSitesByRegion(vVilleId);
        }
        //ajout des listes de sites à la liste de recherhce
        vListSitesRecherches.addAll(vListSitesFromSites);
        vListSitesRecherches.addAll(vListSitesFromRegions);
        vListSitesRecherches.addAll(vListSitesFromDepartements);
        vListSitesRecherches.addAll(vListSitesFromVilles);
        // création de la liste des photos correspondantes aux sites recherchés
        for (Site vSite : vListSitesRecherches) {
            vListPhotos = photoResource.getPhotoByRefId(vSite.getId(), "site");
            if (!vListPhotos.isEmpty()) {
                vSite.setListPhotos(vListPhotos);
            }
        }
        //envoie de la liste du résultat de la recherche à la jsp
        vMaV.addObject("listSites", vListSitesRecherches);
        vMaV.setViewName("recherche-site");
        afficherListe(pModel);
        return vMaV;
    }
}
