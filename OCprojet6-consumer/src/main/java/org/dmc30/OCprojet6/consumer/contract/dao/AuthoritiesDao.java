package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Authorities;

import javax.inject.Named;
import java.util.List;

public interface AuthoritiesDao {

    void createAuthorities(Authorities pAuthorities);
    Authorities readAuthorities(String pUsername);
    List<Authorities> readAllAuthoritiess();
    void updateAuthorities(Authorities pAuthorities);
    void deleteAuthorities(int pId);
}

