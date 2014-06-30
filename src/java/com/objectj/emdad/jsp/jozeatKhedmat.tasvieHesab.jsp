<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>



<%@ page import ="java.lang.*,com.objectj.emdad.ejb.util.EntityList,com.objectj.emdad.ejb.EntityAccess" %>


<html:base/>

<!-------------------------<<< EMDADGAR >>>-------------------->
<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="emdadgar">
<script>
    function jozeatKhedmatList() {
	if (!checkDastorKar())
		return;
    	id = document.jozeatKhedmatForm.dastorkar.value;
	w = screen.width - 10;
	h = screen.height - 70;
	args = "width=" + w + ", height=" + h + " , left=0, top=0, resizable=yes, scrollbars=yes, status=0";
	windowTitle = "TasvieEmdadgar";
	win3 = window.open("/emdad/s/jozeatKhedmat.run?action_type=specific,tasvieHesabEmdadgarList&id="+id, windowTitle,args);
		//win3.resizeTo(screen.width*0.7,screen.height*0.94);
	win3.creator=document;
    }
</script>
</logic:equal>

<!-------------------------<<< NAMAYANDEGI >>>-------------------->
<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="namayandegi">
<script>
    function jozeatKhedmatList() {
	if (!checkDastorKar())
		return;
    	id = document.jozeatKhedmatForm.dastorkar.value;
	w = screen.width - 10;
	h = screen.height - 70;
	args = "width=" + w + ", height=" + h + " , left=0, top=0, resizable=yes, scrollbars=yes, status=0";
	windowTitle = "TasvieNamayandegi";
	win3 = window.open("/emdad/s/jozeatKhedmat.run?action_type=specific,tasvieHesabNamayandegiList&id="+id, windowTitle,args);
		//win3.resizeTo(screen.width*0.7,screen.height*0.94);
	win3.creator=document;
    }

</script>
</logic:equal>

<!-------------------------<<< JARSAGHIL >>>-------------------->
<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil">
<script>
    function jozeatKhedmatList() {
	if (!checkDastorKar())
		return;
    	id = document.jozeatKhedmatForm.dastorkar.value;
	w = screen.width - 10;
	h = screen.height - 70;
	args = "width=" + w + ", height=" + h + " , left=0, top=0, resizable=yes, scrollbars=yes, status=0";
	windowTitle = "TasvieJarsaghil";
	win3 = window.open("/emdad/s/jozeatKhedmat.run?action_type=specific,tasvieHesabJarsaghilList&id="+id, windowTitle,args);
		//win3.resizeTo(screen.width*0.7,screen.height*0.94);
	win3.creator=document;
    }

</script>
</logic:equal>

<script>
	furl = "";
	loaded = false;
	function checkDastorKar() {
		if ( isEmpty(document.jozeatKhedmatForm.dastorkar.value) || !isInteger(document.jozeatKhedmatForm.dastorkar.value)) {
			alert("لطفا دستور کار را صحيح وارد کنيد");
			return false;
		}
		return true;
	}
	
	/*
	function emdadSearch() {
		doSearchAndHide("showEmdad",
				 "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/emdad.run?action_type=specific,find",
				 document.jozeatKhedmatForm,
				 "dimg1");
	}
	*/

	function emdadDetails() {
		showDetail(document.jozeatKhedmatForm.dastorkar,
			null,
			"dimg1",
			"showEmdad",
			"edtl",
			"/emdad/s/emdad.run?action_type=specific,emdadShow") ;
	}
	
	function doEditJKH() {
		jozeatKhedmatList();		
		return false;
	}
	
	function showEmdadList() {
		document.all.List.style.display = "";
		if ( !loaded ) 
			document.frames["emdadListF"].location.href = furl;
		loaded = true;
	}

</script>
<style>
	.listDiv{
	display:inline;
	height:750px;
	layer-background-color: #0099CC;
	border: solid 0px #996633;
	vertical-align: top;
	margin: 0px;
	padding: 0px;
	left: 0px;
	top: 0px;
	right: 0px;
	bottom: 0px;
	}
</style>


