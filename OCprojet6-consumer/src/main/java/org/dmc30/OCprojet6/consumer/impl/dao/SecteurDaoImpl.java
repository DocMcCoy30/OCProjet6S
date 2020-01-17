package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.SecteurDao;
import org.dmc30.OCprojet6.model.bean.Secteur;

import javax.inject.Named;
import java.util.List;

@Named
public class SecteurDaoImpl extends AbstractDao implements SecteurDao {

    @Override
    public void createSecteur(Secteur pSecteur) {

    }

    @Override
    public Secteur readSecteur(int pId) {
        return null;
    }

    @Override
    public List<Secteur> readAllSecteurs() {
        return null;
    }

    @Override
    public void updateSecteur(Secteur pSecteur) {

    }

    @Override
    public void deleteSecteur(int pId) {

    }
}
