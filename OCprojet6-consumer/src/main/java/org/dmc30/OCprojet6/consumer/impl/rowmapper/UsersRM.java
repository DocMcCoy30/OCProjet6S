package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.model.bean.Users;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class UsersRM implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet resultSet, int i) throws SQLException {
        Users vUsers = new Users(resultSet.getString("username"));
        vUsers.setPassword(resultSet.getString("password"));
        vUsers.setEmail(resultSet.getString("email"));
        vUsers.setEnabled(resultSet.getBoolean("enabled"));
        return vUsers;
    }
}
