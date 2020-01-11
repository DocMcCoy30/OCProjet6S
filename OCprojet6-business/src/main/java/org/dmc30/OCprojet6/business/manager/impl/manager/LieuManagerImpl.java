package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.LieuManager;
import org.dmc30.OCprojet6.model.bean.Lieu;

import javax.inject.Named;
import java.util.List;

@Named
public class LieuManagerImpl extends AbstractManager implements LieuManager {

    @Override
    public void createLieu(Lieu pLieu) {

    }

    @Override
    public Lieu getLieuById(int pId) {
        return null;
    }

    @Override
    public List<Lieu> getListLieux() {
        return null;
    }

    @Override
    public void updateLieu(Lieu pLieu) {

    }

    @Override
    public void deleteLieu(int pId) {

    }
}
