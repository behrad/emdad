<%@ page import="com.objectj.emdad.ejb.UserAccessEntity"%>﻿
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<HEAD>
<TITLE>سيستم عمليات - شرکت امداد خودرو ايران</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="css/emdad.css" type="text/css" rel="STYLESHEET">
<script src="css/list.js"> </script>
<script src="css/edit.js"> </script>

</HEAD>


<BODY leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" dir="rtl" background="images/strips-w.jpg" />

<input type="hidden" name="helpUrl" value="/emdad/com/objectj/resources/jsp/help/vorod.help.html"/>

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

	<table width="100%" height="100" border="0" cellpadding="0" cellspacing="0" dir="rtl">
	  <tr valign="top">
		<td width="130" background="strips-rt.jpg">&nbsp;</td>
		  <td valign="middle" width="*" align="center" class="text" bgcolor="#FFFFFF">
		  	<table width="100%" cellpadding="3" bgcolor="#666699">
				
              <tr>
                <td width="100%" class="textTitle"><div align="center">به سيستم عمليات شرکت امداد خودرو ايران خوش آمديد!</div></td>
              </tr>
			</table>
        </td>
		<td width="110" background="strips-lft.jpg">&nbsp;</td>
	  </tr>
	</table>
	  <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
	    <tr valign="top">
		  <td width="130" background="strips-rt.jpg">&nbsp;</td>
          <td width="*" align="center" class="textB" bgcolor="#FFFFFF">
		
			<table width="*" border="0" cellspacing="0" cellpadding="10" dir="rtl">

              <tr>
                <td><img src="images/pgblue.jpg" width="235" height="143" border="0"></td>
                <td width="*">

						<table border=3 bordercolor="#666699" cellpadding=10 class="text" dir="rtl">
                    <tr>
                      <td>
							  لطفاً شناسه و گذرواژه خود را وارد کنيد 
							  
                        <form name="loginForm" method="post" action="j_security_check">
								
                          <table width="85%" border="0">
								  
                            <tr>
									
                              <td width="34%" align="right" class="text">شناسه:</td>
                              <td width="66%" align="right">
									  <input name="j_username" type="text" class="field" size="20"/>
									</td>
                            </tr>
								  
                            <tr>
									
                              <td width="34%" align="right" class="text">گذرواژه:</td>
                              <td width="66%" align="right">
									  <input name="j_password" type="password" class="field" size="20"/>
									</td>
                            </tr>
								  
                            <tr>
									
                              <td width="34%">&nbsp;</td>
                              <td width="66%" align="center">
										<br>
										<input name="Submit" type="submit" class="emdadButton" value="ورود"/>
						&nbsp;&nbsp;<a href="javascript:help();">راهنما</a>&nbsp;&nbsp;
									</td>
                            </tr>
								
                          </table>
                        </form></td>
                    </tr>
                  </table></td>
              </tr>
			</table>
            <br>
            <table width="100%" border="0" cellpadding="10" cellspacing="0" bgcolor="#CCCCFF" class="text">
              <tr>
                <td align="left">اگر گذرواژه خود را فراموش کرده ايد، <a href="/emdad">اينجا</a> را کليک کنيد.</td>
              </tr>
            </table>
            <p>&nbsp;</p></td>     
          <th width="110" background="strips-lft.jpg">&nbsp;</th>
        </tr>
	</table>



			</td>
			<td width="50" valign="top" background="images/strips-lft.jpg"><img src="images/strips-lft.jpg"></td>
		</tr>
	</table>

</td></tr></table>

<script>
	document.loginForm.j_username.focus();
</script>
</BODY>
