package org.dmc30.OCprojet6.webapp.resource;


import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;

@Named
public class AuthenticationResource extends AbstractResource{

    public void createUsers (Users pUsers) throws TechnicalException {
        getManagerFactory().getUsersManager().createUsers(pUsers);
    }

    public Users getUserByName (String pUsername) throws TechnicalException {
        return getManagerFactory().getUsersManager().getUsersByName(pUsername);
    }

    public int[] rechercheDoublon (Users pUsers) throws TechnicalException {
        return getManagerFactory().getUsersManager().rechercheDoublon(pUsers);
    }


}
