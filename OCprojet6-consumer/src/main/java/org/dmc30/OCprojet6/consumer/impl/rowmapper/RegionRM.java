package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.model.bean.Region;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class RegionRM implements RowMapper<Region> {

    @Override
    public Region mapRow(ResultSet resultSet, int i) throws SQLException {
        Region vRegion = new Region(resultSet.getInt("region_id"));
        vRegion.setNom(resultSet.getString("nom"));
        return vRegion;
    }
}
