package org.dmc30.OCprojet6.webapp.controller;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.Commentaire;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.dmc30.OCprojet6.webapp.resource.UserResource;
import org.dmc30.OCprojet6.webapp.resource.CommentaireResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class CommentaireController {

    Logger logger = LogManager.getLogger(CommentaireController.class);

    @Inject
    CommentaireResource commentaireResource;
    @Inject
    UserResource userResource;
    @Inject
    SiteController siteController;
    @Inject
    AccueilController accueilController;

    @PostMapping("/createCommentaire")
    public ModelAndView createCommentaire(@RequestParam(value = "siteId") Integer pSiteId,
                                          @RequestParam(value = "commentaire") String pCommentaire,
                                          @RequestParam(value = "username") String pUsername) throws TechnicalException {
        ModelAndView vMaV = new ModelAndView();
        String vMessageSucces = "";
        String vMessageAlert = "";
        Commentaire vCommentaire = new Commentaire();
        //fixer les attributs du bean commentaire
        vCommentaire.setCommentaire(pCommentaire);
        vCommentaire.setReferenceId(1);
        vCommentaire.setRefId(pSiteId);
        vCommentaire.setValide(false);
        vCommentaire.setUsers(userResource.getUserByName(pUsername));
        vCommentaire.setDate(new Date());
        //enregistrer le commentaire dans la base de données
        try {
            commentaireResource.createCommentaire(vCommentaire);
            vMessageSucces = "Votre commentaire est enregistré. Il sera publié après validation par un administrateur.";
        } catch (TechnicalException e) {
            vMessageAlert = e.getMessage();
        }

        return siteController.showSitePage(pSiteId, vMessageSucces, vMessageAlert);
    }

    @PostMapping("/publierCommentaire")
    public void publierCommentaire(@RequestParam(value = "commentaireId") Integer pCommentaireId,
                                   @RequestParam(value = "checked") Boolean pChecked,
                                   HttpServletResponse response) throws TechnicalException, IOException {
        Commentaire vCommentaire = commentaireResource.getCommentaireById(pCommentaireId);
        if (pChecked) {
            vCommentaire.setValide(true);
        } else if (!pChecked) {
            vCommentaire.setValide(false);
        }
        commentaireResource.updateCommentaire(vCommentaire);
        // Creation de la réponse en JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String vJSONCommentaire = new Gson().toJson(vCommentaire);
        logger.debug("vJSONCommentaire = " + vJSONCommentaire);
        response.getWriter().write(vJSONCommentaire);
    }

    @PostMapping("/updateCommentaire")
    public ModelAndView updateCommentaire(@RequestParam(value = "commentaireId") Integer pCommentaireId,
                                          @RequestParam(value = "action", required = false) String [] pAction,
                                          @RequestParam(value = "commentaire", required = false) String [] pCommentaire,
                                          @RequestParam(value = "line", required = false) Integer pLine,
                                          @RequestParam(value = "username", required = false) String pUsername,
                                          @RequestParam(value = "page") String pPage,
                                          @RequestParam(value = "siteId", required = false) Integer pSiteId,
                                          HttpServletRequest request) throws TechnicalException {

        Commentaire vCommentaire = new Commentaire();
        ModelAndView vMav = new ModelAndView();
        String vMessageSucces = "";

        switch (pAction[1]) {
            case "update":
                logger.debug("CommentaireId = " + pAction[2]);
                vCommentaire = commentaireResource.getCommentaireById(Integer.parseInt(pAction[2]));
                logger.debug("Commentaire à updater = " + vCommentaire.getCommentaire());
                logger.debug("Nouveau commentaire = "+ pCommentaire[Integer.parseInt(pAction[0])]);
                vCommentaire.setCommentaire(pCommentaire[Integer.parseInt(pAction[0])]);
                logger.debug("Commentaire updater = commentaire n°"+vCommentaire.getId() + " : "+vCommentaire.getCommentaire());
                commentaireResource.updateCommentaire(vCommentaire);
                vMessageSucces = "Le commentaire a été modifié.";
                break;
            case "delete":
                commentaireResource.deleteCommentaire(Integer.parseInt(pAction[2]));
                vMessageSucces = "Le commentaire a été supprimé.";
                break;
        }
        if (pPage.equals("page-perso")) {
            vMav = accueilController.showPagePerso(pUsername);
        }
        if (pPage.equals("page-site")) {
            vMav = siteController.showSitePage(pSiteId, vMessageSucces, "");
        }
        return vMav;
    }

}
