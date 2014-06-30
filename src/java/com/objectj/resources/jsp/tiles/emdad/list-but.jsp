<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<!-- % @ page contentType="text/html; charset=UTF-8" % -->
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<script language="JavaScript" type="text/JavaScript">
function pageKeyPress() {
  if (window.event.keyCode == 13) {
  	changePage(document.all.pageInput.value);
	window.event.keyCode == 0;
  }
}
</script>

<table align="right" dir="rtl" border="0" cellspacing="0" class="generalText" width="100%">
	<tr>
		<td>
			<table border="0"  cellspacing="0" cellpadding="4" align="right" width="100%">
				<tr class="listTableFooter">
					<td>
						&nbsp;
						<html:hidden property="action_type"/>
						<html:hidden property="curpage" />
						<html:hidden property="order"/>
						<html:hidden property="sorttype" />
						<html:hidden property="id"/>
						<input type="hidden" name="fastComboHdn"/>

						<logic:equal name="entity_access" property="deleteAccess" value="true" >
							<input type="button" name="delbut" value="حذف" onClick="javascript:Delete();" class="emdadButton">
						</logic:equal>

						<logic:equal name="entity_access" property="createAccess" value="true" >
							<input type="button" name="newbut" value="جديد" onClick="javascript:makeNew();" class="emdadButton">
						</logic:equal>
						<%
							if (request.getParameter("additional") != null) {%>
								<%=request.getParameter("additional")%> <%}
						%>
						<%
							if (request.getAttribute("additional") != null) {%>
								<%=request.getAttribute("additional")%> <%}
						%>
					</td>
				</tr>
			</table>
		</td>
	</tr>

	<!----------------------------------------------------------->

	<tr>
		<td background="images/filter-bk.jpg">
			<table border="0" cellspacing="0" cellpadding="0" align="center" class="generalText">
				<tr align="center">

					<!------------------------------>

					<td width="20"><a href='javascript:changePage(1)'><img src="images/first.gif" alt="صفحه اول" border="0"></a></td>

					<!------------------------------>

					<logic:greaterThan name="cur_records" property="curPage" value="1" >
						<td width="20"><a href='javascript:changePage(<bean:write property="prevPage" name="cur_records"/>)'><img src="images/previous.gif" alt="صفحه قبلي" border="0"></a></td>
					</logic:greaterThan>

					<!------------------------------>


					<td>
						<a href="javascript:refreshPage()">صفحه</a>
					     <input name="hdnPage" type="hidden" onclick="refreshPage()">
						<input id="pageInput" name="tmpPage" value="<bean:write property="curPage" name="cur_records"/>" size="2" maxlength="5" class="field" onKeyPress="pageKeyPress()">
					</td>

					<!------------------------------>

					<logic:equal name="cur_records" property="hasNextPage" value="true" >
						<td width="20"><a href='javascript:changePage(<bean:write property="nextPage" name="cur_records"/>)'><img src="images/next.gif" alt="صفحه بعد" border="0"></a></td>
					</logic:equal>

					<!------------------------------>

					<td width="20" align="right"><a href='javascript:changePage(<bean:write property="totalPages" name="cur_records"/>)'><img src="images/last.gif" alt="صفحه آخر" border="0"></a></td>

					<!------------------------------>

				</tr>
			</table>
		</td>
	</tr>
</table>
<script type="text/javascript" language="Javascript1.1">
	document.all.fastComboHdn.lastTime = 0;
	setHelpURL("/emdad/com/objectj/resources/jsp/help/list.help.html");
</script>
