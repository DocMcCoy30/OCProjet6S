package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.CotationManager;
import org.dmc30.OCprojet6.model.bean.Cotation;

import javax.inject.Named;
import java.util.List;

@Named
public class CotationManagerImpl extends AbstractManager implements CotationManager {

    @Override
    public void createCotation(Cotation pCotation) {
        getDaoFactory().getCotationDao().createCotation(pCotation);

    }

    @Override
    public Cotation getCotationById(int pId) {
        Cotation vCotation = getDaoFactory().getCotationDao().readCotation(pId);
        return vCotation;
    }

    @Override
    public List<Cotation> getListCotations() {
        List<Cotation> vListCotation = getDaoFactory().getCotationDao().readAllCotations();
        return vListCotation;
    }

    @Override
    public void updateCotation(Cotation pCotation) {
        getDaoFactory().getCotationDao().updateCotation(pCotation);
    }

    @Override
    public void deleteCotation(int pId) {
        getDaoFactory().getCotationDao().deleteCotation(pId);
    }
}
