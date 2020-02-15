package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.VoieDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.VoieRM;
import org.dmc30.OCprojet6.model.bean.Voie;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class VoieDaoImpl extends AbstractDao implements VoieDao {

    @Inject
    VoieRM voieRM;

    @Override
    public void createVoie(Voie pVoie) {
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
        String vSQL = "SELECT MAX(hauteur) FROM voie WHERE secteur_id="+pSecteurId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.queryForObject(vSQL, Integer.class);
    }

    @Override
    public int[] getCotationsBySecteur(int pSecteurId) {
        String vSQLMin = "SELECT MIN(cotation_id) FROM voie WHERE secteur_id="+pSecteurId;
        String vSQLMax = "SELECT MAX(cotation_id) FROM voie WHERE secteur_id="+pSecteurId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vMin = vJdbcTemplate.queryForObject(vSQLMin, Integer.class);
        JdbcTemplate vJdbcTemplate2 = new JdbcTemplate(getDataSource());
        int vMax = vJdbcTemplate2.queryForObject(vSQLMax, Integer.class);
        return new int[]{vMin, vMax};
    }

    @Override
    public void updateVoie(Voie pVoie) {

    }

    @Override
    public void deleteVoie(int pId) {

    }

}
