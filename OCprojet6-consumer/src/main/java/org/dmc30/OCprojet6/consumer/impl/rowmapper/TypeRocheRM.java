package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.model.bean.TypeRoche;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class TypeRocheRM implements RowMapper<TypeRoche> {

    @Override
    public TypeRoche mapRow(ResultSet resultSet, int i) throws SQLException {
        TypeRoche vTypeRoche = new TypeRoche(resultSet.getInt("type_roche_id"));
        vTypeRoche.setId(resultSet.getInt("type_roche_id"));
        vTypeRoche.setNom(resultSet.getString("nom"));
        return vTypeRoche;
    }
}
