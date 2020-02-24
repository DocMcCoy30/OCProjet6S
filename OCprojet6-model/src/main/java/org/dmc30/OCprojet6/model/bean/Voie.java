package org.dmc30.OCprojet6.model.bean;

import java.util.List;

public class Voie {

    private int id;
    private String nom;
    private int hauteur;
    private Cotation cotation;
    private Secteur secteur;
    private List<Caracteristique> listCaracteristiques;
    private List<Photo> listPhotos;


    public Voie() {
    }

    public Voie(int id, String nom, int hauteur) {
        this.id = id;
        this.nom = nom;
        this.hauteur = hauteur;
    }

    public Voie(String nom, int hauteur, Cotation cotation, Secteur secteur) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.cotation = cotation;
        this.secteur = secteur;
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

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public Cotation getCotation() {
        return cotation;
    }

    public void setCotation(Cotation cotation) {
        this.cotation = cotation;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
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
