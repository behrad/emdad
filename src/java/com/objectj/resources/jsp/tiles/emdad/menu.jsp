<%@ page import="com.objectj.emdad.web.sysadmin.SysAdminDAO,
                 java.util.ArrayList,
                 java.util.Iterator,
                 com.objectj.emdad.web.sysadmin.MenuModel,
                 com.objectj.emdad.web.sysadmin.UseCaseModel,
                 com.objectj.emdad.ejb.UserAccessEntity"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<script language="JavaScript" type="text/JavaScript">
	function rokhdad__Details() {
		window.open("/emdad/s/rokhdad.run?action_type=specific,rokhdadShow&id="+document.tempForm.rokhdadId.value , "ttl",
			"width=700 , height=500 , resizable=yes, scrollbars=yes, status=0");
	}


	function show_Naghshe() {
		window.open("/emdad/com/objectj/emdad/jsp/naghshe.jsp", "ttl",
			"toolbar=no, width=800 , height=600 , resizable=yes, scrollbars=yes, status=0");
	}

	function show_Savabegh_Moshtari() {
		window.open("/emdad/s/moshtarak.run?action_type=specific,savabegh&id="+document.tempForm2.eshterakId.value , "ttl",
			"width=700 , height=500 , resizable=yes, scrollbars=yes, status=0");
	}


	function show_Savabegh_shomareshasi() {
		window.open("/emdad/s/moshtarak.run?action_type=specific,savabegh&id="+document.tempForm2.shomareShasi.value , "ttl",
			"width=700 , height=500 , resizable=yes, scrollbars=yes, status=0");
	}

	function emdad__Details() {
		window.open("/emdad/s/emdad.run?action_type=specific,emdadShow&id="+document.tempForm.emdadId.value , "ttl",
			"width=700 , height=500 , resizable=yes, scrollbars=yes, status=0");
	}


var openMenu = 0;

function openRep(id) {
	//window.open("< % = com.objectj.emdad.ejb.util.Constants.getReportsURL() % > "+id , "report", "resizable=yes, scrollbars=yes, status=0");
	//window.open("http://222.192.55.220/reports"+id , "report", "resizable=yes, scrollbars=yes, status=0");
	window.open("/reports/xml.report.get.jsp?reportId="+id , "report", "resizable=yes, scrollbars=yes, status=0");
}

function openRepP(id) {
	//window.open("< % = com.objectj.emdad.ejb.util.Constants.getReportsURL() % > "+id , "report", "resizable=yes, scrollbars=yes, status=0");
	//window.open("http://222.192.55.220/reports"+id , "report", "resizable=yes, scrollbars=yes, status=0");
	window.open("/reports/athorize.jsp?viewId="+id , "report", "resizable=yes, scrollbars=yes, status=0");
}

function sivij(idx) {
	var closeAll= false;

	if ((idx == 1) || (idx == 2) || (idx == 3) || (idx == 4) || (idx == 5) || (idx == 6)){
		closeAll = true;
	}

	if (closeAll){
		for (i = 1; i <= 6; i++){
			if (i != idx){
				obj = eval("document.all.div" + i);
				obi = eval("document.all.img" + i);
				tdi = eval("document.all.td" + i);
				if ( obj ) {
					obj.style.display = "none";
					obi.src = "images/f-on.gif";
					tdi.background = "images/menu-top-strip.jpg";
				}
			}
		}
	}

	if (openMenu != idx && openMenu > 0){
		obj = eval("document.all.div" + openMenu);
		obi = eval("document.all.img" + openMenu);
		tdi = eval("document.all.td" + openMenu);
		if ( obj ) {
			obj.style.display = "none";
			obi.src = "images/f-on.gif";
			tdi.background = "images/menu-top-strip.jpg";
		}
	}

	if ((idx == 1) || (idx == 2) || (idx == 3) || (idx == 4) || (idx == 5) || (idx == 6))
		openMenu = 0;
	else
		openMenu = idx;

	obj = eval("document.all.div" + idx);
	obi = eval("document.all.img" + idx);
	tdi = eval("document.all.td" + idx);
	men = eval("document.all.men" + idx);

	if ( obj ) {
		if ( obj.style ) {
			obj = obj.style;
			if ( obj.display == "none" ) {
				obj.display = "inline";
				obi.src = "images/f-off.gif";
				tdi.background = "images/menu-mid.jpg";
			} else {
				obj.display = "none";
				obi.src = "images/f-on.gif";
				tdi.background = "images/menu-top-strip.jpg";
			}
		}
	}
	men.hideFocus = true;
}



