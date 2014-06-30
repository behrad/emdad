<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:form method="post" action="/r/noeKhodro">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">شناسه نوع خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeKhodroId" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">عنوان:</td>
						<td></td>
						<td class="readData"><bean:write property="onvan" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">ضمانت:</td>
						<td></td>
						<td class="readData"><bean:write property="guarantee" name="value_object"/>&nbsp;<span class="fieldDescription">ماه</span></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">مسافت ضمانت:</td>
						<td></td>
						<td class="readData"><bean:write property="guaranteeDistance" name="value_object"/>&nbsp;<span class="fieldDescription">کيلومتر</span></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">کد نوع خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeKhodroCode" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">کد خودروي خودروساز:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="khodroCode" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">مشمول خدمات ويژه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="vijehName" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">هزينه يک ساعت کار:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="hazinehSaat" name="value_object"/>&nbsp;<span class="fieldDescription">ريال</span></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">هزينه اشتراک عادي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="hazinehEshterakVijeh" name="value_object"/>&nbsp;<span class="fieldDescription">ريال</span></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">هزينه اشتراک ويژه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="hazinehEshterakAdi" name="value_object"/>&nbsp;<span class="fieldDescription">ريال</span></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">خودروساز:</td>
						<td></td>
						<td class="readData"><bean:write property="khodrosazName" name="value_object"/></td>
					</tr>

					<tr class="readRow0">
						<td class="readLabel">نوع سرويس هنگامimport:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="noeService"/></td>
					</tr>
		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.NoeKhodroForm);
	setEntity("NoeKhodro");
</script>
