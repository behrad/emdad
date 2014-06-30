<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:form method="post" action="/s/moshtari"  onsubmit="return validate()">

<input type="hidden" name="helpUrl" value=''/>

	<center>
		<span class="tilesHeader">کاربر کرامي جهت پيگيري رخداد مورد نظر مشخصات زير را وارد کنيد:</span>
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
						<td> <html:text property="eshterakId" size="10" maxlength="10" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">کد مورد:</td>
						<td class="editStar">*</td>
						<td> <html:text property="rokhdadId" size="20" maxlength="20" onkeypress="return submitenter(this,event)"/> </td>
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
	setForm(document.moshtarakForm);
	setEntity("Moshtarak");
//	document.moshtarakForm.action="/emdad/s/moshtari.run?action_type=specific,validreq";
//	document.moshtarakForm.action_type.value="specific,validreq";

    document.moshtarakForm.btnCancel.value = "انصراف";
    document.moshtarakForm.enserafBtn.style.display = "none";
    function chkCancel() {
	document.moshtarakForm.action_type.value="specific,goHome";
        document.moshtarakForm.submit();
    }

function validate() {
    if (document.moshtarakForm.eshterakId.value!='' && document.moshtarakForm.rokhdadId.value!='')
		return true;
    else{
	        alert("کد مورد و کد اشتراک بايستي وارد شود");
		return false;
        }
}
</script>


</html>
