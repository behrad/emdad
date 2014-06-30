﻿<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
﻿<html:form method="post" action="/c/validatedarkhastTagheer" onsubmit="return validateDarkhastTagheerForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره اشتراک:</td>
						<td class="editStar"></td>
						<td> <html:hidden property="eshterakId"/><bean:write property="eshterakId" name="darkhastTagheerForm"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نوع سرويس:</td>
						<td class="editStar"></td>
						<td>
							<html:select property="noeService" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="noeServiceList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نام خانوادگي:</td>
						<td class="editStar"> </td>
						<td> <html:text property="nameKhanevadegi" size="20" maxlength="20" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نام:</td>
						<td class="editStar"> </td>
						<td> <html:text property="name" size="20" maxlength="20" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تاريخ تولد:</td>
						<td class="editStar"> </td>
						<td> <html:text property="tarikhTavalod" size="10" maxlength="10"  /><jsp:include page="/com/objectj/resources/jsp/tiles/emdad/samp-date.jsp" flush="true" /></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">آدرس:</td>
						<td class="editStar"> </td>
						<td> <html:text property="address" size="80" maxlength="80" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">کد پستي:</td>
						<td class="editStar"> </td>
						<td> <html:text property="postCode" size="10" maxlength="10" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نام شهر:</td>
						<td class="editStar"> </td>
						<td>
							<html:select property="shahrId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="shahrList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">پست الکترونيکي:</td>
						<td class="editStar"> </td>
						<td> <html:text property="email" size="50" maxlength="50" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تلفن:</td>
						<td class="editStar"> </td>
						<td> <html:text property="tel" size="50" maxlength="50" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تلفن همراه:</td>
						<td class="editStar"> </td>
						<td> <html:text property="mobile" size="50" maxlength="50" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">رنگ خودرو:</td>
						<td class="editStar"> </td>
						<td>
							<html:select property="rangeKhodroId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="rangeKhodroList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره پلاک:</td>
						<td class="editStar"> </td>
						<td> <html:text property="shomarePelak" size="7" maxlength="6" onkeypress="return submitenter(this,event)"/><html:text property="shomarePelak2" size="20" maxlength="18" onkeypress="return submitenter(this,event)" /></td>
						<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/samp-pelak.jsp" flush="true" />
					</tr>
<tr class="editRow0">
<td class="editLabel" colspan=3>
<BR>
نکته: کاربر گرامی، در صورتیکه تمایل به حذف فیلد مربوطه از رکورد خود را دارید، در محل مربوطه "-" وارد کنید.
</td>
</tr>
					<!----------------------------------------->
				    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/edit-but.jsp" flush="true" />
					<!----------------------------------------->

				</table>

			</td>
		</tr>

		<!----------------------------------------->

  </table>
</html:form>

<!----------------------------------------->

<script type="text/javascript" language="Javascript1.1">
	setForm(document.darkhastTagheerForm);
	setEntity("DarkhastTagheer");
    if (document.darkhastTagheerForm.action_type.value=="moshtariCreate")
	{
        document.darkhastTagheerForm.action="/emdad/s/validatedarkhastTagheer.run?action_type=specific,moshtariCreate";
    }

	else
	{
        document.darkhastTagheerForm.action="/emdad/u/validatedarkhastTagheer.run";
    }
</script>
<html:javascript formName="darkhastTagheerForm" />
