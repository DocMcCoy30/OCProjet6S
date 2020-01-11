package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.model.bean.Caracteristique;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class CaracteristiqueRM implements RowMapper<Caracteristique> {

    @Override
    public Caracteristique mapRow(ResultSet resultSet, int i) throws SQLException {
        Caracteristique vCaracteristique = new Caracteristique(resultSet.getInt("caracteristique_id"));
        vCaracteristique.setNom(resultSet.getString("nom"));
        vCaracteristique.setDefinition(resultSet.getString("definition"));
        return vCaracteristique;
    }
}
