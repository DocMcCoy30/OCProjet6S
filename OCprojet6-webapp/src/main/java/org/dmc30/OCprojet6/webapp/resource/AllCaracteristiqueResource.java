package org.dmc30.OCprojet6.webapp.resource;


import org.dmc30.OCprojet6.model.bean.Caracteristique;
import org.dmc30.OCprojet6.model.bean.Cotation;
import org.dmc30.OCprojet6.model.bean.TypeRoche;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class AllCaracteristiqueResource extends AbstractResource{

    public Caracteristique getCaracteristiqueById (int pId) throws TechnicalException {
        return getManagerFactory().getCaracteristiqueManager().getCaracteristiqueById(pId);
    }

    public List<Caracteristique> getAllCaracteristiques() throws TechnicalException {
        return getManagerFactory().getCaracteristiqueManager().getAllCaracteristiques();
    }

    public void createCaracteristique (Caracteristique pCaracteristique) throws TechnicalException {
        getManagerFactory().getCaracteristiqueManager().createCaracteristique(pCaracteristique);
    }

    public void updateCaracteristique (Caracteristique pCaracteristique) throws TechnicalException {
        getManagerFactory().getCaracteristiqueManager().updateCaracteristique(pCaracteristique);
    }

    public void deleteCarateristique (int pId) throws TechnicalException {
        getManagerFactory().getCaracteristiqueManager().deleteCaracteristique(pId);
    }

    public List<TypeRoche> getAllTypeRoche () {
        return getManagerFactory().getTypeRocheManager().getAllTypeRoches();
    }

    public TypeRoche getTypeRocheById (int pId) {
        return getManagerFactory().getTypeRocheManager().getTypeRocheById(pId);
    }

    public List<Cotation> getAllCotations () {
        return getManagerFactory().getCotationManager().getAllCotations();
    }

    public Cotation getCotationById(Integer pCotationId) {
        return getManagerFactory().getCotationManager().getCotationById(pCotationId);
    }
}
