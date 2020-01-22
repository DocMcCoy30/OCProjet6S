package org.dmc30.OCprojet6.model.bean;

import java.util.List;

public class Departement {

    private String code;
    private String nom;
    private List<Ville> listVilles;


    public Departement() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Ville> getListVilles() {
        return listVilles;
    }

    public void setListVilles(List<Ville> listVilles) {
        this.listVilles = listVilles;
    }
}
