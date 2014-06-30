<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<logic:equal name="darkhastEshterakForm" property="action_type" value="create" >
	<table width="100%" align="center"  border="0" cellpadding="4" cellspacing="0" class="generalText">
		<tr>
			<td align="center">در صورت تمايل به مشترک شدن و استفاده از سرويسهاي امداد خودرو   	</td>
		</tr>
		<tr>
			<td align="center">&nbsp;&nbsp;&nbsp;فرم زير را پر کرده و کليد ثبت را فشار دهيد:</td>
		</tr>
	</table>
</logic:equal>
<html:form method="post" action="/c/validatedarkhastEshterak" onsubmit="return validateDarkhastEshterakForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نوع سرويس درخواستي:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="noeService" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="noeServiceList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1606;&#1575;&#1605; &#1582;&#1575;&#1606;&#1608;&#1575;&#1583;&#1711;&#1610;:</td>
						<td class="editStar">*</td>
						<td> <html:text property="nameKhanevadegi" size="20" maxlength="20" onkeypress="return submitenter(this,event)" styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1606;&#1575;&#1605;:</td>
						<td class="editStar">*</td>
						<td> <html:text property="nameMoshtarak" size="20" maxlength="20"  onkeypress="return submitenter(this,event)" styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1578;&#1575;&#1585;&#1610;&#1582; &#1578;&#1608;&#1604;&#1583;:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tarikhTavalod" size="10" maxlength="10"  styleClass="field" /><jsp:include page="/com/objectj/resources/jsp/tiles/emdad/samp-date.jsp" flush="true" /></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1570;&#1583;&#1585;&#1587;:</td>
						<td class="editStar">*</td>
						<td> <html:text property="addressMoshtarak" size="80" maxlength="80"  onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1705;&#1583; &#1662;&#1587;&#1578;&#1610;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="codePost" size="10" maxlength="10"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1606;&#1575;&#1605; &#1588;&#1607;&#1585;:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="shahrId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="shahrList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1662;&#1587;&#1578; &#1575;&#1604;&#1705;&#1578;&#1585;&#1608;&#1606;&#1610;&#1705;&#1610;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="emailMoshtarak" size="50" maxlength="50"   styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1578;&#1604;&#1601;&#1606;:</td>
						<td class="editStar">*</td>
						<td> <html:text property="telMoshtarak" size="25" maxlength="50"   styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1578;&#1604;&#1601;&#1606; &#1607;&#1605;&#1585;&#1575;&#1607;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="mobileMoshtarak" size="50" maxlength="50"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1606;&#1608;&#1593; &#1582;&#1608;&#1583;&#1585;&#1608;:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="noeKhodroId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="noeKhodroList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1585;&#1606;&#1711; &#1582;&#1608;&#1583;&#1585;&#1608;:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="rangeKhodroId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="rangeKhodroList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1587;&#1575;&#1604; &#1587;&#1575;&#1582;&#1578; :</td>
						<td class="editStar">*</td>
						<td> <html:text property="saleSakht" size="5" maxlength="5"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1588;&#1605;&#1575;&#1585;&#1607; &#1662;&#1604;&#1575;&#1705;:</td>
						<td class="editStar">*</td>
						<td> <html:text property="shomarePelak" size="7" maxlength="6" onkeypress="return submitenter(this,event)"/><html:text property="shomarePelak2" size="20" maxlength="18" onkeypress="return submitenter(this,event)" /></td>
						<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/samp-pelak.jsp" flush="true" />
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1588;&#1605;&#1575;&#1585;&#1607; &#1605;&#1608;&#1578;&#1608;&#1585;:</td>
						<td class="editStar">*</td>
						<td> <html:text property="shomareMotor" size="20" maxlength="20"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1588;&#1605;&#1575;&#1585;&#1607; &#1588;&#1575;&#1587;&#1610;:</td>
						<td class="editStar">*</td>
						<td> <html:text property="shomareShasi" size="20" maxlength="20"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1711;&#1575;&#1585;&#1575;&#1606;&#1578;&#1610;:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="garantee" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="garanteeList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1578;&#1575;&#1585;&#1610;&#1582; &#1575;&#1606;&#1602;&#1590;&#1575;&#1610; &#1711;&#1575;&#1585;&#1575;&#1606;&#1578;&#1610;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="tarikhEnghezaGarantee" size="10" maxlength="10"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1606;&#1581;&#1608;&#1607; &#1662;&#1585;&#1583;&#1575;&#1582;&#1578; &#1607;&#1586;&#1610;&#1606;&#1607;:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="nahvePardakht" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="nahvePardakhtList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1588;&#1605;&#1575;&#1585;&#1607; &#1601;&#1610;&#1588;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="shomareFish" size="15" maxlength="15"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1578;&#1575;&#1585;&#1610;&#1582; &#1601;&#1610;&#1588;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="tarikhFish" size="10" maxlength="10"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1606;&#1575;&#1605; &#1588;&#1593;&#1576;&#1607;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="nameShobe" size="40" maxlength="40"  onkeypress="return submitenter(this,event)"  styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1607;&#1586;&#1610;&#1606;&#1607; &#1662;&#1585;&#1583;&#1575;&#1582;&#1578; &#1588;&#1583;&#1607;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="hazineh" size="8" maxlength="7"  styleClass="field" /> </td>
					</tr>

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
	setForm(document.darkhastEshterakForm);
	setEntity("DarkhastEshterak");
    if (document.darkhastEshterakForm.action_type.value=="create")
	{
        document.darkhastEshterakForm.action="/emdad/c/validatedarkhastEshterak.run";
    }

	else
	{
        document.darkhastEshterakForm.action="/emdad/u/validatedarkhastEshterak.run";
    }


</script>
<html:javascript formName="darkhastEshterakForm" />
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
