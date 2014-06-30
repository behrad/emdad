<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:form method="post" action="/c/validatedaftarOstani" onsubmit="return validateDaftarOstaniForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شناسه دفتر استاني:</td>
						<td class="editStar">*</td>
						<td> <html:text property="daftarOstaniId" size="5" maxlength="5"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نام دفتر استاني:</td>
						<td class="editStar">*</td>
						<td> <html:text property="name" size="50" maxlength="50" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">مسئول:</td>
						<td class="editStar">*</td>
						<td> <html:text property="masool" size="40" maxlength="40" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تلفن:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tel" size="50" maxlength="50" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تلفن همراه:</td>
						<td class="editStar">*</td>
						<td> <html:text property="mobile" size="50" maxlength="50" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">آدرس:</td>
						<td class="editStar">*</td>
						<td> <html:text property="address" size="50" maxlength="50" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>


					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">محدوده تحت پوشش:</td>
						<td class="editStar">*</td>
						<td> <html:textarea property="mahdodeh" styleClass="field" rows="3" cols="50" onkeypress="return submitenter2(this,event) && checkLength(256)"/></td>
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
	setForm(document.daftarOstaniForm);
	setEntity("DaftarOstani");
    if (document.daftarOstaniForm.action_type.value=="create") 
	{
        document.daftarOstaniForm.action="/emdad/c/validatedaftarOstani.run";
    } 
	
	else 
	{
        document.daftarOstaniForm.action="/emdad/u/validatedaftarOstani.run";
    }
</script>
<html:javascript formName="daftarOstaniForm" />
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
