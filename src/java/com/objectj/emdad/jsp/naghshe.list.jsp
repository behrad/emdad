<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>
<body onkeydown="Jadid()"/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />

<script>
function upload(id){
	args = "width=700, height=500 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "Uplaod";
	win3 = window.open("/emdad/com/objectj/emdad/jsp/naghshe.requpload.jsp?naghsheId="+id, windowTitle,args);
	win3.creator=window;
	win3.focus();
	clearRefresh();
}
</script>
<html:form method="post" action="/l/naghshe">

    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-filter.jsp" flush="true" />
    <!------------------------------------------------>

<html:base/>
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

			<td class="filterFieldCell"><html:text property="mapLevel" size="1" maxlength="2" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="azTooleGoegraphy" size="10" maxlength="4" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="taTooleGoegraphy" size="10" maxlength="4" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="azArzeGoegraphy" size="10" maxlength="4" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="taArzeGoegraphy" size="10" maxlength="4" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="mantagheId" size="1" maxlength="2" styleClass="field"/></td>
		</tr>

	    <!------------------------------------------------>				

		<tr><td colspan="2" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

			<td class = "listRow0Col" width="4%" align="center"><span class="textW">&#1606;&#1602;&#1588;&#1607;</span></td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "mapLevel"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "&#1587;&#1591;&#1581;"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "azTooleGoegraphy"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "&#1575;&#1586;&#1591;&#1608;&#1604; &#1580;&#1594;&#1585;&#1575;&#1601;&#1610;&#1575;&#1574;&#1740;"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "taTooleGoegraphy"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "&#1578;&#1575;&#1591;&#1608;&#1604; &#1580;&#1594;&#1585;&#1575;&#1601;&#1610;&#1575;&#1574;&#1740;"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "azArzeGoegraphy"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "&#1575;&#1586;&#1593;&#1585;&#1590; &#1580;&#1594;&#1585;&#1575;&#1601;&#1610;&#1575;&#1574;&#1740;"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "taArzeGoegraphy"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "&#1578;&#1575;&#1593;&#1585;&#1590; &#1580;&#1594;&#1585;&#1575;&#1601;&#1610;&#1575;&#1574;&#1740;"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "mantagheId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "&#1605;&#1606;&#1591;&#1602;&#1607;"
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
                    <td class = "listRow1Col" align="center">
                        <a  href='javascript:upload("<bean:write name="value_object" property="id"  />");'><img src="images/c-op.gif" border="0"></a >
                    </td>
				</logic:equal>
				
				<td class = "listRow1Col">
					<logic:equal name="entity_access" property="readAccess" value="true" >
						<a  href='javascript:read("<bean:write name="value_object" property="id"  />");'>
					</logic:equal>
					<bean:write property="mapLevel" name="value_object"/>
					<logic:equal name="entity_access" property="readAccess" value="true" >
						</a >
					</logic:equal>
				</td>

				<td class = "listRow1Col"><bean:write property="azTooleGoegraphy" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="taTooleGoegraphy" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="azArzeGoegraphy" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="taArzeGoegraphy" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="mantagheId" name="value_object"/></td>
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
	setForm(document.naghsheForm);
	setEntity("Naghshe");
</script>
