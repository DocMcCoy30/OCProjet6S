package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.UsersManager;
import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Named;
import java.util.List;

@Named
public class UsersManagerImpl extends AbstractManager implements UsersManager {

    // transaction => pilule bleu
//    @Override
//    public void createUsers(Users pUsers) {
//        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());
//        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                getDaoFactory().getUsersDao().createUsers(pUsers);
//                getDaoFactory().getUserRoleDao().createUserRole(pUsers.getUsername());
//            }
//        });
//    }

    // transaction => pilule bleu avec rollback
//    @Override
//    public void createUsers (Users pUsers) {
//        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());
//        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus pTransactionStatus) {
//           try {
//               getDaoFactory().getUsersDao().createUsers(pUsers);
//               getDaoFactory().getUserRoleDao().createUserRole(pUsers.getUsername());
//           }
//           catch (TechnicalException vEx ) {
//               pTransactionStatus.setRollbackOnly();
//           }
//            }
//        });
//    }

    // transaction => pilule rouge
    @Override
    @Transactional
    public void createUsers(Users pUsers) throws TechnicalException {

        TransactionStatus vTransactionStatus
                = getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
        try {
            String vRole;
            List<Users> vListUsers = getDaoFactory().getUsersDao().getAllUsers();
            if (vListUsers.isEmpty()) {
                vRole = "ROLE_ADMIN";
            } else {
                vRole = "ROLE_USER";
            }
            getDaoFactory().getUsersDao().createUsers(pUsers);
            getDaoFactory().getUserRoleDao().createUserRole(pUsers.getUsername(), vRole);
            TransactionStatus vTScommit = vTransactionStatus;
            vTransactionStatus = null;
            getPlatformTransactionManager().commit(vTScommit);
        } finally {
            if (vTransactionStatus != null) {
                getPlatformTransactionManager().rollback(vTransactionStatus);
            }
        }
    }

    @Override
    public Users getUsersByName(String pUsername) {
        return getDaoFactory().getUsersDao().getUsersByName(pUsername);
    }

    @Override
    public List<Users> getAllUsers() {
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
     *
     * @param pUser Le nouvel utilisateur à créer et dont on souhaite comparer les données
     * @return un tableau de 2 chiffres analysé dans le controller : si différent de 0 => existence d'un doublon
     */
    public int[] rechercheDoublon(Users pUser) {
        List<Users> vListUsers = getDaoFactory().getUsersDao().getAllUsers();
        int vUsernameMarker = 0;
        int vEmailMarker = 0;
        for (Users vUsers : vListUsers) {
            if ((pUser.getUsername()).equals(vUsers.getUsername())) {
                vUsernameMarker++;
                break;
            } else if ((pUser.getEmail()).equals(vUsers.getEmail())) {
                vEmailMarker++;
                break;
            }
        }
        int[] vResult = {vUsernameMarker, vEmailMarker};
        return vResult;
    }
}
