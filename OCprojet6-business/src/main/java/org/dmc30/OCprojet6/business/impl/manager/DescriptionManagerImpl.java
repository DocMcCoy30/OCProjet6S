package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.DescriptionManager;
import org.dmc30.OCprojet6.model.bean.Description;

import javax.inject.Named;

@Named
public class DescriptionManagerImpl extends AbstractManager implements DescriptionManager {

    @Override
    public void createDescription(Description pDescription) {

    }

    @Override
    public Description getDescriptionById(int pId) {
        return null;
    }
}
