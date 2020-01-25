package org.dmc30.OCprojet6.business.manager.contract.manager;

import org.dmc30.OCprojet6.model.bean.Cotation;

import java.util.List;

public interface CotationManager {

    /**
     * Enregistre un objet de type Cotation dans la database
     */
    void createCotation (Cotation pCotation);

    /**
     * Cherche et renvoie un objet de type Cotation stocké dans la database
     * @param pId l'identifiant de l'objet recherché
     * @return l'objet recherché
     */
    Cotation getCotationById (int pId);

    /**
     * Cherche et renvoie la liste des objets de type Cotation stockés dans la database
     * @return la liste d'objets recherchée
     */
    List<Cotation> getAllCotations();

    /**
     * Modifie un objet de type Cotation
     * @param pCotation : l'objet à modifier
     */
    void updateCotation (Cotation pCotation);

    /**
     * Supprimer un objet de type Cotation
     * @param pId : l'identifiant de l'objet à supprimer
     */
    void deleteCotation (int pId);
}
