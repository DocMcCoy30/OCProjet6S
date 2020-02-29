package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.TopoReservation;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface TopoReservationManager {

    /**
     * Enregistre un objet de type TopoReservation dans la database.
     */
    void createTopoReservation(TopoReservation pTopoReservation) throws TechnicalException;

    /**
     * Cherche et renvoie un objet de type TopoReservation stocké dans la database.
     * @param pId l'identifiant de l'objet recherché.
     * @return l'objet recherché.
     */
    TopoReservation getTopoReservationById(int pId);

    /**
     * Cherche et renvoie les reservations pour un topo.
     * @param pTopoId L'identifiant du topo concerné.
     * @return La liste des réservations pour ce topo.
     */
    List<TopoReservation> getTopoReservationsByTopoId(int pTopoId);

    /**
     * Cherche et renvoie la liste des objets de type TopoReservation stockés dans la database.
     * @return la liste d'objets recherchée.
     */
    List<TopoReservation> getAllTopoReservations();

    /**
     * Modifie un objet de type TopoReservation.
     * @param pTopoReservation : l'objet à modifier.
     */
    void updateTopoReservation(TopoReservation pTopoReservation);

    /**
     * Supprimer un objet de type TopoReservation.
     * @param pId : l'identifiant de l'objet à supprimer.
     */
    void deleteTopoReservation(int pId);
}
