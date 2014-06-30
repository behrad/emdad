<%@ page import="com.objectj.emdad.ejb.UserAccessEntity,
                  com.objectj.emdad.ejb.UserSession,
                  com.objectj.jsa.web.action.BaseAction"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<html:base />
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
		<a href="/emdad/l/khodrosaz.run"><span class="paayeLink">خودروسازان</span></a><br>
		<a href="/emdad/l/noeKhodro.run"><span class="paayeLink">انواع خوردرو</span></a><br>
		<a href="/emdad/l/rangeKhodro.run"><span class="paayeLink">رنگهاي خودرو</span></a><br>
		<a href="/emdad/l/ostan.run"><span class="paayeLink">استانها</span></a><br>
		<a href="/emdad/l/shahr.run"><span class="paayeLink">شهرها</span></a><br>
		<a href="/emdad/l/noeBazaryab.run"><span class="paayeLink">انواع بازارياب</span></a><br>
		<a href="/emdad/l/bazaryab.run"><span class="paayeLink">بازاريابها</span></a><br>
		<a href="/emdad/l/namayandegi.run"><span class="paayeLink">نمايندگي ها</span></a><br>
		<a href="/emdad/l/daftarOstani.run"><span class="paayeLink">دفاتر استاني</span></a><br>
<%	
	} else if (role.equals("superuser")) {
%>
		<a href="/emdad/l/khodrosaz.run"><span class="paayeLink">خودروسازان</span></a><br>
		<a href="/emdad/l/noeKhodro.run"><span class="paayeLink">انواع خوردرو</span></a><br>
		<a href="/emdad/l/rangeKhodro.run"><span class="paayeLink">رنگهاي خودرو</span></a><br>
		<a href="/emdad/l/ostan.run"><span class="paayeLink">استانها</span></a><br>
		<a href="/emdad/l/shahr.run"><span class="paayeLink">شهرها</span></a><br>
		<a href="/emdad/l/noeBazaryab.run"><span class="paayeLink">انواع بازارياب</span></a><br>
		<a href="/emdad/l/bazaryab.run"><span class="paayeLink">بازاريابها</span></a><br>
		<a href="/emdad/l/namayandegi.run"><span class="paayeLink">نمايندگي ها</span></a><br>
		<a href="/emdad/l/daftarOstani.run"><span class="paayeLink">دفاتر استاني</span></a><br>

		<a href="/emdad/l/noeEmdadgar.run"><span class="paayeLink">نوع امدادگر</span></a><br>
		<a href="/emdad/l/emdadgar.run"><span class="paayeLink">امدادگران</span></a><br>
		<a href="/emdad/l/irad.run"><span class="paayeLink">ايرادها</span></a><br>
		<a href="/emdad/l/ojrat.run"><span class="paayeLink">اجرت</span></a><br>
		<a href="/emdad/l/qate.run"><span class="paayeLink">قطعات</span></a><br>
<%
	} else if (role.equals("eshterak")) {
%>
		<a href="/emdad/l/khodrosaz.run"><span class="paayeLink">خودروسازان</span></a><br>
		<a href="/emdad/l/noeKhodro.run"><span class="paayeLink">انواع خوردرو</span></a><br>
		<a href="/emdad/l/rangeKhodro.run"><span class="paayeLink">رنگهاي خودرو</span></a><br>
		<a href="/emdad/l/ostan.run"><span class="paayeLink">استانها</span></a><br>
		<a href="/emdad/l/shahr.run"><span class="paayeLink">شهرها</span></a><br>
		<a href="/emdad/l/noeBazaryab.run"><span class="paayeLink">انواع بازارياب</span></a><br>
		<a href="/emdad/l/bazaryab.run"><span class="paayeLink">بازاريابها</span></a><br>
		<a href="/emdad/l/namayandegi.run"><span class="paayeLink">نمايندگي ها</span></a><br>
		<a href="/emdad/l/daftarOstani.run"><span class="paayeLink">دفاتر استاني</span></a><br>
<%	
	} else if (role.equals("doadmin")) {
%>
		<a href="/emdad/l/khodrosaz.run"><span class="paayeLink">خودروسازان</span></a><br>
		<a href="/emdad/l/noeKhodro.run"><span class="paayeLink">انواع خوردرو</span></a><br>
		<a href="/emdad/l/rangeKhodro.run"><span class="paayeLink">رنگهاي خودرو</span></a><br>
		<a href="/emdad/l/ostan.run"><span class="paayeLink">استانها</span></a><br>
		<a href="/emdad/l/shahr.run"><span class="paayeLink">شهرها</span></a><br>
		<a href="/emdad/l/noeBazaryab.run"><span class="paayeLink">انواع بازارياب</span></a><br>
		<a href="/emdad/l/bazaryab.run"><span class="paayeLink">بازاريابها</span></a><br>
		<a href="/emdad/l/namayandegi.run"><span class="paayeLink">نمايندگي ها</span></a><br>
		<a href="/emdad/l/daftarOstani.run"><span class="paayeLink">دفاتر استاني</span></a><br>

		<a href="/emdad/l/noeEmdadgar.run"><span class="paayeLink">نوع امدادگر</span></a><br>
		<a href="/emdad/l/emdadgar.run"><span class="paayeLink">امدادگران</span></a><br>
		<a href="/emdad/l/irad.run"><span class="paayeLink">ايرادها</span></a><br>
		<a href="/emdad/l/ojrat.run"><span class="paayeLink">اجرت</span></a><br>
		<a href="/emdad/l/qate.run"><span class="paayeLink">قطعات</span></a><br>
<%
	} else {
%>
	<span class="paayeLink">غير قابل دسترسي</span>
<%
	}
}
%>