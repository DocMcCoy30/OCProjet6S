package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.LieuDao;
import org.dmc30.OCprojet6.model.bean.Lieu;

import javax.inject.Named;
import java.util.List;

@Named
public class LieuDaoImpl extends AbstractDao implements LieuDao {

    @Override
    public void createLieu(Lieu pLieu) {

    }

    @Override
    public Lieu readLieu(int pId) {
        return null;
    }

    @Override
    public List<Lieu> readAllLieux() {
        return null;
    }

    @Override
    public void updateLieu(Lieu pLieu) {

    }

    @Override
    public void deleteLieu(int pId) {

    }
}
