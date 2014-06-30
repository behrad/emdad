<html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Naghshe</title>
</head>

<script>
var width=0;
function zoom(z){
	if(document.mapFrame.mapForm.getElementsByTagName("img").length!=0)
		width=document.mapFrame.mapForm.getElementsByTagName("img").item(0).width;
	doc=document.mapFrame.mapForm;
	cellWidth=doc.cellWidth.value;
	zoomRatio=document.all.zoomBox.value;
	zoomRatio=parseInt(zoomRatio.substring(0,zoomRatio.length-1));
	if(z==0 ||(z==1 && zoomRatio<150)  || (z==-1 && zoomRatio>50)){
		width=(z==0)? cellWidth :parseInt(width+z*(cellWidth/4));
		zoomRatio=(z==0)? 100 : parseInt(zoomRatio+z*25);
		document.all.zoomBox.value=zoomRatio+"%"
	//	window.status=zoomRatio;
		images=doc.getElementsByTagName("img");
		for(i=0;i<images.length;i++)
			images(i).width=width;
	}
}


function addUp(){
	doc=document.mapFrame;
	doc.mapForm.topBot.value =0;
    doc.mapForm.rows.value=0;
    doc.mapForm.cols.value=doc.mapTable.rows(0).getElementsByTagName("td").length;
    param='topBot=0&mapLevel='+doc.mapForm.realMapLevel.value+'&cols='+doc.mapForm.cols.value+'&tool='+doc.mapForm.tooleShoro.value+'&arz='+(parseInt(doc.mapForm.arzeShoro.value) + parseInt(doc.mapForm.cellArz.value));
	//alert(param);
	loadXML("/emdad/com/objectj/emdad/jsp/xml.map.generator.jsp?"+param,"Up");
}
function addDown(){
	doc=document.mapFrame;
	doc.mapForm.topBot.value =0;
    doc.mapForm.rows.value=0;
    doc.mapForm.cols.value=doc.mapTable.rows(0).getElementsByTagName("td").length;
    param='topBot=0&mapLevel='+doc.mapForm.realMapLevel.value+'&cols='+doc.mapForm.cols.value+'&tool='+doc.mapForm.tooleShoro.value+'&arz='+(parseInt(doc.mapForm.arzeShoro.value) - parseInt(doc.mapForm.cellArz.value)*doc.mapTable.rows.length);
	//alert(param);
	loadXML("/emdad/com/objectj/emdad/jsp/xml.map.generator.jsp?"+param,"Down");
}
function addLeft(){
	doc=document.mapFrame;
	//alert(doc.mapForm.cellTool.value);
    doc.mapForm.topBot.value =0;
    doc.mapForm.cols.value=0;
    doc.mapForm.rows.value=doc.mapTable.rows.length;
    param='topBot=0&mapLevel='+doc.mapForm.realMapLevel.value+'&rows='+doc.mapForm.rows.value+'&tool='+(parseInt(doc.mapForm.tooleShoro.value)-parseInt(doc.mapForm.cellTool.value))+'&arz='+doc.mapForm.arzeShoro.value;
	//alert(param);
   	loadXML("/emdad/com/objectj/emdad/jsp/xml.map.generator.jsp?"+param,"Left");
}
function addRight(){
	doc=document.mapFrame;
    doc.mapForm.topBot.value =0;
    doc.mapForm.cols.value=0;
    doc.mapForm.rows.value=doc.mapTable.rows.length;
    param='topBot=0&mapLevel='+doc.mapForm.realMapLevel.value+'&rows='+doc.mapForm.rows.value+'&tool='+(parseInt(doc.mapForm.tooleShoro.value)+parseInt(doc.mapForm.cellTool.value)*doc.mapTable.rows(0).cells.length)+'&arz='+doc.mapForm.arzeShoro.value;
	//alert(param);
   	loadXML("/emdad/com/objectj/emdad/jsp/xml.map.generator.jsp?"+param,"Right");
}

