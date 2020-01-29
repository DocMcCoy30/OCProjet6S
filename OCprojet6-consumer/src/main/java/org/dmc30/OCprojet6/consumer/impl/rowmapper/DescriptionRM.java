package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.model.bean.Description;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class DescriptionRM implements RowMapper<Description> {

    @Override
    public Description mapRow(ResultSet resultSet, int i) throws SQLException {
        Description vDescription = new Description(resultSet.getInt("description_id"));
        vDescription.setId(resultSet.getInt("description_id"));
        vDescription.setDescription(resultSet.getString("description"));
        vDescription.setInfo(resultSet.getString("info"));
        return vDescription;
    }
}
