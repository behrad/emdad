<%@ page import="java.util.Enumeration, javax.servlet.*, javax.servlet.http.*, java.io.*" %>

<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="util" %>

<util:sendMail
	from="abbasi6@yahoo.com"
	to="hamid@objectj.com"
	subject="subject">

Dear Mr. ...: <br><br>
Salam alaykom: <br>
<a href="aa.com" target=blank></a><br><br>

</util:sendMail>
