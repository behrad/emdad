<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/khodrojagozinMasraf">
<!--jsp : setProperty name="entity_access" property="updateAccess" value= "true" />
< jsp : setProperty name="entity_access" property="deleteAccess" value= "true" />
< jsp : setProperty name="entity_access" property="readAccess" value= "true" />
< jsp : setProperty name="entity_access" property="createAccess" value= "true" /-->

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

			<td class="filterFieldCell"><html:text property="emdadEmdadId" size="13" maxlength="19" styleClass="field"/></td>

			<td class="filterFieldCell">
				<html:select property="khodrojagozinId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="khodrojagozinList" property="eid" labelProperty="name" />
				</html:select>
            </td>

			<td class="filterFieldCell"><html:text property="tarikhTahvilBeMoshtari" size="12" maxlength="10" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="tarikhTahvilAzMoshtari" size="12" maxlength="10" styleClass="field"/></td>

		</tr>

	    <!------------------------------------------------>

		<tr><td colspan="2" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "emdadId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "امداد"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "khodrojagozinId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "خودرو جایگزین"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "tarikhTahvilBeMoshtari"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "تاریخ تحویل دادن به مشتری"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "tarikhTahvilAzMoshtari"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "تاریخ تحویل  گرفتن از مشتری"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

		</tr>

		<!------------------------------------------------>

		<% int i = 0; %>
		<logic:iterate id="value_object" name="value_object_list" >
			<tr class="listRow<%=i%2%>">
				<logic:equal name="entity_access" property="deleteAccess" value="true" >
					<td class = "listRow1Col">
						<logic:equal name="value_object" property="tarikhTahvilAzMoshtariHejri" value="">
							<html:multibox property="selectedItems" ><bean:write name="value_object" property="id"  /></html:multibox>
						</logic:equal>
					</td>
				</logic:equal>

				<td class = "listRow1Col" align="center">
					<logic:equal name="entity_access" property="updateAccess" value="true" >
						<logic:equal name="value_object" property="tarikhTahvilAzMoshtariHejri" value="">
							<a  href='javascript:edit("<bean:write name="value_object" property="id"  />");'><img src="images/pencil.gif" border="0"></a >
						</logic:equal>
					</logic:equal>
				</td>

				<td class = "listRow1Col">
					<logic:equal name="entity_access" property="readAccess" value="true" >
						<a  href='javascript:read("<bean:write name="value_object" property="id"  />");'>
					</logic:equal>
					<bean:write property="emdadEmdadId" name="value_object"/>
					<logic:equal name="entity_access" property="readAccess" value="true" >
						</a>
					</logic:equal>
				</td>

				<td class = "listRow1Col"><bean:write property="khodrojagozinPelak" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="tarikhTahvilBeMoshtariHejri" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="tarikhTahvilAzMoshtariHejri" name="value_object"/></td>

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
	setForm(document.khodrojagozinMasrafForm);
	setEntity("KhodrojagozinMasraf");
</script>