var XMLDOM = new ActiveXObject("Microsoft.XMLDOM");
function loadXML(url,direct){
width=document.mapFrame.mapForm.getElementsByTagName("img").item(0).width;
doc=document.mapFrame.document;
	XMLDOM.async=true;
	XMLDOM.resolveExternals = false;
	if(direct=="Up")
		XMLDOM.onreadystatechange = DoXMLCompleteUp;
	if(direct=="Down")
		XMLDOM.onreadystatechange = DoXMLCompleteDown;
	if(direct=="Left")
		XMLDOM.onreadystatechange = DoXMLCompleteLeft;
	if(direct=="Right")
		XMLDOM.onreadystatechange = DoXMLCompleteRight;
	XMLDOM.load(url);
}

function DoXMLCompleteUp(){
	doc=document.mapFrame;
	if (XMLDOM.readyState == 4) {
		arr=XMLDOM.getElementsByTagName("cell");
		//alert("arr="+arr.length);
		if(arr.length!=0){
			tr=doc.mapTable.insertRow(0);
			for(i=0;i<arr.length;i++){
				td=tr.insertCell();
					td.innerHTML="<img vspace=0 hspace=0 id='img0_"+i+"' onclick='setAttr(this,event);showMenu();' ondblclick='submit(this,event);' width="+width+" border=0 src='/map/"+arr.item(i).getAttribute("imgSrc")+"'>";
			}
			doc.mapForm.arzeShoro.value=parseInt(doc.mapForm.arzeShoro.value)+parseInt(doc.mapForm.cellArz.value);
			correctImgName();
		}
	}
}
function DoXMLCompleteDown(){
	doc=document.mapFrame;
	if (XMLDOM.readyState == 4) {
		arr=XMLDOM.getElementsByTagName("cell");
		//alert("arr="+arr.length);
		if(arr.length!=0){
			tr=doc.mapTable.insertRow();
			for(i=0;i<arr.length;i++){
				td=tr.insertCell();
				td.innerHTML="<img vspace=0 hspace=0 id='img"+(doc.mapTable.rows.length-1)+"_"+i+"' onclick='setAttr(this,event);showMenu();' ondblclick='submit(this,event);' width="+width+"  border=0 src='/map/"+arr.item(i).getAttribute("imgSrc")+"'>";
	//	alert(doc.mapTable.innerHTML);
			}
//			doc.mapForm.arzeShoro.value=parseInt(doc.mapForm.arzeShoro.value) - parseInt(doc.mapForm.cellArz.value)*doc.mapTable.rows.length;

//		correctImgName();
		}
	}

}

function DoXMLCompleteLeft(){
	doc=document.mapFrame;
	if (XMLDOM.readyState == 4) {
		arr=XMLDOM.getElementsByTagName("cell");
		//alert("arr="+arr.length);
		if(arr.length!=0){
			for(i=0;i<arr.length;i++){
				tr=doc.mapTable.rows(i);
				td=tr.insertCell(0);
					td.innerHTML="<img vspace=0 hspace=0 id='img"+i+"_"+0+"' onclick='setAttr(this,event);showMenu();' ondblclick='submit(this,event);' width="+width+"  border=0 src='/map/"+arr.item(i).getAttribute("imgSrc")+"'>";
			}
			doc.mapForm.tooleShoro.value=parseInt(doc.mapForm.tooleShoro.value) - parseInt(doc.mapForm.cellTool.value);
			correctImgName();
		}
	}

}
function DoXMLCompleteRight(){
doc=document.mapFrame;
	if (XMLDOM.readyState == 4) {
		arr=XMLDOM.getElementsByTagName("cell");
		//alert("arr="+arr.length);
		if(arr.length!=0){
			for(i=0;i<arr.length;i++){
				tr=doc.mapTable.rows(i);
				td=tr.insertCell();
				td.innerHTML="<img vspace=0 hspace=0 id='img"+i+"_"+(doc.mapTable.rows(0).cells.length-1)+"' onclick='setAttr(this,event);showMenu();' ondblclick='submit(this,event);' width="+width+"  border=0 src='/map/"+arr.item(i).getAttribute("imgSrc")+"'>";
			}
	//		doc.mapForm.tooleShoro.value=parseInt(doc.mapForm.tooleShoro.value)+parseInt(doc.mapForm.cellTool.value)*doc.mapTable.rows(0).cells.length;
			correctImgName();
		}
	}
}

