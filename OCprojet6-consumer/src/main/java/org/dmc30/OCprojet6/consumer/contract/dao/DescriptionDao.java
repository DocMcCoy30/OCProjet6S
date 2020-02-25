package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Description;

import java.util.List;

public interface DescriptionDao {

    void createDescription (Description pDescription);
    Description getDescriptionById (int pId);
    List<Description> getAllDescriptions();
    int getLastId();
}
