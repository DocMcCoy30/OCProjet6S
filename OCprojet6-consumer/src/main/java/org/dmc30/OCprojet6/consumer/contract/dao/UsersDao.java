package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface UsersDao {

    void createUsers (Users pUsers);
    Users getUsersByName(String pUsername);
    List<Users> getAllUsers();
    void updateUsers (Users pUsers);
    void deleteUsers(int pId);
}

