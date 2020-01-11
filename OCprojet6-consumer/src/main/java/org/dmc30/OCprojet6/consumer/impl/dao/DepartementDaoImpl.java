package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.DepartementDao;
import org.dmc30.OCprojet6.model.bean.Departement;


import javax.inject.Named;
import java.util.List;

@Named
public class DepartementDaoImpl extends AbstractDao implements DepartementDao {

    @Override
    public Departement readDepartement(String code) {
        return null;
    }

    @Override
    public List<Departement> readAllDepartements() {
            return null;
    }
}
