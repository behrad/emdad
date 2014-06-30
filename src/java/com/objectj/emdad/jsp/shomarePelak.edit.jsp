<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>
<form method="post" action="/emdad/s/moshtarak.run?action_type=specific,updatePelak" name="changePelak">
    <center>
        <span class="tilesHeader">تغييرشماره پلاک مشترک</span>
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
							<input type="text" value="<%= request.getParameter("eshterakId") %>" name="eshterakId" size="12" maxlength="10" onkeypress="return submitenter(this,event)" styleClass="field"/>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1588;&#1605;&#1575;&#1585;&#1607; &#1662;&#1604;&#1575;&#1705;:</td>
						<td class="editStar">*</td>
						<td> 
						<input type="text" name="shomarePelak" size="8" maxlength="6" onkeypress="return submitenter2(this,event)"/>
			                        <input type="text" name="shomarePelak2" size="12" maxlength="10" onkeypress="return submitenter2(this,event)" />
						</td>
					</tr>
					<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/samp-pelak.jsp" flush="true" />

                    <tr align="left">
                        <td height="70" colspan="20" align="center">
                            <input type="hidden" name="action_type" />
                            <input type="hidden" name="id" />
                            <input type="hidden" name="curpage" />
                            <input type="hidden" name="order"/>
                            <input type="hidden" name="sorttype" />
                            <input type="button" value="ثبت" name="sabtBtn" class="emdadButton" onClick="setPelak()"/>&nbsp;&nbsp;
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
</body>
<!----------------------------------------->
<script>
var eshterakId1 = "<%=request.getParameter("eshterakId")%>";
function setPelak(){
if (document.changePelak.eshterakId.value == eshterakId1)
creator.shomarePelak.value=document.changePelak.shomarePelak.value +" "+document.changePelak.shomarePelak2.value; 
//alert('before submit');
if(document.changePelak.shomarePelak.value!="" && document.changePelak.shomarePelak2.value!=""){
document.changePelak.submit();
}else {alert("لطفا پلاک را کامل وارد نماييد");}
//alert('after submit');
}
</script>

