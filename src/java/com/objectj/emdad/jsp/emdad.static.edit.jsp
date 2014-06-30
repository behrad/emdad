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


<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/fast-combo.jsp" flush="true" />
<!--jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" /-->

<%@ page import ="java.lang.*,com.objectj.emdad.ejb.util.EntityList,com.objectj.emdad.ejb.EntityAccess" %>

<html:base/>


<script>
	function createEmdad4(){
		theForm.action_type.value = "specific,khodrojagozin";
		theForm.action="/emdad/s/emdad.run?action_type=specific,createEmdad4";
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

	function moshtarakDetails() {
		//alert (document.rokhdadForm.moshtarakIdTmp1.value);
		//alert (document.rokhdadForm.eshterakId.value);
		showDetail(document.emdadForm.moshtarakId,
			null,
			"dimg2",
			"showMoshtari",
			"mdtl",
			"/emdad/s/moshtarak.run?action_type=specific,moshtarakShow") ;
	}

	function showSavabeghMoshtari() {
		//alert (document.emdadForm.moshtarakId.value);
		showDetailInNew(document.emdadForm.moshtarakId1,
			null,
			"dimg3",
			"savabeghMoshtariFrame",
			"savabegh",
			"/emdad/s/moshtarak.run?action_type=specific,savabegh") ;
	}

	function emdadDetails(i) {
		//alert(eval("document.emdadForm.emdadId" + i).value);
		showDetail(eval("document.emdadForm.emdadId" + i),
			null,
			"imgEmdad" + i,
			"showEmdad" + i,
			"edtl" + i,
			"/emdad/s/emdad.run?action_type=specific,emdadShow") ;
	}

	function showJagozin0(){
        showJagozin(1);
        showJagozin(2);
    }

	function showJagozin(i){
		obj = document.getElementById("khodroJagozin"+i);
		styl = obj.style;
		if (document.emdadForm.modatTamir.value > 1 && document.emdadForm.vazeatKonuni.value > 0){
			styl.display = "inline";
		}else{
			styl.display = "none";
		}
	}

	function selectField(){
	    b = document.all.balini2;
		g = document.all.gheireBalini;
		if (document.emdadForm.noeEmdad.value == 0){
			for (var i=0; b!=null && i<b.length; i++){
			   o = b[i];
			   o.style.display = "none";
			}
			
			for(var j=0; g!=null && j<g.length; j++){
				m = g[j];
				m.style.display = "none";
			}
		}
        else if (document.emdadForm.noeEmdad.value == 1){
			for (var i=0; b!=null && i<b.length; i++){
			   o = b[i];
			   o.style.display = "inline";
			}
			
			for(var j=0; g!=null && j<g.length; j++){
				m = g[j];
				m.style.display = "none";
			}
		}
		else if (document.emdadForm.noeEmdad.value > 1){
			for (var i=0; b!=null && i<b.length; i++){
			   o = b[i];
			   o.style.display = "none";
			}
			for(var j=0; g!=null && j<g.length; j++){
				m = g[j];
				m.style.display = "inline";
			}
		}
	}

	function khodrojagozinVazeat() {
		showDetail(document.emdadForm.khvz,
			null,
			"dimg3",
			"khodrojagozinVazeatDiv",
			"khodrojagozinVazeatFrame",
			"/emdad/s/khodrojagozin.run?action_type=specific,khodrojagozinVazeat") ;
	}
	
	
	function selectEmdadgar( valuee ) {
		len = document.all.emdadForm.noeEmdadgarId.options.length;
		sel = document.all.emdadForm.noeEmdadgarId;
		for(i=0; i<len;i++ ){
			emdadgar = document.getElementById( sel.options[i].value );
			if ( emdadgar != null )
				emdadgar.style.display = "none";
		}
		if ( document.getElementById( valuee ) != null ) 	
			document.getElementById( valuee ).style.display = "inline";
	}

	function setEmdadgar( emdadgarSel ) {
		//alert( emdadgarSel.value );
		document.emdadForm.emdadgarId.value = emdadgarSel.value;
	}
	
	function setEmdadForEdit( noeEmdadgar, emdadgar ) {
		if ( document.getElementById( noeEmdadgar ) != null ) {	
			document.getElementById( noeEmdadgar ).value = emdadgar;
			document.getElementById( noeEmdadgar ).style.display = "inline";
		}
	}

	var lastCreator;
//window.moveTo(0,0);
//window.resizeTo(screen.width*0.8, screen.height * 0.9);
</script>
<body onkeydown="Sabt()">

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/validate.jsp" flush="true" />
<% long t1 = (new java.util.Date()).getTime();%>
<form method="post" name="emdadForm" action="/c/validateemdad" onsubmit="return validateEmdadForm(this)">
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/moshtarak.info.jsp" flush="true" />

	<table width="100%" dir=rtl class="generalText">
		<tr>
			<td align="center">
				<table border="0" cellpadding="6" cellspacing="0" class="editTable">

					<!----------------------------------------->
                    <input type="hidden" name="khvz" value="0"/>


					<%
						boolean disable = true;
						boolean lock = false;
					%>
					


					<!----------------------------------------->

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">کد مورد:</td>
						<td class="editStar"> </td>
						<td class="readData">
								<%= request.getAttribute("rokhdadRokhdadId")%>
							<a href="javascript:rokhdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td colspan="3">
							<div   style="display:none;height:180px;" id="showRokhdad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="rdtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="readLabel">مشترک:</td>
						<td width="5%"></td>
						<td class="readData">
                             <%= request.getAttribute("moshtarakId") %>
							<input type="hidden" name="moshtarakId" value="< bean : write name="moshtarakId"/>"/>
							<a href="javascript:moshtarakDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg2"></a>
						</td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="editRow1"> 
						<td class="readData" colspan="3">						
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
                             <%= request.getAttribute("moshtarakId") %>
							<input type="hidden" name="moshtarakId1" value="< bean : write name="moshtarakId"/>"/>
							<a href="javascript:showSavabeghMoshtari()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg3"></a>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td colspan="3">
							<div style="display:none;height:100px;" id="savabeghMoshtariFrame">
								<iframe width="100%" height="100%" src="" frameborder="1" name="savabegh" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

						<tr class="editRow1">
							<td class="editLabel">دستور کار فعلي:</td>
							<td class="editStar"> </td>
							<td class="readData">
								<input type="hidden" name="emdadId1" value="< bean : write property="emdadId" name="emdadForm"/>" />
								< bean : write property="emdadId"  name="emdadForm" />
								<a href="javascript:emdadDetails(1)" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="imgEmdad1"></a>
							</td>
						</tr>

						

						<tr class="editRow1">
							<td colspan="3">
								<div   style="display:none;height:100px;" id="showEmdad1">
									<iframe width="100%" height="100%" src="" frameborder="1" name="edtl1" marginheight="0" marginwidth="0" ></iframe>
								</div>
							</td>
						</tr>


						<script>
							document.emdadForm.emdadId1.changed = true;
						</script>
					<!----------------------------------------->

					<tr height="3" bgcolor="#336699"><td colspan="3"></td></tr>

					<!----------------------------------------->

                    <tr class="editRow1">
                        <td class="editLabel">نوع امداد:</td>
                        <td class="editStar">*</td>
						<% if (lock || disable ) {%>
							<td class="readData"> <%= request.getAttribute("noeEmdadName") %></td>
							<% if (disable && !lock) { %>
								< html : hidden property="noeEmdad" />
							<%}%>
						<% }else{ %>
						<td class="readData">
								<select name="noeEmdad" size="1" onkeypress="return fastCombo(this)" onchange="selectField();" onfocus="emptyFastCombo()"><option value="0">------</option>
									<option value="1">باليني</option>
									<option value="2">خدمات ويژه (تعمير)</option>
									<option value="3">خدمات ويژه (پشتيباني)</option>
								</select>
                        </td>
						<%}%>
                    </tr>

					<!----------------------------------------->
						<tr class="editRow0" style="display:inline" id="balini"><td colspan="6">
						<table cellpadding="0" cellspacing="0" width="100%" dir="rtl"><tr>

							<td class="editLabel">تاريخ اعزام:</td>
							<td class="editStar">*</td>
							<% if (lock) {%>
								<td class="readData"> < bean : write name="emdadForm" property="zamanEzam"/></td>
							<% }else{ %>
								<td><input type="text" name="zamanEzam" size="10" maxlength="10" styleClass="field"/> </td>
							<%}%>
						
							<td class="editLabel">زمان اعزام:</td>
							<td class="editStar">*</td>
							<% if (lock) { %>
								<td class="fieldDescription"> < bean : write name="emdadForm" property="zamanEzam2"/></td>
							<% }else{ %>
								<td><input type="text" name="zamanEzam2" size="10" maxlength="10" styleClass="field"/> </td>
							<%}%>
						 
					</tr></table></td>
                   </tr>
						
<tr class="editRow0" style="display:inline" id="balini"><td colspan="6">
						<table cellpadding="0" cellspacing="0" width="100%" dir="rtl"><tr>					
							<td class="editLabel">تاريخ اعزام:</td>
							<td class="editStar"></td>
							<td class="readData"> 
								<input type="hidden" name="zamanEzam"/>
								<!-- bean : write name="emdadForm" property="zamanEzam"/ -->
							</td>
							<td class="editLabel">زمان اعزام:</td>
							<td class="editStar"></td>
							<td class="readData"> 
								<input type="hidden" name="zamanEzam2"/>
								<!-- bean : write name="emdadForm" property="zamanEzam2"/ -->
							</td>
</tr></table></td>
                   </tr>

						<!-- EMDADGAR COMBOs -->
						<tr class="editRow0" style="display:inline" id="baliniNoe">
							<td class="editLabel">نوع امدادگر:</td>
							<td class="editStar">*</td>
							<td>								
								<select name="noeEmdadgarId" onkeypress="fastCombo(this);selectEmdadgar(this.value);" onchange="selectEmdadgar(this.value);" onfocus="emptyFastCombo()"><option value="" selected="selected">------</option>
									<option value="D08080808080808380o">امدادگر شركتي</option>
									<option value="358180808080804680o">امدادگر موتورسوار</option>
									<option value="308180808080808480o">امدادگر واگذاري</option>
									<option value="378180808080809480o">انجام نشد</option>
									<option value="008280808080801880o">بيمه</option>
									<option value="AE8180808080808A80o">جرثقيل</option>
									<option value="368180808080808C80o">راننده</option>
									<option value="708180808080808080o">غير فعال</option>
									<option value="368180808080808A80o">كارشناس</option>
								</select>								
							</td>
						</tr>					
						<tr class="editRow0" style="display:inline" id="balini">
							<td class="editLabel">امدادگر مربوطه:</td>
							<td class="editStar">*</td>
							<td>								
								<!-- SAMPLES -->
								
									<select style="display:none;" name='' onkeypress="fastCombo(this);setEmdadgar(this);" onchange="setEmdadgar(this);" onfocus="emptyFastCombo()"  >
										
										
									</select>																
								
									<select style="display:none;" name='D08080808080808380o' onkeypress="fastCombo(this);setEmdadgar(this);" onchange="setEmdadgar(this);" onfocus="emptyFastCombo()"  >
										
										
											<option value='358180808080809681o'>2كسرايي فريماني محمد حسين </option>
										
											<option value='35818080808080A081o'>2غمخواري سيد مهدي </option>
										
											<option value='35818080808080A281o'>2صادقي محمدرضا </option>
										
											<option value='35818080808080A881o'>2غلام احمدي رضا </option>
										
											<option value='35818080808080AC81o'>2نيكچه فرهاد</option>
										
											<option value='35818080808080AF81o'>2اسفندياري خدامراد</option>
										
											<option value='35818080808080B381o'>2الطافي عباس </option>
										
											<option value='35818080808080B881o'>2شريفي شهريور آيت اله </option>
										
											<option value='35818080808080BE81o'>2ماهوتچيان شهرام </option>
										
											<option value='368180808080808280o'>2رضايي اكبر </option>
										
											<option value='368180808080808380o'>2حكمت آرا امين </option>
										
											<option value='368180808080808480o'>2خوشبين داود </option>
										
											<option value='368180808080808580o'>2حاجي بكي رضا </option>
										
											<option value='368180808080808680o'>2نديمي حميد </option>
										
											<option value='368180808080808780o'>2دميرچي جواد </option>
										
											<option value='CE828080808080CC80o'>2بياباني مهدي</option>
										
											<option value='E98080808080808280o'>2فكوري حسين </option>
										
											<option value='F08080808080808080o'>2ملت شاهي پيمان </option>
										
									</select>																
								
									<select style="display:none;" name='358180808080804680o' onkeypress="fastCombo(this);setEmdadgar(this);" onchange="setEmdadgar(this);" onfocus="emptyFastCombo()"  >
										
										
											<option value='CE8280808080800480o'>3حميدرضا زارعي</option>
										
									</select>																
								
									<select style="display:none;" name='308180808080808480o' onkeypress="fastCombo(this);setEmdadgar(this);" onchange="setEmdadgar(this);" onfocus="emptyFastCombo()"  >
										
										
											<option value='358180808080805680o'>1رشيدي محمد </option>
										
											<option value='358180808080805A80o'>1پيرهادي تواندشتي محمد </option>
										
											<option value='358180808080805D80o'>1سرلك مهدي </option>
										
											<option value='358180808080806180o'>1عليمحمد عليرضا </option>
										
											<option value='358180808080806580o'>1پيرهادي تواندشتي محمود </option>
										
											<option value='358180808080806980o'>1قوچكانلو كوروش </option>
										
											<option value='358180808080807180o'>1شعباني حسن </option>
										
											<option value='358180808080807480o'>1دشتي محمدرضا </option>
										
											<option value='358180808080808181o'>1ميكاييان محمد </option>
										
											<option value='358180808080809281o'>1مختاري مختار </option>
										
											<option value='358180808080809381o'>1خسروي دانيال </option>
										
											<option value='358180808080809481o'>1خسروي علي </option>
										
											<option value='358180808080809A81o'>1خدابنده علي </option>
										
											<option value='E98080808080808180o'>1بيضاء شهروز </option>
										
									</select>																
								
									<select style="display:none;" name='378180808080809480o' onkeypress="fastCombo(this);setEmdadgar(this);" onchange="setEmdadgar(this);" onfocus="emptyFastCombo()"  >
										
										
											<option value='378180808080809680o'>7با نمايندگي تماس برقرار نشد</option>
										
											<option value='378180808080809880o'>7تمرد امدادگر از انجام امداد</option>
										
											<option value='718180808080808280o'>7اشتباه ثبت شده بود</option>
										
											<option value='718180808080808980o'>7با تماس مجدد كنسل شد</option>
										
											<option value='758180808080809981o'>7نمايندگي با امداد همكاري نكرد</option>
										
											<option value='E8828080808080ED80o'>7راهنمايي تلفني</option>
										
									</select>																
								
									<select style="display:none;" name='008280808080801880o' onkeypress="fastCombo(this);setEmdadgar(this);" onchange="setEmdadgar(this);" onfocus="emptyFastCombo()"  >
										
										
											<option value='E4828080808080BD80o'>پرداخت نقدي</option>
										
									</select>																
								
									<select style="display:none;" name='AE8180808080808A80o' onkeypress="fastCombo(this);setEmdadgar(this);" onchange="setEmdadgar(this);" onfocus="emptyFastCombo()"  >
										
										
											<option value='368180808080808880o'>4عليزاده يوسف</option>
										
											<option value='368180808080808980o'>4حقاني عباس</option>
										
											<option value='368180808080808E80o'>4جرثقيل امداد</option>
										
											<option value='368180808080808F80o'>4جرثقيل رفيع</option>
										
											<option value='E48180808080808080o'>4گنجه ايرج</option>
										
									</select>																
								
									<select style="display:none;" name='368180808080808C80o' onkeypress="fastCombo(this);setEmdadgar(this);" onchange="setEmdadgar(this);" onfocus="emptyFastCombo()"  >
										
										
											<option value='368180808080808D80o'>5جزلانيان حسينعلي </option>
										
											<option value='378180808080808080o'>5مجيدي بابك </option>
										
											<option value='378180808080808180o'>5حميديان داود </option>
										
											<option value='378180808080808280o'>5فرجي پور عباس </option>
										
											<option value='378180808080808880o'>5امامزاده جعفريه سيدعلي </option>
										
											<option value='378180808080808A80o'>5كاوياني محمد رضا </option>
										
											<option value='378180808080808C80o'>5مهري نژاد مهرداد </option>
										
											<option value='708180808080808780o'>5آشتياني وحيد </option>
										
									</select>																
								
									<select style="display:none;" name='708180808080808080o' onkeypress="fastCombo(this);setEmdadgar(this);" onchange="setEmdadgar(this);" onfocus="emptyFastCombo()"  >
										
										
											<option value='378180808080808380o'>ييييييي</option>
										
											<option value='378180808080808480o'>ييي</option>
										
											<option value='378180808080808680o'>ييي</option>
										
											<option value='708180808080808680o'>ييي</option>
										
											<option value='718180808080808080o'>ييي</option>
										
											<option value='718180808080808180o'>ييي</option>
										
											<option value='718180808080808380o'>ييي</option>
										
											<option value='718180808080808480o'>ييي</option>
										
											<option value='718180808080808580o'>ييي</option>
										
											<option value='718180808080808680o'>ييي</option>
										
											<option value='718180808080808780o'>ييي</option>
										
											<option value='718180808080808880o'>ييي</option>
										
											<option value='718180808080808A80o'>ييي</option>
										
											<option value='718180808080808B80o'>ييي</option>
										
											<option value='718180808080808C80o'>ييي</option>
										
											<option value='718180808080808D80o'>ييي</option>
										
											<option value='718180808080808E80o'>ييي</option>
										
											<option value='718180808080808F80o'>ييي</option>
										
											<option value='718180808080809080o'>ييي</option>
										
											<option value='718180808080809180o'>ييي</option>
										

											<option value='718180808080809280o'>ييي</option>
										
											<option value='718180808080809380o'>ييي</option>
										
											<option value='718180808080809480o'>ييي</option>
										
											<option value='718180808080809580o'>ييي</option>
										
											<option value='718180808080809680o'>ييي</option>
										
											<option value='718180808080809780o'>ييي</option>
										
											<option value='718180808080809880o'>ييي</option>
										
											<option value='718180808080809980o'>ييي</option>
										
											<option value='718180808080809A80o'>ييي</option>
										
											<option value='718180808080809B80o'>ييي</option>
										
											<option value='718180808080809C80o'>ييي</option>
										
											<option value='718180808080809D80o'>ييي</option>
										
											<option value='718180808080809E80o'>ييي</option>
										
											<option value='718180808080809F80o'>ييي</option>
										
											<option value='71818080808080A080o'>ييي</option>
										
											<option value='71818080808080A180o'>ييي</option>
										
											<option value='71818080808080A280o'>ييي</option>
										
											<option value='71818080808080A380o'>ييي</option>
										
											<option value='71818080808080A480o'>ييي</option>
										
											<option value='71818080808080A580o'>ييي</option>
										
											<option value='71818080808080A680o'>ييي</option>
										
											<option value='71818080808080A780o'>ييي</option>
										
											<option value='71818080808080A880o'>ييي</option>
										
											<option value='758180808080807780o'>ييي</option>
										
											<option value='758180808080807880o'>ييي</option>
										
											<option value='758180808080807980o'>ييي</option>
										
											<option value='758180808080807A80o'>ييي</option>
										
											<option value='758180808080807B80o'>ييي</option>
										
											<option value='758180808080807C80o'>ييي</option>
										
											<option value='758180808080807D80o'>ييي</option>
										
											<option value='758180808080807E80o'>ييي</option>
										
											<option value='758180808080807F80o'>ييي</option>
										
											<option value='758180808080808081o'>ييي</option>
										
											<option value='758180808080808181o'>ييي</option>
										
											<option value='758180808080808281o'>ييي</option>
										
											<option value='758180808080808381o'>ييي</option>
										
											<option value='758180808080808481o'>ييي</option>
										
											<option value='758180808080808581o'>ييي</option>
										
											<option value='758180808080808681o'>ييي</option>
										
											<option value='758180808080808781o'>ييي</option>
										
											<option value='758180808080808881o'>ييي</option>
										
											<option value='758180808080808981o'>ييي</option>
										
											<option value='758180808080808A81o'>ييي</option>
										
											<option value='758180808080808B81o'>ييي</option>
										
											<option value='758180808080808C81o'>ييي</option>
										
											<option value='758180808080808D81o'>ييي</option>
										
											<option value='758180808080808E81o'>ييي</option>
										
											<option value='758180808080808F81o'>ييي</option>
										
											<option value='758180808080809081o'>ييي</option>
										
											<option value='758180808080809181o'>ييي</option>
										
											<option value='758180808080809281o'>ييي</option>
										
											<option value='758180808080809381o'>ييي</option>
										
											<option value='758180808080809481o'>ييي</option>
										
											<option value='758180808080809581o'>ييي</option>
										
											<option value='758180808080809681o'>ييي</option>
										
											<option value='758180808080809781o'>ييي</option>
										
											<option value='758180808080809881o'>ييي</option>
										
											<option value='758180808080809A81o'>ييي</option>
										
											<option value='758180808080809B81o'>ييي</option>
										
											<option value='758180808080809C81o'>ييي</option>
										
											<option value='758180808080809D81o'>ييي</option>
										
											<option value='758180808080809E81o'>ييي</option>
										
											<option value='758180808080809F81o'>ييي</option>
										
											<option value='CE828080808080CD80o'>ييي</option>
										
									</select>																
								
									<select style="display:none;" name='368180808080808A80o' onkeypress="fastCombo(this);setEmdadgar(this);" onchange="setEmdadgar(this);" onfocus="emptyFastCombo()"  >
										
										
											<option value='368180808080808B80o'>6حاجي زاده حميد</option>
										
									</select>																
								<input type="hidden" name="emdadgarId" />
								<!-- SAMPLES -->								
							</td>
						</tr>
					
					<!----------------------------------------->	

						<tr class="editRow0">
							<td class="editLabel">نمايندگي يا عامليت مجاز:</td>
							<td class="editStar">*</td>
							<td>
								<select name="namayandegiId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()"><option value="" selected="selected">------</option>
<option value="4B8180808080809080o">آبادان 2419 , اردشير آهوپاي</option>
<option value="498180808080808580o">آباده 2205 , عباس و رضا مهربان</option>
<option value="428180808080808980o">آباده 2220 , عباس مهربان</option>
<option value="478180808080808480o">آبيك 1356 , خيرا خسرونژاد</option>
<option value="478180808080809A80o">آذر شهر 1817 , ابوالفضل كاردان</option>
<option value="3F818080808080E280o">آستارا 1972 , شهريار گل بابازاده</option>
<option value="3F818080808080DD80o">آستانه اشرفيه  1966 , بهروز رجب زاده</option>
<option value="4C8180808080809C80o">آمل 3303 , غلامحسين حدادپور</option>
<option value="4C8180808080809E80o">آمل 3305 , هاشم قادري - اسماعيل قبادي مقدم</option>
<option value="38818080808080F782o">آمل 3325 , علي رهنما زاده</option>
<option value="4C818080808080AF80o">ابر كوه  4013 , حسام رسولي</option>
<option value="3D8180808080809F80o">ابهر 1453 , ابراهيم حاجي جعفري</option>
<option value="478180808080808780o">اراك 1403 , پرويز صفوي</option>
<option value="3D8180808080809380o">اراك 1404 , علي معطري</option>
<option value="478180808080808880o">اراك 1409 , تعاوني تاكسيراني ( اصغر رودباراني)</option>
<option value="458180808080808380o">اراك 1410 , جعفر معطري</option>
<option value="478180808080808980o">اراك 1412 , ناصر آزموده فر</option>
<option value="468180808080808280o">اراك 1413 , داود زنديه وكيلي</option>
<option value="478180808080808A80o">اراك 1414 , رضا يار محمدي</option>
<option value="508180808080808380o">اراك 7615 , محمد محسن احمدي فيجاني</option>
<option value="3F818080808080A580o">اردبيل 1702 , بابا بابائي روحنواز</option>
<option value="478180808080809580o">اردبيل 1703 , محمد جعفري نمين</option>
<option value="3F818080808080A880o">اردبيل 1707 , عادل زرعي</option>
<option value="508180808080808480o">اردبيل 6202 , ايوب مختاري</option>
<option value="38818080808080D882o">اردستان 2039 , شركت باند ماشين ( رحمتي زاده )</option>
<option value="4D8180808080809480o">اردكان 4007 , جمشيد ناظمي زاده</option>
<option value="428180808080808D80o">ارسنجان 2226 , ولي ابراهيمي</option>
<option value="3F818080808080CB80o">اروميه 1901 , شركت اروم سرويس ( محمد پير پور )</option>
<option value="47818080808080A280o">اروميه 1905 , مهدي جليلي</option>
<option value="3F818080808080D080o">اروميه 1906 , چنگيز ابوالقاسمي</option>
<option value="47818080808080A380o">اروميه 1907 , محرم الماسي</option>
<option value="47818080808080A480o">اروميه 1910 , تاكسيراني اروميه ( بهمن جعفري )</option>
<option value="47818080808080A580o">اروميه 1912 , شركت چيچست خودرو ( مرتضي خطيبي )</option>
<option value="47818080808080A980o">اروميه 1920 , شركت زرين يدك اروميه ( اسفنديار ضيا )</option>
<option value="47818080808080AA80o">اروميه 1921 , رضا راستگو</option>
<option value="4B8180808080808080o">ازنا 2305 , شركت خدمات خودرو( محمدتقي صالحي )</option>
<option value="4C8180808080808A80o">اسفراين 3008 , محمدعلي خرمي - مهدي حسين زاده</option>
<option value="4C8180808080808580o">اسلام آباد غرب 2807 , احمد حسيني</option>
<option value="38818080808080C582o">اسلامشهر 1226 , اكبر رمضاني</option>
<option value="508180808080808680o">اسلامشهر 5002 , سيد قادر هاشمي</option>
<option value="4F8180808080808480o">اشكذر 4016 , محمد حسين كاظمي پور اشكذري</option>
<option value="47818080808080B380o">اصفهان 2001 , عبدالوهاب و حسين غخارزاده</option>
<option value="468180808080808F80o">اصفهان 2008 , سيد مصطفي كاج آبادي</option>
<option value="47818080808080C880o">اصفهان 2009 , رحمت اله هاشم زاده</option>
<option value="38818080808080CC82o">اصفهان 2010 , غلامعلي صالحي          ( شهرستان خميني شهر )</option>
<option value="38818080808080CD82o">اصفهان 2011 , مهرداد عابدي</option>
<option value="47818080808080CF80o">اصفهان 2012 , سيد جواد قناديان</option>
<option value="47818080808080DA80o">اصفهان 2016 , احمدرضا ناصر</option>
<option value="47818080808080E080o">اصفهان 2019 , شركت جمكار ( محمد شاه طالبي حسين آبادي )</option>
<option value="38818080808080D182o">اصفهان 2020 , غلامحسين مدنيان</option>
<option value="38818080808080D282o">اصفهان 2021 , رجبعلي باقري (شهرستان برخوار - دولت آباد)</option>
<option value="47818080808080E380o">اصفهان 2024 , سعيد فتاحي</option>
<option value="47818080808080E680o">اصفهان 2025 , رضا امين الرعايا - محمد مهدي احمدي</option>
<option value="38818080808080D582o">اصفهان 2032 , شركت حافظ قطعات ( حسن موحديان )</option>
<option value="47818080808080E880o">اصفهان 2033 , رضا پاكدامنيان</option>
<option value="47818080808080E980o">اصفهان 2034 , حسين صاعد</option>
<option value="47818080808080EC80o">اصفهان 2036 , شركت طليعه قطعات سپاهان ( مهدي شيشه گر )</option>
<option value="47818080808080ED80o">اصفهان 2038 , سيد امير چاوشي زاده آشتياني</option>
<option value="38818080808080D982o">اصفهان 2041 , حميدرضا آقا جان</option>
<option value="38818080808080DB82o">اصفهان 2044 , سعيد سيدنا</option>
<option value="498180808080809680o">اليگودرز 2302 , ميرزا حسين گودرزي</option>
<option value="498180808080809780o">اليگودرز 2304 , خسرو روشنايي</option>
<option value="428180808080808F80o">اميديه 2403 , اسماعيل داودي</option>
<option value="38818080808080EE82o">امير كلا 3308 , عليرضا احمديه اميري</option>
<option value="4B8180808080808E80o">انديمشك 2407 , محمد و پرويز ميري</option>
<option value="3F818080808080C680o">اهر 1809 , ايوب قلي زاده </option>
<option value="428180808080809080o">اهواز 2404 , شركت فضل يدك (فضل اله زيبايي)</option>
<option value="4B8180808080808B80o">اهواز 2405 , شركت اهواز ماشين ( منوچهر رستگار )</option>
<option value="4B8180808080808F80o">اهواز 2414 , حميد زنگنه</option>
<option value="428180808080809480o">اهواز 2417 , حسن منابي</option>
<option value="4B8180808080809180o">اهواز 2420 , محمد رضا مسعودي</option>
<option value="4D8180808080808780o">ايرانشهر 4202 , پيربخش دادآفرين</option>
<option value="428180808080809680o">ايلام 2501 , شركت تعاوني 122 ( سيد عباس امامي)</option>
<option value="38818080808080EB82o">بابل 3307 , مصطفي خورشيدي</option>
<option value="38818080808080EC82o">بابل 3315 , حبيب منتظري جويباري</option>
<option value="4C818080808080A480o">بابل 3329 , عسگري نامدار بابلي</option>
<option value="4C8180808080809D80o">بابلسر 3304 , علي اصغر دارخال</option>
<option value="38818080808080F482o">بابلسر 3320 , محمد علي ابوطالبي</option>
<option value="38818080808080D482o">بادرود 2027 , غزال خودرو شريف (عبداله شريفي مقدم)</option>
<option value="47818080808080F280o">بافق 4003 , احمد تشكري</option>
<option value="4C8180808080808680o">بجنورد 3001 , شكراله قنادزاده</option>
<option value="4B8180808080809380o">برازجان 2602 , سردار ملائي</option>
<option value="4B8180808080808180o">بروجرد 2306 , هادي مطهري</option>
<option value="428180808080808180o">بروجن 2102 , عبدالصالح برجيان</option>
<option value="3F818080808080CA80o">بستان آباد 1820 , يوسف شفايي قره كوشن</option>
<option value="4C8180808080809580o">بشرويه 3034 , علي مقيم زاده</option>
<option value="4D8180808080808580o">بم 4109 , شركت گندم صنعت بم ( حسن عليزاده )</option>
<option value="35818080808080A681o">بناب 1802 , محمود و قلي داداش كريمي</option>
<option value="47818080808080B080o">بندر انزلي 1962 , ناصر فرحناك</option>
<option value="4D8180808080809280o">بندر عباس  4301 , رضا دهقاني - نجفعلي ياوري</option>
<option value="4F818080808080CB80o">بندر عباس  4302 , محمد دلپذير</option>
<option value="4B8180808080809680o">بندر كنگان 2606 , احمد صبور</option>
<option value="4B8180808080809480o">بندر گناوه  2604 , نصراله خدري</option>
<option value="4F818080808080CF80o">بندر لنگه  4306 , بابك تراكمه</option>
<option value="3F8180808080808E80o">بهار 1505 , محمد عليزاده</option>
<option value="4B8180808080808980o">بهبهان 2401 , سيد ناصر نور افشان</option>
<option value="4C8180808080809B80o">بهشهر 3302 , فخرالدين روحاني</option>
<option value="4B8180808080809280o">بوشهر 2601 , سيد كاظم جعفري</option>
<option value="4B8180808080809580o">بوشهر 2605 , عبدالمحمد كارداني</option>
<option value="3F818080808080D480o">بوكان 1916 , حسن قرني</option>
<option value="3F818080808080D580o">بوكان 1917 , جعفر شجاعي</option>
<option value="3F8180808080809A80o">بيجار 1601 , تيمور قرباني</option>
<option value="4C8180808080808880o">بيرجند 3005 , محمدتقي كاشتني</option>
<option value="498180808080809180o">بيضاء 2228 , علي زارع</option>
<option value="3F818080808080A780o">پارس آباد 1705 , هوشنگ مهديزاده</option>
<option value="46818080808080A580o">پاكدشت 1210 , عين اله شكرزاده - خانم زهرا عليزاده</option>
<option value="4B8180808080808780o">پلدختر 2310 , حسين نجفي</option>
<option value="3F818080808080A080o">پيرانشهر 1604 , ابوبكر معروفي اقدم - سيد حمزه محمودي</option>
<option value="3D8180808080809180o">تاكستان 1354 , ايرج رحماني</option>
<option value="478180808080809780o">تبريز 1801 , علي و جواد قائميان</option>
<option value="38818080808080C882o">تبريز 1804 , احمد شيباني اقدم</option>
<option value="478180808080809980o">تبريز 1810 , ناصر خودكار</option>
<option value="38818080808080C982o">تبريز 1811 , مجيد امنيت پرست</option>
<option value="38818080808080CA82o">تبريز 1815 , شركت سفيد بام تبريز (محمد مهدي قائميان اسكوئي )</option>
<option value="38818080808080E382o">تربت جام 3014 , شهرام كاظمي</option>
<option value="38818080808080DD82o">تربت حيدريه 3004 , محسن قنادان</option>
<option value="38818080808080E782o">تربت حيدريه 3019 , غلامرضا و حميد رضا توكلي</option>
<option value="4C818080808080AC80o">تفت 4004 , رمضان اسماعيلي</option>
<option value="3D8180808080809480o">تفرش 1411 , مجتبي قنبري</option>
<option value="47818080808080A880o">تكاب 1919 , رحمت اله الماسي</option>
<option value="38818080808080F082o">تنكابن 3312 , محمد اسماعيل جوادزاده</option>
<option value="508180808080808A80o">تهران 109 , يحيي وطندوست</option>
<option value="3C8180808080808080o">تهران 1002 , شركت پيشرفت ( مجيد خدادوستان )</option>
<option value="428180808080809B80o">تهران 1003 , ليون استپانيان - محمود قلي پور</option>
<option value="38818080808080AB82o">تهران 1004 , عليرضا رأسي</option>
<option value="428180808080809C80o">تهران 1005 , اكبر ظفر قندي</option>
<option value="428180808080809D80o">تهران 1006 , شركت تكاران( محمد قيصري)</option>
<option value="428180808080809E80o">تهران 1008 , محمد باقر حسين پور ديرجي</option>
<option value="428180808080809F80o">تهران 1009 , محمد عليشاهي نوراني</option>
<option value="42818080808080A080o">تهران 1010 , حسين دم آبه</option>
<option value="42818080808080A180o">تهران 1011 , فرامرز اكبري كلخوران</option>
<option value="42818080808080A280o">تهران 1012 , محمد حسين زاده - سيد مرتضي خاكره</option>
<option value="38818080808080AC82o">تهران 1013 , اسداله شاه محمدي</option>
<option value="808080808080809280 ">تهران 1014 , علي حسين عطائي</option>
<option value="42818080808080A380o">تهران 1015 , خدا رحم كيخانزاده</option>
<option value="42818080808080A480o">تهران 1016 , احمد عليشاه</option>
<option value="42818080808080A580o">تهران 1018 , امير كامران خواجوي</option>
<option value="42818080808080A680o">تهران 1020 , اكبر محمدي طاهري - مهدي همتيان</option>
<option value="42818080808080A780o">تهران 1021 , مرتضي قلي بيگيان</option>
<option value="38818080808080AD82o">تهران 1022 , احمد قاسمي</option>
<option value="42818080808080A880o">تهران 1023 , فرج اله مهدوي نيا</option>
<option value="808080808080809180 ">تهران 1024 , جهانگير امرجي - علي شاه محمدي</option>
<option value="42818080808080A980o">تهران 1026 , فرهاد پور گشتاسبي</option>
<option value="42818080808080AA80o">تهران 1027 , هوسپ سيمون نرسسيان</option>
<option value="38818080808080AE82o">تهران 1028 , محمد فرخي</option>
<option value="42818080808080AB80o">تهران 1029 , حسن شهياري - خانم مهوش علمداري</option>
<option value="42818080808080AC80o">تهران 1030 , آلبرت بابائيان</option>
<option value="42818080808080AD80o">تهران 1031 , محمد رضا صيادي - عليرضا طباطبائي</option>
<option value="42818080808080AE80o">تهران 1032 , علي اصغر وهاب كاشاني</option>
<option value="438180808080808180o">تهران 1034 , رضا مهدي زاده حجار - رسول داداشيان</option>
<option value="438180808080808280o">تهران 1035 , محمود بهمني - محمدعلي پورعطا</option>
<option value="438180808080808380o">تهران 1036 , محسن و غلامحسين قادري</option>
<option value="38818080808080AF82o">تهران 1037 , شهرام و خسروخان حسيني نور</option>
<option value="438180808080808480o">تهران 1038 , عباس درخشنده</option>
<option value="438180808080808580o">تهران 1039 , آندرانيك آقاجانيان</option>
<option value="438180808080808680o">تهران 1040 , محمد رضا لاشئي</option>
<option value="438180808080808780o">تهران 1041 , سيامك حريري</option>
<option value="38818080808080B082o">تهران 1042 , سيد حسين حاج سيد محمد عرب</option>
<option value="38818080808080B182o">تهران 1043 , شركت هنر خودرو ( حميد مير آبادي )</option>
<option value="438180808080808880o">تهران 1044 , قاسم غيوران</option>
<option value="438180808080808980o">تهران 1045 , علي اصغر دادفر</option>
<option value="438180808080808A80o">تهران 1046 , حسن راستي</option>
<option value="438180808080808B80o">تهران 1047 , ايرج جزء رمضاني</option>
<option value="438180808080808C80o">تهران 1048 , ابراهيم راسي</option>
<option value="438180808080808D80o">تهران 1049 , علي اكبر خان محمدي - صادق شفقي</option>
<option value="438180808080808E80o">تهران 1050 , مهدي اعظمي - علي كريمي</option>
<option value="438180808080808F80o">تهران 1052 , اصغر - نقي - فرهاد كريمي</option>
<option value="438180808080809080o">تهران 1053 , محمد رضا عسگري طاري</option>
<option value="438180808080809180o">تهران 1055 , امير قلي عليمرداني - عنبر سلوكي - قدير زماني</option>
<option value="38818080808080B282o">تهران 1056 , احمد رحيمي نژاد</option>
<option value="38818080808080B382o">تهران 1057 , حسن فاميل دردشتي</option>
<option value="438180808080809280o">تهران 1058 , قاسم عادل منش - خانم قدسي واحدي</option>
<option value="38818080808080B482o">تهران 1060 , يداله چنگي آشتياني</option>
<option value="438180808080809380o">تهران 1061 , مهدي تدين فر</option>
<option value="38818080808080B582o">تهران 1064 , عباس واعظ سميعي</option>
<option value="438180808080809480o">تهران 1067 , نمايشگاه مركزي غرب</option>
<option value="438180808080809580o">تهران 1068 , نمايشگاه بهشتي</option>
<option value="438180808080809680o">تهران 1069 , تعميرگاه مركزي شرق</option>
<option value="438180808080809780o">تهران 1070 , تاكسيراني تهران ( سيد جلال هاشمي عرب )</option>
<option value="38818080808080B682o">تهران 1071 , ايوب صباغي</option>
<option value="438180808080809880o">تهران 1096 , محمد صادق سازش</option>
<option value="438180808080809980o">تهران 1097 , مجتمع تعميرگاهي شهداي تاكسيراني(سيدجلال هاشمي عرب)</option>
<option value="438180808080809A80o">تهران 1102 , قوه قضائيه ( اكبر طبري )</option>
<option value="438180808080809B80o">تهران 1105 , تعميرگاه مركزي غرب</option>
<option value="438180808080809C80o">تهران 1109 , سيد محمد موسوي</option>
<option value="438180808080809D80o">تهران 1110 , جهانگير امرجي</option>
<option value="438180808080809E80o">تهران 1111 , مهرزاد مهرداد</option>
<option value="458180808080808280o">تهران 1112 , كاظم محمدي نيكخواه</option>
<option value="38818080808080B782o">تهران 1113 , رمضانعلي يحيايي </option>
<option value="358180808080808481o">تهران 1114 , امداد خورو ايران</option>
<option value="468180808080809280o">تهران 1115 , تعاوني تاكسي بار تهران ( نادر هوشمنديار )</option>
<option value="38818080808080B882o">تهران 1117 , احمد حسن تهراني</option>
<option value="38818080808080B982o">تهران 1118 , يوسف نصير پور سر دهايي</option>
<option value="468180808080809480o">تهران 1119 , مجتبي فتحي فرزانه</option>
<option value="468180808080809580o">تهران 1120 , حسن نديمي اكباتاني</option>
<option value="38818080808080BA82o">تهران 1121 , شركت روانسوز فرجام ( فرهاد بيك ور ديلو )</option>
<option value="468180808080809680o">تهران 1122 , حسن فاميل دردشتي</option>
<option value="38818080808080BB82o">تهران 1123 , علي جنگي</option>
<option value="468180808080809780o">تهران 1124 , صميد قديمي نوران</option>
<option value="468180808080809880o">تهران 1125 , براتعلي محمدزاده</option>
<option value="468180808080809A80o">تهران 1126 , شركت منتخب يدك تهران ( جعفر خوش چشمي)</option>
<option value="38818080808080BC82o">تهران 1127 , شركت واصاتو ( عبدالعظيم بزاز زاده )</option>
<option value="468180808080809B80o">تهران 1128 , محسن اسماعيلي</option>
<option value="468180808080809C80o">تهران 1129 , جواد سميعي زفرقندي</option>
<option value="468180808080809D80o">تهران 1130 , حسن ابريشميان</option>
<option value="38818080808080BD82o">تهران 1132 , علي زندي</option>
<option value="38818080808080BE82o">تهران 1133 , آسيا خودرو ( يزداني )</option>
<option value="468180808080809E80o">تهران 1134 , اكبر حصاري</option>
<option value="468180808080809F80o">تهران 1135 , جمشيد الماسيان</option>
<option value="508180808080808780o">تهران 5004 , رضا اكبري</option>
<option value="E88280808080806C80o">تهران 5020 , سيد مير حسيني</option>
<option value="4F818080808080D880o">تهران 5022 , اسداله شيرمحمدي</option>
<option value="E88280808080807080o">تهران 5073 , نشان بدروستي</option>
<option value="E88280808080809480o">تهران 5076 , داود نمازي</option>
<option value="E88280808080809880o">تهران 5082 , محمد قارازاده-نيكخواه</option>
<option value="E88280808080807380o">تهران 5087 , حجت ا... ذوالفقاري نسب</option>
<option value="E88280808080807680o">تهران 5130 , قاسم فتاحي ظفرقندي</option>
<option value="E88280808080807A80o">تهران 5145 , ايرج مهرورزپور</option>
<option value="4F818080808080D580o">تهران 5148 , حميد احمدي</option>
<option value="508180808080808880o">تهران 5150 , محمد حسن خليلي</option>
<option value="E88280808080807C80o">تهران 5158 , محمد حسين شاه آبادي فراهاني</option>
<option value="E88280808080807D80o">تهران 5228 , شاهواز كواكيان</option>
<option value="E88280808080808281o">تهران 5238 , عليرضا بصيري</option>
<option value="E88280808080808581o">تهران 5245 , قدمعلي فراهاني</option>
<option value="E88280808080808981o">تهران 5252 , آبرام عيوضي</option>
<option value="E8828080808080A780o">تهران 5309 , سيد خالق فتوحي اونجي</option>
<option value="E88280808080809280o">تهران 5313 , امير تركي</option>
<option value="508180808080808980o">تهران 5373 , مهدي قياسي</option>
<option value="E88280808080809A80o">تهران 5416 , غلامحسين ونكي</option>
<option value="E88280808080809E80o">تهران 5460 , اردشير محمدي آهني</option>
<option value="E88280808080805180o">تهران 80117 , حاجي مراد حيدري</option>
<option value="02828080808080B580o">تهران 80122 , غلامعلي احمدي</option>
<option value="38818080808080C182o">جاجرود 1209 , سيد حميد رضا صفي زاده</option>
<option value="D38280808080803180o">جاجرود 12091 , صفي زاده</option>
<option value="478180808080809880o">جلفا 1807 , علي ربيعي - سلمان احمدزاده</option>
<option value="498180808080808480o">جهرم 2202 , حبيب اله شيرازي</option>
<option value="498180808080808E80o">جهرم 2216 , عبدالحسين رحمانيان كوشككي</option>
<option value="4F818080808080B780o">جيرفت 4115 , عبدالعظيم جاوداني</option>
<option value="4D8180808080808E80o">چابهار 4210 , بهروز قلجه</option>
<option value="38818080808080F882o">چالوس 3326 , سلمان صائميان</option>
<option value="4C8180808080809680o">چناران 3035 , هوشنگ محبوب</option>
<option value="38818080808080C382o">حسن آباد 1216 , محمد حسن اينانلو</option>
<option value="4D8180808080808D80o">خاش 4209 , حسين حاجي بيگي</option>
<option value="498180808080809580o">خرم آباد 2301 , يحيي معيني چاغروند</option>
<option value="4B8180808080808280o">خرم آباد 2307 , علي كوليوند</option>
<option value="4B8180808080808380o">خرم آباد 2308 , بهمن گودرزي</option>
<option value="478180808080809B80o">خسرو شهر 1819 , ايوب نجف شاهي خسروشاهي</option>
<option value="3F818080808080DC80o">خشكه بيجار 1961 , حسن محمدي</option>
<option value="478180808080808680o">خمين 1402 , حسين طاهري</option>
<option value="428180808080808A80o">خنج 2221 , قدرت اله حسيني</option>
<option value="38818080808080CB82o">خوانسار 2005 , مجتبي مير شاه ولايتي</option>
<option value="3F818080808080CE80o">خوي 1904 , عباسعلي افشارنيا</option>
<option value="47818080808080A680o">خوي 1913 , مهدي رحماندوست</option>
<option value="428180808080808680o">داراب 2217 , اكبر سليمي</option>
<option value="38818080808080CE82o">داران 2013 , محمد حسين احمدي داراني</option>
<option value="4C818080808080A980o">دامغان  3404 , رضا عباسي - علي امينيان</option>
<option value="4B8180808080808A80o">دزفول 2402 , محمدرضا بهروز</option>
<option value="428180808080809380o">دزفول 2416 , عبدالرحيم ميرزاپور</option>
<option value="478180808080808C80o">دليجان  1416 , نظرعلي شفيعي</option>
<option value="4F818080808080DB80o">دليجان  6307 , اكبر ابراهيمي</option>
<option value="3D8180808080808A80o">دماوند 1203 , مجتبي گودرزي</option>
<option value="4B8180808080809980o">دهدشت 2704 , قباد زمان</option>
<option value="4B8180808080808880o">دورود 2311 , محمود رك رك</option>
<option value="38818080808080F682o">رامسر 3322 , لطف اله ترابي</option>
<option value="428180808080809580o">رامهرمز 2418 , روزبه نيكو</option>
<option value="46818080808080B080o">رباط كريم 1236 , محمود زارعي</option>
<option value="3F818080808080D780o">رشت 1951 , اسماعيل متقالچي</option>
<option value="3F818080808080D880o">رشت 1958 , محمد حدادفر</option>
<option value="47818080808080AF80o">رشت 1959 , علي حامد مبرا</option>
<option value="3F818080808080D980o">رشت 1960 , شركت شكوفه موتورگيلان (عليرضا پوررستگار ) </option>
<option value="3F818080808080DA80o">رشت 1970 , رحيم بلندپور</option>
<option value="3F818080808080DB80o">رشت 1976 , محمد اسماعيل حسين پور كرد محله</option>
<option value="3F818080808080E380o">رضوانشهر 1973 , بهنام تالش ساساني</option>
<option value="4C818080808080B380o">رفسنجان 4106 , يداله امجدي</option>
<option value="3F818080808080E180o">رودسر 1971 , صادق حاجي آقازاده رودسري</option>
<option value="46818080808080AD80o">رودهن 1228 , عباس رسولي اصفهاني</option>
<option value="4D8180808080808880o">زابل 4204 , عباس نجفي</option>
<option value="4D8180808080808680o">زاهدان  4201 , علي و محمدزضا آذرخشي</option>
<option value="4F818080808080BD80o">زاهدان  4205 , شركت تفتان خودرو ( علي آذرخشي )</option>
<option value="4D8180808080808A80o">زاهدان  4207 , زاهدان خودرو ( آذرخشي )</option>
<option value="4F818080808080C780o">زاهدان  4208 , احمد نجفي</option>
<option value="38818080808080CF82o">زرين شهر 2014 , سيد محمود حسيني</option>
<option value="3D8180808080809A80o">زنجان 1451 , علي اكبر قاسمي - منصور متين فر</option>
<option value="3D8180808080809E80o">زنجان 1452 , علي اكبر عباسيون</option>
<option value="478180808080808D80o">زنجان 1455 , شركت قوا خودرو ( سعيد ناصري )</option>
<option value="47818080808080F080o">ساري 3301 , سيد محمود شاكري</option>
<option value="38818080808080F282o">ساري 3318 , شركت حاشيه خزر                  ( باقر آهنگري )</option>
<option value="4C818080808080A280o">ساري 3324 , ابراهيم فرجي</option>
<option value="38818080808080F382o">ساري 3327 , هومن گلبادي</option>
<option value="4C818080808080A380o">ساري 3328 , محمد جعفر صادقي كيادهي</option>
<option value="E88280808080804780o">ساري 7504 , يوسف رضي پور</option>
<option value="478180808080808B80o">ساوه  1415 , علي اكبر شيري</option>
<option value="508180808080808580o">ساوه  7617 , محمدرضا بوئيني</option>
<option value="38818080808080E582o">سبزوار 3018 , سيد حسن فاظلي ثاني</option>
<option value="38818080808080E682o">سبزوار 3032 , شركت خودرو سامان شرق ( سيد ابوالقاسم حدادي)</option>
<option value="B78080808080808080o">سراب 1816 , علي لطفي</option>
<option value="4F818080808080C380o">سراوان 4206 , ارسلان حسين بر</option>
<option value="3F818080808080A280o">سقز 1606 , شركت خدماتي سقز خودرو ( بابك وثوقي ) </option>
<option value="3F818080808080D380o">سلماس 1914 , فرزان شوقي</option>
<option value="4C818080808080A880o">سمنان  3402 , شركت اتول سمنان (جواد فاميلي)</option>
<option value="4C818080808080AB80o">سمنان  3408 , شركت سمن كار خودرو ( حسين حقي پناه )</option>
<option value="478180808080809480o">سنندج 1602 , شركت تعاوني 46 ( شهرام محمدي )</option>
<option value="3F8180808080809E80o">سنندج 1603 , شركت خدمات موتوري كردستان(علي حيدري) </option>
<option value="4C818080808080B280o">سيرجان 4104 , عليرضا شول</option>
<option value="4F818080808080A980o">سيرجان 4112 , حسين بهروز بهنام</option>
<option value="4C818080808080A580o">شاهرود 3401 , سيد علي و سيد احمد سيد اردكاني</option>
<option value="4C818080808080A680o">شاهرود 3403 , عباسعلي دانائي</option>
<option value="4C818080808080A780o">شاهرود 3407 , عباس مصلحي</option>
<option value="3F818080808080D280o">شاهين دژ 1911 , رسول چاردولي</option>
<option value="38818080808080D382o">شاهين شهر 2022 , سيدحسين - سيدجواد - سيداميرحسين هاشمي صفت</option>
<option value="3F818080808080C280o">شبستر 1806 , صفر علي پور محمد خان</option>
<option value="47818080808080F380o">شهر بابك  4111 , احمد پورغريب شاهي</option>
<option value="46818080808080A680o">شهرري 1211 , محسن حيدري</option>
<option value="47818080808080BB80o">شهرضا 2004 , سعيد و حميدرضا دباغ</option>
<option value="47818080808080F980o">شهرضا 2040 , مصطفي قيام</option>
<option value="428180808080808080o">شهركرد 2101 , ناصر قاسمي دهكردي</option>
<option value="498180808080808180o">شهركرد 2103 , محمد تقي احمديان</option>
<option value="498180808080808280o">شهركرد 2104 , بهزاد رضايي</option>
<option value="46818080808080A080o">شهريار 1201 , مرتضي محسني</option>
<option value="46818080808080A980o">شهريار 1221 , عزت جعفري</option>
<option value="38818080808080C682o">شهريار 1230 , صمد فروزنده بخش</option>
<option value="428180808080809280o">شوشتر 2415 , محمد رضا ساداتي</option>
<option value="498180808080808380o">شيراز 2201 , اسداله و محمدرضا تسلسم</option>
<option value="498180808080808780o">شيراز 2207 , نادر قجه بيات</option>
<option value="498180808080808880o">شيراز 2209 , عبدالرسول همايوني</option>
<option value="498180808080808A80o">شيراز 2211 , غلامحسين - عليرضا - محمدرضا حداديان</option>
<option value="428180808080808580o">شيراز 2212 , شركت وسام خودرو ( فرزاد والي پور)</option>
<option value="498180808080808B80o">شيراز 2213 , شركت خودروسازان فارس ( غلامحسين گرك يراق )</option>
<option value="498180808080808C80o">شيراز 2214 , شركت تعاوني تاكسيراني ( خليل زارع )</option>
<option value="498180808080808F80o">شيراز 2222 , محمدتقي نايب زاده</option>
<option value="498180808080809080o">شيراز 2225 , نورالدين محمدي</option>
<option value="498180808080809380o">شيراز 2231 , ويس مراد توانا</option>
<option value="4C8180808080808780o">شيروان 3002 , يوسف و ستار ستارزاده</option>
<option value="4B8180808080809B80o">صحنه  2802 , لطيف عزيزي</option>
<option value="47818080808080A180o">صوفيان 1824 , علي طباطبائي ديزجي</option>
<option value="468180808080808680o">صومعه سرا 1956 , ميرشجاع حسيني پناه</option>
<option value="4C8180808080809280o">طبس 3029 , عباس برقي</option>
<option value="38818080808080F182o">عباس آباد 3314 , يوسف فروزان</option>
<option value="3F818080808080C580o">عجب شير 1808 , سيد حسن صولت - جواد پناهي آذر - حاجي آقا باقر پور</option>
<option value="428180808080809880o">علي آباد 3204 , عليرضا عجم حسني - هاشم فرزامي</option>
<option value="4C8180808080808980o">فردوس 3007 , سيد عزيزاله اميني</option>
<option value="38818080808080E482o">فريمان 3017 , محمد زحمتكش</option>
<option value="498180808080808680o">فسا 2206 , شركت خدمات فني عشيره ( غلامحسين بيژني )</option>
<option value="47818080808080D780o">فلاورجان 2015 , شركت ياوران (مجتبي نيروكار )</option>
<option value="38818080808080DA82o">فولادشهر 2042 , شركت مبين خودرو ( عبدالرضا فيروز بخش )</option>
<option value="3F818080808080E080o">فومن 1969 , محمدعلي ولي زاده</option>
<option value="508180808080808B80o">فيروز كوه  85366 , اسداله باطبي</option>
<option value="428180808080808C80o">فيروزآباد 2224 , الله داد كريمي</option>
<option value="4C818080808080A180o">قائمشهر 3311 , معين بندگان</option>
<option value="428180808080808880o">قائميه    2219 , كرم رضائي</option>
<option value="38818080808080DF82o">قائن 3009 , سيد محمد حسين جوادزاده</option>
<option value="4C8180808080809480o">قائنات 3033 , حميد گلكار مقدم</option>
<option value="38818080808080C282o">قرچك ورامين  1215 , كوكعلي سلكي - براتعلي حسن آبادي</option>
<option value="3F818080808080A180o">قروه 1605 , علي اكبر ذوقي</option>
<option value="3D8180808080808F80o">قزوين 1351 , شركت انساب                 (محمد نقي حاجي فتحعلي )</option>
<option value="478180808080808180o">قزوين 1353 , شركت شرق يدك( سيد عبدالعلي تقوي)</option>
<option value="478180808080808280o">قزوين 1355 , ابراهيم احمدي</option>
<option value="478180808080808380o">قزوين 1357 , فتحيه معادي</option>
<option value="38818080808080C782o">قم 1301 , جعفر و جواد اويسي</option>
<option value="3D8180808080808D80o">قم 1302 , شركت تعاوني 307 ( محمد علي فيض )</option>
<option value="478180808080808080o">قم 1303 , سيد محمد برقعي</option>
<option value="38818080808080E882o">قوچان 3020 , احمد محمدي صفدر آبادي و براتعلي پاكزاد مقدم</option>
<option value="428180808080808380o">كازرون 2204 , محمد اسماعيل و سعيد قناعتي</option>
<option value="428180808080808B80o">كازرون 2223 , محمد دولتخواه</option>
<option value="47818080808080C380o">كاشان 2007 , علي صاحب قدم</option>
<option value="47818080808080EE80o">كاشان 2017 , عبداله شريفي مقدم بادي</option>
<option value="47818080808080F480o">كاشان 2028 , سعيد نامي</option>
<option value="38818080808080E282o">كاشمر 3012 , مجيد غلامي</option>
<option value="46818080808080A180o">كرج 1202 , احمد لطيفي پور</option>
<option value="38818080808080BF82o">كرج 1204 , علي سرافراز</option>
<option value="46818080808080A280o">كرج 1205 , شركت يدك خودرو ( حسين عبدالهي)</option>
<option value="38818080808080C082o">كرج 1206 , ابراهيم عبادي</option>
<option value="46818080808080A480o">كرج 1208 , ايرج خاكي فيروز</option>
<option value="46818080808080A780o">كرج 1212 , حسن محمدي</option>
<option value="46818080808080A880o">كرج 1214 , محمد كاظم فرامرزي</option>
<option value="E88280808080808B81o">كرج 5118 , عباس خدابخش</option>
<option value="4F818080808080DA80o">كرج 5241 , عباس عباسي افجه اي</option>
<option value="E88280808080809481o">كرج 10028 , محمد كرامت قره بابا</option>
<option value="D48280808080803780o">كرج 90001 , كاوياني</option>
<option value="4C8180808080809A80o">كردكوي 3208 , محمد علي حاجي عسگري</option>
<option value="4C818080808080B180o">كرمان 4101 , دينيار پيرران نژاد</option>
<option value="4F8180808080809C80o">كرمان 4102 , منصور لولوئي</option>
<option value="4F818080808080A280o">كرمان 4103 , مسعود ايرانمنش</option>
<option value="4F818080808080A680o">كرمان 4110 , شركت تعاوني تاكسيراني كرمان ( محمدعلي سرمست )</option>
<option value="4F818080808080AE80o">كرمان 4113 , علي هنر آموز</option>
<option value="4F818080808080B280o">كرمان 4114 , امين محتشم ماهاني</option>
<option value="4B8180808080809A80o">كرمانشاه  2801 , شركت خودروراه كرمانشاه  ( هادي يعقوب نژاد زنگنه)</option>
<option value="4B8180808080809C80o">كرمانشاه  2803 , امير دودمان تيپي</option>
<option value="4C8180808080808180o">كرمانشاه  2804 , علي جليليان</option>
<option value="4C8180808080808380o">كرمانشاه  2805 , محسن حسيني</option>
<option value="4C8180808080808280o">كرمانشاه  2806 , محمد مهدي زنگنه</option>
<option value="4C8180808080808480o">كرمانشاه  2808 , ملك جليليان</option>
<option value="47818080808080AC80o">كلاچاي 1953 , سيد مهدي سيد جوادين</option>
<option value="428180808080809A80o">كلاله 3207 , عبدالحميد اماني</option>
<option value="38818080808080D782o">كليشاد 2037 , عباسعلي هدايت كليشادي</option>
<option value="46818080808080AF80o">كمال شهر 1232 , محمد علي كهن خاني</option>
<option value="498180808080808080o">كوشك اصفهان 2048 , اكبر مصلحي</option>
<option value="4B8180808080808680o">كوهدشت 2309 , خداداد شاكري</option>
<option value="4F818080808080D180o">كيش 4307 , شركت ولايت كيش ( علي بيگي )</option>
<option value="4B8180808080809880o">گچساران  2703 , فريدون قبادي</option>
<option value="428180808080808780o">گراش 2218 , خليل غلامي</option>
<option value="4C8180808080809880o">گرگان 3202 , فرامرز سازگار</option>
<option value="428180808080809780o">گرگان 3203 , رحمت اله موحدي</option>
<option value="4C818080808080AA80o">گرمسار 3405 , سيد علي خدامي</option>
<option value="47818080808080FB80o">گلپايگان 2045 , حميدرضا اختري</option>
<option value="38818080808080DC82o">گناباد 3003 , حسن نمازي</option>
<option value="4C8180808080809780o">گنبد كاووس 3201 , رحمت اله شيخ ملكي</option>
<option value="4C8180808080809980o">گنبد كاووس 3205 , كاوه شهرام فر</option>
<option value="428180808080809980o">گنبد كاووس 3206 , علي احسان</option>
<option value="428180808080808280o">لار 2203 , سيد عبدالرحيم سجادي - علي اصغر جعفريان</option>
<option value="428180808080808E80o">لار 2230 , عبدالوهاب پاسيار</option>
<option value="498180808080808D80o">لامرد 2215 , مصطفي منصوري</option>
<option value="47818080808080B180o">لاهيجان 1963 , عباس پورنصير</option>
<option value="3F818080808080DE80o">لاهيجان 1968 , سيد محمد امامي لنگرودي</option>
<option value="3F818080808080DF80o">لاهيجان 1975 , احمد تنهايي</option>
<option value="47818080808080AB80o">لنگرود 1952 , سيد محمد امامي </option>
<option value="468180808080808C80o">لنگرود 1957 , فيض اله ترابي</option>
<option value="3F818080808080D680o">ماكو 1918 , مسلم سلطاني ( قره ضياءالدين )</option>
<option value="46818080808080AE80o">ماهدشت 1231 , احمد بيگلر بختياري</option>
<option value="4B8180808080808C80o">ماهشهر 2406 , سيف اله چنگلوائي - فرهاد رئيسي نيا</option>
<option value="38818080808080D682o">مباركه 2035 , خدابخش نصوحي</option>
<option value="478180808080808580o">محلات  1401 , ابراهيم و حميد كاوه اي</option>
<option value="4C818080808080A080o">محمودآباد 3309 , محمد فرهادي</option>
<option value="35818080808080C181o">مراغه  1803 , ايوب خسروشاهي</option>
<option value="478180808080809D80o">مراغه  1822 , محمد وهابيپور</option>
<option value="998080808080808080o">مرند 1813 , احمد رضائي</option>
<option value="3F818080808080C980o">مرند 1818 , اسرافيل عظيمي</option>
<option value="428180808080808480o">مرودشت 2208 , مير علي اكبر لوحي - بهادر شهامت</option>
<option value="428180808080809180o">مسجد سليمان 2413 , شركت سمند جنوب( غلام پور داود)</option>
<option value="3F818080808080A380o">مشكين شهر 1701 , مير علي اصغر معصومي نسب</option>
<option value="38818080808080DE82o">مشهد 3006 , شركت خدمات خودرو توس سيحون (ميرعلي اكبر كاظمي) </option>
<option value="38818080808080E182o">مشهد 3011 , شركت خودرو تابان مشهد ( فرشاد هودانلو )</option>
<option value="4C8180808080808B80o">مشهد 3013 , حسين بيك خراساني</option>
<option value="4C8180808080808C80o">مشهد 3015 , جواد عاكف</option>
<option value="4C8180808080808D80o">مشهد 3016 , سعيد كاظمي - محمد قرباني</option>
<option value="4C8180808080808E80o">مشهد 3021 , تاكسيراني مشهد ( سيد حسين مجتبوي )</option>
<option value="38818080808080E982o">مشهد 3022 , رضا صدر</option>
<option value="4C8180808080808F80o">مشهد 3023 , سيد عليرضا نجفي گل</option>
<option value="4C8180808080809080o">مشهد 3026 , محمد حسين پور اول</option>
<option value="4C8180808080809180o">مشهد 3028 , شركت نماد خودرو ( محمد افشار رضايي )</option>
<option value="38818080808080EA82o">مشهد 3030 , علي فارسيان</option>
<option value="4C8180808080809380o">مشهد 3031 , مرتضي پاكاري ابيز</option>
<option value="3F8180808080808A80o">ملاير 1502 , خسرو صارمي</option>
<option value="3F8180808080809780o">ملاير 1513 , احمد عبدي كسبي</option>
<option value="478180808080809280o">ملاير 1514 , عبدالمجيد عليشاهي</option>
<option value="478180808080809E80o">ملكان 1823 , منصور رشدي</option>
<option value="47818080808080B280o">منجيل 1974 , هاردوسينك</option>
<option value="3F818080808080CD80o">مهاباد 1903 , علي اشرف آقازاده</option>
<option value="4C818080808080AD80o">مهريز 4005 , جلال ابوئي مهريزي</option>
<option value="3F818080808080D180o">مياندوآب  1908 , رحيم و بهرام آشام</option>
<option value="3F818080808080C880o">ميانه 1812 , ابراهيم ملكي</option>
<option value="4C818080808080AE80o">ميبد 4010 , عبداله نخعي سرو</option>
<option value="4F818080808080CE80o">ميناب 4304 , ابراهيم سلطاني</option>
<option value="38818080808080D082o">نايين 2018 , مرتضي افشاري</option>
<option value="47818080808080B480o">نجف آباد 2003 , عطااله نوريان</option>
<option value="47818080808080BF80o">نطنز 2006 , محمد و باقر اسلامي</option>
<option value="3F818080808080CC80o">نقده 1902 , حميد قاسمي</option>
<option value="47818080808080A780o">نقده 1915 , قاسم قره چالي</option>
<option value="38818080808080EF82o">نكاء 3310 , قربانعلي زائر اومالي</option>
<option value="478180808080809680o">نمين 1708 , فريد جعفري</option>
<option value="3F8180808080808680o">نهاوند 1501 , مسعود ابوالفتحي</option>
<option value="4C8180808080809F80o">نور 3306 , حسين فرهادي</option>
<option value="498180808080808980o">نور آباد 2210 , حسين رشيدي</option>
<option value="498180808080809480o">نور آباد ممسني 2232 , نادر غلامي</option>
<option value="38818080808080F582o">نوشهر 3321 , ايرج شادمان</option>
<option value="498180808080809280o">ني ريز 2229 , عليرضا شيباني</option>
<option value="4C818080808080B080o">نير 4015 , محمود كافي</option>
<option value="38818080808080E082o">نيشابور 3010 , قاسم باطاني - علي اكبر سيد آبادي</option>
<option value="478180808080809C80o">هريس 1821 , تقي حسين پورآذر</option>
<option value="47818080808080AE80o">هشتپر 1955 , احمد آسوبار</option>
<option value="3F818080808080B080o">هشترود 1805 , كريم و سيروس لطفي</option>
<option value="38818080808080C482o">هشتگرد 1224 , احمد رستگار</option>
<option value="478180808080808E80o">همدان 1503 , موسسه دارالايتام ( محمد كاظم هاشمي نيكو )</option>
<option value="478180808080808F80o">همدان 1504 , مسعود شعباني</option>
<option value="3F8180808080809380o">همدان 1506 , علي حسين ميرزائي پارسا</option>
<option value="478180808080809080o">همدان 1510 , شركت تاكسيراني همدان ( فرهاد غياثوند )</option>
<option value="478180808080809180o">همدان 1512 , علي ميرزايي پارسا</option>
<option value="478180808080809380o">همدان 1515 , سيد محمد مهدي اردستاني زاده</option>
<option value="3F8180808080808280o">هيدج 1454 , شركت چرخشگر                (حسن نقي لو )</option>
<option value="46818080808080A380o">ورامين  1207 , اسفنديار بختياري</option>
<option value="46818080808080AA80o">ورامين  1225 , سيد امير ناصر قاليشوراني</option>
<option value="46818080808080AB80o">ورامين  1229 , حسين ميري</option>
<option value="46818080808080AC80o">ورامين  1234 , موسي الرضا خوش آبي</option>
<option value="47818080808080FA80o">ورنامخواست 2043 , شركت كاويان زرين ( سيروس لنباني )</option>
<option value="4B8180808080809780o">ياسوج 2701 , افضل دهرابپور</option>
<option value="47818080808080F180o">يزد 4002 , سيد علي جليلي</option>
<option value="4D8180808080809380o">يزد 4006 , ناصر جعفري نژاد</option>
<option value="4D8180808080809580o">يزد 4008 , سيد علي حسيني پورهدش</option>
<option value="4D8180808080809680o">يزد 4009 , شركت اعتماد يزد</option>
<option value="4D8180808080809780o">يزد 4012 , علي اكبر محيط پور</option>
<option value="4F8180808080808F80o">يزد 4014 , مهدي كربلا ئيان</option>
<option value="4F8180808080809780o">يزد 4017 , شركت پويا تعمير شكوه ( ايرج امير دوسرا )</option>
</select>
							</td>
						</tr>

					<tr class="editRow1" style="display:inline" id="gheireBalini"><td colspan="6">
						<table cellpadding="0" cellspacing="0" width="100%" dir="rtl"><tr>
						<td class="editLabel">پيش بيني مدت زمان تعمير:</td>
						<td class="editStar"></td>
						<% if (lock) {%>
							<td class="fieldDescription"> <!-- bean : write name="emdadForm" property="modatTamir"/ --> روز</td>
						<% }else{ %>
							<td span class="fieldDescription"><input type="text" name="modatTamir" size="10" maxlength="10" styleClass="field" onchange='showJagozin0();'/> روز</td>
						<%}%>
	                    <td class="editLabel">وضعيت خدمت:</td>
                        <td class="editStar">*</td>
                        <td>
                            <select name="vazeatKhedmatId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()"><option value="" selected="selected">------</option>
<option value="768080808080808480o">o</option>
<option value="DA8080808080808280o">اعزام به تعميرگاه</option>
<option value="768080808080808180o">در حال انجام</option>
<option value="768080808080808380o">در حال حمل با جرثقيل</option>
<option value="D68080808080808280o">شروع به كار</option>
<option value="DA8080808080808380o">منتظر بازديد مامور بيمه</option>
<option value="768080808080808280o">منتظر جرثقيل</option>
<option value="378180808080809A80o">نياز به قطعه دارد</option></select>
                        </td>
</tr></table></td>
					</tr>

					<!----------------------------------------->


					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">توضيحات:</td>
						<td class="editStar"></td>
						<td> <input type="textarea" name="tozihat" styleClass="field" rows="3" cols="50" onkeypress="return submitenter2(this,event) && checkLength(256)"/></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0"><td colspan="6">
						<table cellpadding="0" cellspacing="0" width="100%" dir="rtl"><tr>
						<td class="editLabel">نوع خدمت ويزه:</td>
						<td class="editStar">*</td>
						<td>
							<select name="noeKhedmateVije" size="1"><option value="0">------</option>
<option value="1">تعمير</option>
<option value="2">تصادف-مشترک مقصراست</option>
<option value="3">تصادف-مقصرحادثه دارد</option>
<option value="4">تصادف-مقصرمشترک</option>
<option value="5">حادثه</option>
<option value="6">سرويس دوره اي</option>
<option value="7">سرقت</option></select>
						</td>
						<td class="editLabel">فاصله از نمايندگي:</td>
						<td class="editStar">*</td>
						<td><input type="text" property="faseleAzNamayandegi"  size="5" maxlength="4" styleClass="field" />
						</td>
</tr></table></td>
					</tr>

					<tr class="editRow0" style="display:none" id="khodroJagozin1" >
						<td></td>
						<td></td>
						<td>
							<% if (!lock) {%>
								<input type="button" value="صدور دستور کار خودرو جايگزين" onClick='javascript:createEmdad4();'/>
							<%}else{}%>
						</td>

					</tr>

					<!----------------------------------------->

					<tr class="editRow0" style="display:none" id="khodroJagozin2" >
						<td class="editLabel">وضعيت خودروهاي جايگزين:</td>
						<td class="editStar"></td>
						<td class="readData">
							<input type="hidden" name="moshtarakId2" value="<!-- bean : write name="moshtarakId"/ -->"/>
							<a href="javascript:khodrojagozinVazeat()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg3"></a>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td colspan="3">
							<div style="display:none;height:100px;" id="khodrojagozinVazeatDiv">
								<iframe width="100%" height="100%" src="" frameborder="1" name="khodrojagozinVazeatFrame" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->
<tr align="left">
	<td height="70" colspan="20" align="center">
		<input type="hidden" name="action_type" />
		<input type="hidden" name="id" />
		<input type="hidden" name="curpage" />
		<input type="hidden" name="order"/>
		<input type="hidden" name="sorttype" />
		<input type="submit" value="ثبت" class="emdadButton" onClick="javascript:chkSabt(this);" />&nbsp;&nbsp;
		<input type="reset"  value="حالت اول" styleClass="emdadButton" />&nbsp;&nbsp;
		<input type="button" value="انصراف" class="emdadButton" onclick="javascript:SureCancle2();">&nbsp;&nbsp;
		<!-- html : cancel value="انصراف" styleClass="emdadButton" / -->&nbsp;&nbsp;
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
</form>
<!-- % 
System.out.println("edit.jsp ,"+((new java.util.Date()).getTime()-t1)); 
% -->

<!----------------------------------------->

		<logic:equal name="editAction" value="true">
			<script language="JavaScript">
				//alert("000");
				selectEmdadgar( < bean : write name="emdadForm" property="noeEmdadgarId" /> ); 
				//alert("111");
				document.getElementById("< bean : write name="emdadForm" property="noeEmdadgarId" />").style.display = "inline";				
				//setEmdadForEdit( < bean : write name="emdadForm" property="noeEmdadgarId" />, < bean : write name="emdadForm" property="emdadgarId" />);
				//alert( "222" );
			</script>
			<!-- bean : write name="emdadForm" property="emdadgarId" / -->
		</logic:equal>				

<script type="text/javascript" language="Javascript1.1">
	setForm(document.emdadForm);
	setEntity("Emdad");
	document.emdadForm.rokhdadId.changed = true;
	document.emdadForm.moshtarakId.changed = true;
	document.emdadForm.moshtarakId1.changed = true;
	document.emdadForm.moshtarakId2.changed = true;
	document.emdadForm.khvz.changed = true;
	selectField();
    if (document.emdadForm.action_type.value=="create"){
        document.emdadForm.action="/emdad/c/validateemdad.run";
    }else{
        document.emdadForm.action="/emdad/u/validateemdad.run";
    }
    showJagozin(1);
    showJagozin(2);
	//rokhdadDetails();
	//moshtarakDetails();
	document.emdadForm.zamanEzam.focus();
	parent.window.resizeTo(screen.width*0.7,screen.height*0.94);
</script>
<script type="text/javascript" language="Javascript1.1"> 

<!-- Begin 

     var bCancel = false; 

    function validateEmdadForm(form) {                                                                   
        if (bCancel) 
      return true; 
        else 
       return validateRequired(form) && validateDate(form) && validateMask(form) && validateIntRange(form); 
   } 

    function required () { 
     this.aa = new Array("zamanEzam", "تاريخ اعزام نبايد خالي باشد", new Function ("varName", "this.datePatternStrict='yyyy/MM/dd';  return this[varName];"));
     this.ab = new Array("rokhdadId", "رخداد نبايد خالي باشد", new Function ("varName", " return this[varName];"));
     this.ac = new Array("vazeatKhedmatId", "وضعيت خدمت نبايد خالي باشد", new Function ("varName", " return this[varName];"));
     this.ad = new Array("ezamgarId", "اعزام گر نبايد خالي باشد", new Function ("varName", " return this[varName];"));
     this.ae = new Array("kilometerKarkard", "کيلومتر کارکرد نبايد خالي باشد", new Function ("varName", "this.mask=/^[0-9]*$/;  return this[varName];"));
     this.af = new Array("faseleAzNamayandegi", "فاصله از نمايندگي نبايد خالي باشد", new Function ("varName", "this.mask=/^[0-9]*$/;  return this[varName];"));
     this.ag = new Array("zamanShoro", "تاريخ شروع به کار امدادگر نبايد خالي باشد", new Function ("varName", "this.datePatternStrict='yyyy/MM/dd';  return this[varName];"));
     this.ah = new Array("zamanPayan", "تاريخ پايان کار نبايد خالي باشد", new Function ("varName", "this.datePatternStrict='yyyy/MM/dd';  return this[varName];"));
     this.ai = new Array("zamanPayan2", "زمان پايان کار نبايد خالي باشد", new Function ("varName", " return this[varName];"));
     this.aj = new Array("zamanShoro2", "زمان شروع به کار امدادگر نبايد خالي باشد", new Function ("varName", " return this[varName];"));
     this.ak = new Array("zamanEzam2", "زمان اعزام نبايد خالي باشد", new Function ("varName", " return this[varName];"));
     this.al = new Array("noeEmdad", "نوع امداد نبايد خالي باشد", new Function ("varName", "this.min='1'; this.max='10';  return this[varName];"));
     this.am = new Array("rahAndazi", "راه اندازي نبايد خالي باشد", new Function ("varName", " return this[varName];"));
    } 

    function DateValidations () { 
     this.aa = new Array("zamanEzam", "تاريخ اعزام تاريخ نا معتبر است!", new Function ("varName", "this.datePatternStrict='yyyy/MM/dd';  return this[varName];"));
     this.ab = new Array("zamanShoro", "تاريخ شروع به کار امدادگر تاريخ نا معتبر است!", new Function ("varName", "this.datePatternStrict='yyyy/MM/dd';  return this[varName];"));
     this.ac = new Array("zamanPayan", "تاريخ پايان کار تاريخ نا معتبر است!", new Function ("varName", "this.datePatternStrict='yyyy/MM/dd';  return this[varName];"));
     this.ad = new Array("zamanVagheiPayan", "زملن واقعي پايان کار امدادگر تاريخ نا معتبر است!", new Function ("varName", "this.datePatternStrict='yyyy/MM/dd';  return this[varName];"));
     this.ae = new Array("zamanVagheiShoro", "زمان واقعي شروع به کار امدادگر تاريخ نا معتبر است!", new Function ("varName", "this.datePatternStrict='yyyy/MM/dd';  return this[varName];"));
     this.af = new Array("zamanVagheiEzam", "زمان واقعي اعزام امدادگر تاريخ نا معتبر است!", new Function ("varName", "this.datePatternStrict='yyyy/MM/dd';  return this[varName];"));
    } 

    function mask () { 
     this.aa = new Array("kilometerKarkard", "کيلومتر کارکرد نامعتبر است", new Function ("varName", "this.mask=/^[0-9]*$/;  return this[varName];"));
     this.ab = new Array("faseleAzNamayandegi", "فاصله از نمايندگي نامعتبر است", new Function ("varName", "this.mask=/^[0-9]*$/;  return this[varName];"));
     this.ac = new Array("hazinehJarsaghil", "هزينه جرثقيل نامعتبر است", new Function ("varName", "this.mask=/^[0-9]*$/;  return this[varName];"));
     this.ad = new Array("hazinehBoxel", "هزينه بکسل نامعتبر است", new Function ("varName", "this.mask=/^[0-9]*$/;  return this[varName];"));
     this.ae = new Array("modatTamir", "پيش بيني مدت زمان تعمير نامعتبر است", new Function ("varName", "this.mask=/^[0-9]*$/;  return this[varName];"));
    } 

    function intrange () { 
     this.aa = new Array("noeEmdad", "نوع امداد نبايد خالي باشد.", new Function ("varName", "this.min='1'; this.max='10';  return this[varName];"));
    } 



function validateFloatRange(form) {
                var bValid = true;
                var focusField = null;
                var i = 0;
                var fields = new Array();
                oRange = new floatRange();
                for (x in oRange) {
                    if ((form[oRange[x][0]].type == 'text' ||
                         form[oRange[x][0]].type == 'textarea') &&
                        (form[oRange[x][0]].value.length > 0)) {
                        var fMin = parseFloat(oRange[x][2]("min"));
                        var fMax = parseFloat(oRange[x][2]("max"));
                        var fValue = parseFloat(form[oRange[x][0]].value);
                        if (!(fValue >= fMin && fValue <= fMax)) {
                            if (i == 0) {
                                focusField = form[oRange[x][0]];
                            }
                            fields[i++] = oRange[x][1];
                            bValid = false;
                        }
                    }
                }
                if (fields.length > 0) {
                    focusField.focus();
                    reportErrors(fields);
                    //alert(fields.join('\n'));
                }
                return bValid;
            }
function validateByte(form) {
                var bValid = true;
                var focusField = null;
                var i = 0;
                var fields = new Array();
                oByte = new ByteValidations();
                for (x in oByte) {
                    if ((form[oByte[x][0]].type == 'text' ||
                         form[oByte[x][0]].type == 'textarea' ||
                         form[oByte[x][0]].type == 'select-one' ||
                         form[oByte[x][0]].type == 'radio') &&
                        (form[oByte[x][0]].value.length > 0)) {
                        var iValue = parseInt(form[oByte[x][0]].value);
                        if (isNaN(iValue) || !(iValue >= -128 && iValue <= 127)) {
                            if (i == 0)
                                focusField = form[oByte[x][0]];
                            fields[i++] = oByte[x][1];
                            bValid = false;
                        }
                    }
                }
                if (fields.length > 0) {
          
                   focusField.focus();
                   reportErrors(fields);
                   //alert(fields.join('\n'));
                }
                return bValid;
            }
function validateMaxLength(form) {
                var bValid = true;
                var focusField = null;
                var i = 0;
                var fields = new Array();
                oMaxLength = new maxlength();
                for (x in oMaxLength) {
                    if (form[oMaxLength[x][0]].type == 'text' ||
                        form[oMaxLength[x][0]].type == 'textarea') {
                        var iMax = parseInt(oMaxLength[x][2]("maxlength"));
                        if (!(form[oMaxLength[x][0]].value.length <= iMax)) {
                            if (i == 0) {
                                focusField = form[oMaxLength[x][0]];
                            }
                            fields[i++] = oMaxLength[x][1];
                            bValid = false;
                        }
                    }
                }
                if (fields.length > 0) {
                   focusField.focus();
                   reportErrors(fields);
                   //alert(fields.join('\n'));
                }
                return bValid;
            }
function validateRequired(form) {
                var bValid = true;
                var focusField = null;
                var i = 0;
                var fields = new Array();
                oRequired = new required();
                for (x in oRequired) {
                    if ((form[oRequired[x][0]].type == 'text' ||
                         form[oRequired[x][0]].type == 'textarea' ||
                         form[oRequired[x][0]].type == 'select-one' ||
                         form[oRequired[x][0]].type == 'radio' ||
                         form[oRequired[x][0]].type == 'password') &&
                        (form[oRequired[x][0]].value == '')) {
                        if (i == 0) {
                            focusField = form[oRequired[x][0]];
                        }
                        fields[i++] = oRequired[x][1];
                        bValid = false;
                    }
                }
                if (fields.length > 0) {
                   focusField.focus();
                   reportErrors(fields);
                   //alert(fields.join('\n'));
                }
                return bValid;
            }
function validateInteger(form) {
                var bValid = true;
                var focusField = null;
                var i = 0;
                var fields = new Array();
                oInteger = new IntegerValidations();
                for (x in oInteger) {
                    if ((form[oInteger[x][0]].type == 'text' ||
                         form[oInteger[x][0]].type == 'textarea' ||
                         form[oInteger[x][0]].type == 'select-one' ||
                         form[oInteger[x][0]].type == 'radio') &&
                        (form[oInteger[x][0]].value.length > 0)) {
                        var iValue = parseInt(form[oInteger[x][0]].value);
                        if (isNaN(iValue) || !(iValue >= -2147483648 && iValue <= 2147483647)) {
                            if (i == 0) {
                                focusField = form[oInteger[x][0]];
                            }
                            fields[i++] = oInteger[x][1];
                            bValid = false;
                       }
                    }
                }
                if (fields.length > 0) {
                   focusField.focus();
                   reportErrors(fields);
                   //alert(fields.join('\n'));
                }
                return bValid;
            }
function validateDate(form) {
             var bValid = true;
             var focusField = null;
             var i = 0;
             var fields = new Array();
             oDate = new DateValidations();
             for (x in oDate) {
               var date = form[oDate[x][0]].value;
               if (date.length != 0){
                 var d1 = date.indexOf("/");
                 var temp = "";
                 if (d1 == 4)
                    temp = date.substring(0, 4);
                 if (d1 == 2)
                    temp = "13" + date.substring(0, 2);
                 date =  temp + "*" + date.substring(d1+1, date.length);
                 var value = temp + "/";
                 var d2 = date.indexOf("/");
                 if (d2 == 6){
                     temp = temp + "0" + date.substring(5, 6);
                     value = value + "0" + date.substring(5, 6) + "/";
                 }
                 if (d2 == 7){
                    temp = temp + date.substring(5, 7);
                    value = value + date.substring(5, 7) + "/";
                 }
                 date =  temp + "*" + date.substring(d2 + 1, date.length);
                 var d3 = date.length
                 if (d3 == 8)
                    value = value + "0" + date.substring(7, 8);
                 if (d3 == 9)
                    value = value + date.substring(7, 9);
                 if (value.length == 10)
                    form[oDate[x][0]].value = value;

                 var datePattern = oDate[x][2]("datePatternStrict");
                  if ((form[oDate[x][0]].type == 'text' ||
                      form[oDate[x][0]].type == 'textarea')){
                   var MONTH = "MM";
                   var DAY = "dd";
                   var YEAR = "yyyy";
                   var orderMonth = datePattern.indexOf(MONTH);
                   var orderDay = datePattern.indexOf(DAY);
                   var orderYear = datePattern.indexOf(YEAR);


                   if ((orderDay < orderYear && orderDay > orderMonth)) {
                       var iDelim1 = orderMonth + MONTH.length;
                       var iDelim2 = orderDay + DAY.length;
                       var delim1 = datePattern.substring(iDelim1, iDelim1 + 1);
                       var delim2 = datePattern.substring(iDelim2, iDelim2 + 1);
                       if (iDelim1 == orderDay && iDelim2 == orderYear) {
                          dateRegexp = new RegExp("^(\\d{2})(\\d{2})(\\d{4})$");
                       } else if (iDelim1 == orderDay) {
                          dateRegexp = new RegExp("^(\\d{2})(\\d{2})[" + delim2 + "](\\d{4})$");
                       } else if (iDelim2 == orderYear) {
                          dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})(\\d{4})$");
                       } else {
                          dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})[" + delim2 + "](\\d{4})$");
                       }
                       var matched = dateRegexp.exec(value);
                       if(matched != null) {
                          if (!isValidDate(matched[2], matched[1], matched[3])) {
                             if (i == 0) {
                                 focusField = form[oDate[x][0]];
                             }
                             fields[i++] = oDate[x][1];
                             bValid =  false;
                          }
                       } else {
                          if (i == 0) {
                              focusField = form[oDate[x][0]];
                          }
                          fields[i++] = oDate[x][1];
                          bValid =  false;
                       }
                   } else if ((orderMonth < orderYear && orderMonth > orderDay)) {
                       var iDelim1 = orderDay + DAY.length;
                       var iDelim2 = orderMonth + MONTH.length;
                       var delim1 = datePattern.substring(iDelim1, iDelim1 + 1);
                       var delim2 = datePattern.substring(iDelim2, iDelim2 + 1);
                       if (iDelim1 == orderMonth && iDelim2 == orderYear) {
                           dateRegexp = new RegExp("^(\\d{2})(\\d{2})(\\d{4})$");
                       } else if (iDelim1 == orderMonth) {
                           dateRegexp = new RegExp("^(\\d{2})(\\d{2})[" + delim2 + "](\\d{4})$");
                       } else if (iDelim2 == orderYear) {
                           dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})(\\d{4})$");
                       } else {
                           dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})[" + delim2 + "](\\d{4})$");
                       }
                       var matched = dateRegexp.exec(value);
                       if(matched != null) {
                           if (!isValidDate(matched[1], matched[2], matched[3])) {
                               if (i == 0) {
                                   focusField = form[oDate[x][0]];
                               }
                               fields[i++] = oDate[x][1];
                               bValid =  false;
                            }
                       } else {
                           if (i == 0) {
                               focusField = form[oDate[x][0]];
                           }
                           fields[i++] = oDate[x][1];
                           bValid =  false;
                       }
                   } else if ((orderMonth > orderYear && orderMonth < orderDay)) {
                       var iDelim1 = orderYear + YEAR.length;
                       var iDelim2 = orderMonth + MONTH.length;
                       var delim1 = datePattern.substring(iDelim1, iDelim1 + 1);
                       var delim2 = datePattern.substring(iDelim2, iDelim2 + 1);
                       if (iDelim1 == orderMonth && iDelim2 == orderDay) {
                           dateRegexp = new RegExp("^(\\d{4})(\\d{2})(\\d{2})$");
                       } else if (iDelim1 == orderMonth) {
                           dateRegexp = new RegExp("^(\\d{4})(\\d{2})[" + delim2 + "](\\d{2})$");
                       } else if (iDelim2 == orderDay) {
                           dateRegexp = new RegExp("^(\\d{4})[" + delim1 + "](\\d{2})(\\d{2})$");
                       } else {
                           dateRegexp = new RegExp("^(\\d{4})[" + delim1 + "](\\d{2})[" + delim2 + "](\\d{2})$");
                       }
                       var matched = dateRegexp.exec(value);
                       if(matched != null) {
                           if (!isValidDate(matched[3], matched[2], matched[1])) {
                               if (i == 0) {
                                   focusField = form[oDate[x][0]];
                                }
                                fields[i++] = oDate[x][1];
                                bValid =  false;
                            }
                        } else {
                            if (i == 0) {
                                focusField = form[oDate[x][0]];
                            }
                            fields[i++] = oDate[x][1];
                            bValid =  false;
                        }
                   } else {
                       if (i == 0) {
                           focusField = form[oDate[x][0]];
                       }
                       fields[i++] = oDate[x][1];
                       bValid =  false;
                   }
                }
               }
             }
             if (fields.length > 0) {
                focusField.focus();
                reportErrors(fields);
                //alert(fields.join('\n'));
             }
             return bValid;
             }

         function isValidDate(day, month, year) {
             if (month < 1 || month > 12) {
                 return false;
             }
             if (day < 1 || day > 31) {
                 return false;
             }
             if ((month > 6) && (day > 30)) {
                 return false;
             }
             if (month == 12) {
                 var leap = (((year - ( year + 45) / 33) % 4) == 0);
                 if (day>30 || (day == 30 && !leap)) {
                     return false;
                 }
             }
                 return true;
             }
