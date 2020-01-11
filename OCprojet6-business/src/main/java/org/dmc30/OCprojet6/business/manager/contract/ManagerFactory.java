package org.dmc30.OCprojet6.business.manager.contract;

import org.dmc30.OCprojet6.business.manager.contract.manager.CaracteristiqueManager;

public interface ManagerFactory {


    CaracteristiqueManager getCaracteristiqueManager();

    void setCaracteristiqueManager(CaracteristiqueManager caracteristiqueManager);
}
