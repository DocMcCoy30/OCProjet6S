package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.TopoDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.TopoRM;
import org.dmc30.OCprojet6.model.bean.Topo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TopoDaoImpl extends AbstractDao implements TopoDao {

    @Inject
    TopoRM topoRM;

    @Override
    public void createTopo(Topo pTopo) {

    }

    @Override
    public Topo getTopoById(int pId) {
        String vSQL="SELECT * FROM topo WHERE topo_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Topo> vListTopos = vJdbcTemplate.query(vSQL, topoRM);
        Topo vTopo = vListTopos.get(0);
        return vTopo;
    }

    @Override
    public List<Topo> getAllTopos() {
        String vSQL="SELECT * FROM topo";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Topo> vListTopos = vJdbcTemplate.query(vSQL, topoRM);
        return vListTopos;
    }

    @Override
    public void updateTopo(Topo pTopo) {

    }

    @Override
    public void deleteTopo(int pId) {

    }

}
