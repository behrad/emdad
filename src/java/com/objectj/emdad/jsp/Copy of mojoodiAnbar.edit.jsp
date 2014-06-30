<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<script>
    function qateDetails() {
		showDetail(document.mojoodiAnbarForm.qateId,
			null,
			"dimg1",
			"showQate",
			"edtl",
			"/emdad/s/qate.run?action_type=specific,qateShow") ;
	}

	function qateSearch() {
		doSearchAndHide("showQate",
				 "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/qate.run?action_type=specific,find",
				 document.mojoodiAnbarForm,
				 "dimg1");
	}
</script>

<body onkeydown="Sabt()"/>

<html:form method="post" action="/c/validatemojoodiAnbar" onsubmit="return validateMojoodiAnbarForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

				    <html:hidden property="anbarId" />

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">قطعه:</td>
						<td class="editStar">*</td>
						<td>
                            <html:hidden property="qateId" />
					        <html:text property="qateIdCode" size="11" maxlength="11" styleClass="field" onchange="valueChanged(this)"/>
							<a href="javascript:qateDetails()" ><img src="images/show-on.gif" border="0" id="dimg1"></a>
							<input type="button" value="جستجو" onClick="javascript:qateSearch();" />
						</td>
					</tr>
					<!----------------------------------------->

					<tr class="editRow1">
						<td colspan="3">
							<div style="display:none;height:100px;" id="showQate">
								<iframe width="100%" height="100%" src="" frameborder="1" name="edtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">موجودی:</td>
						<td class="editStar">*</td>
						<td> <html:text property="mojoodi" size="5" maxlength="5" styleClass="field"/> </td>
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
	setForm(document.mojoodiAnbarForm);
	setEntity("MojoodiAnbar");
	document.mojoodiAnbarForm.qateId.changed = true;

    if (document.mojoodiAnbarForm.action_type.value=="create")
	{
        document.mojoodiAnbarForm.action="/emdad/c/validatemojoodiAnbar.run";
    }

	else
	{
        document.mojoodiAnbarForm.action="/emdad/u/validatemojoodiAnbar.run";
    }
</script>
<html:javascript formName="mojoodiAnbarForm" />
