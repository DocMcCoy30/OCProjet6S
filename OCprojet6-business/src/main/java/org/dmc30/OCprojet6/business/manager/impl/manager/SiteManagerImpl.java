package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.SiteManager;
import org.dmc30.OCprojet6.model.bean.Site;

import javax.inject.Named;
import java.util.List;

@Named
public class SiteManagerImpl extends AbstractManager implements SiteManager {

    @Override
    public void createSite(Site pSite) {
        getDaoFactory().getSiteDao().createSite(pSite);

    }

    @Override
    public Site getSiteById(int pId) {
        Site vSite = getDaoFactory().getSiteDao().getSiteById(pId);
        return vSite;
    }

    @Override
    public List<Site> getSitesByRegion (int pRegionId) {
        return getDaoFactory().getSiteDao().getSitesByRegion(pRegionId);
    }

    public List<Site> getSitesByDepartement (int pCode) {
        return getDaoFactory().getSiteDao().getSitesByDepartement(pCode);
    }

    public List<Site> getSitesByVille (int pVilleId) {
        return getDaoFactory().getSiteDao().getSitesByVille(pVilleId);
    }

    @Override
    public List<Site> getAllSites() {
        List<Site> vListSite = getDaoFactory().getSiteDao().getAllSites();
        return vListSite;
    }

    @Override
    public void updateSite(Site pSite) {
        getDaoFactory().getSiteDao().updateSite(pSite);
    }

    @Override
    public void deleteSite(int pId) {
        getDaoFactory().getSiteDao().deleteSite(pId);
    }
}
