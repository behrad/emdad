<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"نام خانوادگی", "نام ", "نوع سرويس", "تلفن", "نوع خودرو", "سال ساخت خودرو", "شماره پلاک", "شماره شاسی", });
		request.setAttribute("fields", new String[] {"nameKhanevadegi", "nameMoshtarak", "noeService", "telMoshtarak", "onvan", "saleSakht", "shomarePelak", "shomareShasi", });
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
