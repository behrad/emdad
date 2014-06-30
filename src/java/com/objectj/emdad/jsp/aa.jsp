<%@ page import="java.util.ArrayList,
                 java.util.Iterator,
                 javax.naming.InitialContext,
                 javax.sql.DataSource,
                 java.sql.*,
                 java.util.*"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%

    String connURL = "jdbc:datadirect:sqlserver://222.192.55.22:1433;DatabaseName=emdad;User=sa;Password=anahita";
    String connURL2 = "jdbc:microsoft:sqlserver://222.192.55.22:1433;DatabaseName=emdad;User=sa;Password=anahita";
    //connURL = "jdbc:datadirect:sqlserver://192.168.0.207:1433;DatabaseName=emdad;User=sa;Password=anahita";
    //connURL2 = "jdbc:microsoft:sqlserver://192.168.0.207:1433;DatabaseName=emdad;User=sa;Password=anahita";
	try {
		Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		Class.forName("com.ddtek.jdbc.sqlserver.SQLServerDriver");
	} catch (ClassNotFoundException e) {
		System.err.println("Unable to load JDBC driver");
		e.printStackTrace();
	}


	int n= 100;
    Connection[] cs = new Connection[n];

	try {

		for (int i=0; i<n; i++) {
			long t = (new java.util.Date()).getTime();
			cs[i] = DriverManager.getConnection(connURL);
			System.out.println("getConnection ["+i+"],"+((new java.util.Date()).getTime()-t));

			i++;
			t = (new java.util.Date()).getTime();
			cs[i] = DriverManager.getConnection(connURL2);
			System.out.println("getConnection ["+i+"],"+((new java.util.Date()).getTime()-t));
		}

		/*
		InitialContext c = new InitialContext();
		DataSource ds = (DataSource)c.lookup("java:/emdadDS");
		for (int i=0; i<n; i++) {
			long t = (new java.util.Date()).getTime();
			cs[i] = ds.getConnection();
			cs[i].createStatement();
			System.out.println("getConnection ["+i+"],"+((new java.util.Date()).getTime()-t));
		}
		*/


		for (int i=0; i<n; i++)
			if (cs[i]!=null)
				cs[i].close();

	} catch (Exception e) {
		e.printStackTrace();
	}


%>
Tested.
