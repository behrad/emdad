<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<html:form method="post" action="/r/serviceDorei">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">نمايندگي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="namayandegiId" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">تاريخ:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tarikhHejri" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">مشتري:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="eshterakId" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">کيلومتر کارکرد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="kilometerKarkard" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">نوع سرويس دوره اي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeServiceDoreiName" name="value_object"/>  </td>
						<html:hidden property="noeServiceDorei" name="value_object" />						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">هزينه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="hazineh" name="value_object"/>  </td>						
					</tr>
					

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.serviceDoreiForm);
	setEntity("ServiceDorei");
</script>
		
