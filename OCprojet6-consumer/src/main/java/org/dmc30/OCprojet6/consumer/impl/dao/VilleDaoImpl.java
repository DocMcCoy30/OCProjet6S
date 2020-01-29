package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.VilleDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.VilleRM;
import org.dmc30.OCprojet6.model.bean.Ville;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class VilleDaoImpl extends AbstractDao implements VilleDao {

    @Inject
    VilleRM villeRM;

    @Override
    public void createVille(Ville pVille) {
        String vSQL = "INSERT INTO ville (nom, departement_code) VALUES (:nom, :departementCode)";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", pVille.getNom());
        vParams.addValue("departementCode", pVille.getDepartement().getCode());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL,vParams);
    }

    @Override
    public Ville getVilleById(int pId) {
        String vSQL = "SELECT * FROM ville WHERE ville_id= :id ORDER BY nom";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", pId);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        List<Ville> vListVilles = vJdbcTemplate.query(vSQL, vParams, villeRM);
        Ville vVille = vListVilles.get(0);
        return vVille;
    }

    @Override
    public List<Ville> getVillesByDepartement(String pCode) {
        String vSQL = "SELECT * FROM ville WHERE departement_code= :departementCode";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("departementCode", pCode);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        List<Ville> vListVilles = vJdbcTemplate.query(vSQL, vParams, villeRM);
        return vListVilles;
    }

    @Override
    public List<Ville> getAllVilles() {
        String vSQL = "SELECT * FROM ville ORDER BY nom";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Ville> vListVilles = vJdbcTemplate.query(vSQL, villeRM);
        return vListVilles;
    }

    @Override
    public int getLastId() {
        String vSQL = "SELECT MAX(ville_id) FROM ville";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Integer vLastId = vJdbcTemplate.queryForObject(vSQL, Integer.TYPE);
        return vLastId;
    }

    @Override
    public void updateVille(Ville pVille) {

    }

    @Override
    public void deleteVille(int pId) {

    }

}
