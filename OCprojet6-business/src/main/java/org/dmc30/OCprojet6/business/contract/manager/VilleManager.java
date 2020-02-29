package org.dmc30.OCprojet6.business.contract.manager;

import org.dmc30.OCprojet6.model.bean.Ville;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.ArrayList;
import java.util.List;

public interface VilleManager {

    /**
     * Enregistre une nouvelle ville dans la base de données.
     * @param pVille La nouvelle ville à enregistrer.
     */
    void createVille (Ville pVille) throws TechnicalException;

    /**
     * Recherche une ville dans la base de données par son identifiant.
     * @param pId L'identifiant de la ville.
     * @return La ville correspondante à l'identifiant renseigné.
     */
    Ville getVilleById (int pId);

    /**
     * Cherche et renvoie la liste des Villes d'un département stockée dans la base de données.
     * @param pCode Le code du departement concerné.
     * @return La liste des villes recherchée.
     */
    List<Ville> getListVillesByDepartement(int pCode);

    /**
     * Cherche et renvoie la liste des villes dont le nom correspond aux termes de recherche.
     * @param pMotCle La sequence de caractères renseignée dans la zone de recherche.
     * @return La liste des villes correspondantes.
     */
    List<Ville> getMatchingVilles(String pMotCle);

    /**
     * Cherche et renvoie la liste des Villes stockée dans la base de données.
     * @return La liste des villes.
     */
    List<Ville> getAllVilles();

    /**
     * Modifie un objet de type Ville.
     * @param pVille La ville à modifier.
     */
    void updateVille (Ville pVille);

    /**
     * Supprime un objet de type Ville.
     * @param pId L'identifiant de la ville à supprimer.
     */
    void deleteVille (int pId);

    /**
     * Vérifie que la nouvelle ville n'existe pas déjà dans le database.
     * @param pVille La nouvelle ville renseignée dans le formulaire de création.
     * @return Un tableau contenant les résultats de recherche sous forme de 2 Integer :
     * [vrai ou faux / 0 ou villeId].
     */
    ArrayList<Integer> rechercheDoublon(Ville pVille);

}
