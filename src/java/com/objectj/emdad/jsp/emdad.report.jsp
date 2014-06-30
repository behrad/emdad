<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"دستورکار",
                                                     "کدمورد",
                                                     "آدرس",
                                                     "شماره پلاک",
                                                     "زمان اعزام",
                                                     "اعزامگر",
                                                     "امدادگر",
                                                     "نمايندگي"
                                                    });
		request.setAttribute("fields", new String[] {"emdadId",
                                                     "rokhdadId",
                                                     "address",
                                                     "shomarePelak",
                                                     "zamanEzam",
                                                     "nameShakhs",
                                                     "nameEmdadgar",
                                                     "nameNamayandegi"
                                                    });
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
