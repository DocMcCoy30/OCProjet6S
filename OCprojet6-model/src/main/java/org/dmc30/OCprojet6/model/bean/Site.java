package org.dmc30.OCprojet6.model.bean;

import java.util.List;

public class Site {

    private int id;
    private String nom;
    private String description;
    private int nbDeSecteurs;
    private List<Secteur> listSecteurs;
    private int nbDeVoies;
    private int hauteur;
    private TypeRoche typeRoche;
    private List<Commentaire> listCommentaires;
    private boolean officiel;
    private List<Photo> listPhotos;
    private List<Topo> listTopos;
    private Region region;
    private Departement departement;
    private Ville ville;

    public Site() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNbDeSecteurs() {
        return nbDeSecteurs;
    }

    public void setNbDeSecteurs(int nbDeSecteurs) {
        this.nbDeSecteurs = nbDeSecteurs;
    }

    public List<Secteur> getListSecteurs() {
        return listSecteurs;
    }

    public void setListSecteurs(List<Secteur> listSecteurs) {
        this.listSecteurs = listSecteurs;
    }

    public int getNbDeVoies() {
        return nbDeVoies;
    }

    public void setNbDeVoies(int nbDeVoies) {
        this.nbDeVoies = nbDeVoies;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public TypeRoche getTypeRoche() {
        return typeRoche;
    }

    public void setTypeRoche(TypeRoche typeRoche) {
        this.typeRoche = typeRoche;
    }

    public List<Commentaire> getListCommentaires() {
        return listCommentaires;
    }

    public void setListCommentaires(List<Commentaire> listCommentaires) {
        this.listCommentaires = listCommentaires;
    }

    public boolean isOfficiel() {
        return officiel;
    }

    public void setOfficiel(boolean officiel) {
        this.officiel = officiel;
    }

    public List<Photo> getListPhotos() {
        return listPhotos;
    }

    public void setListPhotos(List<Photo> listPhotos) {
        this.listPhotos = listPhotos;
    }

    public List<Topo> getListTopos() {
        return listTopos;
    }

    public void setListTopos(List<Topo> listTopos) {
        this.listTopos = listTopos;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
}
