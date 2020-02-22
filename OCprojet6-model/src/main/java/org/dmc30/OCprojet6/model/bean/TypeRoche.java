package org.dmc30.OCprojet6.model.bean;

public class TypeRoche {

    private int id;
    private String nom;
    //calcaire, gres, granite, basalte, quarztite, migmatite, gneiss, silex, conglomerats, schiste, inconnu


    public TypeRoche() {
    }

    public TypeRoche(int id, String nom) {
        this.id = id;
        this.nom = nom;
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
}
