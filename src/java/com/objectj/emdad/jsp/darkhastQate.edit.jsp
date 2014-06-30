<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>

<script>
	function qateDetails() {
		showDetail(document.darkhastQateForm.qateId,
			null,
			"dimg1",
			"showQate",
			"edtl",
			"/emdad/s/qate.run?action_type=specific,qateShow") ;
	}

	function qateSearch() {
		doSearchAndHide("showQate",
				 "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/qate.run?action_type=specific,find",
				 document.darkhastQateForm,
				 "dimg1");
	}

	function emdadgarDetails() {
		showDetail(document.darkhastQateForm.emdadgarId,
			null,
			"dimg2",
			"showEmdadgar",
			"edt2",
			"/emdad/s/emdadgar.run?action_type=specific,emdadgarShow") ;
	}


</script>



<html:form method="post" action="/c/validatedarkhastQate" onsubmit="return validateDarkhastQateForm(this)">
	<table width="100%" dir=rtl class="generalText">

		<!----------------------------------------->

		<tr>
			<td align="center">
				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->
					<logic:notEqual name="darkhastQateForm" property="action_type" value="create" >
						<tr class="editRow0">
							<td class="editLabel">شناسه:</td>
							<td class="editStar"></td>
							<td class="readData"> <bean:write name="darkhastQateForm" property="darkhastQateId" /> </td>
							<html:hidden property="darkhastQateId"/>
						</tr>
					</logic:notEqual>
                    <logic:equal name="darkhastQateForm" property="action_type" value="create">
                        <html:hidden property="darkhastQateId" />
                    </logic:equal>
					<!----------------------------------------->
                    <tr class="editRow1">
                        <td class="editLabel">امدادگر:</td>
                        <td class="editStar">*</td>
                        <td class="readData">
    					<logic:equal name="canChange" value="true" >
                            <logic:equal name="role" value="sarparast" >
                                <html:select property="emdadgarId" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
                                    <html:options collection="emdadgarList" property="eid" labelProperty="name" />
                                </html:select>
                             </logic:equal>
                            <logic:equal name="role" value="emdadgar" >
                                <html:hidden property="emdadgarId" />
                                <bean:write name="emdadgarName" />
                             </logic:equal>
                            <logic:equal name="role" value="anbar" >
                                <html:hidden property="emdadgarId" />
                                <bean:write name="emdadgarName" />
                             </logic:equal>
                         </logic:equal>
                         <logic:notEqual name="canChange" value="true" >
                                <html:hidden property="emdadgarId" />
                                <bean:write name="emdadgarName" />
                         </logic:notEqual>
  						 <a href="javascript:emdadgarDetails()" ><img src="images/show-on.gif" border="0" id="dimg2"></a>
                       </td>
                     </tr>
					<!----------------------------------------->

					<tr class="editRow1">
						<td colspan="3">
							<div style="display:none;height:100px;" id="showEmdadgar">
								<iframe width="100%" height="100%" src="" frameborder="1" name="edt2" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تاریخ درخواست:</td>
						<td class="editStar">*</td>
                         <logic:equal name="canChange" value="true" >
                            <logic:notEqual name="role" value="anbar" >
                                <td> <html:text property="tarikhDarkhast" size="10" maxlength="10" styleClass="field"/> </td>
                            </logic:notEqual>
                            <logic:equal name="role" value="anbar" >
                                <td class="readData">
                                    <bean:write property="tarikhDarkhast" name="darkhastQateForm"/>
                                    <html:hidden property="tarikhDarkhast" />
                                </td>
                            </logic:equal>
                        </logic:equal>
                         <logic:notEqual name="canChange" value="true" >
						 		<td class="readData">
                                <html:hidden property="tarikhDarkhast" />
                                <bean:write property="tarikhDarkhast" name="darkhastQateForm" />
								</td>
                         </logic:notEqual>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">قطعه:</td>
						<td class="editStar">*</td>
                            <html:hidden property="qateId" />

                         <logic:equal name="canChange" value="true" >
                            <logic:notEqual name="role" value="anbar" >
							   <td> <html:text property="qateIdCode" size="11" maxlength="11" styleClass="field" onchange="valueChanged(this)"/>
                            </logic:notEqual>
                            <logic:equal name="role" value="anbar" >
                                <td class="readData">
                                    <bean:write property="qateIdCode" name="darkhastQateForm"/>
                                    <html:hidden property="qateIdCode" />
                            </logic:equal>
							<a href="javascript:qateDetails()" ><img src="images/show-on.gif" border="0" id="dimg1"></a>
							&nbsp;
                            <logic:notEqual name="role" value="anbar" >
								<input type="button" value="جستجو" onClick="javascript:qateSearch();" />
                            </logic:notEqual>
                         </logic:equal>

                         <logic:notEqual name="canChange" value="true" >
                                <td class="readData">
                                <html:hidden property="qateIdCode" />
                                <bean:write  property="qateIdCode" name="darkhastQateForm" />
							<a href="javascript:qateDetails()" ><img src="images/show-on.gif" border="0" id="dimg1"></a>
							&nbsp;
                         </logic:notEqual>

                       </td>
					</tr>
					<!----------------------------------------->

					<tr class="editRow1">
						<td colspan="3">
							<div style="display:none;height:100px;" id="showQate">
								<iframe width="100%" height="100%" src="" frameborder="1" name="edtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>


					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">تعداد درخواستی:</td>
						<td class="editStar">*</td>
                         <logic:equal name="canChange" value="true" >
                            <logic:notEqual name="role" value="anbar" >
                                <td> <html:text property="tedadDarkhasti" size="5" maxlength="5" styleClass="field"/> </td>
                            </logic:notEqual>
                            <logic:equal name="role" value="anbar" >
                                <td class="readData"><bean:write name="darkhastQateForm" property="tedadDarkhasti" />
                                 <html:hidden property="tedadDarkhasti" /></td>
                            </logic:equal>
                        </logic:equal>
                         <logic:notEqual name="canChange" value="true" >
						    <td class="readData"><bean:write name="darkhastQateForm" property="tedadDarkhasti" />
                             <html:hidden property="tedadDarkhasti" /></td>
                         </logic:notEqual>
					</tr>

					<!----------------------------------------->

				<logic:notEqual name="darkhastQateForm" property="action_type" value="create" >
					<logic:notEqual name="role" value="emdadgar" >
                        <tr class="editRow1">
                            <td class="editLabel">تعداد تایید شده توسط سرپرست امدادگران:</td>
                            <td class="editStar"> </td>
                            <logic:equal name="role" value="sarparast" >
                                 <td><html:text property="tedadSarparast" size="5" maxlength="5" styleClass="field"/> </td>
                            </logic:equal>
                            <logic:equal name="role" value="anbar" >
                                   <td class="readData">
                                      <html:hidden property="tedadSarparast" />
                                      <bean:write name="darkhastQateForm" property="tedadSarparast" />
                                   </td>
                            </logic:equal>
                         </tr>
                            <!----------------------------------------->

                            <tr class="editRow0">
                                <td class="editLabel">تایید شده توسط سرپرست امدادگران:</td>
                                <td class="editStar"> </td>
                                <logic:equal name="role" value="sarparast" >
                                    <td>
                                        <html:select property="taeedShodehSarparast" size="1">
                                            <html:options collection="yesNoList" property="id" labelProperty="name" />
                                        </html:select>
                                    </td>
                                </logic:equal>
                                <logic:equal name="role" value="anbar" >
                                       <td class="readData">
                                          <html:hidden property="taeedShodehSarparast" />
                                          <bean:write name="taeedShodehSarparastName" />
                                       </td>
                                </logic:equal>
                            </tr>

                            <!----------------------------------------->

                            <tr class="editRow1">
                                <td class="editLabel">منبع تهیه قطعه:</td>
                                <td class="editStar">*</td>
                                <logic:equal name="role" value="sarparast">
                                    <td>
                                        <html:select property="manba" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
                                            <html:options collection="bazarAnbarList" property="id" labelProperty="name" />
                                        </html:select>
                                    </td>
                                </logic:equal>
                                <logic:equal name="role" value="anbar" >
                                       <td class="readData">
                                          <html:hidden property="manba" />
                                          <bean:write name="manbaName" />
                                       </td>
                                </logic:equal>
                            </tr>
					<!----------------------------------------->
					</logic:notEqual>
               </logic:notEqual>

				<logic:equal name="darkhastQateForm" property="action_type" value="create" >
                        <html:hidden property="manba" />
                </logic:equal>

				<logic:notEqual name="darkhastQateForm" property="action_type" value="create" >
        			<logic:equal name="role" value="anbar">
                        <!----------------------------------------->

                        <tr class="editRow0">
                            <td class="editLabel">تعداد تایید شده توسط انبار:</td>
                            <td class="editStar"> </td>
                            <td> <html:text property="tedadAnbar" size="5" maxlength="5" styleClass="field"/> </td>
                        </tr>

                        <!----------------------------------------->

                        <tr class="editRow1">
                            <td class="editLabel">تایید شده توسط انبار:</td>
                            <td class="editStar"> </td>
                            <td> <!-- html:text property="taeedShodeAnbar" size="5" maxlength="5" styleClass="field"/> </td-->
                                <html:select property="taeedShodeAnbar" size="1">
                                    <html:options collection="yesNoList" property="id" labelProperty="name" />
                                </html:select>
                            </td>
                        </tr>

                        <!----------------------------------------->
                     </logic:equal>
        			<logic:notEqual name="role" value="anbar">
                        <html:hidden property="taeedShodehSarparast" />
                        <html:hidden property="tedadAnbar" />
                    </logic:notEqual>
    			</logic:notEqual>
				<logic:notEqual name="darkhastQateForm" property="action_type" value="create" >
                        <tr class="editRow0">
                            <td class="editLabel">ثبت کننده:</td>
                            <td class="editStar"> </td>
                            <td class="readData">
                                <bean:write name="sabtkonandehName" />
                            </td>
                        </tr>
                </logic:notEqual>
                <html:hidden property="sabtkonandeh" />

					<!----------------------------------------->
				    <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/edit-but.jsp" flush="true" />
					<!----------------------------------------->

				</table>
			</td>
		</tr>


		<!----------------------------------------->

  </table>
</html:form>

<!----------------------------------------->

<script type="text/javascript" language="Javascript1.1">
	setForm(document.darkhastQateForm);
	setEntity("DarkhastQate");
	document.darkhastQateForm.qateId.changed = true;
	document.darkhastQateForm.emdadgarId.changed = true;


    if (document.darkhastQateForm.action_type.value=="create")
	{
        document.darkhastQateForm.action="/emdad/c/validatedarkhastQate.run";
    }

	else
	{
        document.darkhastQateForm.action="/emdad/u/validatedarkhastQate.run";
    }

</script>

<html:javascript formName="darkhastQateForm" />
