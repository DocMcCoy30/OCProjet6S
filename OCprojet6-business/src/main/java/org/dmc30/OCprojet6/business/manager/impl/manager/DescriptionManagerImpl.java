package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.DescriptionManager;
import org.dmc30.OCprojet6.model.bean.Description;

import javax.inject.Named;

@Named
public class DescriptionManagerImpl extends AbstractManager implements DescriptionManager {

    @Override
    public void createCaracteristique(Description pDescription) {

    }

    @Override
    public Description getDescriptionById(int pId) {
        return null;
    }
}
