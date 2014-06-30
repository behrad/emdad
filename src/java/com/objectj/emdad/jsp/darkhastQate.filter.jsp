<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="darkhastQate.darkhastQateId" id="Integer">شناسه</option >
						<option  value="darkhastQate.tarikhDarkhast" id="Date">تاریخ درخواست</option >
						<option  value="darkhastQate.tedadDarkhasti" id="Integer">تعداد درخواستی</option >
						<option  value="darkhastQate.tedadSarparast" id="Integer">تعداد تایید شده توسط سرپرست امدادگران</option >
						<option  value="darkhastQate.taeedShodehSarparast" id="Integer">تایید شده توسط سرپرست امدادگران</option >
						<option  value="darkhastQate.tedadAnbar" id="Integer">تعداد تایید شده توسط انبار</option >
						<option  value="darkhastQate.taeedShodeAnbar" id="Integer">تایید شده توسط انبار</option >
						<option  value="darkhastQate.manba" id="Integer">منبع تهیه قطعه</option >
						<option  value="darkhastQate.sabtkonandeh" id="String">ثبت کننده</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
