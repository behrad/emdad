<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="serviceDorei.tarikh" id="Date">تار�?خ</option >
						<option  value="serviceDorei.kilometerKarkard" id="Integer">کيلومتر کارکرد</option >
						<option  value="serviceDorei.noeServiceDorei" id="Integer">نوع سرويس دوره اي</option >
						<option  value="serviceDorei.hazineh" id="Integer">هزينه</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
