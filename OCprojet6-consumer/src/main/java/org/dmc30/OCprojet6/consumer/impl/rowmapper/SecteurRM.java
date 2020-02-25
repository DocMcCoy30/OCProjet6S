package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.consumer.contract.dao.CotationDao;
import org.dmc30.OCprojet6.consumer.contract.dao.SiteDao;
import org.dmc30.OCprojet6.consumer.contract.dao.VoieDao;
import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.bean.Voie;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class SecteurRM implements RowMapper<Secteur> {

    Logger logger = LogManager.getLogger(SecteurRM.class);

    @Inject
    SiteDao siteDao;
    @Inject
    VoieDao voieDao;
    @Inject
    CotationDao cotationDao;

    @Override
    public Secteur mapRow(ResultSet resultSet, int i) throws SQLException {
        Secteur vSecteur = new Secteur(resultSet.getInt("secteur_id"),
                resultSet.getString("nom"),
                resultSet.getString("description"));

        // utilisation de siteDao
        Site vSite = siteDao.getSiteById(resultSet.getInt("site_id"));
        vSecteur.setSite(vSite);
        // utilisation de voieDao => problème de boucle infinie avec VoieRM qui utilise SecteurRM
//        List<Voie> vListVoies = voieDao.getVoiesBySecteurId(resultSet.getInt("secteur_id"));
//        logger.debug("Liste voies size = "+vListVoies.size());
//        if (!(vListVoies).isEmpty()) {
//            vSecteur.setListVoies(vListVoies);
//            vSecteur.setNbDeVoies(vListVoies.size());
//            int vHauteurMax = voieDao.getHauteurMaxBySecteur(resultSet.getInt("secteur_id"));
//            vSecteur.setHauteurMax(vHauteurMax);
//            int[] vCotationMinMaxId = voieDao.getCotationsMinMaxBySecteur(resultSet.getInt("secteur_id"));
//            //utilisation de cotationDao
//            String vCotationMin = cotationDao.getCotationById(vCotationMinMaxId[0]).getValeur();
//            String vCotationMax = cotationDao.getCotationById(vCotationMinMaxId[1]).getValeur();
//            String[] vCotationMinMax = {vCotationMin, vCotationMax};
//            vSecteur.setCotationMinMax(vCotationMinMax);
//        }
        return vSecteur;
    }
}
