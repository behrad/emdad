<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/qate">
	<table dir=rtl align="center" class="generalText">
		<!------------------------------------------------>

		<tr class="listTableHeader">
			<td class = "listRow0Col" width="%5">رديف</td>
			<td class = "listRow0Col">شرح وضعيت</td>
		</tr>

		<!------------------------------------------------>

		<% int i = 1; %>
		<logic:iterate id="value_object" name="errorList" >
			<tr  class="listRow<%=i%2%>">
				<td class = "listRow1Col"><%=i%></td>
				<td class = "listRow1Col"><bean:write name="value_object"/></td>
				</tr>
			<%i++;%>
		</logic:iterate>
		<tr  class="listTableHeader"><td colspan="5">&nbsp;</td></tr>
		<logic:greaterEqual name="errorCount" value="1" >
		<tr  class="listTableHeader"><td colspan="5" class = "listRow0Col"><a href="/logs/importQate.html"><span class="textW"> نمايش فايل Log </span></a></td></tr>
		</logic:greaterEqual>
		<!------------------------------------------------>

	</table>
</html:form>