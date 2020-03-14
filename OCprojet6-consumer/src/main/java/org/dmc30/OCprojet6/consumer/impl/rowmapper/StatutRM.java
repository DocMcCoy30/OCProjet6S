package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.model.bean.Statut;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class StatutRM implements RowMapper<Statut> {

    @Override
    public Statut mapRow(ResultSet resultSet, int i) throws SQLException {
        Statut vStatut = new Statut(resultSet.getInt("id"),
                resultSet.getString("etat"));
        return vStatut;
    }
}
