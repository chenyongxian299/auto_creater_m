package com.cyx.dbtools.dbhelper;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper implements IConnection{

    @Override
    public Connection getConnection() {

        return null;
    }
}
