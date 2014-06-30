<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<script>
	function moshtarakSearch() {
		doSearchAndHide("showMoshtari",
			 "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/moshtarak.run?action_type=specific,find",
			 document.tamdidEshterakForm,
			 "dimg1");
	}

	function moshtarakDetails() {
		//alert (document.tamdidEshterakForm.eshterakId.value);
		showDetail(document.tamdidEshterakForm.eshterakId,
			null,
			"dimg1",
			"showMoshtari",
			"mdtl",
			"/emdad/s/moshtarak.run?action_type=specific,moshtarakShow") ;
	}

	var lastCreator;
	function moshtarakEdit(){
		args = "width=600, height=600 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "read";
			win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/moshtarak.run&action_type=specific,edit_by_eshterak_id&id="+document.tamdidEshterakForm.eshterakId.value, windowTitle,args);
		win3.creator=window;
		win3.focus();
		clearRefresh();
	}

</script>


<html:base/>
<body onkeydown="Sabt()"/>
<html:form method="post" action="/c/validatetamdidEshterak" onsubmit="return validateTamdidEshterakForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">شماره اشتراک:</td>
						<td class="editStar">*</td>
						<td>
							<html:text property="eshterakId" size="15" maxlength="10" onkeypress="return submitenter(this,event)" onchange="valueChanged(this)"/>
							<a href="javascript:moshtarakDetails()" ><img src="images/show-on.gif" border="0" id="dimg1"></a>
							&nbsp;
							<input type="button" value="جستجو" onClick="javascript:moshtarakSearch();" />
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td colspan="3">
							<div style="display:none;height:100px;" id="showMoshtari">
								<iframe width="100%" height="100%" src="" frameborder="1" name="mdtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
                        		
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تاريخ تمديد:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tarikhAkharinTamdid" size="10" maxlength="10"  /><jsp:include page="/com/objectj/resources/jsp/tiles/emdad/samp-date.jsp" flush="true" /></td>
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
						<td class="editLabel">هزينه پرداخت شده:</td>
						<td class="editStar">*</td>
						<td> <html:text property="hazinehPardakhtShodeh" size="10" maxlength="10"/> </td>
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

<%
    request.setAttribute("additional" , "<input type=\"button\" value=\"&#1608;&#1740;&#1585;&#1575;&#1740;&#1588; &#1605;&#1588;&#1578;&#1585;&#1705;\" onClick=\"javascript:moshtarakEdit();\" class=\"emdadButton\"> ");
%>
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
	setForm(document.tamdidEshterakForm);
	setEntity("TamdidEshterak");
    if (document.tamdidEshterakForm.action_type.value=="create")
	{
        document.tamdidEshterakForm.action="/emdad/c/validatetamdidEshterak.run";
    }

	else
	{
        document.tamdidEshterakForm.action="/emdad/u/validatetamdidEshterak.run";
    }
	document.tamdidEshterakForm.eshterakId.changed = true;
</script>
<html:javascript formName="tamdidEshterakForm" />
