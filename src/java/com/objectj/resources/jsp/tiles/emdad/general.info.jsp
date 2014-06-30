<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<html:base/>
<script>
window.resizeTo(300, 150);
window.moveTo((screen.width-300)/2,(screen.height-150)/2);
</script>

<center class="validation">
	<html:errors/>
	<logic:present name="err_ref" scope="request">
	<bean:message key="errors.entity.delete.reference" />
	</logic:present>
<p></p>
</center>

