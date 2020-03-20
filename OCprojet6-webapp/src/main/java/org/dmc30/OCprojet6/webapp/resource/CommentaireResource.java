package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Commentaire;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class CommentaireResource extends AbstractResource {

    public void createCommentaire (Commentaire pCommentaire) throws TechnicalException {
        getManagerFactory().getCommentaireManager().createCommentaire(pCommentaire);
    }

    public List<Commentaire> getValidatedCommentairesByReference(int pRefererenceId, int pRefId) {
        return getManagerFactory().getCommentaireManager().getValidatedCommentairesByReference(pRefererenceId, pRefId);
    }

    public List<Commentaire> getNonValidatedCommentaires() {
        return getManagerFactory().getCommentaireManager().getNonValidatedCommentaires();
    }

    public void updateCommentaire (Commentaire pCommentaire) throws TechnicalException {
        getManagerFactory().getCommentaireManager().updateCommentaire(pCommentaire);
    }

    public Commentaire getCommentaireById(Integer pCommentaireId) {
        return getManagerFactory().getCommentaireManager().getCommentaireById(pCommentaireId);
    }

    public void deleteCommentaire(Integer pCommentaireId) throws TechnicalException {
        getManagerFactory().getCommentaireManager().deleteCommentaire(pCommentaireId);
    }
}
