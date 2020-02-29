package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.consumer.contract.dao.SiteDao;
import org.dmc30.OCprojet6.consumer.contract.dao.UsersDao;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.bean.Topo;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class TopoRM implements RowMapper<Topo> {

    @Inject
    SiteDao siteDao;
    @Inject
    UsersDao usersDao;

    @Override
    public Topo mapRow(ResultSet resultSet, int i) throws SQLException {
        Topo vTopo = null;
        try {
            vTopo = new Topo(resultSet.getInt("topo_id"),
                    resultSet.getString("nom"),
                    resultSet.getDate("date_parution"),
                    siteDao.getSiteById(resultSet.getInt("site_id")),
                    usersDao.getUsersByName(resultSet.getString("username"))
                    );
        } catch (TechnicalException e) {
            e.printStackTrace();
        }
        return vTopo;
    }
}
