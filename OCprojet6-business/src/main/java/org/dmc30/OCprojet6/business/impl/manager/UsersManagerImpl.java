package org.dmc30.OCprojet6.business.impl.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.business.contract.manager.UsersManager;
import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.OCP6Error;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Named;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Named
public class UsersManagerImpl extends AbstractManager implements UsersManager {

    Logger logger = LogManager.getLogger(UsersManagerImpl.class);

    // transaction => pilule rouge
    @Override
    @Transactional
    public void createUsers(Users pUsers) throws TechnicalException {

        logger.info("Création du PlatformTransactionManager");
        TransactionStatus vTransactionStatus
                = getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
        logger.info("PlatformTransactionManager créé");
        try {
            String vRole;
            List<Users> vListUsers = getDaoFactory().getUsersDao().getAllUsers();
            // si c'est le premier user créé, on lui attribue automatiquement le ROLE_ADMIN
            if (vListUsers.isEmpty()) {
                vRole = "ROLE_ADMIN";
                logger.info("C'est le premier user créé : ROLE_ADMIN");
            } else {
                vRole = "ROLE_USER";
                logger.info("Ce n'est pas le premier user créé : ROLE_USER");
            }
            getDaoFactory().getUsersDao().createUsers(pUsers);
            logger.info("User créé : " + pUsers.getUsername());
            getDaoFactory().getUserRoleDao().createUserRole(pUsers.getUsername(), vRole);
            logger.info("UserRole créé : TODO => bean UserRole + getUserRoleById methode");
            TransactionStatus vTScommit = vTransactionStatus;
            vTransactionStatus = null;
            getPlatformTransactionManager().commit(vTScommit);
            logger.info("Commit OK");
        } catch (BadSqlGrammarException e) {
            logger.error("Problème de syntaxe dans la requète SQL");
            throw new TechnicalException(OCP6Error.OCP_6_400.getMessagesError().getMessage401());
        } catch (Exception e) {
            logger.error("Problème technique");
            throw new TechnicalException(OCP6Error.OCP_6_100.getMessagesError().getMessage101());
        } finally {
            if (vTransactionStatus != null) {
                getPlatformTransactionManager().rollback(vTransactionStatus);
                logger.info("Commit KO : rollback");
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
     * @return un tableau de 2 chiffres analysés dans le controller : si différents de 0 => existence d'un doublon
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
        return new int[]{vUsernameMarker, vEmailMarker};
    }
}
