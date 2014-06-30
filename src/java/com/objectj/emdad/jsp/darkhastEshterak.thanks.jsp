<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:form method="post" action="/s/moshtariDarkhastEshterak.run?action_type=specific,goHome">
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl" align="center">
		<tr>
			<td width="590" height="*" align="center" valign="top" bgcolor="#FFFFFF" class="info2">
				با تشکر از اينکه فرم ثبت نام را پر کرديد
				.مسوولين امور مشترکين امداد خودرو جهت تکميل مراحل ثبت نام با شما تماس خواهند گرفت
			</td>
		</tr>

		<br><br>
		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->
	</table>
	
</html:form>

<script>
	setForm(document.darkhastEshterakForm);
	setEntity("DarkhastEshterak");
</script>
