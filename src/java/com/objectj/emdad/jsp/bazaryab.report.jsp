﻿<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"شناسه بازارياب", "نوع بازارياب", "نام بازارياب"});
		request.setAttribute("fields", new String[] {"bazaryabId", "onvan", "bazaryabKey"});
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
