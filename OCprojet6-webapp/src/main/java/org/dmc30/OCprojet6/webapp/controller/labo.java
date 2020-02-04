package org.dmc30.OCprojet6.webapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class labo {


/*
    @PostMapping("/searchSites")
    public ModelAndView searchSites(Model pModel,
                                    @RequestParam(value = "site", required = false) Integer pSiteId,
                                    @RequestParam(value = "region", required = false) Integer pRegionId,
                                    @RequestParam(value = "departement", required = false) Integer pDepartementCode,
                                    @RequestParam(value = "ville", required = false) Integer pVilleId) {
        ModelAndView vMaV = new ModelAndView();
        List<Site> vListSite = null;
        //DEBUG
        System.out.println("VilleId = " + pVilleId);
        System.out.println("DepartementCode = " + pDepartementCode);
        System.out.println("RegionId = " + pRegionId);
        System.out.println("SiteId = " + pSiteId);
        vListSite = siteResource.searchSites(pSiteId, pRegionId, pDepartementCode, pVilleId);

        if (vListSite.size() == 0) {
            //DEBUG
            System.out.println("liste = 0");
            vMaV.addObject("message", "Aucun site ne correspond à vos critères de recherche !");
        } else {
            //DEBUG
            System.out.println("liste > 0");
            vMaV.addObject("listeSitesSearchResult", vListSite);
        }

        vMaV.setViewName("accueil");
        afficherListe(pModel);
        return vMaV;
    }
    */


        /**
         * Upload une image sur le serveur et la référence dans la base de données
         * @param pNomPhoto : le nom de l'image renseigné dans le formulaire
         * @param pFile : le fichier à uploader
         * @param pSiteId : l'identifiant de site correspondant
         * @return
         */
        /*
    @PostMapping("/uploadFile")
    public ModelAndView uploadFileHandler(@RequestParam("nomPhoto") String pNomPhoto,
                                          @RequestParam("file") MultipartFile pFile,
                                          @RequestParam("siteId") int pSiteId,
                                          HttpServletRequest request) {

        String vNomPhoto = "";
        String vUploadMsg;
        ModelAndView vMaV = new ModelAndView();

        if (!pFile.isEmpty()) {
            try {
                byte[] bytes = pFile.getBytes();

                // Crée le repertoire de stockage des images
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "OCprojet6ImgFiles");

                if (!dir.exists())
                    dir.mkdirs();

                // crée le nom du fichier (avec une référence aléatoire pour diminuer le risque de non concordance entre la BD et le répertoire
                Random rand = new Random();
                int vRandomRef = rand.nextInt(1000000);
                vNomPhoto = pSiteId + vRandomRef + pNomPhoto + "Site" + pSiteId + ".jpeg";
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
        Photo vPhoto = new Photo(vNomPhoto, pSiteId, vSecteurId, vVoieId);
        photoResource.createPhoto(vPhoto);
        Site vSite = siteResource.getSiteById(pSiteId);
        vMaV.addObject("site", vSite);
        vMaV.addObject("uploadMsg", vUploadMsg);
        vMaV.setViewName("sites");
    }
    */

}
