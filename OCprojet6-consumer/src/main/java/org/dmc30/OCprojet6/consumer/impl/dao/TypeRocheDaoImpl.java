package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.TypeRocheDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.TypeRocheRM;
import org.dmc30.OCprojet6.model.bean.TypeRoche;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TypeRocheDaoImpl extends AbstractDao implements TypeRocheDao {

    @Inject
    TypeRocheRM typeRocheRM;

    @Override
    public void createTypeRoche(TypeRoche pTypeRoche) {

    }

    @Override
    public TypeRoche getTypeRocheById(int pId) {
        String vSQL="SELECT * FROM type_roche WHERE type_roche_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<TypeRoche> vListTypeRoches = vJdbcTemplate.query(vSQL, typeRocheRM);
        return vListTypeRoches.get(0);
    }

    @Override
    public List<TypeRoche> getAllTypeRoches() {
        String vSQL="SELECT * FROM type_roche";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.query(vSQL, typeRocheRM);
    }

    @Override
    public void updateTypeRoche(TypeRoche pTypeRoche) {

    }

    @Override
    public void deleteTypeRoche(int pId) {

    }

}
