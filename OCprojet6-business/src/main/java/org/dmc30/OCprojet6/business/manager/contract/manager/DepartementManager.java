package org.dmc30.OCprojet6.business.manager.contract.manager;

import org.dmc30.OCprojet6.model.bean.Departement;

import java.util.List;

public interface DepartementManager {

    /**
     * Enregistre un objet de type Departement dans la database
     */
    void createDepartement (Departement pDepartement);

    /**
     * Cherche et renvoie un objet de type Departement stocké dans la database
     * @param pCode le code de l'objet recherché
     * @return l'objet recherché
     */
    Departement getDepartementByCode (int pCode);

    /**
     * Cherche et renvoie la liste des Département par région stockée dans la database
     * @param pRegionId l'identifiant de la region
     * @return la liste d'objets recherchée
     */
    List<Departement> getDepartementsByRegion (int pRegionId);

    /**
     * Cherche et renvoie la liste des objets de type Departement stockés dans la database
     * @return la liste d'objets recherchée
     */
    List<Departement> getAllDepartements();

    /**
     * Modifie un objet de type Departement
     * @param pDepartement : l'objet à modifier
     */
    void updateDepartement (Departement pDepartement);

    /**
     * Supprimer un objet de type Departement
     * @param pId : l'identifiant de l'objet à supprimer
     */
    void  deleteDepartement (int pId);
}
