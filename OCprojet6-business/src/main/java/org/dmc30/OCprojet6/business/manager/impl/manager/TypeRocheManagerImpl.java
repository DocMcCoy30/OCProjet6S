package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.TypeRocheManager;
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
        TypeRoche vTypeRoche = getDaoFactory().getTypeRocheDao().getTypeRocheById(pId);
        return vTypeRoche;
    }

    @Override
    public List<TypeRoche> getAllTypeRoches() {
        List<TypeRoche> vListTypeRoche = getDaoFactory().getTypeRocheDao().getAllTypeRoches();
        return vListTypeRoche;
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
