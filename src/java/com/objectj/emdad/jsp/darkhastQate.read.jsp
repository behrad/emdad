<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<html:form method="post" action="/r/darkhastQate">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">شناسه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="darkhastQateId" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">امدادگر:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="emdadgarName" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">تاریخ درخواست:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tarikhDarkhastHejri" name="value_object"/>  </td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">قطعه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="qateName" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">تعداد درخواستی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tedadDarkhasti" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">تعداد تایید شده توسط سرپرست امدادگران:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tedadSarparast" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">تایید شده توسط سرپرست امدادگران:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="taeedShodehSarparastName" name="value_object"/>  </td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">تعداد تایید شده توسط انبار:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tedadAnbar" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">تایید شده توسط انبار:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="taeedShodeAnbarName" name="value_object"/>  </td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">منبع تهیه قطعه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="manbaName" name="value_object"/>  </td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">ثبت کننده:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="sabtkonandehName" name="value_object"/>  </td>						
					</tr>
					

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.darkhastQateForm);
	setEntity("DarkhastQate");
</script>
		
