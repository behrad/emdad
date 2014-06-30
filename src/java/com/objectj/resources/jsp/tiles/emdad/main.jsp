<%@ page import="com.objectj.emdad.ejb.UserAccessEntity,
                 com.objectj.emdad.ejb.UserSession,
                 com.objectj.jsa.web.action.BaseAction"%>﻿<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %><HEAD>

<html:base/>
<HEAD>
<TITLE><tiles:getAsString name="title"/></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="css/emdad.css" type="text/css" rel="STYLESHEET">
<script src="css/list.js"> </script>
<script src="css/edit.js"> </script>

</HEAD>

<%
    com.objectj.emdad.ejb.util.Util.add("application.connection.url", System.getProperty("application.connection.url")); //com.objectj.emdad.web.util.Util.getProperty("application.connection.url"));
    String fullName = "";
	String userRole = "";
    String userRoleFarsi = "";
	String doName = "";
	try {
        String username = request.getUserPrincipal().getName();
        userRole = UserAccessEntity.getUserRole(username);
        userRoleFarsi = UserAccessEntity.getUserRoleFarsi(username);
        fullName = UserAccessEntity.getUserFullName(username);
		doName = UserAccessEntity.getDaftarOstaniName(username);
    } catch (Exception e) {
        fullName = "";
		userRole = "";
		doName = "";
    }
%>
<BODY leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" dir="rtl" background="images/strips-w.jpg" />
<input type="hidden" name="helpUrl" value="/emdad/com/objectj/resources/jsp/help/vorod.help.html"/>

<%--begin{the whole thing}--%>
<table width="1000" height="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
<tr><td valign="top">
<%--  begin{top banner}  --%>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
	  <tr>
		<td width="100%" valign="top">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
			  <tr dir="rtl" valign="top">
				<td width="120"><img src="images/toprt.jpg" width="120" height="90" border="0" usemap="#emdadkhodro"></td>
				<td width="227"><img src="images/title.jpg" width="227" height="90"></td>
				<td width="*" height="79" valign="bottom" background="images/mid.jpg">
					<table width="100%" height="80" border="0" cellpadding="10">
					<tr valign="middle">
						<td>
<%
    if (!userRole.equals("")) {
%>
                            <div align="right"><span class="textBlue">کاربر:
							<%=(fullName.equals("") ? "عمومي" : fullName)%> &nbsp;&nbsp;&nbsp;&nbsp; نقش کاربر:
                            <%=(userRole.equals("") ? "" : userRoleFarsi)%>
							</span><br>
							<span class="textBlue">دفتر استاني:
							<%=(doName.equals("") ? "نامشخص" : doName)%>
							</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="javascript:help();">راهنما</a>&nbsp;<strong>|</strong>&nbsp;
							<a href="/emdad/usr/home.run">صفحه اصلي</a>&nbsp;<strong>|</strong>&nbsp;
							<a href="/emdad/s/shakhs.run?action_type=specific,editPass">تغيير گذرواژه</a>&nbsp;<strong>|</strong>&nbsp;
							<a href="/emdad/com/objectj/emdad/jsp/logout.jsp">خروج</a>
						    </div>
<%
    }
%>
                        </td>
					  </tr>
					</table>
				</td>
			  </tr>
			</table>
		</td>
		<td width="50" dir="rtl"><img src="images/toplft1.jpg"></td>
		</tr>
	</table>
<%--    end{top banner}--%>
<%--    begin{page body}--%>
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
		<tr>
<%--            begin{right menu}--%>
			<td width="120" valign="top" background="images/strips-rt.jpg">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">

                <jsp:include page="menu.jsp" />

				</table>
			</td>
<%--            end{right menu}--%>
<%--            begin{main content}--%>
			<td width="*" height="*" align="center" valign="top" bgcolor="#FFFFFF">
				<span class="tilesHeader"><tiles:getAsString name="title"/></span>
				<p><tiles:insert attribute="validate"/></p>
				<!-- Page body -->
				<table border="0" cellpadding="10" cellspacing="0"><tr><td>
					<tiles:insert attribute="body"/>
				</td></tr></table>
			</td>
<%--            end{main content}--%>
<%--            begin{left margin}--%>
			<td width="50" valign="top" background="images/strips.jpg"><img src="images/strips.jpg"></td>
<%--            end{left margin}--%>
		</tr>
	</table>
<%--    end{page body}--%>
</td></tr></table>
<%--end{the whole thing}--%>
</BODY>
