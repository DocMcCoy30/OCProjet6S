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
        Site vSite = getDaoFactory().getSiteDao().readSite(pId);
        return vSite;
    }

    @Override
    public List<Site> getListSites () {
        List<Site> vListSite = getDaoFactory().getSiteDao().readAllSites();
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
