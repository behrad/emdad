<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<head>
	<title>انتخاب اجرت</title>

	<META http-equiv=Content-Type content="text/html; charset=UTF-8">
	<meta http-equiv="Expires" content="-1">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">
</head>

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>

<%@ page import ="java.lang.*,com.objectj.emdad.ejb.util.EntityList,com.objectj.emdad.ejb.EntityAccess" %>


<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:base/>

<!------------------------------------------------>

<body>
	<html:form method="post" action="/s/ojrat">
		<center>
			<span class="tilesHeader">انتخاب اجرت</span>
		</center>

		<!------------------------------------------------>

		<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">	
			<tr>
				<td class="filterFieldCell" colspan="2">
					<a href="javascript:filter()"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/filter-apply.jpg" alt="نمايش با فيلتر" width="20" height="20" border="0"></a>
					&nbsp;
					[کل يافته ها:<bean:write property="totalRecords" name="cur_records"/>]
				</td>
			</tr>

			<!------------------------------------------------>

			<tr bgcolor="#000000"></tr>

			<!------------------------------------------------>

			<tr>
				<td class="filterFieldCell"><html:text property="ojratId" size="5" maxlength="5" styleClass="field"/></td>
				<td class="filterFieldCell"><html:text property="onvan" size="20" maxlength="60" onkeypress="return submitenter(this,event)" styleClass="field"/></td>
			</tr>
	
			<!------------------------------------------------>				
	
			<tr><td colspan="2" height="3"></td></tr>
	
			<!------------------------------------------------>
	
			<tr class="listTableHeader">
	
				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "ojratId"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "کد"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>
	
				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "onvan"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "عنوان"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>
	
			</tr>
	
			<!------------------------------------------------>
	
			<% int i = 0; %>
			<logic:iterate id="value_object" name="value_object_list" >
				<tr class="listRow<%=i%2%>">
					<td class = "listRow1Col">
						<a  href='javascript:select2("<bean:write name="value_object" property="ojratId" />", "<bean:write property="onvan" name="value_object"/>");'>
							<span id="ojratId<%=i%>"><bean:write property="ojratId" name="value_object"/></span>
						</a>
					</td>
	
					<td class = "listRow1Col"><bean:write property="onvan" name="value_object"/></td>
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
	
		<table width=100%  dir="rtl">
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

<script>
	setForm(document.ojratForm);
	setEntity("Ojrat");

	function pageKeyPress() {
	  if (window.event.keyCode == 13) {
		changePage(document.all.pageInput.value);
		window.event.keyCode == 0;
	  }
	}
	
	function changePage(page) {
		theForm.curpage.value = page;
	    //theForm.action_type.value = action;
		theForm.action="/emdad/s/ojrat.run";
		theForm.submit();
	}
	// Previous Search Function
	function select(id,index) {
		creator = top.opener;
		if (creator!=null) {		
			elem = document.getElementById("ojratId" + index);
			if (creator.ojratIdCode != null) {
				creator.ojratIdCode.value = elem.innerText;
				creator.ojratIdCode.changed = true;
			}
			creator.ojratId.value = id;
			creator.ojratId.changed = true;
		}
		top.close();
	}
	
	// jozeatKhedmat Search Function
	function select2( id, onvan ) {		
		creator = top.opener;
		if (creator!=null) {		
			theId = creator.document.tasviehForm.cur_item.value;				
			elem = creator.document.getElementById( theId );			
			elem.value = id;
			elem.changed = true;					
			elem.focus();
			elem = creator.document.getElementById( theId+"Onvan" );
			elem.innerHTML = onvan;		
			//creator.focus();
		}
		
	}
	
</script>
