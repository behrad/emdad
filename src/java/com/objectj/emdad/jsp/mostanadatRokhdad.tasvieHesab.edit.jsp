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

<%@ page import ="java.lang.*,com.objectj.emdad.ejb.util.EntityList,com.objectj.emdad.ejb.EntityAccess" %>

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>
<title></title>

<html:base/>
<script>
	function rokhdadDetails() {
		alert (document.mostanadatRokhdadForm.rokhdadRokhdadId.value);
		showDetail(document.mostanadatRokhdadForm.rokhdadRokhdadId,
				null,
				"dimg1",
				"showRokhdad",
				"rdtl",
				"/emdad/s/rokhdad.run?action_type=specific,rokhdadShow") ;
	}

	var lastCreator;
</script>
<body onkeydown="Sabt()"/>

<html:form method="post" action="/s/validatemostanadatRokhdad" onsubmit="return validateMostanadatRokhdadForm(this)">

	<table width="100%" dir=rtl class="generalText">
		<html:hidden property="tarikhSabt" />
		<html:hidden property="rokhdadId" />

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<html:hidden property="mostanadatRokhdadId" />
					<logic:equal name="mostanadatRokhdadForm" property="action_type" value="update">
						<tr class="editRow0">
							<td class="editLabel">شناسه :</td>
							<td class="editStar"> </td>
							<td class="readData">
								<bean:write name="form" property="mostanadatRokhdadId" />
							</td>
						</tr>
					</logic:equal>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">رخداد:</td>
						<td class="editStar">*</td>
			                        <td class="readData">
							<input type="hidden" name="rokhdadRokhdadId" value="<bean:write name="mostanadatRokhdadForm" property="rokhdadRokhdadId" />"/>
							<bean:write name="mostanadatRokhdadForm" property="rokhdadRokhdadId" />
							<a href="javascript:rokhdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
						</td>
					</tr>

					<tr class="editRow1">
						<td colspan="3">
							<div   style="display:none;height:100px;" id="showRokhdad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="rdtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->


					<tr class="editRow0">
						<td class="editLabel">نام سند:</td>
						<td class="editStar">*</td>
						<td> <html:text property="nameSanad" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره سند:</td>
						<td class="editStar"> </td>
						<td> <html:text property="shomarehSanad" size="20" maxlength="20" styleClass="field"/> </td>
					</tr>


					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تاریخ سند:</td>
						<td class="editStar"> </td>
						<td> <html:text property="tarikhSanad" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

                    <!----------------------------------------->

                    <logic:equal name="mostanadatRokhdadForm" property="action_type" value="update">
						<tr class="editRow1">
							<td class="editLabel">تاريخ ثبت سند:</td>
							<td class="editStar"> </td>
							<td class="readData">
								<bean:write name="tarikhSabt" />
							</td>
						</tr>
					</logic:equal>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شرح سند:</td>
						<td class="editStar">*</td>
						<td> <html:textarea property="sharh" onkeypress="return submitenter(this,event) && checkLength(127)" styleClass="field" rows="5" cols="50"/> </td>
					</tr>

					<!----------------------------------------->

                    <logic:equal name="mostanadatRokhdadForm" property="action_type" value="update">
					<tr class="editRow1">
						<td class="editLabel">نام پرونده:</td>
						<td class="editStar"></td>
						<td class="readData"> 
							<bean:write name="form" property="nameParvande"/>
							<html:hidden property="nameParvande" />
						</td>
					</tr>
					</logic:equal>

					<!----------------------------------------->

                    <tr class="editRow0">
						<td class="editLabel">دفتر استاني:</td>
						<td class="editStar"> </td>
						<td class="readData">
							<bean:write name="daftarOstaniName" />
							<html:hidden property="daftarOstaniId" />
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
	setForm(document.mostanadatRokhdadForm);
	setEntity("MostanadatRokhdad");
	
    if (document.mostanadatRokhdadForm.action_type.value=="create") 
		document.mostanadatRokhdadForm.action_type.value="specific,doTasvieHesabCreate";
	else
		document.mostanadatRokhdadForm.action_type.value="specific,doTasvieHesabUpdate";
    
	document.mostanadatRokhdadForm.rokhdadRokhdadId.changed = true;
</script>
<html:javascript formName="mostanadatRokhdadForm" />
