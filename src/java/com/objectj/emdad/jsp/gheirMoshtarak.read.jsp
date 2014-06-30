<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:form method="post" action="/r/moshtarak">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">شماره اشتراک:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="eshterakId" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">نام خانوادگي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="nameKhanevadegi" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نام:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="name" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تلفن:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tel" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نوع خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeKhodroOnvan" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">رنگ خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="rangeKhodroOnvan" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">سال ساخت خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="saleSakht" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">شماره پلاک:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomarePelak" name="value_object"/></td>
					</tr>


					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">مشترک مجازی؟:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="majaziYaNa"/></td>
					</tr>

					<!---------------------------------------->

				</table>
			</td>
		</tr>

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.moshtarakForm);
	setEntity("Moshtarak");
</script>

