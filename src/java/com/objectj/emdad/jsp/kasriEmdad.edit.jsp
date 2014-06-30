<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<style type="text/css">
INPUT.field{
	"border: 2px thin solid #666699;
	background-color: #FFFFFF;
	font-family: Tahoma, Arial;
	font-size: 9pt;"
}
INPUT.field0{
	border: 0px none;
	background-color: #E9EBEB;
}
INPUT.field1{
	border: 0px none;
	background-color: #DADEDC;
}
LABEL {
	color: #FF0000;
}
</style>
<script>
	
	function focuse( elem ) {
		elem.style.cssText = "border: 2px thin solid #666699;background-color: #FFFFFF;font-family: Tahoma, Arial;font-size: 9pt;";
		elem.tag = 1;
	}
	
	function blure( elem, i ) {
		if ( i % 2 == 0 )
			elem.style.cssText = "border: 2px thin solid #E9EBEB;background-color: #E9EBEB;";
		else
			elem.style.cssText = "border: 2px thin solid #DADEDC;background-color: #DADEDC;";
	}


</script>

<bean:define id="noEditable" value="" scope="request" />

<html:form method="post" action="/c/validatekasriEmdad" onsubmit="return validateKasriEmdadForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->
					<logic:notEqual name="kasriEmdadForm" property="action_type" value="create" >
						<tr class="editRow0">
							<td class="editLabel">شناسه:</td>
							<td class="editStar"></td>
							<td class="readData"> <bean:write name="kasriEmdadForm" property="kasriId" /> </td>
							<html:hidden property="kasriId"/>
						</tr>
					</logic:notEqual>
                    <logic:equal name="kasriEmdadForm" property="action_type" value="create">
                        <html:hidden property="kasriId" />
                    </logic:equal>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تاريخ:</td>
						<td class="editStar">*</td>
						<td> <html:text property="tarikh" size="10" maxlength="10" styleClass="field"/><jsp:include page="/com/objectj/resources/jsp/tiles/emdad/samp-date.jsp" flush="true" /></td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">امدادگر:</td>
						<td class="editStar">*</td>
						<td class="editLabel" align="right">
							<html:hidden property="emdadgarId"/>
							<bean:write property="emdadgarName" name="kasriEmdadForm"/>
							<!--html:select property="emdadgarId" size="1">
								< html :options collection="emdadgarList" property="eid" labelProperty="name" />
							</html:select-->
						</td>
					</tr>

					<!----------------------------------------->

					<!--tr class="editRow1">
						<td class="editLabel">تحويل شد؟:</td>
						<td class="editStar">*</td>
						<td>
							<  html :select property="tahvilshod" size="1">
								< html :options collection="tahvilshodList" property="id" labelProperty="name" />
							< /html :select>
                        </td>
					</tr-->

					<!----------------------------------------->
				    <!--jsp:include page="/com/objectj/resources/jsp/tiles/emdad/edit-but.jsp" flush="true" /-->
					<!----------------------------------------->

				</table>
			</td>
		</tr>
	
		<!----------------------------------------->

  </table>

