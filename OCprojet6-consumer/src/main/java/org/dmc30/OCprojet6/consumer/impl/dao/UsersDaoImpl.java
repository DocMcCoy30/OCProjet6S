package org.dmc30.OCprojet6.consumer.impl.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.consumer.contract.dao.UsersDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.UsersRM;
import org.dmc30.OCprojet6.consumer.securityResource.PasswordEncoderHelper;
import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.ErrorMessages;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UsersDaoImpl extends AbstractDao implements UsersDao {

    Logger logger = LogManager.getLogger(UsersDaoImpl.class);

    @Inject
    UsersRM usersRM;
    @Inject
    PasswordEncoderHelper encoder;

    @Override
    public void createUsers(Users pUsers) {
        String vUserName = pUsers.getUsername();
        String vPassword = encoder.passwordEncoder(pUsers.getPassword());
        String vEmail = pUsers.getEmail();
        String vSQL = "INSERT INTO users (username, password, email, enabled) VALUES (?,?,?,?)";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vUserName, vPassword, vEmail, true);
    }

    @Override
    public Users getUsersByName(String pUsername) throws TechnicalException {
        List<Users> vListUsers;
        String vSQL = "SELECT * FROM users WHERE username='" + pUsername +"'";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        try {
            vListUsers = vJdbcTemplate.query(vSQL, usersRM);
        }catch (
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
        return vListUsers.get(0);
    }

    @Override
    public List<Users> getAllUsers() throws TechnicalException {
        List<Users> vListUsers;

        String vSQL = "SELECT * FROM users";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        try {
            vListUsers = vJdbcTemplate.query(vSQL, usersRM);
        }catch (
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
        return vListUsers;
    }

    @Override
    public void updateUsers(Users pUsers) {
        String vSQL = "UPDATE users SET password= :password, email= :email, enabled = :enabled WHERE username = :username";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("username", pUsers.getUsername());
        vParams.addValue("password", pUsers.getPassword());
        vParams.addValue("email", pUsers.getEmail());
        vParams.addValue("enabled", pUsers.isEnabled());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);
    }

    @Override
    public void deleteUsers(Users pUsers) {

    }

}
