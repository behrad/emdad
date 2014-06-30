<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/darkhastEshterak">
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
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="nameKhanevadegi" size="14" maxlength="20" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="nameMoshtarak" size="14" maxlength="20" styleClass="field"/></td>
			<td class="filterFieldCell">
				<html:select property="noeService" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="noeServiceList" property="id" labelProperty="name" />
				</html:select>
			</td>
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="telMoshtarak" size="20" maxlength="50" styleClass="field"/></td>
			<td class="filterFieldCell">
				<html:select property="noeKhodroId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="noeKhodroList"property="eid" labelProperty="name" />
				</html:select>
			</td>
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="saleSakht" size="3" maxlength="5" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="shomarePelak" size="14" maxlength="20" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="shomareShasi" size="14" maxlength="20" styleClass="field"/></td>
		</tr>

		<tr><td colspan="2" height="3"></td></tr>
        <tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "nameKhanevadegi"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "&#1606;&#1575;&#1605; &#1582;&#1575;&#1606;&#1608;&#1575;&#1583;&#1711;&#1610;"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "nameMoshtarak"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "&#1606;&#1575;&#1605;"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col"><span class="textW">&#1606;&#1608;&#1593; &#1587;&#1585;&#1608;&#1610;&#1587;</span></td>

						<td class = "listRow0Col"><span class="textW">&#1578;&#1604;&#1601;&#1606;</span></td>

						<td class = "listRow0Col"><span class="textW">&#1606;&#1608;&#1593; &#1582;&#1608;&#1583;&#1585;&#1608;</span></td>

						<td class = "listRow0Col"><span class="textW">&#1587;&#1575;&#1604; &#1587;&#1575;&#1582;&#1578;</span></td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "shomarePelak"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "&#1588;&#1605;&#1575;&#1585;&#1607; &#1662;&#1604;&#1575;&#1705;"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "shomareShasi"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "&#1588;&#1605;&#1575;&#1585;&#1607; &#1588;&#1575;&#1587;&#1610;"
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
                                <bean:write property="nameKhanevadegi" name="value_object"/>
                                <logic:equal name="entity_access" property="readAccess" value="true" >
                                	</a>
                                </logic:equal>
                            </td>

							<td class = "listRow1Col"><bean:write property="nameMoshtarak" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="noeServiceName" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="telMoshtarak" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="noeKhodroOnvan" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="saleSakht" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="shomarePelak" name="value_object"/></td>

							<td class = "listRow1Col"><bean:write property="shomareShasi" name="value_object"/></td>
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
	setForm(document.darkhastEshterakForm);
	setEntity("DarkhastEshterak");
	setHelpURL("/emdad/com/objectj/resources/jsp/help/darkhastEshterak.help.html");
</script>
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
