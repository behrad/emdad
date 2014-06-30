<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<body onkeydown="Sabt()"/>

    <form name="chgpassForm" method="post" action="/emdad/s/shakhs.run?action_type=specific,changePass">

	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">
					<!----------------------------------------->

        <tr class="editRow0">

          <td  class="editLabel">گذرواژه قبلی:</td>
          <td>
                  <input name="oldPassword" type="password" class="field" size="20"/>
		<input type="hidden" name="id" value='<bean:write name="id" />' />
                </td>
        </tr>

        <tr class="editRow1">

          <td  class="editLabel">گذرواژه جديد:</td>
          <td>
                  <input name="newPassword" type="password" class="field" size="20"/>
                </td>
        </tr>

        <tr class="editRow0">

          <td  class="editLabel">ورود مجدد گذرواژه جديد:</td>
          <td>
                  <input name="confirmPassword" type="password" class="field" size="20"/>
                </td>
        </tr>

        <tr class="editRow1">
          <td colspan="2">&nbsp;</td>
	</tr>
        <tr class="editRow0">

          <td>
                    <input name="Submit" type="button" class="emdadButton" value="ثبت" onClick="validatePass()"/>
          </td>
          <td>
                    <input name="Cancel" type="button" class="emdadButton" value="انصراف" onclick="cancel()"/>
                </td>
        </tr>
        <tr class="editRow1">
          <td colspan="2">
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/help.jsp" flush="true">
   <jsp:param name="help_url" value="passwordChange.help.html" />	
</jsp:include>
	</td>
	</tr>
	</table>
			</td>
		</tr>

		<!----------------------------------------->

  </table>

</form>

<script>
	document.chgpassForm.oldPassword.focus();
    function validatePass() {
      if (document.chgpassForm.oldPassword.value=='' ||
          document.chgpassForm.newPassword.value=='' ||
          document.chgpassForm.confirmPassword.value=='') {
		alert("لطفا هر سه گذر واژه را وارد کنيد");
	        document.chgpassForm.oldPassword.focus();
	}
	if (document.chgpassForm.newPassword.value!=document.chgpassForm.confirmPassword.value) {
		alert("گذرواژه جديد و تاييد آن يکسان نيستند");
	        document.chgpassForm.newPassword.focus();
	}
	if (document.chgpassForm.newPassword.value==document.chgpassForm.oldPassword.value ) {
		alert("گذر واژه جديد با قبلي يکسان است");
	        document.chgpassForm.newPassword.focus();
	}
        else
            document.chgpassForm.submit();
    }

    function cancel(){
		document.chgpassForm.action="/emdad/s/shakhs.run?action_type=specific,cancel";
		document.chgpassForm.submit();
    }
</script>
</BODY>
