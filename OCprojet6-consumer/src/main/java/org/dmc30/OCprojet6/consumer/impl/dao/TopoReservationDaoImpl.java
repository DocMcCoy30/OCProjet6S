package org.dmc30.OCprojet6.consumer.impl.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.consumer.contract.dao.TopoReservationDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.TopoReservationRM;
import org.dmc30.OCprojet6.model.bean.TopoReservation;
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
public class TopoReservationDaoImpl extends AbstractDao implements TopoReservationDao {

    @Inject
    TopoReservationRM topoReservationRM;

    Logger logger = LogManager.getLogger(TopoReservationDaoImpl.class);

    @Override
    public void createTopoReservation(TopoReservation pTopoReservation) throws TechnicalException {
        String vSQL = "INSERT INTO topo_reservation (reservation_date, reservation_topo_id, username) VALUES (:vDate, :vTopoId, :vUsername)";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("vDate", pTopoReservation.getDateReservation());
        vParams.addValue("vTopoId", pTopoReservation.getTopo().getId());
        vParams.addValue("vUsername", pTopoReservation.getUser().getUsername());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        try {
            vJdbcTemplate.update(vSQL, vParams);
        } catch (
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
    public TopoReservation getTopoReservationById(int pId) {
        String vSQL = "SELECT * FROM topo_reservation WHERE reservation_id=" + pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<TopoReservation> vListTopoReservations = vJdbcTemplate.query(vSQL, topoReservationRM);
        return vListTopoReservations.get(0);
    }

    @Override
    public List<TopoReservation> getTopoReservationByTopoId(int pTopoId) {
        String vSQL = "SELECT * FROM topo_reservation WHERE reservation_topo_id=" + pTopoId + " ORDER BY reservation_date";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, topoReservationRM);
    }

    @Override
    public List<TopoReservation> getAllTopoReservations() {
        String vSQL = "SELECT * FROM topo_reservation";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, topoReservationRM);
    }

    @Override
    public void updateTopoReservation (TopoReservation pTopoReservation) {

    }

    @Override
    public void deleteTopoReservation(int pId) {

    }

}