function validateCreditCard(form) {
                var bValid = true;
                var focusField = null;
                var i = 0;
                var fields = new Array();
                oCreditCard = new creditCard();
                for (x in oCreditCard) {
                    if ((form[oCreditCard[x][0]].type == 'text' ||
                         form[oCreditCard[x][0]].type == 'textarea') &&
                        (form[oCreditCard[x][0]].value.length > 0)) {
                        if (!luhnCheck(form[oCreditCard[x][0]].value)) {
                            if (i == 0) {
                                focusField = form[oCreditCard[x][0]];
                            }
                            fields[i++] = oCreditCard[x][1];
                            bValid = false;
                        }
                    }
                }
                if (fields.length > 0) {
                    focusField.focus();
                    reportErrors(fields);
                    //alert(fields.join('\n'));
                }
                return bValid;
            }

            /**
             * Reference: http://www.ling.nwu.edu/~sburke/pub/luhn_lib.pl
             */
            function luhnCheck(cardNumber) {
                if (isLuhnNum(cardNumber)) {
                    var no_digit = cardNumber.length;
                    var oddoeven = no_digit & 1;
                    var sum = 0;
                    for (var count = 0; count < no_digit; count++) {
                        var digit = parseInt(cardNumber.charAt(count));
                        if (!((count & 1) ^ oddoeven)) {
                            digit *= 2;
                            if (digit > 9) digit -= 9;
                        };
                        sum += digit;
                    };
                    if (sum == 0) return false;
                    if (sum % 10 == 0) return true;
                };
                return false;
            }

            function isLuhnNum(argvalue) {
                argvalue = argvalue.toString();
                if (argvalue.length == 0) {
                    return false;
                }
                for (var n = 0; n < argvalue.length; n++) {
                    if ((argvalue.substring(n, n+1) < "0") ||
                        (argvalue.substring(n,n+1) > "9")) {
                        return false;
                    }
                }
                return true;
            }
