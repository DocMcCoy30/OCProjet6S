package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Site;

import java.util.List;

public interface SiteDao {

    void createSite (Site pSite);
    List<Site> getAllSites();
    Site getSiteById(int pId);
    List<Site> getSitesByRegion (int pRegionId);
    List<Site> getSitesByDepartement (int pCode);
    List<Site> getSitesByVille (int pVilleId);
    List<Site> getMatchingSites (String pMotCle);
    int getLastId();
    void updateSite (Site pSite);
    void deleteSite(int pId);
}
