package org.dmc30.OCprojet6.business.manager.contract.manager;

import org.dmc30.OCprojet6.model.bean.Utilisateur;

import java.util.List;

public interface UtilisateurManager {

    /**
     * Enregistre un objet de type Utilisateur dans la database
     */
    void createUtilisateur (Utilisateur pUtilisateur);

    /**
     * Cherche et renvoie un objet de type Utilisateur stocké dans la database
     * @param pId l'identifiant de l'objet recherché
     * @return l'objet recherché
     */
    Utilisateur getUtilisateurById (int pId);

    /**
     * Cherche et renvoie la liste des objets de type Utilisateur stockés dans la database
     * @return la liste d'objets recherchée
     */
    List<Utilisateur> getListUtilisateurs ();

    /**
     * Modifie un objet de type Utilisateur
     * @param pUtilisateur : l'objet à modifier
     */
    void updateUtilisateur (Utilisateur pUtilisateur);

    /**
     * Supprimer un objet de type Utilisateur
     * @param pUtilisateur : l'objet à supprimer
     */
    void deleteUtilisateur (Utilisateur pUtilisateur);
}
