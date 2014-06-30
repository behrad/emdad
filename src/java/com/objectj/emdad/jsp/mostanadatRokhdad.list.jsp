<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<script>
	function editNameParvande(s){
		document.mostanadatRokhdadForm.action = "/emdad/s/mostanadatRokhdad.run?action_type=specific,upload&mostanadatRokhdadId=" + s + "&fromPopUp=false";
		mostanadatRokhdadForm.submit();
	}
</script>
<body onkeydown="Jadid()"/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/mostanadatRokhdad">

    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-filter.jsp" flush="true" />
    <!------------------------------------------------>

	<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">

		<!------------------------------------------------>

		<tr>
			<logic:equal name="entity_access" property="deleteAccess" value="true" >
				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td class = "filterFieldCell" width="2%" colspan="3"></td>
				</logic:equal>

				<logic:equal name="entity_access" property="updateAccess" value="false" >
					<td class = "filterFieldCell" width="2%"></td>
				</logic:equal>
			</logic:equal>

			<logic:equal name="entity_access" property="deleteAccess" value="false" >
				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td class = "filterFieldCell" width="2%"></td>
				</logic:equal>
			</logic:equal>

			<td class="filterFieldCell"><html:text property="mostanadatRokhdadId" size="3" maxlength="5" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="rokhdadRokhdadId" size="3" maxlength="5" styleClass="field"/></td>

			<td class="filterFieldCell"><html:text property="shomarehSanad" size="14" maxlength="20" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="nameSanad" size="14" maxlength="20" styleClass="field"/></td>
            <logic:equal name="entity_access" property="allAccess" value="true" >
				<td class="filterFieldCell">
					<html:select property="daftarOstaniId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
						<html:options collection="daftarOstaniList" property="eid" labelProperty="name" />
					</html:select>
				</td>
			</logic:equal>
		</tr>

	    <!------------------------------------------------>

		<tr><td colspan="2" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />
			<logic:equal name="entity_access" property="updateAccess" value="true" ><td class = "listRow0Col" width="4%" align="center"><span class="textW">2اصلاح</span></td></logic:equal>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "mostanadatRokhdadId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شناسه"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "rokhdadId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "رخداد"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "shomarehSanad"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره سند"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "namaParvande"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام پرونده"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
            <logic:equal name="entity_access" property="allAccess" value="true" >
				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "daftarOstaniId"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "دفتراستاني"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>
			</logic:equal>
		</tr>

		<!------------------------------------------------>

		<% int i = 0; %>
		<logic:iterate id="value_object" name="value_object_list" >
			<tr class="listRow<%=i%2%>">
				<logic:equal name="entity_access" property="deleteAccess" value="true" >
					<td class = "listRow1Col">
						<html:multibox property="selectedItems" ><bean:write name="value_object" property="id"  /></html:multibox>
					</td>
				</logic:equal>

				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td class = "listRow1Col" align="center">
						<a  href='javascript:edit("<bean:write name="value_object" property="id"  />");'><img src="images/pencil.gif" border="0"></a >
					</td>
				</logic:equal>

				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td class = "listRow1Col" align="center">
						<a  href='javascript:editNameParvande("<bean:write name="value_object" property="id"  />");'><img src="images/mostanad.gif" border="0"></a >
					</td>
				</logic:equal>

				<td class = "listRow1Col">
					<logic:equal name="entity_access" property="readAccess" value="true" >
						<a  href='javascript:read("<bean:write name="value_object" property="id"  />");'>
					</logic:equal>
					<bean:write property="mostanadatRokhdadId" name="value_object"/>
					<logic:equal name="entity_access" property="readAccess" value="true" >
						</a >
					</logic:equal>
				</td>

				<td class = "listRow1Col"><bean:write property="rokhdadRokhdadId" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="shomarehSanad" name="value_object"/></td>
                <td class = "listRow1Col">
					<a  target="_blank" href='http://<%=request.getServerName()%>:<%=request.getServerPort()%>/<bean:write property="nameParvande" name="value_object"/>'>
					<bean:write property="nameSanad" name="value_object"/></a>
				</td>
                <logic:equal name="entity_access" property="allAccess" value="true" >
					<td class = "listRow1Col"><bean:write property="daftarOstaniName" name="value_object"/></td>
				</logic:equal>

            </tr>
            <%i++;%>
        </logic:iterate>
    </table>

    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-but.jsp" flush="true" />
    <!------------------------------------------------>

</html:form>

<!------------------------------------------------>

<script>
	setForm(document.mostanadatRokhdadForm);
	setEntity("MostanadatRokhdad");
</script>
