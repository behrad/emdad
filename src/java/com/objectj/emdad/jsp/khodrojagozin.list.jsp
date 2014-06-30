<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %><body onkeydown="Jadid()"/>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/khodrojagozin">

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

			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="khodrojagozinId" size="3" maxlength="5" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="shomarehPelak" size="10" maxlength="12" styleClass="field"/></td>
			<td class="filterFieldCell">
				<html:select property="noeKhodroId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="noeKhodroList" property="eid" labelProperty="name"/>
				</html:select>
			</td>
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="salesakht" size="14" maxlength="20" styleClass="field"/></td>
			<td class="filterFieldCell">
				<html:select property="faal" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="faalList" property="id" labelProperty="name" />
				</html:select>
            </td>
			<logic:equal name="entity_access" property="allAccess" value="true" >
				<td class="filterFieldCell">
					<html:select property="daftarOstaniId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
						<html:options collection="daftarOstaniList" property="eid" labelProperty="name" />
					</html:select>
				</td>
			</logic:equal>							
		</tr>

	    <!------------------------------------------------>

		<tr><td colspan="2" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "khodrojagozinId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شناسه "
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "shomarehPelak"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره پلاک"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "noeKhodroId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "نوع خودرو"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "salesakht"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "سال ساخت "
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "faal"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "فعال"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<logic:equal name="entity_access" property="allAccess" value="true" >
				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "daftarOstaniId"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "دفتراستاني"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>
			</logic:equal>							
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
					<bean:write property="khodrojagozinId" name="value_object"/>
					<logic:equal name="entity_access" property="readAccess" value="true" >
						</a >
					</logic:equal>
				</td>

				<td class = "listRow1Col"><bean:write property="shomarehPelak" name="value_object"/></td>
				<td class = "listRow1Col"><bean:write property="noeKhodroOnvan" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="salesakht" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="faalName" name="value_object"/></td>

				<logic:equal name="entity_access" property="allAccess" value="true" >
					<td class = "listRow1Col"><bean:write property="daftarOstaniName" name="value_object"/></td>
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
	setForm(document.khodrojagozinForm);
	setEntity("Khodrojagozin");
</script>
