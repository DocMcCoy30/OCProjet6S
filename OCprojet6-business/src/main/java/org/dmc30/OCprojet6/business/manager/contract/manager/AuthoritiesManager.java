package org.dmc30.OCprojet6.business.manager.contract.manager;

import org.dmc30.OCprojet6.model.bean.Authorities;

import java.util.List;

public interface AuthoritiesManager {

    /**
     * Enregistre un objet de type Authorities dans la database
     */
    void createAuthorities (Authorities pAuthorities);

    /**
     * Cherche et renvoie un objet de type Authorities dans la database
     * @param pUsername l'identifiant de l'objet recherché
     * @return l'objet recherché
     */
    Authorities getAuthorities(String pUsername);

    /**
     * Cherche et renvoie la liste des objets de type Authorities
     * @return la liste d'objets recherchée
     */
    List<Authorities> getListAuthorities();

    /**
     * Modifie un objet de type Authorities
     * @param pAuthorities : l'objet à modifier
     */
    void updateAuthorities(Authorities pAuthorities);

    /**
     * Supprimer un objet de type Authorities
     * @param pId : l'identifiant de l'objet à supprimer
     */
    void deleteAuthorities(int pId);

}
