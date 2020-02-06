package org.dmc30.OCprojet6.consumer.impl;

import org.dmc30.OCprojet6.consumer.contract.DaoFactory;
import org.dmc30.OCprojet6.consumer.contract.dao.*;

import javax.inject.Inject;
import javax.inject.Named;

@Named("daoFactory")
public class DaoFactoryImpl implements DaoFactory {

    @Inject
    CaracteristiqueDao caracteristiqueDao;
    @Inject
    CommentaireDao commentaireDao;
    @Inject
    CotationDao cotationDao;
    @Inject
    DepartementDao departementDao;
    @Inject
    DescriptionDao descriptionDao;
    @Inject
    PhotoDao photoDao;
    @Inject
    RegionDao regionDao;
    @Inject
    SecteurDao secteurDao;
    @Inject
    SiteDao siteDao;
    @Inject
    TopoDao topoDao;
    @Inject
    TypeRocheDao typeRocheDao;
    @Inject
    UserRoleDao userRoleDao;
    @Inject
    UsersDao usersDao;
    @Inject
    VilleDao villeDao;
    @Inject
    VoieDao voieDao;

    @Override
    public CaracteristiqueDao getCaracteristiqueDao() {
        return caracteristiqueDao;
    }

    @Override
    public void setCaracteristiqueDao(CaracteristiqueDao caracteristiqueDao) {
        this.caracteristiqueDao = caracteristiqueDao;
    }

    @Override
    public CommentaireDao getCommentaireDao() {
        return commentaireDao;
    }

    @Override
    public void setCommentaireDao(CommentaireDao commentaireDao) {
        this.commentaireDao = commentaireDao;
    }

    @Override
    public CotationDao getCotationDao() {
        return cotationDao;
    }

    @Override
    public void setCotationDao(CotationDao cotationDao) {
        this.cotationDao = cotationDao;
    }

    @Override
    public DepartementDao getDepartementDao() {
        return departementDao;
    }

    @Override
    public void setDepartementDao(DepartementDao departementDao) {
        this.departementDao = departementDao;
    }

    @Override
    public DescriptionDao getDescriptionDao() {
        return descriptionDao;
    }

    @Override
    public void setDescriptionDao(DescriptionDao descriptionDao) {
        this.descriptionDao = descriptionDao;
    }

    @Override
    public PhotoDao getPhotoDao() {
        return photoDao;
    }

    @Override
    public void setPhotoDao(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    @Override
    public RegionDao getRegionDao() {
        return regionDao;
    }

    @Override
    public void setRegionDao(RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    @Override
    public SecteurDao getSecteurDao() {
        return secteurDao;
    }

    @Override
    public void setSecteurDao(SecteurDao secteurDao) {
        this.secteurDao = secteurDao;
    }

    @Override
    public SiteDao getSiteDao() {
        return siteDao;
    }

    @Override
    public void setSiteDao(SiteDao siteDao) {
        this.siteDao = siteDao;
    }

    @Override
    public TopoDao getTopoDao() {
        return topoDao;
    }

    @Override
    public void setTopoDao(TopoDao topoDao) {
        this.topoDao = topoDao;
    }

    @Override
    public TypeRocheDao getTypeRocheDao() {
        return typeRocheDao;
    }

    @Override
    public void setTypeRocheDao(TypeRocheDao typeRocheDao) {
        this.typeRocheDao = typeRocheDao;
    }

    @Override
    public UserRoleDao getUserRoleDao() {
        return userRoleDao;
    }

    @Override
    public void setUserRoleDao(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Override
    public UsersDao getUsersDao() {
        return usersDao;
    }

    @Override
    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public VilleDao getVilleDao() {
        return villeDao;
    }

    @Override
    public void setVilleDao(VilleDao villeDao) {
        this.villeDao = villeDao;
    }

    @Override
    public VoieDao getVoieDao() {
        return voieDao;
    }

    @Override
    public void setVoieDao(VoieDao voieDao) {
        this.voieDao = voieDao;
    }
}
