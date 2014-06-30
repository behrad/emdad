<%@ page contentType="text/html; charset=UTF-8" import="com.objectj.emdad.ejb.*" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<script>
	function readById( id ) {
		document.location.href="/emdad/r/serviceDorei.run?action_type=read_by_id&id=" + id;
	}
	
	function tands() {
		document.serviceDoreiForm.action_type.value = "specific,taeed";
		document.serviceDoreiForm.action="/emdad/s/serviceDorei.run";
    	document.serviceDoreiForm.submit();
	}
</script>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/r/serviceDorei">
	<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
		<tr>
			<td><a href="/emdad/com/objectj/emdad/jsp/serviceDorei.requpload.jsp" target="_blank">دريافت فايل XLS</a>
				&nbsp;&nbsp;&nbsp;
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/help.jsp" flush="true">
   <jsp:param name="help_url" value="serviceDorei.html" />	
</jsp:include>
			</td>
		</tr>
	</table>	
    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-filter.jsp" flush="true" />
    <!------------------------------------------------>

	<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">

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

			<td class="filterFieldCell"><html:text property="namayandegiId" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)" size="12" maxlength="10"  styleClass="field" /></td>
			<td class="filterFieldCell"><input type="text" name="tarikh" size="7" class="field" disabled/></td>
			<td class="filterFieldCell"><html:text property="moshtarakId" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)" size="12" maxlength="10"  styleClass="field" /></td>
			<td class="filterFieldCell"><input type="text" name="shomareShasi" onKeyPress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)" size="12" maxlength="12" class="field"/></td>
			<td class="filterFieldCell"><html:text property="kilometerKarkard" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)" size="5" maxlength="8" styleClass="field"/></td>
			<td class="filterFieldCell"><html:select property="noeServiceDorei" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return fastCombo(this)" onfocus="emptyFastCombo()">
											<html:options collection="noeServiceDoreiList" property="eid" labelProperty="name" />
										</html:select>
			</td>
			<td class="filterFieldCell"><html:text property="hazineh" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return submitenter2(this,event)" size="6" maxlength="9" styleClass="field"/></td>
			<td class="filterFieldCell">
						<select name="taeedHesabdar" onkeypress="javascript:if (window.event.keyCode == 13) {filter();}return fastCombo(this)" >
							<option value="" >---</option>
							<option value="1" >تاييد شده</option>
							<option value="2" >تاييد نشده</option>
						</select>
			</td>
		</tr>

	    <!------------------------------------------------>				

		<tr><td colspan="2" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
			<logic:equal name="entity_access" property="deleteAccess" value="true" ><td class = "listRow0Col" width="2%">&nbsp;</td></logic:equal>
			<logic:equal name="entity_access" property="updateAccess" value="true" ><td class = "listRow0Col" width="4%" align="center"><span class="textW">اصلاح</span></td></logic:equal>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "namayandegiId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "نمايندگي"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "tarikh"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "تاريخ"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "moshtarakId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "مشتري"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
			
			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "shomareShasi"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره شاسي"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "kilometerKarkard"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "کيلومتر کارکرد"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "noeServiceDorei"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "نوع سرويس دوره اي"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col"> 
				<jsp:setProperty name="cur_records" property="columnName" value= "hazineh"
				/><jsp:setProperty name="cur_records" property="columnTitle" value="هزينه"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
			
			<td class = "listRow0Col"> 
				<jsp:setProperty name="cur_records" property="columnName" value= "taeedHesabdar"
				/><jsp:setProperty name="cur_records" property="columnTitle" value="وضعيت"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
			
		</tr>

		<!------------------------------------------------>

		<% int i = 0; %>
		<logic:iterate id="value_object" name="value_object_list" >
			<%
				if ( ((ServiceDoreiList)value_object).getTaeedHesabdar() == null )
					((ServiceDoreiList)value_object).setTaeedHesabdar( new Integer(2) );
			%>
			<tr class="listRow<%=i%2%>">
				<logic:equal name="entity_access" property="deleteAccess" value="true" >
					<td class = "listRow1Col">
						<logic:equal name="value_object" property="taeedHesabdar" value="2" >						
							<html:multibox property="selectedItems" ><bean:write name="value_object" property="id"  /></html:multibox>						
						</logic:equal>
					</td>
				</logic:equal>

				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td class = "listRow1Col" align="center">
						<logic:equal name="value_object" property="taeedHesabdar" value="2" >													
							<a  href='javascript:edit("<bean:write name="value_object" property="id"  />");'><img src="images/pencil.gif" border="0"></a >
						</logic:equal>
					</td>
				</logic:equal>

				<td class = "listRow1Col"><a href="javascript:readById('<bean:write name="value_object" property="id"/>');"><bean:write property="namayandegiId" name="value_object"/></a></td>

				<td class = "listRow1Col"><bean:write property="tarikhHejri" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="eshterakId" name="value_object"/></td>
				
				<td class = "listRow1Col"><bean:write property="shomareShasi" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="kilometerKarkard" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="noeServiceDoreiName" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="hazineh" name="value_object"/></td>
				
				<td class = "listRow1Col">
					<% String taeeded = "<font color='#FF0000'>تاييد نشده</font>"; %>
					<logic:equal name="value_object" property="taeedHesabdar" value="1" >
						<% taeeded = "تاييد شده"; %>
					</logic:equal>
					<%= taeeded %>
				</td>
            </tr>
            <%i++;%>
        </logic:iterate>			
    </table>
	
	<% String additional = "<logic:equal name=\"entity_access\" property=\"updateAccess\" value=\"true\" ><input type=\"button\" name=\"taeed\" value=\" تاييد \" class=\"emdadButton\" onClick=\"javascript:tands();\"/></logic:equal>";
	   request.setAttribute( "additional", additional ); %>
    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-but.jsp" flush="true"/>		
    <!------------------------------------------------>
	<html:hidden property="noeServiceDorei" name="value_object"/>
</html:form>

<!------------------------------------------------>

<script>
	setForm(document.serviceDoreiForm);
	setEntity("ServiceDorei");
</script>
