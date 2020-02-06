package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.consumer.contract.DaoFactory;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.inject.Named;

public abstract class AbstractManager {

    // -- transaction manager
    @Inject
    @Named("txManagerOCprojet6")
    private PlatformTransactionManager platformTransactionManager;
    //-- GETTER
    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }

    //-- Variable d'instances
    private static DaoFactory daoFactory;

    //-- GETTER
    protected static DaoFactory getDaoFactory() {
        return daoFactory;
    }

    //-- SETTER
    public static void setDaoFactory(DaoFactory pDaoFactory) {
        daoFactory = pDaoFactory;
    }

}
