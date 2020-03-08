package org.dmc30.OCprojet6.business.contract;

import org.dmc30.OCprojet6.business.contract.manager.*;

public interface ManagerFactory {


    CommentaireManager getCommentaireManager();

    void setCommentaireManager(CommentaireManager commentaireManager);

    CotationManager getCotationManager();

    void setCotationManager(CotationManager cotationManager);

    DepartementManager getDepartementManager();

    void setDepartementManager(DepartementManager departementManager);

    DescriptionManager getDescriptionManager();

    void setDescriptionManager(DescriptionManager descriptionManager);

    PhotoManager getPhotoManager();

    void setPhotoManager(PhotoManager photoManager);

    RegionManager getRegionManager();

    void setRegionManager(RegionManager regionManager);

    SecteurManager getSecteurManager();

    void setSecteurManager(SecteurManager secteurManager);

    SiteManager getSiteManager();

    void setSiteManager(SiteManager siteManager);

    TopoManager getTopoManager();

    void setTopoManager(TopoManager topoManager);

    TopoReservationManager getTopoReservationManager();

    void setTopoReservationManager(TopoReservationManager topoReservationManager);

    TypeRocheManager getTypeRocheManager();

    void setTypeRocheManager(TypeRocheManager typeRocheManager);

    UsersManager getUsersManager();

    void setUsersManager(UsersManager usersManager);

    UserRolesManager getUserRolesManager();

    void setUserRolesManager(UserRolesManager userRolesManager);

    VilleManager getVilleManager();

    void setVilleManager(VilleManager villeManager);

    VoieManager getVoieManager();

    void setVoieManager(VoieManager voieManager);

    CaracteristiqueManager getCaracteristiqueManager();

    void setCaracteristiqueManager(CaracteristiqueManager caracteristiqueManager);

}
