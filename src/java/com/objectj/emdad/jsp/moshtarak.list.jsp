<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" import="com.objectj.emdad.ejb.*"%>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Jadid()"/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<script>
function ebtal() {
args = "width=400 , height=250 , resizable=yes, scrollbars=yes, status=0";
windowTitle = "Ebtal";
win3 = window.open("/emdad/com/objectj/emdad/jsp/moshtarak.ebtal.jsp" , windowTitle, args);
win3.creator=document.moshtarakForm;
//clearRefresh();

//win3.creator=document.window;
}

function openRep2() {
	window.open("/reports/default.jsp?reportId=49&user=<%=((UserSession) session.getAttribute("user_session")).getName()%>&isSQL=<%=((UserSession) session.getAttribute("user_session")).isISDatabaseSQL()%>&isLocal=<%=((UserSession) session.getAttribute("user_session")).isLocal()%>" , "report", "resizable=yes, scrollbars=yes, status=0");
}
</script>
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
			<td class="filterFieldCell">
				<html:select property="noeEshterak"  style="width:50px;"  onkeypress="return submitenter(this,event)" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="noeEshterakList" property="id" labelProperty="name" />
				</html:select>
			</td>
			<td class="filterFieldCell">
				<html:select property="noeService" size="1"  style="width:40px;"  onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="noeServiceList" property="id" labelProperty="name" />
				</html:select>
			</td>
			<td class="filterFieldCell">
				<html:select property="vazeat" size="1" style="width:60px;"  onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="vazeatList" property="id" labelProperty="name" />
				</html:select>
			</td>
			<td class="filterFieldCell"><html:text property="nameKhanevadegi" size="14" maxlength="20" onkeypress="return submitenter(this,event)" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="name" size="14" maxlength="20" onkeypress="return submitenter(this,event)" styleClass="field"/></td>
			<td class="filterFieldCell">
				<html:select property="noeKhodroId" size="1" style="width:110px;" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="noeKhodroList"property="eid" labelProperty="name" />
				</html:select>
			</td>
			<td class="filterFieldCell"><html:text property="shomarePelak" size="15" maxlength="22" onkeypress="return submitenter(this,event)" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="tarikhEngheza" size="7" maxlength="10" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="namayandegi" size="7" maxlength="10" styleClass="field"/></td>
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
							<jsp:setProperty name="cur_records" property="columnName" value= "noeEshterak"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نوع اشتراک"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "noeService"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نوع سرويس"
							/><jsp:getProperty name="cur_records" property="sortableColumnString" />
						</td>

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "vazeat"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "وضعيت اشتراک"
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

						<td class = "listRow0Col">
							<jsp:setProperty name="cur_records" property="columnName" value= "namayandegi"
							/><jsp:setProperty name="cur_records" property="columnTitle" value= "نمايندگي"
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
						<td class = "listRow1Col"><bean:write property="noeEshterakName" name="value_object"/></td>
						<td class = "listRow1Col"><bean:write property="noeServiceName" name="value_object"/></td>
						<td class = "listRow1Col"><bean:write property="vazeatName" name="value_object"/></td>
						<td class = "listRow1Col"><bean:write property="nameKhanevadegi" name="value_object"/></td>
						<td class = "listRow1Col"><bean:write property="name" name="value_object"/></td>
						<td class = "listRow1Col"><bean:write property="noeKhodroOnvan" name="value_object"/></td>
						<td class = "listRow1Col"><bean:write property="shomarePelak" name="value_object"/></td>
						<td class = "listRow1Col"><bean:write property="tarikhEnghezaHejri" name="value_object"/></td>
						<td class = "listRow1Col"><bean:write property="namayandegi" name="value_object"/></td>
						</tr>
						<%i++;%>
					</logic:iterate>

					<!------------------------------------------------>

				</table>

				<!------------------------------------------------>
				<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-but.jsp" flush="true" >
				</jsp:include>
				<!------------------------------------------------>
<logic:equal name="role" value="eshterak" >
<tr> <td colspan="10">
<input type="button"  value="ابطال اشتراک"  class="emdadButton" onClick="javascript:ebtal();" />
</td></tr>
</logic:equal>
<logic:equal name="role" value="foroush" >
<tr> <td colspan="10">
<a href="javascript:openRep2();" >
گزارش مشترکين جهت صدور کارت</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/logs/importMoshtarak.html" target="blank">وضعيت آخرين اطلاعات منتقل شده</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/emdad/com/objectj/emdad/jsp/moshtarak.logs.jsp" target="blank">فهرست انتقال ها</a>&nbsp;&nbsp;&nbsp;&nbsp;
</td></tr>
</logic:equal>
</html:form>

<!------------------------------------------------>

<script>
	setForm(document.moshtarakForm);
	setEntity("Moshtarak");
</script>
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
