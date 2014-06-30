<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>

				<!----------------------------------------->

				<td class="filterCol"> 
					<select id="operator">
						<option value="=">=</option>
						<option value="<>">≠</option>
						<option value="<">&lt;</option>
						<option value=">">&gt;</option>
						<option value=">=">≥</option>
						<option value="<=">≤</option>
						<option class="generalText" value="LIKE">مشابه</option>
						<option class="generalText" value="START">شروع شود با</option>
					</select> 
				</td>
				
				<!----------------------------------------->
				
				<td class="filterCol"> 
					<input type="text" id="val" size=30 value="" onkeypress="return submitenter(this,event)"> 
				</td>
				
				<!----------------------------------------->

				<td class="filterCol">
					<select class="generalText" id="gr1">
						<option value=" ">&nbsp;</option>
						<option value=")">)</option>
					</select> 
				</td>
				
				<!----------------------------------------->
	
				<td class="filterCol"> 
					<select class="generalText" id="bool">
						<option value="AND">و</option>
						<option value="OR">يا</option>
					</select> 
				</td>
				
				<!----------------------------------------->
								
			</tr>

			<!----------------------------------------->
			
			<tr class="filterRow"></tr>

		</table>

		<!----------------------------------------->

		<p></p>

		<!----------------------------------------->

		<table>
			<tr id="endRow" align="center">
				<td colspan=6 valign=center>
					<input type=button value="نمايش" onclick="getExp()" class="emdadButton" /> &nbsp;&nbsp;&nbsp;
					<input type=button value="سطر جديد" onclick="an()" class="emdadButton" /> &nbsp;&nbsp;&nbsp;
					<input type=button value="انصراف" onclick="cancel()" class="emdadButton" />
				</td>
			</tr>
		</table>
	</form>
</td></tr></table>
</center>
