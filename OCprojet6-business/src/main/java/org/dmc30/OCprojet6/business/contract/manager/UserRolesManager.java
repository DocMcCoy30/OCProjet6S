package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.UserRoles;
import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface UserRolesManager {


    /**
     * Cherche le role d'un utilisteur par son username dans la base de donnée.
     * @param pUsername L'identifiant de l'utilisateur dont on cherche le role.
     * @return Le role de l'utilisateur concerné.
     */
    UserRoles getUserRolesByUsername(String pUsername) throws TechnicalException;

    /**
     * Modifie le role d'un utilisateur.
     * @param pUserRoles : l'objet à modifier
     */
    void updateUserRole(UserRoles pUserRoles) throws TechnicalException;

}
