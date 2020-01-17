package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.SecteurManager;
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
        Secteur vSecteur = getDaoFactory().getSecteurDao().readSecteur(pId);
        return vSecteur;
    }

    @Override
    public List<Secteur> getListSecteurs() {
        List<Secteur> vListSecteur = getDaoFactory().getSecteurDao().readAllSecteurs();
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
