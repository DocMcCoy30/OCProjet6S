package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Region;

import javax.inject.Named;
import java.util.List;

@Named
public class RegionResource extends AbstractResource{

    public List<Region> getListRegions () {
       return getManagerFactory().getRegionManager().getListRegions();
    }
}
