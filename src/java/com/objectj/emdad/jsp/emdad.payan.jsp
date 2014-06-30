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
	function addNew(s,elem) {
	//alert(s);
		s0 = document.emdadForm.emdadId.value;
		s1 = document.emdadForm.rokhdadId.value;
		s2 = document.emdadForm.rokhdadRokhdadId.value;
		s3 = document.emdadForm.rokhdadMoshtarakId.value;
		document.emdadForm.action="/emdad/s/validateEmdad.run?action_type=specific,taeedVaJadid&emdadId="+s0+"&rokhdadId="+s1+"&rokhdadRokhdadId="+s2+"&rokhdadMoshtarakId="+s3;
        elem.disabled = true;
//        top.creator.click();
//		top.close();
		document.emdadForm.submit();
	}
	
	function finish(s,elem)
	{
		s1 = document.emdadForm.rokhdadId.value;
		document.emdadForm.action="/emdad/s/validateEmdad.run?action_type=specific,taeedPayan&emdadId="+s+"&rokhdadId="+s1;
        elem.disabled = true;
  //      top.creator.click();
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
    <span class="tilesHeader"> پايان امداد</span>
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
					<html:hidden property="zamanShoro" />
					<html:hidden property="zamanShoro2" />
					<html:hidden property="zamanVagheiEzam" />
					<html:hidden property="zamanVagheiShoro" />
					<html:hidden property="zamanVagheiPayan" />

					<html:hidden  property="zamanVagheiEzam2" />
					<html:hidden  property="zamanVagheiShoro2" />
					<html:hidden  property="zamanVagheiPayan2" />
					<html:hidden property="maliDone" />

					<html:hidden property="vazeatKhedmatId" />
					<html:hidden property="ezamgarId" />
					<html:hidden property="emdadgarId" />
					<html:hidden property="emdadgarIdGhabli" />
					<html:hidden property="namayandegiIdGhabli" />
					
					<html:hidden property="vazeatKonuni" />
					<html:hidden property="rokhdadId" />
					<html:hidden property="hazinehAyyabZahab" />
					<html:hidden  property="ameliyatMojaz" />
					<html:hidden property="noeKhedmateVije" />

					<html:hidden property="noeEmdad" />
					<html:hidden property="hazinehJarsaghil" value="1"/>
					<html:hidden property="hazinehBoxel" value="1"/>
					<html:hidden property="modatTamir" />
					<html:hidden property="namayandegiId" />
						
                    			<html:hidden property="dastoorKarGhabli" />
			                <html:hidden property="vazeatDakheli" />
					<html:hidden property="guarantee" />
					<html:hidden property="kilometerKarkardGhabli" />

		<input type="hidden" name="rokhdadMoshtarakId" value='<bean:write name = "emdadForm" property="eshterakId" />' />
		<input type="hidden" name="rokhdadRokhdadId" value='<bean:write name = "emdadForm" property="rokhdadRokhdadId" />' />

			
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

					<tr class="editRow1">
						<td colspan="3">
							<div   style="display:none;height:100px;" id="showRokhdad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="rdtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td colspan="3">
							<div   style="display:none;height:100px;" id="showMoshtarak">
								<iframe width="100%" height="100%" src="" frameborder="1" name="mdtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تاريخ شروع:</td>
						<td class="editStar"></td>
						<td class="readData"> <bean:write property="zamanShoro" name="emdadForm"/></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">زمان شروع:</td>
						<td class="editStar"></td>
						<td class="readData"> <bean:write property="zamanShoro2" name="emdadForm"/></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تاريخ پايان:</td>
						<td class="editStar">*</td>
						<td> <html:text property="zamanPayan" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">زمان پايان:</td>
						<td class="editStar">*</td>
						<td> <html:text property="zamanPayan2" size="10" maxlength="10" styleClass="field"/></td>
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
						<td class="editLabel">&nbsp;مبلغ کل صورت حساب:</td>
						<td class="editStar"></td>
						<td> <html:text property="mablaghPardakhtShodeh" size="9" maxlength="9" styleClass="field"/>&nbsp;<span class="fieldDescription">ريال</span></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0" >
						<td class="editLabel">دليل طولاني شدن امداد:</td>
						<td class="editStar"></td>
						<td>
							<html:select property="dalileToolKeshidaneEmdadId" size="1" onkeypress="return fastCombo(this)" styleClass="generalText">
								<html:options collection="dalileToolKeshidaneEmdadList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">راه اندازي:</td>
						<td class="editStar">*</td>
						<td> <html:text property="rahAndazi" size="70" maxlength="120" styleClass="field" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">توضيحات:</td>
						<td class="editStar"></td>
						<td> <html:textarea property="tozihat" styleClass="field" rows="3" cols="50" onkeypress="return submitenter(this,event) && checkLength(160)"/></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">علت نياز به سرويس جديد:</td>
						<td class="editStar"></td>
						<td> <html:text property="elateService" size="50" maxlength="64" styleClass="field" onkeypress="return submitenter(this,event)"/> </td>
					</tr>

					<!----------------------------------------->

					<tr align="left">
						<td height="70" colspan="20" align="center">
							<html:hidden property="action_type" />
							<html:hidden property="id" />
							<html:hidden property="curpage" />
							<html:hidden property="order"/>
							<html:hidden property="sorttype" />
							<input type="button" value="پايان" class="emdadButton"  onClick='finish("<bean:write name="emdadForm" property="id" />",this);'/>&nbsp;&nbsp;
							<html:reset  value="حالت اول" styleClass="emdadButton" />&nbsp;&nbsp;
							<input type="button" value="انصراف" class="emdadButton" onclick="javascript:SureCancle2();">&nbsp;&nbsp;
							<input type="button" value="ايجاد دستور کار مرتبط" onClick='addNew("<bean:write name="emdadForm" property="id" />",this);' class="emdadButton">
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/help.jsp" flush="true">
   <jsp:param name="help_url" value="emdad.payan.help.html" />	
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
