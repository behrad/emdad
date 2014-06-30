<%@ page import="java.io.File" contentType="text/html; charset=UTF-8" %>


<link href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" flush="true" type="text/css" rel="STYLESHEET"/>

<head>
<base target="contents">
</head>
<body>
<font face="Tahoma" color="#0000FF"> &#1601;&#1607;&#1585;&#1587;&#1578; &#1606;&#1578;&#1575;&#1740;&#1580; &#1575;&#1606;&#1578;&#1602;&#1575;&#1604; &#1605;&#1588;&#1578;&#1585;&#1705;&#1740;&#1606; &#1711;&#1585;&#1608;&#1607;&#1740;</font>

<br><br>
<table width="100%">
<%  String[] files=new File("/home/emdad/uploads/deploy2/logs.war/").list();
    for(int i=files.length-1;i>=0;i--)
        if(files[i].length()>16 && files[i].substring(0,16).equals("importMoshtarak_")){
            %><tr class="listRow<%=i%2%>">
            	<td class = "listRow1Col">
					<a href="/logs/importMoshtarak_<%=files[i].substring(16,files[i].indexOf(".html"))%>.html"><%=files[i].substring(16,files[i].indexOf(".html"))%></a>
        		</td>
        	</tr>
        <%}%>
        

</table> 
</body>
</html>