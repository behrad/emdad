<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>


<script>
	function rokhdadDetails() {
		showDetail(document.emdadForm.rokhdadId,
				null,
				"dimg1",
				"showRokhdad",
				"rdtl",
				"/emdad/s/rokhdad.run?action_type=specific,rokhdadShow") ;
	}


	function emdadDetails() {
		showDetail(document.jozeatKhedmatForm.dastorkar,
			null,
			"dimg1",
			"showEmdad",
			"edtl",
			"/emdad/s/emdad.run?action_type=specific,emdadShow") ;
	}

	function qateDetails() {
		showDetail(document.jozeatKhedmatForm.qateId,
			document.jozeatKhedmatForm.qateIdCode,
			"dimg4",
			"showQate",
			"qdtl",
			"/emdad/s/qate.run?action_type=specific,qateShow") ;
	}

	var lastCreator;

function closeWindow(){
	top.close();
}

</script>



<!---------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/show-top.jsp" flush="true" />
<!---------------------------------------->

<html:form method="post" action="/r/jozeatKhedmat" >
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">


					<!---------------------------------------->

					<tr class="readRow1">

						<td class="readLabel">دستورکار:</td>
						<td width="5%"></td>
						<td class="readData">
							<input type="hidden" id="dastorkar" value="<bean:write property="dastorkar" name="value_object"/>"/>
							<bean:write property="dastorkar" name="value_object"/>
							<a href="javascript:emdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="readRow1">
						<td colspan="3">
							<div style="display:none;height:100px;" id="showEmdad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="edtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!---------------------------------------->

					<logic:notEqual name="value_object" property="noeKhedmat" value="4">

						<tr class="readRow0">
							<td class="readLabel">هزینه طبق ادعای سرویس دهنده:</td>
							<td width="5%"></td>
							<td class="readData"><bean:write property="hazineh" name="value_object"/> <span class="fieldDescription">&nbsp;ريال</span></td>
						</tr>

						<!---------------------------------------->
	
						<tr class="readRow1">
							<td class="readLabel">اجرت:</td>
							<td width="5%"></td>
							<td class="readData"><bean:write property="ojratOnvan" name="value_object"/>  </td>
						</tr>
	
						<!---------------------------------------->
	
						<tr class="readRow1">
							<td class="readLabel">کد اجرت:</td>
							<td width="5%"></td>
							<td class="readData"><bean:write property="ojratIdCode" name="value_object"/>  </td>
						</tr>
	
						<!---------------------------------------->
	
						<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
							<html:hidden property="qateId" />
							<html:hidden property="qateIdCode" />
						</logic:equal>
	
						<logic:notEqual name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
							<tr class="readRow0">
								<td class="readLabel">قطعه:</td>
								<td width="5%"></td>
								<td class="readData">
									<bean:write property="qateName" name="value_object"/>
									<input type="hidden" id="qateId" value="<bean:write property="qateId" name="value_object"/>"/>
									<a href="javascript:qateDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg4"></a>
								</td>
							</tr>
	
							<!----------------------------------------->
	
							<tr class="readRow0">
								<td colspan="3">
									<div   style="display:none;height:100px;" id="showQate">
										<iframe width="100%" height="100%" src="" frameborder="1" name="qdtl" marginheight="0" marginwidth="0" ></iframe>
									</div>
								</td>
							</tr>
	
							<!---------------------------------------->
	
							<tr class="readRow1">
								<td class="readLabel">شماره فني قطعه:</td>
								<td width="5%"></td>
								<td class="readData"><bean:write property="qateIdCode" name="value_object"/>  </td>
							</tr>
	
							<!---------------------------------------->
	
							<tr class="readRow0">
								<td class="readLabel">تعداد قطعه مصرفی:</td>
								<td width="5%"></td>
								<td class="readData"><bean:write property="tedadQate" name="value_object"/>  </td>
							</tr>
						</logic:notEqual>
	
						<!---------------------------------------->
	
						<logic:notEqual name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
							<tr class="readRow1">
								<td class="readLabel">مشمول گارانتی؟:</td>
								<td width="5%"></td>
								<td class="readData"><bean:write property="guaranteeName" name="value_object"/>  </td>
							</tr>
						</logic:notEqual>

						<!---------------------------------------->

					</logic:notEqual>
	
					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">تأیید حسابدار عملیات:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="taeedHesabdarName" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<logic:notEqual name="value_object" property="noeKhedmat" value="4">
						<logic:notEqual name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
							<tr class="readRow1">
								<td class="readLabel">تأیید گارانتی:</td>
								<td width="5%"></td>
								<td class="readData"><bean:write property="taeedGuaranteeName" name="value_object"/>  </td>
							</tr>
						</logic:notEqual>
					</logic:notEqual>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">تأیید نماینده مدیریت:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="taeedNamayandegiName" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">ایجاد کننده:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="ijadKonandeh" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<logic:equal name="value_object" property="noeKhedmat" value="4">
						<tr class="readRow0">
							<td class="readLabel">مدت خواب خودرو <span class="fieldDescription">&nbsp;(روز)</span>:</td>
							<td width="5%"></td>
							<td class="readData"><bean:write name="modatKhab"/> </td>
						</tr>

						<!---------------------------------------->

						<tr class="readRow1">
							<td class="readLabel">مدت استفاده از خودروي جايگزين <span class="fieldDescription">&nbsp;(روز)</span>:</td>
							<td width="5%"></td>
							<td class="readData"><bean:write name="modatKhodrojagozin"/> </td>
						</tr>
					</logic:equal>

					
					<!---------------------------------------->

					<tr>
						<td height="70" colspan="3" align="center"> <input name="sub_but" type="button" value="بازگشت" class="emdadButton" onClick="closeWindow();"/>
						</td>
					</tr>

					<!---------------------------------------->

				</table>
			</td>
		</tr>

<html:hidden property="action_type" value="read_all" />
<html:hidden property="curpage" />
<html:hidden property="order"/>
<html:hidden property="sorttype" />
<html:hidden property="id"/>
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.jozeatKhedmatForm);
	setEntity("JozeatKhedmat");
	document.jozeatKhedmatForm.dastorkar.changed = true;
	document.jozeatKhedmatForm.qateId.changed = true;
</script>


