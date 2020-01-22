package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.DepartementDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.DepartementRM;
import org.dmc30.OCprojet6.model.bean.Departement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import javax.inject.Named;
import java.util.List;

@Named
public class DepartementDaoImpl extends AbstractDao implements DepartementDao {

    @Override
    public void createDepartement(Departement pDepartement) {
    }

    @Override
    public Departement readDepartement(String pCode) {
        String vSQL = "SELECT * FROM departement WHERE code="+pCode;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Departement> departementRowMapper = new DepartementRM();
        List<Departement> vListDepartements = vJdbcTemplate.query(vSQL, departementRowMapper);
        Departement vDepartement = vListDepartements.get(0);
        return vDepartement;
    }

    @Override
    public List<Departement> readDepartementsByRegion (int pRegionId) {
        String vSQL = "SELECT * FROM departement WHERE region_id="+pRegionId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Departement> departementRowMapper = new DepartementRM();
        List<Departement> vListDepartements = vJdbcTemplate.query(vSQL, departementRowMapper);
        return vListDepartements;
    }

    @Override
    public List<Departement> readAllDepartements() {
        String vSQL = "SELECT * FROM departement";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Departement> departementRowMapper = new DepartementRM();
        List<Departement> vListDepartements = vJdbcTemplate.query(vSQL, departementRowMapper);
        return vListDepartements;
    }

    @Override
    public void updateDepartement(Departement pDepartement) {

    }

    @Override
    public void deleteDepartement(int pId) {

    }

}
