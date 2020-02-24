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
public class VoieController extends AbstractController{

    @Inject
    VoieResource voieResource;
    @Inject
    SecteurResource secteurResource;
    @Inject
    AllCaracteristiqueResource allCaracteristiqueResource;

    Logger logger = LogManager.getLogger(VoieController.class);

    @GetMapping("/showVoiePage")
    public ModelAndView showVoiePage (@RequestParam(value = "secteurId") Integer pSecteurId,
                                      @RequestParam(value = "siteId") Integer pSiteId) {

        logger.debug("SecteurId = "+pSecteurId);
        logger.debug("SiteId = "+pSiteId);
        Secteur vSecteur = secteurResource.getSecteurById(pSecteurId);
        List<Voie> vListVoie = voieResource.getVoiesBySecteurId(pSecteurId);

        ModelAndView vMaV = new ModelAndView();
        vMaV.addObject("siteId", pSiteId);
        vMaV.addObject("secteur", vSecteur);
        vMaV.addObject("voies", vListVoie);
        vMaV.setViewName("voies");
        return vMaV;
    }

    @GetMapping("/showCreationVoieForm")
    public ModelAndView showCreationVoieForm(@RequestParam(value = "secteurId") Integer pSecteurId,
                                             @RequestParam(value = "siteId") Integer pSiteId) {
        ModelAndView vMaV = new ModelAndView();
        Secteur vSecteur = secteurResource.getSecteurById(pSecteurId);
        List<Cotation> vListCotations = allCaracteristiqueResource.getAllCotations();
        vMaV.addObject("siteId", pSiteId);
        vMaV.addObject("secteur", vSecteur);
        vMaV.addObject("cotations", vListCotations);
        vMaV.setViewName("formulaire-creation-voie");
        return vMaV;
    }

    @PostMapping("/creationVoie")
    public ModelAndView createVoie (@RequestParam(value = "nom") String pVoieNom,
                                    @RequestParam(value = "hauteur", required = false) Integer pVoieHauteur,
                                    @RequestParam(value = "cotationId", required = false) Integer pCotationId,
                                    @RequestParam(value = "secteurId") Integer pSecteurId,
                                    @RequestParam(value = "siteId") Integer pSiteId
                                    ) {
        ModelAndView vMaV = new ModelAndView();
        Integer vVoieHauteur = 0;
        Voie vVoie = new Voie();

        // récupérer le secteur
        Secteur vSecteur = secteurResource.getSecteurById(pSecteurId);
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

        // récupérer la liste des voies correspondant au secteur pour la renvoyer à la vue
        List<Voie> vListVoie = voieResource.getVoiesBySecteurId(pSecteurId);
        // message de confirmation
        String vMessageCreationVoie = "La voie " + pVoieNom + " est créée !";
        // ajout de la vue et des objets au ModelAndView
        vMaV.addObject("secteur", vSecteur);
        vMaV.addObject("messageCreationVoie", vMessageCreationVoie);
        vMaV.addObject("voies", vListVoie);
        vMaV.addObject("siteId", pSiteId);
        vMaV.setViewName("voies");
        return vMaV;
    }
}
