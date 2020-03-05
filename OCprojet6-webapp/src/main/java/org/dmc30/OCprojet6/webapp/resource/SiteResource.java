package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.*;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class SiteResource extends AbstractResource {

    /**
     * Cherche et renvoie tous les sites stockés dans la base de données.
     * @return La liste de tous les sites.
     */
    public List<Site> getAllSites() {
        return getManagerFactory().getSiteManager().getAllSites();
    }

    /**
     * Cherche un site par son identifiant.
     * @param pId L'identifiant du site.
     * @return Le site conserné.
     */
    public Site getSiteById(int pId) {
        return getManagerFactory().getSiteManager().getSiteById(pId);
    }

    /**
     * Cherche et renvoie la liste des sites pour une région.
     * @param pRegionId L'identifiant de la région concernée.
     * @return Une liste de sites.
     */
    public List<Site> getSitesByRegion(int pRegionId) {
        return getManagerFactory().getSiteManager().getSitesByRegion(pRegionId);
    }

    /**
     * Cherche et renvoie la liste des sites pour un département.
     * @param pDepartementCode Le code du département concerné.
     * @return Une liste de sites.
     */
    public List<Site> getSitesByDepartement(int pDepartementCode) {
        return getManagerFactory().getSiteManager().getSitesByDepartement(pDepartementCode);
    }

    /**
     * Cherche et renvoie la liste des sites pour une ville.
     * @param pVilleId L'identifiant de la ville concernée.
     * @return Une liste de sites.
     */
    public List<Site> getSitesByVille(int pVilleId) {
        return getManagerFactory().getSiteManager().getSitesByVille(pVilleId);
    }

    /**
     * Cherche et renvoie les sites correspondants à un mot-clé.
     * @param pMotCle Le mot clé critère de recherche.
     * @return La liste des sites correspondants à la recherche.
     */
    public List<Site> getMatchingSites(String pMotCle) {
        return getManagerFactory().getSiteManager().getMatchingSites(pMotCle);
    }

    /**
     * Cherche et renvoie l'identifiant du dernier site créé.
     * @return L'identifiant.
     */
    public int getLastId() {
        return getManagerFactory().getSiteManager().getLastId();
    }

    /**
     * Crée un nouveau site dans la base de données.
     *
     * @param pSite Le site à créer.
     * @return Le nouveau site créé.
     */
    public Site createSite (Site pSite) throws TechnicalException {
        Site vSite = getManagerFactory().getSiteManager().createSite(pSite);
        return vSite;
    }

    /**
     * Modifie un site existant dans la base de données.
     *
     * @param pSite Le site à modifier.
     * @return Le site modifié.
     */
    public Site updateSite (Site pSite) throws TechnicalException {
        Site vSite = getManagerFactory().getSiteManager().updateSite(pSite);
        return vSite;
    }
}
