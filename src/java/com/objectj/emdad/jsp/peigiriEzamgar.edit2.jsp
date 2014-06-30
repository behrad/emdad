<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>


<META http-equiv=Content-Type content="text/html; charset=utf-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>

<!--jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" /-->

<%@ page import ="java.lang.*,com.objectj.emdad.ejb.util.EntityList,com.objectj.emdad.ejb.EntityAccess" %>


<html:base/>
<script>
    function checkSabt(elem) {
        elem.disabled = true;
//        top.creator.click();
//		top.close();
        theForm.submit();
    }

    function CloseWindow(){
        close();
    }

	function peigiriDetails(s,i) {
		showDetail(s,
			null,
			"dimg"+i,
			"showPeigiri"+i,
			"pdt"+i,
			"/emdad/s/peigiriEzamgar.run?action_type=specific,peigiriShow") ;
	}

	function emdadDetails() {
		showDetail(document.peigiriEzamgarForm.emdadEmdadId,
			null,
			"dimg1",
			"showEmdad",
			"edtl",
			"/emdad/s/emdad.run?action_type=specific,emdadShow") ;
	}

/*
	function emdadSearch() {
		args = "width=1000 , height=750 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "Search";
		obj = document.getElementById("showEmdad");
		obj.style.display = "none";
		s="1";
		win2 = window.open("/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/emdad.run?action_type=specific,find", windowTitle, args);
		win2.creator=document.peigiriEzamgarForm;
	}
*/
	var lastCreator;
</script>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/validate.jsp" flush="true" />

<html:form method="post" action="/s/validatepeigiriEzamgar" onsubmit="return validatePeigiriEzamgarForm(this)">
<br>
<table width="70%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
		<tr align="center">
			<td  nowrap class = "info">
			    پيگيري هاي قبلي
			</td>
		</tr>

		<% int i = 0; %>
		<logic:iterate id="ss" name="peigiriList" >
			<tr class="listRow<%=i%2%>">

				<td class = "listRow1Col">
                    &nbsp;<bean:write property="zamanPeigiriHejri" name="ss"/>&nbsp;
				</td>
				<td class = "listRow1Col">
                    <bean:write property="natije" name="ss"/>
				</td>
            </tr>

            <%i++;%>
        </logic:iterate>

</table>


<br>

<input type="hidden" name="emdadId" value="<%=request.getParameter("emdadId")%>" />
<input type="hidden" name="emdadEmdadId" value="<%=request.getParameter("emdadEmdadId")%>" />

	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تاريخ پي گيري:</td>
						<td class="editStar">*</td>
						<td> <html:text property="zamanPeigiri" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<tr class="editRow1">
						<td class="editLabel">زمان پی گیری:</td>
						<td class="editStar">*</td>
						<td> <html:text property="zamanPeigiri2" size="10" maxlength="10" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">نتیجه پی گیری:</td>
						<td class="editStar">*</td>
						<td> <html:text property="natije" size="80" maxlength="80" onkeypress="return submitenter(this,event)" styleClass="field"/> </td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td height="20" align="center" colspan="3">
							<span class="editRequired">توجه: متني که در اينجا نوشته مي شود توسط مشتري قابل مشاهده است.</span>
						</td>
					</tr>

					<!----------------------------------------->

                    <tr class="editRow1">
						<td class="editLabel">دستورکار:</td>
						<td class="editStar">*</td>
						<td class="readData">
							<%=request.getParameter("emdadEmdadId")%>
							<a href="javascript:emdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1">
							</a>
							&nbsp;
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td colspan="3">
							<div style="display:none;height:100px;" id="showEmdad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="edtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>


					<!----------------------------------------->
<tr align="left">
	<td height="70" colspan="20" align="center">
		<html:hidden property="action_type" />
		<html:hidden property="id" />
		<html:hidden property="curpage" />
		<html:hidden property="order"/>
		<html:hidden property="sorttype" />
		<input type="button" value="ثبت" class="emdadButton" onClick="javascript:checkSabt(this);"/>&nbsp;&nbsp;
		<html:reset  value="حالت اول" styleClass="emdadButton" />&nbsp;&nbsp;
		<input type="button" value="انصراف" class="emdadButton" onClick="javascript:CloseWindow();"/>&nbsp;&nbsp;
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/help.jsp" flush="true">
   <jsp:param name="help_url" value="emdad.peygiri.help.html" />	
</jsp:include>
	</td>
</tr>

<tr align="center">
	<td height="20" align="center" colspan="20">
		<span class="editStar"> * </span> : <span class="editRequired">ورود داده الزامي است</span>
	</td>
</tr>
					<!----------------------------------------->

				</table>
			</td>

		</tr>

		<!----------------------------------------->

  </table>
</html:form>

<!----------------------------------------->

<script type="text/javascript" language="Javascript1.1">
	setForm(document.peigiriEzamgarForm);
	setEntity("PeigiriEzamgar");

	document.peigiriEzamgarForm.emdadEmdadId.changed = true;

</script>
<html:javascript formName="peigiriEzamgarForm" />
