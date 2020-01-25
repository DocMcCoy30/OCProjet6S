package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Caracteristique;

import java.util.List;

public interface CaracteristiqueDao {

    void createCaracteristique (Caracteristique pCaracteristique);
    Caracteristique getCaracteristiqueById(int pId);
    List<Caracteristique> getAllCaracteristiques();
    void updateCaracteristique (Caracteristique pCaracteristique);
    void deleteCaracteristique(int pId);
}

