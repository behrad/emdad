<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<html:base/>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>

<body onkeydown="Sabt()"/>
<input type="hidden" name="helpUrl" value="/emdad/com/objectj/resources/jsp/help/rokhdad.edit.help.html"/>
<html:form method="post" action="/c/validatenaghshe" onsubmit="return validateNaghsheForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">سطح:</td>
						<td class="editStar">*</td>
						<td> <html:text property="mapLevel" size="2" maxlength="2" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">ازطول جغرافيائی:</td>
						<td class="editStar">*</td>
						<td> <html:text property="azTool" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تاطول جغرافيائی:</td>
						<td class="editStar">*</td>
						<td> <html:text property="taTool" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">ازعرض جغرافيائی:</td>
						<td class="editStar">*</td>
						<td> <html:text property="azArz" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تاعرض جغرافيائی:</td>
						<td class="editStar">*</td>
						<td> <html:text property="taArz" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->
					<tr class="editRow1">
						<td class="editLabel">منطقه:</td>
						<td class="editStar">*</td>
						<td> <html:text property="mantagheId" size="2" maxlength="2" styleClass="field"/> </td>
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
	setForm(document.naghsheForm);
	setEntity("Naghshe");
    if (document.naghsheForm.action_type.value=="create") 
	{
        document.naghsheForm.action="/emdad/c/validatenaghshe.run";
    } 
	
	else 
	{
        document.naghsheForm.action="/emdad/u/validatenaghshe.run";
    }
</script>
<html:javascript formName="naghsheForm" />
