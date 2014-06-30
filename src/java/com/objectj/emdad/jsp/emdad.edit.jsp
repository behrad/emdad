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

<%@ page import ="java.lang.*,com.objectj.emdad.ejb.util.EntityList,com.objectj.emdad.ejb.EntityAccess,org.apache.log4j.Logger" %>

<html:base/>


<script>
    function checkSabt(elem) {
        elem.disabled = true;
     //   if (document.emdadForm.action_type.value=="update") {
			//top.creator.execScript("myRefresh()");
	//	}
//		top.close();
        theForm.submit();
    }

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
		showDetailInNew(document.emdadForm.moshtarakId,
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
		src = document.getElementById( valuee );
		dst = document.getElementById( "emdadgarId" );
		if ( src!= null )  {
			len = src.length;
			dst.length=len;
			for (var i=0;i<len;i++){
				dst[i]=new Option(src[i].text); // need all new options for copy
				dst[i].value=src[i].value;
			}
		} else {
			dst.length=0;
		}
	}

	/*function selectEmdadgar( valuee ) {
		len = document.emdadForm.noeEmdadgarId.options.length;
		sel = document.all.emdadForm.noeEmdadgarId;
		for(i=0; i<len;i++ ){
			emdadgar = document.getElementById( sel.options[i].value );
			if ( emdadgar != null )
				emdadgar.style.display = "none";
		}
		if ( document.getElementById( valuee ) != null )
			document.getElementById( valuee ).style.display = "inline";
	}*/

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
    function emptyNamayandegiCombo(){
   // alert("emtying");
        e = document.getElementById("namayandegiCombo");
        for(var i=1;i<e.options.length;i++){
  //      alert(i);
            e.remove(i);
            i--;
             }
    }

    function selectNamayandegiBaZarfiat(noeEmdad){
//        alert("toosham");
var namayandegiIdGhabli = "<bean:write name="emdadForm" property="namayandegiId"/>";
        e = document.getElementById("namayandegiCombo");
        t = document.getElementById("namayandegiIdHdn");
    //    alert(t.options[1].value);
//       alert(e.options.length);
       // alert(noeEmdad);
        switch(noeEmdad){
            case '1':{
                g = document.getElementById("onlyTamir");
                g.style.visibility = "hidden";
                document.emdadForm.noeKhedmateVije.value="0";
                document.emdadForm.faseleAzNamayandegi.value="0";
                //alert('1');
                emptyNamayandegiCombo();
               // alert(t.options.length);
               var j=1;
                for(var i=1;i<t.options.length;i++){
                    o = t.options[i];
                    s = o.value;
                 //   alert(s.substring(s.indexOf(",")+1,s.lastIndexOf(",")));
                   // alert(String.valueOf(s.substring(s.indexOf(","),s.lastIndexOf(",")))!=0);
                    if(parseInt((s.substring(s.indexOf(",")+1,s.lastIndexOf(","))).charAt(0))>0||s.substring(0,s.indexOf(","))==namayandegiIdGhabli){
                       // o.value=s.substring(0,s.indexOf(","));
                     //   alert(o.value);
                       // alert(e.length);
				e[j]=new Option(t[i].text); // need all new options for copy
                e[j].value=s.substring(0,s.indexOf(","));
                j++;
                    }

                }
                break;
            }
            case '2':{
                g = document.getElementById("onlyTamir");
                g.style.visibility = "visible";
                document.emdadForm.noeKhedmateVije.value="0";
                document.emdadForm.faseleAzNamayandegi.value="0";

                //alert('1');
                emptyNamayandegiCombo();
               // alert(t.options.length);
               var j=1;
                for(var i=1;i<t.options.length;i++){
                    o = t.options[i];
                    s = o.value;
                  //  alert(s.substring(s.lastIndexOf(",")+1,s.length));
                  //  alert((s.substring(s.lastIndexOf(",")+1,s.length)).charAt(0)!='0');
                    if(parseInt((s.substring(s.lastIndexOf(",")+1,s.length)).charAt(0))>0||s.substring(0,s.indexOf(","))==namayandegiIdGhabli){
                       // o.value=s.substring(0,s.indexOf(","));
                       // alert(o.value);
                       // alert(e.length);
				e[j]=new Option(t[i].text); // need all new options for copy
                e[j].value=s.substring(0,s.indexOf(","));
                j++;
                    }

                }
                break;
            }

        }
            //alert("before if")
            if(namayandegiIdGhabli!=null && namayandegiIdGhabli.length!=0){
                e.value = namayandegiIdGhabli;
              //  alert(namayandegiIdGhabli);
                }
    }

	var lastCreator;
