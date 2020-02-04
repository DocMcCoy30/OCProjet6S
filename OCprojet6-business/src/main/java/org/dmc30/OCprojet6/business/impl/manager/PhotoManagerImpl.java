package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.PhotoManager;
import org.dmc30.OCprojet6.model.bean.Photo;

import javax.inject.Named;
import java.util.List;

@Named
public class PhotoManagerImpl extends AbstractManager implements PhotoManager {

    @Override
    public void createPhoto(Photo pPhoto) {
        getDaoFactory().getPhotoDao().createPhoto(pPhoto);

    }

    @Override
    public Photo getPhotoById(int pId) {
        Photo vPhoto = getDaoFactory().getPhotoDao().getPhotoById(pId);
        return vPhoto;
    }

    @Override
    public List<Photo> getPhotosByRefId(int pRefId, String pRef) {
        return getDaoFactory().getPhotoDao().getPhotosByRefId(pRefId, pRef);
    }

    @Override
    public List<Photo> getAllPhotos() {
        List<Photo> vListPhoto = getDaoFactory().getPhotoDao().getAllPhotos();
        return vListPhoto;
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
