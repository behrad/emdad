<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="khodrojagozinMasraf.emdadId" id="String">امداد</option >
						<option  value="khodrojagozinMasraf.khodrojagozinId" id="String">خودرو جایگزین</option >
						<option  value="khodrojagozinMasraf.tarikhTahvilBeMoshtari" id="Timestamp">تاریخ تحویل دادن به مشتری</option >
						<option  value="khodrojagozinMasraf.tarikhTahvilAzMoshtari" id="Timestamp">تاریخ تحویل  گر�?تن از مشتری</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
