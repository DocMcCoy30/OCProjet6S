package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.SiteDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.SiteRM;
import org.dmc30.OCprojet6.model.bean.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SiteDaoImpl extends AbstractDao implements SiteDao {

    @Inject
    SiteRM siteRM;

    @Override
    public void createSite(Site pSite) {

    }

    @Override
    public Site getSiteById(int pId) {
        String vSQL = "SELECT * FROM site WHERE site_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Site> vListSites = vJdbcTemplate.query(vSQL, siteRM);
        Site vSite = vListSites.get(0);
        return vSite;
    }

    @Override
    public List<Site> getSitesByRegion(int pRegionId) {
        String vSQL = "SELECT * FROM site WHERE region_id="+pRegionId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Site> vListSites = vJdbcTemplate.query(vSQL, siteRM);
        return vListSites;
    }

    @Override
    public List<Site> getSitesByDepartement(String pCode) {
        String vSQL = "SELECT * FROM site WHERE departement_code="+pCode;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Site> vListSites = vJdbcTemplate.query(vSQL, siteRM);
        return vListSites;
    }

    @Override
    public List<Site> getSitesByVille(int pVilleId) {
        String vSQL = "SELECT * FROM site WHERE ville_id="+pVilleId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Site> vListSites = vJdbcTemplate.query(vSQL, siteRM);
        return vListSites;
    }

    @Override
    public List<Site> getAllSites() {
        String vSQL = "SELECT * FROM site";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Site> vListSites = vJdbcTemplate.query(vSQL, siteRM);
        return vListSites;
    }

    @Override
    public void updateSite(Site pSite) {

    }

    @Override
    public void deleteSite(int pId) {

    }

}
