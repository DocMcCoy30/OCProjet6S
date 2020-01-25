package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Commentaire;

import java.util.List;

public interface CommentaireDao {

    void createCommentaire (Commentaire pCommentaire);
    Commentaire getCommentaireById(int pId);
    List<Commentaire> getAllCommentaires();
    void updateCommentaire (Commentaire pCommentaire);
    void deleteCommentaire(int pId);
}

