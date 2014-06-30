<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>
<%@ page import="java.util.*" %>

<html:base/>
<script>
var needRefresh = true;

function readDastoorKar(id){
	args = "width=600, height=600 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "read";
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/emdad.run&action_type=specific,emdadShow&id="+id, windowTitle,args);
//	win3.creator=document.emdadForm.hdnPage;
	win3.creator=window;
	win3.focus();
//	win3.creator=document;
	clearRefresh();
}

    function mostanadatRokhdadList(dastorkar) {
        document.getElementById("mostanadatRokhdadFrame").src="/emdad/s/mostanadatRokhdad.run?action_type=specific,tasvieHesabList&id=" + dastorkar;
    }


function createPeigiri(s1, s2) {
	args = "width=850, height=280 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "Create";
	win3 = window.open("/emdad/s/peigiriEzamgar.run?action_type=specific,peigiriEdit&emdadId="+s1+"&emdadEmdadId="+s2, windowTitle,args);
//	win3.creator=document.emdadForm.hdnPage;
	win3.creator=window;
	win3.focus();
//	win3.creator=document.emdadForm;
}

function popupEdit(id){
	args = "width=600, height=600 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "edit";
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/u/emdad.run&action_type=edit_by_id&id="+id, windowTitle,args);
//	win3.creator=document.emdadForm.hdnPage;
	win3.creator=window;
	win3.focus();
//	win3.creator=document;
	clearRefresh();
}


function shoro(id){
	args = "width=500, height=500 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "Shoro";
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/emdad.run&action_type=specific,shoro&id="+id, windowTitle,args);
//	win3.creator=document.emdadForm.hdnPage;
	win3.creator=window;
	win3.focus();
//	win3.creator=document;
	clearRefresh();
}

function doRefresh() {
	setTimeout("refresh()", 1800000);
}

function refresh() {
	if (needRefresh==true) {
		document.emdadForm.hdnPage.click();
		//document.location.href = "/emdad/s/emdad.run?action_type=specific,forceNoeEmdad&noeEmdad=<bean:write name="forceNoeEmdad" />&order=<bean:write name="emdadForm" property="order" />&sorttype=<bean:write name="emdadForm" property="sorttype" />&curpage=<bean:write name="emdadForm" property="curpage" />";
	} else {
		needRefresh = true;
		setTimeout("refresh()", 1800000);
	}
}


function payan(id){
	args = "width=500, height=720 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "Payan";
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/emdad.run&action_type=specific,payan&id="+id, windowTitle,args);
//	win3.creator=document.emdadForm.hdnPage;
	win3.creator=window;
	win3.focus();
//	win3.creator=document;
	clearRefresh();
}

function adi(){
	args = "width=500, height=500 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "";//"رخدادهای بالينی اقدام نشده";
//	win3 = window.open("/emdad/s/rokhdad.run?action_type=specific,rokhdademdadlistAdi", windowTitle,args);
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.frame.jsp?url=/emdad/s/rokhdad.run?action_type=specific,rokhdademdadlistAdi", windowTitle,args);
//	win3.creator=document.emdadForm.hdnPage;
	win3.creator=window;
	win3.focus();
//	win3.creator=document;
	clearRefresh();
}

function vijeh(){
	args = "width=500, height=500 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "";//"رخدادهای تعميری اقدام نشده";
//	win3 = window.open("/emdad/s/rokhdad.run?action_type=specific,rokhdademdadlistVijeh", windowTitle,args);
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.frame.jsp?url=/emdad/s/rokhdad.run?action_type=specific,rokhdademdadlistVijeh", windowTitle,args);
//	win3.creator=document.emdadForm.hdnPage;
	win3.creator=window;
	win3.focus();
//	win3.creator=document;
}

function myParentRefresh(error){}
function myRefresh(){
	document.emdadForm.hdnPage.click();
	window.focus();
} 


</script>
<style>
.myfield {
	background-color: #FFFFAA;
	font-family: Tahoma, Arial;
	font-size: 9pt;
	border: thin solid #666699;
}
</style>
<body onload="doRefresh()" />

