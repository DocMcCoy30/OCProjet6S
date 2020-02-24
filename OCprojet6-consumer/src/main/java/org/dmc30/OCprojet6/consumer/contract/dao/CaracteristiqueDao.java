package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Caracteristique;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface CaracteristiqueDao {

    void createCaracteristique (Caracteristique pCaracteristique) throws TechnicalException;
    Caracteristique getCaracteristiqueById(int pId) throws TechnicalException;
    List<Caracteristique> getAllCaracteristiques() throws TechnicalException;
    void updateCaracteristique (Caracteristique pCaracteristique) throws TechnicalException;
    void deleteCaracteristique(int pId) throws TechnicalException;
}

