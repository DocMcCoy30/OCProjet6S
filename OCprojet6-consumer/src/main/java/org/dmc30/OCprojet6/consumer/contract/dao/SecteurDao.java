package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Secteur;

import java.util.List;

public interface SecteurDao {

    void createSecteur (Secteur pSecteur);
    Secteur getSecteurById(int pId);
    List<Secteur> getSecteursBySiteId (int pSiteId);
    List<Secteur> getAllSecteurs();
    void updateSecteur (Secteur pSecteur);
    void deleteSecteur(int pId);
}
