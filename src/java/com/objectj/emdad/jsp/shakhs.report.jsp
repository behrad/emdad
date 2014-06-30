<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"شناسه", "نام", "نقش", "دفتر استاني:", "شناسه کاربر"});
		request.setAttribute("fields", new String[] {"shakhsId", "name", "naghshName", "daftarOstaniId","username"});
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
