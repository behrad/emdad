<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<html:form method="post" action="/c/validatejozeatKasri" onsubmit="return validateJozeatKasriForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">کسری:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="kasriId" size="1">
								<html:options collection="KasriEmdadList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">قطعه:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="qateId" size="1">
								<html:options collection="QateList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تعدادکسری:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tedadKasri" size="5" maxlength="5" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تعدادانبار:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tedadAnbar" size="5" maxlength="5" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تعدادامدادگر:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tedadEmdadgar" size="5" maxlength="5" styleClass="field"/> </td>
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
	setForm(document.jozeatKasriForm);
	setEntity("JozeatKasri");
    if (document.jozeatKasriForm.action_type.value=="create") 
	{
        document.jozeatKasriForm.action="/emdad/c/validatejozeatKasri.run";
    } 
	
	else 
	{
        document.jozeatKasriForm.action="/emdad/u/validatejozeatKasri.run";
    }
</script>
<html:javascript formName="jozeatKasriForm" />
