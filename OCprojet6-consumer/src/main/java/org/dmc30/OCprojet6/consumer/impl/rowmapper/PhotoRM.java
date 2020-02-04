package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.Photo;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class PhotoRM implements RowMapper<Photo> {

    Logger logger = LogManager.getLogger(PhotoRM.class);

    @Override
    public Photo mapRow(ResultSet resultSet, int i) throws SQLException {
        Photo vPhoto = new Photo(resultSet.getInt("photo_id"));
        vPhoto.setId(resultSet.getInt("photo_id"));
        vPhoto.setNom(resultSet.getString("nom"));
        vPhoto.setRef(resultSet.getString("ref"));
        vPhoto.setRefId(resultSet.getInt("ref_id"));
        return vPhoto;
    }
}