top.window.moveTo(0,0);
top.window.resizeTo(screen.width*0.7, screen.height * 0.9);
</script>
<body onkeydown="Sabt()">

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/validate.jsp" flush="true" />

<%
Logger log = Logger.getLogger("com.objectj.emdad");
log.info("emdad.edit.start");
%>
<html:form method="post" action="/c/validateemdad" onsubmit="return validateEmdadForm(this)">
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/moshtarak.info.jsp" flush="true" />

	<table width="100%" dir=rtl class="generalText">
		<tr>
			<td align="center">
				<table border="0" cellpadding="6" cellspacing="0" class="editTable">

					<!----------------------------------------->
                    <input type="hidden" name="khvz" value="0"/>
			<html:hidden property="taeedCreate" />
			
			<html:hidden property="guarantee" />

                    <logic:equal name="emdadForm" property="vazeatKonuni" value="0" >
                        <html:hidden property="zamanShoro" value="1399/1/1"/>
                        <html:hidden property="zamanShoro2" value="12:00"/>
                        <html:hidden property="zamanPayan" value="1399/1/1" />
                        <html:hidden property="zamanPayan2" value = "12:30"/>
                    </logic:equal>

                    <logic:equal name="emdadForm" property="vazeatKonuni" value="1" >
                        <html:hidden property="zamanShoro" />
                        <html:hidden property="zamanShoro2" />
                        <html:hidden property="zamanPayan" value="1399/1/1" />
                        <html:hidden property="zamanPayan2" value = "12:30"/>
                    </logic:equal>

                    <logic:equal name="emdadForm" property="vazeatKonuni" value="2" >
						<html:hidden property="zamanShoro"/>
						<html:hidden property="zamanShoro2"/>
						<html:hidden property="zamanPayan"/>
						<html:hidden property="zamanPayan2"/>
                    </logic:equal>

					<html:hidden property="zamanVagheiEzam"/>
					<html:hidden property="zamanVagheiShoro"/>
					<html:hidden property="zamanVagheiPayan"/>

					<html:hidden property="zamanVagheiEzam2"/>
					<html:hidden property="zamanVagheiShoro2"/>
					<html:hidden property="zamanVagheiPayan2"/>

					<html:hidden property="rokhdadId" />
					<html:hidden property="maliDone" />

					<html:hidden property="emdadgarIdGhabli" />
					<!--bean : write property="emdadgarIdGhabli" name="emdadForm"/-->
					<html:hidden property="namayandegiIdGhabli" />
					<!-- bean : write property="namayandegiIdGhabli" name="emdadForm"/-->

					<html:hidden property="vazeatKonuni" />
					<html:hidden property="hazinehAyyabZahab" />
					<html:hidden property="hazinehJarsaghil" value="0"/>
					<html:hidden property="hazinehBoxel" value="0"/>
					<html:hidden property="noeService"/>
					<html:hidden property="kilometerKarkard" />
					<html:hidden property="dastoorKarGhabli" />
					<html:hidden property="vazeatDakheli" />
					<html:hidden property="emdadId" />
					<html:hidden property="rahAndazi" value="du"/>
					<html:hidden property="elateService" value=""/>

					<%
						boolean disable = true;
						boolean lock = false;
					%>

					<logic:equal name="emdadForm" property="action_type" value="create">
						<% disable=false; %>
					</logic:equal>

					<logic:equal name="emdadForm" property="vazeatDakheli" value="1">
						<% lock = true; %>
						<html:hidden property="zamanEzam" />
						<html:hidden property="noeEmdad" />
						<html:hidden property="modatTamir" />
						<html:hidden property="namayandegiId" />
						<html:hidden property="ameliyatMojaz" />
						<html:hidden property="zamanEzam2" />
						<html:hidden property="emdadgarId" />
					</logic:equal>


					<!----------------------------------------->

                    <logic:equal name="emdadForm" property="action_type" value="create" >
                        <html:hidden property="ezamgarId" value="1"/>
                    </logic:equal>

                    <logic:notEqual name="emdadForm" property="action_type" value="create" >
                        <html:hidden property="ezamgarId"/>
                    </logic:notEqual>

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
							<input type="hidden" name="moshtarakId" value="<bean:write name="moshtarakId"/>"/>
							<a href="javascript:moshtarakDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg2"></a>&nbsp;&nbsp;&nbsp;
							<a href="javascript:showSavabeghMoshtari()" >سوابق</a>
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
						<td colspan="3">
							<div style="display:none;height:100px;" id="savabeghMoshtariFrame">
								<iframe width="100%" height="100%" src="" frameborder="1" name="savabegh" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

					<logic:equal name="emdadForm" property="action_type" value="update" >
						<tr class="editRow1">
							<td class="editLabel">دستور کار فعلي:</td>
							<td class="editStar"> </td>
							<td class="readData">
								<input type="hidden" name="emdadId1" value='<bean:write property="emdadId" name="emdadForm"/>'/>
								<bean:write property="emdadId"  name="emdadForm" />
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
					</logic:equal>

					<!----------------------------------------->

					<tr height="3" bgcolor="#336699"><td colspan="3"></td></tr>

					<!----------------------------------------->
				<logic:equal name="emdadForm" property="action_type" value="create">

                    <tr class="editRow1">
                        <td class="editLabel">نوع امداد:</td>
                        <td class="editStar">*</td>
						<% if (lock || disable ) {%>
							<td class="readData"> <%= request.getAttribute("noeEmdadName") %></td>
							<% if (disable && !lock) { %>
								<html:hidden property="noeEmdad" />
                                <script>
	                                function isBalini(){
    	                            //alert("toosham");
					                var gg = document.getElementById("onlyTamir");
					                gg.style.visibility = "hidden";
					                selectNamayandegiBaZarfiat('1');
                                      }
                                </script>

							<%}%>
						<% }else{ %>
						<td class="readData">
							<logic:equal property="noeService" name="emdadForm" value="vijeh" >
								<html:select property="noeEmdad" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()" onchange='javascript:selectNamayandegiBaZarfiat(this.value);selectField();'>
									<html:options collection="noeEmdadList" property="id" labelProperty="name" />
								</html:select>
							</logic:equal>
							<logic:equal property="noeService" name="emdadForm" value="adi" >
								&nbsp;&nbsp; باليني
								<html:hidden property="noeEmdad" value="1"/>
                                <script>
	                                function isBalini(){
    	                            //alert("toosham");
					                var gg = document.getElementById("onlyTamir");
					                gg.style.visibility = "hidden";
					                selectNamayandegiBaZarfiat('1');
                                      }
                                </script>
							</logic:equal>
                        </td>
						<%}%>
                    </tr>
         </logic:equal>
