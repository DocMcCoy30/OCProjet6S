package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.UsersDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.UsersRM;
import org.dmc30.OCprojet6.model.bean.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UsersDaoImpl extends AbstractDao implements UsersDao {

    @Inject
    UsersRM usersRM;

    @Override
    public void createUsers(Users pUsers) {
        String vUserName = pUsers.getUsername();
        String vPassword = pUsers.getPassword();
        String vEmail = pUsers.getEmail();
        String vSQL = "INSERT INTO users (username, password, email) VALUES (?,?,?)";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vUserName, vPassword, vEmail);
    }

    @Override
    public Users readUsers(String pUsername) {
        return null;
    }

    @Override
    public List<Users> readAllUsers() {
        String vSQL = "SELECT * FROM users";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Users> vRowMapper = new UsersRM();
        List<Users> vListUsers = vJdbcTemplate.query(vSQL, vRowMapper);
        return vListUsers;
    }

    @Override
    public void updateUsers(Users pUsers) {

    }

    @Override
    public void deleteUsers(int pId) {

    }

}
