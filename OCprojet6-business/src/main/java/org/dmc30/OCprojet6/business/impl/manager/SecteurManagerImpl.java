package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.SecteurManager;
import org.dmc30.OCprojet6.model.bean.Secteur;

import javax.inject.Named;
import java.util.List;

@Named
public class SecteurManagerImpl extends AbstractManager implements SecteurManager {

    @Override
    public void createSecteur(Secteur pSecteur) {
        getDaoFactory().getSecteurDao().createSecteur(pSecteur);
    }

    @Override
    public Secteur getSecteurById(int pId) {
        return getDaoFactory().getSecteurDao().getSecteurById(pId);
    }

    @Override
    public List<Secteur> getSecteursBySiteId (int pSiteId) {
        return getDaoFactory().getSecteurDao().getSecteursBySiteId(pSiteId);
    }

    @Override
    public List<Secteur> getAllSecteurs() {
        return getDaoFactory().getSecteurDao().getAllSecteurs();
    }

    @Override
    public void updateSecteur(Secteur pSecteur) {
        getDaoFactory().getSecteurDao().updateSecteur(pSecteur);
    }

    @Override
    public void deleteSecteur(int pId) {
        getDaoFactory().getSecteurDao().deleteSecteur(pId);
    }
}
