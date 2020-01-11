package org.dmc30.OCprojet6.batch;

import org.dmc30.OCprojet6.business.manager.contract.ManagerFactory;

/**
 * Classe abstraite en charge de récupérer L'objet ManagerFactory.
 */
public abstract class AbstractResource {


    //-- Variable d'instances initialisé dans l'IoC Container (cf batchContext.xml)
    private static ManagerFactory managerFactory;

    //-- GETTER
    protected static ManagerFactory getManagerFactory() {
        return managerFactory;
    }

    //-- SETTER
    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }
}


