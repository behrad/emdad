<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/r/moshtarak">
    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-filter.jsp" flush="true" />
    <!------------------------------------------------>
<%--begin{don't know what is this!}--%>
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
						<td class="filterFieldCell"><html:text property="eshterakId" size="7" maxlength="10" onkeypress="return submitenter(this,event)"/></td>
						<td class="filterFieldCell">
							<html:select property="noeEshterak" onkeypress="return submitenter(this,event)">
								<html:options collection="noeEshterakList" property="id" labelProperty="name" />
							</html:select>
						</td>
						<td class="filterFieldCell">
							<html:select property="noeService" size="1">
								<html:options collection="noeServiceList" property="id" labelProperty="name" />
							</html:select>
						</td>
						<td class="filterFieldCell">
							<html:select property="vazeat" size="1">
								<html:options collection="vazeatList" property="id" labelProperty="name" />
							</html:select>
						</td>
						<td class="filterFieldCell"><html:text property="nameKhanevadegi" size="14" maxlength="20" onkeypress="return submitenter(this,event)"/></td>
						<td class="filterFieldCell"><html:text property="name" size="14" maxlength="20" onkeypress="return submitenter(this,event)"/></td>
						<td class="filterFieldCell">
							<html:select property="noeKhodroId"  style="width:130px;"  size="1">
								<html:options collection="noeKhodroList"property="eid" labelProperty="name" />
							</html:select>
						</td>
						<td class="filterFieldCell"><html:text property="email" size="14" maxlength="20" /></td>
						<td class="filterFieldCell"><html:text property="tarikhAkharinEmail" size="14" maxlength="20"/></td>
						<td class="filterFieldCell"><html:text property="tarikhShoro" size="7" maxlength="10"/></td>
						<td class="filterFieldCell"><html:text property="tarikhEngheza" size="7" maxlength="10"/></td>
					</tr>

		<tr><td colspan="2" height="3"></td></tr>
        <tr class="listTableHeader">
            <logic:equal name="entity_access" property="deleteAccess" value="true" ><td class = "listRow0Col" width="2%">&nbsp;</td></logic:equal>
            <logic:equal name="entity_access" property="updateAccess" value="true" ><td class = "listRow0Col" width="4%" align="center"><span class="textW">اصلاح</span></td></logic:equal>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "eshterakId"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره اشتراک"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "noeEshterak"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نوع اشتراک"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "noeService"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نوع سرويس"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "vazeat"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "وضعيت اشتراک"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "nameKhanevadegi"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام خانوادگي"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "name"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "noeKhodroOnvan"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نوع خودرو"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "email"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "پست الکترونيکي"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "tarikhAkharinEmail"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "تاريخ آخرين Email"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "tarikhShoro"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "تاريخ شروع اشتراک"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "tarikhEngheza"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "تاريخ انقضاي اشتراک"
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

							<td class = "listRow1Col"><a  href='javascript:read("<bean:write name="value_object" property="id"  />");'><bean:write property="eshterakId" name="value_object"/></a ></td>

							<td class = "listRow1Col"><bean:write property="noeEshterakName" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="noeServiceName" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="vazeatName" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="nameKhanevadegi" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="name" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="noeKhodroOnvan" name="value_object"/></td>

							<td class = "listRow1Col"><a href="mailto:<bean:write property="email" name="value_object"/>"><bean:write property="email" name="value_object"/></a></td>

							<td class = "listRow1Col"><bean:write property="tarikhAkharinEmailHejri" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="tarikhShoroHejri" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="tarikhEnghezaHejri" name="value_object"/></td>
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
	setForm(document.moshtarakForm);
	setEntity("Moshtarak");
	setHelpURL("/emdad/com/objectj/resources/jsp/help/darhalEngheza.help.html");
</script>
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
