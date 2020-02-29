package org.dmc30.OCprojet6.consumer.impl.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.consumer.contract.dao.SecteurDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.SecteurRM;
import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.exception.ErrorMessages;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SecteurDaoImpl extends AbstractDao implements SecteurDao {

    Logger logger = LogManager.getLogger(SecteurDaoImpl.class);

    @Inject
    SecteurRM secteurRM;

    @Override
    public void createSecteur(Secteur pSecteur) throws TechnicalException {
        String vSQL = "INSERT INTO secteur (nom, description, site_id) VALUES (:nom, :description, :siteId)";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", pSecteur.getNom());
        vParams.addValue("description", pSecteur.getDescription());
        vParams.addValue("siteId", pSecteur.getSite().getId());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        try {
            vJdbcTemplate.update(vSQL, vParams);
        } catch (
                BadSqlGrammarException e) {
            logger.error("Problème de syntaxe dans la requète SQL");
            throw new TechnicalException(ErrorMessages.SQL_SYNTAX_ERROR.getErrorMessage());
        } catch (
                DataAccessException e) {
            logger.error("Problème d'accès à la base de données");
            throw new TechnicalException(ErrorMessages.SQL_UPDATE_ERROR.getErrorMessage());
        } catch (Exception e) {
            logger.error("Problème technique");
            throw new TechnicalException(ErrorMessages.TECHNICAL_ERROR.getErrorMessage());
        }
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
        String vSQL = "SELECT * FROM secteur WHERE site_id= :vSiteId ORDER BY nom";
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
    public void updateSecteur(Secteur pSecteur) throws TechnicalException {
        String vSQL = "UPDATE secteur SET nom= :vNom, description= :vDescription WHERE secteur_id= :vSecteurId";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("vNom", pSecteur.getNom());
        vParams.addValue("vDescription", pSecteur.getDescription());
        vParams.addValue("vSecteurId", pSecteur.getId());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        try {
            vJdbcTemplate.update(vSQL, vParams);
        } catch (
                BadSqlGrammarException e) {
            logger.error("Problème de syntaxe dans la requète SQL");
            throw new TechnicalException(ErrorMessages.SQL_SYNTAX_ERROR.getErrorMessage());
        } catch (
                DataAccessException e) {
            logger.error("Problème d'accès à la base de données");
            throw new TechnicalException(ErrorMessages.SQL_UPDATE_ERROR.getErrorMessage());
        } catch (Exception e) {
            logger.error("Problème technique");
            throw new TechnicalException(ErrorMessages.TECHNICAL_ERROR.getErrorMessage());
        }
    }

    @Override
    public void deleteSecteur(int pId) {

    }

}
