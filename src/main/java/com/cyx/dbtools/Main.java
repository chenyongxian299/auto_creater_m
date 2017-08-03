package com.cyx.dbtools;

import com.cyx.dbtools.dbhelper.C3P0Connection;
import com.cyx.dbtools.dbhelper.IConnection;
import com.cyx.dbtools.dbhelper.table.impl.TableDescribe;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.util.derby.sys.Sys;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public void kk() throws ClassNotFoundException {
        String userName = "root";
        String password = "share";
        String url = "jdbc:mysql://localhost:3306/node_test?useSSL=false&serverTimezone=GMT";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            Result<Record> result = create.fetch("describe test");
            StringBuffer fields = new StringBuffer("");
            for (Record record : result) {
                fields.append(record.get("Field")).append(", ");
            }

            String field = fields.toString().replaceAll(", $", "");

            create.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg) {
        IConnection iConnection = C3P0Connection.getInstance();
        TableDescribe tableDescribe = new TableDescribe(iConnection);
        String tableFields = tableDescribe.getTableFields("test");
        System.out.println("table test fields : " + tableFields);
    }
}
