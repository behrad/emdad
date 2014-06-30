<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:form method="post" action="/s/moshtariDarkhastTagheer"  onsubmit="return validate()">
<input type="hidden" name="helpUrl" value=''/>
	<center>
		<span class="tilesHeader">کاربر گرامی جهت ورود به قسمت تغییر اطلاعات مشترکین مشخصات ذیل را وارد کنید:</span>
	</center>
 
	<br><br>
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شماره اشتراک:</td>
						<td class="editStar">*</td>
						<td> <html:text property="eshterakId" size="20" maxlength="10" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره شاسی:</td>
						<td class="editStar">*</td>
						<td> <html:text property="postCode" size="20" maxlength="20" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->


					<tr class="editRow0">
						<td class="editLabel">شماره موتور:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tel" size="20" maxlength="20" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره پلاک:</td>
						<td class="editStar"> </td>
						<td class="readData"> <html:text property="shomarePelak" size="20" maxlength="20" onkeypress="return submitenter(this,event)"/> &nbsp; در صورت مشخص نبودن, پر نشود&nbsp;</td>
						<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/samp-pelak.jsp" flush="true" />
					</tr>

<%
    request.setAttribute("additional" , "<input type=\"button\" name=\"btnCancel\" value=\"\" onClick=\"javascript:chkCancel();\" class=\"emdadButton\"> ");
%>
					<!----------------------------------------->
				    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/edit-but.jsp" flush="true" />						
					<!----------------------------------------->

				</table>
			</td>
		</tr>
	
		<!----------------------------------------->

  </table>
</html:form>

<!----------------------------------------->

<script type="text/javascript" language="Javascript1.1">
	setForm(document.darkhastTagheerForm);
	setEntity("DarkhastTagheer");
	document.darkhastTagheerForm.action_type.value="specific,validreq";
	document.darkhastTagheerForm.btnCancel.value = "انصراف";
	document.darkhastTagheerForm.enserafBtn.style.display = "none";
	function validate() {
	    if (document.darkhastTagheerForm.eshterakId.value!='' && 
		document.darkhastTagheerForm.postCode.value!='' &&
		document.darkhastTagheerForm.tel.value!='')
			return true;
	    else{
		        alert("مقادير کليه فيلدها را وارد کنيد");
			return false;
	        }
	}
    function chkCancel() {
	document.darkhastTagheerForm.action_type.value="specific,goHome";
        document.darkhastTagheerForm.submit();
    }
</script>
