<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<script>
	function khodrojagozinDetails() {
		showDetail(document.khodrojagozinMasrafForm.khodrojagozinId, 
				null,
				"dimg1",
				"showKhodrojagozin",
				"kdtl",
				"/emdad/s/khodrojagozin.run?action_type=specific,khodrojagozinShow") ;
	}

	var lastCreator;
</script>

<html:base/>

<html:form method="post" action="/r/khodrojagozinMasraf">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">امداد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="emdadEmdadId" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">خودرو جایگزین:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="khodrojagozinPelak" name="value_object"/>  </td>
						<html:hidden  property="khodrojagozinId" value='<bean:write name="value_object" property="khodrojagozinId"/>' />
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تاریخ تحویل دادن به مشتری:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tarikhTahvilBeMoshtariHejri" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">تاریخ تحویل  گرفتن از مشتری:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tarikhTahvilAzMoshtariHejri" name="value_object"/>  </td>
					</tr>

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.khodrojagozinMasrafForm);
	setEntity("KhodrojagozinMasraf");
	document.khodrojagozinMasrafForm.khodrojagozinId.changed = true;
</script>

