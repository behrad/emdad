<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="tamdidEshterak.eshterakId" id="String">شماره اشتراک</option >
						<option  value="tamdidEshterak.tarikhAkharinTamdid" id="Date">تاريخ آخرين تمديد</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
