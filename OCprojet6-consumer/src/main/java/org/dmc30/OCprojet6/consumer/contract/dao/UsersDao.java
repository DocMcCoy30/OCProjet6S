package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Users;

import java.util.List;

public interface UsersDao {

    void createUsers (Users pUsers);
    Users readUsers (String pUsername);
    List<Users> readAllUsers ();
    void updateUsers (Users pUsers);
    void deleteUsers(int pId);
}

