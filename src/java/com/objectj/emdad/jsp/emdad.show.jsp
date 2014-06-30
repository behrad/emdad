<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<body onload=showDone()>

<script>
	function rokhdadDetails() {
		showDetail(document.emdadForm.rokhdadId,
				null,
				"dimg1",
				"showRokhdad",
				"rdtl",
				"/emdad/s/rokhdad.run?action_type=specific,rokhdadShow") ;
	}

	function peigiriDetails() {
		showDetail(document.emdadForm.emdadId,
				null,
				"dimg2",
				"showPeigiriEzamgar",
				"pdtl",
				"/emdad/s/peigiriEzamgar.run?action_type=specific,emdadpeigiriShow") ;
	}

	var lastCreator;
</script>

<!---------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/show-top.jsp" flush="true" />
<!---------------------------------------->

<html:form method="post" action="/r/emdad">
	<table width="100%" align="center"  border="0" cellpadding="4" cellspacing="0" dir=rtl class="generalText">

		<tr class="readRow0">
			<td class="readLabel">پيگيريها:</td>
			<td class="readData">
				<input type="hidden" name="emdadId" value="<bean:write property="emdadId" name="value_object"/>" />
				<a href="javascript:peigiriDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg2"></a>
			</td>
			<td class="readLabel">شماره مشتري:</td>
			<td class="readData"><bean:write property="moshtarakId" name="value_object"/>  </td>
		</tr>

		<!----------------------------------------->

		<tr class="readRow0">
			<td colspan="4">
				<div  style="display:none;height:100px;" id="showPeigiriEzamgar">
					<iframe width="100%" height="100%" src="" frameborder="1" name="pdtl" marginheight="0" marginwidth="0" ></iframe>
				</div>
			</td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="readLabel">نام :</td>
			<td class="readData"><bean:write property="name" name="value_object"/>  </td>
			<td class="readLabel">نام خانوادگي:</td>
			<td class="readData"><bean:write property="nameKhanevadegi" name="value_object"/>  </td>
		</tr>


		<!---------------------------------------->
		<tr class="readRow0">
			<td class="readLabel">دستور کار امداد:</td>
			<td class="readData"><bean:write property="emdadId" name="value_object"/>  </td>
			<td class="readLabel">کد مورد:</td>
			<td class="readData">
				<input type="hidden" name="rokhdadId" value="<bean:write property="rokhdadId" name="value_object"/>" />
				<bean:write property="rokhdadRokhdadId" name="value_object"/>
				<a href="javascript:rokhdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
			</td>
		</tr>

		<!----------------------------------------->

		<tr class="readRow0">
			<td colspan="4">
				<div  style="display:none;height:100px;" id="showRokhdad">
					<iframe width="100%" height="100%" src="" frameborder="1" name="rdtl" marginheight="0" marginwidth="0" ></iframe>
				</div>
			</td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="readLabel">وضعيت خدمت:</td>
			<td class="readData"><bean:write property="vazeatKhedmatOnvan" name="value_object"/>  </td>
			<td class="readLabel">زمان اعزام:</td>
			<td class="readData"><bean:write name="value_object" property="zamanEzamHejri"/> &nbsp;&nbsp; <bean:write name="value_object" property="zamanEzam2"/>  </td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow0">
			<td class="readLabel">زمان شروع به کار امدادگر:</td>
			<td class="readData"><bean:write name="value_object" property="zamanShoroHejri"/> &nbsp;&nbsp; <bean:write name="value_object" property="zamanShoro2"/>  </td>
			<td class="readLabel">زمان پايان کار:</td>
			<td class="readData"><bean:write name="value_object" property="zamanPayanHejri" /> &nbsp; &nbsp; <bean:write name="value_object" property="zamanPayan2" /></td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="readLabel">اعزامگر:</td>
			<td class="readData"><bean:write property="ezamgar" name="value_object"/>  </td>
			<td class="readLabel">امدادگر مربوطه:</td>
			<td class="readData"><bean:write property="emdadgar" name="value_object"/></td>
		</tr>
		

		<tr class="readRow0">
			<td class="readLabel"> نمایندگی مربوطه:</td>
			<td class="readData" colspan=3><bean:write property="namayandegiName" name="value_object"/></td>
		</tr>  
		<!---------------------------------------->

		<tr class="readRow1">
			<td class="readLabel">دليل طول کشيدن امداد:</td>
			<td class="readData"><bean:write property="dalileToolKeshidanOnvan" name="value_object"/>  </td>
			<td class="readLabel">زمان واقعی اعزام امدادگر:</td>
			<td class="readData"><bean:write name="value_object" property="zamanVagheiEzamHejri" />  </td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow0">
			<td class="readLabel">زمان واقعی شروع به کار امداد:</td>
			<td class="readData"><bean:write name="value_object" property="zamanVagheiShoroHejri" />  </td>
			<td class="readLabel">زمان واقعی پايان کار امداد:</td>
			<td class="readData"><bean:write name="value_object" property="zamanVagheiPayanHejri" />  </td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="readLabel">آخرين تغيير دهنده اين امداد:</td>
			<td class="readData"><bean:write property="akharinTagheerDahandeh" name="value_object"/>  </td>
			<td class="readLabel">کيلومتر کارکرد:</td>
			<td class="readData"><bean:write property="kilometerKarkard" name="value_object"/>  </td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow0">
			<td class="readLabel"> فاصله امدادخواه از نمايندگی:</td>
			<td class="readData"><bean:write property="faseleAzNamayandegi" name="value_object"/>&nbsp;<span class="fieldDescription">کيلومتر</span></td>
			<td class="readLabel">راه اندازي:</td>
			<td class="readData"><bean:write property="rahAndazi" name="value_object"/>  </td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="readLabel">علت نياز به سرويس جديد:</td>
			<td class="readData"><bean:write property="elateService" name="value_object"/>  </td>
	            <td colspan="2"/></td>
		</tr>

		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.emdadForm);
	setEntity("Emdad");
	document.emdadForm.rokhdadId.changed = true;
    document.emdadForm.emdadId.changed = true;
</script>

