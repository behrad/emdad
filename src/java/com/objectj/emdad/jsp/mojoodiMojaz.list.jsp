<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
 <html:form method="post" action="/l/mojoodiMojaz">

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

			<td class="filterFieldCell">
          
                    <html:select property="noeEmdadgarId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
                        <html:options collection="noeEmdadgarList" property="eid" labelProperty="name"/>
                    </html:select>
     
			</td>
			<td class="filterFieldCell"><html:text property="shomarehFanni" size="12" maxlength="12" styleClass="field" onkeypress="return submitenter(this,event)"/></td>
		        <td class="filterFieldCell"><html:text property="qateName" size="8" maxlength="4" styleClass="field" /></td>
		        <td class="filterFieldCell"><html:text property="tedad" size="8" maxlength="4" styleClass="field" /></td>
		</tr>

	    <!------------------------------------------------>

		<tr><td colspan="4" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
			<logic:equal name="entity_access" property="deleteAccess" value="true" ><td class = "listRow0Col" width="2%">&nbsp;</td></logic:equal>
			<logic:equal name="entity_access" property="updateAccess" value="true" ><td class = "listRow0Col" width="4%" align="center"><span class="textW">اصلاح</span></td></logic:equal>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "noeEmdadgarId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "نوع امدادگر"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "shomarehFanni"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره فنی"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "qateName"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "قطعه"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "tedad"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "تعداد"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
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
					<bean:write property="noeEmdadgarOnvan" name="value_object"/>
					<logic:equal name="entity_access" property="readAccess" value="true" >
						</a >
					</logic:equal>
				</td>

				<td class = "listRow1Col" align="left"><bean:write property="shomarehFanni" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="qateName" name="value_object"/></td>
				<td class = "listRow1Col"><bean:write property="tedad" name="value_object"/></td>
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
	setForm(document.mojoodiMojazForm);
	setEntity("MojoodiMojaz");
</script>
