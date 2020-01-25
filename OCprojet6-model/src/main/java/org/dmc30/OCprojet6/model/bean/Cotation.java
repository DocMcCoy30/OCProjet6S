package org.dmc30.OCprojet6.model.bean;

public class Cotation {

    private int id;
    private String valeur;

    public Cotation() {
    }

    public Cotation(int cotation_id) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
}
