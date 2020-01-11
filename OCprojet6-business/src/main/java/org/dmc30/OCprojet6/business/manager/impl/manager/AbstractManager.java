package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.consumer.contract.DaoFactory;
import org.dmc30.OCprojet6.model.bean.Caracteristique;

public abstract class AbstractManager {

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

    public void createCaractéristique(Caracteristique pCracteristique) {

    }
}
