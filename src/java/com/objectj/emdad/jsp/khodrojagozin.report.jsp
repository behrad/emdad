<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"شناسه خودروی جایگزین ","شماره پلاک", "نوع خودرو", "سال ساخت ", "فعال","دفتر استاني"});
		request.setAttribute("fields", new String[] {"khodrojagozinId","shomarehPelak", "onvan", "salesakht", "faal","daftarOstaniName"});
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
