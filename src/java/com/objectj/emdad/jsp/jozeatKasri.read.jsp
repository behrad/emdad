<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<html:form method="post" action="/r/jozeatKasri">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">کسری:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="KasriEmdadTarikh" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">قطعه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="QateName" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">تعدادکسری:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tedadKasri" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">تعدادانبار:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tedadAnbar" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">تعدادامدادگر:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tedadEmdadgar" name="value_object"/>  </td>						
					</tr>
					

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.jozeatKasriForm);
	setEntity("JozeatKasri");
</script>
		
