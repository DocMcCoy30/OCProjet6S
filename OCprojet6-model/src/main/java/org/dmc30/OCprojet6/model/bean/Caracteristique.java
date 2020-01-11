package org.dmc30.OCprojet6.model.bean;

public class Caracteristique {

    private int id;
    private String nom;
    private String definition;

    public Caracteristique() {
    }

    public Caracteristique(int id) {
        this.id = id;
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

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
