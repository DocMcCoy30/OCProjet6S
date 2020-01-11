package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.CommentaireManager;
import org.dmc30.OCprojet6.model.bean.Commentaire;

import javax.inject.Named;
import java.util.List;

@Named
public class CommentaireManagerImpl extends AbstractManager implements CommentaireManager {

    @Override
    public void createCommentaire(Commentaire pCommentaire) {

    }

    @Override
    public Commentaire getCommentaireById(int pId) {
        return null;
    }

    @Override
    public List<Commentaire> getListCommentaires() {
        return null;
    }

    @Override
    public void updateCommentaire(Commentaire pCommentaire) {

    }

    @Override
    public void deleteCommentaire(int pId) {

    }
}
