package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.TopoReservation;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface TopoReservationDao {

    void createTopoReservation(TopoReservation pTopoReservation) throws TechnicalException;
    TopoReservation getTopoReservationById(int pId);
    List<TopoReservation> getTopoReservationByTopoId(int pTopoId);
    List<TopoReservation> getAllTopoReservations();
    void updateTopoReservation(TopoReservation pTopoReservation) throws TechnicalException;
    void deleteTopoReservation(int pId);
    List<TopoReservation> getTopoReservationsByUsername(String pUserName);
}
