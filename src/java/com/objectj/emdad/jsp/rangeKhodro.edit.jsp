<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Sabt()"/>
<html:form method="post" action="/c/validaterangeKhodro" onsubmit="return validateRangeKhodroForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شناسه رنگ:</td>
						<td class="editStar">*</td>
						<td> <html:text property="rangeKhodroId" size="5" maxlength="5"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">عنوان:</td>
						<td class="editStar">*</td>
						<td> <html:text property="onvan" size="30" maxlength="30" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">رنگ پايه:</td>
						<td class="editStar"></td>
						<td>
							<html:select property="baseRange" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="baseRangeList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->
					<tr class="editRow1">
						<td class="editLabel">کد رنگ خودرو ساز:</td>
						<td class="editStar"> </td>
						<td> <html:text property="codeRangeKhodrosaz" size="5" maxlength="5"  styleClass="field" /> </td>
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
	setForm(document.rangeKhodroForm);
	setEntity("RangeKhodro");
    if (document.rangeKhodroForm.action_type.value=="create") 
	{
        document.rangeKhodroForm.action="/emdad/c/validaterangeKhodro.run";
    } 
	
	else 
	{
        document.rangeKhodroForm.action="/emdad/u/validaterangeKhodro.run";
    }
</script>
<html:javascript formName="rangeKhodroForm" />
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
