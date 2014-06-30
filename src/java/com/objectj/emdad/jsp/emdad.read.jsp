<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<script>
	function rokhdadDetails() {
		showDetail(document.emdadForm.rokhdadId,
				null,
				"dimg1",
				"showRokhdad",
				"rdtl",
				"/emdad/s/rokhdad.run?action_type=specific,rokhdadShow") ;
	}
	
	function emdadDetails(i) {
		//alert(eval("document.emdadForm.emdadId" + i).value);
		showDetail(eval("document.emdadForm.emdadId" + i), 
			null,
			"imgEmdad" + i,
			"showEmdad" + i,
			"edtl" + i,
			"/emdad/s/emdad.run?action_type=specific,emdadShow") ;
	}

	function showSavabeghMoshtari() {
		//alert (document.emdadForm.moshtarakId.value);
		showDetail(document.emdadForm.moshtarakId,
			null,
			"dimg2",
			"savabeghMoshtariFrame",
			"savabegh",
			"/emdad/s/moshtarak.run?action_type=specific,savabegh") ;
	}

	var lastCreator;
</script>
<html:form method="post" action="/r/emdad">


	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->
		<html:hidden property="rokhdadId" />
		
		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<% int i=0; %>

					<!----------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel">دستور کار امداد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="emdadId" name="value_object"/>  </td>
					</tr>
					<% i++; %>												

					<!----------------------------------------->
			
					<!---------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="editLabel">کد مورد:</td>
						<td class="editStar"> </td>
						<td class="readData">
							<bean:write name="emdadForm" property="rokhdadRokhdadId" />
							<a href="javascript:rokhdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
						</td>
					</tr>

					<tr class="readRow<%=i%2%>">
						<td colspan="3">
							<div   style="display:none;height:100px;" id="showRokhdad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="rdtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>
					<% i++; %>												

					<!----------------------------------------->

					<tr class="editRow<%=i%2%>"> 
						<td class="editLabel">سوابق مشتري:</td>
						<td class="editStar"></td>
						<td class="readData">
							<bean:write name="moshtarakId"/>
							<input type="hidden" name="moshtarakId" value="<bean:write name="moshtarakId"/>"/>
							<a href="javascript:showSavabeghMoshtari()" ><img src="images/show-on.gif" border="0" id="dimg2"></a>
						</td>
					</tr>

					<tr class="editRow<%=i%2%>">
						<td colspan="3">
							<div   style="display:none;height:100px;" id="savabeghMoshtariFrame">
								<iframe width="100%" height="100%" src="" frameborder="1" name="savabegh" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>
					<% i++; %>												

					<!----------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel">نوع امداد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeEmdadName" name="value_object"/>  </td>
					</tr>
					<% i++; %>												

					<!---------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel">اعزامگر:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="ezamgar" name="value_object"/>  </td>
					</tr>
					<% i++; %>												

					<!---------------------------------------->

					<logic:equal name="value_object" property="noeEmdad" value="1" >
						<tr class="readRow<%=i%2%>">
							<td class="readLabel">امدادگر مربوطه:</td>
							<td width="5%"></td>
							<td class="readData"><bean:write property="emdadgar" name="value_object"/>  </td>
						</tr>
						<% i++; %>												

						<tr class="readRow<%=i%2%>">
							<td class="readLabel">زمان اعزام:</td>
							<td width="5%"></td>
							<td class="readData"><bean:write name="value_object" property="zamanEzamHejri"/>  </td>
						</tr>
						<% i++; %>												

						<tr class="readRow<%=i%2%>">
							<td class="readLabel">زمان واقعی اعزام امدادگر:</td>
							<td width="5%"></td>
							<td class="readData"><bean:write name="value_object" property="zamanVagheiEzamHejri" />  </td>
						</tr>
						<% i++; %>												
					</logic:equal>

					<!---------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel">وضعيت خدمت:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="vazeatKhedmatOnvan" name="value_object"/>  </td>
					</tr>
					<% i++; %>												

					<!---------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel">کيلومتر کارکرد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="kilometerKarkard" name="value_object"/>  </td>
					</tr>
					<% i++; %>												

					<!---------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel"> فاصله امدادخواه از نمايندگی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="faseleAzNamayandegi" name="value_object"/>  </td>
					</tr>
					<% i++; %>												

					<!---------------------------------------->


					<tr class="readRow<%=i%2%>">
						<td class="readLabel">توضيحات:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tozihat" name="value_object"/>  </td>
					</tr>
					<% i++; %>												

					<!---------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel">نوع خدمت ويزه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeKhedmateVijeName" name="value_object"/>  </td>
					</tr>
					<% i++; %>

					<!---------------------------------------->

					<logic:notEqual name="value_object" property="noeEmdad" value="1" >
						<tr class="readRow<%=i%2%>">
							<td class="readLabel">عامليت مجاز:</td>
							<td width="5%"></td>
							<td class="readData"><bean:write property="emdadgar" name="value_object"/>  </td>
						</tr>
						<% i++; %>												

						<tr class="readRow<%=i%2%>">
							<td class="readLabel">نمايندگي:</td>
							<td width="5%"></td>
							<td class="readData"><bean:write property="namayandegiName" name="value_object"/>  </td>
						</tr>
						<% i++; %>												

						<tr class="readRow<%=i%2%>">
							<td class="readLabel">مدت تعمير:</td>
							<td width="5%"></td>
							<td class="readData"><bean:write property="modatTamir" name="value_object"/>  </td>
						</tr>
						<% i++; %>												
					</logic:notEqual>

					<!---------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel">دليل طول کشيدن امداد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="dalileToolKeshidanOnvan" name="value_object"/>  </td>
					</tr>
					<% i++; %>												

					<!---------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel">زمان شروع به کار امدادگر:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="value_object" property="zamanShoroHejri"/> </td>
					</tr>
					<% i++; %>												

					<!---------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel">زمان واقعی شروع به کار امداد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="value_object" property="zamanVagheiShoroHejri" />  </td>
					</tr>
					<% i++; %>												

					<!---------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel">زمان پايان کار:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="value_object" property="zamanPayanHejri" /></td>
					</tr>
					<% i++; %>												

					<!---------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel">زمان واقعی پايان کار امداد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="value_object" property="zamanVagheiPayanHejri" />  </td>
					</tr>
					<% i++; %>												

					<!---------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel">آخرين تغيير دهنده اين امداد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="akharinTagheerDahandeh" name="value_object"/>  </td>
					</tr>
					<% i++; %>												

					<!---------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel">راه اندازي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="rahAndazi" name="value_object"/>  </td>
					</tr>
					<% i++; %>												

					<!---------------------------------------->

					<tr class="readRow<%=i%2%>">
						<td class="readLabel">علت نياز به سرويس جديد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="elateService" name="value_object"/>  </td>
					</tr>
					<% i++; %>												
 		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	document.emdadForm.rokhdadId.changed = true;
	document.emdadForm.moshtarakId.changed = true;
	setForm(document.emdadForm);
	setEntity("Emdad");
</script>

