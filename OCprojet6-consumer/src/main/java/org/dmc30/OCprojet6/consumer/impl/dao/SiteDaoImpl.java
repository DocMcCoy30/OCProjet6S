package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.SiteDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.SiteRM;
import org.dmc30.OCprojet6.model.bean.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;

@Named
public class SiteDaoImpl extends AbstractDao implements SiteDao {

    @Inject
    SiteRM siteRM;

    @Override
    public void createSite(Site pSite) {
        String vSQL = "INSERT INTO site (nom, description_id, officiel, type_roche_id, region_id, departement_code, ville_id) VALUES (?,?,?,?,?,?,?)";
        Object[] vParams = {
                new SqlParameterValue(Types.VARCHAR, pSite.getNom()),
                new SqlParameterValue(Types.INTEGER, pSite.getDescription().getId()),
                new SqlParameterValue(Types.BOOLEAN, pSite.isOfficiel()),
                new SqlParameterValue(Types.INTEGER, pSite.getTypeRoche().getId()),
                new SqlParameterValue(Types.INTEGER, pSite.getRegion().getId()),
                new SqlParameterValue(Types.INTEGER, pSite.getDepartement().getCode()),
                new SqlParameterValue(Types.INTEGER, pSite.getVille().getId()),
        };
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public Site getSiteById(int pId) {
        String vSQL = "SELECT * FROM site WHERE site_id=" + pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Site> vListSites = vJdbcTemplate.query(vSQL, siteRM);
        return vListSites.get(0);
    }

    @Override
    public List<Site> getSitesByRegion(int pRegionId) {
        String vSQL = "SELECT * FROM site WHERE region_id=" + pRegionId + " ORDER BY nom";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, siteRM);
    }

    @Override
    public List<Site> getSitesByDepartement(int pCode) {
        String vSQL = "SELECT * FROM site WHERE departement_code=" + pCode + " ORDER BY nom";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, siteRM);
    }

    @Override
    public List<Site> getSitesByVille(int pVilleId) {
        String vSQL = "SELECT * FROM site WHERE ville_id=" + pVilleId + " ORDER BY nom";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, siteRM);
    }

    @Override
    public List<Site> getMatchingSites(String pMotCle) {
        String vMotCle = "%"+pMotCle+"%";
        String vSQL = "SELECT * FROM site WHERE nom ILIKE :motCle";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("motCle", vMotCle);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        List<Site> vListSites = vJdbcTemplate.query(vSQL, vParams, siteRM);
        return vListSites;
    }

    @Override
    public List<Site> getAllSites() {
        String vSQL = "SELECT * FROM site ORDER BY nom";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, siteRM);
    }

    @Override
    public int getLastId() {
        String vSQL = "SELECT MAX(site_id) FROM site";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.queryForObject(vSQL, Integer.TYPE);
    }

    @Override
    public void updateSite(Site pSite) {
        String vSQL = "UPDATE site SET nom= :vNom, description_id= :vDescriptionId, officiel= :vOfficiel," +
                " type_roche_id= :vTypeRocheId, region_id= :vRegionId, departement_code= :vDepartementCode," +
                " ville_id= :vVilleId WHERE site_id= :vSiteId";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("vSiteId", pSite.getId());
        vParams.addValue("vNom", pSite.getNom());
        vParams.addValue("vDescriptionId", pSite.getDescription().getId());
        vParams.addValue("vOfficiel", pSite.isOfficiel());
        vParams.addValue("vTypeRocheId", pSite.getTypeRoche().getId());
        vParams.addValue("vRegionId", pSite.getRegion().getId());
        vParams.addValue("vDepartementCode", pSite.getDepartement().getCode());
        vParams.addValue("vVilleId", pSite.getVille().getId());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);
    }

    @Override
    public void deleteSite(int pId) {

    }

}
