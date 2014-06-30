<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
</HEAD>

<body>

<html:base/>
﻿<html:form method="post" action="/r/darkhastTagheer">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">شماره اشتراک:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="eshterakId" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">ایجادکننده:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="ijadKonandeh" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نوع سرويس:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="noeServiceName" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">نام خانوادگي:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="nameKhanevadegi" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نام:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="name" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تاريخ تولد:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="tarikhTavalod" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">آدرس:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="address" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">کد پستي:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="postCode" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نام شهر:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="shahrName" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">پست الکترونيکي:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="email" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->
					<tr class="readRow0">
						<td class="readLabel">تلفن:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="tel" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تلفن همراه:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="mobile" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">رنگ خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="rangeKhodroOnvan" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">شماره پلاک:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="shomarePelak" name="value_object1"/></td>
					</tr>

				</table>
			</td>
		</tr>

		<tr> 
			<td height="70" colspan="3" align="center">
				<input type="button" value="پايان" class="emdadButton" onClick="closeConfirm()"/>
			</td>
		</tr>

	</table>
</html:form>

<!---------------------------------------->

<script>
	function doChange() {
    do_Submit("specific,change","s");
	}

	setForm(document.darkhastTagheerForm);
	setEntity("DarkhastTagheer");
	
	function closeConfirm() {
		close();
	}

</script>

