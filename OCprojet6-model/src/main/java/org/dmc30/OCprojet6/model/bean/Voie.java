package org.dmc30.OCprojet6.model.bean;

import java.util.List;

public class Voie {

    private int id;
    private String nom;
    private Cotation cotation;
    private int hauteur;
    private int nbDePoints;
    private List<Caracteristique> listCaracteristiques;
    private List<Photo> listPhotos;


    public Voie() {
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

    public Cotation getCotation() {
        return cotation;
    }

    public void setCotation(Cotation cotation) {
        this.cotation = cotation;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getNbDePoints() {
        return nbDePoints;
    }

    public void setNbDePoints(int nbDePoints) {
        this.nbDePoints = nbDePoints;
    }

    public List<Caracteristique> getListCaracteristiques() {
        return listCaracteristiques;
    }

    public void setListCaracteristiques(List<Caracteristique> listCaracteristiques) {
        this.listCaracteristiques = listCaracteristiques;
    }

    public List<Photo> getListPhotos() {
        return listPhotos;
    }

    public void setListPhotos(List<Photo> listPhotos) {
        this.listPhotos = listPhotos;
    }
}
