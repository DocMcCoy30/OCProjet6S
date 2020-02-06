package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.UsersDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.UsersRM;
import org.dmc30.OCprojet6.consumer.securityResource.PasswordEncoderHelper;
import org.dmc30.OCprojet6.model.bean.Users;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UsersDaoImpl extends AbstractDao implements UsersDao {

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
    public Users getUsersByName(String pUsername) {
        String vSQL = "SELECT * FROM users WHERE username="+pUsername;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Users> vListUsers = vJdbcTemplate.query(vSQL, usersRM);
        return vListUsers.get(0);
    }

    @Override
    public List<Users> getAllUsers() {
        String vSQL = "SELECT * FROM users";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, usersRM);
    }

    @Override
    public void updateUsers(Users pUsers) {

    }

    @Override
    public void deleteUsers(int pId) {

    }

}
