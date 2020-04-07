package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.consumer.contract.dao.CotationDao;
import org.dmc30.OCprojet6.consumer.contract.dao.SiteDao;
import org.dmc30.OCprojet6.consumer.contract.dao.VoieDao;
import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.bean.Site;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        return vSecteur;
    }
}
