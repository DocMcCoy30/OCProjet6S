package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.UsersManager;
import org.dmc30.OCprojet6.model.bean.Users;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class UsersManagerImpl extends AbstractManager implements UsersManager {

    @Override
    public void createUsers(Users pUsers) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getUsersDao().createUsers(pUsers);
                getDaoFactory().getUserRoleDao().createUserRole(pUsers.getUsername());
            }
        });
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
