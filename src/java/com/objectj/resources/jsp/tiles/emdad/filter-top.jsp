<%@ page contentType="text/html; charset=UTF-8" %>

<link href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" rel="stylesheet" type="text/css">
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/filter.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>


<center>
<table border="0" cellpadding="0" cellspacing="0" width="80%"><tr><td align="right">
<input type="hidden" name="helpUrl" value="/emdad/com/objectj/resources/jsp/help/filter.help.html"/>
	<form name=filterForm>
	<table border="0" cellpadding="2" class="caption" cellspacing="0">
		<tr>
			<td bgcolor="#FFFFFF">&nbsp;&nbsp;<a href="javascript:help();">راهنما</a>&nbsp;&nbsp;</td>
			<td height="20" align="right">&nbsp;فيلتر پيشرفته&nbsp;&nbsp;</td>
		</tr>
	</table>
		<table border="0" dir=rtl cellpadding="5" cellspacing="1" class="filterTable" id="srchTBL">
				
			<!----------------------------------------->

			<tr class="filterTableHeader">
				<td>(</td>
				<td>مشخصه</td>
				<td>عملگر</td>
				<td>مقدار</td>
				<td>)</td>
				<td>&nbsp;</td>
			</tr>

			<!----------------------------------------->

			<tr id="sampRow" class="filterRow">
				<td class="filterCol"> 
					<select class="generalText" id="gr2" value=adsdddd>
						<option value=" ">&nbsp;</option>
						<option value="(">(</option>
					</select> 
				</td>

				<!----------------------------------------->

