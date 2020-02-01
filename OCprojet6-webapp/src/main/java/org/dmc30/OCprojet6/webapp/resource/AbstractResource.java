package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.business.contract.ManagerFactory;

public abstract class AbstractResource {

    public static ManagerFactory managerFactory;

    protected static ManagerFactory getManagerFactory() {
        return managerFactory;
    }

    public static void setManagerFactory(ManagerFactory pmanagerFactory) {
        managerFactory = pmanagerFactory;
    }
}
