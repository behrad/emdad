<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>

					<!---------------------------------------->

					<tr>
						<td height="70" colspan="3" align="center"> <input name="sub_but" type="submit" value="بازگشت" class="emdadButton"/>
						</td>
					</tr>

					<!---------------------------------------->

				</table>
			</td>
		</tr>

<html:hidden property="action_type" value="read_all" />
<html:hidden property="curpage" />
<html:hidden property="order"/>
<html:hidden property="sorttype" />
<html:hidden property="id"/>
<script type="text/javascript" language="Javascript1.1">
	setHelpURL("/emdad/com/objectj/resources/jsp/help/read.help.html");
</script>
