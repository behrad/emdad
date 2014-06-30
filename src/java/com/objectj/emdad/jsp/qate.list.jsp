<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %><body onkeydown="Jadid()"/>

<script>

function qateImport() {
	args = "width=850, height=480 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "Upload";
	win3 = window.open("/emdad/s/qate.run?action_type=specific,requpload", windowTitle,args);
	win3.creator=window;
	win3.focus();
}

</script>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/qate">

    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-filter.jsp" flush="true" />
    <!------------------------------------------------>

	

<html:base/>
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

			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="qateId" size="3" maxlength="5" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="shomareFanni" size="8" maxlength="12" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="name" size="20" maxlength="40" onkeypress="return ( submitenter2(this,event) && doFilterByEnter() );" styleClass="field"/></td>
			<td class="filterFieldCell">
				<html:select property="vahedShomaresh" size="1">
					<html:options collection="vahedShomareshList" property="id" labelProperty="name" />
				</html:select>
			</td>
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="gheimat" size="7" maxlength="9" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="saghfeTedadi" size="3" maxlength="5" styleClass="field"/></td>
			
		</tr>

	    <!------------------------------------------------>				

		<tr><td colspan="2" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "qateId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شناسه"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "shomareFanni"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره فني"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "name"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام قطعه"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "vahedShomaresh"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "واحد شمارش"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "gheimat"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "قيمت(ريال)"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "saghfeTedadi"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "سقف تعدادی"
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
                                <bean:write property="qateId" name="value_object"/>
                                <logic:equal name="entity_access" property="readAccess" value="true" >
                                	</a>
                                </logic:equal>
                </td>

				<td class = "listRow1Col"><bean:write property="shomareFanni" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="name" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="vahedShomareshName" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="gheimat" name="value_object"/></td>
				
				<td class = "listRow1Col"><bean:write property="saghfeTedadi" name="value_object"/></td>
            </tr>
            <%i++;%>
        </logic:iterate>
    </table>

	<logic:equal name="entity_access" property="createAccess" value="true" >
    <%
        request.setAttribute("additional" , "<input type=\"button\" value=\"انتقال\" onClick=\"javascript:qateImport();\" class=\"emdadButton\"> ");
    %>
	</logic:equal>
    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-but.jsp" flush="true" />
    <!------------------------------------------------>

</html:form>

<!------------------------------------------------>

<script>
	setForm(document.qateForm);
	setEntity("Qate");
</script>
