package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.CotationDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.CotationRM;
import org.dmc30.OCprojet6.model.bean.Cotation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CotationDaoImpl extends AbstractDao implements CotationDao {

    @Inject
    CotationRM cotationRM;

    @Override
    public void createCotation(Cotation pCotation) {

    }

    @Override
    public Cotation getCotationById(int pId) {
        String vSQL="SELECT * FROM cotation WHERE cotation_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Cotation> vListCotations = vJdbcTemplate.query(vSQL, cotationRM);
        Cotation vCotation = vListCotations.get(0);
        return vCotation;
    }

    @Override
    public List<Cotation> getAllCotations() {
        String vSQL="SELECT * FROM cotation";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Cotation> vListCotations = vJdbcTemplate.query(vSQL, cotationRM);
        return vListCotations;
    }

    @Override
    public void updateCotation(Cotation pCotation) {

    }

    @Override
    public void deleteCotation(int pId) {

    }

}
