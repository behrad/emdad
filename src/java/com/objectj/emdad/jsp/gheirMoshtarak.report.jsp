<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"شماره اشتراک", "نام خانوادگي", "نام", "نوع خودرو", "شماره پلاک"});
		request.setAttribute("fields", new String[] {"moshtarakId", "nameKhanevadegi", "name", "onvan", "shomarePelak"});
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
