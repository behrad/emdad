<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:form method="post" action="/r/rangeKhodro">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">شناسه رنگ:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="rangeKhodroId" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">عنوان:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="onvan" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0">
						<td class="readLabel">رنگ پايه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="baseRangeName"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">کد رنگ خودرو ساز:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="codeRangeKhodrosaz" name="value_object"/></td>
					</tr>
					
					<!---------------------------------------->

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.rangeKhodroForm);
	setEntity("RangeKhodro");
</script>
		<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
