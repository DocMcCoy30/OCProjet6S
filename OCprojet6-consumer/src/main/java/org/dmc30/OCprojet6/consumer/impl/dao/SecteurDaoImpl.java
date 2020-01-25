package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.SecteurDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.SecteurRM;
import org.dmc30.OCprojet6.model.bean.Secteur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SecteurDaoImpl extends AbstractDao implements SecteurDao {

    @Inject
    SecteurRM secteurRM;

    @Override
    public void createSecteur(Secteur pSecteur) {
    }

    @Override
    public Secteur getSecteurById(int pId) {
        String vSQL = "SELECT * FROM secteur WHERE secteur_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Secteur> vListSecteurs = vJdbcTemplate.query(vSQL, secteurRM);
        Secteur vSecteur = vListSecteurs.get(0);
        return vSecteur;
    }

    @Override
    public List<Secteur> getSecteursBySite(int pSiteId) {
        String vSQL = "SELECT * FROM secteur WHERE site_id="+pSiteId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Secteur> vListSecteurs = vJdbcTemplate.query(vSQL, secteurRM);
        return vListSecteurs;
    }

    @Override
    public List<Secteur> getAllSecteurs() {
        String vSQL = "SELECT * FROM secteur";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Secteur> vListSecteurs = vJdbcTemplate.query(vSQL, secteurRM);
        return vListSecteurs;
    }

    @Override
    public void updateSecteur(Secteur pSecteur) {

    }

    @Override
    public void deleteSecteur(int pId) {

    }

}
