package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Photo;

import java.util.List;

public interface PhotoDao {

    void createPhoto (Photo pPhoto);
    Photo readPhoto (int pId);
    List<Photo> readAllPhotos ();
    void updatePhoto (Photo pPhoto);
    void deletePhoto(int pId);
}
