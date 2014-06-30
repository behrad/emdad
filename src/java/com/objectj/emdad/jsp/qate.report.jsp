<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"شناسه", "شماره فني", "نام قطعه", "واحد شمارش", "قیمت-ریال", "سطح مهارت فني مورد نياز", "سقف تعدادی"});
		request.setAttribute("fields", new String[] {"qateId", "shomareFanni", "name", "vahedShomaresh", "gheimat", "satheMaharat", "saghfeTedadi"});
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
