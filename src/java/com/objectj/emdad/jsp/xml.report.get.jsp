<%@ page contentType="text/html; charset=UTF-8" %>
<script>
var XMLDOM1 = new ActiveXObject("Microsoft.XMLDOM");
var error="false";
function DoXML1Complete() {
	if (XMLDOM1.readyState == 4) {
   		row=XMLDOM1.getElementsByTagName("report");
   		if(row == null) 
   		   error="true";
   		else if(row.item(0) == null) 
   		   error="true";
   		else if(row.item(0).getAttribute("id")==null)
   		   error="true";
   		else if(row.item(0).getAttribute("user")==null)
   		   error="true";
   		if(error == "true")   
   		  alert("ERROR....");
   		else{  
		  alert(row.item(0).getAttribute("id"));
  		  alert(row.item(0).getAttribute("user"));
		  xml1_datosXML_complete = true;
		}
   }
}

function loadXML(reportId) {
		XMLDOM1.async=true;
		XMLDOM1.resolveExternals = false;
		XMLDOM1.onreadystatechange = DoXML1Complete;
//		var url="/emdad/com/objectj/emdad/jsp/xml.report.generator2.jsp?reportId="+reportId;
		var url="/emdad/com/objectj/emdad/jsp/xml.report.generator.jsp?reportId="+reportId;
		XMLDOM1.load(url);
}
loadXML(<%=request.getParameter("reportId")%>);

</script>
