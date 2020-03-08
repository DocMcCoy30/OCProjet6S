package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.model.bean.UserRoles;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class UserRolesRM implements RowMapper<UserRoles> {

    @Override
    public UserRoles mapRow(ResultSet resultSet, int i) throws SQLException {
        UserRoles vUserRoles = new UserRoles(resultSet.getInt("user_role_id"),
                resultSet.getString("username"),
                resultSet.getString("role"));
        return vUserRoles;
    }

}
