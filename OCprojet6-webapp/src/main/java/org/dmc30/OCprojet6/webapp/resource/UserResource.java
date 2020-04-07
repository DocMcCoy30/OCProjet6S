package org.dmc30.OCprojet6.webapp.resource;


import org.dmc30.OCprojet6.model.bean.UserRoles;
import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class UserResource extends AbstractResource{

    public void createUsers (Users pUsers) throws TechnicalException {
        getManagerFactory().getUsersManager().createUsers(pUsers);
    }

    public Users getUserByName (String pUsername) throws TechnicalException {
        return getManagerFactory().getUsersManager().getUsersByName(pUsername);
    }

    public List<Users> getAllUsers () throws TechnicalException {
        return getManagerFactory().getUsersManager().getAllUsers();
    }

    public int[] rechercheDoublon (Users pUsers) throws TechnicalException {
        return getManagerFactory().getUsersManager().rechercheDoublon(pUsers);
    }


    public UserRoles getUserRoleByUsername(String pUsername) throws TechnicalException {
        return getManagerFactory().getUserRolesManager().getUserRolesByUsername(pUsername);
    }

    public void updateUserRole (UserRoles pUserRoles) throws TechnicalException {
        getManagerFactory().getUserRolesManager().updateUserRole(pUserRoles);
    }

    public void updateUser(Users pUser) {
        getManagerFactory().getUsersManager().updateUsers(pUser);
    }
}
