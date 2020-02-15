package org.dmc30.OCprojet6.model.bean;

import java.util.List;

public class Secteur {

    private int id;
    private String nom;
    private String description;
    private Site site;
    private int hauteurMax;
    private String [] cotationMinMax;
    private int nbDeVoies;
    private List<Voie> listVoies;
    private List<Photo> listPhotos;

    public Secteur() {
    }

    public Secteur(int secteur_id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public int getHauteurMax() {
        return hauteurMax;
    }

    public void setHauteurMax(Integer hauteurMax) {
        this.hauteurMax = hauteurMax;
    }

    public String[] getCotationMinMax() {
        return cotationMinMax;
    }

    public void setCotationMinMax(String[] cotationMinMax) {
        this.cotationMinMax = cotationMinMax;
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
