<%@ page contentType="text/html; charset=UTF-8" %>

<HEAD>
<TITLE>سيستم عمليات - شرکت امداد خودرو ايران</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">

</HEAD>


<BODY leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" />
    <form name="repLogin" method="post" action="j_security_check">
      <input name="j_username" type="text" value="<%=request.getAttribute("UserID").toString()%>"/>
      <input name="j_password" type="password" value="<%=request.getAttribute("Password").toString()%>"/>
    </form>
<script>
	document.repLogin.submit();
</script>
</BODY>
