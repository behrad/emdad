<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="mostanadatRokhdad.mostanadatRokhdadId" id="Integer">شناسه</option >
						<option  value="mostanadatRokhdad.shomarehSanad" id="String">شماره سند</option >
						<option  value="mostanadatRokhdad.tarikhSanad" id="Date">تاریخ سند</option >
						<option  value="mostanadatRokhdad.tarikhSabt" id="Date">تاریخ ثبت سند</option >
						<option  value="mostanadatRokhdad.sharh" id="String" onkeypress="return submitenter(this,event)">شرح سند</option >
						<option  value="mostanadatRokhdad.nameParvande" id="String">نام پرونده</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
