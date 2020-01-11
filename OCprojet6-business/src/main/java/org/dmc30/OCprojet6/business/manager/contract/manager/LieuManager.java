package org.dmc30.OCprojet6.business.manager.contract.manager;

import org.dmc30.OCprojet6.model.bean.Lieu;

import java.util.List;

public interface LieuManager {

    /**
     * Enregistre un objet de type Lieu dans la database
     */
    void createLieu (Lieu pLieu);

    /**
     * Cherche et renvoie un objet de type Lieu stocké dans la database
     * @param pId l'identifiant de l'objet recherché
     * @return l'objet recherché
     */
    Lieu getLieuById (int pId);

    /**
     * Cherche et renvoie la liste des objets de type Lieu stockés dans la database
     * @return la liste d'objets recherchée
     */
    List<Lieu> getListLieux ();

    /**
     * Modifie un objet de type Lieu
     * @param pLieu : l'objet à modifier
     */
    void updateLieu (Lieu pLieu);

    /**
     * Supprimer un objet de type Lieu
     * @param pId : l'identifiant de l'objet à supprimer
     */
    void deleteLieu (int pId);
}
