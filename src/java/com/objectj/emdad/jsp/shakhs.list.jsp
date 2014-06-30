<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Jadid()"/>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/shakhs">

    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-filter.jsp" flush="true" />
    <!------------------------------------------------>

	<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">

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

			<td class="filterFieldCell"><html:text property="shakhsId" size="3" maxlength="5" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="name" size="20" maxlength="40" onkeypress="return submitenter(this,event)" styleClass="field"/></td>

			<td class="filterFieldCell">
                <html:select property="naghshId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="naghshList" property="eid" labelProperty="name" />
				</html:select>
            </td>

            <logic:equal name="entity_access" property="allAccess" value="true" >
				<td class="filterFieldCell">
					<html:select property="daftarOstaniId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
						<html:options collection="daftarOstaniList" property="eid" labelProperty="name" />
					</html:select>
				</td>
			</logic:equal>
			<td class="filterFieldCell"><html:text property="username" size="15" maxlength="64" styleClass="field"/></td>
            <logic:equal name="entity_access" property="updateAccess" value="true" >
            <td class="filterFieldCell">&nbsp</td>
            </logic:equal>
		</tr>

	    <!------------------------------------------------>

		<tr><td colspan="2" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "shakhsId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره کاربر"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "name"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام کاربر"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "naghshName"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "نقش کاربر"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

            <logic:equal name="entity_access" property="allAccess" value="true" >
				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "daftarOstaniName"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "دفتر استانی"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>
			</logic:equal>
			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "username"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شناسه کاربری"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
            <td class = "listRow0Col">&nbsp</td>
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

                 <td class = "listRow1Col">
                    <logic:equal name="entity_access" property="readAccess" value="true" >
                        <a  href='javascript:read("<bean:write name="value_object" property="id"  />");'>
                    </logic:equal>
                    <bean:write property="shakhsId" name="value_object"/>
                    <logic:equal name="entity_access" property="readAccess" value="true" >
                        </a>
                    </logic:equal>
                </td>

				<td class = "listRow1Col"><bean:write property="name" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="naghshName" name="value_object"/></td>

                <logic:equal name="entity_access" property="allAccess" value="true" >
					<td class = "listRow1Col"><bean:write property="daftarOstaniName" name="value_object"/></td>
				</logic:equal>

                <td class = "listRow1Col"><bean:write property="username" name="value_object"/></td>
                
                <logic:equal name="entity_access" property="updateAccess" value="true" >
                <td class = "listRow1Col">
                <logic:equal value="1" name="value_object" property="enable" >
                    <a href="/emdad/s/shakhs.run?action_type=specific,disable&id=<bean:write property="id" name="value_object"/>">غیر فعال سازی</a>
                </logic:equal>
                <logic:equal value="0" name="value_object" property="enable" >
                    <a href="/emdad/s/shakhs.run?action_type=specific,enable&id=<bean:write property="id" name="value_object"/>">فعال سازی</a>
                </logic:equal>
                </td>
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
	setForm(document.shakhsForm);
	setEntity("Shakhs");
</script>
