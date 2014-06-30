<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"شناسه نوع خودرو", "عنوان", "ضمانت", "مسافت ضمانت", "کد خودروي خودروساز","کد نوع خودرو","مشمول خدمات ويژه", "خودروساز"});
		request.setAttribute("fields", new String[] {"noeKhodroId", "onvan", "guarantee", "guaranteeDistance", "khodroCode","noeKhodroCode", "vijeh", "name"});
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
