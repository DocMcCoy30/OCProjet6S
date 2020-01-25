package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.consumer.contract.dao.SecteurDao;
import org.dmc30.OCprojet6.consumer.contract.dao.SiteDao;
import org.dmc30.OCprojet6.consumer.contract.dao.VoieDao;
import org.dmc30.OCprojet6.model.bean.Photo;
import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.bean.Voie;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class PhotoRM implements RowMapper<Photo> {

    @Inject
    SiteDao siteDao;
    @Inject
    SecteurDao secteurDao;
    @Inject
    VoieDao voieDao;

    @Override
    public Photo mapRow(ResultSet resultSet, int i) throws SQLException {
        Photo vPhoto = new Photo(resultSet.getInt("photo_id"));
        vPhoto.setNom(resultSet.getString("nom"));
        // utilisation de dao
        Site vSite = siteDao.getSiteById(resultSet.getInt("site_id"));
        vPhoto.setSite(vSite);
        Secteur vSecteur = secteurDao.getSecteurById(resultSet.getInt("secteur_id"));
        vPhoto.setSecteur(vSecteur);
        Voie vVoie = voieDao.getVoieById(resultSet.getInt("voie_id"));
        vPhoto.setVoie(vVoie);
        return vPhoto;
    }
}
