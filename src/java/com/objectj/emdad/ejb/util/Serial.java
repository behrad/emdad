/**
 * Created by IntelliJ IDEA.
 * User: raheleh
 * Date: Jun 22, 2003
 * Time: 4:03:00 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb.util;

import java.sql.*;

public class Serial {
	static String getConnURL() {
        return (String)Util.get("application.connection.url");
    }

//	static {
//        try {
//            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
//        } catch (Exception e) {
//            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
//        }
//	}


    public static String getSerialCode(Integer year, String kind){
        String serialCode = null;
        Connection c = null;
        Statement sqlSt = null;
        try {
            c = DriverManager.getConnection(getConnURL());
            sqlSt = c.createStatement();
            String query = "select serial from serials where kind='"+ kind + "' and year=" + year;
            ResultSet rs = sqlSt.executeQuery(query);
            if (rs.next()){
                serialCode = String.valueOf(Integer.valueOf(rs.getString("serial")).intValue() + 1);
                int ls = Integer.valueOf(serialCode).intValue();
                query="update serials set serial="+ ls +" where kind='"+kind+"' and year=" + year;
                sqlSt.executeUpdate(query);
            }else{
                sqlSt.executeUpdate("insert into serials (year, kind, serial) values("+year+",'"+kind+"', 1)");
                serialCode = "1";
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                sqlSt.close();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use Options | File Templates.
            }
            return serialCode;
        }
    }
}
