<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<script>
	function moshtarakDetails() {
		showDetail(document.tamdidEshterakForm.eshterakId, 
				null,
				"dimg1",
				"showMoshtari",
				"mdtl",
				"/emdad/s/moshtarak.run?action_type=specific,moshtarakShow") ;
	}

	var lastCreator;
</script>

<html:base/>
<html:form method="post" action="/r/tamdidEshterak">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">شماره اشتراک:</td>
						<td width="5%"></td>
						<td class="readData">
							<bean:write property="eshterakId" name="value_object"/>
							<input type="hidden" name="eshterakId" value="<bean:write property="eshterakId" name="value_object"/>" />
							<a href="javascript:moshtarakDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
						</td>
					</tr>

					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readData" colspan="3">						
							<div   style="display:none;height:100px;" id="showMoshtari">
								<iframe width="100%" height="100%" src="" frameborder="1" name="mdtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>						
					</tr>
						
					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نوع سرويس:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeServiceName" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تاريخ تمديد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tarikhAkharinTamdidHejri" name="value_object"/></td>
					</tr>

					<tr class="readRow0">
						<td class="readLabel">نام:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="name" name="value_object"/></td>
					</tr>

					<tr class="readRow1">
						<td class="readLabel">نام خانوادگي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="nameKhanevadegi" name="value_object"/></td>
					</tr>

					<tr class="readRow0">
						<td class="readLabel">بازارياب:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="bazaryabName" name="value_object"/></td>
					</tr>
					
		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.tamdidEshterakForm);
	setEntity("TamdidEshterak");
	document.tamdidEshterakForm.eshterakId.changed = true;
</script>

