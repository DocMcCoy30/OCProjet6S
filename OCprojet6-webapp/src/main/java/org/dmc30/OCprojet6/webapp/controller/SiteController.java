package org.dmc30.OCprojet6.webapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.Photo;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.webapp.resource.PhotoResource;
import org.dmc30.OCprojet6.webapp.resource.SiteResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class SiteController extends AbstractController {

    @Inject
    SiteResource siteResource;
    @Inject
    PhotoResource photoResource;

    final Logger logger = LogManager.getLogger(SiteController.class);

    @PostMapping("/searchSites")
    public ModelAndView searchSites(Model pModel,
                                    @RequestParam(value = "site", required = false) Integer pSiteId,
                                    @RequestParam(value = "region", required = false) Integer pRegionId,
                                    @RequestParam(value = "departement", required = false) Integer pDepartementCode,
                                    @RequestParam(value = "ville", required = false) Integer pVilleId) {
        ModelAndView vMaV = new ModelAndView();
        List<Site> vListSites = new ArrayList<>();
        List<Photo> vListPhotos;
        if (pVilleId != null) {
            vListSites = siteResource.getSitesByVille(pVilleId);
        } else if (pDepartementCode != null) {
            vListSites = siteResource.getSitesByDepartement(pDepartementCode);
        } else if (pRegionId != null) {
            vListSites = siteResource.getSitesByRegion(pRegionId);
        } else if (pSiteId != null) {
            vListSites.add(siteResource.getSiteById(pSiteId));
        }
        // création de la liste des photos correspondant aux sites recherchés
        for (Site vSite : vListSites) {
            logger.info(vSite.getNom() + vSite.getId());
            vListPhotos = photoResource.getPhotoByRefId(vSite.getId(), "site");
            if (!vListPhotos.isEmpty()) {
                logger.info("La liste de photos pour " + vSite.getNom() + " contient " + vListPhotos.size() + " photos");
                vSite.setListPhotos(vListPhotos);
            }
        }
            vMaV.addObject("listSites", vListSites);
            vMaV.setViewName("recherche-site");
            afficherListe(pModel);
            return vMaV;
        }



    @GetMapping("/showCreationSiteForm")
    public String showCreationSiteForm(Model pModel) {
        afficherListe(pModel);
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
            vMaV.setViewName("showSearchSitePage");
            afficherListe(pModel);
        }
        return vMaV;
    }

    @GetMapping("/showSitePage")
    public ModelAndView showSitePage(@RequestParam("siteId") int pSiteId) {
        ModelAndView vMaV = new ModelAndView();
        // création du site à retourner
        Site vSite = siteResource.getSiteById(pSiteId);
        // création de la liste de photo correspondantes au site
        if (photoResource.getPhotoByRefId(pSiteId, "site") != null) {
            List<Photo> vListPhotos = photoResource.getPhotoByRefId(pSiteId, "site");
            vMaV.addObject("listPhotos", vListPhotos);
        }
        vMaV.addObject("site", vSite);
        vMaV.setViewName("sites");
        return vMaV;
    }

    /**
     * Upload une image sur le serveur et la référence dans la base de données
     *
     * @param pNomPhoto : le nom de l'image renseigné dans le formulaire
     * @param pFile     : le fichier à uploader
     * @param pSiteId   : l'identifiant de site correspondant
     * @return le ModelAndView
     */
    @PostMapping("/uploadFile")
    public ModelAndView uploadPhoto(@RequestParam("nomPhoto") String pNomPhoto,
                                    @RequestParam("file") MultipartFile pFile,
                                    @RequestParam("siteId") int pSiteId,
                                    HttpServletRequest request) {

        String vRef = "site";
        String vNomPhoto = "";
        String vUploadMsg;
        ModelAndView vMaV = new ModelAndView();

        if (!pFile.isEmpty()) {
            try {
                byte[] bytes = pFile.getBytes();

                // Crée le repertoire de stockage des images
                String rootPath = request.getSession().getServletContext().getRealPath("/");
                File dir = new File(rootPath + File.separator + "resources/img");

                if (!dir.exists())
                    dir.mkdirs();

                // crée le nom du fichier (avec une référence aléatoire pour diminuer
                // le risque de non concordance entre la BD et le répertoire
                Random rand = new Random();
                int vRandomRef = rand.nextInt(1000000);
                vNomPhoto = "Site" + pSiteId + "_" + vRandomRef + "_" + pNomPhoto + ".jpeg";
                // crée le fichier dans le repertoire
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + vNomPhoto);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Repertoire créé = " + serverFile.getAbsolutePath());
                logger.info("Fichier créé = " + vNomPhoto);

                vUploadMsg = "L'image " + pNomPhoto + " a été chargée !";
            } catch (Exception e) {
                vUploadMsg = "Echec du chargement de l'image " + pNomPhoto + " => " + e.getMessage();
            }
        } else {
            vUploadMsg = "Il n'y a pas d'image à charger";
        }

        Photo vPhoto = new Photo(vNomPhoto, vRef, pSiteId);
        photoResource.createPhoto(vPhoto);

//        vMaV = showSitePage(pSiteId);
//        vMaV.addObject("uploadMessage", vUploadMsg);

        // création du site à retourner
        Site vSite = siteResource.getSiteById(pSiteId);
        // création de la liste de photo correspondantes au site
        List<Photo> vListPhotos = photoResource.getPhotoByRefId(vPhoto.getRefId(), vPhoto.getRef());

        vMaV.addObject("site", vSite);
        vMaV.addObject("listPhotos", vListPhotos);
        vMaV.addObject("uploadMsg", vUploadMsg);
        vMaV.setViewName("sites");
        return vMaV;
    }

}
