<%@ page contentType="text/html; charset=UTF-8" import="com.objectj.emdad.ejb.*, java.util.*" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>
<html>

<head>
<TITLE>ويرايش جزييات خدمات</TITLE>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">
<style type="text/css">
INPUT.field{
	"border: 2px thin solid #666699;
	background-color: #FFFFFF;
	font-family: Tahoma, Arial;
	font-size: 9pt;"
}
INPUT.field0{
	border: 0px none;
	background-color: #E9EBEB;
}
INPUT.field1{
	border: 0px none;
	background-color: #DADEDC;
}
LABEL {
	color: #FF0000;
}
</style>
<script language="JavaScript">
	function showDetailMe(vobj1,vobj2,imgid,divid,framename,url) {
		obj = document.getElementById(divid);
		img = document.getElementById(imgid);

		styl = obj.style;

		if (styl.display=="none") {
			vobj = vobj1;

			if (vobj1.value=="") {
				if ((vobj2==null ) || (vobj2.value=="")) {

					return;
				}
	
				vobj = vobj2;
			}
			document.frames[framename].location.href = url+"&id="+vobj.value;

			var df = document.frames[framename];
			document.lastCreator = obj;

			vobj.changed = false;

			img.src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-off.gif";
			styl.display = "inline";
		} else {
			hideDetail(imgid,divid);
		}
	}


	function moshtarakDetails() {
		showDetailMe(document.tasviehForm.moshtarakId,
			null,
			"dimg2",
			"showMoshtari",
			"mdtl",
			"/emdad/s/moshtarak.run?action_type=specific,moshtarakShow");
	}

	function showSavabeghMoshtari() {
		url = "/emdad/s/moshtarak.run?action_type=specific,savabegh";
		url = url + "&id=" + document.tasviehForm.moshtarakId.value;
		window.open( url, "savabeghMoshtari", "menubar=no,status=no,height=400,width=600,resizable" );
	}

	function emdadDetails() {
		showDetailMe(eval("document.tasviehForm.id"),
			null,
			"dimg1",
			"showEmdad",
			"edtl",
			"/emdad/s/emdad.run?action_type=specific,emdadShow") ;
	}

	function doSearch(divId, url, creator) {
		args = "width=700 , height=500 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "Search";
		obj = document.getElementById(divId);
		win1 = window.open(url , windowTitle, args);
		win1.creator=creator;
	}

	function doSearchAndHide (divId, url, creator, imgid) {
		hideDetail(imgid,divId);
		doSearch(divId, url, creator);
	}
	
	var qatewin = null;
	var ojratUrl = null;
	var ojratwin = null;
	var iradUrl = null;
	var iradwin = null;
	var cur_ojrat_filter ='0';
	var cur_irad_filter = '0';
	
	function qateSearch(openIt) {		
		url = "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/qate.run&action_type=specific,find&noeKhodroId=<bean:write name="noeKhodroId"/>";
		args = "width=700 , height=500 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "SearchQate";
		if ( qatewin == null || openIt || qatewin.closed ) 
			qatewin = window.open(url , windowTitle, args);
		qatewin.creator= this;
		qatewin.focus();
	}
	
	function ojratSearch( openIt ) {
		url = "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/l/ojrat.run&action_type=filter&ojratId=" + cur_ojrat_filter;;
		if ( ojratUrl == null )
			ojratUrl = "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/ojrat.run&action_type=specific,find&ojratId=" + cur_ojrat_filter;
		else
			ojratUrl = url;		
		args = "width=500 , height=500 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "SearchOjrat";
		if ( ojratwin == null || openIt || ojratwin.closed ) 
			ojratwin = window.open(ojratUrl , windowTitle, args);
		ojratwin.creator= this;
		ojratwin.focus();
	}
	
	function iradSearch( openIt ) {
		url = "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/l/irad.run&action_type=filter&iradId=" + cur_irad_filter;
		if ( iradUrl == null )
			iradUrl = "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/irad.run&action_type=specific,find&iradId=" + cur_ojrat_filter;
		else
			iradUrl = url;
		args = "width=500 , height=500 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "SearchIrad";
		if ( iradwin == null || openIt || iradwin.closed ) 
			iradwin = window.open(iradUrl , windowTitle, args);
		iradwin.creator= this;
		iradwin.focus();
	}
	
	function readCurIrad( name, index ) {
		openIt = true;
		document.all.cur_item.value = name;
		ojelem = document.getElementById( "ojratId" + index );
		newFilter = ojelem.value.substring( 0, 2 );
		if ( cur_irad_filter == newFilter )
			openIt = false;
		cur_irad_filter = newFilter;
		iradSearch( openIt );
		//blure( document.getElementById( name ), index );
	}
	
	function readCurOjrat( name, index ) {
		openIt = true;
		document.all.cur_item.value = name;
		irelem = document.getElementById( "iradId" + index );
		newFilter = irelem.value.substring( 0, 2 );
		if ( cur_ojrat_filter == newFilter )
			openIt = false;
		cur_ojrat_filter = newFilter;
		ojratSearch( openIt );
		//blure( document.getElementById( name ), index );
	}
	
	function readCurQate( name, index ) {
		document.all.cur_item.value = name;
		qateSearch( false );
		//blure( document.getElementById( name ), index );
		blure( document.getElementById( "tedadQate" + index ), index );
	}

	var cols = 7;
	var nottext = 2;
	var init = 11;
	
	function processKeyEvent( row, col ) {
		// Looking for search shortcut
		if( window.event.keyCode == 18 ) {
			// Alt
			switch ( col ) {
				case 1 : // Irad
					readCurIrad('iradId' + row, row );
					break;
				case 2 : // Ojrat
					readCurOjrat('ojratId' + row, row );
					break;
				case 3 : // Qate
					readCurQate('shomarehFanni' + row, row );
					break;
			}
			return;
		}
		// Grid handling Section
		kc = event.keyCode;
		var lcol = col;
		var lrow = row;
		cols = 7;
		nottext = 2;
		callUpdateGaranteeCols();		
		
		switch ( kc ){
		   case 38 :
			  if ( row != 0 ) 
			  	row--;
			  break;
		   case 40 :
		   	  if ( row != document.all.TBL.rows.length - 3  )
			  	row++;
			  break;
		   case 39 :
		   	  if ( window.document.forms[1].elements[ lrow * cols + lcol + init ].tag != 1 )
			  	break;
		   case 27 :
		   	  if ( col == 1 && row != 0 ) {
			    row--;
			    col = cols - nottext;
			  } else
			  	col--;
			  break;
		   case 37 :
		   case 13 :
			  if ( col == cols - nottext ) {
			  	if ( row == document.all.TBL.rows.length - 3 )
					return;
			  	row++;
				col = 1;
			  } else
			  	col++;
			  break;		  
		}
		//window.document.forms[1].elements[ lrow * cols + lcol + init ].tag = 0;
		if ( window.document.forms[1].elements[ row * cols + col + init ].type == 'text' ) {
			//window.document.forms[0].elements[ row * cols + col + init ].select();
			window.document.forms[1].elements[ row * cols + col + init ].focus();
			//window.document.forms[1].elements[ row * cols + col + init ].tag = 1;
		}
	}
	
	var ns6=document.getElementById&&!document.all;
	var ie=document.all;
	
	function addNew() {
		if (ie) {
			document.all.rows.value++;
			tbl = document.all.TBL;
			rn = tbl.rows.length;
			nr = tbl.insertRow( rn - 1 );
			x = rn % 2;
			if ( x == 0 )
				nr.style.cssText = "background-color: #E9EBEB;border:  2px thin solid #E9EBEB;";
			else
				nr.style.cssText = "background-color: #DADEDC;border:  2px thin solid #E9EBEB;";
			row = rn - 2;
			<!-- Colume 1 -->
			oCell=nr.insertCell();
			oCell.style.cssText = "font-family: Tahoma, Arial;font-size: 12px;padding-left: 10px;border: 1px solid #FFFFFF;padding-right: 3px;";
			oCell.innerHTML = "<input type='checkbox' name='delete" +row+ "'/>";			
			<!-- Colume 2 -->
			text = "<a href=javascript:readCurIrad('iradId"+row+"',"+row+"); tabindex='-1'>...</a><br><span id=iradId"+row+"Onvan></span>";			
			oCell=nr.insertCell();
			oCell.style.cssText = "font-family: Tahoma, Arial;font-size: 12px;padding-left: 10px;border: 1px solid #FFFFFF;padding-right: 3px;";
			oCell.innerHTML = "<input type='text' name='iradId"+row+"' size='11' maxlength='11' class='field' onFocus='focuse(this);' onBlur='blure(this,"+row+");' onKeyDown='processKeyEvent( "+row+", 1 );'/>" + text;
			<!-- Colume 3 -->
			text = "<a href=javascript:readCurOjrat('ojratId"+row+"',"+row+"); tabindex='-1'>...</a><br><span id=ojratId"+row+"Onvan></span>";
			oCell=nr.insertCell();
			oCell.style.cssText = "font-family: Tahoma, Arial;font-size: 12px;padding-left: 10px;border: 1px solid #FFFFFF;padding-right: 3px;";
			str = "<input type='text' name='ojratId"+row+"' size='11' maxlength='11' class='field' onFocus='focuse(this);' onBlur='blure(this,"+row+");' onKeyDown='processKeyEvent( "+row+", 2 );'/>" + text;
			oCell.innerHTML = str;			
			<!-- Colume 4 -->
			text = "<a href=javascript:readCurQate('shomarehFanni"+row+"',"+row+"); tabindex='-1'>...</a><br><span id=shomarehFanni"+row+"Onvan></span>";
			oCell=nr.insertCell();
			oCell.style.cssText = "font-family: Tahoma, Arial;font-size: 12px;padding-left: 10px;border: 1px solid #FFFFFF;padding-right: 3px;";
			str = "<input type='text' name='shomarehFanni"+row+"' size='20' maxlength='20' class='field' onFocus='focuse(this);' onBlur='blure(this,"+row+");' onKeyDown='processKeyEvent( "+row+", 3 );'/>" + text;			
			oCell.innerHTML = str;
			<!-- Colume 5 -->			
			oCell=nr.insertCell();
			oCell.style.cssText = "font-family: Tahoma, Arial;font-size: 12px;padding-left: 10px;border: 1px solid #FFFFFF;padding-right: 3px;";
			str = "<input type='text' name='tedadQate"+row+"' size='5' maxlength='5' class='field' onFocus='focuse(this);' onBlur='blure(this,"+row+");' onKeyDown='processKeyEvent( "+row+", 4 );'/>";
			oCell.innerHTML = str;
			<!-- Colume 6 -->
			oCell=nr.insertCell();
			oCell.style.cssText = "font-family: Tahoma, Arial;font-size: 12px;padding-left: 10px;border: 1px solid #FFFFFF;padding-right: 3px;";
			str = "<input type='text' name='hazineh"+row+"' size='11' maxlength='11' class='field' onChange='compute();' onFocus='focuse(this);' onBlur='blure(this,"+row+");' onKeyDown='processKeyEvent( "+row+", 5 );'/>";
			oCell.innerHTML = str;

			callSetGuarantee( nr );

			<!-- Colume 10 -->			
			oCell=nr.insertCell();
			oCell.style.cssText = "font-family: Tahoma, Arial;font-size: 12px;padding-left: 10px;border: 1px solid #FFFFFF;padding-right: 3px;";
			str = "<input type='hidden' name='id"+row+"'/>---";
			oCell.innerHTML = str;
			
			document.getElementById( "iradId" + row ).focus();
		}
	}
	
	function focuse( elem ) {
		elem.style.cssText = "border: 2px thin solid #666699;background-color: #FFFFFF;font-family: Tahoma, Arial;font-size: 9pt;";
		elem.tag = 1;
	}
	
	function blure( elem, i ) {
		if ( i % 2 == 0 )
			elem.style.cssText = "border: 2px thin solid #E9EBEB;background-color: #E9EBEB;";
		else
			elem.style.cssText = "border: 2px thin solid #DADEDC;background-color: #DADEDC;";
	}
	
	function setUpdateable() {
		document.all.updateable.value = "true";
	}
	
	function doTaeed( role ) {
		document.all.taeed.value = role;
		if( document.all.koliyehMadarek != null )
			if( !document.all.koliyehMadarek.checked )		
				alert( "کليه مدارک را بررسي کنيد" );
		else
			doSabt();
	}

	function doSabt() {
		if ( document.tasviehForm.checker.checked ) {
			if (!confirm( "آيا از حذف همه موارد مطمئن هستيد؟" ) )
				return false;
		} else {
			rn = document.all.TBL.rows.length - 3;
			for( i = 0; i <= rn; i++ ) {
				elem = "delete" + i;
				elem = document.getElementById( elem );
				if ( elem != null ){
					if ( elem.checked ){
						if (!confirm( "آيا از حذف موارد مطمئن هستيد؟" ) )
							return false;
						break;
					}
				}			
			}
		}
		if ( document.tasviehForm.newtt != null )		
			document.tasviehForm.newtt.disabled=true;
		if ( document.tasviehForm.sabtt != null )
			document.tasviehForm.sabtt.disabled=true;
		if ( document.tasviehForm.taeeed != null )
			document.tasviehForm.taeeed.disabled=true;
		if ( document.tasviehForm.adametaeeed != null )
			document.tasviehForm.adametaeeed.disabled=true;
		document.tasviehForm.submit();
	}
	
	function adameTaeed( role ) {
		document.all.taeed.value = "n" + role;
		if( document.all.ellateBargashteGuarantee.value == null || document.all.ellateBargashteGuarantee.value == "" )
			alert( "لطفا علت عدم تاييد را پر کنيد" );
		else
			doSabt();
	}
	
	function compute() {
		rn = document.all.TBL.rows.length - 3;
		sum = 0; sumKol = 0; sumgar = 0;
		for( i = 0; i <= rn; i++ ){
			elem = "hazineh" + i;
			elem = document.getElementById( elem );
			sumKol += parseInt( elem.value );
			check = "guarantee" + i;
			check = document.getElementById( check );			
			if ( check != null ){
				if ( check.checked ){
					sumgar += parseInt( elem.value );
				} else {
					sum += parseInt( elem.value );
				}
			}
		}
		document.all.jamkol.innerHTML = sumKol;
		document.all.jam.innerHTML = sum;
		document.all.jamg.innerHTML = sumgar;
	}	
	function checkId() {
		if ( isEmpty(document.all.dastoorKar.value) || !isInteger(document.all.dastoorKar.value)) {
			alert("لطفا دستور کار را صحيح وارد کنيد");
			return false;
		}
		if (document.tasviehForm!=null)
			document.tasviehForm.disabled = true;
		return true;
	}
