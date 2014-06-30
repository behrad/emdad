﻿<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<script>
var needRefresh = true;
var win1;
var win2;
	function doRefresh() {
		setTimeout("refresh()", 180000);
	}

	function refresh() {
		if (needRefresh==true) {
			document.location.href="/emdad/l/rokhdad.run?order=<bean:write name="rokhdadForm" property="order" />&sorttype=<bean:write name="rokhdadForm" property="sorttype" />&curpage=<bean:write name="rokhdadForm" property="curpage" />";
		} 
		else {
			needRefresh = true;
			setTimeout("refresh()", 180000);
		}
	}
		
function popupJadid(){
	args = "width=700, height740 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "jadid";
	win1 = window.open("/emdad/com/objectj/emdad/jsp/general.frame.jsp?url=/emdad/c/rokhdad.run", windowTitle,args);
//	win1.creator=document.rokhdadForm.hdnPage;
	win1.creator=window;
	win1.focus();
//	win3.creator=document;
	clearRefresh();
}

function popupEdit(id){
	args = "width=700, height=740 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "edit";
	win2 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/u/rokhdad.run&action_type=edit_by_id&id="+id, windowTitle,args);
//	win2.creator=document.rokhdadForm.hdnPage;
	win2.creator=window;
	win2.focus();
//	win3.creator=document;
	clearRefresh();
}

function closeAll(){
alert("hi");
	if(win1)
		win1.close();
	if(win2)
		win2.close();
}

</script><body onload="doRefresh()" onkeydown="Jadid()" onUnload=""/>


<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/rokhdad">



<table dir="rtl" width="100%" border="0" cellpadding="2" class="listTable" cellspacing="0">
	<tr>
		<td valign="middle" align="right" width="100">
			<a href="javascript:filter_s()"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/filter-apply.jpg" alt="نمايش با فيلتر" width="20" height="20" border="0"></a>
			<a href="javascript:clearfilter_s()"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/filter-remove.jpg" alt="نمايش کامل" width="20" height="20" border="0"></a>
			<a href="javascript:popUpFilter_s('Filter', 700, 500);"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/filter-form.jpg" alt="فيلتر پيشرفته" width="20" height="20" border="0"></a>
            <logic:equal name="entity_access" property="printAccess" value="true">
			    <a href="javascript:report()"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/list-excel.gif" alt="صفحه گسترده" width="20" height="20" border="0"></a>&nbsp;
            </logic:equal>
		</td>
		<td class="text8" valign="middle" align="right" width="100">
			&nbsp;
			<logic:equal name="cur_records" property="isFilter" value="true" >
				[نمايش با فيلتر  ]
			</logic:equal>
			<logic:equal name="cur_records" property="isFilter" value="false" >
				[ ]
			</logic:equal>
		</td>
		<td class="text8" valign="middle" align="right" width="*">
		[  تعداد یافته ها: <bean:write property="totalRecords" name="cur_records"/>]
		</td>
			<td align="left">
						&nbsp;
						<logic:equal name="entity_access" property="deleteAccess" value="true" >
							<input type="button" name="delbut1" value="حذف" onClick="javascript:Delete();" class="emdadButton">
						</logic:equal>
						
						<logic:equal name="entity_access" property="createAccess" value="true" >
							<input type="button" name="newbut1" value="ثبت رخداد جديد" onClick="javascript:popupJadid();" class="emdadButton">
						</logic:equal>
					</td>				
	</tr>
</table>

