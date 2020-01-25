package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Topo;

import java.util.List;

public interface TopoDao {

    void createTopo (Topo pTopo);
    Topo getTopoById(int pId);
    List<Topo> getAllTopos();
    void updateTopo (Topo pTopo);
    void deleteTopo(int pId);
}
