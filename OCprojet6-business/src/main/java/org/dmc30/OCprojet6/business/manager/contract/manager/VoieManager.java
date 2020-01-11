package org.dmc30.OCprojet6.business.manager.contract.manager;

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
     * @return la liste d'objets recherchée
     */
    List<Voie> getListVoies ();

    /**
     * Modifie un objet de type Voie
     * @param pVoie : l'objet à modifier
     */
    void updateVoie (Voie pVoie);

    /**
     * Supprimer un objet de type Voie
     * @param pVoie : l'objet à supprimer
     */
    void deleteVoie (Voie pVoie);
}
