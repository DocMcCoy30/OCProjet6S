package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.SiteDao;
import org.dmc30.OCprojet6.model.bean.Site;

import javax.inject.Named;
import java.util.List;

@Named
public class SiteDaoImpl extends AbstractDao implements SiteDao {

    @Override
    public void createSite(Site pSite) {

    }

    @Override
    public Site readSite(int pId) {
        return null;
    }

    @Override
    public List<Site> readAllSites() {
        return null;
    }

    @Override
    public void updateSite(Site pSite) {

    }

    @Override
    public void deleteSite(int pId) {

    }
}
