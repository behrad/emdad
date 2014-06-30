<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Sabt()"/>
<html:form method="post" action="/c/validatebazaryab" onsubmit="return validateBazaryabForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شناسه بازارياب:</td>
						<td class="editStar">*</td>
						<td> <html:text property="bazaryabId" size="5" maxlength="5"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نوع بازارياب:</td>
						<td class="editStar">*</td>
						<td>
							<logic:equal name="bazaryabForm" property="action_type" value="update">
								<bean:write name="noeBazaryabOnvan" />
								<html:hidden property="noeBazaryabId" />
							</logic:equal>

							<logic:equal name="bazaryabForm" property="action_type" value="create">
								<html:select property="noeBazaryabId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
									<html:options collection="noeBazaryabList" property="eid" labelProperty="name" />
								</html:select>
							</logic:equal>
						</td>
					</tr>

					<!----------------------------------------->

					<logic:equal name="bazaryabForm" property="action_type" value="update">
						<tr class="editRow0">
							<td class="editLabel">نام بازارياب:</td>
							<td class="editStar"> </td>
							<td>
								<html:select property="bazaryabKey" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
									<html:options collection="bazaryabNameList" property="eid" labelProperty="name" />
								</html:select>
							</td>
						</tr>
					</logic:equal>

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
	setForm(document.bazaryabForm);
	setEntity("Bazaryab");
    if (document.bazaryabForm.action_type.value=="create") 
	{
        document.bazaryabForm.action="/emdad/c/validatebazaryab.run";
    } 
	
	else 
	{
        document.bazaryabForm.action="/emdad/u/validatebazaryab.run";
    }
</script>
<html:javascript formName="bazaryabForm" />
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
