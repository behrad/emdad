<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" %>
<html>
<head>
<title>صفحه اصلي</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"></script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"></script>
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">
<style type="text/css">
<!--
body {
	font-family: Tahoma, "Courier New", Arial;
}
-->
</style>
</head>
<body dir="rtl">
	<div class="generalText" align="center"><h3>بخش دريافت اطلاعات مربوط به ليست قطعه و کدهاي ايراد و اجرت کامپيوترهاي Ipaq 2210</h3></div>
	<table align="center" width="70%" border="0" cellspacing="0" cellpadding="10">
	  <tr>
		<td class="generalText">مرحله اول (1): </td>
		<td class="generalText">
			<ol><li>ابتدا روي دکمه دريافت کليک کنيد</li>
				<li>منتظر بمانيد تا فايلهاي موردنظر شما روي سرور آماده شده و پيغام دريافت آنها ضاهر شود.</li>
				<li>فايل .zip مربوطه را دانلود کنيد.</li>
			</ol>
		</td>
	  </tr>
	</table>
	<form name="ipaqdl" method="post" action="/emdad/com/objectj/emdad/jsp/ipaq/generateList.jsp">
	<div align="center"><input name="submit" type="submit" value="دريافت" class="emdadButton"/></div>
	</form>
</body>
</html>