<tr class="editRow1">
					<logic:notEqual name="emdadForm" property="action_type" value="create">
                        <td class="editLabel">نوع امداد:</td>
                        <td class="editStar">*</td>
                        <td class="readData">
							<logic:equal property="noeService" name="emdadForm" value="adi" >
								&nbsp;&nbsp; باليني
								<html:hidden property="noeEmdad" value="1"/>
                                <script>
	                                function isBalini(){
    	                            //alert("toosham");
					                var gg = document.getElementById("onlyTamir");
					                gg.style.visibility = "hidden";
					                selectNamayandegiBaZarfiat('1');
                                      }
                                </script>
							</logic:equal>
							<logic:equal property="noeService" name="emdadForm" value="vijeh" >
								<html:hidden property="noeEmdad" />
							<logic:equal property="noeEmdad" name="emdadForm" value="1" >
								&nbsp;&nbsp; باليني
							</logic:equal>
							<logic:notEqual property="noeEmdad" name="emdadForm" value="1" >
								&nbsp;&nbsp; تعميري
							</logic:notEqual>
                                <script>
	                                function isBalini(){
    	                            //alert("toosham");
					                var gg = document.getElementById("onlyTamir");
					                gg.style.visibility = "visible";
					                selectNamayandegiBaZarfiat('<bean:write property="noeEmdad" name="emdadForm" />');
                                      }
                                </script>
							</logic:equal>
                              </td>

                    </logic:notEqual>
 </tr>
					<!----------------------------------------->
						<tr class="editRow0" style="display:inline" id="balini"><td colspan="6">
						<table cellpadding="0" cellspacing="0" width="100%" dir="rtl"><tr>

                    <logic:equal name="emdadForm" property="vazeatKonuni" value="0" >
					<td style="font-size:25px;">&nbsp;</td>
							<td class="editLabel">تاريخ اعزام:</td>
							<td style="font-size:25px;">&nbsp;</td>
							<td class="editStar">*</td>
							<% if (lock) {%>
								<td class="readData"> <bean:write name="emdadForm" property="zamanEzam"/></td>
							<% }else{ %>
								<td style="font-size:20px;">&nbsp;&nbsp;</td>
								<td><html:text property="zamanEzam" size="10" maxlength="10" styleClass="field"/> </td>
							<%}%>
					</logic:equal>
		            <logic:equal name="emdadForm" property="vazeatKonuni" value="0" >

							<td class="editLabel">زمان اعزام:</td>
							<td class="editStar">*</td>
							<% if (lock) { %>
								<td class="fieldDescription"> <bean:write name="emdadForm" property="zamanEzam2"/></td>
							<% }else{ %>
								<td><html:text property="zamanEzam2" size="10" maxlength="10" styleClass="field"/> </td>
							<%}%>

					</logic:equal>
					</tr></table></td>
                   </tr>

