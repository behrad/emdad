<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:form method="post" action="/s/moshtariDarkhastEshterak" onsubmit="return validateDarkhastEshterakForm(this)">
<input type="hidden" name="helpUrl" value=''/>
	<center>
		<span class="tilesHeader">در صورت تمايل به مشترک شدن و استفاده از سرويسهاي<br> امداد خودرو فرم زير را پر کرده و کليد ثبت را فشار دهيد:</span>
	</center>
	<br><br>
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
							<html:select property="noeService" size="1">
								<html:options collection="noeServiceList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نام خانوادگي :</td>
						<td class="editStar">*</td>
						<td> <html:text property="nameKhanevadegi" size="20" maxlength="20" onkeypress="return submitenter(this,event)" styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نام :</td>
						<td class="editStar">*</td>
						<td> <html:text property="nameMoshtarak" size="20" maxlength="20"  onkeypress="return submitenter(this,event)" styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تاريخ تولد :</td>
						<td class="editStar">*</td>
						<td> <html:text property="tarikhTavalod" size="10" maxlength="10"  styleClass="field" /><jsp:include page="/com/objectj/resources/jsp/tiles/emdad/samp-date.jsp" flush="true" /></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">آدرس :</td>
						<td class="editStar">*</td>
						<td> <html:text property="addressMoshtarak" size="80" maxlength="80"  onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">کد پستي :</td>
						<td class="editStar"> </td>
						<td> <html:text property="codePost" size="10" maxlength="10"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شهر :</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="shahrId" size="1">
								<html:options collection="shahrList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">آدرس پست الکترونيکي :</td>
						<td class="editStar"> </td>
						<td> <html:text property="emailMoshtarak" size="50" maxlength="50"   styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تلفن :</td>
						<td class="editStar">*</td>
						<td> <html:text property="telMoshtarak" size="25" maxlength="50"   styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تلفن همراه :</td>
						<td class="editStar"> </td>
						<td> <html:text property="mobileMoshtarak" size="50" maxlength="50"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نوع خودرو :</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="noeKhodroId" size="1">
								<html:options collection="noeKhodroList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">رنگ خودرو :</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="rangeKhodroId" size="1">
								<html:options collection="rangeKhodroList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">سال ساخت :</td>
						<td class="editStar">*</td>
						<td> <html:text property="saleSakht" size="5" maxlength="5"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره پلاک :</td>
						<td class="editStar">*</td>
						<td>
							<html:text property="shomarePelak" size="8" maxlength="6" onkeypress="return submitenter(this,event)"/>
							<html:text property="shomarePelak2" size="12" maxlength="10" onkeypress="return submitenter(this,event)" />
						</td>
						<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/samp-pelak.jsp" flush="true" />
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شماره موتور :</td>
						<td class="editStar">*</td>
						<td> <html:text property="shomareMotor" size="20" maxlength="20"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره بدنه :</td>
						<td class="editStar">*</td>
						<td> <html:text property="shomareShasi" size="20" maxlength="20"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">گارانتي ؟</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="garantee" size="1">
								<html:options collection="garanteeList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تاريخ انقضاء گارانتي :</td>
						<td class="editStar"> </td>
						<td> <html:text property="tarikhEnghezaGarantee" size="10" maxlength="10"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نحوه پرداخت :</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="nahvePardakht" size="1">
								<html:options collection="nahvePardakhtList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شماره فيش بانکي :</td>
						<td class="editStar"> </td>
						<td> <html:text property="shomareFish" size="15" maxlength="15"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تاريخ فيش :</td>
						<td class="editStar"> </td>
						<td> <html:text property="tarikhFish" size="10" maxlength="10"  styleClass="field" /> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">نام و کد شعبه :</td>
						<td class="editStar"> </td>
						<td> <html:text property="nameShobe" size="40" maxlength="40"  onkeypress="return submitenter(this,event)"  styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">هزينه پرداختي :</td>
						<td class="editStar"> </td>
						<td> <html:text property="hazineh" size="8" maxlength="7"  styleClass="field" /> </td>
					</tr>

<%
    request.setAttribute("additional" , "<input type=\"button\" name=\"btnCancel\" value=\"\" onClick=\"javascript:chkCancel();\" class=\"emdadButton\"> ");
%>
					<!----------------------------------------->
				    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/edit-but.jsp" flush="true" />
					<!----------------------------------------->

				</table>
			</td>
		</tr>
  </table>
</html:form>

<!----------------------------------------->

<script type="text/javascript" language="Javascript1.1">
	setForm(document.darkhastEshterakForm);
	setEntity("DarkhastEshterak");

    document.darkhastEshterakForm.btnCancel.value = "انصراف";
    document.darkhastEshterakForm.enserafBtn.style.display = "none";
    function chkCancel() {
	document.darkhastEshterakForm.action_type.value="specific,goHome";
        document.darkhastEshterakForm.submit();
    }
</script>
<html:javascript formName="darkhastEshterakForm" />
