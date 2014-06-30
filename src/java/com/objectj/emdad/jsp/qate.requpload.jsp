<%@ page contentType="text/html; charset=UTF-8" %>
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">
<body dir="rtl">
<table border="0">
  <tr> 
    <td>توجه:</td>
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td>&nbsp;</td>
    <td>انتقال فايل قطعات در دو مرحله صورت ميگيرد:</td>
  </tr>
  <tr> 
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td>&nbsp;&nbsp;مرحله 1-</td>
    <td> منتقل کردن فايل DBF به سرور </td>
  </tr>
  <tr> 
    <td>&nbsp;&nbsp;مرحله 2-</td>
    <td>انتقال فهرست قطعات به پايگاه داده</td>
  </tr>
  <tr> 
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td>مرحله1:</td>
    <td>منتقل کردن فايل DBF به سرور</td>
  </tr>
  <tr> 
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr> 
</table>

<form  method="post" action="/emdad/com/objectj/emdad/jsp/qate.doupload.jsp" enctype="multipart/form-data">

	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<!---------------------------------------->

					<tr class="editRow0">
						<td class="editLabel"> لطفا نام فايل DBF را وارد نماييد:</td>
						<td class="editStar">*</td>
						<td><INPUT TYPE=FILE NAME=file size=60 /></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
                         <td><input name='farsi' type="checkbox">تبديل فارسی انجام شود</input></td>
                         <td colspan=3>&nbsp;</td>
					</tr>
					<!----------------------------------------->

					<!--tr class="editRow0">
						<td class="editLabel"> نوع سرويس:</td>
						<td class="editStar">*</td>
						<td>
							<select name="noeService" size="1">
							<option value="1">ويژه</option>
							<option value="2">عادي</option>
							</select>
						</td>
					</tr-->
					</tr>
		<td height="70" colspan="3" align="center"> <input type="submit" value=" انتقال فايل به سرور  "/ >&nbsp;&nbsp;
		</td></tr>

				</table>
			</td>
		</tr>

		<!----------------------------------------->

  </table>

<form>


</body>

</html>
