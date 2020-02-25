package org.dmc30.OCprojet6.webapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.Cotation;
import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.bean.Voie;
import org.dmc30.OCprojet6.webapp.resource.AllCaracteristiqueResource;
import org.dmc30.OCprojet6.webapp.resource.SecteurResource;
import org.dmc30.OCprojet6.webapp.resource.VoieResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class SecteurController extends AbstractController {

    @Inject
    SecteurResource secteurResource;
    @Inject
    VoieResource voieResource;
    @Inject
    AllCaracteristiqueResource allCaracteristiqueResource;

    Logger logger = LogManager.getLogger(SecteurController.class);


    /**
     * Affiche la page des secteurs correspondants au site selectionné.
     * @param pSiteId L'identifiant du site.
     * @return la liste des secteurs concernés et la vue.
     */
    @GetMapping("/showSecteurPage")
    public ModelAndView showSecteurPage(@RequestParam("siteId") int pSiteId) {
        ModelAndView vMaV = new ModelAndView();
        Site vSite = siteResource.getSiteById(pSiteId);
        List<Secteur> vListSecteurs = secteurResource.getSecteursBySiteId(pSiteId);
        // rechercher le nombre de voies, la hauteur max, les cotations Min et Max pour chaque secteur
        for (Secteur vSecteur:vListSecteurs
             ) {
            if (!(voieResource.getVoiesBySecteurId(vSecteur.getId()).isEmpty())) {
                // hauteur Max
                int vHauteurMax = voieResource.getHauteurMaxBySecteur(vSecteur.getId());
                vSecteur.setHauteurMax(vHauteurMax);
                // Nombre de voies
                int vNbDeVoies = voieResource.getNbDeVoiesBySecteur(vSecteur.getId());
                vSecteur.setNbDeVoies(vNbDeVoies);
                // Cotation MinMax
                int[] vCotationIdMinMax = voieResource.getCotationMinMaxBySecteur(vSecteur.getId());
                String vCotationMin = (allCaracteristiqueResource.getCotationById(vCotationIdMinMax[0])).getValeur();
                String vCotationMax = (allCaracteristiqueResource.getCotationById(vCotationIdMinMax[1])).getValeur();
                String[] vCotationMinMax = {vCotationMin, vCotationMax};
                vSecteur.setCotationMinMax(vCotationMinMax);
            }
        }
        // retourner les données
        vMaV.addObject("listSecteurs", vListSecteurs);
        vMaV.addObject("site", vSite);
        vMaV.setViewName("secteurs");
        return vMaV;
    }

    /**
     * Affiche le formulaire de création de secteur.
     * @param pSiteId L'identifiant du site concerné.
     * @return Les infos du site concerné et la vue.
     */
    @GetMapping("/showCreationSecteurForm")
    public ModelAndView showCreationSecteurForm(@RequestParam(value = "siteId") Integer pSiteId) {
        ModelAndView vMaV = new ModelAndView();
        Site vSite = siteResource.getSiteById(pSiteId);
        vMaV.addObject("site", vSite);
        vMaV.setViewName("formulaire-creation-secteur");
        return vMaV;
    }

    /**
     * Enregistre un nouveau secteur dans la base de données.
     * @param pSecteurNom Le nom du secteur.
     * @param pDescription La description du secteur.
     * @param pSiteId L'identifiant du site.
     * @return Les données du sites et la liste des secteurs, un message de confirmation, la vue (page-secteurs).
     */
    @PostMapping("/creationSecteur")
    public ModelAndView createSecteur(@RequestParam(value = "secteurNom", required = false) String pSecteurNom,
                                   @RequestParam(value = "description", required = false) String pDescription,
                                   @RequestParam(value = "siteId", required = false) int pSiteId) {
        Secteur vNewSecteur = null;
        List<Secteur> vListSecteurs;
        Site vSite;
        ModelAndView vMaV = new ModelAndView();
        try {
            secteurResource.createSecteur(pSecteurNom, pDescription, pSiteId);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            vListSecteurs = secteurResource.getSecteursBySiteId(pSiteId);
            String vMessageCreationSecteur = "Le nouveau secteur " + pSecteurNom + " est créé !";
            vSite = siteResource.getSiteById(pSiteId);
            vMaV.addObject("site", vSite);
            vMaV.addObject("messageCreationSecteur", vMessageCreationSecteur);
            vMaV.addObject("listSecteurs", vListSecteurs);
            vMaV.setViewName("secteurs");
        }
        return vMaV;
    }

//    @GetMapping("/showSitePage")
//    public ModelAndView showSitePage(@RequestParam("siteId") int siteId) {
//        ModelAndView vMaV = new ModelAndView();
//        System.out.println(siteId);
//        Site vSite = siteResource.getSiteById(siteId);
//        vMaV.addObject("site", vSite);
//        vMaV.setViewName("sites");
//        return vMaV;
//    }

}
