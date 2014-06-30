<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<%@ page import ="com.objectj.emdad.ejb.util.Constants" %>

<html:base/>

<script>
	function selectEntityList() {
		namayandegiDivObj = document.getElementById("showNamayandegiCombo");
		emdadgarDivObj = document.getElementById("showEmdadgarCombo");
		naghshId1 = parseInt(document.shakhsForm.naghshId.value);


		if(naghshId1 == <%=Constants.getNamayandegiShoghlId()%>) {
			namayandegiDivObj.style.display = "inline";
			emdadgarDivObj.style.display = "none";
		}
		else if (naghshId1 == <%=Constants.getEmdadgarEstekhdamiShoghlId()%> || naghshId1 == <%=Constants.getEmdadgarPeymaniShoghlId()%>) {
			namayandegiDivObj.style.display = "none";
			emdadgarDivObj.style.display = "inline";
		}
		else {
			namayandegiDivObj.style.display = "none";
			emdadgarDivObj.style.display = "none";
		}
	}
	
</script>

<body onkeydown="Sabt()"/>

<html:form method="post" action="/c/validateshakhs" onsubmit="return validateShakhsForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شناسه:</td>
						<td class="editStar">*</td>
						<td> <bean:write name="shakhsForm" property="shakhsId" /></td>
						<html:hidden property="shakhsId"/>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نام:</td>
						<td class="editStar">*</td>
						<td> <html:text property="name" size="40" maxlength="40" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نقش:</td>
						<td class="editStar">*</td>
						<td>
                            <html:select property="naghshId" size="1" onchange="javascript:selectEntityList();" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="naghshList" property="eid" labelProperty="name" />
							</html:select>
                        </td>
					</tr>

					<!----------------------------------------->

                    <tr class="editRow1">
						<td class="editLabel">دفتر استاني:</td>
						<td class="editStar"> </td>
						<td class="readData">
							<logic:equal name="entity_access" property="allAccess" value="true" >
								<html:select property="daftarOstaniId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
									<html:options collection="daftarOstaniList" property="eid" labelProperty="name" />
								</html:select>
							</logic:equal>							
							
							<logic:equal name="entity_access" property="allAccess" value="false" >
								<bean:write name="daftarOstaniName" />
								<html:hidden property="daftarOstaniId" />
							</logic:equal>							
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">امدادگر يا نمايندگي:</td>
						<td class="editStar">*</td>
						<td>							
							<div id="showNamayandegiCombo" style="display:none;">
								<html:select property="namayandegiId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
									<html:options collection="namayandegiList" property="eid" labelProperty="name" />
								</html:select>
							</div>

							<div id="showEmdadgarCombo" style="display:none;">
								<html:select property="emdadgarId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
									<html:options collection="emdadgarList" property="eid" labelProperty="name" />
								</html:select>
							</div>
                        </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شناسه کاربر:</td>
						<td class="editStar"> </td>
						<td> <html:text property="username" size="20" maxlength="64" styleClass="field"/> </td>
					</tr>


					<!----------------------------------------->

                    <tr class="editRow0">
						<td class="editLabel">گذرواژه:</td>
						<td class="editStar"> </td>
						<td> <html:password property="password" size="20" maxlength="64" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

                    <tr class="editRow1">
						<td class="editLabel">تکرار گذرواژه:</td>
						<td class="editStar"> </td>
						<td> <html:password property="repassword" size="20" maxlength="64" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

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
	setForm(document.shakhsForm);
	setEntity("Shakhs");
    if (document.shakhsForm.action_type.value=="create")
	{
        document.shakhsForm.action="/emdad/c/validateshakhs.run";
    }

	else
	{
        document.shakhsForm.action="/emdad/u/validateshakhs.run";
    }

	selectEntityList();
</script>
<html:javascript formName="shakhsForm" />
