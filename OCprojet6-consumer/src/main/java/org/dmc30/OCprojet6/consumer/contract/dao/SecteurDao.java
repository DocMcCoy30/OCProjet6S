package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface SecteurDao {

    void createSecteur (Secteur pSecteur) throws TechnicalException;
    Secteur getSecteurById(int pId);
    List<Secteur> getSecteursBySiteId (int pSiteId);
    List<Secteur> getAllSecteurs();
    void updateSecteur (Secteur pSecteur) throws TechnicalException;
    void deleteSecteur(int pId);
}
