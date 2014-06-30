<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<script>

    function qateDetails() {
		showDetail(document.mojoodiMojazForm.shomarehFanni,
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
						<td class="editLabel"> نوع امدادگر:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="noeEmdadgarId" size="1"  onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="noeEmdadgarList" property="eid" labelProperty="name" />
							</html:select>
                        <!-- logic : notEqual name="emdadgarColumnShow" value="true" >
                            < bean : write name="noeEmdadgarOnvan" />
                            < html : hidden property="noeEmdadgarId" />
                        < /logic : notEqual -->
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره فني:</td>
						<td class="editStar">*</td>
						<td>
					        <html:text property="shomarehFanni" size="14" maxlength="12" styleClass="field" onchange="valueChanged(this)"/>
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
	document.mojoodiMojazForm.shomarehFanni.changed = true;
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
