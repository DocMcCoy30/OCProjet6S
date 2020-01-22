package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.consumer.contract.dao.DepartementDao;
import org.dmc30.OCprojet6.model.bean.Departement;
import org.dmc30.OCprojet6.model.bean.Ville;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VilleRM implements RowMapper<Ville> {

    @Inject
    DepartementDao departementDao;

    @Override
    public Ville mapRow(ResultSet resultSet, int i) throws SQLException {
        Ville vVille = new Ville(resultSet.getInt("ville_id"));
        vVille.setNom(resultSet.getString("nom"));
        // utilisation de departementDao avec departement_code
        String vcode = resultSet.getString("departement_code");
        Departement vDepartement = departementDao.readDepartement(vcode);
        vVille.setDepartement(vDepartement);
        return vVille;
    }
}
