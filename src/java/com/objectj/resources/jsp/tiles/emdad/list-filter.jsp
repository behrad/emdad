<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<%--filter tab--%>
<table border="0" cellpadding="2" class="listTable" cellspacing="0">
	<tr>
		<td height="20" background="images/caption.jpg" class="textBw" align="right">&nbsp;فيلتر&nbsp;&nbsp;</td>
	</tr>
</table>
<%--filter buttons and status--%>
<table width="100%" border="0" cellpadding="2" class="listTable" cellspacing="0" background="images/filter-bk.jpg">
	<tr>
		<td valign="middle" align="right" width="100">
			<a href="javascript:filter()"><img src="images/filter-apply.gif" alt="نمايش با فيلتر" width="20" height="20" border="0"></a>
			<a href="javascript:clearfilter()"><img src="images/filter-remove.gif" alt="نمايش کامل" width="20" height="20" border="0"></a>
			<a href="javascript:popUpFilter('Filter', 700, 500);"><img src="images/filter-form.gif" alt="فيلتر پيشرفته" width="20" height="20" border="0"></a>
            <logic:equal name="entity_access" property="printAccess" value="true">
			    <a href="javascript:report()"><img src="images/list-excel.gif" alt="صفحه گسترده" width="20" height="20" border="0"></a>&nbsp;
            </logic:equal>
		</td>
		<td class="text8" valign="middle" align="right" width="100">
			&nbsp;
			<logic:equal name="cur_records" property="isFilter" value="true" >
				[نمايش با فيلتر]
			</logic:equal>
			<logic:equal name="cur_records" property="isFilter" value="false" >
				[نمايش کامل]
			</logic:equal>
		</td>
		<td class="text8" valign="middle" align="right" width="*">
		[کل يافته ها:<bean:write property="totalRecords" name="cur_records"/>]
		</td>

	</tr>
</table>