function reportErrors(errors) {
            	if(document.all.errors != null) {
            		var errorStr = "";
            		errorStr += "<table><tr><td>&nbsp;</td><td class='errorMessage'>";
            		for(i=0;i<errors.length;i++) {
            			//errorStr += ""
            			errorStr += errors[i];
            			errorStr += "<br>";
            		}
            		errorStr += "</td></tr></table>";
            		document.all.errors.innerHTML = errorStr;
            	} else {
               		alert(errors.join('\n'));
               	}
                return true;
            }
function validateIntRange(form) {
                var bValid = true;
                var focusField = null;
                var i = 0;
                var fields = new Array();
                oRange = new intrange();
                for (x in oRange) {
                    if ((form[oRange[x][0]].type == 'text' ||
                         form[oRange[x][0]].type == 'textarea') &&
                        (form[oRange[x][0]].value.length > 0)) {
                        var iMin = parseInt(oRange[x][2]("min"));
                        var iMax = parseInt(oRange[x][2]("max"));
                        var iValue = parseInt(form[oRange[x][0]].value);
                        if (!(iValue >= iMin && iValue <= iMax)) {
                            if (i == 0) {
                                focusField = form[oRange[x][0]];
                            }
                            fields[i++] = oRange[x][1];
                            bValid = false;
                        }
                    }
                }
                if (fields.length > 0) {
                    focusField.focus();
                    reportErrors(fields);
                    //alert(fields.join('\n'));
                }
                return bValid;
            }
