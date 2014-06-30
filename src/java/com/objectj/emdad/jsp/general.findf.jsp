<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>

<html:base/>
<%
	String urlPath ="";
	if( request.getParameter("iradId") != null ) {
		urlPath = request.getParameter("url")+"?action_type="+request.getParameter("action_type")+"&iradId="+request.getParameter("iradId")+"%25";
	} else if( request.getParameter("ojratId") != null ) {
		urlPath = request.getParameter("url")+"?action_type="+request.getParameter("action_type")+"&ojratId="+request.getParameter("ojratId")+"%25";
	} else if( request.getParameter("noeKhodroId") != null ) {
		urlPath = request.getParameter("url")+ "?action_type="+request.getParameter("action_type") + "&noeKhodroId=" + request.getParameter( "noeKhodroId" ); 
 	} else if( request.getParameter("action_type") != null ) {
		urlPath = request.getParameter("url")+ "?action_type="+request.getParameter("action_type");
	} else
		urlPath = request.getParameter("url");
%>

<frameset rows="100%,*" frameborder="NO" border="0" framespacing="0">
	<frame src='<%=urlPath%>' name="mainFrame" scrolling="auto" noresize>
	<!--frame src="UntitledFrame-2"-->
</frameset>
<noframes></noframes>
