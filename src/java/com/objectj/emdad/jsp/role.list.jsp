<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Jadid()"/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/role">
	<table dir=rtl align="center" class="generalText">

		<!------------------------------------------------>

		<tr>
			<td align=left>

				<!------------------------------------------------>
				<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-filter.jsp" flush="true" />
				<!------------------------------------------------>

						<td><html:text property="roleId" size="3" maxlength="5"/></td>
						<td><html:text property="role" size="20" maxlength="30"/></td>
						<td><html:text property="entity" size="20" maxlength="30"/></td>
						<td><html:text property="access" size="3" maxlength="5"/></td>
					</tr>

					<!------------------------------------------------>

					<tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

						<td class = "listRow0Col">شناسه نقش</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "role"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نقش"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "entity"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام موجوديت"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "access"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "دسترسي"
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
                                <bean:write property="roleId" name="value_object"/>
                                <logic:equal name="entity_access" property="readAccess" value="true" >
                                	</a>
                                </logic:equal>
                            </td>

							<td class = "listRow1Col"><bean:write property="role" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="entity" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="access" name="value_object"/></td>
						</tr>
						<%i++;%>
					</logic:iterate>

					<!------------------------------------------------>

				</table>

				<!------------------------------------------------>
				<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-but.jsp" flush="true" />
				<!------------------------------------------------>

			</td>
		</tr>

		<!------------------------------------------------>

	</table>
</html:form>

<!------------------------------------------------>

<script>
	setForm(document.roleForm);
	setEntity("Role");
</script>
