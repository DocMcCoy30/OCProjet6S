package org.dmc30.OCprojet6.model.bean;

import java.util.List;

public class Secteur {

    private int id;
    private String nom;
    private int nbDeVoies;
    private List<Voie> listVoies;
    private List<Photo> listPhotos;

    public Secteur() {
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

    public int getNbDeVoies() {
        return nbDeVoies;
    }

    public void setNbDeVoies(int nbDeVoies) {
        this.nbDeVoies = nbDeVoies;
    }

    public List<Voie> getListVoies() {
        return listVoies;
    }

    public void setListVoies(List<Voie> listVoies) {
        this.listVoies = listVoies;
    }


    public List<Photo> getListPhotos() {
        return listPhotos;
    }

    public void setListPhotos(List<Photo> listPhotos) {
        this.listPhotos = listPhotos;
    }
}
