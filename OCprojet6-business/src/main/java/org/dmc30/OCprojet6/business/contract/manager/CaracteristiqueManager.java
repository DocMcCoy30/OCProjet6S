package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.Caracteristique;

import java.util.List;

public interface CaracteristiqueManager {

    /**
     * Enregistre un objet de type Caracteristique dans la database
     */
    void createCaracteristique (Caracteristique pCaracteristique);

    /**
     * Cherche et renvoie un objet de type Caracteristique dans la database
     * @param pId l'identifiant de l'objet recherché
     * @return l'objet recherché
     */
    Caracteristique getCaracteristiqueById (int pId);

    /**
     * Cherche et renvoie la liste des objets de type Caracteristique
     * @return la liste d'objets recherchée
     */
    List<Caracteristique> getAllCaracteristiques();

    /**
     * Modifie un objet de type Caracteristique
     * @param pCaracteristique : l'objet à modifier
     */
    void updateCaracteristique (Caracteristique pCaracteristique);

    /**
     * Supprimer un objet de type Caracteristique
     * @param pId : l'identifiant de l'objet à supprimer
     */
    void deleteCaracteristique (int pId);

}
