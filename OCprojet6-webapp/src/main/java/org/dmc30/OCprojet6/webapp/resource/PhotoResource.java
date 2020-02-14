package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Photo;

import javax.inject.Named;
import java.util.List;

@Named
public class PhotoResource extends AbstractResource {

    public void createPhoto (Photo pPhoto) {
        getManagerFactory().getPhotoManager().createPhoto(pPhoto);
    }

    public List<Photo> getAllPhotos() {
        return getManagerFactory().getPhotoManager().getAllPhotos();
    }

    public List<Photo> getPhotoByRefId (int pRefId, String pRef) {
        return getManagerFactory().getPhotoManager().getPhotosByRefId (pRefId, pRef);
    }
}
