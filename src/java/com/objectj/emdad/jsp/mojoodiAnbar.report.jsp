﻿<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"قطعه", "موجودی"});
		request.setAttribute("fields", new String[] {"name", "mojoodi"});
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
