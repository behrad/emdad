<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>backRefresh</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<script>
var XMLDOM1 = new ActiveXObject("Microsoft.XMLDOM");
var XMLDOM2 = new ActiveXObject("Microsoft.XMLDOM");
function DoXML1Complete() {
	if (XMLDOM1.readyState == 4) {
   		row=XMLDOM1.getElementsByTagName("row");
		if(row.item(0).getAttribute("Title")!=null){
			row = XMLDOM1.getElementsByTagName("field");
			attr = row.item(0).getAttribute("Title");
			//document.rokhdadForm.shahrId.value=attr;
			attr = row.item(1).getAttribute("Title");
			document.rokhdadForm.tell.value=attr;
			attr = row.item(2).getAttribute("Title");
			//document.rokhdadForm.khadamateVijeh.value=attr;
		}
		xml1_datosXML_complete = true;
   }
}
function DoXML2Complete() {
	if (XMLDOM2.readyState == 4) {
		row = XMLDOM2.getElementsByTagName("row");
		if(row.item(0).getAttribute("Title")!=null)
			document.all.errorSpan.innerText=row.item(0).getAttribute("Title");			
   		else {
			row = XMLDOM2.getElementsByTagName("emdad");
			if(row.length>0)
				document.all.emdadSpan.innerText=row.item(0).getAttribute("Title")+" "+row.item(0).getAttribute("emdadId");			
			row = XMLDOM2.getElementsByTagName("rokhdad");
			if(row.length>0)
				document.all.rokhdadSpan.innerText=row.item(0).getAttribute("Title")+" "+row.item(0).getAttribute("rokhdadId");			
			row = XMLDOM2.getElementsByTagName("vazeat");
			if(row.length>0)
				document.all.vazeatSpan.innerText=row.item(0).getAttribute("Title");
		}
		xml2_datosXML_complete = true;
   }
}
function loadXML() {
	if(window.event.keyCode==13){
	//document.rokhdadForm.shahrId.value="";
	document.rokhdadForm.tell.value="";
	//document.rokhdadForm.khadamateVijeh.value="";
		document.all.errorSpan.innerText="";			
		document.all.emdadSpan.innerText="";			
		document.all.rokhdadSpan.innerText="";			
		document.all.vazeatSpan.innerText="";
		moshtarakDetails();
		XMLDOM1.async=true;
		XMLDOM2.async=true;
		XMLDOM1.resolveExternals = false;
		XMLDOM2.resolveExternals = false;
		XMLDOM1.onreadystatechange = DoXML1Complete;
		XMLDOM2.onreadystatechange = DoXML2Complete;
		XMLDOM1.load("http://localhost:8080/emdad/com/objectj/emdad/jsp/xml.generator.jsp?fields=shahrId,tel,noeService,address&table=moshtarak&condition=eshterakId='"+document.rokhdadForm.id.value+"'");
		XMLDOM2.load("http://localhost:8080/emdad/com/objectj/emdad/jsp/xml.generator2.jsp?eshterakId="+document.rokhdadForm.id.value);
	}
}
function moshtarakDetails(){}
</script>
<body>
<html:form name="rokhdadForm" >
id:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="10" name="id" onKeyDown="javascript:loadXML();" ><br>
name:&nbsp;&nbsp; <input type="text" size="50" name="tell"><br><br>
address:<textarea rows="5" cols="100" name="address"></textarea><br><br>
irad:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="100" name="irad"><br>
makan:&nbsp;<input type="text" size="100" name="makan"><br>
<span id="errorSpan" class="validation"></span><span id="rokhdadSpan"></span> &nbsp;&nbsp;&nbsp;&nbsp;<span id="emdadSpan"></span> &nbsp;&nbsp;&nbsp;&nbsp;<span id="vazeatSpan"></span>
</html:form>
<!--<center><input type="submit">-->
</body>
</html>
