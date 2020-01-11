package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.CaracteristiqueManager;
import org.dmc30.OCprojet6.model.bean.Caracteristique;

import javax.inject.Named;
import java.util.List;

@Named
public class CaracteristiqueManagerImpl extends AbstractManager implements CaracteristiqueManager {


    @Override
    public void createCaractéristique(Caracteristique pCaracteristique) {
        getDaoFactory().getCaracteristiqueDao().createCaracteristique(pCaracteristique);

    }

    @Override
    public Caracteristique getCaracteristique(int pId) {
        Caracteristique vCaracteristique = getDaoFactory().getCaracteristiqueDao().readCaracteristique(pId);
        return vCaracteristique;
    }

    @Override
    public List<Caracteristique> getListCaracteristiques() {
        List<Caracteristique> vListCaracteristique = getDaoFactory().getCaracteristiqueDao().readAllCaracteristiques();
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
