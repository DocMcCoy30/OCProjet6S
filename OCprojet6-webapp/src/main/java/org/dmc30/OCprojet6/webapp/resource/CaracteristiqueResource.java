package org.dmc30.OCprojet6.webapp.resource;


import org.dmc30.OCprojet6.model.bean.Caracteristique;

import javax.inject.Named;
import java.util.List;

@Named
public class CaracteristiqueResource extends AbstractResource{

    public void createCaracteristique (Caracteristique pCaracteristique) {
        getManagerFactory().getCaracteristiqueManager().createCaractéristique(pCaracteristique);
    }

    public List<Caracteristique> getListCaracteristique() {
        return getManagerFactory().getCaracteristiqueManager().getListCaracteristiques();
    }


}
