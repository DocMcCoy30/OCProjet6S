package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Voie;

import java.util.List;

public interface VoieDao {

    void createVoie (Voie pVoie);
    Voie getVoieById(int pId);
    List<Voie> getVoiesBySecteurId(int pSecteurId);
    List<Voie> getAllVoies();
    Integer getNbDeVoiesBySecteur (int pSecteurId);
    Integer getHauteurMaxBySecteur (int pSecteurId);
    int[] getCotationsBySecteur (int pSecteurId);
    void updateVoie (Voie pVoie);
    void deleteVoie(int pId);


}
