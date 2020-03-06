package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Commentaire;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;

@Named
public class CommentaireResource extends AbstractResource {

    public void createCommentaire (Commentaire pCommentaire) throws TechnicalException {
        getManagerFactory().getCommentaireManager().createCommentaire(pCommentaire);
    }
}
