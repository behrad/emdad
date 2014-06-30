<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"شناسه رنگ", "عنوان", "رنگ پايه","کد رنگ خودرو ساز"});
		request.setAttribute("fields", new String[] {"rangeKhodroId", "onvan", "baseRange", "codeRangeKhodrosaz"});
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
