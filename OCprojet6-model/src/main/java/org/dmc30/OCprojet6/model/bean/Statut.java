package org.dmc30.OCprojet6.model.bean;

public class Statut {

    private int id;
    private String etat;

    public Statut(int id, String etat) {
        this.id = id;
        this.etat = etat;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
