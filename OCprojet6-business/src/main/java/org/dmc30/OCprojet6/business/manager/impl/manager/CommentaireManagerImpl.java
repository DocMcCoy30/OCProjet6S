package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.CommentaireManager;
import org.dmc30.OCprojet6.model.bean.Commentaire;

import javax.inject.Named;
import java.util.List;

@Named
public class CommentaireManagerImpl extends AbstractManager implements CommentaireManager {

    @Override
    public void createCommentaire(Commentaire pCommentaire) {
        getDaoFactory().getCommentaireDao().createCommentaire(pCommentaire);

    }

    @Override
    public Commentaire getCommentaireById(int pId) {
        Commentaire vCommentaire = getDaoFactory().getCommentaireDao().getCommentaireById(pId);
        return vCommentaire;
    }

    @Override
    public List<Commentaire> getAllCommentaires() {
        List<Commentaire> vListCommentaire = getDaoFactory().getCommentaireDao().getAllCommentaires();
        return vListCommentaire;
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
