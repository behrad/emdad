<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Sabt()"/>

<html:form method="post" action="/c/validateemdadgar" onsubmit="return validateEmdadgarForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

                    <html:hidden property="emdadgarId" />
		<html:hidden property="karDarDast" />
		<html:hidden property="vazeat" />
					<!----------------------------------------->
                    <logic:equal name="emdadgarForm" property="action_type" value="update" >
                        <tr class="editRow0">
                            <td class="editLabel">شناسه:</td>
                            <td class="editStar">*</td>
                            <td class="readData">
                                <bean:write property="emdadgarId" name="emdadgarForm"/>
                            </td>
                        </tr>
                    </logic:equal>
					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نام:</td>
						<td class="editStar">*</td>
						<td> <html:text property="name" size="40" maxlength="40" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تلفن:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tel" size="50" maxlength="50" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تلفن همراه:</td>
						<td class="editStar"> </td>
						<td> <html:text property="mobile" size="50" maxlength="50" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">آدرس:</td>
						<td class="editStar">*</td>
						<td> <html:text property="address" size="80" maxlength="80" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">سطح مهارت فني:</td>
						<td class="editStar">*</td>
						<td> <html:text property="satheMaharat" size="2" maxlength="2" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">سقف موجودي:</td>
						<td class="editStar">*</td>
						<td> <html:text property="saghfeMojoodi" size="10" maxlength="9" styleClass="field"/><span class="fieldDescription">&nbsp;ريال</span></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">حداکثر تعداد کار همزمان:</td>
						<td class="editStar">*</td>
						<td> <html:text property="hadaksarKar" size="10" maxlength="9" styleClass="field"/></td>
					</tr>

					<!----------------------------------------->

					<!--tr class="editRow0">
						<td class="editLabel">وضعيت:</td>
						<td class="editStar">*</td>
						<td>
							<  html :select property="vazeat" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html  : options collection="vazeatList" property="id" labelProperty="name" /  >
							<  / html  :select>
						</td>
					</tr-->

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نوع امدادگر:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="noeEmdadgarId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="noeEmdadgarList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">دفتر استاني:</td>
						<td class="editStar"> </td>
						<td class="readData">
							<bean:write name="daftarOstaniName" />
							<html:hidden property="daftarOstaniId" />
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نمايندگي:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="namayandegiId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="namayandegiList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">ازطول جغرافيائی:</td>
						<td class="editStar">*</td>
						<td> <html:text property="azToole" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تاطول جغرافيائی:</td>
						<td class="editStar">*</td>
						<td> <html:text property="taToole" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">ازعرض جغرافيائی:</td>
						<td class="editStar">*</td>
						<td> <html:text property="azArze" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تاعرض جغرافيائی:</td>
						<td class="editStar">*</td>
						<td> <html:text property="taArze" size="10" maxlength="10" styleClass="field"/> </td>
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
	setForm(document.emdadgarForm);
	setEntity("Emdadgar");
    if (document.emdadgarForm.action_type.value=="create") 
	{
        document.emdadgarForm.action="/emdad/c/validateemdadgar.run";
    } 
	
	else 
	{
        document.emdadgarForm.action="/emdad/u/validateemdadgar.run";
    }
</script>
<html:javascript formName="emdadgarForm" />
