<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<head>

<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<html:base/>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>
<script>
function checkSabt(elem) {
        elem.disabled = true;
//        if (document.rokhdadForm.action_type.value=="update") {
//			top.creator.click();
//		}
//		top.close();
        theForm.submit();
    }


function resetSpans(){
	document.all.errorSpan.innerText="";			
	document.all.emdadSpan.innerText="";	
	document.all.rokhdadSpan.innerText="";
	document.all.vazeatSpan.innerText="";
}
function reset2(){
	resetSpans();
	rokhdadForm.reset();
}

function getValidShasi(shasi){
//	if(shasi!=null && shasi.length>1 && shasi.substring(0,2)=="00")
//		return shasi.substring(2,shasi.length);
	return shasi;
}

var XMLDOM1 = new ActiveXObject("Microsoft.XMLDOM");
var XMLDOM2 = new ActiveXObject("Microsoft.XMLDOM");
function DoXML1Complete() {
	if (XMLDOM1.readyState == 4) {
   		row=XMLDOM1.getElementsByTagName("row");
		if(row.item(0).getAttribute("Title")!=null){
			row = XMLDOM1.getElementsByTagName("eshterakId");
			if(row.length>0 && row != null) {
				if (row.item(0).getAttribute("Title")!=null)
				document.rokhdadForm.eshterakId.value=row.item(0).getAttribute("Title");
				//alert("here");
				setEshterakId1();
				moshtarakDetails2();
			}
			
			row = XMLDOM1.getElementsByTagName("shomareShasi");
			if(row != null && row.length>0) {
				if (row.item(0).getAttribute("Title")!=null)
				document.rokhdadForm.shomareShasi.value=row.item(0).getAttribute("Title");
			}
			row = XMLDOM1.getElementsByTagName("shomarePelak");
			if(row != null && row.length>0) {
				if (row.item(0).getAttribute("Title")!=null)
				document.rokhdadForm.shomarePelak.value=row.item(0).getAttribute("Title");
			}
			row = XMLDOM1.getElementsByTagName("shahrId");
			if(row != null && row.length>0) {
				if (row.item(0).getAttribute("Title")!=null)
				document.rokhdadForm.shahrId.value=row.item(0).getAttribute("Title");;
			}
		}
		xml1_datosXML_complete = true;
   }
}

