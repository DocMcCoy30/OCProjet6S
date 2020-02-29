package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Description;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface DescriptionDao {

    void createDescription (Description pDescription) throws TechnicalException;
    Description getDescriptionById (int pId);
    List<Description> getAllDescriptions();
    int getLastId();
    void updateDescription(Description pDescription) throws TechnicalException;
}
