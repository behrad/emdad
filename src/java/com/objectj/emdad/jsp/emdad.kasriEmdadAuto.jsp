<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>

<html:form method="post" action="/s/kasriEmdad">
    <center>
        <span class="tilesHeader">استخراج خودکار کسري امدادگران</span>
    </center>

	<table width="100%" dir=rtl class="generalText">
		<!----------------------------------------->
	<tr>
		<td align="center">
			<table border="0" cellpadding="2" cellspacing="0" class="editTable">
				<!----------------------------------------->
				<tr class="editRow0">
					<td class="editLabel">نوع امدادگر:</td>
					<td class="editStar"></td>
					<td>
					<html:select property="noeEmdadgarId" size="1">
						<html:options collection="noeEmdadgarList" property="eid" labelProperty="name"/>
					</html:select>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                            <input type="button" value="استخراج کسري" class="emdadButton" onClick="extNoeEmdadgar()"/>&nbsp;&nbsp;
					</td>
				</tr>
				<!----------------------------------------->
				<tr class="editRow1">
					<td class="editLabel">امدادگر:</td>
					<td class="editStar"></td>
					<td> 
					<html:select property="emdadgarId" size="1">
						<html:options collection="emdadgarList" property="eid" labelProperty="name"/>
					</html:select>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                            <input type="button" value="استخراج کسري" class="emdadButton" onClick="extEmdadgar()"/>&nbsp;&nbsp;
					</td>
				</tr>

				</table>
			</td>
		</tr>

		<!----------------------------------------->

  </table>
</html:form>
</body>
<!----------------------------------------->
<script>
function extNoeEmdadgar(){
	document.kasriEmdadForm.action = "/s/kasriEmdad.run?action_type=specific,kasriNoeEmdadgar";
	document.kasriEmdadForm.submit();
}
function extEmdadgar(){
	document.kasriEmdadForm.action = "/s/kasriEmdad.run?action_type=specific,kasriEmdadgar";
	document.kasriEmdadForm.submit();
}
</script>

