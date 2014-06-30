<%@ page contentType="text/html; charset=UTF-8" %>

<center>
	<span class="error">توجه:</span> <span class="info2">بارگذاري فايل ممکن است زمان گير باشد</span>
</center>

<br>

<form  method="post" action="/emdad/com/objectj/emdad/jsp/mostanadatRokhdad.doupload.jsp?fromPopUp=false" enctype="multipart/form-data">
<%
    boolean showCancel = false;
    if ( (request.getAttribute("showCancel") != null) && (((String)request.getAttribute("showCancel")).equals("showCancel")))
       showCancel = true;
%>

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
					<tr class="editRow0">
					<td class="editLabel">نام پرونده: </td>
					<td><font size="-1"><%=(String)request.getAttribute("nameParvande")%></font></td>
					</tr>
					<tr class="editRow1">
					<td class="editLabel">نام سند: </td>
					<td><font size="-1"><%=(String)request.getAttribute("nameSanad")%></font></td>
					</tr>

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


					</tr>
		<td height="70" colspan="3" align="center"> <input type="submit" value=" انتقال فايل به سرور  "/>&nbsp;&nbsp;
		<%if (showCancel){%>
		   <input type="button" value="انصراف" styleClass="emdadButton" onClick="history.go(-1);"/>&nbsp;&nbsp;
		   <%}%>
		</td></tr>

				</table>
			</td>
		</tr>

		<!----------------------------------------->

  </table>

<form>


</body>

</html>
