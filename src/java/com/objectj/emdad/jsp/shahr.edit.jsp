<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Sabt()"/>
<html:form method="post" action="/c/validateshahr" onsubmit="return validateShahrForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شناسه شهر:</td>
						<td class="editStar">*</td>
						<td> <html:text property="shahrId" size="5" maxlength="5"  styleClass="field"  /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نام شهر:</td>
						<td class="editStar">*</td>
						<td> <html:text property="shahrName" size="30" maxlength="30" onkeypress="return submitenter(this,event)" styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نام استان:</td>
						<td class="editStar"></td>
						<td>
							<html:select property="ostanId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
							<html:options collection="ostanList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">کد شهر خودروساز:</td>
						<td class="editStar">*</td>
						<td> <html:text property="codeShahrKhodrosaz" size="10" maxlength="10" onkeypress="return submitenter(this,event)" styleClass="field" /> </td>
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
	setForm(document.shahrForm);
	setEntity("Shahr");
    if (document.shahrForm.action_type.value=="create")
	{
        document.shahrForm.action="/emdad/c/validateshahr.run";
    }

	else
	{
        document.shahrForm.action="/emdad/u/validateshahr.run";
    }
</script>
<html:javascript formName="shahrForm" />
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
