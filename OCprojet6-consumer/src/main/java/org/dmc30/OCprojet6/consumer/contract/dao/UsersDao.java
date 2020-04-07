package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface UsersDao {

    void createUsers (Users pUsers) throws TechnicalException;
    Users getUsersByName(String pUsername) throws TechnicalException;
    List<Users> getAllUsers() throws TechnicalException;
    void updateUsers (Users pUsers);
    void deleteUsers(Users pUsers);
}

