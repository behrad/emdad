<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>

<tr align="left">
	<td height="70" colspan="20" align="center">
		<html:hidden property="action_type" />
		<html:hidden property="id" />
		<html:hidden property="curpage" />
		<html:hidden property="order"/>
		<html:hidden property="sorttype" />
		<input type="hidden" name="fastComboHdn"/>
		<input type="hidden" name="submited" value="false"/>

		<input type="button" name="khoroojBtn" value="خروج" class="emdadButton" onClick="javascript:doEditCancel();" style="display:none;" />&nbsp;&nbsp;

		<input type="button" value="ثبت" name="sabtBtn" class="emdadButton" onClick="javascript:chkSabt(this);" />&nbsp;&nbsp;
		<html:reset  value="حالت اول" styleClass="emdadButton" />&nbsp;&nbsp;
		<input type="button" value="انصراف"  name="enserafBtn" class="emdadButton" onClick="javascript:SureCancle();"/>&nbsp;&nbsp;
		<%
		if (request.getParameter("additional") != null) {
			out.println(request.getParameter("additional"));
		}
		if (request.getAttribute("additional") != null) {
			out.println(request.getAttribute("additional"));
		}
		%>
	</td>
</tr>

<tr align="center">
	<td height="20" align="center" colspan="20">
		<span class="editStar"> * </span> : <span class="editRequired">ورود داده الزامي است</span>
	</td>
</tr>

<script type="text/javascript" language="Javascript1.1">
	document.all.fastComboHdn.lastTime = (new Date()).getSeconds();
	setHelpURL("/emdad/com/objectj/resources/jsp/help/edit.help.html");
</script>
<script>
function chkSabt(elem) {
	if ( theForm.submited.value == "false" ) {
		theForm.submited.value = "true";
		b = true;
		if (theForm.onsubmit!=null) {
			b = theForm.onsubmit();
			if ( !b ) {
				theForm.submited.value = "false";
			} else {
				theForm.sabtBtn.disabled = true;
				theForm.submit();
			}
		}
		return b;
	}
	if ( theForm.submited.value == "true" )
		return false;
}

</script>