</script>

<%
	String role = "";
	String doId = "";
	try {
        String username = request.getUserPrincipal().getName();
        role = UserAccessEntity.getUserRole(username);
	doId = UserAccessEntity.getDaftarOstaniId(username);
    } catch (Exception e) {
		role = "";
    }
    ArrayList menus = SysAdminDAO.getMenus(role);
    int menuId = 10; %>


<!----------------------------------------------------------------------->

<%
	boolean showMenu = false;
    for (Iterator menuIt = menus.iterator(); menuIt.hasNext();) {
        MenuModel mm = (MenuModel) menuIt.next();
        if (mm.getBpName().equals("todo"))
	        if (mm.getUsecases().size() >  0){
	        	showMenu = true;
	        	break;
	        }
	}
	if (showMenu){
%>

     <tr><td background="images/menu-top.jpg" align="right" height="20" valign="middle">
            &nbsp;&nbsp;<a href="javascript:sivij('3');" id="men3">
            <img src="images/f-on.gif" border="0" id="img3">
						<span class="menuTitle">در حال اجرا</span></a>
					</td></tr>
					<tr><td id="td3"  background="images/menu-top-strip.jpg" align="center">
						<div id="div3" style="display:none;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">

<%
    for (Iterator menuIt = menus.iterator(); menuIt.hasNext();) {
        MenuModel mm = (MenuModel) menuIt.next();
        if (mm.getBpName().equals("todo")){
	        if (mm.getUsecases().size() <=  0)
	        	break;
%>
                        <tr><td width="8">&nbsp;</td>
					    <td align="center">
<%
        for (Iterator ucIt = mm.getUsecases().iterator(); ucIt.hasNext();) {
            UseCaseModel ucm = (UseCaseModel) ucIt.next();
           if (ucm.showInMenu() != 1){
%>
		<a href="/emdad<%= ucm.getUcURL() %>"><span class="paayeLink"><%= ucm.getUcTitle() %></span></a><br>
<%
}
}
%>
<%
    }
    }
%>

				</table>
				</div>
				</td></tr>
					<tr><td><img src="images/menu-bot.jpg"></td></tr>

<% }%>
<!----------------------------------------------------------------------->

<%
	showMenu = false;
    for (Iterator menuIt = menus.iterator(); menuIt.hasNext();) {
        MenuModel mm = (MenuModel) menuIt.next();
        if (!mm.getBpName().equals("base") && !mm.getBpName().equals("report") && !mm.getBpName().equals("todo"))
	        if (mm.getUsecases().size() >  0){
	        	showMenu = true;
	        	break;
	        }
	}
	if (showMenu){
%>


     <tr><td background="images/menu-top.jpg" align="right" height="20" valign="middle">
            &nbsp;&nbsp;<a href="javascript:sivij('1');" id="men1">
            <img src="images/f-on.gif" border="0" id="img1">
						<span class="menuTitle">وظايف جاري</span></a>
					</td></tr>
					<tr><td id="td1"  background="images/menu-top-strip.jpg" align="center">
						<div id="div1" style="display:none;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">

<%
	for (Iterator menuIt = menus.iterator(); menuIt.hasNext();) {
        MenuModel mm = (MenuModel) menuIt.next();
        if (mm.getBpName().equals("base") || mm.getBpName().equals("report") || mm.getBpName().equals("reportp") || mm.getBpName().equals("todo") || mm.getBpName().equals("search") || mm.getBpName().equals("savabegh"))
        	continue;
        if (mm.getUsecases().size() <=  0)
        	continue;
        menuId ++;
%>
        <tr><td background="images/menu-sub-top.jpg" align="right" height="20" valign="middle">
            &nbsp;&nbsp;<a href="javascript:sivij('<%= menuId %>');" id="men<%= menuId %>">
            <img src="images/f-on.gif" border="0" id="img<%= menuId %>">
						<span class="menuTitle"><%= mm.getBpTitle() %></span></a>
					</td></tr>

					<tr><td id="td<%= menuId %>"  background="images/menu-top-strip.jpg" align="center">
						<div id="div<%= menuId %>" style="display:none;">

                    <table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
                        <tr><td width="8">&nbsp;</td>
					    <td align="center">
<%
        for (Iterator ucIt = mm.getUsecases().iterator(); ucIt.hasNext();) {
            UseCaseModel ucm = (UseCaseModel) ucIt.next();
            if (ucm.getUcURL().equals("show_Naghshe()")){
%>
		        <a href="javascript:show_Naghshe()"><span class="paayeLink"><%= ucm.getUcTitle() %></span></a><br>
<%          }else{%>
		        <a href="/emdad<%= ucm.getUcURL() %>"><span class="paayeLink"><%= ucm.getUcTitle() %></span></a><br>
<%
            }
        }
%>
                        </td>
						<td width="8">&nbsp;</td></tr>
						<tr><td height="4" width="*" colspan="3"><img src="images/menu-mid.jpg"></td>
						</tr></table>
						</div>
					</td></tr>
<%
    }
%>
				</table>
				</div>
				</td></tr>
					<tr><td><img src="images/menu-bot.jpg"></td></tr>

<% }%>
<!----------------------------------------------------------------------->

