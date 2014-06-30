<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<script>

    function qateDetails() {
		showDetail(document.mojoodiMojazForm.qateId,
			null,
			"dimg1",
			"showQate",
			"edtl",
			"/emdad/s/qate.run?action_type=specific,qateShow") ;
	}

	function qateSearch() {
		doSearchAndHide("showQate",
				 "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/qate.run?action_type=specific,find",
				 document.mojoodiMojazForm,
				 "dimg1");
	}

</script>

<html:form method="post" action="/c/validatemojoodiMojaz" onsubmit="return validateMojoodiMojazForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شناسه نوع امدادگر:</td>
						<td class="editStar">*</td>
						<td>
                        <logic:equal name="emdadgarColumnShow" value="true" >
							<html:select property="noeEmdadgarId" size="1"  onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="noeEmdadgarList" property="eid" labelProperty="name" />
							</html:select>
                        </logic:equal>
                        <!-- logic : notEqual name="emdadgarColumnShow" value="true" >
                            < bean : write name="noeEmdadgarOnvan" />
                            < html : hidden property="noeEmdadgarId" />
                        < / logic : notEqual -->
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">قطعه:</td>
						<td class="editStar">*</td>
						<td>
                            <html:hidden property="qateId" />
					        <html:text property="shomarehFanni" size="11" maxlength="11" styleClass="field" onchange="valueChanged(this)"/>
							<a href="javascript:qateDetails()" ><img src="images/show-on.gif" border="0" id="dimg1"></a>
							<input type="button" value="جستجو" onClick="javascript:qateSearch();" />
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تعداد:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tedad" size="5" maxlength="5" styleClass="field"/> </td>
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
	setForm(document.mojoodiMojazForm);
	setEntity("MojoodiMojaz");
    if (document.mojoodiMojazForm.action_type.value=="create") 
	{
        document.mojoodiMojazForm.action="/emdad/c/validatemojoodiMojaz.run";
    } 
	
	else 
	{
        document.mojoodiMojazForm.action="/emdad/u/validatemojoodiMojaz.run";
    }
</script>
<html:javascript formName="mojoodiMojazForm" />
