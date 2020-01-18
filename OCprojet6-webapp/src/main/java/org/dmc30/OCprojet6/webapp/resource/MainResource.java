package org.dmc30.OCprojet6.webapp.resource;


import org.dmc30.OCprojet6.model.bean.Users;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.inject.Named;

@Named
public class MainResource extends AbstractResource{

    public void createUsers (Users pUsers) {
        getManagerFactory().getUsersManager().createUsers(pUsers);
    }

    public Users getUserByName (String pUsername) {
        return getManagerFactory().getUsersManager().getUsersByName(pUsername);
    }

    public int[] rechercheDoublon (Users pUsers) {
        return getManagerFactory().getUsersManager().rechercheDoublon(pUsers);
    }


}
