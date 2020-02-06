package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.*;

import javax.inject.Named;
import java.util.List;

@Named
public class SiteResource extends AbstractResource {

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

    public List<Site> searchSites(int pSiteId, int pRegionId, int pDepartementCode, int pVilleId) {
        return getManagerFactory().getSiteManager().searchSites(pSiteId, pRegionId, pDepartementCode, pVilleId);
    }

    public List<Site> getListSites() {
        return getManagerFactory().getSiteManager().getAllSites();
    }

    public int getLastId () {
        return getManagerFactory().getSiteManager().getLastId();
    }

    public Site createSite(String pNomSite, String pDescription, String pNomVille,
                           int pRegionId, int pDepartementCode, int pTypeRocheId) {
        //creation d'un objet site
        Site vNewSite = new Site();
        //fixation de l'attribut nom
        vNewSite.setNom(pNomSite);
        //recuperation de la Region et fixation de l'attribut
        Region vRegion = getManagerFactory().getRegionManager().getRegionById(pRegionId);
        vNewSite.setRegion(vRegion);
        //recuperation du Departement et fixation de l'attribut
        Departement vDepartement = getManagerFactory().getDepartementManager().getDepartementByCode(pDepartementCode);
        vNewSite.setDepartement(vDepartement);
        //creation de la nouvelle ville (sans id)
        Ville vNewVille = new Ville();
        vNewVille.setNom(pNomVille);
        vNewVille.setDepartement(vDepartement);
        //fixation de l'attribut ville
        vNewSite.setVille(vNewVille);
        //recuperation du TypeRoche et fixation de l'attribut
        TypeRoche vTypeRoche = getManagerFactory().getTypeRocheManager().getTypeRocheById(pTypeRocheId);
        vNewSite.setTypeRoche(vTypeRoche);
        //fixation de l'attribut officiel
        vNewSite.setOfficiel(false);
        //création de la description et fixation de l'attribut
        Description vNewDescription = new Description();
        if (pDescription.isEmpty()) {
            pDescription = "Ajouter une description pour ce site.";
        }
        vNewDescription.setDescription(pDescription);
        String vInfo = pNomSite + " est un site d'escalade de type " + vTypeRoche.getNom() + ", situé à " + pNomSite +
                ", dans le département du " + vDepartement.getNom() + " (" + vRegion.getNom() + ").";
        vNewDescription.setInfo(vInfo);
        vNewSite.setDescription(vNewDescription);

        getManagerFactory().getSiteManager().createSite(vNewSite);

        return vNewSite;
    }
}
