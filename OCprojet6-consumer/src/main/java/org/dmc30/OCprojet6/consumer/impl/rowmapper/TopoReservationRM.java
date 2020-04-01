package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.consumer.contract.dao.StatutDao;
import org.dmc30.OCprojet6.consumer.contract.dao.TopoDao;
import org.dmc30.OCprojet6.consumer.contract.dao.UsersDao;
import org.dmc30.OCprojet6.model.bean.TopoReservation;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;


@Named
public class TopoReservationRM implements RowMapper<TopoReservation> {

    @Inject
    TopoDao topoDao;
    @Inject
    UsersDao usersDao;
    @Inject
    StatutDao statutDao;

    @Override
    public TopoReservation mapRow(ResultSet resultSet, int i) throws SQLException {
        TopoReservation vTopoReservation = null;

        try {
            vTopoReservation = new TopoReservation(resultSet.getInt("reservation_id"),
                    resultSet.getDate("reservation_date"),
                    topoDao.getTopoById(resultSet.getInt("reservation_topo_id")),
                    usersDao.getUsersByName(resultSet.getString("username")),
                    statutDao.getStatutById(resultSet.getInt("id")));
        } catch (TechnicalException e) {
            e.printStackTrace();
        }
        return vTopoReservation;
    }
}
