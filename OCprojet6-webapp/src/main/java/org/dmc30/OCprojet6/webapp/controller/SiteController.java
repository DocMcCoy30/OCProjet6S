package org.dmc30.OCprojet6.webapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.Description;
import org.dmc30.OCprojet6.model.bean.Photo;
import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.webapp.resource.DescriptionResource;
import org.dmc30.OCprojet6.webapp.resource.PhotoResource;
import org.dmc30.OCprojet6.webapp.resource.SecteurResource;
import org.dmc30.OCprojet6.webapp.resource.SiteResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
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
    SecteurResource secteurResource;
    @Inject
    PhotoResource photoResource;

    Logger logger = LogManager.getLogger(SiteController.class);

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
//        List<Secteur> vListSecteurs = secteurResource.getSecteursBySiteId(pSiteId);
//        vMaV.addObject("listSecteurs", vListSecteurs);
        vMaV.addObject("site", vSite);
        vMaV.setViewName("sites");
        return vMaV;
    }

    /**
     * Upload une image sur le serveur et la référence dans la base de données
     * @param pNomPhoto : le nom de l'image renseigné dans le formulaire
     * @param pFile : le fichier à uploader
     * @param pSiteId : l'identifiant de site correspondant
     * @return
     */
    @PostMapping("/uploadFile")
    public ModelAndView uploadFileHandler(@RequestParam("nomPhoto") String pNomPhoto,
                                          @RequestParam("file") MultipartFile pFile,
                                          @RequestParam("siteId") int pSiteId) {

        String vNomPhoto="";
        String vUploadMsg;
        ModelAndView vMaV = new ModelAndView();

        if (!pFile.isEmpty()) {
            try {
                byte[] bytes = pFile.getBytes();

                // Crée le repertoire de stockage des images
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "OCprojet6tmpFiles");

                if (!dir.exists())
                    dir.mkdirs();

                // crée le nom du fichier (avec une référence aléatoire pour diminuer le risque de non concordance entre la BD et le répertoire
                Random rand = new Random();
                int vRandomRef = rand.nextInt(1000000);
                vNomPhoto = pSiteId+vRandomRef+pNomPhoto+"Site"+pSiteId+".jpeg";
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
        int vSecteurId = 0;
        int vVoieId = 0;
        Photo vPhoto = new Photo(vNomPhoto,pSiteId,vSecteurId,vVoieId);
        photoResource.createPhoto(vPhoto);
        Site vSite = siteResource.getSiteById(pSiteId);
        vMaV.addObject("site", vSite);
        vMaV.addObject("uploadMsg", vUploadMsg);
        vMaV.setViewName("sites");

        return vMaV;
    }

}
