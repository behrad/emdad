<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"امداد", "خودرو جایگزین", "تاریخ تحویل دادن به مشتری", "تاریخ تحویل  گر�?تن از مشتری"});
		request.setAttribute("fields", new String[] {"emdadId", "khodrojagozinId", "tarikhTahvilBeMoshtari", "tarikhTahvilAzMoshtari"});
    %>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