<%
	showMenu = false;
    for (Iterator menuIt = menus.iterator(); menuIt.hasNext();) {
        MenuModel mm = (MenuModel) menuIt.next();
        if (mm.getBpName().equals("base"))
	        if (mm.getUsecases().size() >  0){
	        	showMenu = true;
	        	break;
	        }
	}
	if (showMenu){
%>

     <tr><td background="images/menu-top.jpg" align="right" height="20" valign="middle">
            &nbsp;&nbsp;<a href="javascript:sivij('4');" id="men4">
            <img src="images/f-on.gif" border="0" id="img4">
						<span class="menuTitle">اطلاعات پايه</span></a>
					</td></tr>
					<tr><td id="td4"  background="images/menu-top-strip.jpg" align="center">
						<div id="div4" style="display:none;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
<%
    for (Iterator menuIt = menus.iterator(); menuIt.hasNext();) {
        MenuModel mm = (MenuModel) menuIt.next();
        if (mm.getBpName().equals("base")){
	        if (mm.getUsecases().size() <=  0)
	        	break;
%>
                        <tr><td width="8">&nbsp;</td>
					    <td align="center">
<%
        for (Iterator ucIt = mm.getUsecases().iterator(); ucIt.hasNext();) {
            UseCaseModel ucm = (UseCaseModel) ucIt.next();
           if (ucm.showInMenu() != 1){
%>
		<a href="/emdad<%= ucm.getUcURL() %>"><span class="paayeLink"><%= ucm.getUcTitle() %></span></a><br>
<%
}
}
%>
<%
    }
    }
%>
				</table>
				</div>
				</td></tr>
					<tr><td><img src="images/menu-bot.jpg"></td></tr>

<% }%>

<!----------------------------------------------------------------------->

