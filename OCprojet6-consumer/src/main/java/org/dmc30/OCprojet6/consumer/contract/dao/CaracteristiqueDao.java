package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Caracteristique;

import java.util.List;

public interface CaracteristiqueDao {

    void createCaracteristique (Caracteristique pCaracteristique);
    Caracteristique readCaracteristique (int pId);
    List<Caracteristique> readAllCaracteristiques ();
    void updateCaracteristique (Caracteristique pCaracteristique);
    void deleteCaracteristique(int pId);
}

