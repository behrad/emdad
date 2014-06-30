<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<body onload=showDone()>

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

	var lastCreator;
</script>


<!---------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/show-top.jsp" flush="true" />
<!---------------------------------------->

<html:form method="post" action="/r/moshtarak">
	<table width="100%" align="center"  border="0" cellpadding="4" cellspacing="0" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr class="readRow0">
			<td class="readLabel">مشترک:</td>
			<td width="5%"></td>
			<td class="readData"><font color="FF0000"><bean:write property="moshtarakYaNaName" name="value_object"/></font></td>
			<td class="readLabel">شماره مشتري:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="eshterakId" name="value_object"/></td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="readLabel">نام خانوادگي:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="nameKhanevadegi" name="value_object"/></td>
			<td class="readLabel">نام:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="name" name="value_object"/></td>
		</tr>

		<tr class="readRow1">
			<td class="readLabel">تاريخ شروع اشتراک:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write name="tarikhShoro" /></td>
			<td class="readLabel">تاريخ انقضاي اشتراک:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write name="tarikhEngheza" /></td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow0">
			<td class="readLabel">تلفن:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="tel" name="value_object"/></td>
			<td class="readLabel">نوع خودرو:</td>
			<td width="5%"></td>
			<td class="readData">
				<input type="hidden" name="noeKhodroId" value="<bean:write property="noeKhodroId" name="value_object"/>" />
				<bean:write property="noeKhodroOnvan" name="value_object"/>  
				<a href="javascript:noeKhodroDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
			</td>
		</tr>

		<!----------------------------------------->

		<tr class="readRow1">
			<td colspan="3">
				<div style="display:none;height:100px;" id="showNoeKhodro">
					<iframe width="100%" height="100%" src="" frameborder="1" name="nkdtl" marginheight="0" marginwidth="0" ></iframe>
				</div>
			</td>
			<td class="readLabel">رنگ خودرو:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="rangeKhodroOnvan" name="value_object"/></td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="readLabel">سال ساخت خودرو:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="saleSakht" name="value_object"/></td>
			<td class="readLabel">شماره پلاک:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="shomarePelak" name="value_object"/></td>
		</tr>

		<!---------------------------------------->

	</table>
</html:form>

<script>
	setForm(document.moshtarakForm);
	setEntity("Moshtarak");
	document.moshtarakForm.noeKhodroId.changed = true;
</script>
<html:javascript formName="moshtarakForm" />