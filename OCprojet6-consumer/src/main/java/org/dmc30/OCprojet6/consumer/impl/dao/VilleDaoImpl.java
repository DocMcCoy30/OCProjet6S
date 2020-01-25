package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.VilleDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.VilleRM;
import org.dmc30.OCprojet6.model.bean.Ville;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

    }

    @Override
    public Ville getVilleById(int pId) {
        String vSQL = "SELECT * FROM ville WHERE ville_id=" + pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Ville> vListVilles = vJdbcTemplate.query(vSQL, villeRM);
        Ville vVille = vListVilles.get(0);
        return vVille;
    }

    @Override
    public List<Ville> getVillesByDepartement(String pCode) {
        String vSQL = "SELECT * FROM ville WHERE departement_code=" + pCode;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Ville> vListVilles = vJdbcTemplate.query(vSQL, villeRM);
        return vListVilles;
    }

    @Override
    public List<Ville> getAllVilles() {
        String vSQL = "SELECT * FROM ville";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Ville> vListVilles = vJdbcTemplate.query(vSQL, villeRM);
        return vListVilles;
    }

    @Override
    public void updateVille(Ville pVille) {

    }

    @Override
    public void deleteVille(int pId) {

    }

}
