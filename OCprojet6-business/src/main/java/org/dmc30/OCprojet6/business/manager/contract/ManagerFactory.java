package org.dmc30.OCprojet6.business.manager.contract;

import org.dmc30.OCprojet6.business.manager.contract.manager.*;

public interface ManagerFactory {


    CommentaireManager getCommentaireManager();

    void setCommentaireManager(CommentaireManager commentaireManager);

    CotationManager getCotationManager();

    void setCotationManager(CotationManager cotationManager);

    DepartementManager getDepartementManager();

    void setDepartementManager(DepartementManager departementManager);

    LieuManager getLieuManager();

    void setLieuManager(LieuManager lieuManager);

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

    TypeRocheManager getTypeRocheManager();

    void setTypeRocheManager(TypeRocheManager typeRocheManager);

    UsersManager getUsersManager();

    void setUsersManager(UsersManager usersManager);

    VilleManager getVilleManager();

    void setVilleManager(VilleManager villeManager);

    VoieManager getVoieManager();

    void setVoieManager(VoieManager voieManager);

    AuthoritiesManager getAuthoritiesManager();

    void setAuthoritiesManager(AuthoritiesManager authoritiesManager);

    abstract CaracteristiqueManager getCaracteristiqueManager();

    abstract void setCaracteristiqueManager(CaracteristiqueManager caracteristiqueManager);
}
