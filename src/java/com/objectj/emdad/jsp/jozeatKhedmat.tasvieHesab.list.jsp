<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>



<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>

<html:base/>

<jsp:include page="/emdad/com/objectj/resources/jsp/tiles/emdad/list-top.jsp" flush="true" />
<html:form method="post" action="/r/jozeatKhedmat">



<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
<script>

function doDelete()
{
	question = confirm("\u0622\u064a\u0627 \u0645\u0637\u0645\u0626\u0646\u064a\u062f \u06a9\u0647 \u0645\u064a \u062e\u0648\u0627\u0647\u064a\u062f \u0633\u0637\u0631\u0647\u0627\u064a \u0627\u0646\u062a\u062e\u0627\u0628 \u0634\u062f\u0647 \u0631\u0627 \u062d\u0630\u0641 \u06a9\u0646\u064a\u062f\u061f")
	if (question !="0"){
        theForm.action_type.value = "specific,deleteJarsaghil";
        theForm.action="/emdad/s/jozeatKhedmat.run?action_type=specific,deleteJarsaghil";
        theForm.submit();
	}
}

function popupRead(id){
	args = "width=600, height=600 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "read";
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/jozeatKhedmat.run&action_type=specific,popupReadJarsaghil&id="+id, windowTitle,args);
    win3.creator=top;
}

function popupCreate(dastorkar){
	args = "width=600, height=600 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "create";
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/jozeatKhedmat.run&action_type=specific,popupCreateJarsaghil&id="+dastorkar, windowTitle,args);
    win3.creator=document;
}

function popupEdit(id){
	args = "width=600, height=600 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "edit";
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/jozeatKhedmat.run&action_type=specific,popupEditJarsaghil&id="+id, windowTitle,args);
    win3.creator=document;
}
</script>
</logic:equal>


<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="emdadgar">
<script>

function doDelete()
{
	question = confirm("\u0622\u064a\u0627 \u0645\u0637\u0645\u0626\u0646\u064a\u062f \u06a9\u0647 \u0645\u064a \u062e\u0648\u0627\u0647\u064a\u062f \u0633\u0637\u0631\u0647\u0627\u064a \u0627\u0646\u062a\u062e\u0627\u0628 \u0634\u062f\u0647 \u0631\u0627 \u062d\u0630\u0641 \u06a9\u0646\u064a\u062f\u061f")
	if (question !="0"){
        theForm.action_type.value = "specific,deleteEmdadgar";
        theForm.action="/emdad/s/jozeatKhedmat.run?action_type=specific,deleteEmdadgar";
        theForm.submit();
	}
}

function popupRead(id){
	args = "width=600, height=600 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "read";
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/jozeatKhedmat.run&action_type=specific,popupReadEmdadgar&id="+id, windowTitle,args);
    win3.creator=top;
}

function popupCreate(dastorkar){
	args = "width=600, height=600 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "create";
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/jozeatKhedmat.run&action_type=specific,popupCreateEmdadgar&id="+dastorkar, windowTitle,args);
    win3.creator=document;
}

function popupEdit(id){
	args = "width=600, height=600 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "edit";
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/jozeatKhedmat.run&action_type=specific,popupEditEmdadgar&id="+id, windowTitle,args);
    win3.creator=document;
}
</script>
</logic:equal>


<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="namayandegi">
<script>

function doDelete()
{
	question = confirm("\u0622\u064a\u0627 \u0645\u0637\u0645\u0626\u0646\u064a\u062f \u06a9\u0647 \u0645\u064a \u062e\u0648\u0627\u0647\u064a\u062f \u0633\u0637\u0631\u0647\u0627\u064a \u0627\u0646\u062a\u062e\u0627\u0628 \u0634\u062f\u0647 \u0631\u0627 \u062d\u0630\u0641 \u06a9\u0646\u064a\u062f\u061f")
	if (question !="0"){
        theForm.action_type.value = "specific,deleteNamayandegi";
        theForm.action="/emdad/s/jozeatKhedmat.run?action_type=specific,deleteNamayandegi";
        theForm.submit();
	}
}

function popupRead(id){
	args = "width=600, height=600 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "read";
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/jozeatKhedmat.run&action_type=specific,popupReadNamayandegi&id="+id, windowTitle,args);
    win3.creator=top;
}

function popupCreate(dastorkar){
	args = "width=600, height=600 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "create";
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/jozeatKhedmat.run&action_type=specific,popupCreateNamayandegi&id="+dastorkar, windowTitle,args);
    win3.creator=document;
}

