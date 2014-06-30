<html>
<head>
<title>Grid Test Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
<!--
body {
	font-family: Tahoma, "Courier New", Arial;
}
.generalText
{
	font-family: Tahoma, Arial;
	font-size: 12px;
    MARGIN-TOP: 0px;
    MARGIN-BOTTOM: 0px
}
tr.listRow0
{
	background-color: #E9EBEB;
}

tr.listRow1
{
	background-color: #DADEDC;
	border: 1px solid #FFFFFF;
}
td.editLabel
{
	text-align: center;
	font-size: 9pt;
}
tr.listFilterHeader
{
	background-color: #9FC6C5;
	height: 25px;
	font-size: 12px;
}
tr.listTableHeader
{
	background-color: #575F8E;
	text-align: center;
	height: 18px;
	font-size: 14px;
	color: #FFFFFF;
}
.invis 
{
	display : "none";
}

-->
</style>
</head>
<script language="JavaScript" src="grid.js"></script>
<body>
<div align="center"><h4>فهرست کدهاي ايراد موجود</h4></div>
<div align="center" class="generalText">[ تعداد رکوردها: <span class="generalText" id="data_size" align="center"></span>]</div>
<table class="generalText" id="grid" bordercolor="#999999" border="1" align="center" cellspacing="0" cellpadding="10">
  <tr class="listFilterHeader" id="filterRow">
  	<form name="filter" onSubmit="return false;">
	<td align="center">&nbsp;</td>
    <td align="center"><input name="id"   type="text" size="10" onKeyPress="if ( event.keyCode == 13 ) doFilter( 1 );"/></td>
    <td align="center"><input name="name" type="text" size="10" onKeyPress="submitenter(this, event);if ( event.keyCode == 13 ) doFilter( 2 );"/></td>
    <td class="invis" align="center">&nbsp;</td>
	</form>
  </tr>
  <tr class="listTableHeader" id="header">
  	<TD class="editLabel" align="center">رديف</TD>
    <td class="editLabel" align="center" id="col1"><a href="javascript:sortById();"><font color="#FFFFFF">کد 
      ايراد</font></a></td>
    <td class="editLabel" align="center" id="col2"><a href="javascript:sortByName();"><font color="#FFFFFF">عنوان</font></a></td>
    <td class="invis" align="center" id="col3"></td>
  </tr>
  
  <tr class="listRow1" id="row1">
  	<TD align="center"></TD>
    <td align="center">&nbsp;</td>
    <td align="center">&nbsp;</td>
    <td class="invis" align="center">&nbsp;</td>
  </tr>
  
  <tr class="listRow0" id="row2">
  	<TD align="center"></TD>
    <td align="center">&nbsp;</td>
    <td align="center">&nbsp;</td>
    <td class="invis" align="center">&nbsp;</td>
  </tr>
  
  <tr class="listRow1" id="row3">
  	<TD align="center"></TD>
    <td align="center">&nbsp;</td>
    <td align="center">&nbsp;</td>
    <td class="invis" align="center">&nbsp;</td>
  </tr>
  
  <tr class="listRow0" id="row4">
  	<TD align="center"></TD>
    <td align="center">&nbsp;</td>
    <td align="center">&nbsp;</td>
    <td class="invis" align="center">&nbsp;</td>
  </tr>
  
  <tr class="listRow1" id="row5">
  	<TD align="center"></TD>
    <td align="center">&nbsp;</td>
    <td align="center">&nbsp;</td>
    <td  class="invis" align="center">&nbsp;</td>
  </tr>
  
  <tr class="listRow0" id="row6">
  	<TD align="center"></TD>
    <td align="center">&nbsp;</td>
    <td align="center">&nbsp;</td>
    <td class="invis" align="center">&nbsp;</td>
  </tr>
  
  <tr class="listRow1" id="row7">
  	<TD align="center"></TD>
    <td align="center">&nbsp;</td>
    <td align="center">&nbsp;</td>
    <td class="invis" align="center">&nbsp;</td>
  </tr>
  
  <tr class="listRow0" id="row8">
  	<TD align="center"></TD>
    <td align="center">&nbsp;</td>
    <td align="center">&nbsp;</td>
    <td class="invis" align="center">&nbsp;</td>
  </tr>
  
  <tr class="listRow1" id="row9">
  	<TD align="center"></TD>
    <td align="center">&nbsp;</td>
    <td align="center">&nbsp;</td>
    <td class="invis" align="center">&nbsp;</td>
  </tr>
  
  <tr class="listRow0" id="row10">
  	<TD align="center"></TD>
    <td align="center">&nbsp;</td>
    <td align="center">&nbsp;</td>
    <td class="invis" align="center">&nbsp;</td>
  </tr>
  
</table>
<div class="generalText" align="center">
	<a href="javascript:renderGrid( mainGrid, grid_data, cur_start - size );">قبل</a>&nbsp;|
	صفحه <span id="cur_page"></span>&nbsp;از&nbsp;<span id="pages"></span>
	|&nbsp;<a href="javascript:renderGrid( mainGrid, grid_data, cur_start + size );">بعد</a>
	<br><a href="javascript:clearFilter();">نمايش بدون فيلتر</a>
</div>

</body>
</html>
<script language="JavaScript">
	var mainGrid = document.getElementById( "grid" );
