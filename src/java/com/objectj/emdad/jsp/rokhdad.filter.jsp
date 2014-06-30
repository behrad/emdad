<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="rokhdad.rokhdadId" id="Integer">کد مورد</option >
						<option  value="rokhdad.tel" id="String" onkeypress="return submitenter(this,event)">تلفن ثابت</option >
						<option  value="rokhdad.mobile" id="String" onkeypress="return submitenter(this,event)">تلفن همراه </option >
						<option  value="rokhdad.eghdamShodeh" id="Integer">اقدام شده</option >
						<option  value="rokhdad.irad" id="String" onkeypress="return submitenter(this,event)">ايراد خودرو طبق نظر امداد خواه</option >
						<option  value="rokhdad.mantagheh" id="Integer">کد منطقه</option >
						<option  value="rokhdad.address" id="String" onkeypress="return submitenter(this,event)">آدرس</option >
						<option  value="rokhdad.sabetSayar" id="Integer">ثابت يا سيار</option >
						<option  value="rokhdad.khadamateVijeh" id="Integer">مشمول خدمات ويژه</option >
						<option  value="rokhdad.tarikhFaalShodan" id="Date">تاريخ فعال شدن</option >
						<option  value="rokhdad.sabtKonandeh" id="String" onkeypress="return submitenter(this,event)">ثبت کننده رخداد</option >
						<option  value="rokhdad.akharinTaghyirDahandeh" id="String" onkeypress="return submitenter(this,event)">آخرين تغيير دهنده</option >
						<option  value="rokhdad.zamaneVaghei" id="Date">زمان ثبت رخداد</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
