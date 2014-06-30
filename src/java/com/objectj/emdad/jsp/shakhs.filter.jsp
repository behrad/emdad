<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol">
					<select  class="generalText" id="field">
						<option  value="shakhs.shakhsId" id="Integer">شناسه</option >
						<option  value="shakhs.name" id="String" onkeypress="return submitenter(this,event)">نام</option >
						<option  value="shakhs.naghshId" id="Integer">نقش</option >
						<option  value="shakhs.daftarOstaniId" id="String">دفتر استاني</option >
                        <option  value="shakhs.daftarOstaniId" id="String">شناسه کاربر</option >
					</select >
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
