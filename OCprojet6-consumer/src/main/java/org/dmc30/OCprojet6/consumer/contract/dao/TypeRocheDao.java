package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.TypeRoche;

import java.util.List;

public interface TypeRocheDao {

    void createTypeRoche (TypeRoche pTypeRoche);
    TypeRoche getTypeRocheById(int pId);
    List<TypeRoche> getAllTypeRoches();
    void updateTypeRoche (TypeRoche pTypeRoche);
    void deleteTypeRoche(int pId);
}
