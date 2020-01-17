package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.PhotoDao;
import org.dmc30.OCprojet6.model.bean.Photo;

import javax.inject.Named;
import java.util.List;

@Named
public class PhotoDaoImpl extends AbstractDao implements PhotoDao {

    @Override
    public void createPhoto(Photo pPhoto) {

    }

    @Override
    public Photo readPhoto(int pId) {
        return null;
    }

    @Override
    public List<Photo> readAllPhotos() {
        return null;
    }

    @Override
    public void updatePhoto(Photo pPhoto) {

    }

    @Override
    public void deletePhoto(int pId) {

    }
}
