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
        Secteur vSecteur = getDaoFactory().getSecteurDao().getSecteurById(pId);
        return vSecteur;
    }

    @Override
    public List<Secteur> getSecteursBySiteId (int pSiteId) {
        List<Secteur> vListSecteur = getDaoFactory().getSecteurDao().getSecteursBySiteId(pSiteId);
        return vListSecteur;
    }

    @Override
    public List<Secteur> getAllSecteurs() {
        List<Secteur> vListSecteur = getDaoFactory().getSecteurDao().getAllSecteurs();
        return vListSecteur;
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
