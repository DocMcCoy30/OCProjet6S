package org.dmc30.OCprojet6.consumer.impl.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.consumer.contract.dao.VoieDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.VoieRM;
import org.dmc30.OCprojet6.model.bean.Voie;
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
public class VoieDaoImpl extends AbstractDao implements VoieDao {

    Logger logger = LogManager.getLogger(VoieDaoImpl.class);

    @Inject
    VoieRM voieRM;

    @Override
    public void createVoie(Voie pVoie) throws TechnicalException {
        String vSQL = "INSERT INTO voie (nom, hauteur, secteur_id, cotation_id) VALUES (:nom, :hauteur, :secteurId, :cotationId)";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", pVoie.getNom());
        vParams.addValue("hauteur", pVoie.getHauteur());
        vParams.addValue("secteurId", pVoie.getSecteur().getId());
        vParams.addValue("cotationId", pVoie.getCotation().getId());
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
    public Voie getVoieById(int pId) {
        String vSQL = "SELECT * FROM voie WHERE voie_id=" + pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Voie> vListVoies = vJdbcTemplate.query(vSQL, voieRM);
        return vListVoies.get(0);
    }

    @Override
    public List<Voie> getVoiesBySecteurId(int pSecteurId) {
        String vSQL = "SELECT * FROM voie WHERE secteur_id=" + pSecteurId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Voie> vListVoies = vJdbcTemplate.query(vSQL, voieRM);
        return vListVoies;
    }

    @Override
    public List<Voie> getAllVoies() {
        String vSQL = "SELECT * FROM voie";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, voieRM);
    }

    @Override
    public Integer getNbDeVoiesBySecteur(int pSecteurId) {
        String vSQL = "SELECT count(*) FROM voie WHERE secteur_id=" + pSecteurId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.queryForObject(vSQL, Integer.class);
    }

    @Override
    public Integer getHauteurMaxBySecteur(int pSecteurId) {
        String vSQL = "SELECT MAX(hauteur) FROM voie WHERE secteur_id=" + pSecteurId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.queryForObject(vSQL, Integer.class);
    }

    @Override
    public int[] getCotationsMinMaxBySecteur(int pSecteurId) {
        String vSQLMin = "SELECT MIN(cotation_id) FROM voie WHERE secteur_id=" + pSecteurId;
        String vSQLMax = "SELECT MAX(cotation_id) FROM voie WHERE secteur_id=" + pSecteurId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vMin = vJdbcTemplate.queryForObject(vSQLMin, Integer.class);
        JdbcTemplate vJdbcTemplate2 = new JdbcTemplate(getDataSource());
        int vMax = vJdbcTemplate2.queryForObject(vSQLMax, Integer.class);
        return new int[]{vMin, vMax};
    }

    @Override
    public void updateVoie(Voie pVoie) throws TechnicalException {
        String vSQL = "UPDATE voie SET nom= :vNom, hauteur= :vHauteur, cotation_id= :vCotationId WHERE voie_id= :vVoieId";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("vNom", pVoie.getNom());
        vParams.addValue("vHauteur", pVoie.getHauteur());
        vParams.addValue("vCotationId", pVoie.getCotation().getId());
        vParams.addValue("vVoieId", pVoie.getId());
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
    public void deleteVoie(int pId) {

    }

}
