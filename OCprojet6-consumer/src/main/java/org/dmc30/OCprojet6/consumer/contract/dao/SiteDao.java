package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Site;

import java.util.List;

public interface SiteDao {

    void createSite (Site pSite);
    Site readSite (int pId);
    List<Site> readAllSites ();
    void updateSite (Site pSite);
    void deleteSite(int pId);
}
