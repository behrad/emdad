<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

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
						<td class="readData"><bean:write property="eshterakId" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">ایجادکننده:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="ijadKonandeh" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نوع سرويس:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="noeServiceName" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نوع سرويس قبلي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeServiceName_old" name="value_object_old"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">نام خانوادگي:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="nameKhanevadegi" name="value_object"/></td>
					</tr>

					<!---------------------------------------->
					<tr class="readRow1">
						<td class="readLabel">نام خانوادگي قبلي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="nameKhanevadegi_old" name="value_object_old"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نام:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="name" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نام قبلي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="name_old" name="value_object_old"/></td>
					</tr>
					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تاريخ تولد:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="tarikhTavalod" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تاريخ تولد قبلي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tarikhTavalod_old" name="value_object_old"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">آدرس:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="address" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">آدرس قبلي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="address_old" name="value_object_old"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">کد پستي:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="postCode" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">کد پستي قبلي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="postCode_old" name="value_object_old"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نام شهر:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="shahrName" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نام شهر قبلي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shahrName_old" name="value_object_old"/></td>
					</tr>

					<!---------------------------------------->
					<tr class="readRow1">
						<td class="readLabel">پست الکترونيکي:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="email" name="value_object"/></td>
					</tr>

					<!---------------------------------------->
					<tr class="readRow1">
						<td class="readLabel">پست الکترونيکي قبلي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="email_old" name="value_object_old"/></td>
					</tr>

					<!---------------------------------------->
					<tr class="readRow0">
						<td class="readLabel">تلفن:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="tel" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">تلفن قبلي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tel_old" name="value_object_old"/></td>
					</tr>

					<!---------------------------------------->
					<tr class="readRow1">
						<td class="readLabel">تلفن همراه:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="mobile" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تلفن همراه قبلي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="mobile_old" name="value_object_old"/></td>
					</tr>

					<!---------------------------------------->
					<tr class="readRow0">
						<td class="readLabel">رنگ خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="rangeKhodroOnvan" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">رنگ خودرو قبلي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="rangeKhodroOnvan_old" name="value_object_old"/></td>
					</tr>

					<!---------------------------------------->
					<tr class="readRow1">
						<td class="readLabel">شماره پلاک:</td>
						<td width="5%"></td>
						<td class="readData"><font color="#FF0000"><bean:write property="shomarePelak" name="value_object"/></td>
					</tr>

					<!---------------------------------------->
					<tr class="readRow1">
						<td class="readLabel">شماره پلاک قبلي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomarePelak_old" name="value_object_old"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">ثبت تغییرات:</td>
						<td width="5%"></td>
						<td class="readData"><a href="javascript:doChange();" >   قبول   </a></td>
					</tr>

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	function doChange() {
    do_Submit("specific,change","s");
}

	setForm(document.darkhastTagheerForm);
	setEntity("DarkhastTagheer");
</script>

