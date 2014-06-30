<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %><body onkeydown="Jadid()"/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/tamdidEshterak">
	

<html:base/>
<table dir=rtl align="center" class="generalText">
    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-filter.jsp" flush="true" />
    <!------------------------------------------------>

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

			<td class="filterFieldCell"><html:text property="eshterakId" size="10" maxlength="10"/></td>
			<td class="filterFieldCell"><html:text property="tarikhAkharinTamdid" size="10" maxlength="10"/></td>
			<td class="filterFieldCell"><html:text property="name" size="14" maxlength="20"/></td>
			<td class="filterFieldCell"><html:text property="nameKhanevadegi" size="14" maxlength="20"/></td>
		</tr>

	    <!------------------------------------------------>

		<tr><td colspan="2" height="3"></td></tr>

	    <!------------------------------------------------>

        <tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "eshterakId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره اشتراک"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "tarikhAkharinTamdid"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "تاريخ تمديد"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "name"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "nameKhanevadegi"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام خانوادگي"
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
					<td class = "listRow1Col" align="center">
						<logic:equal name="value_object" property="isLast" value="1" >
							<a  href='javascript:edit("<bean:write name="value_object" property="id"  />");'><img src="images/pencil.gif" border="0"></a >
						</logic:equal>						
					</td>
				</logic:equal>
			
				<td class = "listRow1Col">
					<logic:equal name="entity_access" property="readAccess" value="true" >
						<a  href='javascript:read("<bean:write name="value_object" property="id"  />");'>
					</logic:equal>
						<bean:write property="eshterakId" name="value_object"/>
					<logic:equal name="entity_access" property="readAccess" value="true" >
						</a>
					</logic:equal>
				</td>

				<td class = "listRow1Col"><bean:write property="tarikhAkharinTamdidHejri" name="value_object"/></a ></td>

				<td class = "listRow1Col"><bean:write property="name" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="nameKhanevadegi" name="value_object"/></td>
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
	setForm(document.tamdidEshterakForm);
	setEntity("TamdidEshterak");
	setHelpURL("/emdad/com/objectj/resources/jsp/help/tamdidEshterak.list.help.html");
</script>
