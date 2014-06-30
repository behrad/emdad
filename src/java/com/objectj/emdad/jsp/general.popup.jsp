<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>

<html:base/>
<%
    String urlPath;
    if (request.getParameter("noeEmdad") != null)
    	urlPath = request.getParameter("url")+"?action_type="+request.getParameter("action_type")+"&id="+request.getParameter("id")+"&noeEmdad="+request.getParameter("noeEmdad");
    else
    	urlPath = request.getParameter("url")+"?action_type="+request.getParameter("action_type")+"&id="+request.getParameter("id");

    	%>

<frameset rows="1" frameborder="NO" border="0" framespacing="0">
	<frame src=<%= urlPath%>  name="mainFrame" scrolling="auto" noresize>
</frameset>

