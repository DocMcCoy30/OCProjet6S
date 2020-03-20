package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.Commentaire;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface CommentaireManager {

    /**
     * Enregistre un objet de type Commentaire dans la database.
     */
    void createCommentaire(Commentaire pCommentaire) throws TechnicalException;

    /**
     * Cherche et renvoie un objet de type Commentaire stocké dans la database.
     * @param pId l'identifiant de l'objet recherché.
     * @return l'objet recherché.
     */
    Commentaire getCommentaireById(int pId);

    /**
     * Cherche et renvoie la liste des objets de type Commentaire stockés dans la database.
     * @return la liste d'objets recherchée.
     */
    List<Commentaire> getAllCommentaires();

    /**
     * Modifie un objet de type Commentaire.
     * @param pCommentaire : l'objet à modifier.
     */
    void updateCommentaire(Commentaire pCommentaire) throws TechnicalException;

    /**
     * Supprimer un objet de type Commentaire.
     * @param pId : l'identifiant de l'objet à supprimer.
     */
    void deleteCommentaire(int pId) throws TechnicalException;

    /**
     * Cherche et renvoie la liste des commentaires validés correspondants à un site, un secteur ou une voie.
     * @param pRefererenceId Le numero de référence pour site, secteur ou voie.
     * @param pRefId L'identifiant du site, secteur ou voie.
     * @return La liste des commentaires liés au référent.
     */
    List<Commentaire> getValidatedCommentairesByReference(int pRefererenceId, int pRefId);

    /**
     * Cherche et renvoie la liste de tous les commentaires non validés.
     * @return La liste des commentaires non validés.
     */
    List<Commentaire> getNonValidatedCommentaires();

}
