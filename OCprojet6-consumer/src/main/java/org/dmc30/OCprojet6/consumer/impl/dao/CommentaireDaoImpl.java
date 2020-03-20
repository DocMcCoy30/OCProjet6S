package org.dmc30.OCprojet6.consumer.impl.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.consumer.contract.dao.CommentaireDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.CommentaireRM;
import org.dmc30.OCprojet6.model.bean.Commentaire;
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
public class CommentaireDaoImpl extends AbstractDao implements CommentaireDao {

    Logger logger = LogManager.getLogger(CommentaireDaoImpl.class);

    @Inject
    CommentaireRM commentaireRM;

    @Override
    public void createCommentaire(Commentaire pCommentaire) throws TechnicalException {
        String vSQL = "INSERT INTO commentaire ( commentaire, users_username, date_publication, reference_id, ref_id, valide) " +
                "VALUES (:commentaire, :username, :date, :referenceId, :refId, :valide)";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("commentaire", pCommentaire.getCommentaire());
        vParams.addValue("username", pCommentaire.getUsers().getUsername());
        vParams.addValue("date", pCommentaire.getDate());
        vParams.addValue("referenceId", pCommentaire.getReferenceId());
        vParams.addValue("refId", pCommentaire.getRefId());
        vParams.addValue("valide", pCommentaire.isValide());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        try {
            vJdbcTemplate.update(vSQL, vParams);
        }catch (
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
    public Commentaire getCommentaireById(int pId) {
        String vSQL = "SELECT * FROM commentaire WHERE commentaire_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Commentaire> vListCommentaires = vJdbcTemplate.query(vSQL, commentaireRM);
        return vListCommentaires.get(0);
    }

    @Override
    public List<Commentaire> getAllCommentaires() {
        String vSQL = "SELECT * FROM commentaire";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, commentaireRM);
    }

    @Override
    public void updateCommentaire(Commentaire pCommentaire) throws TechnicalException {
        String vSQL = "UPDATE commentaire SET commentaire= :commentaire, users_username= :username," +
                " date_publication= :date, reference_id= :referenceId, ref_id =:refId, valide= :valide" +
                " WHERE commentaire_id="+pCommentaire.getId();
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("commentaire", pCommentaire.getCommentaire());
        vParams.addValue("username", pCommentaire.getUsers().getUsername());
        vParams.addValue("date", pCommentaire.getDate());
        vParams.addValue("referenceId", pCommentaire.getReferenceId());
        vParams.addValue("refId", pCommentaire.getRefId());
        vParams.addValue("valide", pCommentaire.isValide());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        try {
            vJdbcTemplate.update(vSQL, vParams);
        }catch (
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
    public void deleteCommentaire(int pId) throws TechnicalException {
        String vSQL = "DELETE  FROM commentaire WHERE commentaire_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        try {
            vJdbcTemplate.execute(vSQL);
        }
        catch (BadSqlGrammarException e) {
            throw new TechnicalException(ErrorMessages.SQL_SYNTAX_ERROR.getErrorMessage());
        }
        catch (DataAccessException e) {
            throw new TechnicalException(ErrorMessages.SQL_DELETE_ERROR.getErrorMessage());
        }
        catch (Exception e) {
            throw new TechnicalException(ErrorMessages.TECHNICAL_ERROR.getErrorMessage());
        }

    }

    @Override
    public List<Commentaire> getValidatedCommentairesByReference(int pRefererenceId, int pRefId) {
        String vSQL = "SELECT * FROM commentaire WHERE reference_id= :referenceId AND ref_id= :refId AND valide='true'";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("referenceId", pRefererenceId);
        vParams.addValue("refId", pRefId);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, vParams, commentaireRM);
    }

    @Override
    public List<Commentaire> getNonValidatedCommentaires() {
        String vSQL = "SELECT * FROM commentaire WHERE valide='false'";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, commentaireRM);
    }

}
