package org.dmc30.OCprojet6.webapp.resource;


import org.dmc30.OCprojet6.model.bean.Caracteristique;

import javax.inject.Named;
import java.util.List;

@Named
public class CaracteristiqueResource extends AbstractResource{

    public void createCaracteristique (Caracteristique pCaracteristique) {
        getManagerFactory().getCaracteristiqueManager().createCaracteristique(pCaracteristique);
    }

    public Caracteristique getCracteristiqueById (int pId) {
        return getManagerFactory().getCaracteristiqueManager().getCaracteristiqueById(pId);
    }

    public List<Caracteristique> getListCaracteristique() {
        return getManagerFactory().getCaracteristiqueManager().getListCaracteristiques();
    }

    public void updateCaracteristique (Caracteristique pCaracteristique) {
        getManagerFactory().getCaracteristiqueManager().updateCaracteristique(pCaracteristique);
    }

    public void deleteCarateristique (int pId) {
        getManagerFactory().getCaracteristiqueManager().deleteCaracteristique(pId);
    }


}
