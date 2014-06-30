<%@ page import ="org.apache.log4j.Logger" %>
<html dir="ltr">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
<title>map</title>
</head>

<script>
//document.oncontextmenu=showMenu;
//document.onclick=hideMenu;
var oPopup = window.createPopup();
var oPopupBody = oPopup.document.body;
oPopupBody.style.border = "solid black 1px";

var x;
var y;

function showMenu(){
	x=event.x;
	y=event.y;
	document.all.levelMenuTable.style.display='none';
	document.all.menuTable.width=screen.width*13/100;
	document.all.menuTable.height=3*screen.height*3.2/100;
	oPopupBody.innerHTML =document.all.myMenu.innerHTML;
	oPopup.show(event.x, event.y, document.all.menuTable.width, document.all.menuTable.height, document.body);
	return false;
}

function showLevelMenu(){
	if(document.all.levelMenuTable.style.display=='none'){
		document.all.levelMenuTable.style.display='inline';
		document.all.menuTable.width=screen.width*13/100;
		document.all.innerTable.height=7*screen.height*3.2/100;
		document.all.menuTable.height=10*screen.height*3.2/100;
		oPopupBody.innerHTML =document.all.myMenu.innerHTML;
		oPopup.show(x,y,document.all.menuTable.width, document.all.menuTable.height, document.body);
	}
	else{
		document.all.levelMenuTable.style.display='none';
		document.all.menuTable.width=screen.width*13/100;
		document.all.innerTable.height=7*screen.height*3.2/100;
		document.all.menuTable.height=3*screen.height*3.2/100;
		oPopupBody.innerHTML =document.all.myMenu.innerHTML;
		oPopup.show(x,y,document.all.menuTable.width, document.all.menuTable.height, document.body);
	}
}

function getInformation(){
//	alert( document.mapForm.tool.value+"*"+document.mapForm.arz.value);
	oPopup.hide();
	args = "width=500, height=500 , resizable=no, scrollbars=no, status=0";
	windowTitle = "&#1575;&#1591;&#1604;&#1575;&#1593;&#1575;&#1578;";
    param='mapLevel='+document.mapForm.mapLevel.value+'&tool='+document.mapForm.tool.value+'&arz='+document.mapForm.arz.value;
	win3 = window.open("/emdad/s/naghshe.run?action_type=specific,mapInfo&"+param, "Information",args);
	win3.creator=window;
	win3.focus();
}

function submit1(i){
	oPopup.hide();
	if(parseInt(document.mapForm.realMapLevel.value)+i<=5 && parseInt(document.mapForm.realMapLevel.value)+i>=1){
		window.parent.naghsheForm.zoomBox.value="100%";
		document.mapForm.mapLevel.value=parseInt(document.mapForm.realMapLevel.value)+i;
	    document.mapForm.cols.value=6;
//        if(i==-1)
//	        document.mapForm.topBot.value=-1;
//        else
	        document.mapForm.topBot.value=0;
	    document.mapForm.submit();
    }
}

function goToLevel(n){
	oPopup.hide();
	window.parent.naghsheForm.zoomBox.value="100%";
	document.mapForm.mapLevel.value=n;
	document.mapForm.cols.value=6;
//	if(parseInt(document.mapForm.realMapLevel.value) < n)
        document.mapForm.topBot.value=0;
//    else
//        document.mapForm.topBot.value=-1;
	document.mapForm.submit();

}

function setAttr(img,e){
    s=img.id;
    cellTool=parseInt(document.mapForm.cellTool.value);
    cellArz=parseInt(document.mapForm.cellArz.value);
	i=parseInt(s.substring(3,s.indexOf('_')));
	j=parseInt(s.substring(s.indexOf("_")+1,s.length));
	ex=parseFloat(e.offsetX);
	ey=parseFloat(img.height-e.offsetY);
//    alert("imID="+s+",cellTool="+cellTool+",cellArz="+cellArz+",ex="+ex+",ey="+ey);
    document.mapForm.tool.value=parseInt(cellTool*(ex/img.width)+j*cellTool+parseInt(document.mapForm.tooleShoro.value));
    document.mapForm.arz.value=parseInt(cellArz*(ey/img.height)+(-i)*cellArz+parseInt(document.mapForm.arzeShoro.value));
}

