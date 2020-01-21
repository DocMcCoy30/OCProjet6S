package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.UserRoleDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;

@Named
public class UserRoleDaoImpl extends AbstractDao implements UserRoleDao {

    @Override
    public void createUserRole(String pUsername) {
        String vSQL = "INSERT INTO user_roles (username, role) VALUES (?,?)";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, pUsername, "ROLE_ADMIN");
    }
}
