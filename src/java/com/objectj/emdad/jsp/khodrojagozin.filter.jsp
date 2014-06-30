<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="khodrojagozin.khodrojagozinId" id="Integer">شناسه خودروی جایگزین </option >
						<option  value="khodrojagozin.salesakht" id="Integer">سال ساخت </option >
						<option  value="khodrojagozin.shomarehPelak" id="String" onkeypress="return submitenter(this,event)">شماره پلاک </option >
						<option  value="khodrojagozin.shomarehMotor" id="String" onkeypress="return submitenter(this,event)">شماره موتور </option >
						<option  value="khodrojagozin.shomarehShasi" id="String" onkeypress="return submitenter(this,event)">شماره شاسی </option >
						<option  value="khodrojagozin.shomarehVIN" id="String" onkeypress="return submitenter(this,event)">VINشماره </option >
						<option  value="khodrojagozin.tozihat" id="String" onkeypress="return submitenter(this,event)">توضیحات </option >
						<option  value="khodrojagozin.faal" id="Integer">فعال </option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
