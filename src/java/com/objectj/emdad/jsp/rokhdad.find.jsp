<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %><HEAD>

<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>

<!--jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" /-->
<%@ page import ="java.lang.*,com.objectj.emdad.ejb.util.EntityList,com.objectj.emdad.ejb.EntityAccess" %>

</head>

<!------------------------------------------------>
<html:base/>

<body>
	<html:form method="post" action="/r/rokhdad">

		<center>
			<span class="tilesHeader">انتخاب رخداد</span>
		</center>

		<!------------------------------------------------>

		<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
			<tr>
				<logic:equal name="entity_access" property="allAccess" value="true" >
				<td class="filterFieldCell" colspan="6">
				</logic:equal>
				<logic:equal name="entity_access" property="allAccess" value="false" >
				<td class="filterFieldCell" colspan="5">
				</logic:equal>
					<a href="javascript:filter()"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/filter-apply.jpg" alt="نمايش با فيلتر" width="20" height="20" border="0"></a>
					&nbsp;
					[کل يافته ها:<bean:write property="totalRecords" name="cur_records"/>]
				</td>
			</tr>

			<!------------------------------------------------>

			<tr bgcolor="#000000"></tr>

			<!------------------------------------------------>

			<tr>
				<td class="filterFieldCell"><html:text property="rokhdadId" size="3" maxlength="5" styleClass="field"/></td>
				<td class="filterFieldCell"></td>
				<td class="filterFieldCell">
					<html:select property="shahrId" size="1">
						<html:options collection="shahrList" property="id" labelProperty="name" />
					</html:select>
				</td>
				<td class="filterFieldCell"><html:text property="address" size="20" maxlength="80" onkeypress="return submitenter(this,event)" styleClass="field"/></td>				
				<td class="filterFieldCell">
					<html:select property="sabetSayar" size="1">
						<html:options collection="sabetSayarList" property="id" labelProperty="name" />
					</html:select>
				</td>
				<logic:equal name="entity_access" property="allAccess" value="true" >
					<td class="filterFieldCell">
						<html:select property="daftarOstaniId" size="1">
							<html:options collection="daftarOstaniList" property="eid" labelProperty="name" />
						</html:select>
					</td>
				</logic:equal>
			</tr>
		

			<!------------------------------------------------>

			<tr><td colspan="2" height="3"></td></tr>

			<!------------------------------------------------>

			<tr class="listTableHeader">
				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "rokhdadId"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "کد مورد"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>
	
	
				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "moshtarakId"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره مشتري"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>
	
				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "shahrId"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "شهر"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>
	
				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "address"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "آدرس"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>
	
				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "sabetSayar"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "ثابت يا سيار"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>
	
				<logic:equal name="entity_access" property="allAccess" value="true" >
					<td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "daftarOstaniName"
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
						<a  href='javascript:select("<bean:write name="value_object" property="rokhdadId" />",<%=i%>);'>
							 <span id="rokhdadId<%=i%>"><bean:write property="rokhdadId" name="value_object"/></span>
						</a>
					</td>
					<td class = "listRow1Col"><bean:write property="moshtarakEshterakId" name="value_object"/></td>
					<td class = "listRow1Col"><bean:write property="shahrShahrName" name="value_object"/></td>
					<td class = "listRow1Col"><bean:write property="address" name="value_object"/></td>
					<td class = "listRow1Col"><bean:write property="sabetSayarName" name="value_object"/></td>
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
		
		<table width=100% dir="rtl">
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
								<input id="pageInput" name="tmpPage" value="<bean:write property="curPage" name="cur_records"/>" size="2" maxlength="5" class="field" onKeyPress="pageKeyPress()">
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

<script language="JavaScript" type="text/JavaScript">
	function pageKeyPress() {
	  if (window.event.keyCode == 13) {
		changePage(document.all.pageInput.value);
		window.event.keyCode == 0;
	  }
	}

	setForm(document.rokhdadForm);
	setEntity("Rokhdad");

	function changePage(page) {
		theForm.curpage.value = page;
	    //theForm.action_type.value = action;
		s="1";

		theForm.action="/emdad/s/rokhdad.run?action_type=specific,find%26eghdam="+s;
		theForm.submit();
	}

	function pElem(elemId,index) {
		elem = document.getElementById(elemId+index);
		if (elem) {
			exst = eval("creator."+elemId);
			if (exst!=null) {
				eval("creator."+elemId+".value= elem.innerText");
			}
		}
	}

	function select(id,index) {
		creator = top.creator;
		if (creator!=null) {
			creator.rokhdadRokhdadId.value = id;
			creator.rokhdadRokhdadId.changed = true;
			pElem("rokhdadId" ,index);
			creator.rokhdadId.changed = true;
		}
		top.close();
	}
</script>