<%
	showMenu = false;
    for (Iterator menuIt = menus.iterator(); menuIt.hasNext();) {
        MenuModel mm = (MenuModel) menuIt.next();
        if (mm.getBpName().startsWith("report"))
	        if (mm.getUsecases().size() >  0){
	        	showMenu = true;
	        	break;
	        }
	}
	if (showMenu){
%>


     <tr><td background="images/menu-top.jpg" align="right" height="20" valign="middle">
            &nbsp;&nbsp;<a href="javascript:sivij('2');" id="men2">
            <img src="images/f-on.gif" border="0" id="img2">
						<span class="menuTitle">گزارش</span></a>
					</td></tr>
					<tr><td id="td2"  background="images/menu-top-strip.jpg" align="center">
						<div id="div2" style="display:none;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
<%
    showMenu = false;
    for (Iterator menuIt = menus.iterator(); menuIt.hasNext();) {
        MenuModel mm = (MenuModel) menuIt.next();
        if (mm.getBpName().startsWith("report"))
            if (mm.getUsecases().size() >  0){
                showMenu = true;
                break;
            }
    }
    if (showMenu){
%>

 		<tr><td background="images/menu-sub-top.jpg" align="right" height="20" valign="middle">
            &nbsp;&nbsp;<a href="javascript:sivij('<%= ++menuId %>');" id="men<%= menuId %>">
            <img src="images/f-on.gif" border="0" id="img<%= menuId %>">
					<span class="menuTitle">ثابت</span></a>
					</td></tr>
					<tr><td id="td<%= menuId %>"  background="images/menu-top-strip.jpg" align="center">
						<div id="div<%= menuId %>" style="display:none;">

                    <table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
		<%
			for (Iterator menuIt = menus.iterator(); menuIt.hasNext();) {
				MenuModel mm = (MenuModel) menuIt.next();
				if (mm.getBpName().equals("report")){
					if (mm.getUsecases().size() <=  0)
						break;
		%>
					<tr><td width="8">&nbsp;</td>
					<td align="center">
		<%
				for (Iterator ucIt = mm.getUsecases().iterator(); ucIt.hasNext();) {
					UseCaseModel ucm = (UseCaseModel) ucIt.next();
				   if (ucm.showInMenu() != 1){
				String ucurl = ucm.getUcURL();
				if (ucurl.indexOf("$doId$")!=-1) {
					ucurl = com.objectj.emdad.ejb.util.Util.replaceAll(ucurl, "$doId$", doId);
				}
		%>
				<a href="javascript:openRep('<%=ucurl%>')" ><span class="paayeLink"><%= ucm.getUcTitle() %></span></a><br>
		<%
		}
		}
			}
			}
		%>
                        </td>
						<td width="8">&nbsp;</td></tr>
						<tr><td height="4" width="*" colspan="3"><img src="images/menu-mid.jpg"></td>
						</tr></table>
						</div>
					</td></tr>

<%}
    showMenu = false;
    for (Iterator menuIt = menus.iterator(); menuIt.hasNext();) {
        MenuModel mm = (MenuModel) menuIt.next();
        if (mm.getBpName().startsWith("reportp"))
            if (mm.getUsecases().size() >  0){
                showMenu = true;
                break;
            }
    }
    if (showMenu){
%>
		<tr><td background="images/menu-sub-top.jpg" align="right" height="20" valign="middle">
            &nbsp;&nbsp;<a href="javascript:sivij('<%= ++menuId %>');" id="men<%= menuId %>">
            <img src="images/f-on.gif" border="0" id="img<%= menuId %>">
					<span class="menuTitle">قابل تعريف</span></a>
					</td></tr>
					<tr><td id="td<%= menuId %>"  background="images/menu-top-strip.jpg" align="center">
						<div id="div<%= menuId %>" style="display:none;">

                    <table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
		<%
			for (Iterator menuIt = menus.iterator(); menuIt.hasNext();) {
				MenuModel mm = (MenuModel) menuIt.next();
				if (mm.getBpName().equals("reportp")){
					if (mm.getUsecases().size() <=  0)
						break;
		%>
					<tr><td width="8">&nbsp;</td>
					<td align="center">
		<%
				for (Iterator ucIt = mm.getUsecases().iterator(); ucIt.hasNext();) {
					UseCaseModel ucm = (UseCaseModel) ucIt.next();
				   if (ucm.showInMenu() != 1){
				String ucurl = ucm.getUcURL();
				if (ucurl.indexOf("$doId$")!=-1) {
					ucurl = com.objectj.emdad.ejb.util.Util.replaceAll(ucurl, "$doId$", doId);
				}
		%>
				<a href="javascript:openRepP('<%=ucurl%>')" ><span class="paayeLink"><%= ucm.getUcTitle() %></span></a><br>
		<%
		}
		}
			}
			}
		%>
                        </td>
						<td width="8">&nbsp;</td></tr>
						<tr><td height="4" width="*" colspan="3"><img src="images/menu-mid.jpg"></td>
						</tr></table>
						</div>
					</td></tr>
<%}%>
				</table>
				</div>
				</td></tr>
					<tr><td><img src="images/menu-bot.jpg"></td></tr>

<%}%>
<!----------------------------------------------------------------------->
<!-- -->
<script language="JavaScript" type="text/JavaScript">
function eshterakKeyPress() {
  if (window.event.keyCode == 13) {
	show_Savabegh_Moshtari();
	window.event.keyCode == 0;
  }
}
function emdadIdKeyPress() {
  if (window.event.keyCode == 13) {
	emdad__Details();
	window.event.keyCode == 0;
  }
}
function rokhdadIdKeyPress() {
  if (window.event.keyCode == 13) {
	rokhdad__Details();
	window.event.keyCode == 0;
  }
}
function shomareShasiKeyPress() {
  if (window.event.keyCode == 13) {
	show_Savabegh_shomareshasi();
	window.event.keyCode == 0;
  }
}


