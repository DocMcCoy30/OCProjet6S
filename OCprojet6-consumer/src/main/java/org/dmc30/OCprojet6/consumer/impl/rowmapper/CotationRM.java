package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.model.bean.Cotation;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class CotationRM implements RowMapper<Cotation> {
    @Override
    public Cotation mapRow(ResultSet resultSet, int i) throws SQLException {
        Cotation vCotation = new Cotation(resultSet.getInt("cotation_id"), resultSet.getString("valeur"));
        return vCotation;
    }
}
