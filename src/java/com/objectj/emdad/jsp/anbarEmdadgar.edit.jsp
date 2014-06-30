<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<script>

    function qateDetails() {
		showDetail(document.anbarEmdadgarForm.qateId,
			null,
			"dimg1",
			"showQate",
			"edtl",
			"/emdad/s/qate.run?action_type=specific,qateShow") ;
	}

	function qateSearch() {
		doSearchAndHide("showQate",
				 "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/qate.run?action_type=specific,find",
				 document.anbarEmdadgarForm,
				 "dimg1");
	}

</script>

<body onkeydown="Sabt()"/>

<html:form method="post" action="/c/validateanbarEmdadgar" onsubmit="return validateAnbarEmdadgarForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">


    				<logic:notEqual name="anbarEmdadgarForm" property="action_type" value="create" >
                        <tr class="editRow1">
                            <td class="editLabel">دفتر استاني:</td>
                            <td class="editStar"></td>
                            <td class="readData">
                                    <bean:write name="daftarOstaniName" />
                            </td>
                        </tr>
					</logic:notEqual>
						<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">امدادگر:</td>
						<td class="editStar">*</td>
						<td>
                        <logic:equal name="emdadgarColumnShow" value="true" >
							<html:select property="emdadgarId" size="1"  onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="emdadgarList" property="eid" labelProperty="name" />
							</html:select>
                        </logic:equal>
                        <logic:notEqual name="emdadgarColumnShow" value="true" >
                            <bean:write property="emdadgarName" name="anbarEmdadgarForm" />
                            <html:hidden property="emdadgarId" />
                        </logic:notEqual>
						</td>
					</tr>
					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره فني قطعه:</td>
						<td class="editStar">*</td>
						<td>
                            <html:hidden property="qateId" />
					        <html:text property="shomareFanni" size="11" maxlength="11" styleClass="field" onchange="valueChanged(this)"/>
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
	setForm(document.anbarEmdadgarForm);
	setEntity("AnbarEmdadgar");
	document.anbarEmdadgarForm.qateId.changed = true;
    if (document.anbarEmdadgarForm.action_type.value=="create")
	{
        document.anbarEmdadgarForm.action="/emdad/c/validateanbarEmdadgar.run";
    }

	else
	{
        document.anbarEmdadgarForm.action="/emdad/u/validateanbarEmdadgar.run";
    }
</script>
<html:javascript formName="anbarEmdadgarForm" />
