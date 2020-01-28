package org.dmc30.OCprojet6.business.manager.impl.manager;

import org.dmc30.OCprojet6.business.manager.contract.manager.SiteManager;
import org.dmc30.OCprojet6.business.manager.contract.manager.VilleManager;
import org.dmc30.OCprojet6.model.bean.Description;
import org.dmc30.OCprojet6.model.bean.Region;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.bean.Ville;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class SiteManagerImpl extends AbstractManager implements SiteManager {

    @Inject
    VilleManager villeManager;

    @Override
    @Transactional
    public Site createSite(Site pSite) {

        Site vNewSite;
        TransactionStatus vTransactionStatus
                = getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
        try {
            vNewSite = pSite;
            // verifier que la ville n'existe pas
            ArrayList<Integer> vListResult = villeManager.rechercheDoublon(pSite.getVille());
            // creer la ville ou la récuperer si elle existe
            if (vListResult.get(0) > 0) {
                Ville vVille = getDaoFactory().getVilleDao().getVilleById(vListResult.get(1));
                vNewSite.setVille(vVille);
            } else if (vListResult.get(0) == 0) {
                getDaoFactory().getVilleDao().createVille(pSite.getVille());
                int vNewVilleId = getDaoFactory().getVilleDao().getLastId();
                Ville vNewVille = getDaoFactory().getVilleDao().getVilleById(vNewVilleId);
                vNewSite.setVille(vNewVille);
            }
            //créer la description
            getDaoFactory().getDescriptionDao().createDescription(pSite.getDescription());
            int vNewDescriptionId = getDaoFactory().getDescriptionDao().getLastId();
            Description vNewDescription = getDaoFactory().getDescriptionDao().getDescriptionById(vNewDescriptionId);
            vNewSite.setDescription(vNewDescription);
            // creer le site dans la base de donnée
            getDaoFactory().getSiteDao().createSite(vNewSite);
            TransactionStatus vTScommit = vTransactionStatus;
            vTransactionStatus = null;
            getPlatformTransactionManager().commit(vTScommit);
        } finally {
            if (vTransactionStatus != null) {
                getPlatformTransactionManager().rollback(vTransactionStatus);
            }
        }
        // renvoyer le site
        return vNewSite;
    }

    @Override
    public Site getSiteById(int pId) {
        Site vSite = getDaoFactory().getSiteDao().getSiteById(pId);
        return vSite;
    }

    @Override
    public List<Site> getSitesByRegion(int pRegionId) {
        return getDaoFactory().getSiteDao().getSitesByRegion(pRegionId);
    }

    @Override
    public List<Site> getSitesByDepartement(int pCode) {
        return getDaoFactory().getSiteDao().getSitesByDepartement(pCode);
    }

    @Override
    public List<Site> getSitesByVille(int pVilleId) {
        return getDaoFactory().getSiteDao().getSitesByVille(pVilleId);
    }

    @Override
    public List<Site> searchSites(int pSiteId,
                                  int pRegionId,
                                  int pDepartementCode,
                                  int pVilleId) {
        return getDaoFactory().getSiteDao().searchSites(pSiteId, pRegionId, pDepartementCode, pVilleId);
    }

    @Override
    public List<Site> getAllSites() {
        List<Site> vListSite = getDaoFactory().getSiteDao().getAllSites();
        return vListSite;
    }

    @Override
    public void updateSite(Site pSite) {
        getDaoFactory().getSiteDao().updateSite(pSite);
    }

    @Override
    public void deleteSite(int pId) {
        getDaoFactory().getSiteDao().deleteSite(pId);
    }
}
