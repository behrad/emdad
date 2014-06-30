<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
</HEAD>

<body>


<html:base/>
<html:form method="post" action="/r/moshtarak">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="7" cellspacing="0" class="readTable">

					<tr class="readRow0">
						<td class="info" colspan="3">غير مشترک با شماره <span id="eshterakId"><bean:write property="eshterakId" name="value_object1"/></span> ثبت شد.</td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">نام خانوادگي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="nameKhanevadegi" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نام:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="name" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تلفن:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tel" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نوع خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeKhodroOnvan" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">رنگ خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="rangeKhodroOnvan" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">سال ساخت خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="saleSakht" name="value_object1"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">شماره پلاک:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomarePelak" name="value_object1"/></td>
					</tr>


					<!---------------------------------------->

				</table>
			</td>
		</tr>

		<tr> 
			<td height="70" colspan="3" align="center">
				<input type="button" value="پايان" class="emdadButton" onClick="setAttribs()"/>
			</td>
		</tr>


	</table>
</html:form>

<!---------------------------------------->

<script language="JavaScript" type="text/JavaScript">
	function setAttribs() {
		creator = opener.document.rokhdadForm;
		if (creator!=null) {		
			eId = document.getElementById("eshterakId");
			creator.eshterakId.value = eId.innerText;
			creator.eshterakId.changed = true;
			creator.moshtarakId.value = "";
			creator.moshtarakId.changed = true;
			if(creator.eshterakId != null) {
				creator.eshterakId1.value = eId.innerText;
				creator.eshterakId1.changed = true;
			}
		}
		close();
	}
</script>

