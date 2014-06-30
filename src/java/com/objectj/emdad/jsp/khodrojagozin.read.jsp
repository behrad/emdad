<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<html:form method="post" action="/r/khodrojagozin">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">شناسه خودروی جایگزین:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="khodrojagozinId" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">رنگ خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="rangeKhodroOnvan" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">نوع خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeKhodroOnvan" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">سال ساخت :</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="salesakht" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">شماره پلاک :</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomarehPelak" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">شماره موتور :</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomarehMotor" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">شماره شاسی :</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomarehShasi" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">VINشماره :</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomarehVIN" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">توضیحات :</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tozihat" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">فعال :</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="faalName" name="value_object"/>  </td>
					</tr>
					
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">دفتر استاني:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="daftarOstaniName" name="value_object"/>  </td>						
					</tr>
						
		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.khodrojagozinForm);
	setEntity("Khodrojagozin");
</script>
		
