package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.consumer.contract.dao.SiteDao;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.bean.Topo;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class TopoRM implements RowMapper<Topo> {

    @Inject
    SiteDao siteDao;

    @Override
    public Topo mapRow(ResultSet resultSet, int i) throws SQLException {
        Topo vTopo = new Topo(resultSet.getInt("topo_id"),
                resultSet.getString("nom"),
                resultSet.getString("description"),
                resultSet.getBoolean("disponible"),
                resultSet.getDate("date_parution"));

        // utilisation de dao
        Site vSite = siteDao.getSiteById(resultSet.getInt("site_id"));
        vTopo.setSite(vSite);
        return vTopo;
    }
}
