<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<html:base/>
<logic:equal name="ojratForm" property="sorttype" value="succeed" >
<script>
function doing() {
	obj = document.getElementById("isDoing2");
	styl = obj.style;
	styl.display = "none";

	document.ojratForm.takmilBtn.disabled = true;
	obj = document.getElementById("isDoing");
	styl = obj.style;
	styl.display = "inline";
	return true;
}
</script>
<div align="center" class="success">
	<p class=info><br>فايل با موفقيت به سرور منتقل شد.</p>
<table border="0">
  <tr> 
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td>مرحله2:</td>
    <td>&nbsp;</td>
  </tr>
  <tr id="isDoing2" style="display:inline;" > 
    <td>&nbsp;</td>
    <td>انتقال فهرست قطعات به پايگاه داده</td>
  </tr>
</table>
<div id="isDoing" style="display:none;" >
<table border="0">
  <tr> 
    <td>&nbsp;</td>
    <td>اطلاعات قطعات در حال انتقال به پايگاه داده می باشد.</td>
  </tr>
  <tr> 
    <td>&nbsp;</td>
    <td>اين عمل ممکن است دقايقي به طول انجامد</td>
  </tr>
</table>
</div>
	<html:form method="post" action="/s/ojrat" onsubmit="return doing();">
	<html:hidden property="action_type" value="specific,doimport"/>
	<html:hidden property="id"/>
    <input type="hidden" name="farsi" value="<bean:write name="farsi" />" />
	<input type="submit" name="takmilBtn" value="تکميل انتقال اطلاعات قطعات"  />
	</html:form>
</div>
</logic:equal>
<logic:equal name="ojratForm" property="sorttype" value="failed" >
<div align="center" class="error">
	<p>انتقال فايل به سرور با مشکل مواجه شد.</p><br>
	<p><a href="/emdad/l/ojrat.run"> بازگشت </a></p>
</div>
</logic:equal>
