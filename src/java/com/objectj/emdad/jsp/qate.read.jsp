<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<html:form method="post" action="/r/qate">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">شناسه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="qateId" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">شماره فني</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomareFanni" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">نام قطعه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="name" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">واحد شمارش:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="vahedShomaresh"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">قیمت</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="gheimat" name="value_object"/>&nbsp;<span class="fieldDescription">ريال</span></td>
					</tr>

                    <!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">سطح مهارت فني مورد نياز:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="satheMaharat" name="value_object"/></td>
					</tr>
 
                    <!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">سقف تعدادی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="saghfeTedadi" name="value_object"/></td>
					</tr>

                    <tr class="readRow1">
						<td class="readLabel">نوع خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="noeKhodroName"/></td>
					</tr>

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.qateForm);
	setEntity("Qate");
</script>
		
