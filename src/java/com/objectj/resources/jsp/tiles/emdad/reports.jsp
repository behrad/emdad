<%@ page import="com.objectj.emdad.ejb.UserAccessEntity,
                  com.objectj.emdad.ejb.UserSession,
                  com.objectj.jsa.web.action.BaseAction"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

<%
{
    String role = "";
    try {
        role = (String)request.getSession().getAttribute("USERROLE");
    } catch (Exception e) {
        role = "";
    }

	if (role.equals("admin")) {
%>
		<span class="paayeLink">فهرست مشترکين</span><br>
		<span class="paayeLink">معرفي مشترکين ويژه به بيمه</span><br>
		<span class="paayeLink">اشتراک در حال انقضاء</span><br>
		<span class="paayeLink">درخواستهاي اشتراک</span><br>
		<span class="paayeLink">درخواستهاي تغيير</span><br>
<%	
	} else if (role.equals("superuser")) {
%>
		<span class="paayeLink">فهرست مشترکين</span><br>
		<span class="paayeLink">معرفي مشترکين ويژه به بيمه</span><br>
		<span class="paayeLink">اشتراک در حال انقضاء</span><br>
		<span class="paayeLink">درخواستهاي اشتراک</span><br>
		<span class="paayeLink">درخواستهاي تغيير</span><br>
<%	
	} else if (role.equals("others")) {
%>
		<span class="paayeLink">فهرست مشترکين</span><br>
		<span class="paayeLink">معرفي مشترکين ويژه به بيمه</span><br>
		<span class="paayeLink">اشتراک در حال انقضاء</span><br>
		<span class="paayeLink">درخواستهاي اشتراک</span><br>
		<span class="paayeLink">درخواستهاي تغيير</span><br>
<%	
	} else if (role.equals("moshtari")) {
%>
	<span class="paayeLink">غير قابل دسترسي</span>
<%	
	} else if (role.equals("eshterak")) {
%>
		<span class="paayeLink">فهرست مشترکين</span><br>
		<span class="paayeLink">معرفي مشترکين ويژه به بيمه</span><br>
		<span class="paayeLink">اشتراک در حال انقضاء</span><br>
		<span class="paayeLink">درخواستهاي اشتراک</span><br>
		<span class="paayeLink">درخواستهاي تغيير</span><br>
<%	
	} else {
%>
		<span class="paayeLink">فهرست مشترکين</span><br>
		<span class="paayeLink">معرفي مشترکين ويژه به بيمه</span><br>
		<span class="paayeLink">اشتراک در حال انقضاء</span><br>
		<span class="paayeLink">درخواستهاي اشتراک</span><br>
		<span class="paayeLink">درخواستهاي تغيير</span><br>
<%	
	}
}
%>