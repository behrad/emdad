<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="jozeatKhedmat.dastorkar" id="Integer">دستورکار</option >
						<option  value="jozeatKhedmat.ojratIdCode" id="Integer">کد اجرت</option >
						<option  value="jozeatKhedmat.qateIdCode" id="Integer">کد قطعه</option >
						<option  value="jozeatKhedmat.hazineh" id="Integer">هزینه</option >
						<option  value="jozeatKhedmat.tedadQate" id="Integer">تعداد قطعه مصرفی</option >
						<option  value="jozeatKhedmat.guarantee" id="Integer">مشمول گارانتی؟</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
