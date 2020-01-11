package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.PhotoManager;
import org.dmc30.OCprojet6.model.bean.Photo;

import javax.inject.Named;
import java.util.List;

@Named
public class PhotoManagerImpl extends AbstractManager implements PhotoManager {

    @Override
    public void createPhoto(Photo pPhoto) {

    }

    @Override
    public Photo getPhotoById(int pId) {
        return null;
    }

    @Override
    public List<Photo> getListPhotos() {
        return null;
    }

    @Override
    public void updatePhoto(Photo pPhoto) {

    }

    @Override
    public void deletePhoto(Photo pPhoto) {

    }
}
