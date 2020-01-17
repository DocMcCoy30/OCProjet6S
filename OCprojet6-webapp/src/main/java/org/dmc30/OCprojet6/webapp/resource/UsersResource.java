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

    public Boolean rechercheDoublon (String pUsername) {
        return getManagerFactory().getUsersManager().rechercheDoublon(pUsername);
    }


}
