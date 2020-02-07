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

    //debug
    public Region getRegionById (int pId) {
        return getManagerFactory().getRegionManager().getRegionById(pId);
    }

    public List<Departement> getListDepartements () {
        return getManagerFactory().getDepartementManager().getAllDepartements();
    }

    public List<Departement> getDepartementsByRegion (int pRegionId) {
        return getManagerFactory().getDepartementManager().getDepartementsByRegion(pRegionId);
    }

    public List<Ville> getListVilles () {
        return getManagerFactory().getVilleManager().getAllVilles();
    }

    public List<Ville> getVillesByDepartement (String pCode) {
        return getManagerFactory().getVilleManager().getListVillesByDepartement(pCode);
    }

    public Departement getDepartementByCode(Integer pDepartementCode) {
        return getManagerFactory().getDepartementManager().getDepartementByCode(pDepartementCode);
    }
}
