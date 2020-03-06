package org.dmc30.OCprojet6.model.bean;

import java.util.Date;

public class Commentaire {

    private int id;
    private String titre;
    private String commentaire;
    private Users users;
    private Date date;
    private int reference_id;
    private int ref_id;
    private boolean valide;

    public Commentaire() {
    }

    public Commentaire(int id, String titre, String commentaire, Date date, int reference_id, int ref_id, boolean valide) {
        this.id = id;
        this.titre = titre;
        this.commentaire = commentaire;
        this.users = users;
        this.date = date;
        this.reference_id = reference_id;
        this.ref_id = ref_id;
        this.valide = valide;
    }

    public Commentaire(String titre, String commentaire, Users users, Date date, int reference_id, int ref_id, boolean valide) {
        this.titre = titre;
        this.commentaire = commentaire;
        this.users = users;
        this.date = date;
        this.reference_id = reference_id;
        this.ref_id = ref_id;
        this.valide = valide;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public int getReference_id() {
        return reference_id;
    }

    public void setReference_id(int reference_id) {
        this.reference_id = reference_id;
    }

    public int getRef_id() {
        return ref_id;
    }

    public void setRef_id(int ref_id) {
        this.ref_id = ref_id;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }
}
