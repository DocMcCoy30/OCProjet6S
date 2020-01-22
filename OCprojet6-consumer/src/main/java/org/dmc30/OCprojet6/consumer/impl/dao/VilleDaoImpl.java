package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.VilleDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.VilleRM;
import org.dmc30.OCprojet6.model.bean.Ville;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class VilleDaoImpl extends AbstractDao implements VilleDao {

    @Override
    public void createVille(Ville pVille) {

    }

    @Override
    public Ville readVille(int pId) {
        String vSQL = "SELECT * FROM ville WHERE departement_code=" + pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Ville> villeRowMapper = new VilleRM();
        List<Ville> vListVilles = vJdbcTemplate.query(vSQL, villeRowMapper);
        Ville vVille = vListVilles.get(0);
        return vVille;
    }

    @Override
    public List<Ville> readVillesByDepartement(String pCode) {
        String vSQL = "SELECT * FROM ville WHERE departement_code=" + pCode;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Ville> villeRowMapper = new VilleRM();
        List<Ville> vListVilles = vJdbcTemplate.query(vSQL, villeRowMapper);
        return vListVilles;
    }

    @Override
    public List<Ville> readAllVilles() {
        String vSQL = "SELECT * FROM ville";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Ville> villeRowMapper = new VilleRM();
        List<Ville> vListVilles = vJdbcTemplate.query(vSQL, villeRowMapper);
        return vListVilles;
    }

    @Override
    public void updateVille(Ville pVille) {

    }

    @Override
    public void deleteVille(int pId) {

    }

}
