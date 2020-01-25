package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Cotation;

import java.util.List;

public interface CotationDao {

    void createCotation (Cotation pCotation);
    Cotation getCotationById(int pId);
    List<Cotation> getAllCotations();
    void updateCotation (Cotation pCotation);
    void deleteCotation(int pId);
}
