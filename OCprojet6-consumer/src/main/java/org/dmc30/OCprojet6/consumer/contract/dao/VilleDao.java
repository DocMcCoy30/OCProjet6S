package org.dmc30.OCprojet6.consumer.contract.dao;

import org.dmc30.OCprojet6.model.bean.Ville;

import java.util.List;

public interface VilleDao {

    void createVille (Ville pVille);
    Ville getVilleById(int pId);
    List<Ville> getVillesByDepartement(String pCode);
    List<Ville> getAllVilles();
    void updateVille (Ville pVille);
    void deleteVille(int pId);


}
