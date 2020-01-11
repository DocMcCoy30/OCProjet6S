package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.TypeRocheManager;
import org.dmc30.OCprojet6.model.bean.TypeRoche;

import javax.inject.Named;
import java.util.List;

@Named
public class TypeRocheManagerImpl extends AbstractManager implements TypeRocheManager {

    @Override
    public void createTypeRoche(TypeRoche pTypeRoche) {

    }

    @Override
    public TypeRoche getTypeRocheById(int pId) {
        return null;
    }

    @Override
    public List<TypeRoche> getListTypeRoches() {
        return null;
    }

    @Override
    public void updateTypeRoche(TypeRoche pTypeRoche) {

    }

    @Override
    public void deleteTypeRoche(int pId) {

    }
}
