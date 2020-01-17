package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Commentaire;

import java.util.List;

public interface CommentaireDao {

    void createCommentaire (Commentaire pCommentaire);
    Commentaire readCommentaire (int pId);
    List<Commentaire> readAllCommentaires ();
    void updateCommentaire (Commentaire pCommentaire);
    void deleteCommentaire(int pId);
}

