<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"شناسه", "رخداد", "شماره سند", });
		request.setAttribute("fields", new String[] {"mostanadatRokhdadId", "rokhdadId", "shomarehSanad", });
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
