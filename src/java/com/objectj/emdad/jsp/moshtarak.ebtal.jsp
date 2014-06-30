<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>
<form method="post" action="/emdad/s/moshtarak.run?action_type=specific,batel" name="ebtalForm">
<br>
    <center>
        <span class="tilesHeader">ابطال مشترک</span>
    </center>

	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شماره مشتری:</td>
						<td class="editStar">*</td>
						<td>
							<input type="text" value="" name="eshterakId" size="14" maxlength="10" onkeypress="return submitenter(this,event)" styleClass="field"/>
						</td>
					</tr>

                    <tr align="left">
                        <td height="70" colspan="20" align="center">
                            <input type="hidden" name="action_type" />
                            <input type="hidden" name="id" />
                            <input type="hidden" name="curpage" />
                            <input type="hidden" name="order"/>
                            <input type="hidden" name="sorttype" />
                            <input type="button" value="ابطال" name="sabtBtn" class="emdadButton" onClick="doEbtal()"/>&nbsp;&nbsp;
							<!--<input type="button" value="pp" name="sabtBtnm" class="emdadButton" onClick="alert(parent.window.location.href);"/>&nbsp;&nbsp;-->
                            <input type="button" value="انصراف" class="emdadButton" onClick="javascript:SureCancle2();"/>&nbsp;&nbsp;
                        </td>
                    </tr>

                    <tr align="center">
                        <td height="20" align="center" colspan="20">
                            <span class="editStar"> * </span> : <span class="editRequired">ورود داده الزامي است</span>
                        </td>
                    </tr>

				</table>
			</td>
		</tr>

		<!----------------------------------------->

  </table>
</form>
<!----------------------------------------->
<script>
function doEbtal(){
if(document.ebtalForm.eshterakId.value!=""){
	question = confirm("از ابطال اين مشترک مطمئن هستيد؟");
	if (question !="0"){
	document.ebtalForm.submit();
	}
}else {
	alert("لطفا شماره اشتراک را وارد نماييد");
}
}
</script>