</script>
<body onload="if(document.getElementsByTagName('img').length>0)document.mapForm.cellWidth.value=document.getElementsByTagName('img')(0).width;" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">

<%
    Logger log = Logger.getLogger("com.objectj.emdad");
    log.info(request.getAttribute("tooleShoro")+" ******* "+request.getAttribute("arzeShoro"));
//System.out.println(request.getAttribute("tooleShoro")+ " ******* "+request.getAttribute("arzeShoro"));
%>
<form method="post" name="mapForm" action="/emdad/s/naghshe.run?action_type=specific,changeLevel">
	<input type="hidden" name="zoomValue" value="100">
	<input type="hidden" name="topBot"><input type="hidden" name="tool">
	<input type="hidden" name="arz"><input type="hidden" name="cols">
	<input type="hidden" name="rows">
	<input type="hidden" name="realMapLevel" value="<%=request.getAttribute("mapLevel")%>">	
	<input type="hidden" name="mapLevel" value="<%=request.getAttribute("mapLevel")%>">
	<input type="hidden" name="tooleShoro" value="<%=request.getAttribute("tooleShoro")%>">
	<input type="hidden" name="arzeShoro" value="<%=request.getAttribute("arzeShoro")%>">
	<input type="hidden" name="cellTool" value="<%=request.getAttribute("cellTool")%>">
	<input type="hidden" name="cellArz" value="<%=request.getAttribute("cellArz")%>">
	<input type=hidden name="cellWidth"> 
	
	<table style="cursor:crosshair" id="mapTable" name="mapTable" border="0" cellspacing="0" cellpadding="0">
		<%
		String[][] images=(String[][])request.getAttribute("imageList");
		if(images==null){
			%><script>alert(".\u062a\u0635\u0627\u0648\u064a\u0631 \u062c\u063a\u0631\u0627\u0641\u064a\u0627\u0626\u064a \u0633\u0637\u062d \u0645\u0648\u0631\u062f \u0646\u0638\u0631 \u0645\u0648\u062c\u0648\u062f \u0646\u0645\u064a\u0628\u0627\u0634\u062f");history.back(); </script><%
		}else
		for(int i=0;i<images.length;i++){%>
		<tr>
			<%for(int j=0;j<images[i].length;j++){
				if(images[i][j]==null){%>
			<td><img id="img<%=i%>_<%=j%>" border="0" src="/map/blank_img.gif"></td>
			<%}else{%>
			<td>
			<img vspace=0 hspace=0 id="img<%=i%>_<%=j%>" onclick="setAttr(this,event);showMenu();" ondblclick="javascript:setAttr(this,event);submit1(this,event)" border="0" src="/map/<%=images[i][j]%>"></td>
			<%}
            }%>
		</tr>
		<%}%>
	</table>
