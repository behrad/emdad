<!-- Start of head.jsp -->
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
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>

<script>
function Cancel(){
    if(document.moshtarakForm.isList.value == "close")
        SureCancle2();
    else
        SureCancle();
}
</script>

<body onkeydown="Sabt()"/>
<html:base/>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/validate.jsp" flush="true" />
<input type="hidden" name="helpUrl" value="/emdad/com/objectj/resources/jsp/help/gheireMoshtarak.create.help.html"/>

<html:form method="post" action="/c/validatemoshtarak" onsubmit="return validateMoshtarakForm(this)">
    <input type="hidden" name="isList" value="<bean:write name="isList" />" />
    <html:hidden property="moshtarakYaNa" value="1"/>
	<!--%="~~~~~~~~~~action_type: " + request.getParameter("action_type")%-->
    <% boolean canChange = request.getParameter("action_type").equals("edit_by_id"); %>
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شماره اشتراک:</td>
						<td class="editStar"> </td>
						<td> <html:text property="eshterakId" size="12" maxlength="10" onkeypress="return submitenter(this,event)" readonly="true"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نوع اشتراک:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="noeEshterak" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="noeEshterakList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نوع سرويس:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="noeService" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="noeServiceList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">مشترک مجازی؟:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="majaziYaNa" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="majaziYaNaList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">وضعيت اشتراک:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="vazeat" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="vazeatList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نام خانوادگي:</td>
						<td class="editStar">*</td>
						<td> <html:text property="nameKhanevadegi" size="30" maxlength="40" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نام:</td>
						<td class="editStar">*</td>
						<td> <html:text property="name" size="20" maxlength="20" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تاريخ تولد:</td>
						<td class="editStar"></td>
						<td> <html:text property="tarikhTavalod" size="10" maxlength="10" /><jsp:include page="/com/objectj/resources/jsp/tiles/emdad/samp-date.jsp" flush="true" /></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">آدرس:</td>
						<td class="editStar">*</td>
						<td> <html:text property="address" size="80" maxlength="80" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">کد پستي:</td>
						<td class="editStar"> </td>
						<td> <html:text property="postCode" size="10" maxlength="10" onkeypress="return submitenter(this,event)"/> </td>
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
						<td class="editLabel">پست الکترونيکي:</td>
						<td class="editStar"> </td>
						<td> <html:text property="email" size="50" maxlength="50" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تلفن:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tel" size="50" maxlength="50" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تلفن همراه:</td>
						<td class="editStar"></td>
						<td> <html:text property="mobile" size="50" maxlength="50" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نوع خودرو:</td>
						<td class="editStar">*</td>
						<td class="readData">
						<html:select property="noeKhodroId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
							<html:options collection="noeKhodroList" property="eid" labelProperty="name" />
						</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">رنگ خودرو:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="rangeKhodroId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="rangeKhodroList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">سال ساخت خودرو:</td>
						<td class="editStar">*</td>
						<td> <html:text property="saleSakht" size="4" maxlength="4"  readonly="<%=canChange%>"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره پلاک:</td>
						<td class="editStar">*</td>
						<td>
							<html:text property="shomarePelak" size="8" maxlength="6" onkeypress="return submitenter(this,event)"/>
							<html:text property="shomarePelak2" size="12" maxlength="10" onkeypress="return submitenter(this,event)" />
						</td>
						<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/samp-pelak.jsp" flush="true" />
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شماره موتور:</td>
						<td class="editStar">*</td>
						<td> <html:text property="shomareMotor" size="20" maxlength="20" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره شاسي:</td>
						<td class="editStar">*</td>
						<td> <html:text property="shomareShasi" size="20" maxlength="20" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">VIN شماره:</td>
						<td class="editStar"> </td>
						<td> <html:text property="shomareVIN" size="20" maxlength="20" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تاريخ شروع اشتراک:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tarikhShoro" size="10" maxlength="10"  /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تاريخ آخرين تمديد:</td>
						<td class="editStar"> </td>
						<td> <html:text property="tarikhAkharinTamdid" size="10" maxlength="10"  /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تاريخ انقضاي اشتراک:</td>
						<td class="editStar"></td>
						<td class="readData">
							<html:hidden property="tarikhEngheza" />
							<logic:equal name="moshtarakForm" property="action_type" value="create">
								يکسال پس از تاريخ شروع اشتراک
							</logic:equal>

							<logic:equal name="moshtarakForm" property="action_type" value="update">
								<bean:write property="tarikhEngheza" name="moshtarakForm" />
							</logic:equal>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تاريخ تحويل خودرو:</td>
						<td class="editStar"> </td>
						<td> <html:text property="tarikhTahvil" size="10" maxlength="10"  /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">ضمانت:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="guarantee" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="guaranteeList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تاريخ انقضاي ضمانت:</td>
						<td class="editStar"> </td>
						<td> <html:text property="tarikhEnghezaGuarantee" size="10" maxlength="10"  /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">بازارياب:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="bazaryabId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="bazaryabList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تاريخ سرويس اوليه:</td>
						<td class="editStar"> </td>
						<td> <html:text property="tarikhServiceAvalieh" size="10" maxlength="10"  /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">محل سرويس اوليه:</td>
						<td class="editStar"> </td>
						<td> <html:text property="mahaleServiceAvalieh" size="40" maxlength="40" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">هزينه پرداخت شده:</td>
						<td class="editStar">*</td>
						<td> <html:text property="hazinehPardakhtShodeh" size="10" maxlength="10"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نمايندگي:</td>
						<td class="editStar">*</td>
						<td> <html:text property="namayandegi" size="4" maxlength="4"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تخفیف:</td>
						<td class="editStar">*</td>
						<td> <html:text property="takhfif" size="10" maxlength="10"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نقد:</td>
						<td class="editStar">*</td>
						<td> <html:text property="naghd" size="10" maxlength="10"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تعهدی:</td>
						<td class="editStar">*</td>
						<td> <html:text property="taahodi" size="10" maxlength="10"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">جمع اقساط:</td>
						<td class="editStar">*</td>
						<td> <html:text property="aghsat" size="10" maxlength="10"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">چکها:</td>
						<td class="editStar"></td>
						<td> <html:textarea property="cheque" styleClass="field" rows="3" cols="50" onkeypress="return submitenter(this,event) && checkLength(80)"/> </td>
					</tr>


                    <tr align="left">
                        <td height="70" colspan="20" align="center">
                            <html:hidden property="action_type" />
                            <html:hidden property="id" />
                            <html:hidden property="curpage" />
                            <html:hidden property="order"/>
                            <html:hidden property="sorttype" />
                            <input type="submit" value="ثبت" class="emdadButton"/>&nbsp;&nbsp;
                            <html:reset  value="حالت اول" styleClass="emdadButton" />&nbsp;&nbsp;
                            <input type="button" value="انصراف"  class="emdadButton" onClick="javascript:Cancel();"/>&nbsp;&nbsp;
                            &nbsp;&nbsp;<a href="javascript:help();">راهنما</a>&nbsp;&nbsp;
                        </td>
                    </tr>

                    <tr align="center">
                        <td height="20" align="center" colspan="20">
                            <span class="editStar"> * </span> : <span class="editRequired">ورود داده الزامي است</span>
                        </td>
                    </tr>

				</table>
			</td>
		</tr>

		<!----------------------------------------->

  </table>
</html:form>

<!----------------------------------------->

<script type="text/javascript" language="Javascript1.1">
	setForm(document.moshtarakForm);
	setEntity("Moshtarak");
    if (document.moshtarakForm.action_type.value=="create")
        document.moshtarakForm.action="/emdad/c/validatemoshtarak.run";
	else
        document.moshtarakForm.action="/emdad/u/validatemoshtarak.run";
</script>
<html:javascript formName="moshtarakForm" />
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
