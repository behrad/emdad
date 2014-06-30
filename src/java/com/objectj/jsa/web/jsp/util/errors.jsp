<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:errors/>
The following error is thrown in your action
<HR>
<%
Exception exception;
exception = (Exception)request.getAttribute("exception");
if(exception == null) exception = (Exception)session.getAttribute("exception");
if(exception != null) {
    out.println("<b>" + exception.getMessage() + "</b><hr><p/>");
    java.io.StringWriter stringWriter = new java.io.StringWriter();

    //
    // Need to encapsulate the StringWriter into a Printwriter object
    // to fill up with stack trace
    //
    java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter);

    //
    // If it is ProxyException get the original exception
    //
    if(exception instanceof com.objectj.jsa.proxy.ProxyException) exception =
        ((com.objectj.jsa.proxy.ProxyException)exception).getException();

    //
    // Get the stack trace and fill the PrintWriter
    //
    exception.printStackTrace(printWriter);

    //
    // StringBuffer to hold stack trace
    //
    StringBuffer error = stringWriter.getBuffer();
    
    //
    // Return String object with stack trace
    //
    out.println(error.toString().replaceAll("\n", "\n<br>\n"));

//exception.printStackTrace(new java.io.PrintWriter(out));
} else {
    out.println("No exception in request or session!!");
}
%>
<!-- Start of foot.jsp -->
</html>                             
 <!-- End of foot.jsp -->
