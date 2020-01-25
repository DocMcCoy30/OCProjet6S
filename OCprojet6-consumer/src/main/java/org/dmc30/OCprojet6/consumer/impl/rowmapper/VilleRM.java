package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.consumer.contract.dao.DepartementDao;
import org.dmc30.OCprojet6.model.bean.Departement;
import org.dmc30.OCprojet6.model.bean.Ville;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class VilleRM implements RowMapper<Ville> {

    @Inject
    DepartementDao departementDao;

    @Override
    public Ville mapRow(ResultSet resultSet, int i) throws SQLException {
        Ville vVille = new Ville(resultSet.getInt("ville_id"));
        vVille.setId(resultSet.getInt("ville_id"));
        vVille.setNom(resultSet.getString("nom"));
        // utilisation de departementDao avec departement_code
        Departement vDepartement = departementDao.getDepartementByCode(resultSet.getInt("departement_code"));
        vVille.setDepartement(vDepartement);
        return vVille;
    }
}
