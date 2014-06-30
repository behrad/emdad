<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Sabt()"/>
﻿<html:form method="post" action="/c/validatenamayandegi" onsubmit="return validateNamayandegiForm(this)">

<head>
</head>

	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شناسه نمايندگي:</td>
						<td class="editStar">*</td>
						<td> <html:text property="namayandegiId" size="8" maxlength="7"  styleClass="field" /> 
<html:hidden property="karDarDast" />
<html:hidden property="karDarDast2" />
</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1606;&#1575;&#1605; &#1606;&#1605;&#1575;&#1610;&#1606;&#1583;&#1711;&#1610;:</td>
						<td class="editStar">*</td>
						<td> <html:text property="name" size="50" maxlength="50" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نوع نمايندگي:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="noeNamayandegi" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="noeNamayandegiList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

 					<tr class="editRow0">
						<td class="editLabel">نام شهر:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="shahrId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
							<html:options collection="shahrList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">کد منطقه:</td>
						<td class="editStar"> </td>
						<td> <html:text property="codeMantaghe" size="5" maxlength="5"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1578;&#1604;&#1601;&#1606;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="namayandegiTel" size="50" maxlength="50"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تلفن ضروري:</td>
						<td class="editStar"> </td>
						<td> <html:text property="telZaroori" size="50" maxlength="50"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1605;&#1608;&#1576;&#1575;&#1610;&#1604;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="namayandegiMobile" size="50" maxlength="50"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1601;&#1575;&#1705;&#1587;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="namayandegiFax" size="20" maxlength="20"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1570;&#1583;&#1585;&#1587;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="namayandegiAddress" size="80" maxlength="80"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">آدرس پست الکترونيکي:</td>
						<td class="editStar"> </td>
						<td> <html:text property="email" size="50" maxlength="50"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1575;&#1605;&#1583;&#1575;&#1583;&#1711;&#1585;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="emdadgar" size="30" maxlength="30" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1606;&#1608;&#1593; &#1582;&#1608;&#1583;&#1585;&#1608; &#1575;&#1605;&#1583;&#1575;&#1583;:</td>
						<td class="editStar"></td>
						<td>
							<html:select property="noeKhodroId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
							<html:options collection="noeKhodroList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نام دفتر استاني:</td>
						<td class="editStar"> * </td>
						<td>
							<html:select property="daftarOstaniId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
							<html:options collection="daftarOstaniList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->
					<tr class="editRow0">
						<td class="editLabel">&#1578;&#1575;&#1585;&#1610;&#1582; &#1578;&#1581;&#1608;&#1610;&#1604; &#1582;&#1608;&#1583;&#1585;&#1608;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="tarikhTahvil" size="10" maxlength="10"  styleClass="field" /><jsp:include page="/com/objectj/resources/jsp/tiles/emdad/samp-date.jsp" flush="true" /></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1587;&#1575;&#1576;&#1602;&#1607; &#1601;&#1593;&#1575;&#1604;&#1610;&#1578;:</td>
						<td class="editStar"> </td>
						<td>
							<html:select property="sabegheFaaliat" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
							<html:options collection="sabegheFaaliatList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1587;&#1575;&#1576;&#1602;&#1607; &#1601;&#1593;&#1575;&#1604;&#1610;&#1578; &#1606;&#1608;&#1585;&#1608;&#1586;&#1610;:</td>
						<td class="editStar"> </td>
						<td>
							<html:select property="sabegheNoroozi" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
							<html:options collection="sabegheNorooziList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1578;&#1575;&#1585;&#1610;&#1582; &#1593;&#1602;&#1583; &#1602;&#1585;&#1575;&#1585;&#1583;&#1575;&#1583;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="tarikhGharardad" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1588;&#1605;&#1575;&#1585;&#1607; &#1602;&#1585;&#1575;&#1585;&#1583;&#1575;&#1583;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="shomarehGharardad" size="15" maxlength="15"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1605;&#1581;&#1583;&#1608;&#1583;&#1607; &#1578;&#1581;&#1578; &#1662;&#1608;&#1588;&#1588;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="tahtePooshesh" size="80" maxlength="80"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1606;&#1592;&#1585;&#1610;&#1607; &#1575;&#1610;&#1587;&#1575;&#1705;&#1608;:</td>
						<td class="editStar"> </td>
						<td>
							<html:select property="nazarIsaco" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
							<html:options collection="nazarIsacoList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->
					<tr class="editRow1">
						<td class="editLabel">تاريخ آخرين استعلام:</td>
						<td class="editStar"> </td>
						<td> <html:text property="tarikhAkharinEstelam" size="15" maxlength="15"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">&#1608;&#1590;&#1593;&#1610;&#1578; &#1601;&#1593;&#1604;&#1610; &#1602;&#1585;&#1575;&#1585;&#1583;&#1575;&#1583;:</td>
						<td class="editStar"> </td>
						<td>
							<html:select property="vazGharardad" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
							<html:options collection="vazGharardadList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">&#1575;&#1608;&#1604;&#1608;&#1610;&#1578;:</td>
						<td class="editStar"> </td>
						<td> <html:text property="olaviat" size="5" maxlength="5"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">سقف ريالي:</td>
						<td class="editStar">*</td>
						<td> <html:text property="saghfeRiali" size="10" maxlength="9"  styleClass="field" />&nbsp;<span class="fieldDescription">ريال</span> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">حداکثر تعداد کار ارجاعي امدادي:</td>
						<td class="editStar">*</td>
						<td> <html:text property="hadaksarKar" size="10" maxlength="5"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel"> حداکثر تعداد کار ارجاعي تعميراتي:</td>
						<td class="editStar">*</td>
						<td> <html:text property="hadaksarKar2" size="10" maxlength="5"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">دستگاه عيب ياب:</td>
						<td class="editStar"> </td>
						<td> <html:text property="dastgahEybyab" size="50" maxlength="50"  styleClass="field" /> </td>
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
	setForm(document.namayandegiForm);
	setEntity("Namayandegi");
    if (document.namayandegiForm.action_type.value=="create")
	{
        document.namayandegiForm.action="/emdad/c/validatenamayandegi.run";
    }

	else
	{
        document.namayandegiForm.action="/emdad/u/validatenamayandegi.run";
    }
</script>
<html:javascript formName="namayandegiForm" />
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
