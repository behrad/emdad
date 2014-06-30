<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<!---------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/show-top.jsp" flush="true" />
<!---------------------------------------->
<body onload="finish()" >
<script>
	function finish() {
		copySecondary = parent.document.jozeatKhedmatForm.iradId;
		select = document.iradForm.iradId;
			copyFlag=false;
	
		if (!copyFlag){ // just to be sure we don't run twice
			var countSecondary=select.length;
	
			copySecondary.length=countSecondary;
			for (var i=0;i<countSecondary;i++){
				copySecondary[i]=new Option(select[i].text); // need all new options for copy
				copySecondary[i].value=select[i].value;
			}
	
			copyFlag=true;
		}
		close();
	}
</script>

<html:form method="post" action="/r/irad">
	<table width="100%" align="center"  border="0" cellpadding="4" cellspacing="0" dir=rtl class="generalText">
		<tr class="readRow0"> 
			<td class="readData">
				<html:select property="iradId" size="1">
					<html:options collection="iradList1" property="eid" labelProperty="name" />
				</html:select>
			</td>
		</tr>
	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.iradForm);
	setEntity("Irad");
</script>
		
