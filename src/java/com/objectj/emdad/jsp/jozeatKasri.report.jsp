<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"تعدادکسری", "تعدادانبار", "تعدادامدادگر"});
		request.setAttribute("fields", new String[] {"tedadKasri", "tedadAnbar", "tedadEmdadgar"});
    %>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
