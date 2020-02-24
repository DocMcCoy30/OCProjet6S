package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.CaracteristiqueDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.CaracteristiqueRM;
import org.dmc30.OCprojet6.model.bean.Caracteristique;
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
public class CaracteristiqueDaoImpl extends AbstractDao implements CaracteristiqueDao {

    @Inject
    CaracteristiqueRM caracteristiqueRM;

    @Override
    public void createCaracteristique(Caracteristique pCaracteristique) throws TechnicalException {
        String vNom = pCaracteristique.getNom();
        String vDefinition = pCaracteristique.getDefinition();
        String vSQL = "INSERT INTO caracteristique (nom, definition) VALUES (?,?)";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        try {
            vJdbcTemplate.update(vSQL, vNom, vDefinition);
        }
        catch (BadSqlGrammarException e) {
            throw new TechnicalException(ErrorMessages.SQL_SYNTAX_ERROR.getErrorMessage());
        }
        catch (DataAccessException e) {
            throw new TechnicalException(ErrorMessages.SQL_UPDATE_ERROR.getErrorMessage());
        }
        catch (Exception e) {
            throw new TechnicalException(ErrorMessages.TECHNICAL_ERROR.getErrorMessage());
        }
    }

    @Override
    public Caracteristique getCaracteristiqueById(int pId) throws TechnicalException {
        List<Caracteristique> vListCaracteristiques;
        String vSQL = "SELECT * FROM caracteristique WHERE caracteristique_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        try {
        vListCaracteristiques = vJdbcTemplate.query(vSQL, caracteristiqueRM);
        }
        catch (BadSqlGrammarException e) {
            throw new TechnicalException(ErrorMessages.SQL_SYNTAX_ERROR.getErrorMessage());
        }
        catch (DataAccessException e) {
            throw new TechnicalException(ErrorMessages.SQL_QUERY_ERROR.getErrorMessage());
        }
        catch (Exception e) {
            throw new TechnicalException(ErrorMessages.TECHNICAL_ERROR.getErrorMessage());
        }
        return vListCaracteristiques.get(0);
    }

    @Override
    public List<Caracteristique> getAllCaracteristiques() throws TechnicalException {
        List<Caracteristique> vListCaracteristiques;
        String vSQL = "SELECT * FROM caracteristique";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        try {
            vListCaracteristiques = vJdbcTemplate.query(vSQL, caracteristiqueRM);
        }
        catch (BadSqlGrammarException e) {
            throw new TechnicalException(ErrorMessages.SQL_SYNTAX_ERROR.getErrorMessage());
        }
        catch (DataAccessException e) {
            throw new TechnicalException(ErrorMessages.SQL_QUERY_ERROR.getErrorMessage());
        }
        catch (Exception e) {
            throw new TechnicalException(ErrorMessages.TECHNICAL_ERROR.getErrorMessage());
        }
        return vListCaracteristiques;
    }

    @Override
    public void updateCaracteristique(Caracteristique pCaracteristique) throws TechnicalException {
        String vSQL = "UPDATE caracteristique SET nom= :nom, definition= :definition WHERE caracteristique_id= :id";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", pCaracteristique.getNom());
        vParams.addValue("definition", pCaracteristique.getDefinition());
        vParams.addValue("id", pCaracteristique.getId());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        try {
            vJdbcTemplate.update(vSQL, vParams);
        }
        catch (BadSqlGrammarException e) {
            throw new TechnicalException(ErrorMessages.SQL_SYNTAX_ERROR.getErrorMessage());
        }
        catch (DataAccessException e) {
            throw new TechnicalException(ErrorMessages.SQL_UPDATE_ERROR.getErrorMessage());
        }
        catch (Exception e) {
            throw new TechnicalException(ErrorMessages.TECHNICAL_ERROR.getErrorMessage());
        }
    }

    @Override
    public void deleteCaracteristique(int pId) throws TechnicalException {
        String vSQL = "DELETE  FROM caracteristique WHERE caracteristique_id="+pId;
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

}
