package org.dmc30.OCprojet6.business.manager.contract.manager;

import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface UsersManager {

    /**
     * Enregistre un objet de type Users dans la database
     */
    void createUsers (Users pUsers) throws TechnicalException;

    /**
     * Cherche et renvoie un objet de type Users stocké dans la database
     * @param pUsername l'identifiant de l'objet recherché
     * @return l'objet recherché
     */
    Users getUsersByName (String pUsername);

    /**
     * Cherche et renvoie la liste des objets de type Users stockés dans la database
     * @return la liste d'objets recherchée
     */
    List<Users> getListUsers ();

    /**
     * Modifie un objet de type Users
     * @param pUsers : l'objet à modifier
     */
    void updateUsers (Users pUsers);

    /**
     * Supprimer un objet de type Users
     * @param pId : l'identifiant de l'objet à supprimer
     */
    void deleteUsers (int pId);

    /**
     * Recherche de doublon pour creation de compte
     * @param pUsers le Users renseigné dans le formulaire de creéation de compte
     * @return false ou true
     */
    int[] rechercheDoublon (Users pUsers);
}
