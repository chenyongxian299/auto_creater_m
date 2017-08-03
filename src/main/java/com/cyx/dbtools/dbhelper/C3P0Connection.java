package com.cyx.dbtools.dbhelper;



import com.cyx.dbtools.utils.StringUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class C3P0Connection implements IConnection {
    private static ComboPooledDataSource connPool;

    //静态初始化块进行初始化
    static {
        try {
            Properties prop = new Properties();
            InputStream in = C3P0Connection.class.getResourceAsStream("/db_config.properties");
            try {
                prop.load(in);
                connPool = new ComboPooledDataSource();//创建连接池实例
                connPool.setDriverClass(prop.getProperty("c3p0.driver").trim());//设置连接池连接数据库所需的驱动
                connPool.setJdbcUrl(prop.getProperty("c3p0.jdbcUrl").trim());//设置连接数据库的URL
                connPool.setUser(prop.getProperty("c3p0.username").trim());//设置连接数据库的用户名
                connPool.setPassword(prop.getProperty("c3p0.password").trim());//设置连接数据库的密码
                connPool.setMaxPoolSize(StringUtil.toInteger(prop.getProperty("c3p0.maxPoolSize")));//设置连接池的最大连接数
                connPool.setMinPoolSize(StringUtil.toInteger(prop.getProperty("c3p0.minPoolSize")));//设置连接池的最小连接数
                connPool.setInitialPoolSize(StringUtil.toInteger(prop.getProperty("c3p0.initPoolSize")));//设置连接池的初始连接数
                connPool.setMaxStatements(StringUtil.toInteger(prop.getProperty("c3p0.maxStatements")));//设置连接池的缓存Statement的最大数
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private C3P0Connection() {

    }
    private static C3P0Connection c3P0Connection = new C3P0Connection();
    public static IConnection getInstance(){
        return c3P0Connection;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = connPool.getConnection();
        } catch (SQLException e) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(connPool.getJdbcUrl(), connPool.getUser(), connPool.getPassword());
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        }
        return connection;
    }
}
