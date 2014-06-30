<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<html:form method="post" action="/c/validatebazaryabMotefareghe" onsubmit="return validateBazaryabMotefaregheForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نام و نام خانوادگی:</td>
						<td class="editStar">*</td>
						<td> <html:text property="name" size="35" maxlength="35" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تلفن:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tel" size="35" maxlength="50" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تلفن همراه:</td>
						<td class="editStar"> </td>
						<td> <html:text property="mobile" size="35" maxlength="50" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">آدرس:</td>
						<td class="editStar">*</td>
						<td> <html:text property="address" size="50" maxlength="80" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نام پدر:</td>
						<td class="editStar"> </td>
						<td> <html:text property="namePedar" size="20" maxlength="20" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره شناسنامه:</td>
						<td class="editStar"> </td>
						<td> <html:text property="shShenasname" size="10" maxlength="10" styleClass="field"/> </td>
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
	setForm(document.bazaryabMotefaregheForm);
	setEntity("BazaryabMotefareghe");
    if (document.bazaryabMotefaregheForm.action_type.value=="create")
	{
        document.bazaryabMotefaregheForm.action="/emdad/c/validatebazaryabMotefareghe.run";
    }

	else
	{
        document.bazaryabMotefaregheForm.action="/emdad/u/validatebazaryabMotefareghe.run";
    }
</script>
<html:javascript formName="bazaryabMotefaregheForm" />
