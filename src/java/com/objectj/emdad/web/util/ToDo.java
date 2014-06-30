package com.objectj.emdad.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ToDo {

	static String getConnURL() {
        return (String)System.getProperty("application.connection.url"); //Util.getProperty("application.connection.url");
    }

	static {
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }
	}

    public static int countEntity(String entity, String where) {
        int result = -1;
        Connection c = null;
        Statement sqlSt = null;
        try {
            c = DriverManager.getConnection(getConnURL());
            sqlSt = c.createStatement();
            ResultSet rs;
            if ((where == null) || where.equals(""))
            	rs = sqlSt.executeQuery("select count(*) as cnt from " + entity);
            else
            	rs = sqlSt.executeQuery("select count(*) as cnt from " + entity + " where " + where);
            if (rs.next())
                result = rs.getInt("cnt");
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                sqlSt.close();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
            return result;
        }
    }


}