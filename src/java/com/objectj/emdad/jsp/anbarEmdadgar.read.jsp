<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>
<script>
	function emdadgarDetails() {
		showDetail(document.anbarEmdadgarForm.emdadgarId,
			null,
			"dimg1",
			"showEmdadgar",
			"rdtl",
			"/emdad/s/emdadgar.run?action_type=specific,emdadgarShow") ;
	}

	function qateDetails() {
		showDetail(document.anbarEmdadgarForm.qateId,
			null,
			"dimg2",
			"showQate",
			"rdt2",
			"/emdad/s/qate.run?action_type=specific,qateShow") ;
	}
</script>

<html:base/>

<html:form method="post" action="/r/anbarEmdadgar">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">دفتر استاني:</td>
						<td width="5%"></td>
						<td class="readData">
							<bean:write property="daftarOstaniName" name="value_object"/> 
						 </td>						
					</tr>
						
					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">امدادگر:</td>
						<td width="5%"></td>
						<td class="readData">
							<input type="hidden" name="emdadgarId" value="<bean:write name="value_object" property="emdadgarId"/>"/>
							<bean:write property="emdadgarName" name="value_object"/> 
							<a href="javascript:emdadgarDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
						 </td>						
					</tr>
						
					<!---------------------------------------->
					<tr class="editRow0">
						<td colspan="3">
							<div   style="display:none;height:100px;" id="showEmdadgar">
								<iframe width="100%" height="100%" src="" frameborder="1" name="rdtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">قطعه:</td>
						<td width="5%"></td>
						<td class="readData">
							<bean:write property="qateName" name="value_object"/>
							<input type="hidden" name="qateId" value="<bean:write name="value_object" property="qateId"/>"/>
							<a href="javascript:qateDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg2"></a>
						  </td>						

					</tr>
					<!---------------------------------------->
					<tr class="editRow1">
						<td colspan="3">
							<div   style="display:none;height:100px;" id="showQate">
								<iframe width="100%" height="100%" src="" frameborder="1" name="rdt2" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>
						
					<!---------------------------------------->
					<tr class="readRow0"> 
						<td class="readLabel">موجودی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="mojoodi" name="value_object"/>  </td>						
					</tr>
					<!---------------------------------------->
			
					<tr class="readRow1"> 
						<td class="readLabel">ارزش موجودی قطعه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="valueQate" name="anbarEmdadgarForm"/>  </td>						
					</tr>
					<!---------------------------------------->

					<tr class="readRow0"> 
						<td class="readLabel">ارزش کل موجودی:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="valueAnbar" name="anbarEmdadgarForm"/>  </td>						
					</tr>

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.anbarEmdadgarForm);
	setEntity("AnbarEmdadgar");
	document.anbarEmdadgarForm.emdadgarId.changed = true;
	document.anbarEmdadgarForm.qateId.changed = true;
</script>
		
