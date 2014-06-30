<%
    if (request.getAttribute("toURL")!=null ) {
	    response.sendRedirect((String)request.getAttribute("toURL"));
    }
%>
