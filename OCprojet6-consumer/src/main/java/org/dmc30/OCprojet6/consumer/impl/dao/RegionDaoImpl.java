package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.RegionDao;
import org.dmc30.OCprojet6.model.bean.Region;

import javax.inject.Named;
import java.util.List;

@Named
public class RegionDaoImpl extends AbstractDao implements RegionDao {

    @Override
    public void createRegion(Region pRegion) {

    }

    @Override
    public Region readRegion(int pId) {
        return null;
    }

    @Override
    public List<Region> readAllRegions() {
        return null;
    }

    @Override
    public void updateRegion(Region pRegion) {

    }

    @Override
    public void deleteRegion(int pId) {

    }
}
