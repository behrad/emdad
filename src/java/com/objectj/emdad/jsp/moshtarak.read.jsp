<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:form method="post" action="/r/moshtarak">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">شماره اشتراک:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="eshterakId" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">نوع اشتراک:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="noeEshterak"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نوع سرويس:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="noeService"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">مشترک مجازی؟:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="majaziYaNa"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">وضعيت اشتراک:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="vazeat"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">نام خانوادگي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="nameKhanevadegi" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نام:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="name" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تاريخ تولد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="tarikhTavalod"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">آدرس:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="address" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">کد پستي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="postCode" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نام شهر:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shahrName" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">پست الکترونيکي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="email" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">تلفن:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tel" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تلفن همراه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="mobile" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نوع خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeKhodroOnvan" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">رنگ خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="rangeKhodroOnvan" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">سال ساخت خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="saleSakht" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">شماره پلاک:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomarePelak" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">شماره موتور:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomareMotor" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">شماره شاسي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomareShasi" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">VIN شماره:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomareVIN" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تاريخ شروع اشتراک:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="tarikhShoro" /></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">تاريخ آخرين تمديد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="tarikhAkharinTamdid"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تاريخ انقضاي اشتراک:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="tarikhEngheza" /></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">تاريخ تحويل خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="tarikhTahvil" /></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">ضمانت:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="guaranteeName" name="value_object" /></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">تاريخ انقضاي ضمانت:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="tarikhEnghezaGuarantee" /></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">بازارياب:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="bazaryabName" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">تاريخ سرويس اوليه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="tarikhServiceAvalieh" /></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">محل سرويس اوليه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="mahaleServiceAvalieh" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">هزينه پرداخت شده:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="hazinehPardakhtShodeh" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">نمايندگي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="namayandegi" name="value_object"/></td>
					</tr>

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.moshtarakForm);
	setEntity("Moshtarak");
</script>
		<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
