<?xml version="1.0" encoding="UTF-8"?>
<%@page contentType="text/xml;charset=UTF-8" import="java.sql.*,java.sql.Connection,java.sql.SQLException,java.sql.DriverManager,com.objectj.emdad.ejb.util.*"%>
<%
String fields=request.getParameter("fields").trim();
String driver = "com.ddtek.jdbc.sqlserver.SQLServerDriver";
Connection con = Util.getConnection();
String path=request.getRealPath(request.getContextPath());
//path=path.subString(0,path.length()-"\\getQuery.jsp".length());
/*DataOutputStream writer=new DataOutputStream(new FileOutputStream(path"\\result.xml"));
writer.writeBytes("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");*/


try {
	Statement statement = con.createStatement();
	ResultSet rs =null;
	if(request.getParameter("condition")==null ||
		request.getParameter("condition").trim().length()==0){
		//System.out.println("select "+request.getParameter("fields")+" from "+ request.getParameter("table"));
		rs=statement.executeQuery("select "+request.getParameter("fields")+" from " + request.getParameter("table"));
	}
	else{
		//System.out.println("select "+request.getParameter("fields")+" from "+ request.getParameter("table") + " where " +request.getParameter("condition"));
		rs=statement.executeQuery("select "+request.getParameter("fields")+" from " + request.getParameter("table") + " where " +request.getParameter("condition"));
	}
	int j=0;
	if (rs.next()) {
		%><row Title="<%= request.getParameter("table") %>"><%
		for(int i=0;i<rs.getMetaData().getColumnCount();i++){
			%><<%= rs.getMetaData().getColumnName(i+1) %> fieldId="n_<%= i %>" Title="<%= rs.getString(i+1) %>"></<%=rs.getMetaData().getColumnName(i+1)%>><%
		}
		j++;
    }
	else{
		%><row><%
	}
    statement.close();
    con.close();
    } finally {
 	   if (con != null) con.close();
    }
%>
</row>