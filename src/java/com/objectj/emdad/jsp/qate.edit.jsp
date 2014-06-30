<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Sabt()"/>

<html:form method="post" action="/c/validateqate" onsubmit="return validateQateForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شناسه:</td>
						<td class="editStar">*</td>
						<td> <html:text property="qateId" size="5" maxlength="5" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره فني:</td>
						<td class="editStar">*</td>
						<td> <html:text property="shomareFanni" size="12" maxlength="12" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نام قطعه:</td>
						<td class="editStar">*</td>
						<td> <html:text property="name" size="40" maxlength="40" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">واحد شمارش:</td>
						<td class="editStar">*</td>
						<td>
                            <html:select property="vahedShomaresh" size="1">
								<html:options collection="vahedShomareshList" property="id" labelProperty="name" />
							</html:select>
                        </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">قیمت</td>
						<td class="editStar">*</td>
						<td> <html:text property="gheimat" size="9" maxlength="9" styleClass="field"/> <span class="fieldDescription">ريال</span></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">سطح مهارت فني مورد نياز:</td>
						<td class="editStar">*</td>
						<td> <html:text property="satheMaharat" size="5" maxlength="5" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">سقف تعدادی:</td>
						<td class="editStar">*</td>
						<td> <html:text property="saghfeTedadi" size="5" maxlength="5" styleClass="field"/> </td>
					</tr>
					<tr class="editRow0">
						<td colspan="3"><span class="fieldDescription">اين قطعه حداکثر به اين تعداد مي تواند در دست هر امدادگري باشد</span></td>
					</tr>



                    <tr class="editRow1">
						<td class="editLabel">نوع خودرو:</td>
						<td class="editStar">*</td>
						<td>
                            <html:select property="noeKhodroId" size="1">
								<html:options collection="noeKhodroList" property="eid" labelProperty="name" />
							</html:select>
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
	setForm(document.qateForm);
	setEntity("Qate");
    if (document.qateForm.action_type.value=="create") 
	{
        document.qateForm.action="/emdad/c/validateqate.run";
    } 
	
	else 
	{
        document.qateForm.action="/emdad/u/validateqate.run";
    }
</script>
<html:javascript formName="qateForm" />
