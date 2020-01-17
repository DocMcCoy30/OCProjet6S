package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.TypeRocheDao;
import org.dmc30.OCprojet6.model.bean.TypeRoche;

import javax.inject.Named;
import java.util.List;

@Named
public class TypeRocheDaoImpl extends AbstractDao implements TypeRocheDao {

    @Override
    public void createTypeRoche(TypeRoche pTypeRoche) {

    }

    @Override
    public TypeRoche readTypeRoche(int pId) {
        return null;
    }

    @Override
    public List<TypeRoche> readAllTypeRoches() {
        return null;
    }

    @Override
    public void updateTypeRoche(TypeRoche pTypeRoche) {

    }

    @Override
    public void deleteTypeRoche(int pId) {

    }
}
