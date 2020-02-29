package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Ville;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import java.util.List;

public interface VilleDao {

    void createVille (Ville pVille) throws TechnicalException;
    Ville getVilleById(int pId);
    List<Ville> getVillesByDepartement(int pCode);
    List<Ville> getMatchingVilles(String pMotCle);
    List<Ville> getAllVilles();
    int getLastId();
    void updateVille (Ville pVille);
    void deleteVille(int pId);



}