</script>

<!----------------------------------------------------------------------->

<%
	showMenu = false;
    for (Iterator menuIt = menus.iterator(); menuIt.hasNext();) {
        MenuModel mm = (MenuModel) menuIt.next();
        if (mm.getBpName().equals("savabegh")) {
	        	showMenu = true;
	        	break;
	        }
	}
	if (showMenu){
%>

			<tr><td background="images/menu-top.jpg" align="right" height="20" valign="middle">
            &nbsp;&nbsp;<a href="javascript:sivij('6');" id="men6">
            <img src="images/f-on.gif" border="0" id="img6">
						<span class="menuTitle">سوابق مشتری</span></a>
					</td></tr>
					<tr><td id="td6"  background="images/menu-top-strip.jpg" align="center">
						<div id="div6" style="display:none;"><form name="tempForm2">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">

						<tr><td width="16"></td><td align="right" class="paayeLink"><a href="javascript:show_Savabegh_moshtari();">...<small>کد اشتراک</small></a></td><td width="16"></td></tr>
						<tr><td width="12"></td><td align="right"><input type=text name="eshterakId" value="" size=13 maxsize=10  onKeyPress="eshterakKeyPress()"/></td><td width="12"></td></tr>
						<tr height="1"  valign="center"><td width="20"></td><td align="center" bgcolor="#ffeedd"></td><td width="20"></td></tr>

						<tr><td width="16"></td><td align="right" class="paayeLink"><a href="javascript:show_Savabegh_shomareshasi();">...<small>شماره شاسي</small></a></td><td width="16"></td></tr>
						<tr><td width="12"></td><td align="right"><input type=text name="shomareShasi" value="" size=13 maxsize=10  onKeyPress="shomareShasiKeyPress()"/></td><td width="12"></td></tr>
						<tr height="1"  valign="center"><td width="20"></td><td align="center" bgcolor="#ffeedd"></td><td width="20"></td></tr>


				</table></form>
				</div>
		</td></tr>
			<tr><td><img src="images/menu-bot.jpg"></td></tr>
<%}%>

<!----------------------------------------------------------------------->

<%
	showMenu = false;
    for (Iterator menuIt = menus.iterator(); menuIt.hasNext();) {
        MenuModel mm = (MenuModel) menuIt.next();
        if (mm.getBpName().equals("search")) {
	        	showMenu = true;
	        	break;
	        }
	}
	if (showMenu){
%>
     <tr><td background="images/menu-top.jpg" align="right" height="20" valign="middle">
            &nbsp;&nbsp;<a href="javascript:sivij('5');" id="men5">
            <img src="images/f-on.gif" border="0" id="img5">
						<span class="menuTitle">جستجو</span></a>
					</td></tr>
					<tr><td id="td5"  background="images/menu-top-strip.jpg" align="center">
						<div id="div5" style="display:none;"><form name="tempForm" >
				<table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">


		<tr><td width="16"></td><td align="right" class="paayeLink"><a href="javascript:emdad__Details();">...<small>دستور کار</small></a></td><td width="16"></td></tr>
		<tr><td width="12"></td><td align="right"><input type=text name="emdadId" value="" size=13 maxsize=10  onKeyPress="emdadIdKeyPress()"/></td><td width="12"></td></tr>
		<tr height="1"  valign="center"><td width="20"></td><td align="center" bgcolor="#ffeedd"></td><td width="20"></td></tr>

		<tr><td width="16"></td><td align="right" class="paayeLink"><a href="javascript:rokhdad__Details();">...<small>کد مورد</small></a></td><td width="16"></td></tr>
		<tr><td width="12"></td><td align="right"><input type=text name="rokhdadId" value="" size=13 maxsize=10  onKeyPress="rokhdadIdKeyPress()"/></td><td width="12"></td></tr>
		<tr height="1"  valign="center"><td width="20"></td><td align="center" bgcolor="#ffeedd"></td><td width="20"></td></tr>

		<tr><td width="16"></td><td align="right" class="paayeLink"><a href="javascript:moshtarakSearch();"><small>جستجوي مشتري</small></a></td><td width="16"></td></tr>

				</table></form>
				</div>
	</td></tr>

	<tr><td><img src="images/menu-bot.jpg"></td></tr>

<%}%>
