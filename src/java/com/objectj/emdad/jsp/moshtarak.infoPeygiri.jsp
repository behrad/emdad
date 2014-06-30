<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:form method="post" action="/s/moshtari?action_type=specific,goHome">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">شماره اشتراک:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="eshterakId"/></td>
					</tr>

					<tr height="3" bgcolor="#336699"><td colspan="3"></td></tr>
					
					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">کد مورد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="rokhdadId"/></td>
					</tr>
					
					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">اقدام شده:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="eghdamShodeh"/></td>
					</tr>
					
					<!---------------------------------------->

					<tr height="3" bgcolor="#336699"><td colspan="3"></td></tr>

					<!---------------------------------------->
		<% int i=1; %>

		<logic:iterate id="value_object" name="emdadList" >
				
					<tr class="readRow0">
						<td class="readLabel">دستور کار <%=i%>:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="emdadId" name="value_object"/></td>
					</tr>
	
					<tr class="readRow1">
						<td class="readLabel">نوع سرویس:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeEmdadName" name="value_object"/></td>
					</tr>

					<tr class="readRow0">						
						<td class="readLabel">زمان شروع به کار:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="zamanShoro" name="value_object"/></td>						
					</tr>

					<tr class="readRow1">
						<td class="readLabel">زمان پایان کار:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="zamanPayan" name="value_object"/></td>
					</tr>

					<tr class="readRow0">						
						<td class="readLabel">آخرین وضعیت:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="vazeatKhedmatOnvan" name="value_object"/></td>						
					</tr>

					<tr class="readRow1">
						<td class="readLabel">امدادگر:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="emdadgar" name="value_object"/></td>
					</tr>

					<tr class="readRow0">						
						<td class="readLabel">نمایندگی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="namayandegiName" name="value_object"/></td>						
					</tr>

					<tr class="readRow1">
						<td class="readLabel">پیش بینی مدت زمان تعمیر-سرویس:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="modatTamir" name="value_object"/></td>
					</tr>
				
					<tr height="3" bgcolor="#336699"><td colspan="3"></td></tr>
		<% i++; %>
									
        </logic:iterate>

		<logic:iterate id="value_object2" name="peigiriList" >

					<!---------------------------------------->
			<tr class="listRow<%=i%2%>">
				<td class = "listRow1Col" colspan="3">&nbsp;<bean:write property="zamanPeigiriHejri" name="value_object2"/>&nbsp;
                    <bean:write property="natije" name="value_object2"/>
				</td>
            </tr>
					<!---------------------------------------->
       </logic:iterate>


		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.moshtarakForm);
	setEntity("Moshtarak");
</script>
