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
        String vSQL="SELECT * FROM voie WHERE voie_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Voie> vListVoies = vJdbcTemplate.query(vSQL, voieRM);
        return vListVoies.get(0);
    }

    @Override
    public List<Voie> getAllVoies() {
        String vSQL="SELECT * FROM voie";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, voieRM);
    }

    @Override
    public void updateVoie(Voie pVoie) {

    }

    @Override
    public void deleteVoie(int pId) {

    }

}
