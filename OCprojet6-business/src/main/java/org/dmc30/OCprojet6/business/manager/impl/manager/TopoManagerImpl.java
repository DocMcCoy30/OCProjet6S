package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.TopoManager;
import org.dmc30.OCprojet6.model.bean.Topo;

import javax.inject.Named;
import java.util.List;

@Named
public class TopoManagerImpl extends AbstractManager implements TopoManager {

    @Override
    public void createTopo(Topo pTopo) {
        getDaoFactory().getTopoDao().createTopo(pTopo);

    }

    @Override
    public Topo getTopoById(int pId) {
        Topo vTopo = getDaoFactory().getTopoDao().readTopo(pId);
        return vTopo;
    }

    @Override
    public List<Topo> getListTopos() {
        List<Topo> vListTopo = getDaoFactory().getTopoDao().readAllTopos();
        return vListTopo;
    }

    @Override
    public void updateTopo(Topo pTopo) {
        getDaoFactory().getTopoDao().updateTopo(pTopo);
    }

    @Override
    public void deleteTopo(int pId) {
        getDaoFactory().getTopoDao().deleteTopo(pId);
    }
}
