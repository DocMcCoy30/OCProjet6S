package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.LieuManager;
import org.dmc30.OCprojet6.model.bean.Lieu;

import javax.inject.Named;
import java.util.List;

@Named
public class LieuManagerImpl extends AbstractManager implements LieuManager {

    @Override
    public void createLieu(Lieu pLieu) {
        getDaoFactory().getLieuDao().createLieu(pLieu);

    }

    @Override
    public Lieu getLieuById(int pId) {
        Lieu vLieu = getDaoFactory().getLieuDao().readLieu(pId);
        return vLieu;
    }

    @Override
    public List<Lieu> getListLieux() {
        List<Lieu> vListLieu = getDaoFactory().getLieuDao().readAllLieux();
        return vListLieu;
    }

    @Override
    public void updateLieu(Lieu pLieu) {
        getDaoFactory().getLieuDao().updateLieu(pLieu);
    }

    @Override
    public void deleteLieu(int pId) {
        getDaoFactory().getLieuDao().deleteLieu(pId);
    }
}
