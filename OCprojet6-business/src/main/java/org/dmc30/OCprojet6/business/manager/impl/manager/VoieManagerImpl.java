package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.VoieManager;
import org.dmc30.OCprojet6.model.bean.Voie;

import javax.inject.Named;
import java.util.List;

@Named
public class VoieManagerImpl extends AbstractManager implements VoieManager {

    @Override
    public void createVoie(Voie pVoie) {

    }

    @Override
    public Voie getVoieById(int pId) {
        return null;
    }

    @Override
    public List<Voie> getListVoies() {
        return null;
    }

    @Override
    public void updateVoie(Voie pVoie) {

    }

    @Override
    public void deleteVoie(Voie pVoie) {

    }
}
