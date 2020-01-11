package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.SecteurManager;
import org.dmc30.OCprojet6.model.bean.Secteur;

import javax.inject.Named;
import java.util.List;

@Named
public class SecteurManagerImpl extends AbstractManager implements SecteurManager {

    @Override
    public void createSecteur(Secteur pSecteur) {

    }

    @Override
    public Secteur getSecteurById(int pId) {
        return null;
    }

    @Override
    public List<Secteur> getListSecteurs() {
        return null;
    }

    @Override
    public void updateSecteur(Secteur pSecteur) {

    }

    @Override
    public void deleteSecteur(int pId) {

    }
}
