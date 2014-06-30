<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:errors/>
<%
org.apache.struts.validator.DynaValidatorForm form;
form = (org.apache.struts.validator.DynaValidatorForm)request.getAttribute("form");
if(form == null) form = (org.apache.struts.validator.DynaValidatorForm)session.getAttribute("form");
if(form != null) {
    %>
    You submitted: 
    <HR>
    <%
    java.util.Map map = form.getMap();
    for(java.util.Iterator iter = map.keySet().iterator(); iter.hasNext(); ) {
        Object key = iter.next();
        out.println("<li>" + key + "=" + map.get(key));
    }
} else {
    %>
    This default page works only if you don't remove the form from
session/request scope. 
    <p>
    You probabely need to set the forward action to a different jsp.
    <%
}
%>
<!-- Start of foot.jsp -->
</html>                             
 <!-- End of foot.jsp -->
