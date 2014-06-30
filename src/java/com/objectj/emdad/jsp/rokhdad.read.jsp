<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<script>
	function moshtarakDetails() {
		showDetail(document.rokhdadForm.eshterakId, 
				null,
				"dimg1",
				"showMoshtari",
				"mdtl",
				"/emdad/s/moshtarak.run?action_type=specific,moshtarakShow") ;
	}

	var lastCreator;
</script>


<html:form method="post" action="/r/rokhdad">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">کد مورد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="rokhdadId" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->

					<tr class="readRow1"> 
						<td class="readLabel">مشترک:</td>
						<td width="5%"></td>
						<td class="readData">						
							<input type="hidden" name="eshterakId" value="<bean:write property="moshtarakEshterakId" name="value_object"/>" />
							<bean:write property="moshtarakEshterakId" name="value_object"/>
							<a href="javascript:moshtarakDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
						</td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readData" colspan="3">						
							<div   style="display:none;height:100px;" id="showMoshtari">
								<iframe width="100%" height="100%" src="" frameborder="1" name="mdtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>						
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
						<td class="readLabel">ايراد خودرو طبق نظر امدادخواه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="irad" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">شهر:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shahrShahrName" name="value_object"/>  </td>						
					</tr>
					
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">کد منطقه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="mantagheh" name="value_object"/></td>						
					</tr>

					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">آدرس:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="address" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">ثابت يا سيار:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="sabetSayar"/></td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">مشمول خدمات ويژه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="khadamateVijeh"/></td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">نمايندگي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="namayandegiName"/>  </td>						
					</tr>
						
					<!---------------------------------------->
						
					<tr class="readRow1">
						<td class="readLabel">تاريخ فعال شدن:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tarikhFaalShodanHejri" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0"> 
						<td class="readLabel">ثبت کننده رخداد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="sabtKonandehName" name="value_object"/>  </td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0">
						<td class="readLabel">نوع درخواست کننده:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeDarkhastKonandehName" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->
					<tr class="readRow1">
						<td class="readLabel">آخرين تغيير دهنده:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="akharinTaghyirDahandehName" name="value_object"/>  </td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">دفتر استاني:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="daftarOstaniName" name="value_object"/>  </td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">زمان ثبت رخداد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="zamaneVagheiHejri" name="value_object"/> </td>
					</tr>
						
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">دستورکار قبلي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="dastorkarGhabli" name="value_object"/>  </td>						
					</tr>
					
					<tr class="readRow1"> 
						<td class="readLabel">کیلومتر کارکرد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="kilometerKarkard" name="value_object"/>  </td>						
					</tr>
					
					<tr class="readRow0"> 
						<td class="readLabel">کارکرد قبلی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="kilometerKarkardGhabli" name="value_object"/>  </td>						
					</tr>

					<!---------------------------------------->

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.rokhdadForm);
	setEntity("Rokhdad");
	document.rokhdadForm.eshterakId.changed = true;
</script>
		
