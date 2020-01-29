package org.dmc30.OCprojet6.webapp.controller;

import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.webapp.resource.SecteurResource;
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
public class SecteurController extends AbstractController {

    @Inject
    SecteurResource secteurResource;


    @GetMapping("/showCreationSecteurForm")
    public ModelAndView showCreationSiteForm(@RequestParam(value = "siteId") Integer pSiteId) {
        ModelAndView vMaV = new ModelAndView();
        Site vSite = siteResource.getSiteById(pSiteId);
        vMaV.addObject("site", vSite);
        vMaV.setViewName("formulaire-creation-secteur");
        return vMaV;
    }

    @PostMapping("/creationSecteur")
    public ModelAndView createSite(@RequestParam(value = "secteurNom", required = false) String pSecteurNom,
                                   @RequestParam(value = "description", required = false) String pDescription,
                                   @RequestParam(value = "siteId", required = false) int pSiteId) {
        Secteur vNewSecteur = null;
        List<Secteur> vListSecteurs = new ArrayList<>();
        Site vSite = null;
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
            vMaV.setViewName("sites");
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
