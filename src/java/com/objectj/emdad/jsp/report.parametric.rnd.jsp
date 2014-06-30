<%@page contentType="text/html;charset=UTF-8"
	import="com.objectj.emdad.ejb.*,
		com.objectj.emdad.ejb.util.ApplicationPool,
		com.objectj.emdad.ejb.util.Constants"%>
<%int reportId = Integer.parseInt(request.getParameter("viewId").trim());

//ApplicationPool ap = new ApplicationPool();
//pageContext.getServletContext().setAttribute(Constants.APPLICATION_POOL , ap);


ApplicationPool ap = (ApplicationPool) pageContext.getServletContext().getAttribute(Constants.APPLICATION_POOL);
System.out.println("ap="+ap);
if (ap==null) {
	return;
}
UserSession ses = (UserSession) pageContext.getSession().getAttribute(Constants.USER_SESSION);
System.out.println("ses="+ses);

String rnd = "" + System.currentTimeMillis() + "a" + pageContext.hashCode() ;
System.out.println("rnd="+rnd);

ap.add(rnd, "id="+reportId+","+"user="+ses.getName()+","+"isSQL="+ses.isISDatabaseSQL()+","+"isLocal="+ses.isLocal()+",");
%>
<script>
//alert("aaaaaa");
document.location.href = "/reports/athorizehome.jsp?rand=<%=rnd%>&viewId=<%=reportId%>";
</script>
