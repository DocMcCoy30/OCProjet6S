package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface SecteurManager {

    /**
     * Enregistre un nouveau Secteur dans la base de données.
     */
    void createSecteur (Secteur pSecteur) throws TechnicalException;

    /**
     * Cherche un secteur dans la base de données par son identifiant.
     * @param pId L'identifiant de du secteur recherché.
     * @return Le secteur recherché.
     */
    Secteur getSecteurById (int pId);

    /**
     * Cherche et renvoie la liste des secteurs correspondants à un site.
     * @param pSiteId L'identifiant du site.
     * @return La liste des secteurs.
     */
    List<Secteur> getSecteursBySiteId(int pSiteId);

    /**
     * Cherche et renvoie la liste de tous les secteurs stockés dans la base de données.
     * @return La liste de tous les secteurs.
     */
    List<Secteur> getAllSecteurs();

    /**
     * Modifie un secteur.
     * @param pSecteur Le secteur à modifier.
     */
    void updateSecteur (Secteur pSecteur) throws TechnicalException;

    /**
     * Supprime un secteur.
     * @param pId : L'identifiant du secteur à supprimer.
     */
    void deleteSecteur (int pId);
}