function validateShort(form) {
                var bValid = true;
                var focusField = null;
                var i = 0;
                var fields = new Array();
                oShort = new ShortValidations();
                for (x in oShort) {
                    if ((form[oShort[x][0]].type == 'text' ||
                         form[oShort[x][0]].type == 'textarea' ||
                         form[oShort[x][0]].type == 'select-one' ||
                         form[oShort[x][0]].type == 'radio') &&
                        (form[oShort[x][0]].value.length > 0)) {
                        var iValue = parseInt(form[oShort[x][0]].value);
                        if (isNaN(iValue) || !(iValue >= -32768 && iValue <= 32767)) {
                            if (i == 0) {
                                focusField = form[oShort[x][0]];
                            }
                            fields[i++] = oShort[x][1];
                            bValid = false;
                       }
                    }
                }
                if (fields.length > 0) {
                   focusField.focus();
                   reportErrors(fields);
                   //alert(fields.join('\n'));
                }
                return bValid;
            }
function validateFloat(form) {
                var bValid = true;
                var focusField = null;
                var i = 0;
                var fields = new Array();
                oFloat = new FloatValidations();
                for (x in oFloat) {
                    if ((form[oFloat[x][0]].type == 'text' ||
                         form[oFloat[x][0]].type == 'textarea' ||
                         form[oFloat[x][0]].type == 'select-one' ||
                         form[oFloat[x][0]].type == 'radio') &&
                        (form[oFloat[x][0]].value.length > 0)) {
                        var iValue = parseFloat(form[oFloat[x][0]].value);
                        if (isNaN(iValue)) {
                            if (i == 0) {
                                focusField = form[oFloat[x][0]];
                            }
                            fields[i++] = oFloat[x][1];
                            bValid = false;
                        }
                    }
                }
                if (fields.length > 0) {
                   focusField.focus();
				   reportErrors(fields);
                   //alert(fields.join('\n'));
                }
                return bValid;
            }
