<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Sabt()"/>
<html:form method="post" action="/c/validatenoeKhodro" onsubmit="return validateNoeKhodroForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<tr class="editRow0">
						<td class="editLabel">شناسه نوع خودرو:</td>
						<td class="editStar">*</td>
						<td> <html:text property="noeKhodroId" size="5" maxlength="5" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">عنوان:</td>
						<td class="editStar">*</td>
						<td> <html:text property="onvan" size="30" maxlength="30" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">ضمانت:</td>
						<td class="editStar">*</td>
						<td> <html:text property="guarantee" size="5" maxlength="5" styleClass="field"/>&nbsp;<span class="fieldDescription">ماه </span></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">مسافت ضمانت:</td>
						<td class="editStar">*</td>
						<td> <html:text property="guaranteeDistance" size="5" maxlength="5" styleClass="field"/>&nbsp;<span class="fieldDescription">کيلومتر</span></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">کد نوع خودرو:</td>
						<td class="editStar">*</td>
						<td> <html:text property="noeKhodroCode" size="4" maxlength="2" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">کد خودروي خودروساز:</td>
						<td class="editStar"> </td>
						<td> <html:text property="khodroCode" size="5" maxlength="5" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">مشمول خدمات ويژه:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="vijeh" size="1">
								<html:options collection="isVijehList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>


					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">هزينه يک ساعت کار:</td>
						<td class="editStar">*</td>
						<td> <html:text property="hazinehSaat" size="7" maxlength="7" onkeypress="return submitenter(this,event)" styleClass="field"/>&nbsp;<span class="fieldDescription">ريال</span> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">هزينه اشتراک عادي:</td>
						<td class="editStar">*</td>
						<td> <html:text property="hazinehEshterakAdi" size="7" maxlength="7" onkeypress="return submitenter(this,event)" styleClass="field"/>&nbsp;<span class="fieldDescription">ريال</span> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">هزينه اشتراک ويژه:</td>
						<td class="editStar">*</td>
						<td> <html:text property="hazinehEshterakVijeh" size="7" maxlength="7" onkeypress="return submitenter(this,event)" styleClass="field"/>&nbsp;<span class="fieldDescription">ريال</span> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">خودروساز:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="khodrosazId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="khodrosazList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نوع سرويس هنگامimport:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="noeService" size="1">
								<html:options collection="noeServiceList" property="id" labelProperty="name" />
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
	setForm(document.noeKhodroForm);
	setEntity("NoeKhodro");
    if (document.noeKhodroForm.action_type.value=="create")
	{
        document.noeKhodroForm.action="/emdad/c/validatenoeKhodro.run";
    }

	else
	{
        document.noeKhodroForm.action="/emdad/u/validatenoeKhodro.run";
    }
</script>
<html:javascript formName="noeKhodroForm" />
