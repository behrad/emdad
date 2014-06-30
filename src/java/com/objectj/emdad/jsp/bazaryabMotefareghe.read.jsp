<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<html:form method="post" action="/r/bazaryabMotefareghe">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نام و نام خانوادگی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="name" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تلفن:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tel" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">تلفن همراه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="mobile" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">آدرس:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="address" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نام پدر:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="namePedar" name="value_object"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">شماره شناسنامه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shShenasname" name="value_object"/>  </td>
					</tr>


		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.bazaryabMotefaregheForm);
	setEntity("BazaryabMotefareghe");
</script>

