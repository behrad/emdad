<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"سطح", "ازطول جغرافيائی", "تاطول جغرافيائی", "ازعرض جغرافيائی", "تاعرض جغرافيائی", "منطقه"});
		request.setAttribute("fields", new String[] {"mapLevel", "azTooleGoegraphy", "taTooleGoegraphy", "azArzeGoegraphy", "taArzeGoegraphy", "mantagheId"});
    %>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
