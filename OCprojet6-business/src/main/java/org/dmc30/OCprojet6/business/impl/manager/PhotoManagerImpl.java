package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.PhotoManager;
import org.dmc30.OCprojet6.model.bean.Photo;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class PhotoManagerImpl extends AbstractManager implements PhotoManager {

    @Override
    public void createPhoto(Photo pPhoto) throws TechnicalException {
        getDaoFactory().getPhotoDao().createPhoto(pPhoto);

    }

    @Override
    public Photo getPhotoById(int pId) {
        return getDaoFactory().getPhotoDao().getPhotoById(pId);
    }

    @Override
    public List<Photo> getPhotosByRefId(int pRefId, String pRef) {
        return getDaoFactory().getPhotoDao().getPhotosByRefId(pRefId, pRef);
    }

    @Override
    public List<Photo> getAllPhotos() {
        return getDaoFactory().getPhotoDao().getAllPhotos();
    }

    @Override
    public void updatePhoto(Photo pPhoto) {
        getDaoFactory().getPhotoDao().updatePhoto(pPhoto);
    }

    @Override
    public void deletePhoto(int pId) {
        getDaoFactory().getPhotoDao().deletePhoto(pId);
    }
}
