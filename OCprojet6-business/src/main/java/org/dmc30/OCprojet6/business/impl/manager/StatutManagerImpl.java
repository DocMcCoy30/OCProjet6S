package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.StatutManager;
import org.dmc30.OCprojet6.model.bean.Statut;

import javax.inject.Named;

@Named
public class StatutManagerImpl extends AbstractManager implements StatutManager {

    @Override
    public Statut getStatutById(int pId) {
        return getDaoFactory().getStatutDao().getStatutById(pId);
    }
}
