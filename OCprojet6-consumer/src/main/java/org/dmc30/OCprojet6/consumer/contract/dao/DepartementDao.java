package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Departement;

import java.util.List;

public interface DepartementDao {

    Departement readDepartement (String code);
    List<Departement> readAllDepartements ();
}