function correctImgName(){
doc=document.mapFrame;
	images=doc.mapForm.getElementsByTagName("img");
	for(i=0;i<images.length;i++)
			images(i).id.value="img"+i/doc.mapTable.rows(0).cells.length+"_"+i/doc.mapTable.rows(0).cells.length;
}

function goToLevel(n){
//alert("dfdfd")
	doc=document.mapFrame.document;
	doc.mapForm.realMapLevel.value=n;
}

</script>
<body bgcolor="#006699">

<form id="naghsheForm" name="naghsheForm">
	<center>
	<table width="90%">
		<tr height="50">
			<td width="28">&nbsp;</td>
			<td width="90%" align="left">
			<img align="left" style="cursor:hand" onclick="history.back()" border="0" src="/map/Back.GIF"></td>
			<td width="66" align="center">
			<input type="text" id="zoomBox" size="6" value="100%" readonly="true"></td>
			<td width="44" align="center">
			<img align="middle" alt="&#1575;&#1606;&#1583;&#1575;&#1586;&#1607; &#1575;&#1589;&#1604;&#1740;" style="cursor:hand" onclick="javascript:zoom(0)" border="0" src="/map/zoom%20default.gif"></td>
			<td width="44" align="center">
			<img align="middle" alt="&#1576;&#1586;&#1585;&#1711; &#1606;&#1605;&#1575;&#1740;&#1740;" style="cursor:hand" onclick="javascript:zoom(1)" border="0" src="/map/zoom%20in.gif"></td>
			<td width="44" align="center">
			<img align="middle" alt="&#1705;&#1608;&#1670;&#1705; &#1606;&#1605;&#1575;&#1740;&#1740;" style="cursor:hand" onclick="javascript:zoom(-1)" border="0" src="/map/zoom%20out.gif"></td>
		</tr>
	</table>
	<table name="naghsheTable" cellpadding="0" cellspacing="0" width="90%" height="90%">
		<tr>
			<td bgcolor="#CCCCFF"></td>
			<td style="cursor:hand" onmouseover="document.all.up.src='/map/up2.gif'" onmouseout="document.all.up.src='/map/up1.gif'" onclick="javascript:addUp();" bgcolor="#CCCCFF" align="center" width="90%">
			<img id="up" border="0" src="/map/up1.gif" alt="&#1587;&#1591;&#1585; &#1602;&#1576;&#1604;"></td>
			<td bgcolor="#CCCCFF"></td>
		</tr>
		<tr height="100%">
			<td style="cursor:hand" onmouseover="document.all.left.src='/map/left2.gif'" onmouseout="document.all.left.src='/map/left1.gif'" onclick="javascript:addLeft();" bgcolor="#CCCCFF">
			<p align="center"><img id="left" border="0" src="/map/left1.gif" alt="&#1587;&#1578;&#1608;&#1606; &#1602;&#1576;&#1604;"></p>
			</td>
			<td width="100%" height="100%" align="center">
			<iframe width="100%" height="100%" name="mapFrame" src="/emdad/s/naghshe.run?action_type=specific,levelPics&mapLevel=1">
			</iframe></td>
			<td style="cursor:hand" onmouseover="document.all.right.src='/map/right2.gif'" onmouseout="document.all.right.src='/map/right1.gif'" onclick="javascript:addRight();" bgcolor="#CCCCFF">
			<img id="right" border="0" src="/map/right1.gif" alt="&#1587;&#1578;&#1608;&#1606; &#1576;&#1593;&#1583;"></td>
		</tr>
		<tr>
			<td bgcolor="#CCCCFF"></td>
			<td style="cursor:hand" onmouseover="document.all.down.src='/map/down2.gif'" onmouseout="document.all.down.src='/map/down1.gif'" onclick="javascript:addDown();" bgcolor="#CCCCFF" align="center">
			<img id="down" border="0" src="/map/down1.gif" alt="&#1587;&#1591;&#1585; &#1576;&#1593;&#1583;"></td>
			<td bgcolor="#CCCCFF"></td>
		</tr>
	</table>
	</center>
</form>

</body>

</html>