<tr class="editRow0" style="display:inline" id="balini"><td colspan="6">
						<table cellpadding="0" cellspacing="0" width="100%" dir="rtl"><tr>
                              <logic:notEqual name="emdadForm" property="vazeatKonuni" value="0" >
							<td class="editLabel">زمان اعزام:</td>
							<td class="editStar"></td>
							<td class="readData">
								 <html:hidden property="zamanEzam"/>
								<bean:write name="emdadForm" property="zamanEzam"/>
								-
								<html:hidden property="zamanEzam2"/>
								<bean:write name="emdadForm" property="zamanEzam2"/>
							</td>
					</logic:notEqual>

					<logic:notEqual name="emdadForm" property="vazeatKonuni" value="0" >
							<td class="editLabel">زمان شروع:</td>
							<td class="editStar"></td>
							<td class="readData">
								 <html:hidden property="zamanShoro"/>
								<bean:write name="emdadForm" property="zamanShoro"/>
								-
								<html:hidden property="zamanShoro2"/>
								<bean:write name="emdadForm" property="zamanShoro2"/>
							</td>
					</logic:notEqual>


</tr></table></td>
                   </tr>

                    <logic:equal name="emdadForm" property="vazeatKonuni" value="0" >
						<!-- EMDADGAR COMBOs -->
						<tr class="editRow1" style="display:inline" id="baliniNoe">
							<td class="editLabel">نوع امدادگر:</td>
							<td class="editStar">*</td>
							<td>
								<html:select property="noeEmdadgarId" onchange="selectEmdadgar(this.value);" onkeypress="fastCombo(this);selectEmdadgar(this.value);" onfocus="emptyFastCombo()">
									<html:options collection="noeEmdadgarList" property="eid" labelProperty="name" />
								</html:select>
							</td>
						</tr>
						<tr class="editRow0" style="display:inline" id="balini">
							<td class="editLabel">امدادگر مربوطه:</td>
							<td class="editStar">*</td>
							<td>
								<logic:iterate id="noeEmdadgarId" name="noeEmdadgarList">
									<select style="display:none;" name='<bean:write name="noeEmdadgarId" property="eid"/>' onkeypress="fastCombo(this);setEmdadgar(this);" onchange="setEmdadgar(this);" onfocus="emptyFastCombo()" <% if(lock) {%>disabled="true" <%}%> >
										<option value="">------</option>
										<% java.util.ArrayList list = (java.util.ArrayList)request.getAttribute( ((com.objectj.emdad.ejb.util.ComboObject)noeEmdadgarId).getEid() ); 
										if (list!=null) {
										   for ( int item = 0; item < list.size(); item++ ) { %>
											<option value='<%=((com.objectj.emdad.ejb.EmdadgarBean)list.get(item)).getId()%>'><%=((com.objectj.emdad.ejb.EmdadgarBean)list.get(item)).getName()%></option>
										<% }} %>
									</select>
								</logic:iterate>
								<html:select property="emdadgarId" onkeypress="fastCombo(this);" onfocus="emptyFastCombo()">
									<!--html : options collection="emdadgarList" property="eid" labelProperty="name" / -->
								</html:select>
								<input type="hidden" name="tmpEmdadgarId" value="<bean:write name="emdadForm" property="emdadgarId" />" />
							</td>
						</tr>
					</logic:equal>

                    <logic:notEqual name="emdadForm" property="vazeatKonuni" value="0" >
						<tr class="editRow0" style="display:inline" id="balini">
							<td class="editLabel">امدادگر مربوطه:</td>
							<td class="editStar"></td>
							<td class="readData">
								<html:hidden property="emdadgarId"/>
								<bean:write name="emdadgarName"/>
							</td>
						</tr>
					</logic:notEqual>

					<!----------------------------------------->
                    <tr style="display:none;">
                    <td colspan=4>

                                <select  id="namayandegiIdHdn" >
								<logic:iterate id="noeNamayandegiHdn" name="namayandegiOrAmelyatListHdn">
									<option value='<bean:write name="noeNamayandegiHdn" property="eid"/>'> <bean:write name="noeNamayandegiHdn" property="name"/> </option>
								</logic:iterate>
                                </select>
                    </td>
                    </tr>

                    <logic:equal name="emdadForm" property="vazeatKonuni" value="0" >
						<tr class="editRow1">
							<td class="editLabel">نمايندگي يا عامليت مجاز:</td>
							<td class="editStar">*</td>
							<td>
                                <select name="namayandegiId" id="namayandegiCombo" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
                                <option value="" selected="selected">------</option>
                                </select>
							</td>
						</tr>
					</logic:equal>

                    <logic:notEqual name="emdadForm" property="vazeatKonuni" value="0" >
						<tr class="editRow1">
							<td class="editLabel">نمايندگي يا عامليت مجاز:</td>
							<td class="editStar"></td>
							<td class="readData">
								<html:hidden property="namayandegiId"/>
								<bean:write name="namayandegiName"/>
							</td>
						</tr>
					</logic:notEqual>

					<!----------------------------------------->

					<tr class="editRow1" style="display:inline" id="gheireBalini"><td colspan="6">
						<table cellpadding="0" cellspacing="0" width="100%" dir="rtl"><tr>
						<td class="editLabel">پيش بيني مدت زمان تعمير:</td>
						<td class="editStar"></td>
						<% if (lock) {%>
							<td class="fieldDescription"> <bean:write name="emdadForm" property="modatTamir"/> روز</td>
						<% }else{ %>
							<td span class="fieldDescription"><html:text property="modatTamir" size="10" maxlength="10" styleClass="field" onchange='showJagozin0();'/> روز</td>
						<%}%>
	                    <td class="editLabel">وضعيت خدمت:</td>
                        <td class="editStar">*</td>
                        <td>
                            <html:select property="vazeatKhedmatId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()" >
                                <html:options collection="vazeatKhedmatList" property="eid" labelProperty="name" />
                            </html:select>
                        </td>