<logic:equal name="emdadForm" property="forceNoeService" value="adi" >
    <!-- iframe src="/emdad/s/rokhdad.run?action_type=specific,rokhdademdadlistAdi" width="100%" height="100%" align="middle" frameborder="0" >< / iframe-->
    <a href="javascript:adi()" >رخدادهاي اقدام نشده</a>
</logic:equal>

<logic:equal name="emdadForm" property="forceNoeService" value="vijeh" >
    <!-- iframe src="/emdad/s/rokhdad.run?action_type=specific,rokhdademdadlistVijeh" width="100%" height="100%" align="middle" frameborder="0" >< / iframe-->
    <table width="100%">
		<td><a href="javascript:vijeh()" >رخدادهاي اقدام نشده</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td align="left"><a href="/emdad/com/objectj/emdad/jsp/rokhdad.requpload.jsp" target="blank">دريافت فايل XLS</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	</table>
</logic:equal>
<br>

<center>
	<logic:equal name="forceNoeEmdad" value="1">
		<span class="tilesHeader">فهرست امدادهاي باليني</span>
	</logic:equal>

	<logic:equal name="forceNoeEmdad" value="2">
		<span class="tilesHeader">فهرست امدادهاي تعميري</span>
	</logic:equal>

	<logic:equal name="forceNoeEmdad" value="3">
		<span class="tilesHeader">فهرست امدادهاي پشتيباني</span>
	</logic:equal>
	<logic:equal name="forceNoeEmdad" value="0">
		<span class="tilesHeader">فهرست ا مدادها</span>
	</logic:equal>