<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">

	    <!------------------------------------------------>

		<tr>
		<td colspan="16" class="filterFieldCell">
		<span class="generalText">
		آدرس:
		<html:text property="address" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)" size="30" maxlength="80" styleClass="field"/>
		</span>
		</td>
		</tr>

		<!------------------------------------------------>

		<tr>
			<logic:equal name="entity_access" property="deleteAccess" value="true" >
				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td class = "filterFieldCell" width="2%" colspan="2"></td>
				</logic:equal>

				<logic:equal name="entity_access" property="updateAccess" value="false" >
					<td class = "filterFieldCell" width="2%"></td>
				</logic:equal>
			</logic:equal>

			<logic:equal name="entity_access" property="deleteAccess" value="false" >
				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td class = "filterFieldCell" width="2%"></td>
				</logic:equal>
			</logic:equal>

			<td class="filterFieldCell"><html:text property="rokhdadId" size="6" maxlength="6" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}else { return submitenter2(this,event)};"/></td>
			<td class="filterFieldCell"><html:text property="moshtarakId" size="10" maxlength="10" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}else { return submitenter2(this,event)};"/></td>
    		<td class="filterFieldCell"><html:text property="zamaneVaghei" size="10" maxlength="10" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>
            <td class="filterFieldCell">
				<html:select property="shahrId" size="1" onchange="filter();" style="width:100px;" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="shahrList" property="eid" labelProperty="name" />
				</html:select>
			</td>
			<!-- <td class="filterFieldCell"><html:text property="address" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)" size="20" maxlength="80" styleClass="field"/></td> -->
            <!--<td class="filterFieldCell"><html:text property="irad" size="12" maxlength="35" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td> -->
            <td class="filterFieldCell"><html:text property="sabtKonandeh" size="10" maxlength="10" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}else { return submitenter2(this,event)};" /></td>
			<td class="filterFieldCell">
				<html:select property="sabetSayar" size="1" onchange="filter();" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return fastCombo(this)">
					<html:options collection="sabetSayarList" property="id" labelProperty="name" />
				</html:select>
			</td>
			<td class="filterFieldCell"><html:text property="irad" size="35" maxlength="35" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td> 
			<logic:equal name="entity_access" property="allAccess" value="true" >
				<td class="filterFieldCell">
					<html:select property="daftarOstaniId" onchange="filter();" size="1" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return fastCombo(this)" onfocus="emptyFastCombo()">
						<html:options collection="daftarOstaniList" property="eid" labelProperty="name" />
					</html:select>
				</td>
			</logic:equal>
		</tr>

	    <!------------------------------------------------>

		<tr><td colspan="2" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "rokhdadId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "کد مورد"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "eshterakId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره مشتري"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

            <td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "zamaneVaghei"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "زمان تماس"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "shahrName"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شهر"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<!--
			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "address"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "آدرس"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
			-->

			<!--
            <td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "irad"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "ایراد"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
			-->

            <td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "sabtKonandeh"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "پذیرشگر"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "sabetSayar"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "ثابت يا سيار"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "irad"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "ایراد"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
			

			<logic:equal name="entity_access" property="allAccess" value="true" >
				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "nameDaftarOstani"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "دفتراستاني"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>
			</logic:equal>
			
		</tr>

		<!------------------------------------------------>

		<% int i = 0; %>
		<logic:iterate id="value_object" name="value_object_list" >
			<tr class="listRow<%=i%2%>">
				<logic:equal name="entity_access" property="deleteAccess" value="true" >
					<td class = "listRow1Col">
						<html:multibox property="selectedItems" ><bean:write name="value_object" property="id"  /></html:multibox>
					</td>
				</logic:equal>

				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td class = "listRow1Col" align="center">
						<a  href='javascript:popupEdit("<bean:write name="value_object" property="id"  />");'><img src="images/pencil.gif" border="0"></a >
					</td>
				</logic:equal>

				<td class = "listRow1Col">
					<logic:equal name="entity_access" property="readAccess" value="true" >
						<a  href='javascript:read("<bean:write name="value_object" property="id"  />");'>
					</logic:equal>
					<bean:write property="rokhdadId" name="value_object"/>
					<logic:equal name="entity_access" property="readAccess" value="true" >
						</a >
					</logic:equal>
				</td>

				<td class = "listRow1Col"><bean:write property="moshtarakEshterakId" name="value_object"/></td>

                <td class = "listRow1Col"><bean:write property="zamaneVagheiHejri" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="shahrShahrName" name="value_object"/></td>

				<!-- <td class = "listRow1Col"><bean:write property="address" name="value_object"/></td> -->
                <!-- <td class = "listRow1Col"><bean:write property="irad" name="value_object"/></td> -->

                <td class = "listRow1Col"><bean:write property="sabtKonandeh" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="sabetSayarName" name="value_object"/></td>
				
				<td class = "listRow1Col"><bean:write property="irad" name="value_object"/></td> 

				<logic:equal name="entity_access" property="allAccess" value="true" >
					<td class = "listRow1Col"><bean:write property="daftarOstaniName" name="value_object"/></td>
				</logic:equal>
								
            </tr>
			<tr class="listRow<%=i%2%>">
				<td colspan="10" class = "listRow1Col"><bean:write property="address" name="value_object"/></td>
			</tr>
            <%i++;%>
        </logic:iterate>
    </table>
    
	<!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-but.jsp" flush="true" />
    <!------------------------------------------------>

</html:form>

<!------------------------------------------------>

<script>
	function makeNew(){
		popupJadid();
	}
	setForm(document.rokhdadForm);
	setEntity("Rokhdad");
</script>