</form>
<div id="myMenu" style="display:none;position:absolute; left:10px; top:15px; width:201px">
	<table cellpadding="0" cellspacing="0" id="menuTable" >
		<tr>
			<td style="cursor:hand;" onmouseover="this.bgColor='#0000FF';this.style.color='white'"  onmouseout="this.bgColor='#FFFFFF';this.style.color='black'" onclick="window.parent.execScript('getInformation()');" bgcolor="#FFFFFF" width="100%" align="right">
			<p dir="rtl"><font face="Times New Roman"><b>&nbsp;&nbsp; &#1606;&#1605;&#1575;&#1740;&#1588; 
			&#1575;&#1591;&#1604;&#1575;&#1593;&#1575;&#1578;</b></font></p>
			</td>
		</tr>
		<tr>
			<td style="cursor:hand;" onmouseover="this.bgColor='#0000FF';this.style.color='white'"  onmouseout="this.bgColor='#FFFFFF';this.style.color='black'" onclick="window.parent.execScript('showLevelMenu()');" bgcolor="#FFFFFF" width="100%" align="right">
			<p dir="rtl"><font face="Times New Roman"><b>&nbsp;&nbsp; &#1608;&#1585;&#1608;&#1583; &#1576;&#1607; 
			...</b></font></p>
			</td>
		</tr>
		<tr id="levelMenuTable" style="display:none;">
			<td width="100%" align="right">
			<table id="innerTable" width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
				<tr>
					<td style="cursor:hand;" onmouseover="this.bgColor='#0000FF';this.style.color='white'" onmouseout="this.bgColor='#FEFEF3';this.style.color='black'" onclick="window.parent.execScript('submit1(1)');" bgcolor="#FEFEF3" width="100%">
					<p align="right" dir="rtl"><font face="Times New Roman"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					- &#1587;&#1591;&#1581; &#1576;&#1593;&#1583;</b></font></p>
					</td>
				</tr>
				<tr>
					<td style="cursor:hand;" onmouseover="this.bgColor='#0000FF';this.style.color='white'" onmouseout="this.bgColor='#FEFEF3';this.style.color='black'" onclick="window.parent.execScript('submit1(-1)');" bgcolor="#FEFEF3" width="100%">
					<p align="right" dir="rtl"><font face="Times New Roman"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					- &#1587;&#1591;&#1581; &#1602;&#1576;&#1604;</b></font></p>
					</td>
				</tr>
				<tr>
					<td style="cursor:hand;" onmouseover="this.bgColor='#0000FF';this.style.color='white'" onmouseout="this.bgColor='#FEFEF3';this.style.color='black'" onclick="window.parent.execScript('goToLevel(5)');" bgcolor="#FEFEF3" width="100%">
					<p dir="rtl"><font face="Times New Roman"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					- &#1587;&#1591;&#1581; 5 </b></font> </p>
					</td>
				</tr>
				<tr>
					<td style="cursor:hand;" onmouseover="this.bgColor='#0000FF';this.style.color='white'" onmouseout="this.bgColor='#FEFEF3';this.style.color='black'" onclick="window.parent.execScript('goToLevel(4)');" bgcolor="#FEFEF3" width="100%">
					<p dir="rtl" align="right"><font face="Times New Roman"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					- &#1587;&#1591;&#1581; 4 </b></font> </p>
					</td>
				</tr>
				<tr>
					<td style="cursor:hand;" onmouseover="this.bgColor='#0000FF';this.style.color='white'" onmouseout="this.bgColor='#FEFEF3';this.style.color='black'" onclick="window.parent.execScript('goToLevel(3)');" bgcolor="#FEFEF3" width="100%">
					<p dir="rtl" align="right"><font face="Times New Roman"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					- &#1587;&#1591;&#1581; 3 </b></font> </p>
					</td>
				</tr>
				<tr>
					<td style="cursor:hand;" onmouseover="this.bgColor='#0000FF';this.style.color='white'" onmouseout="this.bgColor='#FEFEF3';this.style.color='black'" onclick="window.parent.execScript('goToLevel(2)');" bgcolor="#FEFEF3" width="100%">
					<p dir="rtl" align="right"><font face="Times New Roman"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					- &#1587;&#1591;&#1581; 2 </b></font> </p>
					</td>
				</tr>
				<tr>
					<td style="cursor:hand;" onmouseover="this.bgColor='#0000FF';this.style.color='white'" onmouseout="this.bgColor='#FEFEF3';this.style.color='black'" onclick="window.parent.execScript('goToLevel(1)');" bgcolor="#FEFEF3" width="100%">
					<p dir="rtl" align="right"><font face="Times New Roman"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					- &#1587;&#1591;&#1581; 1 </b></font> </p>
					</td>
					</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td style="cursor:hand;" onmouseover="this.bgColor='#0000FF';this.style.color='white'"  onmouseout="this.bgColor='white';this.style.color='black'" onclick="window.parent.execScript('oPopup.hide()');" bgcolor="#FFFFFF" width="100%">
			<p dir="rtl" align="right"><font face="Times New Roman"><b>&nbsp;&nbsp; 
			&#1575;&#1606;&#1589;&#1585;&#1575;&#1601;</b></font></p>
			</td>
		</tr>
	</table>
</div>

</body>

</html>