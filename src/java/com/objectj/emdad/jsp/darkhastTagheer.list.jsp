<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
﻿<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/darkhastTagheer">
	<table dir=rtl align="center" class="generalText">
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
			<td class="filterFieldCell"><html:text property="eshterakId" size="7" maxlength="10" onkeypress="return submitenter(this,event)"/></td>
			<td class="filterFieldCell"><html:text property="ijadKonandeh" size="14" maxlength="20" onkeypress="return submitenter(this,event)"/></td>
			<td class="filterFieldCell">
				<html:select property="noeService" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="noeServiceList" property="id" labelProperty="name" />
				</html:select>
			</td>
						<td class="filterFieldCell"><html:text property="nameKhanevadegi" size="14" maxlength="20" onkeypress="return submitenter(this,event)"/></td>
						<td class="filterFieldCell"><html:text property="name" size="14" maxlength="20" onkeypress="return submitenter(this,event)"/></td>
						<td class="filterFieldCell"><html:text property="tel" size="20" maxlength="50" onkeypress="return submitenter(this,event)"/></td>
						<td class="filterFieldCell"><html:text property="mobile" size="20" maxlength="50" onkeypress="return submitenter(this,event)"/></td>
					</tr>


				<tr><td colspan="2" height="3"></td></tr>
				<tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "eshterakId"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره اشتراک"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "ijadKonandeh"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "ایجادکننده"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "noeService"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نوع سرويس"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "nameKhanevadegi"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام خانوادگي"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "name"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col"><span class="textW"> تلفن </span></td>

						<td class = "listRow0Col"><span class="textW">تلفن همراه </span></td>
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
                                <bean:write property="eshterakId" name="value_object"/>
                                <logic:equal name="entity_access" property="readAccess" value="true" >
                                	</a>
                                </logic:equal>
                            </td>

							<td class = "listRow1Col"><bean:write property="ijadKonandeh" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="noeServiceName_old" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="nameKhanevadegi_old" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="name_old" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="tel_old" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="mobile_old" name="value_object"/></td>
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
	setForm(document.darkhastTagheerForm);
	setEntity("DarkhastTagheer");
</script>
