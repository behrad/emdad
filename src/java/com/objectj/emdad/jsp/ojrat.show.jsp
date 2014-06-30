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

<html:form method="post" action="/r/ojrat">
	<table width="100%" align="center" border="0" cellpadding="4" cellspacing="0" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr class="readRow0"> 
			<td class="readLabel">کد:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="ojratId" name="value_object"/>  </td>						
		</tr>
			
		<!---------------------------------------->

		<tr class="readRow1"> 
			<td class="readLabel">عنوان:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="onvan" name="value_object"/>  </td>						
		</tr>
			
		<!---------------------------------------->

		<tr class="readRow0"> 
			<td class="readLabel">اجرت:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="ojrat" name="value_object"/> <span class="fieldDescription">&nbsp;ريال</span></td>						
		</tr>
			
		<!---------------------------------------->

		<tr class="readRow1"> 
			<td class="readLabel">مدت:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="modat" name="value_object"/> <span class="fieldDescription">&nbsp;دقيقه</span></td>						
		</tr>						

		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.ojratForm);
	setEntity("Ojrat");
</script>
		
