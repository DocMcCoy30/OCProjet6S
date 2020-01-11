package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.CaracteristiqueDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.CaracteristiqueRM;
import org.dmc30.OCprojet6.model.bean.Caracteristique;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
    public Caracteristique readCaracteristique(int pId) {

        String vSQL = "SELECT * FROM caracteristique WHERE caracteristique_id="+pId;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Caracteristique> caracteristiqueRM = new CaracteristiqueRM();

        List<Caracteristique> vListCaracteristique = vJdbcTemplate.query(vSQL, caracteristiqueRM);
        Caracteristique vCaracteristique = vListCaracteristique.get(0);

        return vCaracteristique;
    }

    @Override
    public List<Caracteristique> readAllCaracteristiques() {
        String vSQL = "SELECT * FROM caracteristique";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Caracteristique> caracteristiqueRM = new CaracteristiqueRM();

        List<Caracteristique> vListCaracteristique = vJdbcTemplate.query(vSQL, caracteristiqueRM);

        return vListCaracteristique;
    }

    @Override
    public void updateCaracteristique(Caracteristique pCaracteristique) {

    }

}
