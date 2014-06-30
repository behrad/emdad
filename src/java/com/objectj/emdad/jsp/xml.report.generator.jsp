<?xml version="1.0" encoding="UTF-8"?>
<%@page contentType="text/xml;charset=UTF-8" import="com.objectj.emdad.ejb.*,
		com.objectj.emdad.ejb.util.ApplicationPool,
		com.objectj.emdad.ejb.util.Constants"%>
<%String rnd = request.getParameter("rand").trim(); 
String attribs = "";
//ApplicationPool ap = new ApplicationPool();
//pageContext.getServletContext().setAttribute(Constants.APPLICATION_POOL , ap);

try{
ApplicationPool ap = (ApplicationPool) pageContext.getServletContext().getAttribute(Constants.APPLICATION_POOL);
System.out.println("ap="+ap);
if (ap==null) {
	return;
}
UserSession ses = (UserSession) pageContext.getSession().getAttribute(Constants.USER_SESSION);
System.out.println("ses="+ses);
//String rnd = "" + System.currentTimeMillis() + "a" + pageContext.hashCode() ;
System.out.println("rnd="+rnd);
if(request.getParameter("type").equals("get")){
attribs=""+ap.get(rnd);
System.out.println("got *************");
}else{
attribs=""+ap.pop(rnd);
System.out.println("poped *************");
}

System.out.println("attribs="+attribs);
%>

<report id="<%=attribs.substring(attribs.indexOf("id")+3,attribs.indexOf(',',attribs.indexOf("id")))%>"  user="<%=attribs.substring(attribs.indexOf("user")+5,attribs.indexOf(',',attribs.indexOf("user")))%>" isSQL="<%=attribs.substring(attribs.indexOf("isSQL")+6,attribs.indexOf(',',attribs.indexOf("isSQL")))%>" isLocal="<%=attribs.substring(attribs.indexOf("isLocal")+8,attribs.indexOf(',',attribs.indexOf("isLocal")))%>" />
<%}catch(Exception e){%>
<report id=""  user="" isSQL="" isLocal="" />

<%
}
%>