function validateEmail(form) {
                var bValid = true;
                var focusField = null;
                var i = 0;
                var fields = new Array();
                oEmail = new email();
                for (x in oEmail) {
                    if ((form[oEmail[x][0]].type == 'text' ||
                         form[oEmail[x][0]].type == 'textarea') &&
                        (form[oEmail[x][0]].value.length > 0)) {

                        var retValue = form[oEmail[x][0]].value;
                        var ch = retValue.substring(0, 1);
                        while (ch == " ") { // Check for spaces at the beginning of the string
                           retValue = retValue.substring(1, retValue.length);
                           ch = retValue.substring(0, 1);
                        }
                        ch = retValue.substring(retValue.length-1, retValue.length);
                        while (ch == " ") { // Check for spaces at the end of the string
                           retValue = retValue.substring(0, retValue.length-1);
                           ch = retValue.substring(retValue.length-1, retValue.length);
                        }
                        while (retValue.indexOf("  ") != -1) { // Note that there are two spaces in the string - look for multiple spaces within the string
                           retValue = retValue.substring(0, retValue.indexOf("  ")) + retValue.substring(retValue.indexOf("  ")+1, retValue.length); // Again, there are two spaces in each of the strings
                        }
                        form[oEmail[x][0]].value = retValue;
                        if (!checkEmail(form[oEmail[x][0]].value)) {
                            if (i == 0) {
                                focusField = form[oEmail[x][0]];
                            }
                            fields[i++] = oEmail[x][1];
                            bValid = false;
                        }
                    }
                }
                if (fields.length > 0) {
                    focusField.focus();
                    reportErrors(fields);
                    //alert(fields.join('\n'));
                }
                return bValid;
            }

            /**
             * Reference: Sandeep V. Tamhankar (stamhankar@hotmail.com),
             * http://javascript.internet.com
             */
            function checkEmail(emailStr) {
               if (emailStr.length == 0) {
                   return true;
               }
               var emailPat=/^(.+)@(.+)$/;
               var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]";
               var validChars="\[^\\s" + specialChars + "\]";
               var quotedUser="(\"[^\"]*\")";
               var ipDomainPat=/^(\d{1,3})[.](\d{1,3})[.](\d{1,3})[.](\d{1,3})$/;
               var atom=validChars + '+';
               var word="(" + atom + "|" + quotedUser + ")";
               var userPat=new RegExp("^" + word + "(\\." + word + ")*$");
               var domainPat=new RegExp("^" + atom + "(\\." + atom + ")*$");
               var matchArray=emailStr.match(emailPat);
               if (matchArray == null) {
                   return false;
               }
               var user=matchArray[1];
               var domain=matchArray[2];
               if (user.match(userPat) == null) {
                   return false;
               }
               var IPArray = domain.match(ipDomainPat);
               if (IPArray != null) {
                   for (var i = 1; i <= 4; i++) {
                      if (IPArray[i] > 255) {
                         return false;
                      }
                   }
                   return true;
               }
               var domainArray=domain.match(domainPat);
               if (domainArray == null) {
                   return false;
               }
               var atomPat=new RegExp(atom,"g");
               var domArr=domain.match(atomPat);
               var len=domArr.length;
               if ((domArr[domArr.length-1].length < 2) ||
                   (domArr[domArr.length-1].length > 3)) {
                   return false;
               }
               if (len < 2) {
                   return false;
               }
               return true;
            }
