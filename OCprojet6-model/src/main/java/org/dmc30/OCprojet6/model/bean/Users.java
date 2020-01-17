package org.dmc30.OCprojet6.model.bean;

import java.util.List;

public class Users {

    private String username;
    private String password;
    private String email;
    private int enabled;
    private Authorities authorities;
    private List<Site> listSites;
    private List<Topo> listTopos;

    public Users(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Authorities getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Authorities authorities) {
        this.authorities = authorities;
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