<table id="TBL" width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
		<tr class="listTableHeader">			
			<td class = "listRow0Col">شماره فني</td>

			<td class = "listRow0Col">نام قطعه</td>
			
			<td class = "listRow0Col">تعداد کسري</td>

			<td class = "listRow0Col">تعداد تاييد شده توسط انبار</td>

			<td class = "listRow0Col">تعداد تاييد شده توسط امدادگر</td>
		</tr>
		<!------------------------------------------------>
		<% int i = 0; %>	
		
		<logic:iterate id="value_object2" name="value_object_list">
		     <tr class="listRow<%=i%2%>">
			<td class = "listRow1Col" align="left">
				<logic:equal name="role" value="anbar">
					<logic:notEqual name="kasriEmdadForm" property="taeedAnbardar" value="1">
						<input type="hidden" name="id<%=i%>" value='<bean:write property="id" name="value_object2"/>' />
					</logic:notEqual>
				</logic:equal>
				<logic:equal name="role" value="emdadgar">
					<logic:notEqual name="kasriEmdadForm" property="taeedEmdadgar" value="1">
						<input type="hidden" name="id<%=i%>" value='<bean:write property="id" name="value_object2"/>' />
					</logic:notEqual>
				</logic:equal>
				<bean:write property="shomareFanni" name="value_object2"/>
			</td>

			<td class = "listRow1Col"><bean:write property="qateName" name="value_object2"/></td>

			<td class = "listRow1Col">
				<bean:write property="tedadKasri" name="value_object2"/>
			</td>
			<td class = "listRow1Col">
				<logic:equal name="role" value="anbar">
					<logic:equal name="kasriEmdadForm" property="taeedAnbardar" value="1">
						<bean:write property="tedadAnbar" name="value_object2"/>
					</logic:equal>
					<logic:notEqual name="kasriEmdadForm" property="taeedAnbardar" value="1">
						<input type="text" name="tedad<%=i%>" value='<bean:write property="tedadAnbar" name="value_object2"/>' size="5" maxlength="5" class="field<%=i%2%>"  onFocus="focuse(this);" onBlur="blure(this,<%=i%>);" />
					</logic:notEqual>
				</logic:equal>
				<logic:notEqual name="role" value="anbar">
				<bean:write property="tedadAnbar" name="value_object2"/>
				</logic:notEqual>
			</td>
			<td class = "listRow1Col">
				<logic:equal name="role" value="emdadgar">
					<logic:equal name="kasriEmdadForm" property="taeedEmdadgar" value="1">
						<bean:write property="tedadEmdadgar" name="value_object2"/>
					</logic:equal>
					<logic:notEqual name="kasriEmdadForm" property="taeedEmdadgar" value="1">
						<logic:equal name="kasriEmdadForm" property="taeedAnbardar" value="1">
							<input type="text" name="tedad<%=i%>" value='<bean:write property="tedadEmdadgar" name="value_object2"/>' size="5" maxlength="5" class="field<%=i%2%>"  onFocus="focuse(this);" onBlur="blure(this,<%=i%>);" />
						</logic:equal>
						<logic:notEqual name="kasriEmdadForm" property="taeedAnbardar" value="1">
							<bean:write property="tedadEmdadgar" name="value_object2"/>
						</logic:notEqual>
					</logic:notEqual>
				</logic:equal>
				<logic:notEqual name="role" value="emdadgar">
				<bean:write property="tedadEmdadgar" name="value_object2"/>
				</logic:notEqual>
			</td>
	            </tr>
	            <%i++;%>
	        </logic:iterate>
		<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>
			<span class="editLabel">تائيدانباردار؟:</span>
			<logic:equal name="role" value="anbar">
				<logic:equal name="kasriEmdadForm" property="taeedAnbardar" value="1">
					<html:hidden property="taeedAnbardar" /><bean:write property="taeedAnbardarName" name="value_object" />
					<bean:define id="noEditable" value="noEditable" scope="request" />
				</logic:equal>
				<logic:notEqual name="kasriEmdadForm" property="taeedAnbardar" value="1">
					<html:select property="taeedAnbardar" size="1">
						<html:options collection="taeedAnbardarList" property="id" labelProperty="name" />
					</html:select>
				</logic:notEqual>
			</logic:equal>
			<logic:notEqual name="role" value="anbar">
				<html:hidden property="taeedAnbardar" /><bean:write property="taeedAnbardarName" name="value_object" />
				<!--bean:define id="noEditable" value="noEditable" scope="request"/-->
			</logic:notEqual>
		</td>
		<td>
			<span class="editLabel">تاييد امدادگر؟:</span>
			<logic:equal name="role" value="emdadgar">
				<logic:equal name="kasriEmdadForm" property="taeedEmdadgar" value="1">
					<html:hidden property="taeedEmdadgar" /><bean:write property="taeedEmdadgarName" name="value_object" />
					<bean:define id="noEditable" value="noEditable" scope="request"/>
				</logic:equal>
				<logic:notEqual name="kasriEmdadForm" property="taeedEmdadgar" value="1">
					<logic:equal name="kasriEmdadForm" property="taeedAnbardar" value="1">
						<html:select property="taeedEmdadgar" size="1">
							<html:options collection="taeedEmdadgarList" property="id" labelProperty="name" />
						</html:select>
					</logic:equal>
					<logic:notEqual name="kasriEmdadForm" property="taeedAnbardar" value="1">
						<bean:define id="noEditable" value="noEditable" scope="request"/>
						<html:hidden property="taeedEmdadgar" /><bean:write property="taeedEmdadgarName" name="value_object" />
					</logic:notEqual>
				</logic:notEqual>
			</logic:equal>
			<logic:notEqual name="role" value="emdadgar">
				<html:hidden property="taeedEmdadgar" /><bean:write property="taeedEmdadgarName" name="value_object" />
				<!--bean:define id="noEditable" value="noEditable" scope="request"/-->
			</logic:notEqual>
		</td>
		</tr>
					<!----------------------------------------->
				    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/edit-but.jsp" flush="true" />						
					<!----------------------------------------->
</table>
<html:hidden property="tahvilshod" />

</html:form>

<!----------------------------------------->

<script type="text/javascript" language="Javascript1.1">
	setForm(document.kasriEmdadForm);
	setEntity("KasriEmdad");
    if (document.kasriEmdadForm.action_type.value=="create") 
	{
        document.kasriEmdadForm.action="/emdad/c/validatekasriEmdad.run";
    } 
	
	else 
	{
        document.kasriEmdadForm.action="/emdad/u/validatekasriEmdad.run";
    }

<logic:equal name="noEditable" value="noEditable" >
document.kasriEmdadForm.khoroojBtn.style.display = "inline";
document.kasriEmdadForm.sabtBtn.style.display = "none";
document.kasriEmdadForm.enserafBtn.style.display = "none";
</logic:equal>

function chkSabt(elem) {
	elem.disabled = true;
	err = false;
	elm = eval("document.kasriEmdadForm.tedad0");
	for (j=0; elm!=null && j<1000; j++) {
		elm = eval("document.kasriEmdadForm.tedad"+j);
		if (elm==null) {
			break;
		}
		//alert(j+","+elm.value);
		if (!isInteger(elm.value)) {
			err = true;
			focuse(elm);
			break;
		}
	}
	if (err) {
		elem.disabled = false;
	} else {
		theForm.submit();
	}
}
</script>
<html:javascript formName="kasriEmdadForm" />
