﻿<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"شناسه نقش", "نقش", "نام موجوديت", "دسترسي"});
		request.setAttribute("fields", new String[] {"roleId", "role", "entity", "access"});
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />