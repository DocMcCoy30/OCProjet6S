package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.CotationDao;
import org.dmc30.OCprojet6.model.bean.Cotation;

import javax.inject.Named;
import java.util.List;

@Named
public class CotationDaoImpl extends AbstractDao implements CotationDao {

    @Override
    public void createCotation(Cotation pCotation) {

    }

    @Override
    public Cotation readCotation(int pId) {
        return null;
    }

    @Override
    public List<Cotation> readAllCotations() {
        return null;
    }

    @Override
    public void updateCotation(Cotation pCotation) {

    }

    @Override
    public void deleteCotation(int pId) {

    }
}
