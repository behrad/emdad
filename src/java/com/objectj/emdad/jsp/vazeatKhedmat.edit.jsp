<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Sabt()"/>

<html:form method="post" action="/c/validatevazeatKhedmat" onsubmit="return validateVazeatKhedmatForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شناسه:</td>
						<td class="editStar">*</td>
						<td> <html:text property="vazeatKhedmatId" size="5" maxlength="5" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">عنوان:</td>
						<td class="editStar">*</td>
						<td> <html:text property="onvan" size="30" maxlength="30" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
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
	setForm(document.vazeatKhedmatForm);
	setEntity("VazeatKhedmat");
    if (document.vazeatKhedmatForm.action_type.value=="create") 
	{
        document.vazeatKhedmatForm.action="/emdad/c/validatevazeatKhedmat.run";
    } 
	
	else 
	{
        document.vazeatKhedmatForm.action="/emdad/u/validatevazeatKhedmat.run";
    }
</script>
<html:javascript formName="vazeatKhedmatForm" />
