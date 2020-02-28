package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Voie;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface VoieDao {

    void createVoie (Voie pVoie) throws TechnicalException;
    Voie getVoieById(int pId);
    List<Voie> getVoiesBySecteurId(int pSecteurId);
    List<Voie> getAllVoies();
    Integer getNbDeVoiesBySecteur (int pSecteurId);
    Integer getHauteurMaxBySecteur (int pSecteurId);
    int[] getCotationsMinMaxBySecteur(int pSecteurId);
    void updateVoie (Voie pVoie) throws TechnicalException;
    void deleteVoie(int pId);


}
