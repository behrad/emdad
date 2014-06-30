<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="jozeatKasri.tedadKasri" id="Integer">تعدادکسری</option >
						<option  value="jozeatKasri.tedadAnbar" id="Integer">تعدادانبار</option >
						<option  value="jozeatKasri.tedadEmdadgar" id="Integer">تعدادامدادگر</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