</script>
<html:base/> 
</head>

<body dir="rtl" onKeyPress="callme();">
<form method="post" name="editTasvieh" action="/emdad/s/jozeatKhedmat.run" onSubmit="return checkId();">
  <table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="0" cellspacing="0">
		<tr class="editRow1" align="center" valign="middle">					 
			<td> دستور کـار:				
				<input class="field" type="text" name="dastoorKar"/> 
				&nbsp;
				<input class="emdadButton" name="virayesh" type="submit" value=" ويرايش "/>		
				&nbsp;&nbsp;&nbsp;	
				<input class="emdadButton" name="cancle" type="button" value="بستن صفحه" onClick="window.close();"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<logic:equal name="noeTasvieh" value="namayandegi">
					<input type="hidden" name="action_type" value="specific,tasvieHesabNamayandegiListEdit"/>
					<logic:equal name="role" value="h">
						<a href="/emdad/com/objectj/emdad/jsp/emdad.requpload.jsp" target="_blank">دريافت فايل XLS</a>						
					</logic:equal>
				</logic:equal>
				<logic:equal name="noeTasvieh" value="emdadgar">
					<input type="hidden" name="action_type" value="specific,tasvieHesabEmdadgarListEdit"/>
					<logic:equal name="role" value="h">
						<a href="/emdad/com/objectj/emdad/jsp/emdadgar.requpload.jsp" target="_blank">دريافت فايل XLS</a>						
					</logic:equal>
				</logic:equal>
				<logic:equal name="noeTasvieh" value="jarsaghil">
					<input type="hidden" name="action_type" value="specific,tasvieHesabJarsaghilListEdit"/>					
				</logic:equal>
					&nbsp;&nbsp;&nbsp;
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/help.jsp" flush="true">
   <jsp:param name="help_url" value="tasvieHesab.html" />	