function validateMask(form) {
                var bValid = true;
                var focusField = null;
                var i = 0;
                var fields = new Array();
                oMasked = new mask();
                for (x in oMasked) {
                    if ((form[oMasked[x][0]].type == 'text' ||
                         form[oMasked[x][0]].type == 'textarea' ||
                         form[oMasked[x][0]].type == 'password') &&
                        (form[oMasked[x][0]].value.length > 0)) {
                        if (!matchPattern(form[oMasked[x][0]].value, oMasked[x][2]("mask"))) {
                            if (i == 0) {
                                focusField = form[oMasked[x][0]];
                            }
                            fields[i++] = oMasked[x][1];
                            bValid = false;
                        }
                    }
                }
                if (fields.length > 0) {
                   focusField.focus();
                   reportErrors(fields);
                   //alert(fields.join('\n'));
                }
                return bValid;
            }

            function matchPattern(value, mask) {
               var bMatched = mask.exec(value);
               if (!bMatched) {
                   return false;
               }
               return true;
            }
function validateMinLength(form) {
                var bValid = true;
                var focusField = null;
                var i = 0;
                var fields = new Array();
                oMinLength = new minlength();
                for (x in oMinLength) {
                    if (form[oMinLength[x][0]].type == 'text' ||
                        form[oMinLength[x][0]].type == 'textarea') {
                        var iMin = parseInt(oMinLength[x][2]("minlength"));
                        if (!(form[oMinLength[x][0]].value.length >= iMin)) {
                            if (i == 0) {
                                focusField = form[oMinLength[x][0]];
                            }
                            fields[i++] = oMinLength[x][1];
                            bValid = false;
                        }
                    }
                }
                if (fields.length > 0) {
                   focusField.focus();
                   reportErrors(fields);
                   //alert(fields.join('\n'));
                }
                return bValid;
            }

//End --> 
</script>


























