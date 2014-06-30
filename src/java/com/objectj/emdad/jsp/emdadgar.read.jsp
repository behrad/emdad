<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<html:form method="post" action="/r/emdadgar">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">شناسه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="emdadgarId" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">نام:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="name" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">تلفن:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tel" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">تلفن همراه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="mobile" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">آدرس:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="address" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">سطح مهارت فني:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="satheMaharat" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">سقف موجودي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="saghfeMojoodi" name="value_object"/> <span class="fieldDescription">&nbsp;ريال</span></td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">حداکثر تعداد امداد همزمان:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="hadaksarKar" name="value_object"/></td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">تعداد امداد در حال انجام:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="karDarDast" name="value_object"/></td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">نوع امدادگر:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeEmdadgarOnvan" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">دفتر استاني:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="daftarOstaniName" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">نمايندگي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="namayandegiName" name="value_object"/>  </td>						
					</tr>
					
					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">ازطول جغرافيائی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="azToole" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">تاطول جغرافيائی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="taToole" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">ازعرض جغرافيائی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="azArze" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">تاعرض جغرافيائی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="taArze" name="value_object"/>  </td>
					</tr>

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.emdadgarForm);
	setEntity("Emdadgar");
</script>
		
