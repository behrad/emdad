<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<script>

	function addNew(s) {
		s0 = document.emdadForm.emdadId.value;
		s1 = document.emdadForm.rokhdadId.value;
		s2 = document.emdadForm.rokhdadRokhdadId.value;
		s3 = document.emdadForm.rokhdadMoshtarakId.value;
		document.emdadForm.action="/emdad/s/emdad.run?action_type=specific,addNew&emdadId="+s0+"&rokhdadId="+s1+"&rokhdadRokhdadId="+s2+"&rokhdadMoshtarakId="+s3;
		document.emdadForm.submit();
	}
	
	function finish(s)
	{
		s1 = document.emdadForm.rokhdadId.value;
		document.emdadForm.action="/emdad/s/emdad.run?action_type=specific,end&emdadId="+s+"&rokhdadId="+s1;
		document.emdadForm.submit();
	}
	
	
	function rokhdadDetails() {
			showDetail(document.emdadForm.rokhdadId,
					null,
					"dimg1",
					"showRokhdad",
					"rdtl",
					"/emdad/s/rokhdad.run?action_type=specific,rokhdadShow") ;
	}
	
	
	function emdadDetails(){
			showDetail(document.emdadForm.emdadId,
					null,
					"dimg2",
					"showEmdad",
					"rdt2",
					"/emdad/s/emdad.run?action_type=specific,emdadShow") ;
	}

	var lastCreator;
</script>

<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>

<html:form method="post" action="/s/validateEmdad" onsubmit="return validateEmdadForm(this)">
	<br><br>
	<table align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<html:hidden property="emdadId" />
		<html:hidden property="zamanEzam" />
		<html:hidden property="zamanEzam2" />
		<html:hidden property="zamanShoro" />
		<html:hidden property="zamanShoro2" />
		<html:hidden property="zamanPayan" />
		<html:hidden property="zamanPayan2" />
		<html:hidden property="zamanVagheiEzam" />
		<html:hidden property="zamanVagheiShoro" />
		<html:hidden property="zamanVagheiPayan" />

		<html:hidden property="zamanVagheiEzam2" />
		<html:hidden property="zamanVagheiShoro2" />
		<html:hidden property="zamanVagheiPayan2" />


		<html:hidden property="vazeatKhedmatId" />
		<html:hidden property="ezamgarId" />
		<html:hidden property="emdadgarId" />
		<html:hidden property="vazeatKonuni" />
		<html:hidden property="faseleAzNamayandegi" />
		<html:hidden property="kilometerKarkard" />
		<html:hidden property="mablaghPardakhtShodeh" />
		<html:hidden property="dalileToolKeshidaneEmdadId" />



		<html:hidden property="rokhdadId" />
		<html:hidden property="vazeatKonuni" />
		<html:hidden property="id" />

		<html:hidden property="noeEmdad" />
		<html:hidden property="hazinehJarsaghil" value="1"/>
		<html:hidden property="hazinehBoxel" value="1"/>
		<html:hidden property="modatTamir" />
		<html:hidden property="namayandegiId" />
		<html:hidden property="tozihat"/>

        <html:hidden property="dastoorKarGhabli" />
        <html:hidden property="vazeatDakheli" />


		<input type="hidden" name="rokhdadMoshtarakId" value='<bean:write name = "value_object" property="eshterakId" />' />
		<input type="hidden" name="rokhdadRokhdadId" value='<bean:write name = "value_object" property="rokhdadRokhdadId" />' />

		<tr>
			<td align="center">
				<table border="0" cellpadding="4" cellspacing="0" class="readTable" width="100%">

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">کد مورد:</td>
						<td class="editStar"> </td>
						<td class="readData">
							<bean:write property="rokhdadRokhdadId" name="value_object"/>
							<a href="javascript:rokhdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td colspan="3">
							<div   style="display:none;height:100px;" id="showRokhdad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="rdtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">دستور کار:</td>
						<td width="5%"></td>
						<td class="readData">
                            <bean:write property="emdadId"  name="emdadForm" />
                            <a href="javascript:emdadDetails()" > <img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg2"> </a>
                        </td>
					</tr>
					<!---------------------------------------->

                    <tr class="editRow1">
                        <td colspan="3">
                            <div style="display:none;height:100px;" id="showEmdad">
                                <iframe width="100%" height="100%" src="" frameborder="1" name="rdt2" marginheight="0" marginwidth="0" > </iframe>
                            </div>
                        </td>
                    </tr>
					<!---------------------------------------->
					<tr class="readRow0">
						<td class="readLabel">تاريخ پايان:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="emdadForm" property="zamanPayan" />  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">زمان پايان:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="zamanPayan2" name="emdadForm"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">راه اندازي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="rahAndazi" name="emdadForm"/>  </td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">علت نياز به سرويس جديد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="elateService" name="emdadForm"/>  </td>
					</tr>

				</table>				

		 		<!---------------------------------------->

				<table align="center" border="0" dir=rtl width="100%">
					<tr>
						<td height="70" colspan="3" align="center"> <input class="emdadButton" type="button"  onclick='addNew("<bean:write name="value_object" property="id" />");' value="شروع سرويس جديد"/></td>&nbsp;
						<td height="70" colspan="3" align="center"> <input class="emdadButton" type="button"  onclick='finish("<bean:write name="value_object" property="id" />");' value="پايان سرويس"/></td>
					</tr>
				</table>					
			</td>
		</tr>

	</table>

</html:form>

<!---------------------------------------->
<script type="text/javascript" language="Javascript1.1">
	setForm(document.emdadForm);
	setEntity("Emdad");
	document.emdadForm.rokhdadId.changed = true;
	document.emdadForm.emdadId.changed = true;
</script>
<html:javascript formName="emdadForm" />


