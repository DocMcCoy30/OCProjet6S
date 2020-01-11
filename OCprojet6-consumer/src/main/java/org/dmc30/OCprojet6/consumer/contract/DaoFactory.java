package org.dmc30.OCprojet6.consumer.contract;

import org.dmc30.OCprojet6.consumer.contract.dao.CaracteristiqueDao;

public interface DaoFactory {

    CaracteristiqueDao getCaracteristiqueDao ();
    void setCaracteristiqueDao (CaracteristiqueDao caracteristiqueDao);
}
