<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="dalileToolKeshidaneEmdad.dalileToolKeshidaneEmdadId" id="Integer">شناسه</option >
						<option  value="dalileToolKeshidaneEmdad.onvan" id="String" onkeypress="return submitenter(this,event)">عنوان</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->