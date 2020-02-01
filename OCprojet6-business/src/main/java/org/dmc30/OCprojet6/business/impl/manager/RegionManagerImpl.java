package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.RegionManager;
import org.dmc30.OCprojet6.model.bean.Region;

import javax.inject.Named;
import java.util.List;

@Named
public class RegionManagerImpl extends AbstractManager implements RegionManager {

    @Override
    public void createRegion(Region pRegion) {
        getDaoFactory().getRegionDao().createRegion(pRegion);

    }

    @Override
    public Region getRegionById(int pId) {
        Region vRegion = getDaoFactory().getRegionDao().getRegionById(pId);
        return vRegion;
    }

    @Override
    public List<Region> getAllRegions() {
        List<Region> vListRegion = getDaoFactory().getRegionDao().getAllRegions();
        return vListRegion;
    }

    @Override
    public void updateRegion(Region pRegion) {
        getDaoFactory().getRegionDao().updateRegion(pRegion);
    }

    @Override
    public void deleteRegion(int pId) {
        getDaoFactory().getRegionDao().deleteRegion(pId);
    }
}
