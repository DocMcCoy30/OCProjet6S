package org.dmc30.OCprojet6.business.manager.contract.manager;

import org.dmc30.OCprojet6.model.bean.Ville;

import java.util.List;

public interface VilleManager {

    /**
     * Enregistre un objet de type Ville dans la database
     */
    void createVille (Ville pVille);

    /**
     * Cherche et renvoie un objet de type Ville stocké dans la database
     * @param pId l'identifiant de l'objet recherché
     * @return l'objet recherché
     */
    Ville getVilleById (int pId);

    /**
     * Cherche et renvoie la liste des objets de type Ville stockés dans la database
     * @return la liste d'objets recherchée
     */
    List<Ville> getListVilles ();

    /**
     * Modifie un objet de type Ville
     * @param pVille : l'objet à modifier
     */
    void updateVille (Ville pVille);

    /**
     * Supprimer un objet de type Ville
     * @param pVille : l'objet à supprimer
     */
    void deleteVille (Ville pVille);
}
