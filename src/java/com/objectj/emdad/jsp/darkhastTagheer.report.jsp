<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"شماره اشتراک", "ایجادکننده", "نوع سرويس", "نام خانوادگي", "نام", "تل(f)ن", "تل(f)ن همراه", });
		request.setAttribute("fields", new String[] {"eshterakId", "ijadKonandeh", "noeService", "nameKhanevadegi", "name", "tel", "mobile", });
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
