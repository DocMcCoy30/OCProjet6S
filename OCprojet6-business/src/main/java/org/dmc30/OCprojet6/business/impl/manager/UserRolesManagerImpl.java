package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.UserRolesManager;
import org.dmc30.OCprojet6.model.bean.UserRoles;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;

@Named
public class UserRolesManagerImpl extends AbstractManager implements UserRolesManager {

    @Override
    public UserRoles getUserRolesByUsername(String pUsername) throws TechnicalException {
        return getDaoFactory().getUserRoleDao().getUserRoleByUsername(pUsername);
    }

    @Override
    public void updateUserRole(UserRoles pUserRoles) throws TechnicalException {
        getDaoFactory().getUserRoleDao().updateUserRole(pUserRoles);

    }
}
