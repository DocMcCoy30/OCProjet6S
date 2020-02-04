package org.dmc30.OCprojet6.consumer.impl.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.consumer.contract.dao.DepartementDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.DepartementRM;
import org.dmc30.OCprojet6.model.bean.Departement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class DepartementDaoImpl extends AbstractDao implements DepartementDao {

Logger logger = LogManager.getLogger(DepartementDaoImpl.class);


    @Inject
    DepartementRM departementRM;

    @Override
    public void createDepartement(Departement pDepartement) {
    }

    @Override
    public Departement getDepartementByCode(int pCode) {
        String vSQL = "SELECT * FROM departement WHERE code= :vCode ORDER BY nom";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("vCode", pCode);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        List<Departement> vListDepartements = vJdbcTemplate.query(vSQL, vParams, departementRM);
        Departement vDepartement = vListDepartements.get(0);
        return vDepartement;
    }

    @Override
    public List<Departement> getDepartementsByRegion(int pRegionId) {
        String vSQL = "SELECT * FROM departement WHERE region_id= :vRegionId ORDER BY nom";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("vRegionId", pRegionId);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        List<Departement> vListDepartements = vJdbcTemplate.query(vSQL, vParams, departementRM);
        return vListDepartements;
    }

    @Override
    public List<Departement> getAllDepartements() {
        String vSQL = "SELECT * FROM departement ORDER BY nom";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Departement> vListDepartements = vJdbcTemplate.query(vSQL, departementRM);
        return vListDepartements;
    }

    @Override
    public void updateDepartement(Departement pDepartement) {

    }

    @Override
    public void deleteDepartement(int pId) {

    }

}
