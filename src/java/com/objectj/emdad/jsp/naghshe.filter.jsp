<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="naghshe.mapLevel" id="Integer">سطح</option >
						<option  value="naghshe.azTooleGoegraphy" id="Integer">ازطول جغرافيائی</option >
						<option  value="naghshe.taTooleGoegraphy" id="Integer">تاطول جغرافيائی</option >
						<option  value="naghshe.azArzeGoegraphy" id="Integer">ازعرض جغرافيائی</option >
						<option  value="naghshe.taArzeGoegraphy" id="Integer">تاعرض جغرافيائی</option >
						<option  value="naghshe.mantagheId" id="Integer">منطقه</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
