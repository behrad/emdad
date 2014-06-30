<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>



<html:base/>
<body onkeydown="Jadid()"/>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/jozeatKhedmat">

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
			
			<td class="filterFieldCell"><html:text property="dastorkar" size="11" maxlength="11" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="hazineh" size="11" maxlength="11" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="tedadQate" size="11" maxlength="5" styleClass="field"/></td>
			<td class="filterFieldCell">
				<html:select property="guarantee" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="guaranteeList" property="id" labelProperty="name" />
				</html:select>
			</td>
		</tr>

	    <!------------------------------------------------>				

		<tr><td colspan="2" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />


			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "khedmatId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "دستور کار"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "hazineh"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "هزینه&nbsp;(ريال)"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "tedadQate"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "تعداد قطعه مصرفی"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "guarantee"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "مشمول گارانتی؟"
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

					<td class = "listRow1Col" align="center">
						<a  href='javascript:edit("<bean:write name="value_object" property="id"  />");'><img src="images/pencil.gif" border="0"></a >
					</td>

				<td class = "listRow1Col">
					<logic:equal name="entity_access" property="readAccess" value="true" >
						<a  href='javascript:read("<bean:write name="value_object" property="id"  />");'>
					</logic:equal>
					<bean:write property="dastorkar" name="value_object"/>
					<logic:equal name="entity_access" property="readAccess" value="true" >
						</a >
					</logic:equal>
				</td>

				<td class = "listRow1Col"><bean:write property="hazineh" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="tedadQate" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="guaranteeName" name="value_object"/></td>
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
	setForm(document.jozeatKhedmatForm);
	setEntity("JozeatKhedmat");
</script>