function DoXML2Complete() {
	if (XMLDOM2.readyState == 4) {
		row = XMLDOM2.getElementsByTagName("row");
		if (row.length>0 && row != null) {
			
			if(row.item(0).getAttribute("Title")!=null) {
				document.all.errorSpan.innerText=row.item(0).getAttribute("Title");			
   			} else {
			row = XMLDOM2.getElementsByTagName("emdad");
			if(row.length>0 && row != null) {
				document.all.emdadSpan.innerText="["+row.item(0).getAttribute("Title")+":"+row.item(0).getAttribute("emdadId")+"]";	
			}
			row = XMLDOM2.getElementsByTagName("rokhdad");
			if(row.length>0 && row != null) {
				document.all.rokhdadSpan.innerText="["+row.item(0).getAttribute("Title")+":"+row.item(0).getAttribute("rokhdadId")+"]";
			}
			row = XMLDOM2.getElementsByTagName("vazeat");
			if(row.length>0 && row != null) {
				document.all.vazeatSpan.innerText=row.item(0).getAttribute("Title");
			}
			}
		} 
		xml2_datosXML_complete = true;
   }
}
function loadXML(opt) {
	if(window.event.keyCode==13){
		document.rokhdadForm.shahrId.value="";
		document.rokhdadForm.tel.value="";
		document.rokhdadForm.shomarePelak.value="";
		//document.rokhdadForm.khadamateVijeh.value="";
		document.all.errorSpan.innerText="";			
		document.all.emdadSpan.innerText="";			
		document.all.rokhdadSpan.innerText="";			
		document.all.vazeatSpan.innerText="";
		//moshtarakDetails();
		XMLDOM1.async=true;
		XMLDOM2.async=true;
		XMLDOM1.resolveExternals = false;
		XMLDOM2.resolveExternals = false;
		XMLDOM1.onreadystatechange = DoXML1Complete;
		XMLDOM2.onreadystatechange = DoXML2Complete;
		var url="";
		if(opt==1) {
			url="/emdad/com/objectj/emdad/jsp/xml.generator.jsp?fields=eshterakId,shomareShasi,shomarePelak,shahrId,address&table=moshtarak&condition=eshterakId='"+document.rokhdadForm.eshterakId.value+"'";
			url2 ="/emdad/com/objectj/emdad/jsp/xml.generator2.jsp?field=eshterakId&value='"+document.rokhdadForm.eshterakId.value+"'";;
		} else {
			if(opt==2) {
				url="/emdad/com/objectj/emdad/jsp/xml.generator.jsp?fields=eshterakId,shomareShasi,shomarePelak,shahrId,tel,noeService,address&table=moshtarak&condition=shomareShasi='"+getValidShasi(document.rokhdadForm.shomareShasi.value)+"'";
				url2 ="/emdad/com/objectj/emdad/jsp/xml.generator2.jsp?field=shomareShasi&value='"+getValidShasi(document.rokhdadForm.shomareShasi.value)+"'";;
				document.rokhdadForm.eshterakId.value="";
			} else {
				url="/emdad/com/objectj/emdad/jsp/xml.generator.jsp?fields=eshterakId,shomareShasi,shomarePelak,shahrId,tel,noeService,address&table=moshtarak&condition=shomarePelak='"+document.rokhdadForm.shomarePelak.value+"'";
			}
		}
		XMLDOM1.load(url);
		XMLDOM2.load(url2);
		//XMLDOM2.load("/emdad/com/objectj/emdad/jsp/xml.generator2.jsp?eshterakId="+document.rokhdadForm.eshterakId.value);
		//alert("before moshtaralDetails")
		setEshterakId1();
		//setShomareShasi1();
//		window.resizeTo(600,800);
		moshtarakDetails2();
		return false;
	}
	return true;
}
	function gheirMoshtarakCreate() {
		args = "width=500 , height=430 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "Create";
		win3 = window.open("/emdad/s/moshtarak.run?action_type=specific,gheirMoshtarakCreate" , windowTitle, args);
		win3.creator=document.rokhdadForm;
		win3.focus();
		//document.rokhdadForm.eshterakId1.value = document.rokhdadForm.eshterakId.value;
	}

	function moshtarakDetails2() {
		showDetail2(document.rokhdadForm.eshterakId,
			null,
			"dimg1",
			"showMoshtari",
			"mdtl",
			"/emdad/s/moshtarak.run?action_type=specific,moshtarakShow") ;
	}

	function moshtarakDetails() {
		//alert (document.rokhdadForm.moshtarakIdTmp1.value);
		//alert (document.rokhdadForm.eshterakId.value);
		showDetail(document.rokhdadForm.eshterakId,
			null,
			"dimg1",
			"showMoshtari",
			"mdtl",
			"/emdad/s/moshtarak.run?action_type=specific,moshtarakShow") ;
	}

	function showSavabeghMoshtari() {
		//alert (document.rokhdadForm.moshtarakIdTmp2.value);
		//alert (document.rokhdadForm.eshterakId1.value);
		//alert (document.rokhdadForm.eshterakId1.changed);
		setEshterakId1();
		showDetailInNew(document.rokhdadForm.eshterakId1,
			null,
			"dimg2",
			"savabeghMoshtariFrame",
			"savabegh",
			"/emdad/s/moshtarak.run?action_type=specific,savabegh") ;
	}

	function setEshterakId1(){
		document.rokhdadForm.eshterakId1.value = document.rokhdadForm.eshterakId.value;
		document.rokhdadForm.eshterakId.changed = true;
		document.rokhdadForm.eshterakId1.changed = true;
	}
	/**function setShomareShasi1(){
		document.rokhdadForm.shomareShasi1.value = document.rokhdadForm.shomareShasi.value;
		document.rokhdadForm.shomareShasi.changed = true;
		document.rokhdadForm.shomareShasi1.changed = true;
	}**/


	function editShomarePelak() {
		args = "width=400 , height=250 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "Create";
		win3 = window.open("/emdad/com/objectj/emdad/jsp/shomarePelak.edit.jsp?eshterakId="+document.rokhdadForm.eshterakId.value , windowTitle, args);
		win3.creator=document.rokhdadForm;
		win3.focus();
		//clearRefresh();
		
		//win3.creator=document.window;
	}
	
	function singleSubmit( form ) {
		if ( form.submited.value == "false" ) {
			form.submited.value = "true";
			b = validateRokhdadForm(form);
			if ( !b ) {
				form.submited.value = "false";
			}
			return b;
		}
		if ( form.submited.value == "true" )
			return false;		
	}

	var lastCreator;
	
	function initFocus(){
		if(document.rokhdadForm.action_type.value!="update")
			document.rokhdadForm.eshterakId.focus();
		else
			document.rokhdadForm.irad.focus();
	}
