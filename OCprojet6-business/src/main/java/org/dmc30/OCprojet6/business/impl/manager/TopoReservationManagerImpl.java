package org.dmc30.OCprojet6.business.impl.manager;

import org.dmc30.OCprojet6.business.contract.manager.TopoReservationManager;
import org.dmc30.OCprojet6.model.bean.TopoReservation;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named
public class TopoReservationManagerImpl extends AbstractManager implements TopoReservationManager {

    @Override
    public void createTopoReservation(TopoReservation pTopoReservation) throws TechnicalException {
        getDaoFactory().getTopoReservationDao().createTopoReservation(pTopoReservation);
    }

    @Override
    public TopoReservation getTopoReservationById(int pId) {
        return getDaoFactory().getTopoReservationDao().getTopoReservationById(pId);
    }

    @Override
    public List<TopoReservation> getTopoReservationsByTopoId(int pTopoId) {
        return getDaoFactory().getTopoReservationDao().getTopoReservationByTopoId(pTopoId);
    }

    @Override
    public List<TopoReservation> getAllTopoReservations() {
        return null;
    }

    @Override
    public void updateTopoReservation(TopoReservation pTopoReservation) throws TechnicalException {
        getDaoFactory().getTopoReservationDao().updateTopoReservation(pTopoReservation);
    }

    @Override
    public void deleteTopoReservation(int pId) {
        getDaoFactory().getTopoReservationDao().deleteTopoReservation(pId);
    }

    @Override
    public List<TopoReservation> getTopoReservationsByUsername(String pUserName) {
        return getDaoFactory().getTopoReservationDao().getTopoReservationsByUsername(pUserName);
    }
}
