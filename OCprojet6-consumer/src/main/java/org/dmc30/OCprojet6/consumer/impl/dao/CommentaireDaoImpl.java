package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.CommentaireDao;
import org.dmc30.OCprojet6.model.bean.Commentaire;

import javax.inject.Named;
import java.util.List;

@Named
public class CommentaireDaoImpl extends AbstractDao implements CommentaireDao {

    @Override
    public void createCommentaire(Commentaire pCommentaire) {

    }

    @Override
    public Commentaire readCommentaire(int pId) {
        return null;
    }

    @Override
    public List<Commentaire> readAllCommentaires() {
        return null;
    }

    @Override
    public void updateCommentaire(Commentaire pCommentaire) {

    }

    @Override
    public void deleteCommentaire(int pId) {

    }
}
