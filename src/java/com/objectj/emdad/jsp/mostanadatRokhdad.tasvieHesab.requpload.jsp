<%@ page contentType="text/html; charset=UTF-8" %>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>
<title></title>


<center>
	<span class="error">توجه:</span> <span class="info2">بارگذاري فايل ممکن است زمان گير باشد</span>
</center>

<br>

<%
    boolean showCancel = false;
    if ( (request.getAttribute("showCancel") != null) && (((String)request.getAttribute("showCancel")).equals("showCancel")))
       showCancel = true;
%>

<form  method="post" action="/emdad/com/objectj/emdad/jsp/mostanadatRokhdad.doupload.jsp?fromPopUp=true" enctype="multipart/form-data">
	<input type="hidden" name="id" value="<%=(String) request.getAttribute("mostanadatRokhdadId")%>" />
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<!---------------------------------------->
					
					<%if (!showCancel){%>
						<tr class="editRow0">
							<td class="editLabel">لطفا نام پرونده را وارد نماييد: </td>
							<td class="editStar">*</td>
							<td><INPUT TYPE=FILE NAME=file size=60 value=<%=(String)request.getAttribute("nameParvande")%>/></td>
						</tr>
					<%} else {%>
					
						<!---------------------------------------->
	
						<tr class="editRow0">
							<td class="editLabel">نام پرونده: </td>
							<td><font size="-1"><%=(String)request.getAttribute("nameParvande")%></font></td>
						</tr>
						
						<!---------------------------------------->
	
						<tr class="editRow1">
							<td class="editLabel">نام سند: </td>
							<td><font size="-1"><%=(String)request.getAttribute("nameSanad")%></font></td>
						</tr>
	
						<!---------------------------------------->
	
						<tr class="editRow1">
							<td class="editLabel">لطفا نام پرونده را وارد نماييد: </td>	
							<td><INPUT TYPE=FILE NAME=file size=60 /></td>
						</tr>
					<%}%>

					<!---------------------------------------->

					<tr class="readRow1">
						<td colspan=4>&nbsp;</td>
					</tr>

					<!----------------------------------------->

					<tr>
						<td height="70" colspan="3" align="center"> <input type="submit" value=" انتقال فايل به سرور  "/>&nbsp;&nbsp;
							<%if (showCancel){%>
								<input type="button" value="انصراف" styleClass="emdadButton" onClick="history.go(-1);"/>&nbsp;&nbsp;
							<%}%>
						</td>
					</tr>

					<!----------------------------------------->
					
				</table>
			</td>
		</tr>

		<!----------------------------------------->

  </table>

<form>


</body>
</html>

<script type="text/javascript" language="Javascript1.1">
	setForm(document.mostanadatRokhdadForm);
	setEntity("MostanadatRokhdad");
</script>
	
