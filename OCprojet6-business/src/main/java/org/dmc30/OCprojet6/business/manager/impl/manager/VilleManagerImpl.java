package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.VilleManager;
import org.dmc30.OCprojet6.model.bean.Ville;

import javax.inject.Named;
import java.util.List;

@Named
public class VilleManagerImpl extends AbstractManager implements VilleManager {

    @Override
    public void createVille(Ville pVille) {
        getDaoFactory().getVilleDao().createVille(pVille);

    }

    @Override
    public Ville getVilleById(int pId) {
        Ville vVille = getDaoFactory().getVilleDao().readVille(pId);
        return vVille;
    }

    @Override
    public List<Ville> getListVilles() {
        List<Ville> vListVille = getDaoFactory().getVilleDao().readAllVilles();
        return vListVille;
    }

    @Override
    public List<Ville> getListVillesByDepartement(String pCode) {
        return getDaoFactory().getVilleDao().readVillesByDepartement(pCode);
    }

    @Override
    public void updateVille(Ville pVille) {
        getDaoFactory().getVilleDao().updateVille(pVille);
    }

    @Override
    public void deleteVille(int pId) {
        getDaoFactory().getVilleDao().deleteVille(pId);
    }
}