function click(){}
</script>
</head>

<body onkeydown="Sabt()" onLoad="javascript:initFocus();"/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/validate.jsp" flush="true" />

<html:form method="post" action="/c/validaterokhdad" onsubmit="return singleSubmit(this);">
	<html:hidden property="hasrepl" />
				<center><span class="tilesHeader">ثبت رخداد جديد</span></center>
				
<table width="100%" dir=rtl class="generalText">
		<!----------------------------------------->
	
		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<logic:equal name="rokhdadForm" property="action_type" value="update">
						<tr class="editRow0">
							<td class="editLabel">کد مورد:</td>
							<td class="editStar"> </td>
							<td class="readData">
								<bean:write name="rokhdadId" />
								<html:hidden property="rokhdadId" />
							</td>
						</tr> 
					</logic:equal>

					<!----------------------------------------->

					<tr class="editRow1"> 
						<td class="editLabel">&nbsp;</td>
						<td class="editStar">&nbsp;</td>
						<td class="readData">
							
							<logic:equal name="rokhdadForm" property="action_type" value="create">
								&nbsp;
								<input type="button" value="جستجو" class="emdadButton" onClick="javascript:moshtarakSearch();"/>
								<input type="button" name="createMoshtari" class="emdadButton" value="ايجاد غير مشترک" onClick="javascript:gheirMoshtarakCreate();" />
							</logic:equal>
						</td>
					</tr>
					<!----------------------------------------->

					<tr class="editRow0"> 
						<td class="editLabel">&nbsp;</td>
						<td class="editStar">&nbsp;</td>
						<td class="readData">
							<span id="errorSpan" class="validation" dir="rtl">&nbsp;&nbsp;</span>&nbsp;&nbsp;
							<span id="rokhdadSpan" class="validation" dir="rtl">&nbsp;&nbsp;</span>&nbsp;&nbsp;
							<span id="emdadSpan" class="validation" dir="rtl">&nbsp;&nbsp;</span>&nbsp;&nbsp;
							<span id="vazeatSpan" class="validation" dir="rtl">&nbsp;&nbsp;</span>&nbsp;&nbsp;
					</tr>

					<!----------------------------------------->
					<tr class="editRow1"> <td colspan="10"><table width="100%%" cellspacing="0" cellpadding="0"><tr>
						<td class="editLabel">شماره مشتري:</td>
						<td class="editStar">*</td>
						<html:hidden property="moshtarakId"/>
						<input type="hidden" name="eshterakId1" value='<bean:write property="moshtarakId" name="rokhdadForm"/>'/>
						<td class="readData">
							<logic:equal name="rokhdadForm" property="action_type" value="create">
								<html:text property="eshterakId" size="12" maxlength="10" onkeypress="return submitenter(this,event) && loadXML(1)" styleClass="field" onchange="javascript:setEshterakId1()"/>
							</logic:equal>

							<logic:equal name="rokhdadForm" property="action_type" value="update">
								<input type="hidden" name="eshterakId" value='<bean:write name="moshtarakEshterakId"/>'/>
								<bean:write name="moshtarakEshterakId" />
							</logic:equal>
							<a href="javascript:moshtarakDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>

							<!--<logic:equal name="rokhdadForm" property="action_type" value="create">
								&nbsp;
								<input type="button" value="جستجو" onClick="javascript:moshtarakSearch();"/>
								<input type="button" name="createMoshtari" value="ايجاد غير مشترک" onClick="javascript:gheirMoshtarakCreate();"  onBlur="rokhdadForm.irad.focus();"/>
							</logic:equal>-->
						<td class="editLabel">شماره شاسي :</td>
						<td class="editStar">&nbsp;</td>
						<td class="readData">
							<input type="hidden" name="shomareShasi1" />
								<input type="text" name="shomareShasi" size="15" maxlength="20" onKeyPress="return submitenter(this,event) && loadXML(2)" class="field" />
							
							
						</td>
						<td class="editLabel">شماره پلاک :</td>
						<td class="editStar">&nbsp;</td>
						<td class="readData">
							
								<input type="text" name="shomarePelak" size="20" maxlength="20" disabled="true" onKeyPress="return submitenter(this,event) && loadXML(3)" class="field" onBlur="rokhdadForm.irad.focus();"/>
							
							
						</td>
						<td class="editLable"><input type="button" value="تغيير" class="emdadButton"  onClick="javascript:editShomarePelak();"/>&nbsp;&nbsp;
