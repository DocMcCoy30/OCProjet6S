package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.VilleManager;
import org.dmc30.OCprojet6.model.bean.Ville;

import javax.inject.Named;
import java.util.List;

@Named
public class VilleManagerImpl extends AbstractManager implements VilleManager {

    @Override
    public void createVille(Ville pVille) {

    }

    @Override
    public Ville getVilleById(int pId) {
        return null;
    }

    @Override
    public List<Ville> getListVilles() {
        return null;
    }

    @Override
    public void updateVille(Ville pVille) {

    }

    @Override
    public void deleteVille(int pId) {

    }
}
