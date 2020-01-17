package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Cotation;

import java.util.List;

public interface CotationDao {

    void createCotation (Cotation pCotation);
    Cotation readCotation (int pId);
    List<Cotation> readAllCotations ();
    void updateCotation (Cotation pCotation);
    void deleteCotation(int pId);
}
