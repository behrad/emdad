<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="noeKhodro.noeKhodroId" id="Integer">شناسه نوع خودرو</option >
						<option  value="noeKhodro.onvan" id="String" onkeypress="return submitenter(this,event)">عنوان</option >
						<option  value="noeKhodro.guarantee" id="Integer">ضمانت</option >
						<option  value="noeKhodro.guaranteeDistance" id="Integer">مسافت ضمانت</option >
						<option  value="noeKhodro.noeKhodroCode" id="String" onkeypress="return submitenter(this,event)">کد نوع خودرو</option >
						<option  value="noeKhodro.khodroCode" id="String" onkeypress="return submitenter(this,event)">کد خودروي خودروساز</option >
						<option  value="noeKhodro.vijeh" id="Integer">مشمول خدمات ويژه</option >
						<option  value="noeKhodro.hazinehSaat" id="Integer">هزينه يک ساعت کار</option >
						<option  value="noeKhodro.hazinehEshterakAdi" id="Integer">هزينه اشتراک عادي</option >
						<option  value="noeKhodro.hazinehEshterakVijeh" id="Integer">هزينه اشتراک ويژه</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
