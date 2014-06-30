<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="ojrat.ojratId" id="String">کد</option >
						<option  value="ojrat.onvan" id="String" onkeypress="return submitenter(this,event)">عنوان</option >
						<option  value="ojrat.ojrat" id="Integer">اجرت</option >
						<option  value="ojrat.modat" id="Integer">مدت</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
