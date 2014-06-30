<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Sabt()"/>

<html:form method="post" action="/c/validatekhodrojagozin" onsubmit="return validateKhodrojagozinForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شناسه خودروی جایگزین :</td>
						<td class="editStar">*</td>
						<td> <html:text property="khodrojagozinId" size="5" maxlength="5" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">رنگ خودرو:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="rangeKhodroId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="rangeKhodroList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نوع خودرو:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="noeKhodroId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="noeKhodroList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">سال ساخت :</td>
						<td class="editStar">*</td>
						<td> <html:text property="salesakht" size="10" maxlength="4" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شماره پلاک :</td>
						<td class="editStar">*</td>
						<td> <html:text property="shomarehPelak" size="20" maxlength="20" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره موتور :</td>
						<td class="editStar">*</td>
						<td> <html:text property="shomarehMotor" size="20" maxlength="20" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شماره شاسی :</td>
						<td class="editStar">*</td>
						<td> <html:text property="shomarehShasi" size="20" maxlength="20" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">VINشماره :</td>
						<td class="editStar"></td>
						<td> <html:text property="shomarehVIN" size="20" maxlength="20" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">توضیحات :</td>
						<td class="editStar"> </td>
						<td> <html:text property="tozihat" size="64" maxlength="64" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">فعال :</td>
						<td class="editStar">*</td>
						<td>
                            <html:select property="faal" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
                                <html:options collection="faalList" property="id" labelProperty="name" />
                            </html:select>
                        </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">دفتر استاني:</td>
						<td class="editStar"></td>
						<td class="readData">
							<bean:write name="daftarOstaniName" />
							<html:hidden property="daftarOstaniId" />
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
	setForm(document.khodrojagozinForm);
	setEntity("Khodrojagozin");
    if (document.khodrojagozinForm.action_type.value=="create") 
	{
        document.khodrojagozinForm.action="/emdad/c/validatekhodrojagozin.run";
    } 
	
	else 
	{
        document.khodrojagozinForm.action="/emdad/u/validatekhodrojagozin.run";
    }
</script>
<html:javascript formName="khodrojagozinForm" />
