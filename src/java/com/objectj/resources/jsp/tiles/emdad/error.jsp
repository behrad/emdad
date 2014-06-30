<%@ page import="com.objectj.emdad.ejb.UserAccessEntity"%>﻿
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<HEAD>
<TITLE>کاربر شناخته شده نيست</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="css/emdad.css" type="text/css" rel="STYLESHEET">
<script src="css/list.js"> </script>
<script src="css/edit.js"> </script>

</HEAD>


<BODY leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" dir="rtl" background="images/strips-w.jpg" />


<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
<tr><td valign="top">

	<table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
	  <tr>
		<td width="100%" valign="top">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
			  <tr dir="rtl" valign="top">
				<td width="120"><img src="images/toprt.jpg" width="120" height="90" border="0" usemap="#emdadkhodro"></td>
				<td width="227"><img src="images/title.jpg" width="227" height="90"></td>
				<td width="*" height="79" valign="bottom" background="images/mid.jpg">&nbsp;
				</td>
			  </tr>
			</table>
		</td>
		<td width="50" dir="rtl"><img src="images/toplft1.jpg"></td>
		</tr>
	</table>


	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
		<tr>
			<td width="120" valign="top" background="images/strips-rt.jpg">&nbsp;</td>
			<td width="*" height="*" align="center" valign="top" bgcolor="#FFFFFF">
				<span class="error">شناسة کاربر و گذرواژه براي سيستم عمليات شناخته شده نيست.</span>
				<p>
				<a href="/emdad/usr/home.run">بازگشت</a>
			
			</td>
			<td width="50" valign="top" background="images/strips-lft.jpg"><img src="images/strips-lft.jpg"></td>
		</tr>
	</table>

</td></tr></table>

<map name="emdadkhodro" id="emdadkhodro">
  <area shape="rect" coords="12,59,101,72" href="http://emdad-khodro.com">
</map>
</BODY>
