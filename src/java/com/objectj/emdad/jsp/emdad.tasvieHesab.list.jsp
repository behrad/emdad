﻿<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<script>
	function emdadDetails (id){
		args = "width=500, height=500 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "Emdad";
		win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/emdad.run&action_type=specific,emdadShow&id="+id, windowTitle,args);
		win3.creator=document;
	}

	function rokhdadDetails (id){
		args = "width=500, height=500 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "Emdad";
		win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/rokhdad.run&action_type=specific,rokhdadShow&id="+id, windowTitle,args);
		win3.creator=document;
	}

	function moshtariDetails (id){
		args = "width=500, height=500 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "Emdad";
		win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/moshtarak.run&action_type=specific,moshtarakShow&id="+id, windowTitle,args);
		win3.creator=document;
	}	
</script>


<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>

<%@ page import ="java.lang.*,com.objectj.emdad.ejb.util.EntityList,com.objectj.emdad.ejb.EntityAccess" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/fast-combo.jsp" flush="true" />
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:base/>

<!------------------------------------------------>

<body>
	<html:form method="post" action="/l/emdad">

		<!------------------------------------------------>

		<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
			<tr>
				<logic:equal name="entity_access" property="allAccess" value="true" >
					<td class="filterFindEditCell" colspan="8">
				</logic:equal>

				<logic:equal name="entity_access" property="allAccess" value="false" >
					<td class="filterFindEditCell" colspan="8">
				</logic:equal>

					<a href="javascript:filter()"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/filter-apply.gif" alt="نمايش با فيلتر" width="20" height="20" border="0"></a>
        			<a href="javascript:clearfilter()"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/filter-remove.gif" alt="نمايش کامل" width="20" height="20" border="0"></a>
					&nbsp;
					[کل يافته ها:<bean:write property="totalRecords" name="cur_records"/>]
				</td>
			</tr>

			<!------------------------------------------------>

			<tr>
				<td class="filterFieldCell"></td>
				<td class="filterFieldCell"><html:text property="emdadId" size="7" maxlength="9" onkeypress="return submitenter(this,event)" styleClass="field"/></td>
				<td class="filterFieldCell"><html:text property="rokhdadRokhdadId" size="7" maxlength="10" styleClass="field" /></td>
				<td class="filterFieldCell"><html:text property="zamanEzam" size="10" maxlength="10" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>
				<td class="filterFieldCell"><html:text property="eshterakId" size="10" maxlength="10" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/></td>
				<td class="filterFieldCell">
					<html:select property="noeEmdad" size="1"  style="width:150px;"  onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
						<html:options collection="noeEmdadList" property="id" labelProperty="name" />
					</html:select>
				</td>
				<td class="filterFieldCell">
					<%! String action_type = "specific,tasvieHesabNamayandegiList"; %>
					<logic:equal name="noeTasvieh" value="emdadgar">
						<% action_type = "specific,tasvieHesabEmdadgarList"; %>
					<html:select property="emdadgarId" size="1"  style="width:150px;"  onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
						<html:options collection="emdadgarList" property="eid" labelProperty="name" />
					</html:select>
					<html:hidden property="namayandegiId"/>
					</logic:equal>
					<logic:equal name="noeTasvieh" value="namayandegi">
                    <html:text property="namayandegiId" size="17" maxlength="20" styleClass="field" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)"/>
					<html:hidden property="emdadgarId"/>
					</logic:equal>
				</td>
				<logic:equal name="entity_access" property="allAccess" value="true" >
					<td class="filterFieldCell">
						<html:select property="daftarOstaniId" size="1"  style="width:150px;" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
							<html:options collection="daftarOstaniList" property="eid" labelProperty="name" />
						</html:select>
					</td>
				</logic:equal>
			</tr>

			<!------------------------------------------------>

			<tr><td colspan="2" height="3">
			<input type="hidden" name="noeTasvieh"  value="<bean:write name="noeTasvieh" />" />
            </td></tr>

			<!------------------------------------------------>

			<tr class="listTableHeader">
				<td class = "listRow0Col">
					<span class="textW">جزئيات</span>
				</td>
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

				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "zamanEzam"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "زمان اعزام"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>

				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "eshterakId"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره مشتري"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>

				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "noeEmdad"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "نوع امداد"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>

				<td class = "listRow0Col">
					<logic:equal name="noeTasvieh" value="emdadgar">
						<jsp:setProperty name="cur_records" property="columnName" value= "emdadgarId"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "امدادگر"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</logic:equal>
					<logic:equal name="noeTasvieh" value="namayandegi">
						<jsp:setProperty name="cur_records" property="columnName" value= "namayandegiId"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "نمايندگي"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />					
					</logic:equal>					
				</td>

				<logic:equal name="entity_access" property="allAccess" value="true" >
					<td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "daftarOstaniId"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "دفتراستاني"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</td>
				</logic:equal>
			</tr>

			<!------------------------------------------------>

			<% int i = 0; %>
			<logic:iterate id="value_object" name="value_object_list" >
				<tr class="listRow<%=i%2%>">
					<td class = "listRow1Col">
						<a  href='javascript:viewJozeatKhedmatList("<bean:write name="value_object" property="emdadId" />");'>
							<img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/details.gif" border="0">
						</a>
					</td>

					<td class = "listRow1Col">
						<a  href='javascript:emdadDetails("<bean:write name="value_object" property="id" />");'>
							<bean:write property="emdadId" name="value_object"/>
						</a>
					</td>
					<td class = "listRow1Col">
						<a  href='javascript:rokhdadDetails("<bean:write name="value_object" property="rokhdadRokhdadId" />");'>
							<bean:write property="rokhdadRokhdadId" name="value_object"/>
						</a>
					</td>
					<td class = "listRow1Col"><bean:write property="zamanEzamHejri" name="value_object"/></td>
					<td class = "listRow1Col">
						<a  href='javascript:moshtariDetails("<bean:write name="value_object" property="eshterakId" />");'>
							<bean:write property="eshterakId" name="value_object"/>
						</a>
					</td>
					<td class = "listRow1Col"><bean:write property="noeEmdadName" name="value_object"/></td>
					<td class = "listRow1Col"><bean:write property="emdadgar" name="value_object"/><bean:write property="namayandegiName" name="value_object"/></td>
					<logic:equal name="entity_access" property="allAccess" value="true" >
						<td class = "listRow1Col"><bean:write property="daftarOstaniName" name="value_object"/></td>
					</logic:equal>
				</tr>
				<%i++;%>
			</logic:iterate>
		</table>

		<!------------------------------------------------>
		<html:hidden property="action_type"/>
		<html:hidden property="curpage" />
		<html:hidden property="order"/>
		<html:hidden property="sorttype" />
		<html:hidden property="id"/>
		<!------------------------------------------------>

		<table dir="rtl" width=100%>
			<tr class="filterFindCell">
				<td background="/emdad/com/objectj/resources/jsp/tiles/emdad/images/filter-bk.jpg">
					<table border="0" cellspacing="0" cellpadding="0" align="center" class="generalText">
						<tr align="center"  class="filterFindCell">

							<!------------------------------>

							<td width="20"><a href='javascript:changePage(1)'><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/first.gif" alt="صفحه اول" border="0"></a></td>

							<!------------------------------>

							<logic:greaterThan name="cur_records" property="curPage" value="1" >
								<td width="20"><a href='javascript:changePage(<bean:write property="prevPage" name="cur_records"/>)'><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/previous.gif" alt="صفحه قبلي" border="0"></a></td>
							</logic:greaterThan>

							<!------------------------------>

							<td>
								<a href="javascript:refreshPage()">صفحه</a>
								<input id="pageInput" name="tmpPage" value='<bean:write property="curPage" name="cur_records" />' size="2" maxlength="5" class="field" onKeyPress="pageKeyPress()"/>
							</td>

							<!------------------------------>

							<logic:equal name="cur_records" property="hasNextPage" value="true" >
								<td width="20"><a href='javascript:changePage(<bean:write property="nextPage" name="cur_records"/>)'><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/next.gif" alt="صفحه بعد" border="0"></a></td>
							</logic:equal>

							<!------------------------------>

							<td width="20" align="right"><a href='javascript:changePage(<bean:write property="totalPages" name="cur_records"/>)'><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/last.gif" alt="صفحه آخر" border="0"></a></td>

							<!------------------------------>

						</tr>
					</table>
				</td>
			</tr>
		</table>
	</html:form>
</body>

<!------------------------------------------------>

<script>
	setForm(document.emdadForm);
	setEntity("Emdad");

	function pageKeyPress() {
	  if (window.event.keyCode == 13) {
		changePage(document.all.pageInput.value);
		window.event.keyCode == 0;
	  }
	}

	function changePage(page) {
		theForm.curpage.value = page;
		theForm.action_type.value = "<%=action_type%>";
		theForm.action="/emdad/s/emdad.run";
		theForm.submit();
	}

	function sort(type){
	    sort2(type);
	}
	function filter(){
	    filter_s();
	}

</script>
