package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.TypeRoche;

import java.util.List;

public interface TypeRocheManager {

    /**
     * Enregistre un objet de type TypeRoche dans la database
     */
    void createTypeRoche (TypeRoche pTypeRoche);

    /**
     * Cherche et renvoie un objet de type TypeRoche stocké dans la database
     * @param pId l'identifiant de l'objet recherché
     * @return l'objet recherché
     */
    TypeRoche getTypeRocheById (int pId);

    /**
     * Cherche et renvoie la liste des objets de type TypeRoche stockés dans la database
     * @return la liste d'objets recherchée
     */
    List<TypeRoche> getAllTypeRoches();

    /**
     * Modifie un objet de type TypeRoche
     * @param pTypeRoche : l'objet à modifier
     */
    void updateTypeRoche (TypeRoche pTypeRoche);

    /**
     * Supprimer un objet de type TypeRoche
     * @param pId : l'identifiant de l'objet à supprimer
     */
    void  deleteTypeRoche (int pId);
}
