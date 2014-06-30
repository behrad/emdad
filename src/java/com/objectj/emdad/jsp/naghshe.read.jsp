<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<html:form method="post" action="/r/naghshe">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">سطح:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="mapLevel" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">ازطول جغرافيائی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="azTool" name="value_object"/>  </td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">تاطول جغرافيائی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="taTool" name="value_object"/>  </td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">ازعرض جغرافيائی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="azArz" name="value_object"/>  </td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">تاعرض جغرافيائی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="taArz" name="value_object"/>  </td>
					</tr>
						
					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">منطقه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="mantagheId" name="value_object"/>  </td>						
					</tr>
					

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.naghsheForm);
	setEntity("Naghshe");
</script>
		
