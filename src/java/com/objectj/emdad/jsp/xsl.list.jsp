<%@ page contentType = "application/vnd.ms-excel; charset=UTF-8" %>
<!--% response.setContentType("application/vnd.ms-excel"); %-->
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<table dir=rtl align="center" class="generalText">
					<% int i = 0; %>
					<logic:iterate id="value_object" name="value_object_list" >
						<tr  class="listRow<%=i%2%>">
							<td class = "listRow1Col"><a  href='javascript:read("<bean:write name="value_object" property="id"  />");'><bean:write property="khodrosazId" name="value_object"/></a ></td>

							<td class = "listRow1Col"><bean:write property="name" name="value_object"/></td>
						</tr>
						<%i++;%>
					</logic:iterate>
	</table>
امداد خودرو ایران