package org.dmc30.OCprojet6.model.bean;

public class Commentaire {

    private int Id;
    private String commentaire;

    public Commentaire() {
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
