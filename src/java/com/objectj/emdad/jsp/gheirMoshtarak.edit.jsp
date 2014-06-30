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

</HEAD>


<body onkeydown="Sabt()"/>


<html:base/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/validate.jsp" flush="true" />

<input type="hidden" name="helpUrl" value="/emdad/com/objectj/resources/jsp/help/gheireMoshtarak.create.help.html"/>

<html:form method="post" action="/u/validatemoshtarak" onsubmit="return validateMoshtarakForm(this)">
    <input type="hidden" name="isList" value="<bean:write name="isList" />" />
	<html:hidden property="tarikhTavalod" value="1380/01/01"/>
	<html:hidden property="address" value="-"/>
	<html:hidden property="postCode"/>
	<html:hidden property="shahrId" value="808080808080808480"/>
	<html:hidden property="email" />
	<html:hidden property="mobile" />
	<html:hidden property="noeEshterak" value="1"/>
	<html:hidden property="noeService" value="2"/>
	<html:hidden property="vazeat" value="1"/>
	<html:hidden property="shomareMotor"  value="4344354"/>
	<html:hidden property="shomareVIN"  />
	<html:hidden property="tarikhShoro" value="1380/01/01"/>
	<html:hidden property="tarikhAkharinTamdid"  />
	<html:hidden property="tarikhEngheza"  value="1380/01/01" />
	<html:hidden property="tarikhTahvil" />
	<html:hidden property="guarantee" value="2"/>
	<html:hidden property="tarikhEnghezaGuarantee" />
	<html:hidden property="bazaryabId" value="508180808080808280o"/>
	<html:hidden property="tarikhServiceAvalieh"  />
	<html:hidden property="mahaleServiceAvalieh" />
	<html:hidden property="moshtarakYaNa" value="2"/>
	<!-- html : hidden property="shomareShasi" value="4344354" / -->
	<html:hidden property="hazinehPardakhtShodeh" value="0"/>
	<html:hidden property="namayandegi" value="0"/>
	<html:hidden property="takhfif" value="0"/>
	<html:hidden property="naghd" value="0"/>
	<html:hidden property="taahodi" value="0"/>
	<html:hidden property="aghsat" value="0"/>
	<html:hidden property="name" value="-"/>
	<html:hidden property="tel" value="-"/>

	<table width="100%" dir=rtl class="generalText">

<% boolean canChange = request.getParameter("action_type").equals("edit_by_id"); %>
		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شماره اشتراک:</td>
						<td class="editStar"> </td>
						<td> <html:text property="eshterakId" size="10" maxlength="10" onkeypress="return submitenter(this,event)" readonly="true"/> </td>
					</tr>


					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره شاسي:</td>
						<td class="editStar">*</td>
						<td> <html:text property="shomareShasi" size="20" maxlength="20" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->


					<tr class="editRow0">
						<td class="editLabel">نام خانوادگي:</td>
						<td class="editStar">*</td>
						<td> <html:text property="nameKhanevadegi" size="30" maxlength="40" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<!--<tr class="editRow1">
						<td class="editLabel">نام:</td>
						<td class="editStar">*</td>
						<td> <html:text property="name" size="20" maxlength="20" onkeypress="return submitenter(this,event)"/> </td>
					</tr>-->

					<!----------------------------------------->

					<!--<tr class="editRow0">
						<td class="editLabel">تلفن:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tel" size="50" maxlength="50" onkeypress="return submitenter(this,event)"/> </td>
					</tr>-->

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نوع خودرو:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="noeKhodroId" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()" size="1" disabled="<%= canChange %>" >
								<html:options collection="noeKhodroList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">رنگ خودرو:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="rangeKhodroId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
								<html:options collection="rangeKhodroList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->
					<tr class="editRow1">
						<td class="editLabel">سال ساخت خودرو:</td>
						<td class="editStar">*</td>
						<td> <html:text property="saleSakht" size="4" maxlength="4"  readonly="<%=canChange%>"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شماره پلاک:</td>
						<td class="editStar">*</td>
						<td> 
							<html:text property="shomarePelak" size="8" maxlength="6" onkeypress="return submitenter(this,event)"/>
							<html:text property="shomarePelak2" size="12" maxlength="10" onkeypress="return submitenter(this,event)" />
						</td>
						<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/samp-pelak.jsp" flush="true" />
					</tr>

					<!----------------------------------------->
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
					<!----------------------------------------->

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
    if (document.moshtarakForm.action_type.value == "specific,taeedghCreate")
        document.moshtarakForm.action="/emdad/s/validatemoshtarak.run";
	else
        document.moshtarakForm.action="/emdad/u/validatemoshtarak.run";
</script>
<html:javascript formName="moshtarakForm" />
<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
