package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.VilleManager;
import org.dmc30.OCprojet6.model.bean.Ville;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class VilleManagerImpl extends AbstractManager implements VilleManager {

    @Override
    public void createVille(Ville pVille) {
        getDaoFactory().getVilleDao().createVille(pVille);

    }

    @Override
    public Ville getVilleById(int pId) {
        return getDaoFactory().getVilleDao().getVilleById(pId);
    }

    @Override
    public List<Ville> getAllVilles() {
        return getDaoFactory().getVilleDao().getAllVilles();
    }

    @Override
    public List<Ville> getListVillesByDepartement(String pCode) {
        return getDaoFactory().getVilleDao().getVillesByDepartement(pCode);
    }

    @Override
    public void updateVille(Ville pVille) {
        getDaoFactory().getVilleDao().updateVille(pVille);
    }

    @Override
    public void deleteVille(int pId) {
        getDaoFactory().getVilleDao().deleteVille(pId);
    }

    @Override
    public ArrayList<Integer> rechercheDoublon(Ville pVille) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> vListResult = new ArrayList<>();
        List<Ville> vListVille = getDaoFactory().getVilleDao().getAllVilles();
        for (Ville vVille: vListVille) {
            if (vVille.getNom().equalsIgnoreCase(pVille.getNom())) {
                if (vVille.getDepartement().getCode() == (pVille.getDepartement().getCode())) {
                    i++;
                    j = vVille.getId();
                }
            }
        }
        vListResult.add(i);
        vListResult.add(j);
        return vListResult;
    }
}

