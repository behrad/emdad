<%@ page contentType="text/html; charset=UTF-8" %>
&nbsp;
&nbsp;
&nbsp;
&nbsp;

<table width="300" dir=rtl class="generalText"  border="1" align="center" bordercolor="#000099">
		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable" border="1">

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="editLabel">مشترک:</td>
			<td class="readData"><%= request.getAttribute("moshtarak_yaNa") %>  </td>
			<td class="editLabel">&nbsp;&nbsp;&nbsp;</td>
			<td class="editLabel">نوع اشتراک:</td>
			<td class="readData"><%= request.getAttribute("moshtarak_noeEshterak") %>  </td>
		</tr>

		<!---------------------------------------->


		<tr class="readRow0">
			<td class="editLabel">نوع سرويس: </td>
			<td class="readData"><%= request.getAttribute("moshtarak_noeService") %>  </td>
			<td class="editLabel">&nbsp;&nbsp;&nbsp;</td>
			<td class="editLabel"> وضعيت اشتراک:</td>
			<td class="readData"><%= request.getAttribute("moshtarak_vazeat") %> </td>
		</tr>

		<!---------------------------------------->

		<tr class="readRow1">
			<td class="editLabel">گارانتي:</td>
			<td class="readData"> <%= request.getAttribute("moshtarak_guarantee")%> </td>
			<td class="editLabel">&nbsp;&nbsp;&nbsp;</td>
			<td class="editLabel">&nbsp;</td>
			<td class="readData">&nbsp;</td>
		</tr>

		<!---------------------------------------->

		<!--tr class="readRow0">
			<td class="editLabel">آخرين مسافت گارانتي < % = request.getAttribute("moshtarak_noeKhodro") % >: </td>
			<td class="readData">&nbsp;< % = request.getAttribute("moshtarak_guaranteeDistance") % > &nbsp; کيلومتر</td>
		</tr-->

		<!---------------------------------------->
		</table>
		</td>
		</tr>

	</table>
