package org.dmc30.OCprojet6.model.bean;

import java.util.Date;
import java.util.List;

public class Topo {

    private int id;
    private String nom;
    private Date dateParution;
    private Site site;
    private Users user;
    List<TopoReservation> listReservations;

    public Topo() {
    }

    public Topo(int id, String nom, Date dateParution, Site site, Users user) {
        this.id = id;
        this.nom = nom;
        this.dateParution = dateParution;
        this.site = site;
        this.user = user;
    }

    public Topo(String nom, Date dateParution, Site site, Users user) {
        this.nom = nom;
        this.dateParution = dateParution;
        this.site = site;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateParution() {
        return dateParution;
    }

    public void setDateParution(Date dateParution) {
        this.dateParution = dateParution;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<TopoReservation> getListReservations() {
        return listReservations;
    }

    public void setListReservations(List<TopoReservation> listReservations) {
        this.listReservations = listReservations;
    }
}
