package org.dmc30.OCprojet6.business.manager.contract.manager;

import org.dmc30.OCprojet6.model.bean.Photo;

import java.util.List;

public interface PhotoManager {

    /**
     * Enregistre un objet de type Photo dans la database
     */
    void createPhoto (Photo pPhoto);

    /**
     * Cherche et renvoie un objet de type Photo stocké dans la database
     * @param pId l'identifiant de l'objet recherché
     * @return l'objet recherché
     */
    Photo getPhotoById (int pId);

    /**
     * Cherche et renvoie la liste des objets de type Photo stockés dans la database
     * @return la liste d'objets recherchée
     */
    List<Photo> getListPhotos ();

    /**
     * Modifie un objet de type Photo
     * @param pPhoto : l'objet à modifier
     */
    void updatePhoto (Photo pPhoto);

    /**
     * Supprimer un objet de type Photo
     * @param pPhoto : l'objet à supprimer
     */
    void deletePhoto (Photo pPhoto);
}
