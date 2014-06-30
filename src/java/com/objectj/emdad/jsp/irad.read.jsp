<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<html:form method="post" action="/r/irad">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">کد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="iradId" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">عنوان:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="onvan" name="value_object"/></td>
					</tr>
					
		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.iradForm);
	setEntity("Irad");
</script>
		