</tr></table></td>
					</tr>

					<!----------------------------------------->


					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">توضيحات:</td>
						<td class="editStar"></td>
						<td> <html:textarea property="tozihat" styleClass="field" rows="3" cols="50" onkeypress="return submitenter2(this,event) && checkLength(256)"/></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0" id="onlyTamir"><td colspan="6">
						<table cellpadding="0" cellspacing="0" width="100%" dir="rtl"><tr>
						<td class="editLabel">نوع خدمت ويزه:</td>
						<td class="editStar">*</td>
						<td style="font-size:50px;">&nbsp;&nbsp;&nbsp;</td>
						<td>
							<html:select property="noeKhedmateVije" size="1">
								<html:options collection="noeKhedmateVijeList" property="id" labelProperty="name" />
							</html:select>
						</td>
						<td class="editLabel">فاصله از نمايندگي:</td>
						<td class="editStar">*</td>
						<td><html:text property="faseleAzNamayandegi"  size="5" maxlength="4" styleClass="field" />
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
							<input type="hidden" name="moshtarakId2" value="<bean:write name="moshtarakId"/>"/>
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
		<html:hidden property="action_type" />
		<html:hidden property="id" />
		<html:hidden property="curpage" />
		<html:hidden property="order"/>
		<html:hidden property="sorttype" />
		<input type="button" value="ثبت" class="emdadButton" name="sabtBtn" onClick="javascript:checkSabt(this);" />&nbsp;&nbsp;
		<html:reset  value="حالت اول" styleClass="emdadButton" />&nbsp;&nbsp;
		<input type="button" value="انصراف" class="emdadButton" onclick="javascript:SureCancle2();">&nbsp;&nbsp;
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/help.jsp" flush="true">
   <jsp:param name="help_url" value="emdad.edit.help.html" />	
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
<%
log.info("emdad.edit.middle");
//System.out.println("edit.jsp ,"+((new java.util.Date()).getTime()-t1));
%>

