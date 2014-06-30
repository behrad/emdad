<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="bazaryabMotefareghe.name" id="String" onkeypress="return submitenter(this,event)">نام و نام خانوادگی</option >
						<option  value="bazaryabMotefareghe.tel" id="String" onkeypress="return submitenter(this,event)">تلفن</option >
						<option  value="bazaryabMotefareghe.mobile" id="String" onkeypress="return submitenter(this,event)">تلفن همراه</option >
						<option  value="bazaryabMotefareghe.namePedar" id="String" onkeypress="return submitenter(this,event)">نام پدر</option >
						<option  value="bazaryabMotefareghe.shShenasname" id="String">شماره شناسنامه</option >
						<option  value="bazaryabMotefareghe.address" id="String" onkeypress="return submitenter(this,event)">آدرس</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
