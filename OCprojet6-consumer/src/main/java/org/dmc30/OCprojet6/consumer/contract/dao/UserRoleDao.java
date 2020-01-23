package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.exception.TechnicalException;

public interface UserRoleDao {

    void createUserRole (String pUsername) throws TechnicalException;
}
