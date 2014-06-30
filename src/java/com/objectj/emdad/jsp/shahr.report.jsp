<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"شناسه شهر", "نام شهر", "نام استان", "کد شهر خودروساز"});
		request.setAttribute("fields", new String[] {"shahrId", "shahrName", "name", "codeShahrKhodrosaz"});
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
