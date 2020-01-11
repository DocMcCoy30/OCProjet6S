package org.dmc30.OCprojet6.consumer.impl;

import org.dmc30.OCprojet6.consumer.contract.DaoFactory;
import org.dmc30.OCprojet6.consumer.contract.dao.CaracteristiqueDao;

import javax.inject.Inject;
import javax.inject.Named;

@Named("daoFactory")
public class DaoFactoryImpl implements DaoFactory {

    @Inject
    CaracteristiqueDao caracteristiqueDao;

    @Override
    public CaracteristiqueDao getCaracteristiqueDao() {

        return caracteristiqueDao;
    }

    @Override
    public void setCaracteristiqueDao(CaracteristiqueDao caracteristiqueDao) {

    }
}
