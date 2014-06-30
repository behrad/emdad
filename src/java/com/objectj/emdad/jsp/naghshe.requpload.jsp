<%@ page contentType="text/html; charset=UTF-8" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">
</head>

<body dir="rtl">

<table border="0">
  <tr>
 	<td>توجه:</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>انتقال فايل GIF یا JPG در دو مرحله صورت ميگيرد:</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;مرحله 1-</td>
    <td> منتقل کردن فايل GIF یا JPG به سرور </td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;مرحله 2-</td>
    <td>انتقال <span lang="fa">اطلاعات</span>&nbsp; فايل GIF <span lang="fa">یا </span>JPG به پايگاه داده</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>مرحله1:</td>
    <td>منتقل کردن فايل GIF <span lang="fa">یا </span>JPG به سرور</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  </table>

<form id="tt"  method="post" action="/emdad/com/objectj/emdad/jsp/naghshe.doupload.jsp" enctype="multipart/form-data" onsubmit="document.all('submt').disabled = true;">

<input type='hidden' name="naghsheId" value="<%=request.getParameter("naghsheId")%>" >
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<!---------------------------------------->

					<tr class="editRow0">
						<td class="editLabel"> لطفا نام فايل GIF <span lang="fa">	یا </span>JPG<span lang="fa"> </span>&nbsp;را وارد نماييد:</td>
						<td class="editStar">*</td>
						<td><INPUT TYPE=FILE NAME=file size=60 /></td>
					</tr>

					<!---------------------------------------->


					<tr>
		<td height="70" colspan="3" align="center"> <input id="submt" type="submit" value=" انتقال فايل به سرور  "/ >&nbsp;&nbsp;
		</td></tr>

				</table>
			</td>
		</tr>

		<!----------------------------------------->

  </table>
</form>
</body>

</html>
