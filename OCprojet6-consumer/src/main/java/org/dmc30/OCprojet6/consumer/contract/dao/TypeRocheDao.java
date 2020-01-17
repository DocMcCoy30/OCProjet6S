package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.TypeRoche;

import java.util.List;

public interface TypeRocheDao {

    void createTypeRoche (TypeRoche pTypeRoche);
    TypeRoche readTypeRoche (int pId);
    List<TypeRoche> readAllTypeRoches ();
    void updateTypeRoche (TypeRoche pTypeRoche);
    void deleteTypeRoche(int pId);
}
