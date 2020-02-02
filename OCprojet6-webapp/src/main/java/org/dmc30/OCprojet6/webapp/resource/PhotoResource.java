package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Photo;

import javax.inject.Named;

@Named
public class PhotoResource extends AbstractResource {


    public void createPhoto (Photo pPhoto) {
        getManagerFactory().getPhotoManager().createPhoto(pPhoto);
    }
}
