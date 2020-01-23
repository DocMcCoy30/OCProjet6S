package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface UsersDao {

    void createUsers (Users pUsers) throws TechnicalException;
    Users readUsers (String pUsername);
    List<Users> readAllUsers ();
    void updateUsers (Users pUsers);
    void deleteUsers(int pId);
}

