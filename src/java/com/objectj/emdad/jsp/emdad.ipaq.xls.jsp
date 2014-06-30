<%@ page contentType = "application/x-msexcel; charset=UTF-8" %>

<%
	//response.setContentType( "application/vnd.ms-excel" );
	response.setContentType( "application/x-msexcel" );
%>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>
	
	<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="0" cellspacing="0">
	
		<tr>
			
			<td class="headerCol">&nbsp;دستورکار</td>
		
			<td class="headerCol">&nbsp;شماره اشتراک</td>
		
			<td class="headerCol">&nbsp;شرح ايراد</td>
		
			<td class="headerCol">&nbsp;کيلومتر کارکرد</td>
		
			<td class="headerCol">&nbsp;تاريخ شروع</td>
		
			<td class="headerCol">&nbsp;تاريخ پايان</td>
		
			<td class="headerCol">&nbsp;راه اندازي </td>
		
			<td class="headerCol">&nbsp;مبلغ کل صورت حساب</td>
		
			<td class="headerCol">&nbsp;نياز به سرويس جديد</td>
		
		</tr>

		<!------------------------------------------------>

		<logic:iterate id="value_object" name="value_object_list" >
		
			<tr>

				<td class = "field">&nbsp;<bean:write property="emdadId" name="value_object"/></td>

				<td class = "field">&nbsp;<bean:write property="eshterakId" name="value_object"/></td>

				<td class = "field">&nbsp;<bean:write property="irad" name="value_object"/></td>

				<td class = "field">&nbsp;<bean:write property="kilometerKarkard" name="value_object"/></td>

				<td class = "field">&nbsp;<bean:write property="zamanShoro" name="value_object"/></td>

                <td class = "field">&nbsp;<bean:write property="zamanPayan" name="value_object"/></td>

                <td class = "field">&nbsp;<bean:write property="rahAndazi" name="value_object"/></td>

                <td class = "field">&nbsp;<bean:write property="hododeHazinehKol" name="value_object"/></td>

                <td class = "field">&nbsp;</td>

            </tr>

        </logic:iterate>

	</table>