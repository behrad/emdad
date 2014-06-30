<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<script>
    function checkSabt(elem) {
        elem.disabled = true;
//        top.creator.click();
//		top.close();
        theForm.submit();
    }

    function CloseWindow(){
        close();
    }
	function emdadDetails() {
		showDetail(document.khodrojagozinMasrafForm.emdadEmdadId,
			null,
			"dimg1",
			"showEmdad",
			"edtl",
			"/emdad/s/emdad.run?action_type=specific,emdadShow") ;
	}

	function emdadSearch() {
		doSearchAndHide("showEmdad",
				 "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/emdad.run?action_type=specific,find4%26noeEmdad4=4",
				 document.khodrojagozinMasrafForm,
				 "dimg1");
	}

	function khodrojagozinDetails() {
		showDetail(document.khodrojagozinMasrafForm.khodrojagozinId,
				null,
				"dimg2",
				"showKhodrojagozin",
				"kdtl",
				"/emdad/s/khodrojagozin.run?action_type=specific,khodrojagozinShow") ;
	}

	var lastCreator;
</script>


<html:base/>

<html:form method="post" action="/c/validatekhodrojagozinMasraf" onsubmit="return validateKhodrojagozinMasrafForm(this)">

	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">


					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">دستورکار:</td>
						<td class="editStar">*</td>
						<td class="readData">
		                    <logic:equal name="khodrojagozinMasrafForm" property="action_type" value="update">
								<bean:write property="emdadEmdadId" name="khodrojagozinMasrafForm"/>
								<html:hidden property="emdadEmdadId"/>
							</logic:equal>

		                    <logic:equal name="khodrojagozinMasrafForm" property="action_type" value="create">
								<html:text property="emdadEmdadId" size="11" maxlength="11" styleClass="field" onchange="valueChanged(this)"/>
							</logic:equal>

							&nbsp;
							<a href="javascript:emdadDetails()" ><img src="images/show-on.gif" border="0" id="dimg1"></a>

		                    <logic:equal name="khodrojagozinMasrafForm" property="action_type" value="create">
								<input type="button" value="جستجو" onClick="javascript:emdadSearch();" />
							</logic:equal>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td colspan="3">
							<div style="display:none;height:100px;" id="showEmdad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="edtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

						<tr class="editRow1">
							<td class="editLabel">خودرو جایگزین:</td>
							<td class="editStar">*</td>
							<td class="readData">
				             <logic:equal name="khodrojagozinMasrafForm" property="action_type" value="create">
								<html:select property="khodrojagozinId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
									<html:options collection="khodrojagozinList_faal" property="eid" labelProperty="name" />
								</html:select>
						</logic:equal>
		        		     <logic:notEqual name="khodrojagozinMasrafForm" property="action_type" value="create">
					 	<html:hidden property="khodrojagozinId" /><bean:write name="shomarehPelak" />
					</logic:notEqual>
							</td>
						</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تاریخ تحویل دادن به مشتری:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tarikhTahvilBeMoshtari" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">زمان تحویل دادن به مشتری:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tarikhTahvilBeMoshtari2" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->
                    <logic:notEqual name="khodrojagozinMasrafForm" property="action_type" value="create">
                        <tr class="editRow0">
                            <td class="editLabel">تاریخ تحویل  گرفتن از مشتری:</td>
                            <td class="editStar"> </td>
                            <td> <html:text property="tarikhTahvilAzMoshtari" size="10" maxlength="10" styleClass="field"/> </td>
                        </tr>

                        <!----------------------------------------->
                        <tr class="editRow1" >
                            <td class="editLabel">زمان تحویل  گرفتن از مشتری:</td>
                            <td class="editStar"> </td>
                            <td> <html:text property="tarikhTahvilAzMoshtari2" size="10" maxlength="10" styleClass="field"/> </td>
                        </tr>
						<tr span class="fieldDescription" bgcolor="#DADEDC">
							<td colspan="3">در صورت وارد کردن فيلد تاريخ تحويل گرفتن از مشتري, اين فرآيند خودروي جايگزين خاتمه يافته و ديگر قابل تغيير نيست.</td>
						</tr>
                    </logic:notEqual>
                    <html:hidden property="tarikhTahvilBeMoshtari" />
                    <html:hidden property="tarikhTahvilBeMoshtari2"/>

<tr align="left">
	<td height="70" colspan="20" align="center">
		<html:hidden property="action_type" />
		<html:hidden property="id" />
		<html:hidden property="curpage" />
		<html:hidden property="order"/>
		<html:hidden property="sorttype" />
		<input type="button" value="ثبت" class="emdadButton" onClick="javascript:checkSabt(this);"/>&nbsp;&nbsp;
		<html:reset  value="حالت اول" styleClass="emdadButton" />&nbsp;&nbsp;
		<input type="button" value="انصراف" class="emdadButton" onClick="javascript:CloseWindow();"/>&nbsp;&nbsp;
		&nbsp;&nbsp;<a href="javascript:help();">راهنما</a>&nbsp;&nbsp;
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
	setForm(document.khodrojagozinMasrafForm);
	setEntity("KhodrojagozinMasraf");
	document.khodrojagozinMasrafForm.emdadEmdadId.changed = true;
	document.khodrojagozinMasrafForm.khodrojagozinId.changed = true;

    if (document.khodrojagozinMasrafForm.action_type.value=="create")
	{
        document.khodrojagozinMasrafForm.action="/emdad/c/validatekhodrojagozinMasraf.run";
    }

	else
	{
        document.khodrojagozinMasrafForm.action="/emdad/u/validatekhodrojagozinMasraf.run";
    }
</script>
<html:javascript formName="khodrojagozinMasrafForm" />
