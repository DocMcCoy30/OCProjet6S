package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.CotationManager;
import org.dmc30.OCprojet6.model.bean.Cotation;

import javax.inject.Named;
import java.util.List;

@Named
public class CotationManagerImpl extends AbstractManager implements CotationManager {

    @Override
    public void createCotation(Cotation pCotation) {

    }

    @Override
    public Cotation getCotationById(int pId) {
        return null;
    }

    @Override
    public List<Cotation> getListCotations() {
        return null;
    }

    @Override
    public void updateCotation(Cotation pCotation) {

    }

    @Override
    public void deleteCotation(int pId) {

    }
}
