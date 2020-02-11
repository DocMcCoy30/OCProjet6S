package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Departement;
import org.dmc30.OCprojet6.model.bean.Region;
import org.dmc30.OCprojet6.model.bean.Ville;

import javax.inject.Named;
import java.util.List;

@Named
public class GeographicResource extends AbstractResource {

    public List<Region> getListRegions () {
        return getManagerFactory().getRegionManager().getAllRegions();
    }

    public List<Region> getMatchingRegions (String pMotCle) {
        return getManagerFactory().getRegionManager().getMatchingRegions(pMotCle);
    }

    public List<Departement> getListDepartements () {
        return getManagerFactory().getDepartementManager().getAllDepartements();
    }

    public List<Departement> getDepartementsByRegion (int pRegionId) {
        return getManagerFactory().getDepartementManager().getDepartementsByRegion(pRegionId);
    }

    public Departement getDepartementByCode(Integer pDepartementCode) {
        return getManagerFactory().getDepartementManager().getDepartementByCode(pDepartementCode);
    }

    public List<Departement> getMatchingDepartements(String pMotCle) {
        return getManagerFactory().getDepartementManager().getMatchingDepartements(pMotCle);
    }

    public List<Ville> getListVilles () {
        return getManagerFactory().getVilleManager().getAllVilles();
    }

    public List<Ville> getVillesByDepartement (int pCode) {
        return getManagerFactory().getVilleManager().getListVillesByDepartement(pCode);
    }

    public List<Ville> getMatchingVilles(String pMotCle) {
        return getManagerFactory().getVilleManager().getMatchingVilles(pMotCle);
    }
}
