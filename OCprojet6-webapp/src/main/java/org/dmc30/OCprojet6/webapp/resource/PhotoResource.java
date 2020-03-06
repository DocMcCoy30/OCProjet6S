package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Photo;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class PhotoResource extends AbstractResource {

    public void createPhoto (Photo pPhoto) throws TechnicalException {
        getManagerFactory().getPhotoManager().createPhoto(pPhoto);
    }

    public List<Photo> getAllPhotos() {
        return getManagerFactory().getPhotoManager().getAllPhotos();
    }

    public List<Photo> getPhotoByRefId (int pReferenceId, int pRefId) {
        return getManagerFactory().getPhotoManager().getPhotosByRefId (pReferenceId, pRefId);
    }
}
