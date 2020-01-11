package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.RegionManager;
import org.dmc30.OCprojet6.model.bean.Region;

import javax.inject.Named;
import java.util.List;

@Named
public class RegionManagerImpl extends AbstractManager implements RegionManager {

    @Override
    public void createRegion(Region pRegion) {

    }

    @Override
    public Region getRegionById(int pId) {
        return null;
    }

    @Override
    public List<Region> getListRegions() {
        return null;
    }

    @Override
    public void updateRegion(Region pRegion) {

    }

    @Override
    public void deleteRegion(Region pRegion) {

    }
}
