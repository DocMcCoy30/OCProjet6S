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

    @PostMapping("/updateCommentaire")
    public void updateCommentaire (@RequestParam(value = "commentaireId") Integer pCommentaireId,
                                   @RequestParam(value = "checked") Boolean pChecked,
                                   HttpServletResponse response) throws TechnicalException, IOException {
        Commentaire vCommentaire = commentaireResource.getCommentaireById(pCommentaireId);
        if (pChecked) {
            vCommentaire.setValide(true);
        } else if (!pChecked){
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

}
