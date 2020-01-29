package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Description;

import javax.inject.Named;

@Named
public class DescriptionResource extends AbstractResource {

    public Description getDescriptionById (int pId) {
        Description vDescription = getManagerFactory().getDescriptionManager().getDescriptionById(pId);
        return vDescription;
    }
}
