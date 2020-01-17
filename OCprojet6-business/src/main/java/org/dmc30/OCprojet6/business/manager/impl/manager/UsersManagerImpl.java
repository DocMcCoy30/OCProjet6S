package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.UsersManager;
import org.dmc30.OCprojet6.model.bean.Users;

import javax.inject.Named;
import java.util.List;

@Named
public class UsersManagerImpl extends AbstractManager implements UsersManager {

    @Override
    public void createUsers(Users pUsers) {
        getDaoFactory().getUsersDao().createUsers(pUsers);
    }

    @Override
    public Users getUsersByName(String pUsername) {
        return null;
    }

    @Override
    public List<Users> getListUsers() {
        return null;
    }

    @Override
    public void updateUsers(Users pUsers) {

    }

    @Override
    public void deleteUsers(int pId) {

    }

    public boolean rechercheDoublon (String pUsername) {
        List<Users> vListUsers = getDaoFactory().getUsersDao().readAllUsers();
        int i = 0;
        Boolean vDoublon = false;
        for (Users vUsers:vListUsers) {
            if (pUsername.equals(vUsers.getUsername())) {
                i++;
            }
        }
        if (i != 0) {
            vDoublon=true;
        }
        return vDoublon;
    }
}
