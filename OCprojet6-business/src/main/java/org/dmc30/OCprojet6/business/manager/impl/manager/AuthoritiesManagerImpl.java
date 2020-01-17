package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.AuthoritiesManager;
import org.dmc30.OCprojet6.model.bean.Authorities;

import javax.inject.Named;
import java.util.List;

@Named
public class AuthoritiesManagerImpl extends AbstractManager implements AuthoritiesManager {

    @Override
    public void createAuthorities(Authorities pAuthorities) {
        getDaoFactory().getAuthoritiesDao().createAuthorities(pAuthorities);

    }

    @Override
    public Authorities getAuthorities(String pUsername) {
        Authorities vAuthorities = getDaoFactory().getAuthoritiesDao().readAuthorities(pUsername);
        return vAuthorities;
    }

    @Override
    public List<Authorities> getListAuthorities() {
        List<Authorities> vListAuthorities = getDaoFactory().getAuthoritiesDao().readAllAuthoritiess();
        return vListAuthorities;
    }

    @Override
    public void updateAuthorities(Authorities pAuthorities) {
        getDaoFactory().getAuthoritiesDao().updateAuthorities(pAuthorities);
    }

    @Override
    public void deleteAuthorities(int pId) {
        getDaoFactory().getAuthoritiesDao().deleteAuthorities(pId);
    }
}
