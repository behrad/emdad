<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>
<title></title>
<html:base/>

<script>
	function closeWindow(){
		top.close();
	}
</script>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/validate.jsp" flush="true" />

<html:form method="post" action="/s/validatejozeatKhedmat" onsubmit="return validateJozeatKhedmatForm(this)">
	<table width="100%" dir=rtl class="generalText">
		<tr>
			<td align="center">
            <jsp:include page="/com/objectj/emdad/jsp/jozeatKhedmat.fields.jsp" flush="true" />
                <tr align="left">
                    <td height="70" colspan="20" align="center">
                        <html:hidden property="action_type" />
                        <html:hidden property="id" />
                        <html:hidden property="curpage" />
                        <html:hidden property="order"/>
                        <html:hidden property="sorttype" />
                        <input type="submit" value="ثبت" class="emdadButton"/>&nbsp;&nbsp;
                        <html:reset  value="حالت اول" styleClass="emdadButton" />&nbsp;&nbsp;
                        <input type="button" value="انصراف" class="emdadButton" onClick="closeWindow();"/>&nbsp;&nbsp;
                    </td>
                </tr>

                <tr align="center">
                    <td height="20" align="center" colspan="20">
                        <span class="editStar"> * </span> : <span class="editRequired">ورود داده الزامي است</span>
                    </td>
                </tr>
		       </table>
			</td>
		</tr>
  </table>
</html:form>

<!----------------------------------------->

<script type="text/javascript" language="Javascript1.1">
	setForm(document.jozeatKhedmatForm);
	setEntity("JozeatKhedmat");
    document.jozeatKhedmatForm.action="/emdad/s/validatejozeatKhedmat.run";
</script>
<html:javascript formName="jozeatKhedmatForm" />
