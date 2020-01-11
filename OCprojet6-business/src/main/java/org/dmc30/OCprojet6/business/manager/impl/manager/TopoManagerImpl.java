package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.TopoManager;
import org.dmc30.OCprojet6.model.bean.Topo;

import javax.inject.Named;
import java.util.List;

@Named
public class TopoManagerImpl extends AbstractManager implements TopoManager {

    @Override
    public void createTopo(Topo pTopo) {

    }

    @Override
    public Topo getTopoById(int pId) {
        return null;
    }

    @Override
    public List<Topo> getListTopos() {
        return null;
    }

    @Override
    public void updateTopo(Topo pTopo) {

    }

    @Override
    public void deleteTopo(int pId) {

    }
}
