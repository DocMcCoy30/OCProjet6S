package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.VoieManager;
import org.dmc30.OCprojet6.model.bean.Voie;

import javax.inject.Named;
import java.util.List;

@Named
public class VoieManagerImpl extends AbstractManager implements VoieManager {
    
    @Override
    public void createVoie(Voie pVoie) {
        getDaoFactory().getVoieDao().createVoie(pVoie);

    }

    @Override
    public Voie getVoieById(int pId) {
        return getDaoFactory().getVoieDao().getVoieById(pId);
    }

    @Override
    public List<Voie> getVoiesBySecteurId(int pSecteurId) {
        return getDaoFactory().getVoieDao().getVoiesBySecteurId(pSecteurId);
    }

    @Override
    public List<Voie> getAllVoies() {
        return getDaoFactory().getVoieDao().getAllVoies();
    }

    @Override
    public void updateVoie(Voie pVoie) {
        getDaoFactory().getVoieDao().updateVoie(pVoie);
    }

    @Override
    public void deleteVoie(int pId) {
        getDaoFactory().getVoieDao().deleteVoie(pId);
    }
}
