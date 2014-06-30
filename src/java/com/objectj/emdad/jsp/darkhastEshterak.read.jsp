<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:form method="post" action="/r/darkhastEshterak">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">&#1606;&#1608;&#1593; &#1587;&#1585;&#1608;&#1610;&#1587;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="noeService"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">&#1606;&#1575;&#1605; &#1582;&#1575;&#1606;&#1608;&#1575;&#1583;&#1711;&#1610;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="nameKhanevadegi" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">&#1606;&#1575;&#1605;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="nameMoshtarak" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">&#1578;&#1575;&#1585;&#1610;&#1582; &#1578;&#1608;&#1604;&#1583;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="tarikhTavalod"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">&#1570;&#1583;&#1585;&#1587;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="addressMoshtarak" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">&#1705;&#1583; &#1662;&#1587;&#1578;&#1610;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="codePost" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">&#1606;&#1575;&#1605; &#1588;&#1607;&#1585;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shahrName" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">&#1662;&#1587;&#1578; &#1575;&#1604;&#1705;&#1578;&#1585;&#1608;&#1606;&#1610;&#1705;&#1610;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="emailMoshtarak" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">&#1578;&#1604;&#1601;&#1606;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="telMoshtarak" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">&#1578;&#1604;&#1601;&#1606; &#1607;&#1605;&#1585;&#1575;&#1607;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="mobileMoshtarak" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">&#1606;&#1608;&#1593; &#1582;&#1608;&#1583;&#1585;&#1608;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeKhodroOnvan" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">&#1585;&#1606;&#1711; &#1582;&#1608;&#1583;&#1585;&#1608;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="rangeKhodroOnvan" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">&#1587;&#1575;&#1604; &#1587;&#1575;&#1582;&#1578; :</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="saleSakht" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">&#1588;&#1605;&#1575;&#1585;&#1607; &#1662;&#1604;&#1575;&#1705;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomarePelak" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">&#1588;&#1605;&#1575;&#1585;&#1607; &#1605;&#1608;&#1578;&#1608;&#1585;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomareMotor" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">&#1588;&#1605;&#1575;&#1585;&#1607; &#1588;&#1575;&#1587;&#1610;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomareShasi" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">&#1711;&#1575;&#1585;&#1575;&#1606;&#1578;&#1610;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="garantee"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">&#1578;&#1575;&#1585;&#1610;&#1582; &#1575;&#1606;&#1602;&#1590;&#1575;&#1610; &#1711;&#1575;&#1585;&#1575;&#1606;&#1578;&#1610;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="tarikhEnghezaGarantee"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">&#1606;&#1581;&#1608;&#1607; &#1662;&#1585;&#1583;&#1575;&#1582;&#1578; &#1607;&#1586;&#1610;&#1606;&#1607;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="nahvePardakht"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">&#1588;&#1605;&#1575;&#1585;&#1607; &#1601;&#1610;&#1588;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomareFish" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">&#1578;&#1575;&#1585;&#1610;&#1582; &#1601;&#1610;&#1588;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="tarikhFish"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">&#1606;&#1575;&#1605; &#1588;&#1593;&#1576;&#1607;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="nameShobe" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">&#1607;&#1586;&#1610;&#1606;&#1607; &#1662;&#1585;&#1583;&#1575;&#1582;&#1578; &#1588;&#1583;&#1607;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="hazineh" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تبديل به مشترک:</td>
						<td width="5%"></td>
						<td class="readData"><a href="javascript:doAccept();" >   قبول   </a></td>
					</tr>

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.darkhastEshterakForm);
	setEntity("DarkhastEshterak");
</script>
		<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
