package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.VilleDao;
import org.dmc30.OCprojet6.model.bean.Ville;

import javax.inject.Named;
import java.util.List;

@Named
public class VilleDaoImpl extends AbstractDao implements VilleDao {

    @Override
    public void createVille(Ville pVille) {

    }

    @Override
    public Ville readVille(int pId) {
        return null;
    }

    @Override
    public List<Ville> readAllVilles() {
        return null;
    }

    @Override
    public void updateVille(Ville pVille) {

    }

    @Override
    public void deleteVille(int pId) {

    }
}
