package org.dmc30.OCprojet6.model.bean;

import java.util.List;

public class Site {

    private int id;
    private String nom;
    private boolean officiel;
    private Description description;
    private TypeRoche typeRoche;

    private Region region;
    private Departement departement;
    private Ville ville;

    private int nbDeSecteurs;
    private int nbDeVoies;
    private int hauteur;
    private List<Photo> listPhotos;
    private List<Topo> listTopos;
    private List<Secteur> listSecteurs;
    private List<Commentaire> listCommentaires;


    public Site() {
    }

    public Site(int id, String nom, boolean officiel) {
        this.id = id;
        this.nom = nom;
        this.officiel = officiel;
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

    public boolean isOfficiel() {
        return officiel;
    }

    public void setOfficiel(boolean officiel) {
        this.officiel = officiel;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public TypeRoche getTypeRoche() {
        return typeRoche;
    }

    public void setTypeRoche(TypeRoche typeRoche) {
        this.typeRoche = typeRoche;
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

    public int getNbDeSecteurs() {
        return nbDeSecteurs;
    }

    public void setNbDeSecteurs(int nbDeSecteurs) {
        this.nbDeSecteurs = nbDeSecteurs;
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

    public List<Secteur> getListSecteurs() {
        return listSecteurs;
    }

    public void setListSecteurs(List<Secteur> listSecteurs) {
        this.listSecteurs = listSecteurs;
    }

    public List<Commentaire> getListCommentaires() {
        return listCommentaires;
    }

    public void setListCommentaires(List<Commentaire> listCommentaires) {
        this.listCommentaires = listCommentaires;
    }
}
