package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.consumer.contract.dao.RegionDao;
import org.dmc30.OCprojet6.model.bean.Departement;
import org.dmc30.OCprojet6.model.bean.Region;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class DepartementRM implements RowMapper<Departement> {

    @Inject
    RegionDao regionDao;

    @Override
    public Departement mapRow(ResultSet resultSet, int i) throws SQLException {
        Departement vDepartement = new Departement(resultSet.getInt("code"));
        vDepartement.setNom(resultSet.getString("nom"));
        // utilisation de regionDao avec region_id
        Region vRegion = regionDao.getRegionById(resultSet.getInt("region_id"));
        vDepartement.setRegion(vRegion);
        return vDepartement;
    }
}