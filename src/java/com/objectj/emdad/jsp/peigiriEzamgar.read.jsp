<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<script>
	function emdadDetails() {
			showDetail(document.peigiriEzamgarForm.emdadId,
				null,
				"dimg1",
				"showEmdad",
				"edtl",
				"/emdad/s/emdad.run?action_type=specific,emdadShow") ;
		}

	var lastCreator;
</script>
<html:form method="post" action="/r/peigiriEzamgar">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">تاريخ پي گيري:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="zamanPeigiri"/>  </td>
					</tr>
					<tr class="readRow1">
						<td class="readLabel">زمان پي گيري:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="zamanPeigiri2"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نتیجه پی گیری:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="natije" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					 <tr class="readRow1">
						<td class="readLabel">دستورکار:</td>
						<td width="5%"></td>
						<td class="readData">
						<input type="hidden" name="emdadId" value="<bean:write property="emdadId" name="value_object"/>" /><bean:write property="emdadEmdadId" name="value_object"/>
					    <a href="javascript:emdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
						</td>
					</tr>

					<tr class="readRow1">
						<td class="readData" colspan="3">
							<div   style="display:none;height:100px;" id="showEmdad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="edtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>



		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.peigiriEzamgarForm);
	setEntity("PeigiriEzamgar");
	document.peigiriEzamgarForm.emdadId.changed = true;
</script>

