package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.RegionDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.RegionRM;
import org.dmc30.OCprojet6.model.bean.Region;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
    public Region readRegion(int pId) {
        String vSQL = "SELECT * FROM region WHERE region_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Region> regionRowMapper = new RegionRM();
        List<Region> vListRegion = vJdbcTemplate.query(vSQL, regionRowMapper);
        Region vRegion = vListRegion.get(0);
        return vRegion;
    }

    @Override
    public List<Region> readAllRegions() {
        String vSQL = "SELECT * FROM region";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Region> regionRowMapper = new RegionRM();
        List<Region> vListRegion = vJdbcTemplate.query(vSQL, regionRowMapper);
        return vListRegion;
    }

    @Override
    public void updateRegion(Region pRegion) {

    }

    @Override
    public void deleteRegion(int pId) {

    }

}
