package org.dmc30.OCprojet6.webapp.resource;


import org.dmc30.OCprojet6.model.bean.Users;

import javax.inject.Named;
import java.util.List;

@Named
public class UsersResource extends AbstractResource{

    public void createUsers (Users pUsers) {
        getManagerFactory().getUsersManager().createUsers(pUsers);
    }

    public Users getUserByName (String pUsername) {
        return getManagerFactory().getUsersManager().getUsersByName(pUsername);
    }

    public List<Users> getListUsers() {
        return getManagerFactory().getUsersManager().getListUsers();
    }

    public void updateUsers (Users pUsers) {
        getManagerFactory().getUsersManager().updateUsers(pUsers);
    }

    public void deleteCarateristique (int pId) {
        getManagerFactory().getUsersManager().deleteUsers(pId);
    }

    public Boolean rechercheDoublon (String pUsername) {
        return getManagerFactory().getUsersManager().rechercheDoublon(pUsername);
    }


}
