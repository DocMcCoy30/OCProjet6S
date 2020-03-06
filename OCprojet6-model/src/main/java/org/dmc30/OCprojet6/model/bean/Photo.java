package org.dmc30.OCprojet6.model.bean;

public class Photo {

    private int id;
    private String nom;
    private int referenceId;
    private int refId;

    public Photo() {
    }

    public Photo(String nom, int referenceId, int refId) {
        this.nom = nom;
        this.referenceId = referenceId;
        this.refId = refId;
    }

    public Photo(int id, String nom, int referenceId, int refId) {
        this.id = id;
        this.nom = nom;
        this.referenceId = referenceId;
        this.refId = refId;
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


    public int getRefId() {
        return refId;
    }

    public void setRefId(int refId) {
        this.refId = refId;
    }

    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }
}
