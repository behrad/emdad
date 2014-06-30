<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Sabt()"/>
<html:form method="post" action="/c/validaterole" onsubmit="return validateRoleForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شناسه نقش:</td>
						<td class="editStar">*</td>
						<td> <html:text property="roleId" size="5" maxlength="5"  /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نقش:</td>
						<td class="editStar">*</td>
						<td> <html:text property="role" size="30" maxlength="30"  /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نام موجوديت:</td>
						<td class="editStar">*</td>
						<td> <html:text property="entity" size="30" maxlength="30"  /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">دسترسي:</td>
						<td class="editStar">*</td>
						<td> <html:text property="access" size="5" maxlength="5"  /> </td>
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
	setForm(document.roleForm);
	setEntity("Role");
    if (document.roleForm.action_type.value=="create") 
	{
        document.roleForm.action="/emdad/c/validaterole.run";
    } 
	
	else 
	{
        document.roleForm.action="/emdad/u/validaterole.run";
    }
</script>
<html:javascript formName="roleForm" />
