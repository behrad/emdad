<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<%@ page import ="java.lang.*, com.objectj.emdad.ejb.util.EntityList, com.objectj.emdad.ejb.EntityAccess, com.objectj.emdad.ejb.util.Constants" %>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>



<script>
	function mostanadatRokhdadDetails (id){
		args = "width=500, height=300 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "MostanadatRokhdad";
		win1 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/mostanadatRokhdad.run&action_type=specific,mostanadatRokhdadShow&id="+id, windowTitle, args);
		win1.creator=document;
	}

	function mostanadatRokhdadCreate() {
		args = "width=500, height=400 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "MostanadatRokhdad";
		rokhdadId = document.mostanadatRokhdadForm.rokhdadRokhdadId.value;
		win2 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/mostanadatRokhdad.run&action_type=specific,tasvieHesabCreate&id=" + rokhdadId, windowTitle, args);
		win2.creator=document;		
	}

	function mostanadatRokhdadUpdate(id) {
		args = "width=500, height=500 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "MostanadatRokhdad";
		rokhdadId = document.mostanadatRokhdadForm.rokhdadRokhdadId.value;
		win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/mostanadatRokhdad.run&action_type=specific,tasvieHesabUpdate&id=" + id, windowTitle, args);
		win3.creator=document;		
	}

	function editNameParvande(id){
		args = "width=500, height=500 , resizable=yes, scrollbars=yes, status=0";
		windowTitle = "MostanadatRokhdad";
		win4 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/mostanadatRokhdad.run&action_type=specific,upload%26mostanadatRokhdadId=" + id + "%26fromPopUp=true", windowTitle, args);
		win4.creator=document;		
	}

	function mostanadatRokhdadDelete(){
		//document.mostanadatRokhdadForm.action_type.value="specific,doTasvieHesabDelete";
		//doSubmit("specific,doTasvieHesabDelete");
		question = confirm("\u0622\u064a\u0627 \u0645\u0637\u0645\u0626\u0646\u064a\u062f \u06a9\u0647 \u0645\u064a \u062e\u0648\u0627\u0647\u064a\u062f \u0633\u0637\u0631\u0647\u0627\u064a \u0627\u0646\u062a\u062e\u0627\u0628 \u0634\u062f\u0647 \u0631\u0627 \u062d\u0630\u0641 \u06a9\u0646\u064a\u062f\u061f")
		if (question !="0"){
			do_Submit("specific,doTasvieHesabDelete","s");
		}
	}
</script>

<!--% boolean canEdit = ((Boolean) request.getAttribute("canEdit")).booleanValue();//request.isUserInRole(Constants.ROLE_MALIOP); %-->

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:base/>

<!------------------------------------------------>
<body onkeydown="Jadid()">
	<html:form method="post" action="/l/mostanadatRokhdad">

		<!------------------------------------------------>
		<input type="hidden" name="rokhdadRokhdadId" value="<bean:write name="rokhdadRokhdadId"/>"/>
		
		<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">

			<!------------------------------------------------>

			<tr class="listTableHeader">
				<!-- logic : equal name="canEdit" value="true" -->
		            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />
					<td class = "listRow0Col" width="4%" align="center"><span class="textW">پرونده</span></td>
				<!-- / logic : equal -->
	
				<td class = "listRow0Col">
					<span class="textW">شناسه</span>
				</td>
	
				<td class = "listRow0Col">
					<span class="textW">شماره سند</span>
				</td>
	
				<td class = "listRow0Col">
					<span class="textW">نام پرونده</span>
				</td>
			</tr>

			<!------------------------------------------------>

			<% int i = 0; %>
			<logic:iterate id="value_object" name="value_object_list" >
				<tr class="listRow<%=i%2%>">
					<!-- logic : equal name="canEdit" value="true" -->
						<logic:equal name="entity_access" property="deleteAccess" value="true" >
							<td class = "listRow1Col">
								<html:multibox property="selectedItems" ><bean:write name="value_object" property="id"  /></html:multibox>
							</td>
						</logic:equal>

						<logic:equal name="entity_access" property="updateAccess" value="true" >
							<td class = "listRow1Col" align="center">
								<a  href='javascript:mostanadatRokhdadUpdate("<bean:write name="value_object" property="id"  />");'><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/pencil.gif" border="0"></a >
							</td>
	
							<td class = "listRow1Col" align="center">
								<a  href='javascript:editNameParvande("<bean:write name="value_object" property="id"  />");'><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/mostanad.gif" border="0"></a >
							</td>
						</logic:equal>						
					<!-- / logic : equal -->


					<td class = "listRow1Col">
						<logic:equal name="entity_access" property="readAccess" value="true" >
							<a  href='javascript:mostanadatRokhdadDetails("<bean:write name="value_object" property="mostanadatRokhdadId" />");'>
						</logic:equal>						
						<bean:write property="mostanadatRokhdadId" name="value_object"/>
						<logic:equal name="entity_access" property="readAccess" value="false" >
							</a >
						</logic:equal>						
					</td>

					<td class = "listRow1Col"><bean:write property="shomarehSanad" name="value_object"/></td>
					<td class = "listRow1Col">
						<a  target="_blank" href='http://<%=request.getServerName()%>:<%=request.getServerPort()%>/<bean:write property="nameParvande" name="value_object"/>'>
						<bean:write property="nameSanad" name="value_object"/></a>
					</td>
				</tr>
				<%i++;%>
			</logic:iterate>
		</table>

		<!------------------------------------------------>

		<html:hidden property="action_type"/>
		<html:hidden property="curpage" />
		<html:hidden property="order"/>
		<html:hidden property="sorttype" />
		<html:hidden property="id"/>
		
	    <!------------------------------------------------>

		<!--logic : equal name="canEdit" value="true" -->
			<table align="right" dir="rtl" border="0" cellspacing="0" class="generalText" width="100%">
				<tr>
					<td>
						<table border="0"  cellspacing="0" cellpadding="4" align="right" width="100%">
							<tr class="listTableFooter">
								<td>
									<logic:equal name="entity_access" property="deleteAccess" value="true" >
										<input type="button" name="delbut" value="حذف" onclick="javascript:mostanadatRokhdadDelete();" class="emdadButton"/>
									</logic:equal>
										
									<logic:equal name="entity_access" property="createAccess" value="true" >
										<input type="button" name="newbut" value="جديد" onclick="javascript:mostanadatRokhdadCreate();" class="emdadButton"/>
									</logic:equal>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>  
		<!--/ logic : equal -->

	</html:form>
</body>

<!------------------------------------------------>

<script>
	setForm(document.mostanadatRokhdadForm);
	setEntity("MostanadatRokhdad");
	top.document.all.rokhdadId2.innerText = document.mostanadatRokhdadForm.rokhdadRokhdadId.value;
</script>
