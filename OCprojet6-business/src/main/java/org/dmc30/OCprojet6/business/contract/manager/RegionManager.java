package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.Region;

import java.util.List;

public interface RegionManager {

    /**
     * Enregistre un objet de type Region dans la database.
     */
    void createRegion (Region pRegion);

    /**
     * Cherche une région par son identifiant.
     * @param pId L'identifiant de la région recherchée.
     * @return La région recherchée.
     */
    Region getRegionById (int pId);

    /**
     * Cherche et renvoie la liste des regions dont le nom correspond aux termes de recherche.
     * @param pMotCle la sequence de caractères renseignée dans la zone de recherche.
     * @return la liste des regions correspondantes.
     */
    List<Region> getMatchingRegions(String pMotCle);

    /**
     * Cherche et renvoie la liste de toutes les régions.
     * @return Le liste de toutes les régions.
     */
    List<Region> getAllRegions();

    /**
     * Modifie un objet de type Region.
     * @param pRegion L'objet à modifier.
     */
    void updateRegion (Region pRegion);

    /**
     * Supprime un objet de type Region.
     * @param pId : L'identifiant de l'objet à supprimer.
     */
    void deleteRegion (int pId);
}
