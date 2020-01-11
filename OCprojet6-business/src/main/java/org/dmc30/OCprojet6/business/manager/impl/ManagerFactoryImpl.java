package org.dmc30.OCprojet6.business.manager.impl;

import org.dmc30.OCprojet6.business.manager.contract.ManagerFactory;
import org.dmc30.OCprojet6.business.manager.contract.manager.CaracteristiqueManager;

import javax.inject.Inject;
import javax.inject.Named;

@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private CaracteristiqueManager caracteristiqueManager;

    @Override
    public CaracteristiqueManager getCaracteristiqueManager() {
        return caracteristiqueManager;
    }

    @Override
    public void setCaracteristiqueManager(CaracteristiqueManager caracteristiqueManager) {
        this.caracteristiqueManager = caracteristiqueManager;
    }
}
