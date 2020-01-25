package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.CaracteristiqueManager;
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
        Caracteristique vCaracteristique = getDaoFactory().getCaracteristiqueDao().getCaracteristiqueById(pId);
        return vCaracteristique;
    }

    @Override
    public List<Caracteristique> getAllCaracteristiques() {
        List<Caracteristique> vListCaracteristique = getDaoFactory().getCaracteristiqueDao().getAllCaracteristiques();
        return vListCaracteristique;
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
