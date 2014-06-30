<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %><body onkeydown="Jadid()"/>
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/l/noeKhodro">

    <!------------------------------------------------>
    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-filter.jsp" flush="true" />
    <!------------------------------------------------>

	

<html:base/>
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

			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="noeKhodroId" size="3" maxlength="5" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="onvan" size="20" maxlength="30" onkeypress="return ( submitenter2(this,event) && doFilterByEnter() );" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="guarantee" size="3" maxlength="5" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text onkeypress="doFilterByEnter();" property="guaranteeDistance" size="3" maxlength="5" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="khodroCode" size="3" maxlength="5" onkeypress="return ( submitenter2(this,event) && doFilterByEnter() );" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="noeKhodroCode" size="3" maxlength="5" onkeypress="return ( submitenter2(this,event) && doFilterByEnter() );" styleClass="field"/></td>
			<td class="filterFieldCell">
				<html:select property="vijeh" size="1">
					<html:options collection="isVijehList" property="id" labelProperty="name" />
				</html:select>
			</td>
			<td class="filterFieldCell">
				<html:select property="khodrosazId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="khodrosazList" property="eid" labelProperty="name" />
				</html:select>
			</td>
		</tr>

	    <!------------------------------------------------>				

		<tr><td colspan="2" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "noeKhodroId"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "شناسه"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "onvan"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "عنوان"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "guarantee"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "ضمانت"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "guaranteeDistance"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "مسافت ضمانت"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "khodroCode"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "کد خودروي خودروساز"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "noeKhodroCode"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "کد نوع خودرو"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "vijeh"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "مشمول خدمات ويژه"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>

			<td class = "listRow0Col">
				<jsp:setProperty name="cur_records" property="columnName" value= "khodrosazName"
				/><jsp:setProperty name="cur_records" property="columnTitle" value= "خودروساز"
				/><jsp:getProperty name="cur_records" property="sortableColumnString" />
			</td>
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
						<a  href='javascript:edit("<bean:write name="value_object" property="id"  />");'><img src="images/pencil.gif" border="0"></a >
					</td>
				</logic:equal>

				<td class = "listRow1Col">
					<logic:equal name="entity_access" property="readAccess" value="true" >
						<a  href='javascript:read("<bean:write name="value_object" property="id"  />");'>
					</logic:equal>
					<bean:write property="noeKhodroId" name="value_object"/>
					<logic:equal name="entity_access" property="readAccess" value="true" >
						</a >
					</logic:equal>
				</td>

				<td class = "listRow1Col"><bean:write property="onvan" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="guarantee" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="guaranteeDistance" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="khodroCode" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="noeKhodroCode" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="vijehName" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="khodrosazName" name="value_object"/></td>
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
	setForm(document.noeKhodroForm);
	setEntity("NoeKhodro");
</script>
