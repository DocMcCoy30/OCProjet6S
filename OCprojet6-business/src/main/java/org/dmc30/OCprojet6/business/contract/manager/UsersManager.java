package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface UsersManager {

    /**
     * Enregistre un nouvel utilisateur dans la base de données : (table)users et son rôle dans (table)users_role
     */
    void createUsers (Users pUsers) throws TechnicalException;

    /**
     * Cherche un utilisateur par son identifiant dans la base de donnée.
     * @param pUsername L'identifiant de l'utilisateur recherché.
     * @return L'uitlisateur correspodant à l'identifiant renseigné.
     */
    Users getUsersByName (String pUsername) throws TechnicalException;

    /**
     * Cherche et renvoie la liste de tous les utilisateurs stockés dans la base de données.
     * @return La liste des utilisateurs.
     */
    List<Users> getAllUsers() throws TechnicalException;

    /**
     * Modifie un utilisateur.
     * @param pUsers : l'objet à modifier
     */
    void updateUsers (Users pUsers);

    /**
     * Supprime un utilisateur de la base de données.
     * @param pId : L'identifiant de l'utilisateur à supprimer.
     */
    void deleteUsers (int pId);

    /**
     * Verifie que le nouveal utilisateur n'est pas déjà enregistré dans la base de données.
     * @param pUsers Le nouvel utilisateur renseigné dans le formulaire de création de compte.
     * @return vrai ou faux
     */
    int[] rechercheDoublon (Users pUsers) throws TechnicalException;
}
