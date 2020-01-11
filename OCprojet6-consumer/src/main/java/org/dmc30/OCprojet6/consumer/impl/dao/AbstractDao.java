package org.dmc30.OCprojet6.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDao {

    @Inject
    @Named("dataSourceOCprojet6")
    private DataSource dataSource;

    protected DataSource getDataSource() {
        return dataSource;
    }

}