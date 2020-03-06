package org.dmc30.OCprojet6.webapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.Commentaire;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.dmc30.OCprojet6.webapp.resource.AuthenticationResource;
import org.dmc30.OCprojet6.webapp.resource.CommentaireResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Date;

@Controller
public class commentaireController {

    Logger logger = LogManager.getLogger(commentaireController.class);

    @Inject
    CommentaireResource commentaireResource;
    @Inject
    AuthenticationResource authenticationResource;
    @Inject
    SiteController siteController;

    @PostMapping("/createCommentaire")
    public ModelAndView createCommentaire(@RequestParam(value = "siteId") Integer pSiteId,
                                          @RequestParam(value = "commentaireTitre") String pTitre,
                                          @RequestParam(value = "commentaire") String pCommentaire,
                                          @RequestParam(value = "username") String pUsername) throws TechnicalException {

        ModelAndView vMaV = new ModelAndView();
        String vMessageSucces = "";
        String vMessageAlert = "";
        Commentaire vCommentaire = new Commentaire();

        //fixer les attributs du bean commentaire
        vCommentaire.setTitre(pTitre);
        vCommentaire.setCommentaire(pCommentaire);
        vCommentaire.setReference_id(1);
        vCommentaire.setRef_id(pSiteId);
        vCommentaire.setValide(false);
        vCommentaire.setUsers(authenticationResource.getUserByName(pUsername));
        vCommentaire.setDate(new Date());
        //enregistrer le commentaire dans la base de données
        try {
            commentaireResource.createCommentaire(vCommentaire);
            vMessageSucces = "Votre commentaire est enregistré. Il sera publié après validation par un administrateur.";
        } catch (TechnicalException e) {
            vMessageAlert = e.getMessage();
        }


        logger.debug(vCommentaire.getDate());

        return siteController.showSitePage(pSiteId, vMessageSucces, vMessageAlert);
    }

}
