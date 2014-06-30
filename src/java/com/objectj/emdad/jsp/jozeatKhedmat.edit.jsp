<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<body onkeydown="Sabt()"/>

<html:form method="post" action="/c/validatejozeatKhedmat" onsubmit="return validateJozeatKhedmatForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">

                    <jsp:include page="/com/objectj/emdad/jsp/jozeatKhedmat.fields.jsp" flush="true" />
                	<!----------------------------------------->
				    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/edit-but.jsp" flush="true" />
					<!----------------------------------------->

				</table>
			</td>
		</tr>

		<!----------------------------------------->

  </table>
</html:form>

<!----------------------------------------->

<script type="text/javascript" language="Javascript1.1">

	setForm(document.jozeatKhedmatForm);
	setEntity("JozeatKhedmat");
	if (document.jozeatKhedmatForm.action_type.value=="create") 
	{
        document.jozeatKhedmatForm.action="/emdad/c/validatejozeatKhedmat.run";
	} 
	
	else 
	{
        document.jozeatKhedmatForm.action="/emdad/u/validatejozeatKhedmat.run";
	}
</script>
<html:javascript formName="jozeatKhedmatForm" />