</center>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/fast-combo.jsp" flush="true" />
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/emdad">

    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-filter.jsp" flush="true" />
    <!------------------------------------------------>

	<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">

		<!------------------------------------------------>
		<tr>
			<td class = "filterFieldCell" colspan="8">&nbsp;</td>
			<td class = "filterFieldCell" colspan="18">ايراد:<html:text property="irad" size="40" maxlength="20" styleClass="myfield" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>
		</tr>
		<tr>
			<td class = "filterFieldCell" width="2%" colspan="4">آدرس:<html:text property="address" size="20" maxlength="20" styleClass="myfield" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>

			<td class="filterFieldCell"><html:text property="emdadId" size="7" maxlength="9" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}" styleClass="field"/></td>

			<td class="filterFieldCell"><html:text property="rokhdadRokhdadId" size="7" maxlength="9" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}"/></td>

			<!-- <td class="filterFieldCell"><html:text property="address" size="15" maxlength="20" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td> -->

			<td class="filterFieldCell"><html:text property="shomarePelak" size="12" maxlength="35" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>

			<td class="filterFieldCell"><html:text property="zamanEzam" size="15" maxlength="10" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}"/></td>

			<td class="filterFieldCell">
				<html:select property="ezamgarId" size="1" style="width:100px;" onchange="filter();" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="ezamgarList" property="eid" labelProperty="name" />
				</html:select>
			</td>
			<td class="filterFieldCell"><html:text property="namayandegiId" size="17" maxlength="20" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>
			<td class="filterFieldCell"><html:text property="nameEmdadgar" size="15" maxlength="20" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>

        	<!--logic : equal name="forceNoeEmdad" value="1" -->
			<!--	<td class="filterFieldCell">&nbsp;</td>  -->
					<!-- html : select property="emdadgarId" size="1" style="width:150px;" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
						< html : options collection="emdadgarList" property="eid" labelProperty="name" />
					</ html:select>
				</td>
            <!-- /logic : equal >

        	< logic : notEqual name="forceNoeEmdad" value="1">
				<td class="filterFieldCell">
					< html : select property="namayandegiId" size="1" style="width:150px;" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
						< html : options collection="namayandegiList" property="eid" labelProperty="name" />
					</ html : select>
				</td>
            </ logic : notEqual -->

        	<logic:equal name="forceNoeEmdad" value="0">
                <td class="filterFieldCell">
                    <html:select property="noeEmdad" size="1" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return fastCombo(this)" onfocus="emptyFastCombo()" styleClass="generalText">
                        <html:options collection="noeEmdadList" property="id" labelProperty="name" />
                    </html:select>
                </td>
            </logic:equal>

        	<logic:notEqual name="forceNoeEmdad" value="0">
			<input type="hidden" name="noeEmdad"  value="<bean:write name="noeEmdad" />" />
            </logic:notEqual>

		</tr>

	    <!------------------------------------------------>

		<tr><td colspan="2" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
            <td class = "listRow0Col" width="4%" align="center"><span class="textW">مستندات رخداد</span></td>
            <td class = "listRow0Col" width="4%" align="center"><span class="textW">اصلاح</span></td>
			<td class = "listRow0Col" width="4%" align="center"><span class="textW">پي گيري</span></td>
			<td class = "listRow0Col" width="4%" align="center"><span class="textW"></span></td>


			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "emdadId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "دستورکار"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "rokhdadId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "کد مورد"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<!--
			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "onvan"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "آدرس"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
			-->

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "shomarePelak"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره پلاک"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "zamanEzam"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "زمان اعزام"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "nameShakhs"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "اعزامگر"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "namayandegiId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "نمايندگي و عامليت"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
            </td>
			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "nameEmdadgar"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "امدادگر "
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
            </td>

			<!--td class = "listRow0Col">
				< jsp : setProperty name="cur_records" property="columnName" value= "nameEmdadgar"
				/>< jsp : setProperty name="cur_records" property="columnTitle" value= "امدادگر / نمايندگي"
				/>< js p : getProperty name="cur_records" property="sortableColumnString" />
			</td-->

        	<logic:equal name="forceNoeEmdad" value="0">
                <td class = "listRow0Col">
                    <jsp:setProperty name="cur_records" property="columnName" value= "noeEmdad"
                    /><jsp:setProperty name="cur_records" property="columnTitle" value= "نوع امداد"
                    /><jsp:getProperty name="cur_records" property="sortableColumnString" />
                </td>
            </logic:equal>
		</tr>

		<!------------------------------------------------>
		<% int i = 0; %>
		<logic:iterate id="value_object" name="value_object_list" >
			<tr class="listRow<%=i%2%>">
	
				<td class = "listRow1Col" align="center">
					<a  href='javascript:mostanadatRokhdadList("<bean:write property="emdadId" name="value_object"/>")'>
						<img src="images/pencil.gif" border="0">
					</a >
				</td>
				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td class = "listRow1Col" align="center">
						<a  href='javascript:popupEdit("<bean:write name="value_object" property="id"  />");'><img src="images/pencil.gif" border="0" ></a >
					</td>
				</logic:equal>
				 <td class = "listRow1Col">
						<a  href='javascript:createPeigiri("<bean:write name="value_object" property="id" />", "<bean:write name="value_object" property="emdadId"  />");'>
							<img src="images/peygiri.gif" border="0">
						</a >
				</td>

				<td class = "listRow1Col" align="center">
					<logic:equal name="value_object" property="vazeatKonuni" value="0" >
							<a  href='javascript:shoro("<bean:write name="value_object" property="id"  />");'><img src="images/next.gif" border="0"></a >
					</logic:equal>

					<logic:equal name="value_object" property="vazeatDakheli" value="0">
						<logic:equal name="value_object" property="vazeatKonuni" value="1" >
								<a  href='javascript:payan("<bean:write name="value_object" property="id"  />");'><img src="images/stop.gif" border="0"></a >
						</logic:equal>
					</logic:equal>
				</td>

				<td class = "listRow1Col">
					<a  href='javascript:readDastoorKar("<bean:write name="value_object" property="id"  />");'>
                    	<bean:write property="emdadId" name="value_object"/>
					</a>
                </td>

				<td class = "listRow1Col"><bean:write property="rokhdadRokhdadId" name="value_object"/></td>
				<!-- <td class = "listRow1Col"><bean:write property="address" name="value_object"/></td> -->
				<td class = "listRow1Col"><bean:write property="shomarePelak" name="value_object"/></td>
				<td class = "listRow1Col"><bean:write property="zamanEzamHejri" name="value_object"/> </td>
				<td class = "listRow1Col"><bean:write property="ezamgar" name="value_object"/></td>
                <td class = "listRow1Col"><bean:write property="namayandegiName" name="value_object"/></td>
				<td class = "listRow1Col"><bean:write property="emdadgar" name="value_object"/></td>
            	<logic:equal name="forceNoeEmdad" value="0">
				    <td class = "listRow1Col"><bean:write property="noeEmdadName" name="value_object"/></td>
                </logic:equal>
            </tr>
			<tr class="listRow<%=i%2%>">
				<td colspan="8" class = "listRow1Col"><bean:write property="address" name="value_object"/></td>
				<td colspan="4" class = "listRow1Col">ايراد:<bean:write property="irad" name="value_object"/></td>
			</tr>
            <%i++;%>
        </logic:iterate>
    </table>

    <!------------------------------------------------>
