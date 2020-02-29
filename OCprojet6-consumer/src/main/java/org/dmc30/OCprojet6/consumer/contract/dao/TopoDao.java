package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Topo;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface TopoDao {

    void createTopo (Topo pTopo) throws TechnicalException;
    Topo getTopoById(int pId);
    List<Topo> getToposBySiteId(int pSiteId);
    List<Topo> getAllTopos();
    void updateTopo (Topo pTopo);
    void deleteTopo(int pId);
}
