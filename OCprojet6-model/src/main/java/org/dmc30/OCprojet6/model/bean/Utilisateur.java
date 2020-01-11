package org.dmc30.OCprojet6.model.bean;

import java.util.List;

public class Utilisateur {

    private int id;
    private String login;
    private String email;
    private String password;
    private boolean administrateur;
    private List<Site> listSites;
    private List<Topo> listTopos;

    public Utilisateur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(boolean administrateur) {
        this.administrateur = administrateur;
    }

    public List<Site> getListSites() {
        return listSites;
    }

    public void setListSites(List<Site> listSites) {
        this.listSites = listSites;
    }

    public List<Topo> getListTopos() {
        return listTopos;
    }

    public void setListTopos(List<Topo> listTopos) {
        this.listTopos = listTopos;
    }
}
