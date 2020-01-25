package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.PhotoDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.PhotoRM;
import org.dmc30.OCprojet6.model.bean.Photo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class PhotoDaoImpl extends AbstractDao implements PhotoDao {

    @Inject
    PhotoRM photoRM;

    @Override
    public void createPhoto(Photo pPhoto) {

    }

    @Override
    public Photo getPhotoById(int pId) {
        String vSQL = "SELECT * FROM photo WHERE photo_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Photo> vListPhotos = vJdbcTemplate.query(vSQL, photoRM);
        Photo vPhoto = vListPhotos.get(0);
        return vPhoto;
    }

    @Override
    public List<Photo> getAllPhotos() {
        String vSQL = "SELECT * FROM photo";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Photo> vListPhotos = vJdbcTemplate.query(vSQL, photoRM);
        return vListPhotos;
    }

    @Override
    public void updatePhoto(Photo pPhoto) {

    }

    @Override
    public void deletePhoto(int pId) {

    }

}
