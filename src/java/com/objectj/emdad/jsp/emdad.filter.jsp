<%@ page contentType="text/html; charset=UTF-8" %>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="emdad.emdadId" id="Integer" onkeypress="return submitenter(this,event)">دستورکار</option >
						<option  value="emdad.zamanEzam" id="Date">زمان اعزام</option >
						<option  value="emdad.zamanShoro" id="Date">زمان شروع به کار امدادگر</option >
						<option  value="emdad.zamnaPayan" id="Date">زمان پايان کار</option >
						<option  value="emdad.zamanVagheiEzam" id="Date">زمان واقعی اعزام امدادگر</option >
						<option  value="emdad.zamanVagheiShoro" id="Date">زمان واقعی شروع به کار امداد</option >
						<option  value="emdad.zamanVagheiPayan" id="Date">زمان واقعی پايان کار امداد</option >
						<option  value="emdad.akharinTagheerDahandeh" id="String">آخرين تغيير دهنده اين امداد</option >
						<option  value="emdad.kilometerKarkard" id="Integer">کيلومتر کارکرد</option >
						<option  value="emdad.faseleAzNamayandegi" id="Integer">فاصله امدادخواه از نمايندگی</option >
						<option  value="emdad.mablaghPardakhtShodeh" id="Integer">مبلغ پرداخت شده</option >
						<option  value="emdad.hododeHazinehKol" id="Integer">حدود هزيته کل امداد</option >
						<option  value="emdad.rahAndazi" id="String">راه اندازي</option >
						<option  value="emdad.elateService" id="String">علت نياز به سرويس جديد</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
