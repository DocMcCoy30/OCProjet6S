package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.PhotoDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.PhotoRM;
import org.dmc30.OCprojet6.model.bean.Photo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class PhotoDaoImpl extends AbstractDao implements PhotoDao {

    @Inject
    PhotoRM photoRM;

    @Override
    public void createPhoto(Photo pPhoto) {
        String vSQL = "INSERT INTO photo (nom, ref, ref_id) VALUES (:nom, :ref, :refId)";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", pPhoto.getNom());
        vParams.addValue("ref", pPhoto.getRef());
        vParams.addValue("refId", pPhoto.getRefId());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public Photo getPhotoById(int pId) {
        String vSQL = "SELECT * FROM photo WHERE photo_id=" + pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Photo> vListPhotos = vJdbcTemplate.query(vSQL, photoRM);
        Photo vPhoto = vListPhotos.get(0);
        return vPhoto;
    }

    @Override
    public List<Photo> getPhotosByRefId(int pRefId, String pRef) {
        String vSQL = "SELECT * FROM photo WHERE ref = :ref AND ref_id = :refId";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("ref", pRef);
        vParams.addValue("refId", pRefId);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        List<Photo> vListPhotos = vJdbcTemplate.query(vSQL, vParams, photoRM);
        return vListPhotos;
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
