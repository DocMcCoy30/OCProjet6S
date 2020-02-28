package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.Voie;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface VoieManager {

    /**
     * Enregistre une nouvelle voie dans la base de données.
     * @param pVoie La nouvelle voie à enregistrer.
     */
    void createVoie (Voie pVoie) throws TechnicalException;

    /**
     * Recherche une voie par son identifiant dans la base de données.
     * @param pId L'identifiant de la voie recherchée.
     * @return La voie correspondante à l'identifiant renseigné.
     */
    Voie getVoieById (int pId);

    /**
     * Cherche la liste des Voies par secteur dans la base de données.
     * @param pSecteurId L'identifiant du secteur.
     * @return La liste des voies correspondant au secteur renseigné.
     */
    List<Voie> getVoiesBySecteurId(int pSecteurId);

    /**
     * Cherche la liste de toute les voies dans la base de données.
     * @return La liste des voies
     */
    List<Voie> getAllVoies();

    /**
     * Modifie une Voie.
     * @param pVoie : La voie à modifier.
     */
    void updateVoie (Voie pVoie) throws TechnicalException;

    /**
     * Supprime une Voie.
     * @param pId L'identifiant de la voie à supprimer.
     */
    void deleteVoie (int pId);

    /**
     * Récupère la hauteur Max parmi les hauteurs des voies d'un secteur.
     * @param pSecteurId L'identifiant du secteur.
     * @return La hauteur de la voie la plus haute du secteur.
     */
    Integer getHauteurMaxBySecteur(int pSecteurId);

    /**
     * Récupère le nombre de voie pour un secteur.
     * @param pSecteurId L'identifiant du secteur.
     * @return Le nombre de voies d'un secteur.
     */
    Integer getNbDeVoiesBySecteur(int pSecteurId);

    /**
     * Récupère les identifiants des cotations Min et Max parmi les cotations de toutes les voies d'un secteur.
     * @param pSecteurId L'identifiant d'un secteur.
     * @return Les identifiants des cotations Min et Max.
     */
    int[] getCotationMinMaxBySecteur(int pSecteurId);
}
