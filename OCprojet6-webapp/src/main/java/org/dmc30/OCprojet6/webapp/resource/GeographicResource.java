package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Departement;
import org.dmc30.OCprojet6.model.bean.Region;
import org.dmc30.OCprojet6.model.bean.Ville;

import javax.inject.Named;
import java.util.List;

@Named
public class GeographicResource extends AbstractResource {

    public List<Region> getListRegions () {
        return getManagerFactory().getRegionManager().getListRegions();
    }

    public List<Departement> getDepartementsByRegion (int pRegionId) {
        return getManagerFactory().getDepartementManager().getDepartementsByRegion(pRegionId);
    }

    public List<Ville> getListVillesByDepartement (String pCode) {
        return getManagerFactory().getVilleManager().getListVillesByDepartement(pCode);
    }
}
