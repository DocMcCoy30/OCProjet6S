package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.consumer.contract.dao.*;
import org.dmc30.OCprojet6.model.bean.*;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class SiteRM implements RowMapper<Site> {

    @Inject
    RegionDao regionDao;
    @Inject
    DepartementDao departementDao;
    @Inject
    VilleDao villeDao;
    @Inject
    TypeRocheDao typeRocheDao;
    @Inject
    DescriptionDao descriptionDao;

    @Override
    public Site mapRow(ResultSet resultSet, int i) throws SQLException {
        Site vSite = new Site(resultSet.getInt("site_id"));
        vSite.setId(resultSet.getInt("site_id"));
        vSite.setNom(resultSet.getString("nom"));
        vSite.setOfficiel(resultSet.getBoolean("officiel"));
        // utilisation des différentes dao pour contruire l'objet Site
        //Description
        Description vDescription = descriptionDao.getDescriptionById(resultSet.getInt("description_id"));
        vSite.setDescription(vDescription);
        //Region
        Region vRegion = regionDao.getRegionById(resultSet.getInt("region_id"));
        vSite.setRegion(vRegion);
        //Departement
        Departement vDepartement = departementDao.getDepartementByCode(resultSet.getInt("departement_code"));
        vSite.setDepartement(vDepartement);
        //Ville
        Ville vVille = villeDao.getVilleById(resultSet.getInt("ville_id"));
        vSite.setVille(vVille);
        //TypeRoche
        TypeRoche vTypeRoche = typeRocheDao.getTypeRocheById(resultSet.getInt("type_roche_id"));
        vSite.setTypeRoche(vTypeRoche);

        return vSite;
    }
}
