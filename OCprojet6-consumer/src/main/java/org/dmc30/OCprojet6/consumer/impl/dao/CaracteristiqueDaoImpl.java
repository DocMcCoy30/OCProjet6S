package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.CaracteristiqueDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.CaracteristiqueRM;
import org.dmc30.OCprojet6.model.bean.Caracteristique;
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
    public void createCaracteristique(Caracteristique pCaracteristique) {
        String vNom = pCaracteristique.getNom();
        String vDefinition = pCaracteristique.getDefinition();
        String vSQL = "INSERT INTO caracteristique (nom, definition) VALUES (?,?)";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vNom, vDefinition);
    }

    @Override
    public Caracteristique getCaracteristiqueById(int pId) {
        String vSQL = "SELECT * FROM caracteristique WHERE caracteristique_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Caracteristique> vListCaracteristique = vJdbcTemplate.query(vSQL, caracteristiqueRM);
        return vListCaracteristique.get(0);
    }

    @Override
    public List<Caracteristique> getAllCaracteristiques() {
        String vSQL = "SELECT * FROM caracteristique";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, caracteristiqueRM);
    }

    @Override
    public void updateCaracteristique(Caracteristique pCaracteristique) {
        String vSQL = "UPDATE caracteristique SET nom= :nom, definition= :definition WHERE caracteristique_id= :id";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", pCaracteristique.getNom());
        vParams.addValue("definition", pCaracteristique.getDefinition());
        vParams.addValue("id", pCaracteristique.getId());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public void deleteCaracteristique(int pId) {
        String vSQL = "DELETE  FROM caracteristique WHERE caracteristique_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.execute(vSQL);
    }

}
