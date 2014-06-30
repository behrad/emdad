<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<script>
	function emdadDetails() {
		showDetail(document.jozeatKhedmatForm.dastorkar, 
			null,
			"dimg1",
			"showEmdad",
			"edtl",
			"/emdad/s/emdad.run?action_type=specific,emdadShow") ;
	}

	function iradDetails() {
		//alert(document.jozeatKhedmatForm.qateId.value);
		//alert(document.jozeatKhedmatForm.qateIdCode.value);
		showDetail(document.jozeatKhedmatForm.iradId, 
			document.jozeatKhedmatForm.iradIdCode,
			"dimg2",
			"showIrad",
			"idtl",
			"/emdad/s/irad.run?action_type=specific,iradShow") ;
	}

	function ojratDetails() {
		//alert(document.jozeatKhedmatForm.qateId.value);
		//alert(document.jozeatKhedmatForm.qateIdCode.value);
		showDetail(document.jozeatKhedmatForm.ojratId, 
			document.jozeatKhedmatForm.ojratIdCode,
			"dimg3",
			"showOjrat",
			"odtl",
			"/emdad/s/ojrat.run?action_type=specific,ojratShow") ;
	}

	function qateDetails() {
		//alert(document.jozeatKhedmatForm.qateId.value);
		//alert(document.jozeatKhedmatForm.qateIdCode.value);
		showDetail(document.jozeatKhedmatForm.qateId, 
			document.jozeatKhedmatForm.qateIdCode,
			"dimg4",
			"showQate",
			"qdtl",
			"/emdad/s/qate.run?action_type=specific,qateShow") ;
	}

	var lastCreator;
</script>

<html:base/>
<html:form method="post" action="/r/jozeatKhedmat">
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
							<a href="javascript:emdadDetails()" ><img src="images/show-on.gif" border="0" id="dimg1"></a>
						</td>
					</tr>

					<tr class="readRow1">
						<td colspan="3">
							<div style="display:none;height:100px;" id="showEmdad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="edtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">ايراد:</td>
						<td width="5%"></td>
						<td class="readData">
							<input type="hidden" id="iradId" value="<bean:write property="iradId" name="value_object"/>"/>
							<bean:write property="iradOnvan" name="value_object"/>
							<a href="javascript:iradDetails()" ><img src="images/show-on.gif" border="0" id="dimg2"></a>
						</td>
					</tr>

					<tr class="readRow0">
						<td colspan="3">
							<div style="display:none;height:100px;" id="showIrad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="idtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">اجرت:</td>
						<td width="5%"></td>
						<td class="readData">
							<input type="hidden" id="ojratId" value="<bean:write property="ojratId" name="value_object"/>"/>
							<bean:write property="ojratOnvan" name="value_object"/>  
							<a href="javascript:ojratDetails()" ><img src="images/show-on.gif" border="0" id="dimg3"></a>
						</td>
					</tr>

					<tr class="readRow1">
						<td colspan="3">
							<div style="display:none;height:100px;" id="showOjrat">
								<iframe width="100%" height="100%" src="" frameborder="1" name="odtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">قطعه:</td>
						<td width="5%"></td>
						<td class="readData">
							<bean:write property="qateName" name="value_object"/>
							<input type="hidden" id="qateId" value="<bean:write property="qateId" name="value_object"/>"/>							
							<a href="javascript:qateDetails()" ><img src="images/show-on.gif" border="0" id="dimg4"></a>
						</td>
					</tr>

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

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">مشمول گارانتی؟:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="guaranteeName" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">هزینه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="hazinehDefault" name="value_object"/> <span class="fieldDescription">&nbsp;ريال</span></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">هزینه طبق ادعای سرویس دهنده:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="hazineh" name="value_object"/> <span class="fieldDescription">&nbsp;ريال</span></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">تأیید حسابدار عملیات:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="taeedHesabdarName" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تأیید گارانتی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="taeedGuaranteeName" name="value_object"/>  </td>
					</tr>

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
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.jozeatKhedmatForm);
	setEntity("JozeatKhedmat");
	document.jozeatKhedmatForm.dastorkar.changed = true;
	document.jozeatKhedmatForm.iradId.changed = true;
	document.jozeatKhedmatForm.ojratId.changed = true;
	document.jozeatKhedmatForm.qateId.changed = true;
</script>

