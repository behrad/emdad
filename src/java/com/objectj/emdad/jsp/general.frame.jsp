<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>

<html:base/>

<!--frameset rows="100%,*" frameborder="NO" border="0" framespacing="0"-->
<frameset rows="1" frameborder="NO" border="0" framespacing="0">
	<frame src='<%=request.getParameter("url")%>' name="mainFrame" scrolling="auto" noresize>
</frameset>
