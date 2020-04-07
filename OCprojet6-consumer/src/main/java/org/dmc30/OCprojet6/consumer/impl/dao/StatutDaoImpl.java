package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.StatutDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.StatutRM;
import org.dmc30.OCprojet6.model.bean.Statut;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class StatutDaoImpl extends AbstractDao implements StatutDao {

    @Inject
    StatutRM statutRM;


    @Override
    public Statut getStatutById(int pId) {
        String vSQL = "SELECT * FROM statut WHERE id="+pId;
        JdbcTemplate vJdbc = new JdbcTemplate(getDataSource());
        List<Statut> vListStatuts = vJdbc.query(vSQL,statutRM);
        return vListStatuts.get(0);
    }

}
