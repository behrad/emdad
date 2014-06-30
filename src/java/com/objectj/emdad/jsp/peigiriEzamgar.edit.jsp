<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<script>
	function emdadDetails() {
		showDetail(document.peigiriEzamgarForm.emdadEmdadId,
			null,
			"dimg1",
			"showEmdad",
			"edtl",
			"/emdad/s/emdad.run?action_type=specific,emdadShow") ;
	}

	function emdadSearch() {
		s="1";
		doSearchAndHide("showEmdad", 
				 "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/emdad.run?action_type=specific,find%26vazeatKonuni="+s, 
				 document.peigiriEzamgarForm,
				 "dimg1");

		//args = "width=1000 , height=750 , resizable=yes, scrollbars=yes, status=0";
		//windowTitle = "Search";
		//obj = document.getElementById("showEmdad");
		//obj.style.display = "none";
		//s="1";
		//win2 = window.open("/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/emdad.run?action_type=specific,find%26vazeatKonuni="+s, windowTitle, args);
		//win2.creator=document.peigiriEzamgarForm;
	}

	var lastCreator;
</script>
<body onkeydown="Sabt()"/>

<html:form method="post" action="/c/validatepeigiriEzamgar" onsubmit="return validatePeigiriEzamgarForm(this)">
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
							 <html:text property="emdadEmdadId" size="11" maxlength="11" styleClass="field" onchange="valueChanged(this)"/>
							<a href="javascript:emdadDetails()" ><img src="images/show-on.gif" border="0" id="dimg1"></a>
							&nbsp;
							<input type="button" value="جستجو" onClick="javascript:emdadSearch();" />
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td colspan="3">
							<div style="display:none;height:100px;" id="showEmdad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="edtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تاريخ پي گيري:</td>
						<td class="editStar">*</td>
						<td> <html:text property="zamanPeigiri" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">زمان پی گیری:</td>
						<td class="editStar">*</td>
						<td> <html:text property="zamanPeigiri2" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نتیجه پی گیری:</td>
						<td class="editStar">*</td>
						<td> <html:text property="natije" size="80" maxlength="80" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td height="20" align="center" colspan="3">
							<span class="editRequired">توجه: متني که در اينجا نوشته مي شود توسط مشتري قابل مشاهده است.</span>
						</td>
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
	setForm(document.peigiriEzamgarForm);
	setEntity("PeigiriEzamgar");
    if (document.peigiriEzamgarForm.action_type.value=="create")
	{
        document.peigiriEzamgarForm.action="/emdad/c/validatepeigiriEzamgar.run";
    }

	else
	{
        document.peigiriEzamgarForm.action="/emdad/u/validatepeigiriEzamgar.run";
    }
	document.peigiriEzamgarForm.emdadEmdadId.changed = true;
</script>
<html:javascript formName="peigiriEzamgarForm" />
