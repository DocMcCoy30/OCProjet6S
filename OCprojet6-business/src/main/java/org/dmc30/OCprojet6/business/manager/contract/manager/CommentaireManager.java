package org.dmc30.OCprojet6.business.manager.contract.manager;

import org.dmc30.OCprojet6.model.bean.Commentaire;

import java.util.List;

public interface CommentaireManager {

    /**
     * Enregistre un objet de type Commentaire dans la database
     */
    void createCommentaire(Commentaire pCommentaire);

    /**
     * Cherche et renvoie un objet de type Commentaire stocké dans la database
     * @param pId l'identifiant de l'objet recherché
     * @return l'objet recherché
     */
    Commentaire getCommentaireById(int pId);

    /**
     * Cherche et renvoie la liste des objets de type Commentaire stockés dans la database
     * @return la liste d'objets recherchée
     */
    List<Commentaire> getListCommentaires ();

    /**
     * Modifie un objet de type Commentaire
     * @param pCommentaire : l'objet à modifier
     */
    void updateCommentaire(Commentaire pCommentaire);

    /**
     * Supprimer un objet de type Commentaire
     * @param pCommentaire : l'objet à supprimer
     */
    void deleteCommentaire(Commentaire pCommentaire);



}
