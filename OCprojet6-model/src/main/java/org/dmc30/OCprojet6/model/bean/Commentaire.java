package org.dmc30.OCprojet6.model.bean;

public class Commentaire {

    private int id;
    private String commentaire;
    private Site site;
    private Users users;

    public Commentaire() {
    }

    public Commentaire(int commentaire_id) {
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
