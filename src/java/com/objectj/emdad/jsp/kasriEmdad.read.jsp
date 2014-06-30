<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<html:form method="post" action="/l/kasriEmdad">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">شناسه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="kasriId" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">تاريخ:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tarikhHejri" name="value_object"/>  </td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">امدادگر:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="emdadgarName" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">تحويل شد؟:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tahvilshodName" name="value_object"/>  </td>
					</tr>
					
					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تائيدانباردار؟:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="taeedAnbardarName" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تائیدامدادگر؟:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="taeedEmdadgarName" name="value_object"/>  </td>
					</tr>

	</table>

<table id="TBL" width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
		<tr class="listTableHeader">			
			<td class = "listRow0Col">شماره فني</td>

			<td class = "listRow0Col">نام قطعه</td>
			
			<td class = "listRow0Col">تعداد کسري</td>

			<td class = "listRow0Col">تعداد تاييد شده توسط انبار</td>

			<td class = "listRow0Col">تعداد تاييد شده توسط امدادگر</td>
		</tr>
		<!------------------------------------------------>
		<% int i = 0; %>	
		
		<logic:iterate id="value_object2" name="value_object_list">
		     <tr class="listRow<%=i%2%>">
			<td class = "listRow1Col" align="left">
				<bean:write property="shomareFanni" name="value_object2"/>
			</td>

			<td class = "listRow1Col"><bean:write property="qateName" name="value_object2"/></td>

			<td class = "listRow1Col">
				<bean:write property="tedadKasri" name="value_object2"/>
			</td>
			<td class = "listRow1Col">
				<bean:write property="tedadAnbar" name="value_object2"/>
			</td>
			<td class = "listRow1Col">
				<bean:write property="tedadEmdadgar" name="value_object2"/>
			</td>
	            </tr>
	            <%i++;%>
	        </logic:iterate>
		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->
</table>

</html:form>

<!---------------------------------------->

<script>
	setForm(document.kasriEmdadForm);
	setEntity("KasriEmdad");
</script>
		
