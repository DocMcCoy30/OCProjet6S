package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.DepartementDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.DepartementRM;
import org.dmc30.OCprojet6.model.bean.Departement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class DepartementDaoImpl extends AbstractDao implements DepartementDao {

    @Inject
    DepartementRM departementRM;

    @Override
    public void createDepartement(Departement pDepartement) {
    }

    @Override
    public Departement getDepartementByCode(int pCode) {
        String vSQL = "SELECT * FROM departement WHERE code="+pCode;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Departement> vListDepartements = vJdbcTemplate.query(vSQL, departementRM);
        Departement vDepartement = vListDepartements.get(0);
        return vDepartement;
    }

    @Override
    public List<Departement> getDepartementsByRegion(int pRegionId) {
        String vSQL = "SELECT * FROM departement WHERE region_id="+pRegionId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Departement> vListDepartements = vJdbcTemplate.query(vSQL, departementRM);
        return vListDepartements;
    }

    @Override
    public List<Departement> getAllDepartements() {
        String vSQL = "SELECT * FROM departement";
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
