<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*, java.io.*, java.util.zip.*, com.objectj.emdad.ejb.*" %>
<%
	String parent = "com" + File.separator + "objectj" + File.separator + "emdad" + File.separator + "jsp" + File.separator + "ipaq" + File.separator;
	String jsPath = parent + "grid.jsp";
	String homeHtml = parent + "index_.jsp";
	String qateTop = parent + "qate.top.jsp";
	String ojratTop = parent + "ojrat.top.jsp";
	String iradTop = parent + "irad.top.jsp";
	String mainTail = parent + "main.tail.jsp";
	
	String js = File.separator + "grid.js";
	String home = File.separator + "index.html";
	String qateHtml = File.separator + "qate.html";
	String ojratHtml = File.separator + "ojrat.html";
	String iradHtml = File.separator + "irad.html";
	
	String qateCall = "entities.push( new Entity( '";
	String ojratCall = "entities.push( new Entity( '";
	String iradCall = "entities.push( new Entity( '";
	String comma = "', '";
	String endCall = "' ) );";
	BufferedWriter outt;
	BufferedReader in;
	File dir = null;
	String pdaDir = "/home/emdad/uploads/deploy2/pda.war/";
	String filePath = File.separator + "emdad.entity.list.zip";
	String link = "";
	try {
		Connection c = com.objectj.emdad.ejb.util.Util.getConnection();
		String userId = ((UserSession)session.getAttribute( "user_session" )).getName();
		dir = new File( pdaDir + userId );
		dir.mkdir();
		js = dir + js;
		home = dir + home;
		ojratHtml = dir + ojratHtml;
		iradHtml = dir + iradHtml;
		qateHtml = dir + qateHtml;
		
		com.objectj.emdad.web.util.Util.copyUtf8File( request.getRealPath(jsPath), js, false );
		com.objectj.emdad.web.util.Util.copyUtf8File( request.getRealPath(homeHtml), home, false );
		com.objectj.emdad.web.util.Util.copyUtf8File( request.getRealPath(qateTop), qateHtml, false );
		com.objectj.emdad.web.util.Util.copyUtf8File( request.getRealPath(ojratTop), ojratHtml, false );
		com.objectj.emdad.web.util.Util.copyUtf8File( request.getRealPath(iradTop), iradHtml, false );
		
		outt = new BufferedWriter( new OutputStreamWriter( new FileOutputStream( qateHtml, true ), "UTF-8" ) );
		ResultSet qates = c.createStatement().executeQuery("SELECT shomareFanni, name, gheimat FROM QATE ORDER BY shomareFanni");
		while( qates.next() )
			outt.write( qateCall + qates.getString("shomareFanni") + comma + qates.getString("name") + "', " + qates.getString("gheimat") + " ) );" );
		outt.flush();
		outt.close();
		qates.close();
		com.objectj.emdad.web.util.Util.copyUtf8File( request.getRealPath(mainTail), qateHtml, true );
		
		// Writing ojrat html
		outt = new BufferedWriter( new OutputStreamWriter( new FileOutputStream( ojratHtml, true ), "UTF-8" ) );
		ResultSet ojrats = c.createStatement().executeQuery("SELECT ojratId, onvan FROM ojrat ORDER BY ojratId");
		while( ojrats.next() )
			outt.write( ojratCall + ojrats.getString("ojratId") + comma + ojrats.getString("onvan") + comma + endCall );
		outt.flush();
		outt.close();
		ojrats.close();
		com.objectj.emdad.web.util.Util.copyUtf8File( request.getRealPath(mainTail), ojratHtml, true );
		
		// Writing irad html
		outt = new BufferedWriter( new OutputStreamWriter( new FileOutputStream( iradHtml, true ), "UTF-8" ) );
		ResultSet irads = c.createStatement().executeQuery("SELECT iradId, onvan FROM irad ORDER BY iradId");
		while( irads.next() )
			outt.write( iradCall + irads.getString("iradId") + comma + irads.getString("onvan") + comma + endCall );
		outt.flush();
		irads.close();
		outt.close();
		com.objectj.emdad.web.util.Util.copyUtf8File( request.getRealPath(mainTail), iradHtml, true );
		
		// Now try to zip the file and put in user Directory!!!
		String zipDir = dir + filePath;		
		ZipEntry entry;
		int len;
		byte[] buf = new byte[1024];
		ZipOutputStream zip = new ZipOutputStream( new FileOutputStream( zipDir ) );
		
		FileInputStream fin = new FileInputStream( js );
		zip.putNextEntry( new ZipEntry( "grid.js" ) );
		while ((len = fin.read(buf)) > 0)
			zip.write(buf, 0, len);
		zip.closeEntry();
		fin.close();
		fin = new FileInputStream( home );
		zip.putNextEntry( new ZipEntry( "index.html" ) );
		while ((len = fin.read(buf)) > 0)
			zip.write(buf, 0, len);
		zip.closeEntry();
		fin.close();
		fin = new FileInputStream( qateHtml );
		zip.putNextEntry( new ZipEntry( "qate.html" ) );
		while ((len = fin.read(buf)) > 0)
			zip.write(buf, 0, len);
		zip.closeEntry();
		fin.close();
		fin = new FileInputStream( ojratHtml );
		zip.putNextEntry( new ZipEntry( "ojrat.html" ) );
		while ((len = fin.read(buf)) > 0)
			zip.write(buf, 0, len);
		zip.closeEntry();
		fin.close();
		fin = new FileInputStream( iradHtml );
		zip.putNextEntry( new ZipEntry( "irad.html" ) );
		while ((len = fin.read(buf)) > 0)
			zip.write(buf, 0, len);
		zip.closeEntry();
		fin.close();
		zip.flush();
		zip.close();
		link = "/pda/" + userId + "/emdad.entity.list.zip";
	
	} catch( Exception e ) {
		e.printStackTrace();
		return;
	}
	
%>
<html>
<head>
<title>صفحه دريافت</title>
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
		<td class="generalText">مرحله دوم (2):</td>
		<td class="generalText">
			<ol><li>روي لينک فايل zip کليک کرده و منتظر باشيد تا از روي سرور به دستگاه شما منتقل شود.</li>
				<li>فايل zip را unzip کرده و روي کامپيوتر جيبي خود کپي کنيد.</li>
				<li>براي استفاده صفحه index.html را مشاهده کنيد.</li>
			</ol>
		</td>
	  </tr>
	</table>
	<div align="center"><a href=<%=link%>>فايل zip ليستهاي قطعه و کدهاي اجرت و ايراد</a></div>
</body>
</html>