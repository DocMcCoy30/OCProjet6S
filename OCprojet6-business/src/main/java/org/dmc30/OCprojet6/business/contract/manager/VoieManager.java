package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.Voie;

import java.util.List;

public interface VoieManager {

    /**
     * Enregistre un objet de type Voie dans la database
     */
    void createVoie (Voie pVoie);

    /**
     * Cherche et renvoie un objet de type Voie stocké dans la database
     * @param pId l'identifiant de l'objet recherché
     * @return l'objet recherché
     */
    Voie getVoieById (int pId);

    /**
     * Cherche et renvoie la liste des objets de type Voie stockés dans la database
     * @param pSecteurId L'identifiant du secteur.
     * @return La liste d'objet recherchée
     */
    List<Voie> getVoiesBySecteurId(int pSecteurId);

    /**
     * Cherche et renvoie la liste des objets de type Voie stockés dans la database
     * @return la liste d'objets recherchée
     */
    List<Voie> getAllVoies();

    /**
     * Modifie un objet de type Voie
     * @param pVoie : l'objet à modifier
     */
    void updateVoie (Voie pVoie);

    /**
     * Supprimer un objet de type Voie
     * @param pId : l'identifiant de l'objet à supprimer
     */
    void deleteVoie (int pId);

}
