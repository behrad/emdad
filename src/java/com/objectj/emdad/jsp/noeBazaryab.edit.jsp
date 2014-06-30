<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Sabt()"/>
<html:form method="post" action="/c/validatenoeBazaryab" onsubmit="return validateNoeBazaryabForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شناسه نوع بازاریاب:</td>
						<td class="editStar">*</td>
						<td> <html:text property="noeBazaryabId" size="5" maxlength="5"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">عنوان:</td>
						<td class="editStar">*</td>
						<td> <html:text property="onvan" size="30" maxlength="30" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->


					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">جدول مرجع:</td>
						<td class="editStar">*</td>
						<td>
							<logic:equal name="noeBazaryabForm" property="action_type" value="update">
								<span class="text"><bean:write name="entityName" /></span>
								<html:hidden property="entity" />		
							</logic:equal>

							<logic:equal name="noeBazaryabForm" property="action_type" value="create">
								<html:select property="entity" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
									<html:options collection="entityList" property="id" labelProperty="name" />
								</html:select>
							</logic:equal>
						</td>
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
	setForm(document.noeBazaryabForm);
	setEntity("NoeBazaryab");
    if (document.noeBazaryabForm.action_type.value=="create") 
	{
        document.noeBazaryabForm.action="/emdad/c/validatenoeBazaryab.run";
    } 
	
	else 
	{
        document.noeBazaryabForm.action="/emdad/u/validatenoeBazaryab.run";
    }
</script>
<html:javascript formName="noeBazaryabForm" />
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
