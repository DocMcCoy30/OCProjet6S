package org.dmc30.OCprojet6.model.bean;

public class Photo {

    private int id;
    private String nom;
    private String ref;
    private int refId;

    public Photo() {
    }

    public Photo(String nom, String ref, int refId) {
        this.nom = nom;
        this.ref = ref;
        this.refId = refId;
    }

    public Photo(int id, String nom, String ref, int refId) {
        this.id = id;
        this.nom = nom;
        this.ref = ref;
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

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getRefId() {
        return refId;
    }

    public void setRefId(int refId) {
        this.refId = refId;
    }
}
