package org.dmc30.OCprojet6.business.impl;

import org.dmc30.OCprojet6.business.contract.ManagerFactory;
import org.dmc30.OCprojet6.business.contract.manager.*;

import javax.inject.Inject;
import javax.inject.Named;

@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    CaracteristiqueManager caracteristiqueManager;
    @Inject
    CommentaireManager commentaireManager;
    @Inject
    CotationManager cotationManager;
    @Inject
    DepartementManager departementManager;
    @Inject
    DescriptionManager descriptionManager;
    @Inject
    PhotoManager photoManager;
    @Inject
    RegionManager regionManager;
    @Inject
    SecteurManager secteurManager;
    @Inject
    SiteManager siteManager;
    @Inject
    TopoManager topoManager;
    @Inject
    TypeRocheManager typeRocheManager;
    @Inject
    UsersManager usersManager;
    @Inject
    VilleManager villeManager;
    @Inject
    VoieManager voieManager;

    @Override
    public CaracteristiqueManager getCaracteristiqueManager() {
        return caracteristiqueManager;
    }

    @Override
    public void setCaracteristiqueManager(CaracteristiqueManager caracteristiqueManager) {
        this.caracteristiqueManager = caracteristiqueManager;
    }

    @Override
    public CommentaireManager getCommentaireManager() {
        return commentaireManager;
    }

    @Override
    public void setCommentaireManager(CommentaireManager commentaireManager) {
        this.commentaireManager = commentaireManager;
    }

    @Override
    public CotationManager getCotationManager() {
        return cotationManager;
    }

    @Override
    public void setCotationManager(CotationManager cotationManager) {
        this.cotationManager = cotationManager;
    }

    @Override
    public DepartementManager getDepartementManager() {
        return departementManager;
    }

    @Override
    public void setDepartementManager(DepartementManager departementManager) {
        this.departementManager = departementManager;
    }

    @Override
    public DescriptionManager getDescriptionManager() {
        return descriptionManager;
    }

    @Override
    public void setDescriptionManager(DescriptionManager descriptionManager) {
        this.descriptionManager = descriptionManager;
    }

    @Override
    public PhotoManager getPhotoManager() {
        return photoManager;
    }

    @Override
    public void setPhotoManager(PhotoManager photoManager) {
        this.photoManager = photoManager;
    }

    @Override
    public RegionManager getRegionManager() {
        return regionManager;
    }

    @Override
    public void setRegionManager(RegionManager regionManager) {
        this.regionManager = regionManager;
    }

    @Override
    public SecteurManager getSecteurManager() {
        return secteurManager;
    }

    @Override
    public void setSecteurManager(SecteurManager secteurManager) {
        this.secteurManager = secteurManager;
    }

    @Override
    public SiteManager getSiteManager() {
        return siteManager;
    }

    @Override
    public void setSiteManager(SiteManager siteManager) {
        this.siteManager = siteManager;
    }

    @Override
    public TopoManager getTopoManager() {
        return topoManager;
    }

    @Override
    public void setTopoManager(TopoManager topoManager) {
        this.topoManager = topoManager;
    }

    @Override
    public TypeRocheManager getTypeRocheManager() {
        return typeRocheManager;
    }

    @Override
    public void setTypeRocheManager(TypeRocheManager typeRocheManager) {
        this.typeRocheManager = typeRocheManager;
    }

    @Override
    public UsersManager getUsersManager() {
        return usersManager;
    }

    @Override
    public void setUsersManager(UsersManager usersManager) {
        this.usersManager = usersManager;
    }

    @Override
    public VilleManager getVilleManager() {
        return villeManager;
    }

    @Override
    public void setVilleManager(VilleManager villeManager) {
        this.villeManager = villeManager;
    }

    @Override
    public VoieManager getVoieManager() {
        return voieManager;
    }

    @Override
    public void setVoieManager(VoieManager voieManager) {
        this.voieManager = voieManager;
    }

}
