<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Sabt()"/>
<html:form method="post" action="/c/validatenoeEmdadgar" onsubmit="return validateNoeEmdadgarForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شناسه نوع امدادگر:</td>
						<td class="editStar">*</td>
						<td> <html:text property="noeEmdadgarId" size="15" maxlength="5"  styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">عنوان:</td>
						<td class="editStar">*</td>
						<td> <html:text property="onvan" size="30" maxlength="30" styleClass="field" /> </td>
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
	setForm(document.noeEmdadgarForm);
	setEntity("NoeEmdadgar");
    if (document.noeEmdadgarForm.action_type.value=="create")
	{
        document.noeEmdadgarForm.action="/emdad/c/validatenoeEmdadgar.run";
    }

	else
	{
        document.noeEmdadgarForm.action="/emdad/u/validatenoeEmdadgar.run";
    }
</script>
<html:javascript formName="noeEmdadgarForm" />
