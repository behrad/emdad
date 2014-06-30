<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"کد مورد",
                                                     "شماره مشتري",
                                                     "زمان تماس",
                                                     "شهر",
                                                     "آدرس",
                                                     "ايراد",
                                                     "پذيرشگر",
                                                     "ثابت يا سيار",
                                                     "دفتراستاني"
                                                    });
		request.setAttribute("fields", new String[] {"rokhdadId", "eshterakId", "zamaneVaghei", "shahrName",
                                                     "address", "irad", "sabtKonandeh",
                                                     "sabetSayar", "nameDaftarOstani"});
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
