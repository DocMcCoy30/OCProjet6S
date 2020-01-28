package org.dmc30.OCprojet6.webapp.resource;


import org.dmc30.OCprojet6.model.bean.Caracteristique;
import org.dmc30.OCprojet6.model.bean.TypeRoche;

import javax.inject.Named;
import java.util.List;

@Named
public class AllCaracteristiqueResource extends AbstractResource{

    public Caracteristique getCaracteristiqueById (int pId) {
        return getManagerFactory().getCaracteristiqueManager().getCaracteristiqueById(pId);
    }

    public List<Caracteristique> getListCaracteristique() {
        return getManagerFactory().getCaracteristiqueManager().getAllCaracteristiques();
    }

    public void createCaracteristique (Caracteristique pCaracteristique) {
        getManagerFactory().getCaracteristiqueManager().createCaracteristique(pCaracteristique);
    }

    public void updateCaracteristique (Caracteristique pCaracteristique) {
        getManagerFactory().getCaracteristiqueManager().updateCaracteristique(pCaracteristique);
    }

    public void deleteCarateristique (int pId) {
        getManagerFactory().getCaracteristiqueManager().deleteCaracteristique(pId);
    }

    public List<TypeRoche> getListTypeRoche () {
        return getManagerFactory().getTypeRocheManager().getAllTypeRoches();
    }


}
