package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.SecteurDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.SecteurRM;
import org.dmc30.OCprojet6.model.bean.Secteur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SecteurDaoImpl extends AbstractDao implements SecteurDao {

    @Inject
    SecteurRM secteurRM;

    @Override
    public void createSecteur(Secteur pSecteur) {
        String vSQL = "INSERT INTO secteur (nom, description, site_id) VALUES (:nom, :description, :siteId)";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", pSecteur.getNom());
        vParams.addValue("description", pSecteur.getDescription());
        vParams.addValue("siteId", pSecteur.getSite().getId());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);
    }

    @Override
    public Secteur getSecteurById(int pId) {
        String vSQL = "SELECT * FROM secteur WHERE secteur_id= :vId ORDER BY nom";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("vId", pId);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        List<Secteur> vListSecteurs = vJdbcTemplate.query(vSQL, vParams, secteurRM);
        return vListSecteurs.get(0);
    }

    @Override
    public List<Secteur> getSecteursBySiteId(int pSiteId) {
        String vSQL = "SELECT * FROM secteur WHERE site_id= :vSiteId";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("vSiteId", pSiteId);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, vParams, secteurRM);
    }

    @Override
    public List<Secteur> getAllSecteurs() {
        String vSQL = "SELECT * FROM secteur ORDER BY nom";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, secteurRM);
    }

    @Override
    public void updateSecteur(Secteur pSecteur) {

    }

    @Override
    public void deleteSecteur(int pId) {

    }

}
