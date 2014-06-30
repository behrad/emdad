<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %><body onkeydown="Jadid()"/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/shahr">
    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-filter.jsp" flush="true" />
    <!------------------------------------------------>
<%--begin{don't know what is this!}--%>
	

<html:base/>
<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
		<tr>
			<logic:equal name="entity_access" property="deleteAccess" value="true" >
				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td class = "filterFieldCell" width="2%" colspan="2"></td>
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
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="shahrId" size="3" maxlength="5"/></td>
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="shahrName" size="21" maxlength="30"/></td>
			<td class="filterFieldCell">
				<html:select property="ostanId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
				<html:options collection="ostanList" property="eid" labelProperty="name" />
				</html:select>
			</td>
			<td class="filterFieldCell"><html:text property="codeShahrKhodrosaz" size="7" maxlength="10" onkeypress="return ( submitenter2(this,event) && doFilterByEnter() );"/></td>
            <td class="filterFieldCell">&nbsp;</td>
           	<td class="filterFieldCell">&nbsp;</td>
            <td class="filterFieldCell">&nbsp;</td>
           	<td class="filterFieldCell">&nbsp;</td>
		</tr>
		<tr><td colspan="2" height="3"></td></tr>
		<tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "shahrId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شناسه شهر"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "shahrName"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام شهر"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "ostanId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام استان"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "codeShahrKhodrosaz"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "کد شهر خودروساز"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "azTool"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "ازطول جغرافيائی"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "taTool"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "تاطول جغرافيائی"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "azArz"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "ازعرض جغرافيائی"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "taArz"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "تاعرض جغرافيائی"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
		</tr>

		<!------------------------------------------------>

		<% int i = 0; %>
		<logic:iterate id="value_object" name="value_object_list" >
			<tr  class="listRow<%=i%2%>">
				<logic:equal name="entity_access" property="deleteAccess" value="true" >
					<td class = "listRow1Col">
						<html:multibox property="selectedItems" ><bean:write name="value_object" property="id"  /></html:multibox>
					</td>
				</logic:equal>

				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td  class = "listRow1Col" align="center">
						<a  href='javascript:edit("<bean:write name="value_object" property="id"  />");'><img src="images/pencil.gif" border="0"></a >
					</td>
				</logic:equal>

				<td class = "listRow1Col">
					<logic:equal name="entity_access" property="readAccess" value="true" >
						<a  href='javascript:read("<bean:write name="value_object" property="id"  />");'>
					</logic:equal>
					<bean:write property="shahrId" name="value_object"/>
					<logic:equal name="entity_access" property="readAccess" value="true" >
						</a>
					</logic:equal>
				</td>

				<td class = "listRow1Col"><bean:write name="value_object" property="shahrName"  /></td>

				<td class = "listRow1Col"><bean:write property="ostanName" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="codeShahrKhodrosaz" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="azToole" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="taToole" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="azArze" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="taArze" name="value_object"/></td>
			</tr>
			<%i++;%>
		</logic:iterate>

		<!------------------------------------------------>

	</table>

	<!------------------------------------------------>
	<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-but.jsp" flush="true" />
	<!------------------------------------------------>

</html:form>

<!------------------------------------------------>

<script>
	setForm(document.shahrForm);
	setEntity("Shahr");
</script>
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
