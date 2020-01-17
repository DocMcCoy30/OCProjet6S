package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Secteur;

import java.util.List;

public interface SecteurDao {

    void createSecteur (Secteur pSecteur);
    Secteur readSecteur (int pId);
    List<Secteur> readAllSecteurs ();
    void updateSecteur (Secteur pSecteur);
    void deleteSecteur(int pId);
}
