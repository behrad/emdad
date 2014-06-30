<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

    <logic:equal name="entity_access" property="deleteAccess" value="true" >
        <td class = "listRow0Col" width="2%">
            <input type="checkbox" id="selectDesAll" onclick="javascript:checkOrClear();" >
        </td>
    </logic:equal>
    <logic:equal name="entity_access" property="updateAccess" value="true" >
        <td class = "listRow0Col" width="4%" align="center">
            <span class="textW">اصلاح</span>
        </td>
    </logic:equal>

