<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>


<script>
	function noeKhodroDetails() {
		//alert(document.moshtarakForm.noeKhodroId.value);
		showDetail(document.moshtarakForm.noeKhodroId,
				null,
				"dimg1",
				"showNoeKhodro",
				"nkdtl",
				"/emdad/s/noeKhodro.run?action_type=specific,noeKhodroShow") ;
	}
</script>


<!---------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/show-top.jsp" flush="true" />
<!---------------------------------------->
<html:form method="post" action="/r/moshtarak">

	<table width="100%" align="center"  border="0" cellpadding="4" cellspacing="0" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr class="readRow0">
			<td class="readLabel">شماره مشتري:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="eshterakId" name="value_object"/></td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="readLabel">مشترک:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="moshtarakYaNaName" name="value_object"/></td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow0">
			<td class="readLabel">نوع اشتراک:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write name="noeEshterak"/></td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="readLabel">نوع سرويس:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write name="noeService"/></td>
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
			<td class="readData">
				<input type="hidden" name="noeKhodroId" value="<bean:write property="noeKhodroId" name="value_object"/>" />
				<bean:write property="noeKhodroOnvan" name="value_object"/>
				<a href="javascript:noeKhodroDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
			</td>
		</tr>

		<!----------------------------------------->

		<tr class="readRow0">
			<td colspan="3">
				<div style="display:none;;height:100;" id="showNoeKhodro">
					<iframe width="100%" src="" frameborder="1" name="nkdtl" marginheight="0" marginwidth="0" ></iframe>
				</div>
			</td>
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
			<td class="readData"><bean:write name="guarantee" /></td>
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
	</table>
</html:form>

<script>
	setForm(document.moshtarakForm);
	setEntity("Moshtarak");
	document.moshtarakForm.noeKhodroId.defaultValue = "";
</script>
<html:javascript formName="moshtarakForm" />