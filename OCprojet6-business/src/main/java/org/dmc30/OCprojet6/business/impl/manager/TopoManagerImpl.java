package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.TopoManager;
import org.dmc30.OCprojet6.model.bean.Topo;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class TopoManagerImpl extends AbstractManager implements TopoManager {

    @Override
    public void createTopo(Topo pTopo) throws TechnicalException {
        getDaoFactory().getTopoDao().createTopo(pTopo);

    }

    @Override
    public Topo getTopoById(int pId) {
        return getDaoFactory().getTopoDao().getTopoById(pId);
    }

    @Override
    public List<Topo> getToposBySiteId(int pSiteId) {
        return getDaoFactory().getTopoDao().getToposBySiteId(pSiteId);
    }
    @Override
    public List<Topo> getAllTopos() {
        return getDaoFactory().getTopoDao().getAllTopos();
    }

    @Override
    public void updateTopo(Topo pTopo) {
        getDaoFactory().getTopoDao().updateTopo(pTopo);
    }

    @Override
    public void deleteTopo(int pId) {
        getDaoFactory().getTopoDao().deleteTopo(pId);
    }

    @Override
    public List<Topo> getTopoByUser(String pUserName) {
        return getDaoFactory().getTopoDao().getTopoByUser(pUserName);
    }
}
