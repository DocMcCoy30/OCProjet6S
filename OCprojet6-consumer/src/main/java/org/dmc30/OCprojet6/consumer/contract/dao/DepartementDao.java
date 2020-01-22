package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Departement;

import java.util.List;

public interface DepartementDao {

    void createDepartement (Departement pDepartement);
    Departement readDepartement (String pCode);
    List<Departement> readDepartementsByRegion (int pRegionId);
    List<Departement> readAllDepartements ();
    void updateDepartement (Departement pDepartement);
    void deleteDepartement(int pId);
}

