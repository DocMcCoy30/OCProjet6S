package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.Region;

import java.util.List;

public interface RegionManager {

    /**
     * Enregistre un objet de type Region dans la database
     */
    void createRegion (Region pRegion);

    /**
     * Cherche et renvoie un objet de type Region stocké dans la database
     * @param pId l'identifiant de l'objet recherché
     * @return l'objet recherché
     */
    Region getRegionById (int pId);

    /**
     * Cherche et renvoie la liste des objets de type Region stockés dans la database
     * @return la liste d'objets recherchée
     */
    List<Region> getAllRegions();

    /**
     * Modifie un objet de type Region
     * @param pRegion : l'objet à modifier
     */
    void updateRegion (Region pRegion);

    /**
     * Supprimer un objet de type Region
     * @param pId : l'identifiant de l'objet à supprimer
     */
    void deleteRegion (int pId);
}