function popupEdit(id){
	args = "width=600, height=600 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "edit";
	win3 = window.open("/emdad/com/objectj/emdad/jsp/general.popup.jsp?url=/emdad/s/jozeatKhedmat.run&action_type=specific,popupEditNamayandegi&id="+id, windowTitle,args);
    win3.creator=document;
}
</script>
</logic:equal>






    <!------------------------------------------------>
    <!--jsp:include page="/com/objectj/resources/jsp/tiles/emdad/list-filter.jsp" flush="true" / -->
    <!------------------------------------------------>

	<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">

		<!------------------------------------------------>

		<!--tr>
			<logic:equal name="entity_access" property="deleteAccess" value="true" >
				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td class = "filterFieldCell" width="2%" colspan="2"></td>
				</logic:equal>

				<logic:equal name="entity_access" property="updateAccess" value="false" >
					<td class = "filterFieldCell" width="2%"></td>
				</logic:equal>
			</logic:equal>

			<logic:equal name="entity_access" property="deleteAccess" value="false" >
				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td class = "filterFieldCell" width="2%"></td>
				</logic:equal>
			</logic:equal>

			<td class="filterFieldCell"><html:text property="dastorkar" size="11" maxlength="11" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="hazineh" size="11" maxlength="11" styleClass="field"/></td>
			<td class="filterFieldCell"><html:text property="tedadQate" size="11" maxlength="5" styleClass="field"/></td>
			<td class="filterFieldCell">
				<html:select property="guarantee" size="1" onkeypress="return fastCombo(this)" onfocus="emptyFastCombo()">
					<html:options collection="guaranteeList" property="id" labelProperty="name" />
				</html:select>
			</td>
		</tr-->

	    <!------------------------------------------------>

		<tr><td colspan="2" height="3"></td></tr>

		<!------------------------------------------------>

		<tr class="listTableHeader">
            <jsp:include page="/com/objectj/resources/jsp/tiles/emdad/checkAll.jsp" flush="true" />


			<td class = "listRow0Col">
				دستور کار
			</td>

			<td class = "listRow0Col">
				هزینه&nbsp;(ريال)
			</td>

			<td class = "listRow0Col">
				تعداد قطعه مصرفی
			</td>

			<td class = "listRow0Col">
				مشمول گارانتی؟
			</td>
		</tr>

		<!------------------------------------------------>		

		<% int i = 0; %>		
		<logic:iterate id="value_object" name="value_object_list" >
			<% if (i == 0) { %>
				<input type="hidden" name="id" value="<bean:write name="value_object" property="khedmatId"  />" />
			<% } %>
			<tr class="listRow<%=i%2%>">

				<logic:equal name="entity_access" property="deleteAccess" value="true" >
					<td class = "listRow1Col">
                            <logic:equal name="value_object" property="fieldDeleteAccess" value="1" >
							    <html:multibox property="selectedItems" ><bean:write name="value_object" property="id"  /></html:multibox>
                            </logic:equal>
					</td>
				</logic:equal>

				<logic:equal name="entity_access" property="updateAccess" value="true" >
					<td class = "listRow1Col" align="center">
                            <logic:equal name="value_object" property="fieldUpdateAccess" value="1" >
	    						<a  href='javascript:popupEdit("<bean:write name="value_object" property="id"  />");'><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/pencil.gif" border="0"></a >
                            </logic:equal>
					</td>
				</logic:equal>

				<td class = "listRow1Col">
					<logic:equal name="entity_access" property="readAccess" value="true" >
						<a  href='javascript:popupRead("<bean:write name="value_object" property="id"  />");'>
					</logic:equal>
					<bean:write property="dastorkar" name="value_object"/>
					<logic:equal name="entity_access" property="readAccess" value="true" >
						</a >
					</logic:equal>
				</td>

				<td class = "listRow1Col"><bean:write property="hazineh" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="tedadQate" name="value_object"/></td>

				<td class = "listRow1Col"><bean:write property="guaranteeName" name="value_object"/></td>
            </tr>
            <%i++;%>
        </logic:iterate>
    </table>

    <!------------------------------------------------>

  <table align="right" dir="rtl" border="0" cellspacing="0" class="generalText" width="100%">
	<tr>
		<td>
			<table border="0"  cellspacing="0" cellpadding="4" align="right" width="100%">
				<tr class="listTableFooter">
					<td>
						<html:hidden property="dastorkar" />
                        <html:hidden property="noeTasvieh" />

						<html:hidden property="action_type"/>
						<html:hidden property="curpage" />
						<html:hidden property="order"/>
						<html:hidden property="sorttype" />
						<html:hidden property="id"/>

						<logic:equal name="entity_access" property="deleteAccess" value="true" >
							<logic:equal name="deletePossible" value="true" >
								<input type="button" name="delbut" value="حذف" onclick="javascript:doDelete();" class="emdadButton"/>
							</logic:equal>
						</logic:equal>

						<logic:equal name="entity_access" property="createAccess" value="true" >
							<logic:equal name="createPossible" value="true" >
								<input type="button" name="newbut" value="جديد" onclick='javascript:popupCreate("<bean:write name="jozeatKhedmatForm" property="dastorkar"  />");' class="emdadButton"/>
							</logic:equal>
						</logic:equal>

						<logic:equal name="taeedModiriatPossible" value="true" >
							<logic:equal name="role" value="namayandeh" >
								<input type='button' value='تأیید نماینده مدیریت' onclick='javascript:doTaeed();' class='emdadButton'/>
							</logic:equal>
						</logic:equal>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</html:form>

<!------------------------------------------------>

<script>
	setForm(document.jozeatKhedmatForm);
	setEntity("JozeatKhedmat");

	function doTaeed() {
    	do_Submit("specific,doTaeed","s");
	}

</script>

