package org.dmc30.OCprojet6.model.bean;

import java.util.List;

public class Region {

    private int id;
    private String nom;
    private List<Departement> listDepartements;

    public Region() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Departement> getListDepartements() {
        return listDepartements;
    }

    public void setListDepartements(List<Departement> listDepartements) {
        this.listDepartements = listDepartements;
    }
}
