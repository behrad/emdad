<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:form method="post" action="/r/daftarOstani">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">شناسه دفتر استاني:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="daftarOstaniId" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">نام دفتر استاني:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="name" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">مسئول:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="masool" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">تلفن:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tel" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">تلفن همراه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="mobile" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">آدرس:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="address" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0"> 
						<td class="readLabel">محدوده تحت پوشش:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="mahdodeh" name="value_object"/></td>
					</tr>					

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.daftarOstaniForm);
	setEntity("DaftarOstani");
</script>
		<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