</jsp:include>
			</td>
		</tr>
			<!-- 
      <td>شماره فاکتور: 
        
	  </td>		
			
      <td><input class="field" type="text" name="shomarehFactor" size="8"/></td>
	  <td >&nbsp;</td>
      <td align="left" colspan="2"><input class="emdadButton" name="virayesh" type="submit" value=" ويرايش "/> </td>
      </tr>-->
	</table>
	<input type="hidden" name="noeTasvieh" value="<bean:write name="noeTasvieh"/>"/>
</form>
<%
	String disabled= "disabled"; 
	if ( request.getAttribute( "emdadKhatemeNaYafteh" ) != null ) {
%>
		<br>
		<table align="center" cellpadding="5" style="font-family:tahoma;font-size:12px;">
			<tr>
				<td><strong><font color="#FF0000">امداد مورد نظر خاتمه نيافته است</font></strong></td>
			</tr>
		</table>
<%
	} else if ( request.getAttribute( "emdadNoAccess" ) != null ) {
%>
<br>
<jsp:include page="access.denied.jsp" flush="true"/>
<%
	} else if ( request.getAttribute( "emdadAdamTaeed" ) != null ) {
%>
		<br>
		<table align="center" cellpadding="5" style="font-family:tahoma;font-size:12px;">
			<tr>
				<td><strong><font color="#FF0000">جزييات تسويه حساب تاييد نشد</font></strong></td>
			</tr>
		</table>
<%
	} else if ( request.getAttribute( "emdadTaeed" ) != null ) {
%>
		<br>
		<table align="center" cellpadding="5" style="font-family:tahoma;font-size:12px;">
			<tr>
				<td><font color="#FF0000"><strong>جزييات تسويه حساب تاييد شد</strong></font></td>
			</tr>
		</table>
<%
	} else if( request.getAttribute( "invalidEmdadId" ) != null ) {	
%>		
		<br>
		<table align="center" cellpadding="5" style="font-family:tahoma;font-size:12px;">
			<tr>
				<td><font color="#FF0000"><strong>امداد با کد مورد نظر موجود نمي باشد</strong></font></td>
			</tr>
		</table>
<%		
		return; 
	} else {
%>

<script>
	function callSetGuarantee( nr ) {
			<logic:equal name="emdad" property="noeEmdad" value="1">
				<!-- Colume 7 -->
				oCell=nr.insertCell();
				oCell.style.cssText = "text-align: center;font-family: Tahoma, Arial;font-size: 12px;padding-left: 10px;border: 1px solid #FFFFFF;padding-right: 3px;";
				str = "<input type='checkbox' name='guarantee" +row+ "' value='1' onClick='compute();' />";
				oCell.innerHTML = str;			
				<!-- Colume 8 -->
				oCell=nr.insertCell();
				oCell.style.cssText = "text-align: center;font-family: Tahoma, Arial;font-size: 12px;padding-left: 10px;border: 1px solid #FFFFFF;padding-right: 3px;";
				str = "<input type='checkbox' name='manbaeTahiyeh" +row+ "' value='1' />";
				oCell.innerHTML = str;
				<!-- Colume 9 -->
				oCell=nr.insertCell();
				oCell.style.cssText = "text-align: center;font-family: Tahoma, Arial;font-size: 12px;padding-left: 10px;border: 1px solid #FFFFFF;padding-right: 3px;";
				str = "<input type='checkbox' name='nahveyePardakht" +row+ "' value='1' />";
				oCell.innerHTML = str;
			</logic:equal>
	}
	
	function callUpdateGaranteeCols() {
		<logic:equal name="emdad" property="noeEmdad" value="1">
			cols += 3;
			nottext += 3;
		</logic:equal>
	}
</script>

<% String ellatType = "hidden"; String type = "hidden"; String value=""; String taeedName = ""; String adamName = " عدم تاييد "; String ellatAdam = ""; String formAction = "jozeatKhedmat"; String moshtarakYaNa = "غير مشترک"; %>

<logic:equal name="noeTasvieh" value="namayandegi">
	<%  formAction = "validateTasvieHesabNamayandegi"; %>
</logic:equal>
<logic:equal name="noeTasvieh" value="emdadgar">
	<%  formAction = "validateTasvieHesabEmdadgar"; %>
</logic:equal>
<logic:equal name="noeTasvieh" value="jarsaghil">
	<%  formAction = "validateTasvieHesabJarsaghil"; %>
</logic:equal>

<logic:equal name="role" value="h">
	<%		
		EmdadList emdad = (EmdadList)request.getAttribute( "emdad" );
		int taeedHesabdar = ( emdad.getTaeedHesabdar() == null ) ? 2 : emdad.getTaeedHesabdar().intValue();
			if (  taeedHesabdar != 1 )
				disabled = "";
	%>
	<%
		taeedName = " تاييد حسابدار عمليات ";
		value = "h";
		ellatType = "text";
		type = "button";
		ellatAdam = "علت عدم تاييد :";
	%>
</logic:equal>

<logic:equal name="role" value="e">
	<%		
		EmdadList emdad = (EmdadList)request.getAttribute( "emdad" );
		int taeedHesabdar = ( emdad.getTaeedHesabdar() == null ) ? 2 : emdad.getTaeedHesabdar().intValue();
			if (  taeedHesabdar != 1 )
				disabled = "";
	%>
	<%		
		value = "e";
	%>
</logic:equal>

<logic:equal name="role" value="m">
	<%		
		EmdadList emdad = (EmdadList)request.getAttribute( "emdad" );
		int taeedHesabdar = ( emdad.getTaeedHesabdar() == null ) ? 2 : emdad.getTaeedHesabdar().intValue();
			if (  taeedHesabdar != 1 )
				disabled = "";
	%>
	<%		
		value = "m";		
	%>
</logic:equal>

<logic:equal name="role" value="n">
	<%
		taeedName = " تاييد نماينده مديريت ";
		value = "n";
		ellatType = "text";
		type = "button";
		ellatAdam = "علت عدم تاييد :";
	%>
</logic:equal>

<logic:equal name="role" value="g">
	<%
		taeedName = " تاييد گارانتي ";
		value = "g";
		ellatType = "text";
		type = "button";
		ellatAdam = "علت عدم تاييد :";
	%>
</logic:equal>
<%
	boolean taeeded = false;
	Integer tn = ( ((EmdadList)request.getAttribute( "emdad" )).getTaeedNamayandegi() );
	int taeedNamayandeh = ( tn == null ) ? 2 : tn.intValue();
	Integer tg = ( ((EmdadList)request.getAttribute( "emdad" )).getTaeedGuarantee() );
	int taeedGuarantee = ( tg == null ) ? 2 : tg.intValue();
	Integer th = ( ((EmdadList)request.getAttribute( "emdad" )).getTaeedHesabdar() );
	int taeedHesabdar = ( th == null ) ? 2 : th.intValue();
	if ( !request.getAttribute("role").equals("e") && !request.getAttribute("role").equals("m") && ( taeedNamayandeh == 1 ) || 
		 ( request.getAttribute("role").equals("h") && taeedHesabdar == 1 ) ||
		 ( ( request.getAttribute("role").equals("h") || request.getAttribute("role").equals("g") ) && taeedGuarantee == 1 ) ) {
		taeeded = true;
   }
%>

<form method="post" name="tasviehForm" action="/emdad/s/jozeatKhedmat.run">

<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
	<tr class="editRow0">
		<td class="editLabel">شماره فاکتور:</td>
		<td class="readData">
				<% if ( disabled.equals( "disabled" ) ) { %>
					<bean:write name="emdad" property="shomarehFactor"/>
					<input type="hidden" name="shomarehFactor" value='<bean:write name="emdad" property="shomarehFactor"/>'/>
				<% } else { %>
					<input type="text" onChange="setUpdateable();" name="shomarehFactor" size="11" maxlength="11" class="field" value='<bean:write name="emdad" property="shomarehFactor"/>'/><!--disabled-->
				<% } %>
		</td>
		<td class="editLabel">دستور کار:</td>
		<td class="readData">
			
			<input type="hidden" name="taeedHesabdar" value="<%=taeedHesabdar%>"/><input type="hidden" name="id" value='<bean:write name="emdad" property="id"/>'/>
			<input type="hidden" name="emdadId" value="<bean:write name='emdad' property='emdadId'/>"/><bean:write name="emdad" property="emdadId"/>
			<a href="javascript:emdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>			
			<font color="#FF0000"><bean:write name="emdad" property="noeEmdadName"/></font>
		</td>
		<td class="editLabel">امدادگر   / نمايندگي:</td>
		<td class="readData"><bean:write property="emdadgar" name="emdad"/>&nbsp;/&nbsp;<bean:write property="namayandegiName" name="emdad"/></td>
	</tr>

	<tr class="editRow0">
		<td colspan="6">
		<div   style="display:none;height:100px;" id="showEmdad">
			<iframe width="100%" height="100%" src="" frameborder="1" name="edtl" marginheight="0" marginwidth="0" ></iframe>
		</div>
		</td>
	</tr>
	<tr class="editRow1">
		<td class="editLabel">شماره مشتري:</td>
		<td class="readData"><bean:write name="emdad" property="moshtarakId"/>
			<input type="hidden" name="moshtarakId" value='<bean:write name="emdad" property="moshtarakId"/>'/><!--disabled-->
			<a href="javascript:moshtarakDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg2"></a><a href="javascript:showSavabeghMoshtari()">سوابق</a>
			<logic:equal name="moshtarakYaNa" value="1"/>
				<% moshtarakYaNa = "مشترک"; %>
			</logic:equal>
			<font color="#FF0000"><%= moshtarakYaNa + " " %><bean:write name="noeService"/></font>
		</td>
		<td class="editLabel">کيلومتر کارکرد:</td>				
		<td class="readData">
			<% if ( disabled.equals( "disabled" ) ) { %>
					<bean:write name="emdad" property="kilometerKarkard"/>
					<input type="hidden" name="kilometerKarkard" value='<bean:write name="emdad" property="kilometerKarkard"/>'/>
				<% } else { %>
					<input type="text" onChange="setUpdateable();" name="kilometerKarkard" size="11" maxlength="11" class="field" value='<bean:write name="emdad" property="kilometerKarkard"/>'><!--disabled-->
				<% } %>
		</td>
		<td class="editLabel">نوع خودرو:</td>
		<td class="readData"><input type="hidden" name="noeKhodroId" value="<bean:write name='noeKhodroId'/>"/><!--disabled--><bean:write name="noeKhodroOnvan"/></td>
	</tr>
	<tr class="editRow1"> 
		<td class="readData" colspan="6">						
		<div   style="display:none;height:100px;" id="showMoshtari">
			<iframe width="100%" height="100%" src="" frameborder="1" name="mdtl" marginheight="0" marginwidth="0" ></iframe>
		</div>
		</td>						
	</tr>
	<tr class="editRow1">
		<td class="readData" colspan="6">
			<div style="display:none;height:100px;" id="savabeghMoshtariFrame">
				<iframe width="100%" height="100%" src="" frameborder="1" name="savabegh" marginheight="0" marginwidth="0" ></iframe>
			</div>
		</td>
	</tr>
	<tr class="editRow0">
		<td class="editLabel">فاصله از نمايندگي:</td>
		<td class="readData">
				<% if ( disabled.equals( "disabled" ) ) { %>
					<bean:write name="emdad" property="faseleAzNamayandegi"/>
					<input type="hidden" name="faseleAzNamayandegi" value='<bean:write name="emdad" property="faseleAzNamayandegi"/>'/>
				<% } else { %>
					<input type="text" onChange="setUpdateable();" name="faseleAzNamayandegi" size="11" maxlength="11" class="field" value='<bean:write name="emdad" property="faseleAzNamayandegi"/>'><!--disabled-->
				<% } %>
		</td>
		<td class="editLabel">هزينه اياب ذهاب:</td>
		<td class="readData">
				<% if ( disabled.equals( "disabled" ) ) { %>
					<bean:write name="emdad" property="hazinehAyyabZahab"/>
					<input type="hidden" name="hazinehAyyabZahab" value='<bean:write name="emdad" property="hazinehAyyabZahab"/>'/>
				<% } else { %>
					<input type="text" onChange="setUpdateable();" name="hazinehAyyabZahab" size="11" maxlength="11" class="field" value='<bean:write name="emdad" property="hazinehAyyabZahab"/>'><!--disabled-->
				<% } %>
		</td>
		<td class="editLabel">هزينه بکسل:</td>
		<td class="readData">
				<% if ( disabled.equals( "disabled" ) ) { %>
					<bean:write name="emdad" property="hazinehBoxel"/>
					<input type="hidden" name="hazinehBoxel" value='<bean:write name="emdad" property="hazinehBoxel"/>'/>
				<% } else { %>
					<input type="text" onChange="setUpdateable();" name="hazinehBoxel" size="11" maxlength="11" class="field" value='<bean:write name="emdad" property="hazinehBoxel"/>'><!--disabled-->
				<% } %>
		</td>
	</tr>
</table>
<table id="TBL" width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
		<tr class="listTableHeader">			
			<td class = "listRow0Col" width="2%"><input name="checker" type="checkbox" onClick="checkitAll(this);"/></td>

			<td class = "listRow0Col">کد ايراد</td>
			
			<td class = "listRow0Col">کد اجرت</td>						

			<td class = "listRow0Col">شماره فني قطعه</td>						

			<td class = "listRow0Col">تعداد قطعه</td>

			<td class = "listRow0Col">هزينه</td>
			
			<logic:equal name="emdad" property="noeEmdad" value="1">			
				<td align="center" class = "listRow0Col" width="3%">گارانتي </td>
				
				<td align="center" class = "listRow0Col" width="3%">تهيه از بازار</td>
				
				<td align="center" class = "listRow0Col" width="3%">پرداخت نقدي</td>
			</logic:equal>
			
			<td class = "listRow0Col">هزينه متعارف</td>
		</tr>

		<!------------------------------------------------>
		<% int i = 0; int hazinehSum = 0; int hazinehSumg = 0; int hazinehKol = 0; int hazinehDefaultSum = 0; boolean hasGuarantee = false;%>	
		
		<logic:iterate id="value_object" name="value_object_list">
			<%  				
				if ( disabled.equals( "" ) && !taeeded ) { hasGuarantee = true; %>
			<tr class="listRow<%=i%2%>">

				<td class = "listRow1Col"> 
					<input type="checkbox" name="delete<%=i%>" value='<bean:write property="id" name="value_object"/>' />
				</td>
				
				<td class = "listRow1Col">
					<logic:equal name="<%= "iradIdError" + i %>" value="true">
						<img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/d-op.gif" alt="" height="16" width="16" />
					</logic:equal>					
					<input type="text" name="iradId<%=i%>" value='<bean:write property="iradId" name="value_object"/>' 
						size="11" maxlength="11" class="field<%=i%2%>" onFocus="focuse(this);" onBlur="blure(this,<%=i%>);" onKeyDown="processKeyEvent( <%=i%>, 1 );"/>											
					<a href="javascript:readCurIrad('iradId<%=i%>', <%=i%>);" tabindex='-1'>...</a>
					<br>
					<span id="iradId<%=i%>Onvan"><bean:write property="iradOnvan" name="value_object"/></span>
				</td>
				
				<td class = "listRow1Col">
					<logic:equal name="<%= "ojratIdError" + i %>" value="true">
						<img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/d-op.gif" alt="" height="16" width="16" />
					</logic:equal>					
					<input type="text" name="ojratId<%=i%>" value='<bean:write property="ojratId" name="value_object"/>' 
						size="11" maxlength="11" class="field<%=i%2%>" onFocus="focuse(this);" onBlur="blure(this,<%=i%>);" onKeyDown="processKeyEvent( <%=i%>, 2 );"/>						
					<a href="javascript:readCurOjrat('ojratId<%=i%>', <%=i%>);" tabindex='-1'>...</a>
					<br>
					<span id="ojratId<%=i%>Onvan"><bean:write property="ojratOnvan" name="value_object"/></span>
					<logic:equal name="<%= "ojratHazinehAlert" + i %>" value="true">
						<br><font color="FF0000">0 --- صفر</font>
					</logic:equal>
				</td>
				
				<td class = "listRow1Col">
					<logic:equal name="<%= "shomarehFanniError" + i %>" value="true">
						<img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/d-op.gif" alt="" height="16" width="16" />
					</logic:equal>
					<input type="text" name="shomarehFanni<%=i%>" value='<bean:write property="shomarehFanni" name="value_object"/>'
						size="20" maxlength="20" class="field<%=i%2%>" onFocus="focuse(this);" onBlur="blure(this,<%=i%>);" onKeyDown="processKeyEvent( <%=i%>, 3 );"/>
					<a href="javascript:readCurQate('shomarehFanni<%=i%>', <%=i%>);" tabindex='-1'>...</a>
					<br>
					<span id="shomarehFanni<%=i%>Onvan"><bean:write property="qateName" name="value_object"/></span>
				</td>							
				
				<td class = "listRow1Col">
					<logic:equal name="<%= "tedadQateError" + i %>" value="true">
						<img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/d-op.gif" alt="" height="16" width="16" />
					</logic:equal>		
					<logic:equal name="<%= "mojoodiManfiError" + i %>" value="true">
						<img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/d-op.gif" alt="" height="16" width="16" />
						<font color="#FF0000">کسر موجودي</font>
					</logic:equal>	
					<input type="text" name="tedadQate<%=i%>" value='<bean:write property="tedadQate" name="value_object"/>' 
						size="5" maxlength="5" class="field<%=i%2%>" onFocus="focuse(this);" onBlur="blure(this,<%=i%>);" onKeyDown="processKeyEvent( <%=i%>, 4 );"/>					
				</td>

				<td class = "listRow1Col">
					<input type="text" name="hazineh<%=i%>" onChange="compute();" value='<bean:write property="hazineh" name="value_object"/>' 
						size="11" maxlength="11" class="field<%=i%2%>" onFocus="focuse(this);" onBlur="blure(this,<%=i%>);" onKeyDown="processKeyEvent( <%=i%>, 5 );"/>
				</td>
				<logic:equal name="emdad" property="noeEmdad" value="1">
				
					<td class = "listRow1Col" align="center">
						<% String checked = ""; %>
						<logic:equal name="value_object" property="guarantee" value="1">
							<% checked = "checked"; %>
						</logic:equal>
						<input type="checkbox" name="guarantee<%=i%>" value="1" <%=checked%> onClick="compute();"/>										
					</td>		
								
					<td class = "listRow1Col" align="center">
						<% String checked1 = ""; %>
						<logic:equal name="value_object" property="manbaeTahiyeh" value="1">
							<% checked1 = "checked"; %>
						</logic:equal>
						<input type="checkbox" name="manbaeTahiyeh<%=i%>" value="1" <%=checked1%> />
					</td>
					
					<td class = "listRow1Col" align="center">
						<% String checked2 = ""; %>
						<logic:equal name="value_object" property="nahveyePardakht" value="1">
							<% checked2 = "checked"; %>
						</logic:equal>
						<input type="checkbox" name="nahveyePardakht<%=i%>" value="1" <%=checked2%> />
					</td>
				</logic:equal>
				
				<td class = "listRow1Col">
					<logic:equal name="value_object" property="hazinehDefault" value="0" >
						<font color="#FF0000"><bean:write property="hazinehDefault" name="value_object"/> --- صفر</font>
					</logic:equal>
					<logic:notEqual name="value_object" property="hazinehDefault" value="0" >
						<bean:write property="hazinehDefault" name="value_object"/>
					</logic:notEqual>
					<input type="hidden" name="id<%=i%>" value='<bean:write property="id" name="value_object"/>' />
				</td>
				
            </tr>
			<% } else { %>
				<tr class="listRow<%=i%2%>">

					<td class = "listRow1Col"> 
						<%= i + 1 %> 
					</td>
					
					<td class = "listRow1Col">
						<bean:write property="iradId" name="value_object"/>
						<br><bean:write property="iradOnvan" name="value_object"/>
					</td>
					
					<td class = "listRow1Col">
						<bean:write property="ojratId" name="value_object"/>
						<br><bean:write property="ojratOnvan" name="value_object"/>
					</td>
				
					<td class = "listRow1Col">
						<bean:write property="shomarehFanni" name="value_object"/>
						<br><bean:write property="qateName" name="value_object"/>
					</td>
									
					<td class = "listRow1Col">
						<bean:write property="tedadQate" name="value_object"/>
					</td>					
	
					<td class = "listRow1Col">
						<bean:write property="hazineh" name="value_object"/>
					</td>
					<logic:equal name="emdad" property="noeEmdad" value="1">
						<td class = "listRow1Col" align="center">
							<% String g = "خير"; %>
							<logic:equal name="value_object" property="guarantee" value="1">							
								<% g = "بلي"; %>
							</logic:equal>
							<%= g %>
						</td>		
									
						<td class = "listRow1Col" align="center">
							<% String m = "خير"; %>
							<logic:equal name="value_object" property="manbaeTahiyeh" value="1">
								<% m = "بلي"; %>
							</logic:equal>
							<%= m %>
						</td>
						
						<td class = "listRow1Col" align="center">
							<% String n = "خير"; %>
							<logic:equal name="value_object" property="nahveyePardakht" value="1">
								<% n =  "بلي"; %>
							</logic:equal>
							<%= n %>
						</td>
					</logic:equal>
					
					<td class = "listRow1Col">
						<bean:write property="hazinehDefault" name="value_object"/>
					</td>
					
				</tr>
				<input type="hidden" name="iradId<%=i%>" value='<bean:write property="iradId" name="value_object"/>' />
				<input type="hidden" name="ojratId<%=i%>" value='<bean:write property="ojratId" name="value_object"/>' />
				<input type="hidden" name="shomarehFanni<%=i%>" value='<bean:write property="shomarehFanni" name="value_object"/>'/>					
				<input type="hidden" name="tedadQate<%=i%>" value='<bean:write property="tedadQate" name="value_object"/>'/> 
				<input type="hidden" name="hazineh<%=i%>" value='<bean:write property="hazineh" name="value_object"/>'/>
				<input type="hidden" name="guarantee<%=i%>" value='<bean:write property="guarantee" name="value_object"/>'/>
				<input type="hidden" name="manbaeTahiyeh<%=i%>" value='<bean:write property="manbaeTahiyeh" name="value_object"/>'/>
				<input type="hidden" name="nahveyePardakht<%=i%>" value='<bean:write property="nahveyePardakht" name="value_object"/>'/>
				<input type="hidden" name="id<%=i%>" value='<bean:write property="id" name="value_object"/>' />
			<% } %>
			<%				
				if ( ((JozeatKhedmatList)value_object).getGuarantee().intValue() != 1 ) 
					hazinehSum += ((JozeatKhedmatList)value_object).getHazineh().intValue();
				else
					hazinehSumg += ((JozeatKhedmatList)value_object).getHazineh().intValue();
			%>
            <% i++; hazinehDefaultSum += ((JozeatKhedmatList)value_object).getHazinehDefault().intValue(); hazinehKol += ((JozeatKhedmatList)value_object).getHazineh().intValue();%>
			
        </logic:iterate>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<logic:equal name="emdad" property="noeEmdad" value="1">
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</logic:equal>
			<td>&nbsp;</td>
		</tr>
	</table>
<table dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
	<tr>
		<td><font color="#FF0000">جمع کل هزينه:</font>&nbsp;
			<span id="jamkol"><%=hazinehKol%></span>
		</td>
		<td><font color="#FF0000">جمع هزينه با گارانتي:</font>&nbsp;
			<span  id="jamg"><%= hazinehSumg %></span>
		</td>
		<td><font color="#FF0000">جمع هزينه بدون گارانتي:</font>&nbsp;
			<span id="jam"><%=hazinehSum%></span>
		</td>			
		<td>&nbsp;</td>
		<td><font color="#FF0000">جمع هزينه متعارف:</font>&nbsp;<%= hazinehDefaultSum %></td>
	</tr>
</table>

<table dir="rtl" align="right" class="generalText" border="0" cellpadding="3" cellspacing="0">
		<tr>
			<!-- <input type="hidden" name="action_type" value="specific,<%=formAction%>"/>		-->
			<input type="hidden" name="action_type" value="specific,validateTasvieHesabNamayandegi"/>		
			<td>کليه مدارک لازم موجود است : </td>
			<td><% String selected1 = ""; String madarek="خير"; %>
				<logic:equal name="emdad" property="koliyehMadarek" value="1">
					<% selected1 = "checked"; madarek = "بلي"; %>
				</logic:equal>
				<% if ( disabled.equals( "disabled" ) ) { %>
					<%= madarek %>
				<% } else { %>
					<input type="checkbox" onChange="setUpdateable();" name="koliyehMadarek" <%=selected1%> value="1" /><!--disabled-->					
				<% } %>
			</td>
		</tr>
		<tr>						
			<% if ( !taeeded ) { %>
				<td align="left"><%= ellatAdam %></td>
				<td><input type="<%=ellatType%>" onChange="setUpdateable();" name="ellateBargashteGuarantee" size="100" class="field" value='<bean:write name="emdad" property="ellateBargashteGuarantee"/>' onKeyPress="submitenter2(this,event);"/></td>
			<% } %>			
		</tr>
	</table>
	<br>
	<br>
	<br>
	<table dir="rtl" align="right" class="generalText" border="0" cellpadding="3" cellspacing="0">
		<tr>
			<% if ( !disabled.equals( "disabled" ) ) { %>
				<td ><input name="newtt" type="button" value="جديد"   class="emdadButton" onClick="addNew();"></td>
				<td ><input name="sabtt" type="button" value="ثبت"    class="emdadButton" onClick="doSabt();"></td>
			<% } %>
			<td ><input type="button" value="انصراف" class="emdadButton" onClick="window.close();"></td>
			<% if( !taeeded ) { %>
				<td ><input name="taeeed" type="<%=type%>" value="<%=taeedName%>" class="emdadButton" onClick="doTaeed( '<%=value%>' );"></td>
				<logic:notEqual name="role" value="h">
					<td ><input name="adametaeeed" type="<%=type%>" value="<%=adamName%>"  class="emdadButton" onClick="adameTaeed( '<%=value%>' );"></td>
				</logic:notEqual>
			<% } %>
			<!-- <td ><input type="button" value="فهرست قطعه" class="emdadButton" onClick="qateSearch( true );"></td>
			<td ><input type="button" value="فهرست اجرت" class="emdadButton" onClick="ojratSearch( true, '' );"></td>
			<td ><input type="button" value="فهرست ايراد" class="emdadButton" onClick="iradSearch( true, '' );"></td> -->
				 <input type="hidden" name="rows" value="<%=i%>"/>
				 <input type="hidden"  name="taeed" value="xx<%=value%>" />
				 <input type="hidden" name="updateable" value="false"/>
				 <input type="hidden" name="cur_item" value=""/>
				 <input type="hidden" name="noeTasvieh" value="<bean:write name="noeTasvieh"/>"/>
		</tr>
		<% if ( !disabled.equals( "disabled" ) ) { %>
		<tr class="editRow1">			
		  <td colspan="10">ثبت: <font color="#FF0000">Enter</font> &nbsp;&nbsp;&nbsp;&nbsp; جديد: 
			<font color="#FF0000">Ctrl-J</font> &nbsp;&nbsp;&nbsp;&nbsp; جستجوي مورد 
			فعلي: <font color="#FF0000">Alt</font></td>
		</tr>
		<% } %>
	</table>
</form>
<%  } %>
</body>
</html>
<script>
	document.all.dastoorKar.focus();
	<% if ( !disabled.equals( "disabled" ) ) { %>
	
	function callme() {
		if( window.event.keyCode == 13 ) {
			doSabt();
			return;
		}
		if( window.event.ctrlKey ) {		
			if( window.event.keyCode == 10 ) {
				// ctrl+j
				addNew();
				return;
			}
		}
	}	
	
	function checkitAll( checker ) {
		rn = document.all.TBL.rows.length - 3;
		for( i = 0; i <= rn; i++ ) {
			elem = "delete" + i;
			elem = document.getElementById( elem );
			if ( elem != null ){
				if ( checker.checked ){
					elem.checked = true;
				} else {
					elem.checked= false;
				}
			}			
		}		
	}
	<% } %>
</script>