package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.RegionDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.RegionRM;
import org.dmc30.OCprojet6.model.bean.Region;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class RegionDaoImpl extends AbstractDao implements RegionDao {

    @Inject
    RegionRM regionRM;

    @Override
    public void createRegion(Region pRegion) {

    }

    @Override
    public Region getRegionById(int pId) {
        String vSQL = "SELECT * FROM region WHERE region_id= :vId";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("vId", pId);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        List<Region> vListRegion = vJdbcTemplate.query(vSQL, vParams, regionRM);
        Region vRegion = vListRegion.get(0);
        return vRegion;
    }

    @Override
    public List<Region> getAllRegions() {
        String vSQL = "SELECT * FROM region ORDER BY nom";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Region> vListRegion = vJdbcTemplate.query(vSQL, regionRM);
        return vListRegion;
    }

    @Override
    public void updateRegion(Region pRegion) {

    }

    @Override
    public void deleteRegion(int pId) {

    }

}
