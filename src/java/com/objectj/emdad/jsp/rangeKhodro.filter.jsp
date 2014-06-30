<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="rangeKhodro.rangeKhodroId" id="Integer">شناسه رنگ</option >
						<option  value="rangeKhodro.onvan" id="String" onkeypress="return submitenter(this,event)">عنوان</option >
						<option  value="rangeKhodro.baseRange" id="Integer">رنگ پايه</option >
						<option  value="rangeKhodro.codeRangeKhodrosaz" id="String">کد رنگ خودرو ساز</option >
					</select >
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
