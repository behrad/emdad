<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Jadid()"/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/peigiriEzamgar">

    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-filter.jsp" flush="true" />
    <!------------------------------------------------>

	<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0" width="500">

		<!------------------------------------------------>

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

			<td class="filterFieldCell"><html:text property="zamanPeigiri" size="7" maxlength="10" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="natije" size="20" maxlength="80" onkeypress="return submitenter(this,event)" styleClass="field"/></td>
			<td class="filterFieldCell">
				<html:text property="emdadEmdadId" size="7" maxlength="10" styleClass="field"/>
			</td>
		</tr>

	    <!------------------------------------------------>

		<tr><td colspan="2" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "zamanPeigiri"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "زمان پی گیری"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "natije"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "نتيجه پي گيري"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			 </td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "emdadId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "دستورکار"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
		</tr>

		<!------------------------------------------------>

		<% int i = 0; %>
		<logic:iterate id="value_object" name="value_object_list" >
			<tr class="listRow<%=i%2%>">
				<logic:equal name="value_object" property="emdadVazeatKonuni" value="2">
				<logic:equal name="entity_access" property="deleteAccess" value="true" >
					<td class = "listRow1Col">&nbsp;

					</td>
				</logic:equal>

				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td class = "listRow1Col" align="center">&nbsp;

					</td>
				</logic:equal>
				</logic:equal>

				<logic:notEqual name="value_object" property="emdadVazeatKonuni" value="2">
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
				</logic:notEqual>

				<td class = "listRow1Col">
					<logic:equal name="entity_access" property="readAccess" value="true" >
						<a  href='javascript:read("<bean:write name="value_object" property="id"  />");'>
					</logic:equal>
					<bean:write property="zamanPeigiriHejri" name="value_object"/>
					<logic:equal name="entity_access" property="readAccess" value="true" >
						</a>
					</logic:equal>
                </td>

				<td class = "listRow1Col"><bean:write property="natije" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="emdadEmdadId" name="value_object"/></td>
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
	setForm(document.peigiriEzamgarForm);
	setEntity("PeigiriEzamgar");
</script>
