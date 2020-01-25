package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Region;

import java.util.List;

public interface RegionDao {

    void createRegion (Region pRegion);
    Region getRegionById(int pId);
    List<Region> getAllRegions();
    void updateRegion (Region pRegion);
    void deleteRegion(int pId);
}
