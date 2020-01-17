package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.AuthoritiesDao;
import org.dmc30.OCprojet6.model.bean.Authorities;

import javax.inject.Named;
import java.util.List;

@Named
public class AuthoritiesDaoImpl extends AbstractDao implements AuthoritiesDao {

    @Override
    public void createAuthorities(Authorities pAuthorities) {

    }

    @Override
    public Authorities readAuthorities(String pUsername) {
        return null;
    }

    @Override
    public List<Authorities> readAllAuthoritiess() {
        return null;
    }

    @Override
    public void updateAuthorities(Authorities pAuthorities) {

    }

    @Override
    public void deleteAuthorities(int pId) {

    }
}
