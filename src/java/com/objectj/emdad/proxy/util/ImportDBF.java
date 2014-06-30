package com.objectj.emdad.proxy.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class ImportDBF {

	protected static Logger log = Logger.getLogger(ImportDBF.class.getName());

	public ResultSet fetchDBF(String filePath) {		
		try {
			Class.forName("com.hxtt.sql.dbf.DBFDriver");
			Connection connection;
			
			File f = new File(filePath);
						
			String fileName = new String(f.getName());
			String path = new String(f.getParent());
			path = path.replace('\\','/');
			path += File.separator + ".";
									
			if ( fileName != null ){
				 connection = DriverManager.getConnection("jdbc:dbf:/" + path);
			}else{
				 connection = DriverManager.getConnection("jdbc:dbf:/c:/.");
			}
			
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM " + fileName.substring(0,fileName.indexOf("."));
						
			ResultSet resultSet = statement.executeQuery(query);

			return resultSet; 
			
//			while (resultSet.next()) {
//				//resultSet.next();
//				setMoshtarak(resultSet);
//			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}