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
		<a href="/emdad/s/moshtarak.run?action_type=specific,moshtarak"><span class="paayeLink">مشترکين</span></a><br>
		<a href="/emdad/s/moshtarak.run?action_type=specific,gheirMoshtarak"><span class="paayeLink">غير مشترکين</span></a><br>
		<a href="/emdad/c/moshtarak.run"><span class="paayeLink">ايجاد مشترک</span></a><br>
		<a href="/emdad/s/moshtarak.run?action_type=specific,engheza"><span class="paayeLink">پي گيري اشتراک</span></a><br>
		<a href="/emdad/l/tamdidEshterak.run"><span class="paayeLink">تمديد اشتراک</span></a><br>
		<span class="paayeLink">صدور کارت اشتراک</a><br>
		<span class="paayeLink">صدور کارت طلايي</a><br>
		<a href="/emdad/l/darkhastEshterak.run"><span class="paayeLink">درخواست هاي اشتراک</span></a><br>
		<a href="/emdad/l/darkhastTagheer.run"><span class="paayeLink">درخواستهاي تغيير</span></a>
<%	
	} else if (role.equals("superuser")) {
%>
		<a href="/emdad/s/moshtarak.run?action_type=specific,moshtarak"><span class="paayeLink">مشترکين</span></a><br>
		<a href="/emdad/s/moshtarak.run?action_type=specific,gheirMoshtarak"><span class="paayeLink">غير مشترکين</span></a><br>
		<a href="/emdad/c/moshtarak.run"><span class="paayeLink">ايجاد مشترک</span></a><br>
		<a href="/emdad/s/moshtarak.run?action_type=specific,engheza"><span class="paayeLink">پي گيري اشتراک</span></a><br>
		<a href="/emdad/l/tamdidEshterak.run"><span class="paayeLink">تمديد اشتراک</span></a><br>
		<span class="paayeLink">صدور کارت اشتراک</a><br>
		<span class="paayeLink">صدور کارت طلايي</a><br>
		<a href="/emdad/l/darkhastEshterak.run"><span class="paayeLink">درخواست هاي اشتراک</span></a><br>
		<a href="/emdad/l/darkhastTagheer.run"><span class="paayeLink">درخواستهاي تغيير</span></a>
<%
    } else if (role.equals("doadmin")) {
%>
		<a href="/emdad/s/moshtarak.run?action_type=specific,moshtarak"><span class="paayeLink">مشترکين</span></a><br>
		<a href="/emdad/s/moshtarak.run?action_type=specific,gheirMoshtarak"><span class="paayeLink">غير مشترکين</span></a><br>
		<a href="/emdad/c/moshtarak.run"><span class="paayeLink">ايجاد مشترک</span></a><br>
		<a href="/emdad/s/moshtarak.run?action_type=specific,engheza"><span class="paayeLink">پي گيري اشتراک</span></a><br>
		<a href="/emdad/l/tamdidEshterak.run"><span class="paayeLink">تمديد اشتراک</span></a><br>
		<span class="paayeLink">صدور کارت اشتراک</a><br>
		<span class="paayeLink">صدور کارت طلايي</a><br>
		<a href="/emdad/l/darkhastEshterak.run"><span class="paayeLink">درخواست هاي اشتراک</span></a><br>
		<a href="/emdad/l/darkhastTagheer.run"><span class="paayeLink">درخواستهاي تغيير</span></a>
<%
	} else if (role.equals("eshterak")) {
%>
		<a href="/emdad/s/moshtarak.run?action_type=specific,moshtarak"><span class="paayeLink">مشترکين</span></a><br>
		<a href="/emdad/s/moshtarak.run?action_type=specific,gheirMoshtarak"><span class="paayeLink">غير مشترکين</span></a><br>
		<a href="/emdad/c/moshtarak.run"><span class="paayeLink">ايجاد مشترک</span></a><br>
		<a href="/emdad/s/moshtarak.run?action_type=specific,engheza"><span class="paayeLink">پي گيري اشتراک</span></a><br>
		<a href="/emdad/l/tamdidEshterak.run"><span class="paayeLink">تمديد اشتراک</span></a><br>
		<span class="paayeLink">صدور کارت اشتراک</a><br>
		<span class="paayeLink">صدور کارت طلايي</a><br>
		<a href="/emdad/l/darkhastEshterak.run"><span class="paayeLink">درخواست هاي اشتراک</span></a><br>
		<a href="/emdad/l/darkhastTagheer.run"><span class="paayeLink">درخواستهاي تغيير</span></a>
<%
	} else if (role.equals("others")) {
%>
		<a href="/emdad/s/moshtarak.run?action_type=specific,moshtarak"><span class="paayeLink">مشترکين</span></a><br>
		<a href="/emdad/c/moshtarak.run"><span class="paayeLink">ايجاد مشترک</span></a><br>
		<a href="/emdad/s/moshtarak.run?action_type=specific,engheza"><span class="paayeLink">پي گيري اشتراک</span></a><br>
		<a href="/emdad/l/tamdidEshterak.run"><span class="paayeLink">تمديد اشتراک</span></a><br>
		<span class="paayeLink">صدور کارت اشتراک</a><br>
		<span class="paayeLink">صدور کارت طلايي</a><br>
		<a href="/emdad/l/darkhastEshterak.run"><span class="paayeLink">درخواست هاي اشتراک</span></a><br>
		<a href="/emdad/l/darkhastTagheer.run"><span class="paayeLink">درخواستهاي تغيير</span></a>
<%	
	} else {
%>
		<a href="/emdad/c/darkhastEshterak.run"><span class="paayeLink">درخواست  اشتراک</span></a><br>
		<a href="/emdad/s/darkhastTagheer.run?action_type=specific,request"><span class="paayeLink">درخواست تغيير</span></a><br>
		<span class="paayeLink">پي گيري</span><br>
		<span class="paayeLink">شکايات</span><br>
<%
	}
}
%>