</td>
						</tr></table></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td colspan="3">
							<div   style="display:none;height:100px;" id="showMoshtari">
								<iframe width="100%" height="100%" src="" frameborder="1" name="mdtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0"> 
						<td class="editLabel">سوابق مشتري:</td>
						<td class="editStar"></td>
						<td class="readData">
							<a href="javascript:showSavabeghMoshtari()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg2"></a>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td colspan="3">
							<div   style="display:none;height:100px;" id="savabeghMoshtariFrame">
								<iframe width="100%" height="100%" src="" frameborder="1" name="savabegh" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">ايراد خودرو طبق نظر امداد خواه:</td>
						<td class="editStar">*</td>
						<td> <html:text property="irad" size="80" maxlength="80" onkeypress="return submitenter2(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">آدرس:</td>
						<td class="editStar">*</td>
						<td> <html:textarea property="address" styleClass="field" rows="2" cols="70" onkeypress="return submitenter2(this,event) && checkLength(160)"/></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تلفن:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tel" size="50" maxlength="50" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تلفن همراه :</td>
						<td class="editStar"> </td>
						<td> <html:text property="mobile" size="50" maxlength="50" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">شهر:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="shahrId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()" styleClass="generalText">
								<html:options collection="shahrList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->
					
					<tr class="editRow0">
					 <td colspan="5"><table cellspacing="0" cellpadding="0" width="100%"><tr>
						<td colspan="32">&nbsp;</td>
						<td class="editLabel">کيلومتر کارکرد: </td>
						<td class="editStar" style="width:10px;">*</td>
						<td> <html:text property="kilometerKarkard" size="8" maxlength="10" styleClass="field"/> 
						
						<td class="editLabel"> کارکرد قبلی:</td>
						<td class="editLabel"> <span id="kilometerKarkardGhabli" color="red"><bean:write property="kilometerKarkardGhabli" name="rokhdadForm" /></span></td>
						

					 <td class="editStar" style="width:12px;">&nbsp;</td>
						<td class="editLabel">کد منطقه:</td>
						<td class="editStar" style="width:10px;">*</td>
						<td> <html:text property="mantagheh" size="2" maxlength="2" styleClass="field"/></td>
						<td class="editLabel">ثابت يا سيار:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="sabetSayar" value="1" size="1" styleClass="generalText">
								<html:options collection="sabetSayarList" property="id" labelProperty="name" />
							</html:select>
						</td>

						</tr></table></td>
					</tr>

					<!----------------------------------------->

					<!--<tr class="editRow1">
						<td class="editLabel">ثابت يا سيار:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="sabetSayar" size="1" styleClass="generalText">
								<html:options collection="sabetSayarList" property="id" labelProperty="name" />
							</html:select>
						</td>
					</tr>-->

					<!----------------------------------------->

					<tr class="editRow1">
					<td colspan="5" align="right"><table cellspacing="0" cellpadding="0" width="100%" dir="rtl"><tr>
						<td class="editLabel" style="width:160px;">مشمول خدمات ويژه:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="khadamateVijeh" size="1" styleClass="generalText">
								<html:options collection="khadamateVijehList" property="id" labelProperty="name" />
							</html:select>
						</td>						
						<td class="editLabel">تاريخ فعال شدن:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tarikhFaalShodan" size="10" maxlength="10"  /> </td>
						</tr></table></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نمايندگي:</td>
						<td class="editStar"> </td>
						<td>
							<html:select property="namayandegiId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()" styleClass="generalText">
								<html:options collection="namayandegiList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>

					<!----------------------------------------->

					<!--<tr class="editRow0">
						<td class="editLabel">تاريخ فعال شدن:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tarikhFaalShodan" size="10" maxlength="10"  /> </td>
					</tr>-->

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">ثبت کننده رخداد:</td>
						<td class="editStar"></td>
						<logic:equal name="rokhdadForm" property="action_type" value="create">
							<td class="readData">
								<bean:write name="userName" />
							</td>
						</logic:equal>

						<logic:equal name="rokhdadForm" property="action_type" value="update">
							<td class="readData">
								<bean:write property="sabtKonandehName"  name="rokhdadForm"/>
							</td>
						</logic:equal>
						<html:hidden property="sabtKonandeh" />
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
					<td colspan="5"><table cellspacing="0" cellpadding="0" width="100%"><tr>
						<td class="editLabel" style="width:160px;">نوع درخواست کننده:</td>
						<td class="editStar">*</td>
						<td>
							<html:select property="noeDarkhastKonandeh" size="1" styleClass="generalText">
								<html:options collection="noeDarkhastKonandehList" property="id" labelProperty="name" />
							</html:select>
						</td>
						<td class="editLabel">دفتر استاني:</td>
						<td class="editStar">*</td>
						<td class="readData">
							<html:select property="daftarOstaniId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()" styleClass="generalText">
								<html:options collection="daftarOstaniList" property="eid" labelProperty="name" />
							</html:select>
						</td>
						</tr></table></td>
					</tr>

					<!----------------------------------------->

					<logic:equal name="rokhdadForm" property="action_type" value="update">
						<tr class="editRow0">
							<td class="editLabel">آخرين تغيير دهنده:</td>
							<td class="editStar"></td>
							<td class="readData">
								<bean:write property="akharinTaghyirDahandehName"  name="rokhdadForm"/>
								<html:hidden property="akharinTaghyirDahandeh" />
							</td>
						</tr>
					</logic:equal>

					<!----------------------------------------->

					<logic:equal name="rokhdadForm" property="action_type" value="update">
						<tr class="editRow1">
							<td class="editLabel">زمان ثبت رخداد:</td>
							<td class="editStar"> </td>
							<td class="readData">
								<bean:write property="zamaneVaghei" name="rokhdadForm"/> <bean:write property="zamaneVaghei2" name="rokhdadForm"/>
								<html:hidden property="zamaneVaghei" />
								<html:hidden property="zamaneVaghei2" />
							</td>
						</tr>
					</logic:equal>

					<!----------------------------------------->

					<!--<tr class="editRow0">
						<td class="editLabel">دفتر استاني:</td>
						<td class="editStar">*</td>
						<td class="readData">
							<html:select property="daftarOstaniId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()" styleClass="generalText">
								<html:options collection="daftarOstaniList" property="eid" labelProperty="name" />
							</html:select>
						</td>
					</tr>-->

					<!----------------------------------------->
                    <tr align="left">
                        <td height="70" colspan="20" align="center">
                            <html:hidden property="action_type" />
                            <html:hidden property="id" />
                            <html:hidden property="curpage" />
                            <html:hidden property="order"/>
                            <html:hidden property="sorttype" />
                            <input type="hidden" name="fastComboHdn"/>
                          <!--  <input type="submit" value="ثبت" name="sabtBtn" class="emdadButton"/>&nbsp;&nbsp; -->
							<input type="hidden" name="submited" value="false"/>
                          <!--  <input type="button" value="انصراف" class="emdadButton" onClick="javascript:SureCancle();"/>&nbsp;&nbsp; -->
							 <!--  <input type="button" value="تغيير شماره پلاک" class="emdadButton"  onClick="javascript:editShomarePelak();"/>&nbsp;&nbsp;-->
							<input type="button" value="ثبت" class="emdadButton" name="sabtBtn" onClick="javascript:checkSabt(this);" />&nbsp;&nbsp;
                            <input type="reset" value="حالت اول" class="emdadButton" onClick="javascript:resetSpans();"/>&nbsp;&nbsp;							
			<!--				<input type="button"  value="حالت اول" styleClass="emdadButton" name="resetButton" onClick="javascript:reset2();"/>&nbsp;&nbsp; -->
							<input type="button" value="انصراف" class="emdadButton" onclick="javascript:SureCancle2();">&nbsp;&nbsp;		
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/help.jsp" flush="true">
   <jsp:param name="help_url" value="rokhdad.edit.help.html" />	
</jsp:include>
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
	setForm(document.rokhdadForm);
	setEntity("Rokhdad");
    if (document.rokhdadForm.action_type.value=="create") 
	{
        document.rokhdadForm.action="/emdad/c/validaterokhdad.run";
    } 
	
	else 
	{
        document.rokhdadForm.action="/emdad/u/validaterokhdad.run";
    }
	document.rokhdadForm.eshterakId.changed = true;
	document.rokhdadForm.eshterakId1.changed = true;
</script>
<!--<Script language="vbs" src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/farsi.inc"></Script>-->

<html:javascript formName="rokhdadForm" />