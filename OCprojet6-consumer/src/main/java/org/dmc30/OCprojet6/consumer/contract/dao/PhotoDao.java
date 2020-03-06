package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Photo;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface PhotoDao {

    void createPhoto (Photo pPhoto) throws TechnicalException;
    Photo getPhotoById(int pId);
    List<Photo> getPhotosByRefId( int pReferenceId, int pRefId);
    List<Photo> getAllPhotos();
    void updatePhoto (Photo pPhoto);
    void deletePhoto(int pId);


}
