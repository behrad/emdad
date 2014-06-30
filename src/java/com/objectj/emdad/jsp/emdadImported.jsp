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
<TITLE>Emdad Import Finish</TITLE>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">
</head>
<BODY dir="rtl">
<div style="font-family:tahoma;font-size:13px;" align="center"><strong><font color="#FF0000">اطلاعات فايل مورد نظر وارد سيستم شد
  </font></strong></div>
<br>
<div align="center">
	<input type="button" name="back" value="  دريافت فايل XLS  " class="emdadButton" onClick="document.location='<%=(String)request.getAttribute( "uploadPage" )%>';">
	<input name="button" type="button" value=" بستن صفحه " onClick="window.close();" class="emdadButton" />
</div>  
</BODY>
</HTML>