package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.SiteManager;
import org.dmc30.OCprojet6.model.bean.Site;

import javax.inject.Named;
import java.util.List;

@Named
public class SiteManagerImpl extends AbstractManager implements SiteManager {

    @Override
    public void createSite(Site pSite) {
    }

    @Override
    public Site getSiteById(int pId) {
        return null;
    }

    @Override
    public List<Site> getlistSites() {
        return null;
    }

    @Override
    public void updateSite(Site pSite) {
    }

    @Override
    public void deleteSite(Site pSite) {
    }
}
