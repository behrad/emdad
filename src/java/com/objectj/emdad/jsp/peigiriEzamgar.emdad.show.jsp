<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<body onload=showDone()>

<!---------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/show-top.jsp" flush="true" />


<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
		<% int i = 0; %>
		<logic:iterate id="ss" name="peigiriList" >
			<tr class="listRow<%=i%2%>">

				<td class = "listRow1Col">
                    &nbsp;<bean:write property="zamanPeigiriHejri" name="ss"/>&nbsp;
				</td>
				<td class = "listRow1Col">
                    <bean:write property="natije" name="ss"/>
				</td>
            </tr>

            <%i++;%>
        </logic:iterate>
	<%if (i==0) {%>
	<tr class="listRow<%=i%2%>">
		<td class = "listRow1Col">موردي پيدا نشد
		</td>
            </tr>
<%}%>
</table>

<!---------------------------------------->