<!----------------------------------------->

		<logic:equal name="editAction" value="true">
			<script language="JavaScript">
				//alert("000");
				selectEmdadgar("<bean:write name="emdadForm" property="noeEmdadgarId" />");
				//alert("111");
				//document.getElementById("<bean:write name="emdadForm" property="noeEmdadgarId" />").style.display = "inline";
				//setEmdadForEdit( <bean:write name="emdadForm" property="noeEmdadgarId" />, <bean:write name="emdadForm" property="emdadgarId" />);
				//alert( "222" );
			</script>
		</logic:equal>

<script type="text/javascript" language="Javascript1.1">
	setForm(document.emdadForm);
	setEntity("Emdad");
	document.emdadForm.rokhdadId.changed = true;
	document.emdadForm.moshtarakId.changed = true;
//	document.emdadForm.moshtarakId1.changed = true;
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
    selectEmdadgar(document.emdadForm.noeEmdadgarId.value);
    document.emdadForm.emdadgarId.value = document.emdadForm.tmpEmdadgarId.value;
	//rokhdadDetails();
	//moshtarakDetails();
	document.emdadForm.zamanEzam2.focus();
	parent.window.resizeTo(screen.width*0.7,screen.height*0.94);
<logic:equal name="emdadForm" property="action_type" value="create" >
<logic:equal property="noeService" name="emdadForm" value="adi" >
    isBalini();
</logic:equal>
</logic:equal>
<logic:notEqual name="emdadForm" property="action_type" value="create" >
    isBalini();
</logic:notEqual>
</script>
<%
log.info("emdad.edit.end");
%>
<html:javascript formName="emdadForm" />












