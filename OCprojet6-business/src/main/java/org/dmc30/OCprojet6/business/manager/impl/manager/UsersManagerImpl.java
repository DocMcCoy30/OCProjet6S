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
        return getDaoFactory().getUsersDao().readUsers(pUsername);
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

    /**
     * Recherche les doublons (username et email) dans la DB
     * @param pUser Le nouvel utilisateur à créer et dont on souhaite comparer les données
     * @return un tableau de 2 chiffres analysé dans le controller : si différent de 0 => existence d'un doublon
     */
    public int[] rechercheDoublon (Users pUser) {
        List<Users> vListUsers = getDaoFactory().getUsersDao().readAllUsers();
        int vUsernameMarker = 0;
        int vEmailMarker = 0;
        for (Users vUsers:vListUsers) {
            if ((pUser.getUsername()).equals(vUsers.getUsername())) {
                vUsernameMarker ++;
                break;
            }
            else if ((pUser.getEmail()).equals(vUsers.getEmail())) {
                vEmailMarker ++;
                break;
            }
        }
        int [] vResult = {vUsernameMarker, vEmailMarker};
        return vResult;
    }
}
