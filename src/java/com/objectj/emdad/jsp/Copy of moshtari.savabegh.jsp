<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import ="java.sql.*,java.util.*,com.objectj.emdad.proxy.QueryObject,com.objectj.emdad.ejb.*,com.objectj.emdad.ejb.util.*" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>
<!---------------------------------------->

<body onload=showDone()>

<script>

	function moshtarakDetails() {
		showDetail(document.moshtarakForm.eshterakId, 
				null,
				"dimg0",
				"showMoshtari",
				"mdtl",
				"/emdad/s/moshtarak.run?action_type=specific,moshtarakShow") ;
	}

	function emdadDetails(emdadId, i){
			showDetail(emdadId,
					null,
					"dimg"+i,
					"showEmdad"+i,
					"rdt"+i,
					"/emdad/s/emdad.run?action_type=specific,emdadShow") ;
	}

	function rokhdadDetails(rokhdadId, i){
			showDetail(rokhdadId,
					null,
					"dimg"+i,
					"showRokhdad"+i,
					"rdt"+i,
					"/emdad/s/rokhdad.run?action_type=specific,rokhdadShow") ;
	}

	var lastCreator;
</script>



<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/show-top.jsp" flush="true" />
<!---------------------------------------->
<html:form method="post" action="/r/moshtarak">

	<table width="100%" align="center"  border="0" cellpadding="4" cellspacing="0" dir=rtl class="generalText">

		<tr class="readRow0">
			<td class="readLabel">شماره مشتري:</td>
			<td width="5%"></td>
			<td class="readData"> <bean:write name="Moshtarak" property="eshterakId" />
			<input type="hidden" name="eshterakId" value="<bean:write property="id" name="Moshtarak"/>" />
			<script>document.moshtarakForm.eshterakId.changed = true;</script>
			<a href="javascript:moshtarakDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg0"></a>
			</td>
		</tr>
		<!----------------------------------------->

		<tr class="readRow0">
			<td colspan="3">
				<div style="display:none;height:100px;" id="showMoshtari">
					<iframe width="100%" height="100%" src="" frameborder="1" name="mdtl" marginheight="0" marginwidth="0" ></iframe>
				</div>
			</td>
		</tr>

	<tr height="3" bgcolor="#336699"><td colspan="3"></td></tr>

        <% int i = 1; 
	int j= 1;
	int k = 1;
	ArrayList al = null;
	try {
		al = (ArrayList) request.getAttribute("RokhdadList");
	for (j=0,i=0; i<al.size() && j<20; i++,j++) {
		ArrayList al4 = (ArrayList) al.get(j);%>
			<tr class="readRow<%=i%2%>">
				<td class="readLabel">مورد:</td>
				<td width="5%"></td>
				<td class="readData">
                      <%=al4.get(1)%><input type="hidden" value="<%=al4.get(0)%>" name="rokhdadId<%=i%>" />
                      <a href='javascript:rokhdadDetails(document.moshtarakForm.rokhdadId<%=i%>, "<%=i%>");' > <img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg<%=i%>"> </a>
			<%=HejriUtil.getDateTimeFromDate((Timestamp)al4.get(2))%> , <%=(al4.get(3)==null ? "" : al4.get(3))%> 
			<script>document.moshtarakForm.rokhdadId<%=i%>.changed = true;</script>
                 </td>
			</tr>

            <!---------------------------------------->

            <tr class="editRow<%=i%2%>">
                <td colspan="3">
                    <div style="display:none;height:100px;" id="showRokhdad<%=i%>">
                        <iframe width="100%" height="100%" src="" frameborder="1" name="rdt<%=i%>" marginheight="0" marginwidth="0" > </iframe>
                    </div>
                </td>
            </tr>
	<%
		QueryObject qo = new QueryObject();
		qo.setFromIndex(0);
		qo.setTables("emdad");
	        qo.setSelectFields("emdadId,rahAndazi");
		qo.setJoined(false);
		qo.setWhere("rokhdadId='" + al4.get(0) + "'");
		ArrayList al3 = com.objectj.emdad.web.util.Util.advanceRead(qo);
		for (k=0, i++; k<al3.size() && k<6; i++,k++) {
			ArrayList al2 = (ArrayList) al3.get(k); %>
			<tr class="readRow<%=i%2%>">
				<td class="readLabel">دستور کار:</td>
				<td width="5%"></td>
				<td class="readData">
                      <%=al2.get(0)%><input type="hidden" value="<%=al2.get(0)%>" name="emdadId<%=i%>" />
                      <a href='javascript:emdadDetails(document.moshtarakForm.emdadId<%=i%>, "<%=i%>");' > <img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg<%=i%>"> </a>
			<%=al2.get(1)==null ? "" : al2.get(1)%>
			<script>document.moshtarakForm.emdadId<%=i%>.changed = true;</script>
                 </td>
			</tr>

	            <!---------------------------------------->

	            <tr class="editRow<%=i%>">
        	        <td colspan="3">
                	    <div style="display:none;height:100px;" id="showEmdad<%=i%>">
                        	<iframe width="100%" height="100%" src="" frameborder="1" name="rdt<%=i%>" marginheight="0" marginwidth="0" > </iframe>
	                    </div>
        	        </td>
	            </tr>
		<%}
		if (al3.size()>6) {%>
	            <tr class="editRow<%=i%>"><td colspan="3">...ناتمام</td></tr>
		<%}%>
		<tr height="3" bgcolor="#336699"><td colspan="3"></td></tr>
<%	}
	if (al.size()>20) {%>
            <tr class="editRow<%=i%>"><td colspan="3">...ناتمام</td></tr>
	<%}
	} catch (Exception e) {
		e.printStackTrace(); 
        }
	%>
	
	</table>

</html:form>
