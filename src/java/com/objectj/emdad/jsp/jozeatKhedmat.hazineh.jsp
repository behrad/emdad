<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<!---------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/show-top.jsp" flush="true" />
<!---------------------------------------->
<body onload="finish()" >
<script>
	function finish() {
		parent.document.jozeatKhedmatForm.hazinehDefault.value = document.jozeatKhedmatForm.hazinehDefault.value;		
		close();
	}
</script>

<html:base/>

<html:form method="post" action="/r/jozeatKhedmat">
	<input type="hidden" name="hazinehDefault" value="<bean:write name="hazinehDefault"/>"/>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.jozeatKhedmatForm);
	setEntity("JozeatKhedmat");
</script>