<center>
    <logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil">
            <span class="tilesHeader">تسويه حساب جرثقيل</span>			
    </logic:equal>

    <logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="emdadgar">
            <span class="tilesHeader">تسويه حساب امدادگر</span>
    </logic:equal>

    <logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="namayandegi">
            <span class="tilesHeader">تسويه حساب نمايندگي</span>
    </logic:equal>
</center>


<html:form method="post" action="/l/jozeatKhedmat" onsubmit="return doEditJKH();" >
	<html:hidden property="noeTasvieh" />

<table border="0" cellpadding="2" cellspacing="0" class="generalText" width="100%">
    <tr class="editRow0" align="center">
        <td width="150">&nbsp;</td>
        <td class="editLabel">دستور کار:</td>
        <td>
			<input type="text" name="dastorkar" size="12" maxlength="9" class="field" />
			<a href="javascript:emdadDetails()" ><img src="images/show-on.gif" border="0" id="dimg1"></a>&nbsp;&nbsp;
            <input type="button" value="جزئيات تسويه حساب" onClick='javascript:jozeatKhedmatList();' class="emdadButton"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            			
        </td>
        <td width="150">
			<% String role = (String)request.getAttribute( "role" ); %>
			<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil">
				<!-- empty for now -->							
			</logic:equal>
		
			<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="emdadgar">
				<logic:equal name="role" value="maliOp">
					<a href="/emdad/com/objectj/emdad/jsp/emdadgar.requpload.jsp" target="_blank">دريافت فايل XLS</a>
				</logic:equal>
			</logic:equal>
		
			<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="namayandegi">
				<logic:equal name="role" value="maliOp">
					<a href="/emdad/com/objectj/emdad/jsp/emdad.requpload.jsp" target="_blank">دريافت فايل XLS</a>
				</logic:equal>
			</logic:equal>			
		</td>
    </tr>
    <tr class="editRow0" align="center">
        <td colspan="5">
            <div style="display:none;height:100px;" id="showEmdad">
                <iframe width="100%" height="100%" src="" frameborder="1" name="edtl" marginheight="0" marginwidth="0" ></iframe>
            </div>			
        </td>
    </tr>
    <tr class="editRow1" align="center">
        <td colspan="5">
			<input type="button" value="نمايش ليست امدادها" onClick="javascript:showEmdadList();" class="emdadButton"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/help.jsp" flush="true">
   <jsp:param name="help_url" value="tasvieHesab.edit.html" />	
</jsp:include>
			<br>
				<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="emdadgar">
					<div id="List" class="listDiv">
						<span class="tilesHeader">
							فهرست امدادها
						</span>
						<div class="listDiv" id="emdadList">
							<iframe marginheight="0" marginwidth="0" src="" width="100%" height="100%" align="middle" frameborder="0" name="emdadListF"></iframe>
						</div>
					<script> furl="/emdad/s/emdad.run?action_type=specific,tasvieHesabEmdadgarList"; </script>
					</div>
				</logic:equal>
				<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil">
					<div id="List" class="listDiv">
						<span class="tilesHeader">
							فهرست امدادهاي جرثقيل
						</span>
						<div class="listDiv" id="emdadList">
							<iframe marginheight="0" marginwidth="0" src="" width="100%" height="100%" align="middle" frameborder="0" name="emdadListF" ></iframe>
						</div>
					<script> furl="/emdad/s/emdad.run?action_type=specific,tasvieHesabJarsaghilList"; </script>
					</div>
				</logic:equal>
				<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="namayandegi">
					<div id="List" class="listDiv">
						<span class="tilesHeader">
							فهرست امدادهاي نمايندگي
						</span>
						<div class="listDiv" id="emdadList">
							 <iframe marginheight="0" marginwidth="0" src="" vspace="0" width="100%" height="100%" align="middle" frameborder="0" name="emdadListF"></iframe>
						</div>
					<script> furl="/emdad/s/emdad.run?action_type=specific,tasvieHesabNamayandegiList"; </script>
					</div>
				</logic:equal>
		</td>
    </tr>    
</table>

</html:form>

<!------------------------------------------------>

<script>
	document.all.List.style.display="none";
	setForm(document.jozeatKhedmatForm);
	setEntity("JozeatKhedmat");
	document.jozeatKhedmatForm.dastorkar.changed = true;
	document.jozeatKhedmatForm.dastorkar.focus();
</script>