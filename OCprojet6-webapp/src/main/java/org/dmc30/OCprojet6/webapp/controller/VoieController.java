package org.dmc30.OCprojet6.webapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.bean.Voie;
import org.dmc30.OCprojet6.webapp.resource.SecteurResource;
import org.dmc30.OCprojet6.webapp.resource.VoieResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
