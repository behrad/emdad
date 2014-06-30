<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"نمايندگي", "تار�?خ", "مشتري", "کيلومتر کارکرد", "نوع سرويس دوره اي", "هزينه"});
		request.setAttribute("fields", new String[] {"name", "tarikh", "name", "kilometerKarkard", "noeServiceDorei", "hazineh"});
    %>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
