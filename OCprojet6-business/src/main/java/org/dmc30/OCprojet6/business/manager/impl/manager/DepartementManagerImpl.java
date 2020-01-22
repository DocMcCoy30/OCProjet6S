package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.DepartementManager;
import org.dmc30.OCprojet6.model.bean.Departement;

import javax.inject.Named;
import java.util.List;

@Named
public class DepartementManagerImpl extends AbstractManager implements DepartementManager {

    @Override
    public void createDepartement(Departement pDepartement) {
        getDaoFactory().getDepartementDao().createDepartement(pDepartement);

    }

    @Override
    public Departement getDepartementByCode(String pCode) {
        Departement vDepartement = getDaoFactory().getDepartementDao().readDepartement(pCode);
        return vDepartement;
    }

    @Override
    public List<Departement> getDepartementsByRegion(int pRegionId) {
        return getDaoFactory().getDepartementDao().readDepartementsByRegion(pRegionId);
    }

    @Override
    public List<Departement> getListDepartements() {
        List<Departement> vListDepartement = getDaoFactory().getDepartementDao().readAllDepartements();
        return vListDepartement;
    }

    @Override
    public void updateDepartement(Departement pDepartement) {
        getDaoFactory().getDepartementDao().updateDepartement(pDepartement);
    }

    @Override
    public void deleteDepartement(int pId) {
        getDaoFactory().getDepartementDao().deleteDepartement(pId);
    }
}
