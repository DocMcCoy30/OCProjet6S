package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.consumer.contract.dao.CotationDao;
import org.dmc30.OCprojet6.consumer.contract.dao.SecteurDao;
import org.dmc30.OCprojet6.model.bean.Cotation;
import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.bean.Voie;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class VoieRM implements RowMapper<Voie> {

    @Inject
    SecteurDao secteurDao;
    @Inject
    CotationDao cotationDao;

    @Override
    public Voie mapRow(ResultSet resultSet, int i) throws SQLException {
        Voie vVoie = new Voie(resultSet.getInt("voie_id"));
        vVoie.setNom(resultSet.getString("nom"));
        vVoie.setHauteur(resultSet.getInt("hauteur"));
        // utilisation de dao
        Secteur vSecteur = secteurDao.getSecteurById(resultSet.getInt("secteur_id"));
        vVoie.setSecteur(vSecteur);
        Cotation vCotation = cotationDao.getCotationById(resultSet.getInt("cotation_id"));
        vVoie.setCotation(vCotation);
        return vVoie;
    }
}
