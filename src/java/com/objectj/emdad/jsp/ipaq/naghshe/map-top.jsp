<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>map</title>
<script language="Jscript">
var width = 220;
var zoo = 100;
function zoom(z){
	if( (z==1 && zoo<150)  || (z==-1 && zoo>50)   ){
			width=parseInt(width*(1+z/10));
			zoo=parseInt(zoo*(1+z/10));
			alert( document.images.length );
			for( i = 0; i < document.images.length; i++ )
				document.images[i].width = width;
   	}
}
</script>
</head>
<body dir="rtl">
	<form name="ZoomForm">
	<p align="center"><font face="Courier New"><a href="../index.html">برگشت</a></font></p>
		<table align="center" id="mapTable" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align="center" id="cell" width="220">
						<table style="cursor:hand" id="mapTable" name="mapTable" border="0" cellspacing="0" cellpadding="0">					