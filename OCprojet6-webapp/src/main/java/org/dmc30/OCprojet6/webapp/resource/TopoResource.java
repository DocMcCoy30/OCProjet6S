package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Topo;
import org.dmc30.OCprojet6.model.bean.TopoReservation;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class TopoResource extends AbstractResource{

    public void createTopo (Topo pTopo) throws TechnicalException {
        getManagerFactory().getTopoManager().createTopo(pTopo);
    }

    public List<Topo> getTopoBySiteId(Integer pSiteId) {
        return getManagerFactory().getTopoManager().getToposBySiteId(pSiteId);
    }

    public void createTopoReservation (TopoReservation pTopoReservation) throws TechnicalException {
        getManagerFactory().getTopoReservationManager().createTopoReservation(pTopoReservation);
    }

    public Topo getTopoById(Integer vTopoId) {
        return getManagerFactory().getTopoManager().getTopoById(vTopoId);
    }

    public List<TopoReservation> getTopoReservationsByTopoId(int vTopoId) {
        return getManagerFactory().getTopoReservationManager().getTopoReservationsByTopoId(vTopoId);
    }

    public List<Topo> getTopoByUser(String pUserName) {
        return getManagerFactory().getTopoManager().getTopoByUser(pUserName);
    }

    public TopoReservation getTopoReservationById(Integer pReservationId) {
        return getManagerFactory().getTopoReservationManager().getTopoReservationById(pReservationId);
    }

    public void updateTopoReservation(TopoReservation pTopoReservation) throws TechnicalException {
        getManagerFactory().getTopoReservationManager().updateTopoReservation(pTopoReservation);
    }

    public void deleteTopoReservation(Integer pReservationId) {
        getManagerFactory().getTopoReservationManager().deleteTopoReservation(pReservationId);
    }
}
