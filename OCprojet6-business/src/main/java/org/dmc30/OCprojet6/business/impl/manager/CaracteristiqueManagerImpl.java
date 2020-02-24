package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.CaracteristiqueManager;
import org.dmc30.OCprojet6.model.bean.Caracteristique;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class CaracteristiqueManagerImpl extends AbstractManager implements CaracteristiqueManager {


    @Override
    public void createCaracteristique(Caracteristique pCaracteristique) throws TechnicalException {
        getDaoFactory().getCaracteristiqueDao().createCaracteristique(pCaracteristique);

    }

    @Override
    public Caracteristique getCaracteristiqueById(int pId) throws TechnicalException {
        return getDaoFactory().getCaracteristiqueDao().getCaracteristiqueById(pId);
    }

    @Override
    public List<Caracteristique> getAllCaracteristiques() throws TechnicalException {
        return getDaoFactory().getCaracteristiqueDao().getAllCaracteristiques();
    }

    @Override
    public void updateCaracteristique(Caracteristique pCaracteristique) throws TechnicalException {
        getDaoFactory().getCaracteristiqueDao().updateCaracteristique(pCaracteristique);
    }

    @Override
    public void deleteCaracteristique(int pId) throws TechnicalException {
        getDaoFactory().getCaracteristiqueDao().deleteCaracteristique(pId);

    }
}
