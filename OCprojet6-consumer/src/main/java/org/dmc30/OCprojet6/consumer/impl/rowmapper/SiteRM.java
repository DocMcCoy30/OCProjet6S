package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.consumer.contract.dao.*;
import org.dmc30.OCprojet6.model.bean.Departement;
import org.dmc30.OCprojet6.model.bean.Region;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.bean.Ville;
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
    SecteurDao secteurDao;
    @Inject
    CommentaireDao commentaireDao;
    @Inject
    PhotoDao photoDao;
    @Inject
    TopoDao topoDao;

    @Override
    public Site mapRow(ResultSet resultSet, int i) throws SQLException {
        Site vSite = new Site(resultSet.getInt("site_id"));
        vSite.setNom(resultSet.getString("nom"));
        vSite.setDescription(resultSet.getString("description"));
        vSite.setNbDeSecteurs(resultSet.getInt("nb_de_secteurs"));
        vSite.setNbDeVoies(resultSet.getInt("nb_de_voies"));
        vSite.setHauteur(resultSet.getInt("hauteur"));
        vSite.setOfficiel(resultSet.getBoolean("officiel"));
        // utilisation des dao pour contruire l'objet Site
        Region vRegion = regionDao.getRegionById(resultSet.getInt("region_id"));
        vSite.setRegion(vRegion);
        Departement vDepartement = departementDao.getDepartementByCode(resultSet.getInt("departement_code"));
        vSite.setDepartement(vDepartement);
        Ville vVille = villeDao.getVilleById(resultSet.getInt("ville_id"));
        vSite.setVille(vVille);

        return vSite;
    }
}
