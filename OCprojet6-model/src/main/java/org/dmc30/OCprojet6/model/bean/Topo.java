package org.dmc30.OCprojet6.model.bean;

import java.util.Date;

public class Topo {

    private int Id;
    private String nom;
    private String description;
    private boolean disponible;
    private Date dateDeParution;
    private Site site;

    public Topo() {
    }

    public Topo(int id, String nom, String description, boolean disponible, Date dateDeParution) {
        Id = id;
        this.nom = nom;
        this.description = description;
        this.disponible = disponible;
        this.dateDeParution = dateDeParution;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Date getDateDeParution() {
        return dateDeParution;
    }

    public void setDateDeParution(Date dateDeParution) {
        this.dateDeParution = dateDeParution;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
