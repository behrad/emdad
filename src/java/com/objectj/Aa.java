package com.objectj;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class Aa {

    private static String connURL = "jdbc:datadirect:sqlserver://222.192.55.22:1433;DatabaseName=emdad;User=sa;Password=anahita";
    static {
        try {
            //Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
            Class.forName("com.ddtek.jdbc.sqlserver.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Unable to load JDBC driver");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {

            InitialContext c = new InitialContext();
            DataSource ds = (DataSource)c.lookup("java:/emdadDS");
            long t = (new java.util.Date()).getTime();
            Connection connection = ds.getConnection();
            System.out.println("getConnection "+((new java.util.Date()).getTime()-t));
            Connection c1 = DriverManager.getConnection(connURL);
            System.out.println("getConnection "+((new java.util.Date()).getTime()-t));

            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
