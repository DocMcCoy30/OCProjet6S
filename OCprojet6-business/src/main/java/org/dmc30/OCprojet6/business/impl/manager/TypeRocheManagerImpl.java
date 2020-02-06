package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.TypeRocheManager;
import org.dmc30.OCprojet6.model.bean.TypeRoche;

import javax.inject.Named;
import java.util.List;

@Named
public class TypeRocheManagerImpl extends AbstractManager implements TypeRocheManager {

    @Override
    public void createTypeRoche(TypeRoche pTypeRoche) {
        getDaoFactory().getTypeRocheDao().createTypeRoche(pTypeRoche);

    }

    @Override
    public TypeRoche getTypeRocheById(int pId) {
        return getDaoFactory().getTypeRocheDao().getTypeRocheById(pId);
    }

    @Override
    public List<TypeRoche> getAllTypeRoches() {
        return getDaoFactory().getTypeRocheDao().getAllTypeRoches();
    }

    @Override
    public void updateTypeRoche(TypeRoche pTypeRoche) {
        getDaoFactory().getTypeRocheDao().updateTypeRoche(pTypeRoche);
    }

    @Override
    public void deleteTypeRoche(int pId) {
        getDaoFactory().getTypeRocheDao().deleteTypeRoche(pId);
    }
}
