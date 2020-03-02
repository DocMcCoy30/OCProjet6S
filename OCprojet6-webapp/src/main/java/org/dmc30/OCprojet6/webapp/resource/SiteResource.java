package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.*;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class SiteResource extends AbstractResource {

    public List<Site> getAllSites() {
        return getManagerFactory().getSiteManager().getAllSites();
    }

    public Site getSiteById(int pId) {
        return getManagerFactory().getSiteManager().getSiteById(pId);
    }

    public List<Site> getSitesByRegion(int pRegionId) {
        return getManagerFactory().getSiteManager().getSitesByRegion(pRegionId);
    }

    public List<Site> getSitesByDepartement(int pDepartementCode) {
        return getManagerFactory().getSiteManager().getSitesByDepartement(pDepartementCode);
    }

    public List<Site> getSitesByVille(int pVilleId) {
        return getManagerFactory().getSiteManager().getSitesByVille(pVilleId);
    }

    public List<Site> getMatchingSites(String pMotCle) {
        return getManagerFactory().getSiteManager().getMatchingSites(pMotCle);
    }

    public int getLastId() {
        return getManagerFactory().getSiteManager().getLastId();
    }

    /**
     * Crée un nouveau site dans la base de données.
     *
     * @param pNomSite         Le nom du site.
     * @param pDescription     La description du site.
     * @param pNomVille        Le nom de la ville.
     * @param pRegionId        L'identifiant de la région.
     * @param pDepartementCode Le code du département.
     * @param pTypeRocheId     L'identifiant du type de roche.
     * @return Le nouveau site créé.
     */
    public Site createSite(String pNomSite, String pDescription, String pNomVille,
                           int pRegionId, int pDepartementCode, int pTypeRocheId) throws TechnicalException {
        //creation d'un objet site
        Site vSite = new Site();
        //construction du nouveau site
        setSiteCommonsAttributes(pNomSite, pNomVille, pRegionId, pDepartementCode, pTypeRocheId, vSite);
        //fixation de la description
        Description vNewDescription = new Description();
        if (pDescription.isEmpty()) {
            pDescription = "Ajouter une description pour ce site.";
        }
        vNewDescription.setDescription(pDescription);
        String vInfo = pNomSite + " est un site d'escalade de type " + vSite.getTypeRoche().getNom() + ", situé à " + pNomSite +
                ", dans le département " + vSite.getDepartement().getNom() + " (" + vSite.getRegion().getNom() + ").";
        vNewDescription.setInfo(vInfo);
        vSite.setDescription(vNewDescription);
        // création du site
        getManagerFactory().getSiteManager().createSite(vSite);

        return vSite;
    }

    /**
     * Modifie un site existant dans la base de données.
     *
     * @param pSiteId          L'identifiant du site à modifier.
     * @param pNomSite         Le nom du site.
     * @param pDescription     La description du site.
     * @param pNomVille        Le nom de la ville.
     * @param pRegionId        L'identifiant de la région.
     * @param pDepartementCode Le code du département.
     * @param pTypeRocheId     L'identifiant du type de roche.
     * @return Le site modifié.
     */
    public Site updateSite(Integer pSiteId, String pNomSite,
                           Integer pDescriptionId, String pDescription,
                           String pNomVille, Integer pRegionId,
                           Integer pDepartementCode, Integer pTypeRocheId) throws TechnicalException {
        //creation d'un objet site
        Site vSite = new Site();
        //fixation de l'attribut id
        vSite.setId(pSiteId);
        setSiteCommonsAttributes(pNomSite, pNomVille, pRegionId, pDepartementCode, pTypeRocheId, vSite);
        //fixation de la description
        Description vNewDescription = new Description();
        vNewDescription.setId(pDescriptionId);
        if (pDescription.isEmpty()) {
            pDescription = "Ajouter une description pour ce site.";
        }
        vNewDescription.setDescription(pDescription);
        String vInfo = pNomSite + " est un site d'escalade de type " + vSite.getTypeRoche().getNom() + ", situé à " + pNomSite +
                ", dans le département du " + vSite.getDepartement().getNom() + " (" + vSite.getRegion().getNom() + ").";
        vNewDescription.setInfo(vInfo);
        vSite.setDescription(vNewDescription);
        //modification du site
        getManagerFactory().getSiteManager().updateSite(vSite);

        return vSite;
    }

    /**
     * Fixe les attributs d'un objet Site pour création ou modification.
     *
     * @param pNomSite         Le nom du Site.
     * @param pNomVille        Le nom de la ville.
     * @param pRegionId        L'identifiant de la région.
     * @param pDepartementCode Le code du département.
     * @param pTypeRocheId     Le type de roche.
     * @param vSite            L'objet Site à créer ou modifier.
     */
    private void setSiteCommonsAttributes(String pNomSite, String pNomVille, Integer pRegionId, Integer pDepartementCode, Integer pTypeRocheId, Site vSite) {

        //fixation de l'attribut nom
        vSite.setNom(pNomSite);
        //recuperation de la Region et fixation de l'attribut
        Region vRegion = getManagerFactory().getRegionManager().getRegionById(pRegionId);
        vSite.setRegion(vRegion);
        //recuperation du Departement et fixation de l'attribut
        Departement vDepartement = getManagerFactory().getDepartementManager().getDepartementByCode(pDepartementCode);
        vSite.setDepartement(vDepartement);
        //fixation de l'attribut ville
        Ville vVille = new Ville();
        vVille.setNom(pNomVille);
        vVille.setDepartement(vDepartement);
        //fixation de l'attribut ville
        vSite.setVille(vVille);
        //recuperation du TypeRoche et fixation de l'attribut
        TypeRoche vTypeRoche = getManagerFactory().getTypeRocheManager().getTypeRocheById(pTypeRocheId);
        vSite.setTypeRoche(vTypeRoche);
        //fixation de l'attribut officiel
        vSite.setOfficiel(false);

    }
}
