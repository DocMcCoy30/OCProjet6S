package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.TopoDao;
import org.dmc30.OCprojet6.model.bean.Topo;

import javax.inject.Named;
import java.util.List;

@Named
public class TopoDaoImpl extends AbstractDao implements TopoDao {

    @Override
    public void createTopo(Topo pTopo) {

    }

    @Override
    public Topo readTopo(int pId) {
        return null;
    }

    @Override
    public List<Topo> readAllTopos() {
        return null;
    }

    @Override
    public void updateTopo(Topo pTopo) {

    }

    @Override
    public void deleteTopo(int pId) {

    }
}
