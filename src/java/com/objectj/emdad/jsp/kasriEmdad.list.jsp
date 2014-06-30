<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/r/kasriEmdad">

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

			<td class="filterFieldCell"><html:text property="kasriId" size="5" maxlength="6" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="tarikh" size="10" maxlength="10" styleClass="field"/></td>

			<td class="filterFieldCell">
				<html:select property="emdadgarId" size="1">
					<html:options collection="emdadgarList" property="eid" labelProperty="name"/>
				</html:select>
			</td>

			<!--td class="filterFieldCell">
				<html:select property="tahvilshod" size="1">
					<html:options collection="tahvilshodList" property="id" labelProperty="name" />
				</html:select>
			</td-->

			<td class="filterFieldCell">
				<html:select property="taeedAnbardar" size="1">
					<html:options collection="taeedAnbardarList" property="id" labelProperty="name" />
				</html:select>
			</td>

			<td class="filterFieldCell">
				<html:select property="taeedEmdadgar" size="1">
					<html:options collection="taeedEmdadgarList" property="id" labelProperty="name" />
				</html:select>
			</td>
		</tr>

	    <!------------------------------------------------>				

		<tr><td colspan="2" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
			<logic:equal name="entity_access" property="deleteAccess" value="true" ><td class = "listRow0Col" width="2%">&nbsp;</td></logic:equal>
			<logic:equal name="entity_access" property="updateAccess" value="true" ><td class = "listRow0Col" width="4%" align="center"><span class="textW">اصلاح</span></td></logic:equal>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "kasriId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شناسه"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "tarikh"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "تاريخ"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "name"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "امدادگر"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<!--td class = "listRow0Col">
				< jsp :setProperty name="cur_records" property="columnName" value= "tahvilshod"
				/>< jsp  :setProperty name="cur_records" property="columnTitle" value= "تحويل شد؟"
				/>< jsp :getProperty name="cur_records" property="sortableColumnString" />
			</td-->

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "taeedAnbardar"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "تائيدانباردار؟"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "taeedEmdadgar"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "تائیدامدادگر؟"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
		</tr>

		<!------------------------------------------------>

		<% int i = 0; %>
		<logic:iterate id="value_object" name="value_object_list" >
			<tr class="listRow<%=i%2%>">
				<logic:equal name="entity_access" property="deleteAccess" value="true" >
					<td class = "listRow1Col"> 
						<logic:notEqual name="value_object" property="taeedAnbardar" value="1">
						<html:multibox property="selectedItems" ><bean:write name="value_object" property="id"  /></html:multibox>
						</logic:notEqual>
					</td>
				</logic:equal>

                    <logic:equal name="entity_access" property="updateAccess" value="true" >
	                <td class = "listRow1Col" align="center">&nbsp;
                        <logic:notEqual name="value_object" property="tahvilshod" value="1">
				<logic:equal name="role" value="anbar" >
					<logic:notEqual name="value_object" property="taeedAnbardar" value="1">
	                                <a  href='javascript:edit("<bean:write name="value_object" property="id"  />");'><img src="images/pencil.gif" border="0"></a >
					</logic:notEqual>
				</logic:equal>
				<logic:equal name="role" value="emdadgar" >
					<logic:equal name="value_object" property="taeedAnbardar" value="1">
						<logic:notEqual name="value_object" property="taeedEmdadgar" value="1">
	                                	<a  href='javascript:edit("<bean:write name="value_object" property="id"  />");'><img src="images/pencil.gif" border="0"></a >
						</logic:notEqual>
					</logic:equal>
				</logic:equal>
                        </logic:notEqual>
        	        </td>
                    </logic:equal>

				<td class = "listRow1Col">
					<logic:equal name="entity_access" property="readAccess" value="true" >
						<a  href='javascript:read("<bean:write name="value_object" property="id"  />");'>
					</logic:equal>
					<bean:write property="kasriId" name="value_object"/>
					<logic:equal name="entity_access" property="readAccess" value="true" >
						</a >
					</logic:equal>
				</td>
				<td class = "listRow1Col"><bean:write property="tarikhHejri" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="emdadgarName" name="value_object"/></td>

				<!--td class = "listRow1Col">< bean :write property="tahvilshodName" name="value_object"/></td-->

				<td class = "listRow1Col"><bean:write property="taeedAnbardarName" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="taeedEmdadgarName" name="value_object"/></td>
            </tr>
            <%i++;%>
        </logic:iterate>
    </table>
<%
if (((String)request.getAttribute("role")).equals("anbar")) {
request.setAttribute("additional" , "<input type=\"button\" name=\"auto\" value=\"\" onClick=\"javascript:doAuto();\" class=\"emdadButton\"> ");
}
%>
    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-but.jsp" flush="true" >
	</jsp:include>
    <!------------------------------------------------>

</html:form>

<!------------------------------------------------>

<script>
	function doAuto() {
		args = "width=600, height=300 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "Auto";
		win3 = window.open("/emdad/com/objectj/emdad/jsp/general.frame.jsp?url=/emdad/s/kasriEmdad.run?action_type=specific,kasriAuto", windowTitle,args);
//	win3.creator=document.rokhdadForm.hdnPage;
		win3.creator=document.kasriEmdadForm.hdnPage;
		win3.focus();
		//window.open("/emdad/s/kasriEmdad.run?action_type=specific,kasriAuto" , "ttl", 
		//	"width=600 , height=300 , resizable=yes, scrollbars=yes, status=0");
	}
	setForm(document.kasriEmdadForm);
	setEntity("KasriEmdad");
	if (document.kasriEmdadForm.auto!=null) {
		document.kasriEmdadForm.auto.value = "کسري خودکار";
	}
</script>
