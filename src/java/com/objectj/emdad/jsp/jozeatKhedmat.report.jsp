<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"دستورکار", "هزینه طبق گفته سرویس دهنده", "تعداد قطعه مصرفی", "مشمول گارانتی؟"});
		request.setAttribute("fields", new String[] {"dastorkar", "hazineh", "tedadQate", "guarantee"});
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
