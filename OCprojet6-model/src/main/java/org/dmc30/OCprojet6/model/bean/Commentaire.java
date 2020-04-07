package org.dmc30.OCprojet6.model.bean;

import java.util.Date;

public class Commentaire {

    private int id;
    private String commentaire;
    private Users users;
    private Date date;
    private int referenceId;
    private int refId;
    private boolean valide;

    public Commentaire() {
    }

    public Commentaire(int id, String commentaire, Date date, int referenceId, int refId, boolean valide) {
        this.id = id;
        this.commentaire = commentaire;
        this.date = date;
        this.referenceId = referenceId;
        this.refId = refId;
        this.valide = valide;
    }

    public Commentaire(String commentaire, Users users, Date date, int referenceId, int refId, boolean valide) {
        this.commentaire = commentaire;
        this.users = users;
        this.date = date;
        this.referenceId = referenceId;
        this.refId = refId;
        this.valide = valide;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }

    public int getRefId() {
        return refId;
    }

    public void setRefId(int refId) {
        this.refId = refId;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }
}
