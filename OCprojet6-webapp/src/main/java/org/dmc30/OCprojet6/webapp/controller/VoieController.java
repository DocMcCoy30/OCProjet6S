package org.dmc30.OCprojet6.webapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.Cotation;
import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.bean.Voie;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.dmc30.OCprojet6.webapp.resource.AllCaracteristiqueResource;
import org.dmc30.OCprojet6.webapp.resource.SecteurResource;
import org.dmc30.OCprojet6.webapp.resource.VoieResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Controller
public class VoieController extends AbstractController {

    @Inject
    VoieResource voieResource;
    @Inject
    SecteurResource secteurResource;
    @Inject
    AllCaracteristiqueResource allCaracteristiqueResource;

    Logger logger = LogManager.getLogger(VoieController.class);

    /**
     * Affiche la page des voies d'un secteur.
     *
     * @param pSecteurId L'identifiant du secteur dont on souhaite consulter la liste des voies.
     * @param pSiteId    L'identifiant du site correspondant au secteur.
     * @return Les données et la vue.
     */
    @GetMapping("/showVoiePage")
    public ModelAndView showVoiePage(@RequestParam(value = "secteurId") Integer pSecteurId,
                                     @RequestParam(value = "siteId") Integer pSiteId) {

        Secteur vSecteur = secteurResource.getSecteurById(pSecteurId);
        List<Voie> vListVoie = voieResource.getVoiesBySecteurId(pSecteurId);

        ModelAndView vMaV = new ModelAndView();
        vMaV.addObject("siteId", pSiteId);
        vMaV.addObject("secteur", vSecteur);
        vMaV.addObject("voies", vListVoie);
        vMaV.setViewName("voies");
        return vMaV;
    }

    /**
     * Affiche le formulaire de création/modification de voie.
     *
     * @param pSecteurId L'identifiant du secteur auquel on souhaite ajouter une nouvelle voie.
     * @param pSiteId    L'identifiant du site correspondant au secteur.
     * @param pVoieId L'identifiant de la voie à modifier.
     * @return Les données et la vue.
     */
    @GetMapping("/showVoieForm")
    public ModelAndView showVoieForm(@RequestParam(value = "secteurId") Integer pSecteurId,
                                     @RequestParam(value = "siteId") Integer pSiteId,
                                     @RequestParam(value = "voieId", required = false) Integer pVoieId) {
        ModelAndView vMaV = new ModelAndView();
        Secteur vSecteur = secteurResource.getSecteurById(pSecteurId);
        List<Cotation> vListCotations = allCaracteristiqueResource.getAllCotations();
        if (pVoieId != null) {
            Voie vVoie = voieResource.getVoiesById(pVoieId);
            vMaV.addObject("voie", vVoie);
        }
        vMaV.addObject("siteId", pSiteId);
        vMaV.addObject("secteur", vSecteur);
        vMaV.addObject("cotations", vListCotations);
        vMaV.setViewName("formulaire-creation-voie");
        return vMaV;
    }

    /**
     * Crée ou modifie une voie dans la base de données.
     *
     * @param pVoieNom     Le nom de la nouvelle voie.
     * @param pVoieHauteur La hauteur de la nouvelle voie.
     * @param pCotationId  L'identifiant de la cotation de la nouvelle voie.
     * @param pSecteurId   Le secteur auquel est rattachée la nouvelle voie.
     * @param pSiteId      Le site auquel est rattaché le secteur.
     * @return Les données, le message de confirmation et la vue.
     */
    @PostMapping("/createUpdateVoie")
    public ModelAndView createUpdateVoie(@RequestParam(value = "nom") String pVoieNom,
                                         @RequestParam(value = "hauteur", required = false) Integer pVoieHauteur,
                                         @RequestParam(value = "cotationId", required = false) Integer pCotationId,
                                         @RequestParam(value = "secteurId") Integer pSecteurId,
                                         @RequestParam(value = "siteId") Integer pSiteId,
                                         @RequestParam(value = "voieId", required = false) Integer pVoieId,
                                         @RequestParam(value = "action") String pAction) throws TechnicalException {

        ModelAndView vMaV = new ModelAndView();
        Integer vVoieHauteur = 0;
        String vMessage ="";
        Voie vVoie = new Voie();
        Secteur vSecteur = new Secteur();
        List<Voie> vListVoie = new ArrayList<>();

        try {
            // récupérer le secteur
            vSecteur = secteurResource.getSecteurById(pSecteurId);

            switch (pAction) {
                case "update":
                    vVoie = voieResource.getVoiesById(pVoieId);
                    vVoie.setNom(pVoieNom);
                    if (pVoieHauteur != null) {
                        vVoie.setHauteur(pVoieHauteur);
                    }
                    if (pCotationId != null) {
                        Cotation vCotation = allCaracteristiqueResource.getCotationById(pCotationId);
                        vVoie.setCotation(vCotation);
                    }
                    voieResource.updateVoie(vVoie);
                    vMessage = "La voie "+ pVoieNom + " a été modifiée";
                    break;

                case "create":
                    // créer le nouvel objet Voie
                    vVoie.setNom(pVoieNom);
                    vVoie.setSecteur(vSecteur);
                    if (pVoieHauteur != null) {
                        vVoie.setHauteur(pVoieHauteur);
                    }
                    if (pCotationId != null) {
                        Cotation vCotation = allCaracteristiqueResource.getCotationById(pCotationId);
                        vVoie.setCotation(vCotation);
                    }
                    // créer la voie dans la base de donnée
                    voieResource.createVoie(vVoie);
                    vMessage = "La voie "+ pVoieNom + " a été créée";
            }
            // récupérer la liste des voies correspondant au secteur pour la renvoyer à la vue
            vListVoie = voieResource.getVoiesBySecteurId(pSecteurId);

        } catch (TechnicalException e) {
            vMessage = e.getMessage();

        } finally {
            // ajout de la vue et des objets au ModelAndView
            vMaV.addObject("secteur", vSecteur);
            vMaV.addObject("message", vMessage);
            vMaV.addObject("voies", vListVoie);
            vMaV.addObject("siteId", pSiteId);
            vMaV.setViewName("voies");
        }
        return vMaV;
    }
}
