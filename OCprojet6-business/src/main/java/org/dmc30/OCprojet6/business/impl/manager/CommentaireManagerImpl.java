package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.CommentaireManager;
import org.dmc30.OCprojet6.model.bean.Commentaire;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class CommentaireManagerImpl extends AbstractManager implements CommentaireManager {

    @Override
    public void createCommentaire(Commentaire pCommentaire) throws TechnicalException {
        getDaoFactory().getCommentaireDao().createCommentaire(pCommentaire);

    }

    @Override
    public Commentaire getCommentaireById(int pId) {
        return getDaoFactory().getCommentaireDao().getCommentaireById(pId);
    }

    @Override
    public List<Commentaire> getAllCommentaires() {
        return getDaoFactory().getCommentaireDao().getAllCommentaires();
    }

    @Override
    public void updateCommentaire(Commentaire pCommentaire) {
        getDaoFactory().getCommentaireDao().updateCommentaire(pCommentaire);
    }

    @Override
    public void deleteCommentaire(int pId) {
        getDaoFactory().getCommentaireDao().deleteCommentaire(pId);
    }
}
