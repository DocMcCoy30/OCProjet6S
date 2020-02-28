package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.VoieManager;
import org.dmc30.OCprojet6.model.bean.Voie;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class VoieManagerImpl extends AbstractManager implements VoieManager {
    
    @Override
    public void createVoie(Voie pVoie) throws TechnicalException {
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
    public void updateVoie(Voie pVoie) throws TechnicalException {
        getDaoFactory().getVoieDao().updateVoie(pVoie);
    }

    @Override
    public void deleteVoie(int pId) {
        getDaoFactory().getVoieDao().deleteVoie(pId);
    }

    @Override
    public Integer getHauteurMaxBySecteur(int pSecteurId) {
        return getDaoFactory().getVoieDao().getHauteurMaxBySecteur(pSecteurId);
    }

    @Override
    public Integer getNbDeVoiesBySecteur(int pSecteurId) {
        return getDaoFactory().getVoieDao().getNbDeVoiesBySecteur(pSecteurId);
    }

    @Override
    public int[] getCotationMinMaxBySecteur(int pSecteurId) {
        return getDaoFactory().getVoieDao().getCotationsMinMaxBySecteur(pSecteurId);
    }
}
