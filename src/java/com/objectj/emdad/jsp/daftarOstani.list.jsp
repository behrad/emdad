<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/daftarOstani">
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
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="daftarOstaniId" size="3" maxlength="5" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="name" size="20" maxlength="50" onkeypress="return ( submitenter2(this,event) && doFilterByEnter() );" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="masool" size="20" maxlength="40" onkeypress="return ( submitenter2(this,event) && doFilterByEnter() );" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="tel" size="20" maxlength="50" onkeypress="return ( submitenter2(this,event) && doFilterByEnter() );" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="mobile" size="20" maxlength="50" onkeypress="return ( submitenter2(this,event) && doFilterByEnter() );" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="address" size="20" maxlength="50" onkeypress="return ( submitenter2(this,event) && doFilterByEnter() );" styleClass="field"/></td>
		</tr>

		<tr><td colspan="2" height="3"></td></tr>
        <tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "daftarOstaniId"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "شناسه دفتر استاني"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "name"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام دفتر استاني"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "masool"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "مسئول"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "tel"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "تلفن"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "mobile"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "تلفن همراه"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "address"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "آدرس"
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
                                <bean:write property="daftarOstaniId" name="value_object"/>
                                <logic:equal name="entity_access" property="readAccess" value="true" >
                                	</a>
                                </logic:equal>
                            </td>

							<td class = "listRow1Col"><bean:write property="name" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="masool" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="tel" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="mobile" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="address" name="value_object"/></td>
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
	setForm(document.daftarOstaniForm);
	setEntity("DaftarOstani");
</script>
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
