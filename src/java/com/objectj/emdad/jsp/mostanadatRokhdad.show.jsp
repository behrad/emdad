<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<body onload=showDone()>

<script>
	var lastCreator;
</script>

<!---------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/show-top.jsp" flush="true" />
<!---------------------------------------->

<html:form method="post" action="/r/mostanadatRokhdad">
	<table width="100%" align="center"  border="0" cellpadding="4" cellspacing="0" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr class="readRow0">
			<td class="readLabel">شناسه:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="mostanadatRokhdadId" name="value_object"/>  </td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="readLabel">رخداد:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="rokhdadRokhdadId" name="value_object"/>  </td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow0">
			<td class="readLabel">شماره سند:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="shomarehSanad" name="value_object"/>  </td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="readLabel">تاریخ سند:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write name="tarikhSanad"/>  </td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow0">
			<td class="readLabel">تاریخ ثبت سند:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write name="tarikhSabt"/>  </td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="readLabel">شرح سند:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="sharh" name="value_object"/>  </td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow0">
			<td class="readLabel">نام پرونده:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="nameParvande" name="value_object"/>  </td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="readLabel">نام سند:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="nameSanad" name="value_object"/>  </td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow0">
			<td class="readLabel">دفتر استاني:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="daftarOstaniName" name="value_object"/>  </td>
		</tr>

		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.mostanadatRokhdadForm);
	setEntity("MostanadatRokhdad");
</script>
		
