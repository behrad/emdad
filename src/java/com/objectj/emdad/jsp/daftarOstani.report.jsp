<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"شناسه دفتر استاني", "نام دفتر استاني", "مسئول", "تلفن", "تلفن همراه", "آدرس"});
		request.setAttribute("fields", new String[] {"daftarOstaniId", "name", "masool", "tel", "mobile", "address"});
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
