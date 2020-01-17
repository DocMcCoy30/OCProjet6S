package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.VoieDao;
import org.dmc30.OCprojet6.model.bean.Voie;

import javax.inject.Named;
import java.util.List;

@Named
public class VoieDaoImpl extends AbstractDao implements VoieDao {

    @Override
    public void createVoie(Voie pVoie) {

    }

    @Override
    public Voie readVoie(int pId) {
        return null;
    }

    @Override
    public List<Voie> readAllVoies() {
        return null;
    }

    @Override
    public void updateVoie(Voie pVoie) {

    }

    @Override
    public void deleteVoie(int pId) {

    }
}
