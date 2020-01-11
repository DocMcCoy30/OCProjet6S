package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.UtilisateurManager;
import org.dmc30.OCprojet6.model.bean.Utilisateur;

import javax.inject.Named;
import java.util.List;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

    @Override
    public void createUtilisateur(Utilisateur pUtilisateur) {

    }

    @Override
    public Utilisateur getUtilisateurById(int pId) {
        return null;
    }

    @Override
    public List<Utilisateur> getListUtilisateurs() {
        return null;
    }

    @Override
    public void updateUtilisateur(Utilisateur pUtilisateur) {

    }

    @Override
    public void deleteUtilisateur(Utilisateur pUtilisateur) {

    }
}
