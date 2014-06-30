<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<script>
	function qateDetails() {
		showDetail(document.mojoodiMojazForm.qateId,
			null,
			"dimg2",
			"showQate",
			"rdt2",
			"/emdad/s/qate.run?action_type=specific,qateShow") ;
	}
</script>

<html:form method="post" action="/r/mojoodiMojaz">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->
					<tr class="readRow0">
						<td class="readLabel"> نوع امدادگر:</td>
						<td width="5%"></td>
						<td class="readData">
							<input type="hidden" name="noeEmdadgarId" value="<bean:write name="value_object" property="noeEmdadgarId"/>"/>
							<bean:write property="noeEmdadgarOnvan" name="value_object"/>
						 </td>
					</tr>

					<!---------------------------------------->
					<tr class="readRow1">
						<td class="readLabel">شماره فني قطعه:</td>
						<td width="5%"></td>
						<td class="readData">
							<bean:write property="shomarehFanni" name="value_object"/>
							<input type="hidden" name="qateId" value="<bean:write name="value_object" property="qateId"/>"/>
							<a href="javascript:qateDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg2"></a>
						  </td>

					</tr>
					<!---------------------------------------->
					<tr class="editRow1">
						<td colspan="3">
							<div   style="display:none;height:100px;" id="showQate">
								<iframe width="100%" height="100%" src="" frameborder="1" name="rdt2" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">تعداد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tedad" name="value_object"/>  </td>						
					</tr>
					

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.mojoodiMojazForm);
	setEntity("MojoodiMojaz");
	document.mojoodiMojazForm.qateId.changed = true;
</script>
		
