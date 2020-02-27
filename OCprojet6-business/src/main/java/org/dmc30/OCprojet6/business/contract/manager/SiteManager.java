package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface SiteManager {

    /**
     * Enregistre un nouveau site dans la base de données.
     * @param pSite Le nouveau site à enregistrer.
     */
    Site createSite(Site pSite) throws TechnicalException;

    /**
     * Cherche un Site stocké dans la base de donnée par son identifiant.
     * @param pId L'identifiant du site recherché.
     * @return Le site correspondant à l'identifiant renseigné.
     */
    Site getSiteById(int pId);

    /**
     * Cherche dans la base de données la liste des sites correspondant à une région.
     * @param pRegionId L'identifiant de la région concernée.
     * @return La liste des sites recherchés.
     */
    List<Site> getSitesByRegion(int pRegionId);

    /**
     * Cherche dans la base de données la liste des sites correspondant à un departement.
     * @param pCode Le code du département concerné.
     * @return La liste des sites recherchés.
     */
    List<Site> getSitesByDepartement(int pCode);

    /**
     * Cherche dans la base de données la liste des sites correspondant à une ville.
     * @param pVilleId L'identifiant de la ville concernée.
     * @return La liste des sites recherchés.
     */
    List<Site> getSitesByVille(int pVilleId);

    /**
     * Cherche et renvoie la liste des sites dont le nom correspond aux termes de recherche.
     * @param pMotCle La sequence de caractères renseignée dans la zone de recherche.
     * @return La liste des sites correspondants.
     */
    List<Site> getMatchingSites (String pMotCle);

    /**
     * Cherche et renvoie la liste de tous les sites stockés dans la base de données.
     * @return La liste de tous les sites.
     */
    List<Site> getAllSites();

    /**
     * Renvoie L'identifiant du dernier site enregistré.
     * @return L'id du site.
     */
    int getLastId();

    /**
     * Modifie un Site.
     * @param pSite Le site à modifier.
     */
    void updateSite(Site pSite) throws TechnicalException;

    /**
     * Supprime un Site
     * @param pId L'identifiant du site à supprimer.
     */
    void deleteSite(int pId);
}
