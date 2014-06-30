<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="emdadgar.emdadgarId" id="Integer">شناسه</option >
						<option  value="emdadgar.name" id="String" onkeypress="return submitenter(this,event)">نام</option >
						<option  value="emdadgar.tel" id="String" onkeypress="return submitenter(this,event)">تلفن</option >
						<option  value="emdadgar.mobile" id="String" onkeypress="return submitenter(this,event)">تلفن همراه</option >
						<option  value="emdadgar.address" id="String" onkeypress="return submitenter(this,event)">آدرس</option >
						<option  value="emdadgar.satheMaharat" id="Integer">سطح مهارت فني</option >
						<option  value="emdadgar.saghfeMojoodi" id="Integer">سقف موجودي</option >
						<option  value="emdadgar.hadaksarKar" id="Integer">حداکثر تعداد کار همزمان</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
