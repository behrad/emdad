<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol">
					<select  class="generalText" id="field">
						<option  value="qate.qateId" id="Integer">شناسه</option >
						<option  value="qate.shomareFanni" id="String">شماره فني</option >
						<option  value="qate.name" id="String" onkeypress="return submitenter(this,event)">نام قطعه</option >
						<option  value="qate.vahedShomaresh" id="Integer">واحد شمارش</option >
						<option  value="qate.gheimat" id="Integer">قیمت-ریال</option >
                        <option  value="qate.satheMaharat" id="Integer">سطح مهارت فني مورد نياز</option >
                        <option  value="qate.saghfeTedadi" id="Integer">سقف تعدادی</option >                        
					</select >
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
