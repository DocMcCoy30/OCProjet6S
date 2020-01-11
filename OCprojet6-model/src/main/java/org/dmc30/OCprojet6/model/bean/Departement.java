package org.dmc30.OCprojet6.model.bean;

import java.util.List;

public class Departement {

    private int numero;
    private String nom;
    private List<Ville> listVilles;


    public Departement() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Ville> getListVilles() {
        return listVilles;
    }

    public void setListVilles(List<Ville> listVilles) {
        this.listVilles = listVilles;
    }
}
