<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Sabt()"/>

<html:form method="post" action="/c/validateojrat" onsubmit="return validateOjratForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">کد:</td>
						<td class="editStar">*</td>
						<td> <html:text property="ojratId" size="7" maxlength="5" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">عنوان:</td>
						<td class="editStar">*</td>
						<td> <html:text property="onvan" size="60" maxlength="60" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">اجرت:</td>
						<td class="editStar">*</td>
						<td> <html:text property="ojrat" size="9" maxlength="9" styleClass="field"/><span class="fieldDescription">&nbsp;ريال</span></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">مدت:</td>
						<td class="editStar"> </td>
						<td> <html:text property="modat" size="7" maxlength="7" styleClass="field"/><span class="fieldDescription">&nbsp;دقيقه</span></td>
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
	setForm(document.ojratForm);
	setEntity("Ojrat");
    if (document.ojratForm.action_type.value=="create") 
	{
        document.ojratForm.action="/emdad/c/validateojrat.run";
    } 
	
	else 
	{
        document.ojratForm.action="/emdad/u/validateojrat.run";
    }
</script>
<html:javascript formName="ojratForm" />
