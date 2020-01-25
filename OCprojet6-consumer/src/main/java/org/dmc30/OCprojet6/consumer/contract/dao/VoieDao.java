package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Voie;

import java.util.List;

public interface VoieDao {

    void createVoie (Voie pVoie);
    Voie getVoieById(int pId);
    List<Voie> getAllVoies();
    void updateVoie (Voie pVoie);
    void deleteVoie(int pId);
}
