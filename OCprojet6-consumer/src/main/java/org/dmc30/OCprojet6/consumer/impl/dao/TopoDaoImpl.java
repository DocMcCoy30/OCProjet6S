package org.dmc30.OCprojet6.consumer.impl.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.consumer.contract.dao.TopoDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.TopoRM;
import org.dmc30.OCprojet6.model.bean.Topo;
import org.dmc30.OCprojet6.model.exception.ErrorMessages;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TopoDaoImpl extends AbstractDao implements TopoDao {

    Logger logger = LogManager.getLogger(TopoDaoImpl.class);

    @Inject
    TopoRM topoRM;

    @Override
    public void createTopo(Topo pTopo) throws TechnicalException {
        String vSQL = "INSERT INTO topo (nom, date_parution, site_id, username, description)" +
                " VALUES (:vNom, :vDateParution, :vSiteId, :vUsername, :vDescription)";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("vNom", pTopo.getNom());
        vParams.addValue("vDateParution", pTopo.getDateParution());
        vParams.addValue("vSiteId", pTopo.getSite().getId());
        vParams.addValue("vUsername", pTopo.getUser().getUsername());
        vParams.addValue("vDescription", pTopo.getDescription());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        try {
            vJdbcTemplate.update(vSQL, vParams);
        }catch (
                BadSqlGrammarException e) {
            logger.error("Problème de syntaxe dans la requète SQL");
            throw new TechnicalException(ErrorMessages.SQL_SYNTAX_ERROR.getErrorMessage());
        } catch (
                DataAccessException e) {
            logger.error("Problème d'accès à la base de données");
            throw new TechnicalException(ErrorMessages.SQL_UPDATE_ERROR.getErrorMessage());
        } catch (Exception e) {
            logger.error("Problème technique");
            throw new TechnicalException(ErrorMessages.TECHNICAL_ERROR.getErrorMessage());
        }
    }

    @Override
    public Topo getTopoById(int pId) {
        String vSQL="SELECT * FROM topo WHERE topo_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Topo> vListTopos = vJdbcTemplate.query(vSQL, topoRM);
        return vListTopos.get(0);
    }

    @Override
    public List<Topo> getToposBySiteId(int pSiteId) {
        String vSQL="SELECT * FROM topo WHERE site_id="+pSiteId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, topoRM);
    }

    @Override
    public List<Topo> getAllTopos() {
        String vSQL="SELECT * FROM topo";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, topoRM);
    }

    @Override
    public void updateTopo(Topo pTopo) {

    }

    @Override
    public void deleteTopo(int pId) {

    }

    @Override
    public List<Topo> getTopoByUser(String pUserName) {
        String vSQL="SELECT * FROM topo WHERE username='"+pUserName+"'";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, topoRM);
    }

}
