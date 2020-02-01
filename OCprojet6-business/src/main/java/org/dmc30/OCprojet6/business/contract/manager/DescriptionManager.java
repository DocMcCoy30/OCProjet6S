package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.Description;

public interface DescriptionManager {

    /**
     * Enregistre un objet de type Description dans la database
     */
     void createDescription(Description pDescription);

    /**
     * Cherche et renvoie un objet de type Description dans la database
     * @param pId l'identifiant de l'objet recherché
     * @return l'objet recherché
     */
    Description getDescriptionById (int pId);
}
