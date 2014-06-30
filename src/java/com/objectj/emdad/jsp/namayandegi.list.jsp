<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %><body onkeydown="Jadid()"/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/namayandegi">
    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-filter.jsp" flush="true" />
    <!------------------------------------------------>
<%--begin{don't know what is this!}--%>
	

<html:base/>
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
			<td class="filterFieldCell"><html:text property="namayandegiId" size="3" maxlength="8" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>
			<td class="filterFieldCell"><html:text property="name" size="20" maxlength="35"  styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>
			<td class="filterFieldCell">
				<html:select property="shahrId" size="1" value="" style="width:80px;" onchange="filter();" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return fastCombo(this)" onfocus="emptyFastCombo()">
				<html:options collection="shahrList" property="eid" labelProperty="name" />
				</html:select>
			</td>
			<td class="filterFieldCell">
				<html:select property="daftarOstaniId" size="1" value="" onchange="filter();" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return fastCombo(this)" onfocus="emptyFastCombo()">
				<html:options collection="daftarOstaniList" property="eid" labelProperty="name" />
				</html:select>
			</td>
			<td class="filterFieldCell"><html:text property="namayandegiAddress" size="20" maxlength="40" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>
			<td class="filterFieldCell"><html:text property="telZaroori" size="8" maxlength="12" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>
			<td class="filterFieldCell"><html:text property="dastgahEybyab" size="8" maxlength="40" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>
			<td class="filterFieldCell"><html:text property="namayandegiTel" size="15" maxlength="14" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>
			<td class="filterFieldCell"><html:text property="namayandegiMobile" size="15" maxlength="15" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>
			<td class="filterFieldCell"><html:text property="hadaksarKar" size="5" maxlength="14" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>
			<td class="filterFieldCell"><html:text property="hadaksarKar2" size="5" maxlength="15" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>

		</tr>
		<tr><td colspan="2" height="3"></td></tr>
        <tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "namayandegiId"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "شناسه"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "name"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "&#1606;&#1575;&#1605; &#1606;&#1605;&#1575;&#1610;&#1606;&#1583;&#1711;&#1610;"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "shahrId"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "&#1606;&#1575;&#1605; &#1588;&#1607;&#1585;"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "daftarOstaniId"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "دفتر استاني"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "namayandegiAddress"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "آدرس"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "telZaroori"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "تلفن ضروری"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "dastgahEybyab"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "دستگاه عيب ياب"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col"><span class="textW">تلفن</span></td>

						<td class = "listRow0Col"><span class="textW">موبايل</span></td>
						
						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "hadaksarKar"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "سقف باليني"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "hadaksarKar2"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "سقف تعميري"
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
                                <bean:write property="namayandegiId" name="value_object"/>
                                <logic:equal name="entity_access" property="readAccess" value="true" >
                                	</a>
                                </logic:equal>
                            </td>

							<td class = "listRow1Col"><bean:write property="name" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="shahrName" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="daftarOstaniName" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="namayandegiAddress" name="value_object"/></td>
							<td class = "listRow1Col"><bean:write property="telZaroori" name="value_object"/></td>
							<td class = "listRow1Col"><bean:write property="dastgahEybyab" name="value_object"/></td>
							<td class = "listRow1Col"><bean:write property="namayandegiTel" name="value_object"/></td>
							<td class = "listRow1Col"><bean:write property="namayandegiMobile" name="value_object"/></td>
							<td class = "listRow1Col"><bean:write property="hadaksarKar" name="value_object"/></td>
							<td class = "listRow1Col"><bean:write property="hadaksarKar2" name="value_object"/></td>



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
	setForm(document.namayandegiForm);
	setEntity("Namayandegi");
</script>
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