<script language="JavaScript" type="text/JavaScript">
function pageKeyPress() {
  if (window.event.keyCode == 13) {
  	changePage(document.all.pageInput.value);
	window.event.keyCode == 0;
  }
}
</script>

<table align="right" dir="rtl" border="0" cellspacing="0" class="generalText" width="100%">
	<html:hidden property="order"/>
	<html:hidden property="action_type"/>
	<html:hidden property="curpage" />
	<html:hidden property="sorttype" />
	<html:hidden property="id"/>
	<!----------------------------------------------------------->

	<tr>
		<td background="../home/emdad/uploads/deploy2/emdad.ear/emdad-web.war/com/objectj/emdad/jsp/images/filter-bk.jpg">
			<table border="0" cellspacing="0" cellpadding="0" align="center" class="generalText">
				<tr align="center">

					<!------------------------------>

					<td width="20"><a href='javascript:changePage(1)'><img src="images/first.gif" alt="صفحه اول" border="0"></a></td>

					<!------------------------------>

					<logic:greaterThan name="cur_records" property="curPage" value="1" >
						<td width="20"><a href='javascript:changePage(<bean:write property="prevPage" name="cur_records"/>)'><img src="images/previous.gif" alt="صفحه قبلي" border="0"></a></td>
					</logic:greaterThan>

					<!------------------------------>


					<td>
						<a href="javascript:refreshPage()">صفحه</a>
                        <input name="hdnPage" type="hidden" onclick="refreshPage()">
						
						<input id="pageInput" name="tmpPage" value="<bean:write property="curPage" name="cur_records"/>" size="2" maxlength="5" class="field" onKeyPress="pageKeyPress()">
					</td>

					<!------------------------------>

					<logic:equal name="cur_records" property="hasNextPage" value="true" >
						<td width="20"><a href='javascript:changePage(<bean:write property="nextPage" name="cur_records"/>)'><img src="images/next.gif" alt="صفحه بعد" border="0"></a></td>
					</logic:equal>

					<!------------------------------>

					<td width="20" align="right"><a href='javascript:changePage(<bean:write property="totalPages" name="cur_records"/>)'><img src="images/last.gif" alt="صفحه آخر" border="0"></a></td>

					<!------------------------------>

				</tr>
			</table>
		</td>
	</tr>
</table>    <!------------------------------------------------>

<br><br>
<span class="tilesHeader">
	 مستندات رخداد  - کد مورد <span id="rokhdadId2" class="info"> ... </span>
</span>
<div style="display:inline; height:150px;layer-background-color: #0099CC;border: solid 1px #996633;" id="mostanadatRokhdadList">
	<iframe src="about:blank" width="100%" height="100%" align="middle" frameborder="0" id="mostanadatRokhdadFrame"></iframe>
</div>

</html:form>

<!------------------------------------------------>

<script>
	setForm(document.emdadForm);
	setEntity("Emdad");
	setHelpURL("/emdad/com/objectj/resources/jsp/help/emdad.list.help.html");
</script>
