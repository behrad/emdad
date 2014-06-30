<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
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
