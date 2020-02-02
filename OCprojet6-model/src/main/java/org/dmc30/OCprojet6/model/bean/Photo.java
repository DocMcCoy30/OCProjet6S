package org.dmc30.OCprojet6.model.bean;

public class Photo {

    private int id;
    private String nom;
    private int siteId;
    private int secteurId;
    private int voieId;

    public Photo() {
    }

    public Photo(int photo_id) {
    }

    public Photo(String nom, int siteId, int secteurId, int voieId) {
        this.nom = nom;
        this.siteId = siteId;
        this.secteurId = secteurId;
        this.voieId = voieId;
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

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getSecteurId() {
        return secteurId;
    }

    public void setSecteurId(int secteurId) {
        this.secteurId = secteurId;
    }

    public int getVoieId() {
        return voieId;
    }

    public void setVoieId(int voieId) {
        this.voieId = voieId;
    }
}
