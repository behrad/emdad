﻿<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>
<!---------------------------------------->

<html:base/>

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script>
	fitWidth(window);
</script>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/show-top.jsp" flush="true" />
<!---------------------------------------->

<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
	<tr class="listTableHeader">
            <td class = "listRow0Col" align="center"><span class="textW">کد مورد</span></td>
            <td class = "listRow0Col" align="center"><span class="textW">دستور کار</span></td>
            <td class = "listRow0Col" align="center"><span class="textW">نوع امداد</span></td>
            <td class = "listRow0Col" align="center"><span class="textW">پذيرشگر</span></td>
            <td class = "listRow0Col" align="center"><span class="textW">تلفن</span></td>
            
	    <td class = "listRow0Col" align="center"><span class="textW">زمان تماس</span></td>
            <td class = "listRow0Col" align="center"><span class="textW">زمان اعزام</span></td>
            <td class = "listRow0Col" align="center"><span class="textW">زمان شروع</span></td>
            <td class = "listRow0Col" align="center"><span class="textW">زمان پايان</span></td>
            
	    <td class = "listRow0Col" align="center"><span class="textW">راه اندازي</span></td>
	    <td class = "listRow0Col" align="center"><span class="textW">کيلومتر کارکرد</span></td>
            <td class = "listRow0Col" align="center"><span class="textW">نمايندگي و عامليت</span></td>
            <td class = "listRow0Col" align="center"><span class="textW">امدادگر</span></td>
	    <td class = "listRow0Col" align="center"><span class="textW">اعزامگر</span></td>
	</tr>
	
	<!------------------------------------------------>
	<% int i = 0; %>
	<logic:iterate id="value_object" name="savabegh" >
	<tr class="readRow<%=i%2%>">
            <td class = "listRow1Col" align="right"><bean:write property="rokhdadId" name="value_object"/></td>
            <td class = "listRow1Col" align="right"><bean:write property="emdadId" name="value_object"/></td>
	    <td class = "listRow1Col" align="right"><logic:equal property="noeEmdad" name="value_object" value="1">تعمیری</logic:equal>
<logic:equal property="noeEmdad" name="value_object" value="2">بالینی</logic:equal>
</td>
            <td class = "listRow1Col" align="right"><bean:write property="pazireshgarName" name="value_object"/></td>
            <td class = "listRow1Col" align="right"><bean:write property="tel" name="value_object"/></td>

		<td class = "listRow1Col" align="right"><bean:write property="zamanTamasHejri" name="value_object"/></td>
            <td class = "listRow1Col" align="right"><bean:write property="zamanEzamHejri" name="value_object"/></td>
            <td class = "listRow1Col" align="right"><bean:write property="zamanShoroHejri" name="value_object"/></td>
            <td class = "listRow1Col" align="right"><bean:write property="zamanPayanHejri" name="value_object"/></td>

            <td class = "listRow1Col" align="right"><bean:write property="rahAndazi" name="value_object"/></td>
            <td class = "listRow1Col" align="right"><bean:write property="kilometerKarkard" name="value_object"/></td>
            <td class = "listRow1Col" align="right"><bean:write property="namayandegiId" name="value_object"/></td>
		<td class = "listRow1Col" align="right"><bean:write property="emdadgarName" name="value_object"/></td>
            <td class = "listRow1Col" align="right"><bean:write property="ezamgarName" name="value_object"/></td>
	</tr>
	<tr class="readRow<%=i%2%>">
  		<td colspan=8 class = "listRow1Col" align="right">آدرس:<bean:write property="address" name="value_object"/></td>
		<td colspan=5 class = "listRow1Col" align="right">ايراد: <bean:write property="irad" name="value_object"/></td>
	</tr>

	<%i++;%>
	</logic:iterate>
</table>