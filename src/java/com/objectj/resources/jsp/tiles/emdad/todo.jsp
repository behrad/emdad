<%@ page import="com.objectj.emdad.ejb.UserAccessEntity,com.objectj.emdad.web.util.ToDo,
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
	<span class="paayeLink">غير قابل دسترسي</span>
<%	
	} else if (role.equals("superuser")) {
%>
	<span class="paayeLink">غير قابل دسترسي</span>
<%	
	} else if (role.equals("eshterak")) {
		int cntDarkhastEshterak = ToDo.countEntity("darkhastEshterak", "");
		int cntDarkhastTagheer = ToDo.countEntity("darkhastTagheer", "");
		int cntEngheza = 4;
		if (cntDarkhastEshterak > 0) {
%>
			<a href="/emdad/l/darkhastEshterak.run"><span class="paayeLink">درخواست اشتراک (<%= cntDarkhastEshterak %>)</span></a><br>
<%		} 
		if (cntEngheza > 0) { 
%>
			<a href="/emdad/s/moshtarak.run?action_type=specific,engheza"><span class="paayeLink">پي گيري اشتراک (<%= cntEngheza %>)</span></a><br>
<%		} 
		if (cntDarkhastTagheer > 0) { 
%>
			<a href="/emdad/l/darkhastTagheer.run"><span class="paayeLink">تغيير اشتراک (<%= cntDarkhastTagheer %>)</span></a>
<%	
		}
	} else if (role.equals("moshtari") || role.equals("")) {
%>
	<span class="paayeLink">غير قابل دسترسي</span>
<%	
	} else if (role.equals("others")) {
%>
	<span class="paayeLink">غير قابل دسترسي</span>
<%	
	} else {
%>
	<span class="paayeLink">غير قابل دسترسي</span>
<%	
	}
}
%>