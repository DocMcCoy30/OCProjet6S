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
        Description vDescription = new Description(resultSet.getInt("description_id"),
                resultSet.getString("description"),
                resultSet.getString("info"));

        return vDescription;
    }
}
