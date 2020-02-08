package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.Ville;

import java.util.ArrayList;
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
    List<Ville> getAllVilles();

    /**
     * Cherche et renvoie la liste des Villes d'un département dans la database
     * @param pCode le code du departement concerné
     * @return la liste d'objets recherchée
     */
    List<Ville> getListVillesByDepartement(int pCode);

    /**
     * Modifie un objet de type Ville
     * @param pVille : l'objet à modifier
     */
    void updateVille (Ville pVille);

    /**
     * Supprimer un objet de type Ville
     * @param pId : l'identifiant de l'objet à supprimer
     */
    void deleteVille (int pId);

    /**
     * Vérifie que la nouvelle ville n'existe pas déjà dans le database
     * @param pVille la nouvelle ville renseignée dans le formulaire de création
     * @return un tableau contenant les résultats de recherche sous forme de 2 Integer :
     * [vrai ou faux / 0 ou villeId]
     */
    ArrayList<Integer> rechercheDoublon(Ville pVille);
}
