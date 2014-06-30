<html>
<head>
<title>Login Page for Document Management System</title>
</head>
<body style="margin-top: 8px;">
<form method="POST" action='<%= response.encodeURL("j_security_check") %>' >
  <div align="center">
    <table border="1" cellspacing="0" cellpadding="0" bordercolor="#666666">
      <tr>
        <td align="center"> 
          <table border="0" cellspacing="0" cellpadding="5">
      <tr> 
        <th class="MenuRight">&nbsp;</th>
        <th> Login Form</th>
      </tr>      <tr> 
        <td align="right"><font face="Verdana, Arial, Helvetica, sans-serif" size="2">Username:</font></td>
        <td align="left">
          <input type="text" name="j_username">
        </td>
      </tr>
      <tr> 
        <td align="right"><font face="Verdana, Arial, Helvetica, sans-serif" size="2">Password:</font></td>
        <td align="left">
          <input type="password" name="j_password">
        </td>
      </tr>
      <tr> 
        <td class=menu align="right">&nbsp;</td>
        <td class=menu align="left"> 
          <input type="submit" value="Log In" name="submit" class=button>
          <input type="reset" class=button>
        </td>
      </tr>
    </table>

		</td>
      </tr>
    </table>
  </div>
</form>
</body>
</html>
