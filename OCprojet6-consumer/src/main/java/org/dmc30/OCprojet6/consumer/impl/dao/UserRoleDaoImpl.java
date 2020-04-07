package org.dmc30.OCprojet6.consumer.impl.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.consumer.contract.dao.UserRoleDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.UserRolesRM;
import org.dmc30.OCprojet6.model.bean.UserRoles;
import org.dmc30.OCprojet6.model.exception.ErrorMessages;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UserRoleDaoImpl extends AbstractDao implements UserRoleDao {

    Logger logger = LogManager.getLogger(UserRoleDaoImpl.class);

    @Inject
    UserRolesRM userRolesRM;

    @Override
    public void createUserRole(String pUsername, String pRole) throws TechnicalException {
        String vSQL = "INSERT INTO user_roles (username, role) VALUES (?,?)";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        try {
            vJdbcTemplate.update(vSQL, pUsername, pRole);
        } catch (
                BadSqlGrammarException e) {
            logger.error("Problème de syntaxe dans la requète SQL");
            throw new TechnicalException(ErrorMessages.SQL_SYNTAX_ERROR.getErrorMessage());
        } catch (
                DataAccessException e) {
            logger.error("Problème d'accès à la base de données");
            throw new TechnicalException(ErrorMessages.SQL_UPDATE_ERROR.getErrorMessage());
        } catch (Exception e) {
            logger.error("Problème technique");
            throw new TechnicalException(ErrorMessages.TECHNICAL_ERROR.getErrorMessage());
        }
    }

    @Override
    public void updateUserRole(UserRoles pUserRoles) throws TechnicalException {
        String vSQL = "UPDATE user_roles SET role=? WHERE user_role_id="+pUserRoles.getId();
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        try {
            vJdbcTemplate.update(vSQL, pUserRoles.getUserRole());
        } catch (
                BadSqlGrammarException e) {
            logger.error("Problème de syntaxe dans la requète SQL");
            throw new TechnicalException(ErrorMessages.SQL_SYNTAX_ERROR.getErrorMessage());
        } catch (
                DataAccessException e) {
            logger.error("Problème d'accès à la base de données");
            throw new TechnicalException(ErrorMessages.SQL_UPDATE_ERROR.getErrorMessage());
        } catch (Exception e) {
            logger.error("Problème technique");
            throw new TechnicalException(ErrorMessages.TECHNICAL_ERROR.getErrorMessage());
        }
    }


    @Override
    public UserRoles getUserRoleByUsername(String pUsername) {
        String vSQL = "SELECT * FROM user_roles WHERE username='" + pUsername + "'";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<UserRoles> vListUserRoles = vJdbcTemplate.query(vSQL,userRolesRM);
        return vListUserRoles.get(0);
    }

}
