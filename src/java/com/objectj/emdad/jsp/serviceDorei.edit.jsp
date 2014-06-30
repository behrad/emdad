<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<html:form method="post" action="/c/validateserviceDorei" onsubmit="return validateServiceDoreiForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نمايندگي:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="namayandegiId" size="1">
								<html:options collection="namayandegiList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تاريخ:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tarikh" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">مشتري:</td>
						<td class="editStar">*</td>
						<td>
						<html:text property="eshterakId" size="12" maxlength="10"  styleClass="field" />
						<html:hidden property="moshtarakId"/>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">کيلومتر کارکرد:</td>
						<td class="editStar">*</td>
						<td> <html:text property="kilometerKarkard" size="8" maxlength="8" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->
					<%
						
					%>
					<tr class="editRow0">
						<td class="editLabel">نوع سرويس دوره اي:</td>
						<td class="editStar">*</td>
						<td> 
							<html:select property="noeServiceDorei" onkeypress="fastCombo(this);" onfocus="emptyFastCombo()">
									<html:options collection="noeServiceDoreiList" property="eid" labelProperty="name" />
							</html:select>							
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">هزينه:</td>
						<td class="editStar">*</td>
						<td> <html:text property="hazineh" size="9" maxlength="9" styleClass="field"/> </td>
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
	setForm(document.serviceDoreiForm);
	setEntity("ServiceDorei");
    if (document.serviceDoreiForm.action_type.value=="create") 
	{
        document.serviceDoreiForm.action="/emdad/c/validateserviceDorei.run";
    } 
	
	else 
	{
        document.serviceDoreiForm.action="/emdad/u/validateserviceDorei.run";
    }
</script>
<html:javascript formName="serviceDoreiForm" />
