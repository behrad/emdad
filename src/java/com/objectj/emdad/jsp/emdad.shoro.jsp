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
<title></title>
<html:base/>


<script>
    function checkSabt(elem) {
        elem.disabled = true;
        //top.creator.click();
//		top.close();
        theForm.submit();
    }

	function rokhdadDetails() {
		showDetail(document.emdadForm.rokhdadId,
				null,
				"dimg1",
				"showRokhdad",
				"rdtl",
				"/emdad/s/rokhdad.run?action_type=specific,rokhdadShow") ;
	}

	var lastCreator;
</script>

<center>
	<span class="tilesHeader">شروع امداد</span>
</center>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/validate.jsp" flush="true" />

<html:form method="post" action="/s/validateEmdad" onsubmit="return validateEmdadForm(this)">
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/moshtarak.info.jsp" flush="true" />
<br>
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<html:hidden property="emdadId" />
					<html:hidden property="zamanEzam" />
					<html:hidden property="zamanEzam2" />
					<html:hidden property="zamanPayan" value="1500/1/1" />
					<html:hidden property="zamanPayan2" value = "12:30"/>
					<html:hidden  property="zamanVagheiEzam" />
					<html:hidden  property="zamanVagheiShoro" />
					<html:hidden  property="zamanVagheiPayan" />
					<html:hidden  property="vazeatKhedmatId" />
					<html:hidden  property="ezamgarId" />
					<html:hidden  property="emdadgarId" />
					<html:hidden  property="vazeatKonuni" />
					<html:hidden  property="rokhdadId" />
					<html:hidden  property="namayandegiId" />
					<html:hidden  property="ameliyatMojaz" />
					<html:hidden property="emdadgarIdGhabli" />
					<html:hidden property="namayandegiIdGhabli" />
					<html:hidden property="maliDone" />

					<html:hidden  property="zamanVagheiEzam2" />
					<html:hidden  property="zamanVagheiShoro2" />
					<html:hidden  property="zamanVagheiPayan2" />

					<html:hidden property="noeEmdad" />
					<html:hidden property="hazinehJarsaghil" value="1"/>
					<html:hidden property="hazinehBoxel" value="1"/>
					<html:hidden property="modatTamir"/>
			                <html:hidden property="dastoorKarGhabli" />
                    			<html:hidden property="vazeatDakheli" />
					<html:hidden property="rahAndazi" value = "du"/>
					<html:hidden property="elateService" />
					<html:hidden property="guarantee" />
					<html:hidden property="noeKhedmateVije" />

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">کد مورد:</td>
						<td class="editStar"> </td>
						<td class="readData">
							<%= request.getAttribute("rokhdadRokhdadId")%>
							<% request.setAttribute("rokhdadRokhdadId", request.getAttribute("rokhdadRokhdadId")); %>
							<a href="javascript:rokhdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td colspan="3">
							<div   style="display:none;height:100px;" id="showRokhdad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="rdtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>


					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">زمان اعزام:</td>
						<td class="editStar"> </td>
						
						<td class="readData"><bean:write property="zamanEzamHejri"  name="emdadForm" /></td>
						
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">زمان شروع:</td>
						<td class="editStar">*</td>
						<td> <html:text property="zamanShoro2" size="10" maxlength="10" styleClass="field"/></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تاريخ شروع:</td>
						<td class="editStar">*</td>
						<td> <html:text property="zamanShoro" size="10" maxlength="10" styleClass="field" /> </td>
					</tr>


					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">کيلومتر کارکرد:</td>
						<td class="editStar">*</td>
						<td> <html:text property="kilometerKarkard" size="9" maxlength="9" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">فاصله از نمايندگي:</td>
						<td class="editStar">*</td>
						<td><html:text property="faseleAzNamayandegi"  size="5" maxlength="4" styleClass="field" /></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">توضيحات:</td>
						<td class="editStar"></td>
						<td> <html:textarea property="tozihat" styleClass="field" rows="3" cols="50" onkeypress="return submitenter2(this,event) && checkLength(256)"/></td>
					</tr>
					<!----------------------------------------->

					<tr align="left">
						<td height="70" colspan="20" align="center">
							<html:hidden property="action_type" />
							<html:hidden property="id" />
							<html:hidden property="curpage" />
							<html:hidden property="order"/>
							<html:hidden property="sorttype" />
							<input type="button" value="شروع" class="emdadButton" onClick="javascript:checkSabt(this);"/>&nbsp;&nbsp;
							<html:reset  value="حالت اول" styleClass="emdadButton" />&nbsp;&nbsp;
							<input type="button" value="انصراف" class="emdadButton" onclick="javascript:SureCancle2();">&nbsp;&nbsp;
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/help.jsp" flush="true">
   <jsp:param name="help_url" value="emdad.shoro.help.html" />	
</jsp:include>
						</td>
					</tr>

					<!----------------------------------------->

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
	setForm(document.emdadForm);
	setEntity("Emdad");
	document.emdadForm.rokhdadId.changed = true;
</script>
<html:javascript formName="emdadForm" />
