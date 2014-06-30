<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body />
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/moshtarak">


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
			<td class="filterFieldCell"><html:text property="eshterakId" size="10" maxlength="10" onkeypress="return submitenter(this,event)" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="shomareShasi" size="7" maxlength="10" styleClass="field"/></td>
     		<td class="filterFieldCell"><html:text property="nameKhanevadegi" size="14" maxlength="20" onkeypress="return submitenter(this,event)" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="name" size="14" maxlength="20" onkeypress="return submitenter(this,event)" styleClass="field"/></td>
			<td class="filterFieldCell">
				<html:select property="noeKhodroId" size="1" style="width:150px;" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="noeKhodroList" property="eid" labelProperty="name" />
				</html:select>
			</td>
			<td class="filterFieldCell"><html:text property="shomarePelak" size="14" maxlength="20" onkeypress="return submitenter(this,event)" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="tarikhEngheza" size="7" maxlength="10" styleClass="field"/></td>
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
							<jsp:setProperty name="cur_records" property="columnName" value= "shomareShasi"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره شاسي"
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

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "noeKhodroOnvan"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نوع خودرو"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "shomarePelak"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره پلاک"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "tarikhEngheza"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "تاريخ انقضاي اشتراک"
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
                                <bean:write property="eshterakId" name="value_object"/>
                                <logic:equal name="entity_access" property="readAccess" value="true" >
                                	</a>
                                </logic:equal>
                            </td>
						<td class = "listRow1Col"><bean:write property="shomareShasi" name="value_object"/></td>
						<td class = "listRow1Col"><bean:write property="nameKhanevadegi" name="value_object"/></td>
						<td class = "listRow1Col"><bean:write property="name" name="value_object"/></td>
						<td class = "listRow1Col"><bean:write property="noeKhodroOnvan" name="value_object"/></td>
						<td class = "listRow1Col"><bean:write property="shomarePelak" name="value_object"/></td>
						<td class = "listRow1Col"><bean:write property="tarikhEnghezaHejri" name="value_object"/></td>
						</tr>
						<%i++;%>
					</logic:iterate>

					<!------------------------------------------------>

				</table>

				<!------------------------------------------------>
				<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-but.jsp" flush="true" />
				<!------------------------------------------------>

			</td>
			<tr>

		<!------------------------------------------------>

	</table>
</html:form>

<!------------------------------------------------>

<script>
	setForm(document.moshtarakForm);
	setEntity("Moshtarak");
	if (document.moshtarakForm.newbut!=null)
		document.moshtarakForm.newbut.style.display="none";
</script>
