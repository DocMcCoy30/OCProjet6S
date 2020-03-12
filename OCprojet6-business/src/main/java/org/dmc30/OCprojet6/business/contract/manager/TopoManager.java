package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.Topo;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface TopoManager {

    /**
     * Enregistre un objet de type Topo dans la database.
     */
    void createTopo (Topo pTopo) throws TechnicalException;

    /**
     * Cherche et renvoie un objet de type Topo stocké dans la database.
     * @param pId l'identifiant de l'objet recherché.
     * @return l'objet recherché.
     */
    Topo getTopoById (int pId);

    List<Topo> getToposBySiteId(int pSiteId);

    /**
     * Cherche et renvoie la liste des objets de type Topo stockés dans la database.
     * @return la liste d'objets recherchée.
     */
    List<Topo> getAllTopos();

    /**
     * Modifie un objet de type Topo.
     * @param pTopo : l'objet à modifier.
     */
    void updateTopo (Topo pTopo);

    /**
     * Supprimer un objet de type Topo.
     * @param pId : l'identifiant de l'objet à supprimer.
     */
    void deleteTopo (int pId);

    /**
     * Cherche et récupère les topos d'un utilisateur.
     * @param pUserName Le nom de l'utilisateur.
     * @return La liste des topos liés à l'utilisateur.
     */
    List<Topo> getTopoByUser(String pUserName);
}
