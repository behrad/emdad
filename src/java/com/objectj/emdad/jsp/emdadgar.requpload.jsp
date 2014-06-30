<%@ page contentType="text/html; charset=UTF-8" import="com.objectj.emdad.web.util.Util, java.sql.*, java.util.*,
                                                        java.io.IOException,
                                                        com.objectj.emdad.ejb.UserAccessEntity" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>
<HTML>
<head>
<html:base/>
<TITLE>معرفي فايل XLS</TITLE>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>
<script language="JavaScript">
	function chkFileName() {
		var path = document.emdadReqUpload.file.value;		
		if ( path == "" ) {
			alert( "نام فايل را وارد کنيد" );
			return false;
		}
		return true;
	}
</script>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">
</head>
<BODY dir="rtl">

<h2 align="center">دریافت فایل اکسل امدادگـر</h2>

<table border="0" align="center" class="generalText">
  <tr> 
    <td><font color="#FF0000">توجه:</font></td>
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td>&nbsp;</td>
    <td>انتقال فايل در دو مرحله صورت ميگيرد:</td>
  </tr>
  <tr> 
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td>&nbsp;&nbsp;<font color="#000033">مرحله 1-</font></td>
    <td> منتقل کردن فايل XLS به سرور </td>
  </tr>
  <tr> 
    <td>&nbsp;<font color="#000066">&nbsp;مرحله 2-</font></td>
    <td> انتقال فهرست به پايگاه داده ها</td>
  </tr>
  <tr> 
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td><font color="#003366">مرحله1:</font></td>
    <td>منتقل کردن فايل XLS به سرور</td>
  </tr>
  <tr> 
    <td>&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="hidden" name="helpUrl" value="/emdad/com/objectj/resources/jsp/help/import.xls.html"/>
		<a href="javascript:help();" target="_blank">راهنما</a></td>
  </tr>
  <tr> 
</table>

<form name="emdadReqUpload"  method="post" action="/emdad/com/objectj/emdad/jsp/emdadgar.doupload.jsp" enctype="multipart/form-data" onSubmit="return chkFileName();">

	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<!---------------------------------------->
					<tr class="generalText">
						
						
            <td colspan="3"> 
              <% String message = (String)request.getAttribute( "message" ); %>
              <div align="center"><strong><font color="#FF0000"> 
                <%= ( message == null ) ? "" : message %>
                </font></strong> </div></td>
					</tr>
					<tr class="editRow0">
						<td class="editLabel"> لطفا نام فايل XLS را وارد نماييد:</td>
						<td class="editStar">*</td>
						<td><INPUT dir="ltr" TYPE="FILE" NAME="file" size="60" class="field"/>						
						</td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
					  <td colspan=4>&nbsp;</td>
					</tr>
					<!----------------------------------------->


		<td height="70" colspan="3" align="center"> <input class="emdadButton" type="submit" value=" انتقال فايل به سرور  "/ >&nbsp;&nbsp;
		</td></tr>

				</table>
			</td>
		</tr>

		<!----------------------------------------->

  </table>

</form>


</body>

</html>