package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.CaracteristiqueManager;
import org.dmc30.OCprojet6.model.bean.Caracteristique;

import javax.inject.Named;
import java.util.List;

@Named
public class CaracteristiqueManagerImpl extends AbstractManager implements CaracteristiqueManager {


    @Override
    public void createCaracteristique(Caracteristique pCaracteristique) {
        getDaoFactory().getCaracteristiqueDao().createCaracteristique(pCaracteristique);

    }

    @Override
    public Caracteristique getCaracteristiqueById(int pId) {
        return getDaoFactory().getCaracteristiqueDao().getCaracteristiqueById(pId);
    }

    @Override
    public List<Caracteristique> getAllCaracteristiques() {
        return getDaoFactory().getCaracteristiqueDao().getAllCaracteristiques();
    }

    @Override
    public void updateCaracteristique(Caracteristique pCaracteristique) {
        getDaoFactory().getCaracteristiqueDao().updateCaracteristique(pCaracteristique);
    }

    @Override
    public void deleteCaracteristique(int pId) {
        getDaoFactory().getCaracteristiqueDao().deleteCaracteristique(pId);

    }
}
