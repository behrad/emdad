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

<%@ page import ="java.lang.*,com.objectj.emdad.ejb.util.EntityList,com.objectj.emdad.ejb.EntityAccess" %>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:base/>

<!------------------------------------------------>

<body>
	<html:form method="post" action="/r/emdad">
		<center>
			<span class="tilesHeader">انتخاب امداد</span>
		</center>

		<!------------------------------------------------>

		<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
			<tr>
				<td class="filterFindEditCell" colspan="6">
					<a href="javascript:filter()"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/filter-apply.jpg" alt="نمايش با فيلتر" width="20" height="20" border="0"></a>
					&nbsp;
					[کل يافته ها:<bean:write property="totalRecords" name="cur_records"/>]
				</td>
			</tr>

			<!------------------------------------------------>
			
			<tr>
				<td class="filterFieldCell"><html:text property="emdadId" size="7" maxlength="9" onkeypress="return submitenter(this,event)" styleClass="field"/></td>
				<td class="filterFieldCell"><html:text property="rokhdadRokhdadId" size="7" maxlength="10" /></td>
				<td class="filterFieldCell">
					<html:select property="vazeatKhedmatId" size="1">
						<html:options collection="vazeatKhedmatList" property="eid" labelProperty="name" />
					</html:select>
				</td>
				<td class="filterFieldCell"><html:text property="zamanEzam" size="10" maxlength="10" styleClass="field"/></td>
				<td class="filterFieldCell">
					<html:select property="ezamgarId" size="1">
						<html:options collection="ezamgarList" property="eid" labelProperty="name" />
					</html:select>
				</td>
				<td class="filterFieldCell">
					<html:select property="emdadgarId" size="1">
						<html:options collection="emdadgarList" property="eid" labelProperty="name" />
					</html:select>
				</td>

			</tr>

			<!------------------------------------------------>

			<tr><td colspan="2" height="3"></td></tr>

			<!------------------------------------------------>

			<tr class="listTableHeader">
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
					<jsp:setProperty name="cur_records" property="columnName" value= "vazeatKhedmatId"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "وضعيت خدمت"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>

				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "zamanEzam"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "زمان اعزام"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>

				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "ezamgarId"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "اعزامگر"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>
				<td class = "listRow0Col">
					<jsp:setProperty name="cur_records" property="columnName" value= "emdadgarId"
					/><jsp:setProperty name="cur_records" property="columnTitle" value= "امدادگر"
					/><jsp:getProperty name="cur_records" property="sortableColumnString" />
				</td>
			</tr>

			<!------------------------------------------------>

			<% int i = 0; %>
			<logic:iterate id="value_object" name="value_object_list" >
				<tr class="listRow<%=i%2%>">
					<td class = "listRow1Col">
						<a  href='javascript:select("<bean:write name="value_object" property="id" />",<%=i%>);'>
							<span id="emdadId<%=i%>"><bean:write property="emdadId" name="value_object"/></span>
						</a>
					</td>
					<td class = "listRow1Col"><bean:write property="rokhdadRokhdadId" name="value_object"/></td>
					<td class = "listRow1Col"><bean:write property="vazeatKhedmatOnvan" name="value_object"/></td>
					<td class = "listRow1Col"><bean:write property="zamanEzamHejri" name="value_object"/></td>
					<td class = "listRow1Col"><bean:write property="ezamgar" name="value_object"/></td>
					<td class = "listRow1Col"><bean:write property="emdadgar" name="value_object"/></td>

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
		theForm.action="/emdad/s/emdad.run";
		theForm.submit();
	}

	function select(id,index) {
		creator = top.creator;
		if (creator!=null) {
			elem = document.getElementById("emdadId"+index);
			if (creator.dastorkar) {
				creator.dastorkar.value = elem.innerText;
				creator.dastorkar.changed = true;
			}
			if (creator.emdadEmdadId) {
				creator.emdadEmdadId.value = elem.innerText;
				creator.emdadEmdadId.changed = true;
			}
		}
		top.close();
	}

</script>
