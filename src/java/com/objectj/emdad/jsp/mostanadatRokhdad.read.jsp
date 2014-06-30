<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<script>
	function rokhdadDetails() {
		showDetail(document.mostanadatRokhdadForm.rokhdadId,
				null,
				"dimg1",
				"showRokhdad",
				"rdtl",
				"/emdad/s/rokhdad.run?action_type=specific,rokhdadShow") ;
	}

	var lastCreator;
</script>

<html:form method="post" action="/r/mostanadatRokhdad">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

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
						<td class="readData">

						<input type="hidden" name="rokhdadId" value="<bean:write property="rokhdadId" name="value_object"/>" /><bean:write property="rokhdadRokhdadId" name="value_object"/>
					    <a href="javascript:rokhdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>

						 </td>
					</tr>

					<tr class="readRow1">
						<td class="readData" colspan="3">
							<div   style="display:none;height:100px;" id="showRokhdad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="rdtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
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
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.mostanadatRokhdadForm);
	setEntity("MostanadatRokhdad");
	document.mostanadatRokhdadForm.rokhdadId.changed = true;
</script>

