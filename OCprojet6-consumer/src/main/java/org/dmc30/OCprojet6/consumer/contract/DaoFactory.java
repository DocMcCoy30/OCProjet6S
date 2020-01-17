package org.dmc30.OCprojet6.consumer.contract;

import org.dmc30.OCprojet6.consumer.contract.dao.*;

public interface DaoFactory {

    CaracteristiqueDao getCaracteristiqueDao();

    void setCaracteristiqueDao(CaracteristiqueDao caracteristiqueDao);

    CommentaireDao getCommentaireDao();

    void setCommentaireDao(CommentaireDao commentaireDao);

    CotationDao getCotationDao();

    void setCotationDao(CotationDao cotationDao);

    DepartementDao getDepartementDao();

    void setDepartementDao(DepartementDao departementDao);

    LieuDao getLieuDao();

    void setLieuDao(LieuDao lieuDao);

    PhotoDao getPhotoDao();

    void setPhotoDao(PhotoDao photoDao);

    RegionDao getRegionDao();

    void setRegionDao(RegionDao regionDao);

    SecteurDao getSecteurDao();

    void setSecteurDao(SecteurDao secteurDao);

    SiteDao getSiteDao();

    void setSiteDao(SiteDao siteDao);

    TopoDao getTopoDao();

    void setTopoDao(TopoDao topoDao);

    TypeRocheDao getTypeRocheDao();

    void setTypeRocheDao(TypeRocheDao typeRocheDao);

    UserRoleDao getUserRoleDao();

    void setUserRoleDao(UserRoleDao userRoleDao);

    UsersDao getUsersDao();

    void setUsersDao(UsersDao usersDao);

    VilleDao getVilleDao();

    void setVilleDao(VilleDao villeDao);

    VoieDao getVoieDao();

    void setVoieDao(VoieDao voieDao);
}
