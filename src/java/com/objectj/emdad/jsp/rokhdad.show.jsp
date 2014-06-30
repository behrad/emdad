<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<!---------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/show-top.jsp" flush="true" />
<!---------------------------------------->
<body onload=showDone()>

<script>
	function moshtarakDetails() {
		showDetail(document.rokhdadForm.eshterakId, 
				null,
				"dimg1",
				"showMoshtari",
				"mdtl",
				"/emdad/s/moshtarak.run?action_type=specific,moshtarakShow") ;
	}

	function showSavabeghMoshtari() {
		//alert (document.emdadForm.moshtarakId.value);
		showDetailInNew(document.rokhdadForm.eshterakId2,
			null,
			"dimg1",
			"savabeghMoshtariFrame",
			"savabegh",
			"/emdad/s/moshtarak.run?action_type=specific,savabegh") ;
	}

	var lastCreator;
</script>


<!---------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/show-top.jsp" flush="true" />
<!---------------------------------------->
<html:form method="post" action="/r/rokhdad">
	<table width="100%" align="center"  border="0" cellpadding="4" cellspacing="0" dir=rtl class="generalText">
	
		
		<tr class="readRow0"> 
			<td class="readLabel">زمان ثبت رخداد:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="zamaneVagheiHejri" name="value_object"/>  </td>						
			<td class="readLabel">تلفن:</td>
			<td ></td>
			<td class="readData"><bean:write property="tel" name="value_object"/>  </td>						
		</tr>	
		
		
		<tr class="readRow1"> 
			<td class="readLabel">ايراد خودرو طبق نظر امدادخواه:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="irad" name="value_object"/>  </td>						 
			<td class="readLabel">شهر:</td>
			<td ></td>
			<td class="readData"><bean:write property="shahrShahrName" name="value_object"/>  </td>						
		</tr>
		
		<tr class="readRow0"> 
			<td class="readLabel">آدرس:</td>
			<td width="5%"></td>
			<td colspan="4" class="readData"><bean:write property="address" name="value_object"/>  </td>						
		</tr>
		
		<tr class="readRow1"> 
			<td class="readLabel">ثبت کننده رخداد:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="sabtKonandehName" name="value_object"/>  </td>						
			<td class="readLabel">ثابت يا سيار:</td>
			<td ></td>
			<td class="readData"><bean:write name="sabetSayar"/></td>						
		</tr>
		
		<tr class="readRow0"> 
			<td class="readLabel">مشمول خدمات ويژه:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write name="khadamateVijeh"/></td>						
			<td class="readLabel">نمايندگي:</td>
			<td ></td>
			<td class="readData"><bean:write name="namayandegiName"/>  </td>						
		</tr>
		
		<tr class="readRow1"> 
			<td class="readLabel">مشترک:</td>
			<td ></td>
			<td class="readData">
				<input type="hidden" name="eshterakId" value="<bean:write property="moshtarakEshterakId" name="value_object"/>" /><bean:write property="moshtarakEshterakId" name="value_object"/>
				<a href="javascript:moshtarakDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>&nbsp;&nbsp;&nbsp;
				<input type="hidden" name="eshterakId2" value="<bean:write property="moshtarakEshterakId" name="value_object"/>" />
				&nbsp;&nbsp;&nbsp;<a href="javascript:showSavabeghMoshtari() " >سوابق</a>
			</td>
			<td class="readLabel">کد مورد:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="rokhdadId" name="value_object"/>  </td>						
		</tr>
			
		<!----------------------------------------->

		<tr class="readRow1">
			<td colspan="6">
				<div style="display:none;height:100px;" id="showMoshtari">
					<iframe width="100%" height="100%" src="" frameborder="1" name="mdtl" marginheight="0" marginwidth="0" ></iframe>
				</div>
			</td>
		</tr>

		<!---------------------------------------->

		
			
		<!---------------------------------------->

		<tr class="readRow0"> 
			<td class="readLabel">تلفن همراه:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="mobile" name="value_object"/>  </td>						
			<td class="readLabel">کد منطقه:</td>
			<td ></td>
			<td class="readData"><bean:write property="mantagheh" name="value_object"/></td>						
		</tr>
			
		<tr class="readRow1">
			<td class="readLabel">تاريخ فعال شدن:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="tarikhFaalShodanHejri" name="value_object"/></td> 
			<td class="readLabel">آخرين تغيير دهنده:</td>
			<td ></td>
			<td class="readData"><bean:write property="akharinTaghyirDahandehName" name="value_object"/>  </td>						
		</tr>
			
		<!---------------------------------------->

		<tr class="readRow0"> 
			<td class="readLabel">دفتر استاني:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="daftarOstaniName" name="value_object"/>  </td>						
			<td class="readLabel">دستورکار قبلي:</td>
			<td ></td>
			<td class="readData"><bean:write property="dastorkarGhabli" name="value_object"/>  </td>						
		</tr>	
		
		
		<tr class="readRow1"> 
			<td class="readLabel">کیلومتر کارکرد:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="kilometerKarkard" name="value_object"/>  </td>						
			<td class="readLabel">کارکرد قبلی:</td>
			<td width="5%"></td>
			<td class="readData"><bean:write property="kilometerKarkardGhabli" name="value_object"/>  </td>						
		</tr>
					
			
		<!---------------------------------------->
	</table>
</html:form>

<script type="text/javascript" language="Javascript1.1">
	setForm(document.rokhdadForm);
	setEntity("Rokhdad");
	document.rokhdadForm.eshterakId.changed = true;
	document.rokhdadForm.eshterakId2.changed = true;
	//alert(opener.style.height);
</script>
<html:javascript formName="rokhdadForm" />
