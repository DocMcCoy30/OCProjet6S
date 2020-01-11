package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.DepartementManager;
import org.dmc30.OCprojet6.business.manager.impl.manager.AbstractManager;
import org.dmc30.OCprojet6.model.bean.Departement;

import javax.inject.Named;
import java.util.List;

@Named
public class DepartementManagerImpl extends AbstractManager implements DepartementManager {

    @Override
    public void createDepartement(Departement pDepartement) {

    }

    @Override
    public Departement getDepartementByCode(String pCode) {
        return null;
    }

    @Override
    public List<Departement> getListDepartements() {
        return null;
    }

    @Override
    public void updateDepartement(Departement pDepartement) {

    }

    @Override
    public void deleteDepartement(Departement pDepartement) {

    }
}
