package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Lieu;

import java.util.List;

public interface LieuDao {

    void createLieu (Lieu pLieu);
    Lieu readLieu (int pId);
    List<Lieu> readAllLieux ();
    void updateLieu (Lieu pLieu);
    void deleteLieu(int pId);
}
