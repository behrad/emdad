<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-top.jsp" flush="true" />
    <%
		request.setAttribute("titles", new String[] {"شناسه نمايندگي", "نام نمايندگي", "نام شهر","نام دفتر استاني","آدرس", "تلفن", "موبايل","سقف باليني","سقف تعميري", "شماره قرارداد", });
		request.setAttribute("fields", new String[] {"namayandegiId", "name", "shahrName","daftarOstaniName", "namayandegiAddress","namayandegiTel","hadaksarKar","hadaksarKar2", "namayandegiMobile", "shomarehGharardad", });
    %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/report-but.jsp" flush="true" />
