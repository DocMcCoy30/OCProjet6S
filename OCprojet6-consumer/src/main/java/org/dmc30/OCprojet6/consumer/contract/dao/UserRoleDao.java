package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.UserRoles;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

public interface UserRoleDao {

    void createUserRole(String pUsername, String pRole) throws TechnicalException;

    void updateUserRole(UserRoles pUserRoles) throws TechnicalException;

    UserRoles getUserRoleByUsername(String pUsername);

}
