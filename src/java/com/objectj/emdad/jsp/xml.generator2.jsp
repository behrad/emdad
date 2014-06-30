<?xml version="1.0" encoding="UTF-8"?>
<%@page contentType="text/xml;charset=UTF-8" import="java.sql.*,java.sql.Connection,java.sql.SQLException,java.sql.DriverManager,com.objectj.emdad.ejb.util.*,
                                                     com.objectj.emdad.ejb.UserAccessEntity"%>
<%
/*
String driver = "com.ddtek.jdbc.sqlserver.SQLServerDriver";
Connection con = Util.getConnection();
String path=request.getRealPath(request.getContextPath());
path=path.subString(0,path.length()-"\\getQuery.jsp".length());
DataOutputStream writer=new DataOutputStream(new FileOutputStream(path"\\result.xml"));
writer.writeBytes("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
*/

    Connection c=null;
    Statement statement=null;
    ResultSet rs=null;
	Date tarikhEngheza=null;
try {
    c=Util.getConnection();

    statement=c.createStatement();
	String query = "SELECT id,vazeat,moshtarakYaNa  FROM moshtarak where "+request.getParameter("field")+" = "+request.getParameter("value");
	//System.out.println(query);
	rs=statement.executeQuery(query);

 //   System.out.println("666666666666666666666  id= "+id);

	if(rs.next()){
        String id=rs.getString("id");
		int vazeat=rs.getInt("vazeat");
        int moshtarakYaNa=rs.getInt("moshtarakYaNa");
		%><row ><%
        rs=statement.executeQuery("SELECT emdadId,rokhdadId  FROM view_savabegh where moshtarakId='" + id +"' and ( emdadId is null or (emdadId is not null and zamanPayan is null))");
//		System.out.println("777777777777777777777777777"+rs);
        int i=1;
		boolean findEmdad=false;
		boolean findRokhdad=false;
		if(rs.next()){
			if(rs.getString("emdadId")==null){
				findRokhdad=true;
				%><rokhdad fieldId="n_<%= i++ %>" Title="مورد ناتمام" rokhdadId="<%= rs.getString("rokhdadId") %>"></rokhdad><%
			}
			else{
				findEmdad=true;
				%><emdad fieldId="n_<%= i++ %>" Title="امداد ناتمام" emdadId="<%= rs.getString("emdadId") %>"></emdad><%
			}
		while (rs.next() && !(findEmdad && findRokhdad)){
			if(rs.getString("emdadId")==null && !findRokhdad){
				findRokhdad=true;
				%><rokhdad fieldId="n_<%= i++ %>" Title="مورد ناتمام" rokhdadId="<%= rs.getString("rokhdadId") %>"></rokhdad><%
			}
			else
				if(!findEmdad){
					findEmdad=true;
					%><emdad fieldId="n_<%= i++ %>" Title="امداد ناتمام" emdadId="<%= rs.getString("emdadId") %>"></emdad><%
				}
		}
	}
        if(moshtarakYaNa==2){
            %><vazeat fieldId="vazeat" Title="غير مشترک"></vazeat><%
        }
        else if(moshtarakYaNa==1 && vazeat==1){
            %><vazeat fieldId="vazeat" Title="مشترک فعال"></vazeat><%
        }
        else if(moshtarakYaNa==1 && vazeat==2){
            %><vazeat fieldId="vazeat" Title="مشترک غيرفعال"></vazeat><%
        }

    }
    else{
	    if (request.getParameter("eshterakId")!=null){
        %><row Title="شماره اشتراک <%= request.getParameter("eshterakId") %> وجود ندارد "><%
    	}else{%><row Title="شماره مورد نظر پيدا نشد"><%
		 }
	}
} catch(Exception e) {
    e.printStackTrace();
} finally {
            try {
                if(statement!=null)
                    statement.close();
                if (c!=null)
                    c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
%>
</row>



