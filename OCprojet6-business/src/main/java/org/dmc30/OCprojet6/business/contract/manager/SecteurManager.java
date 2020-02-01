package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.Secteur;

import java.util.List;

public interface SecteurManager {

    /**
     * Enregistre un objet de type Secteur dans la database
     */
    void createSecteur (Secteur pSecteur);

    /**
     * Cherche et renvoie un objet de type Secteur stocké dans la database
     * @param pId l'identifiant de l'objet recherché
     * @return l'objet recherché
     */
    Secteur getSecteurById (int pId);

    /**
     * Cherche et renvoie la liste des secteurs d'un même site stockée dans la database
     * @return la liste des secteurs
     */
    List<Secteur> getSecteursBySiteId(int pSiteId);

    /**
     * Cherche et renvoie la liste des objets de type Secteur stockés dans la database
     * @return la liste d'objets recherchée
     */
    List<Secteur> getAllSecteurs();

    /**
     * Modifie un objet de type Secteur
     * @param pSecteur : l'objet à modifier
     */
    void updateSecteur (Secteur pSecteur);

    /**
     * Supprimer un objet de type Secteur
     * @param pId : l'identifiant de l'objet à supprimer
     */
    void deleteSecteur (int pId);
}
