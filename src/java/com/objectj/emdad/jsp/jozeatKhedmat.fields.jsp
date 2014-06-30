<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<script>
	function emdadDetails() {
		showDetail(document.jozeatKhedmatForm.dastorkar, 
			null,
			"dimg1",
			"showEmdad",
			"edtl",
			"/emdad/s/emdad.run?action_type=specific,emdadShow") ;
	}

	function emdadSearch() {
		doSearchAndHide("showEmdad", 
				 "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/emdad.run?action_type=specific,find", 
				 document.jozeatKhedmatForm,
				 "dimg1");
	}

	function iradDetails() {		
		showDetail(document.jozeatKhedmatForm.iradId,
			document.jozeatKhedmatForm.iradIdCode,
			"dimg2",
			"showIrad",
			"idtl",
			"/emdad/s/irad.run?action_type=specific,iradShow") ;
	}

	function iradSearch() {
		doSearchAndHide("showIrad", 
				 "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/irad.run?action_type=specific,find",
				 document.jozeatKhedmatForm,
				 "dimg2");		
	}

	function iradIdCodeChanged(){
		document.jozeatKhedmatForm.iradIdCode.changed = true;
		document.jozeatKhedmatForm.iradId.value = "";
		document.jozeatKhedmatForm.iradId.changed = true;
		selectOjrat();
	}

	function computeHazineh() {
		ojratId = document.jozeatKhedmatForm.ojratId;
		qateIdCode = document.jozeatKhedmatForm.qateIdCode;
		tedadQate = document.jozeatKhedmatForm.tedadQate;
		emdadId = document.jozeatKhedmatForm.dastorKar;


		if(!isInteger(qateIdCode.value) || !isInteger(tedadQate.value))
			return;
						
		if ((ojratId==null || ojratId.value == "") && (qateIdCode==null || qateIdCode.value == "" || tedadQate==null || tedadQate.value == ""))
			return;		

		document.frames["hazinehFrame"].location.href = "/emdad/s/jozeatKhedmat.run?action_type=specific,computeHazineh&ojratId=" + ojratId.value + "&qateIdCode=" + qateIdCode.value + "&tedadQate=" + tedadQate.value + "&emdadId=" + emdadId.value;
		//ojratId.defaultValue = ojratId.value;
		qateId.defaultValue = qateId.value;
		tedadQate.defaultValue = tedadQate.value;
	}

	function selectOjrat() {		
		img = document.getElementById("dimg3");
		styl = document.getElementById("ojratCombo").style;
		vobj = document.jozeatKhedmatForm.iradIdCode;
		if (vobj==null || vobj.value == "")
			return;
		document.frames["ojratSelect"].location.href = "/emdad/s/ojrat.run?action_type=specific,ojratSelect"+"&id="+vobj.value;
		vobj.defaultValue = vobj.value;
	}

	function qateDetails() {
		//alert(document.jozeatKhedmatForm.qateId.value);
		//alert(document.jozeatKhedmatForm.qateIdCode.value);
		showDetail(document.jozeatKhedmatForm.qateId, 
			document.jozeatKhedmatForm.qateIdCode,
			"dimg4",
			"showQate",
			"qdtl",
			"/emdad/s/qate.run?action_type=specific,qateShow") ;
	}


	function qateSearch() {
		doSearchAndHide("showQate", 
				 "/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/qate.run?action_type=specific,find", 
				 document.jozeatKhedmatForm,
				 "dimg4");
	}

	function qateIdCodeChanged(){
		document.jozeatKhedmatForm.qateIdCode.changed = true;
		document.jozeatKhedmatForm.qateId.value = "";
		document.jozeatKhedmatForm.qateId.changed = true;
	}

	var lastCreator;
</script>

				<table border="0" cellpadding="2" cellspacing="0" class="editTable">

					<!----------------------------------------->

				<logic:equal name="isIjadKonandeh" value="1" >
					<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
                        <tr class="editRow1">
                            <td class="editLabel">دستورکار:</td>
                            <td class="editStar">*</td>
                            <td class="readData">
                                <html:hidden property="dastorkar"/>
                                <bean:write property="dastorkar" name="jozeatKhedmatForm"/>
                                <a href="javascript:emdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
                                &nbsp;
                            </td>
                        </tr>
					</logic:equal>
					
					<logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="emdadgar" >
                        <tr class="editRow1">
                            <td class="editLabel">دستورکار:</td>
                            <td class="editStar">*</td>
                            <td class="readData">
                                <html:hidden property="dastorkar"/>
                                <bean:write property="dastorkar" name="jozeatKhedmatForm"/>
                                <a href="javascript:emdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
                                &nbsp;
                            </td>
                        </tr>
					</logic:equal>

                    <logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="namayandegi" >
                        <tr class="editRow1">
                            <td class="editLabel">دستورکار:</td>
                            <td class="editStar">*</td>
                            <td class="readData">
                                <html:hidden property="dastorkar"/>
                                <bean:write property="dastorkar" name="jozeatKhedmatForm"/>
                                <a href="javascript:emdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
                                &nbsp;
                            </td>
                        </tr>
                   </logic:equal>


                    <logic:notEqual name="jozeatKhedmatForm" property="noeTasvieh" value="emdadgar" >
                        <logic:notEqual name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
							<logic:notEqual name="jozeatKhedmatForm" property="noeTasvieh" value="namayandegi" >
                                <tr class="editRow1">
                                    <td class="editLabel">دستورکار:</td>
                                    <td class="editStar">*</td>
                                    <td class="readData">
                                        <html:text property="dastorkar" size="11" maxlength="11" styleClass="field" onchange="valueChanged(this)"/>
                                        <a href="javascript:emdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
                                        &nbsp;
                                        <input type="button" value="جستجو" onClick="javascript:emdadSearch();" />
                                    </td>
                                </tr>
							</logic:notEqual>
						</logic:notEqual>
					</logic:notEqual>

					<!----------------------------------------->

					<tr class="editRow1">
						<td colspan="3">
							<div style="display:none;height:100px;" id="showEmdad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="edtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">کد ايراد:</td>
						<td class="editStar"> </td>
						<td class="readData">
							<html:text property="iradIdCode" size="10" maxlength="8" styleClass="field" onchange="javascript:iradIdCodeChanged();"/>
							<input type="hidden" name="iradId" value=""/>
							<a href="javascript:iradDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg2"></a>
							&nbsp;
							<input type="button" value="جستجو" onClick="javascript:iradSearch();" />
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td colspan="3">
							<div   style="display:none;height:100px;" id="showIrad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="idtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">اجرت:</td>
						<td class="editStar"> </td>
						<td class="readData">
							<div   style="display:none;height:100px;" id="ojratCombo">
								<iframe width="120" height=60 src="" frameborder="1" name="ojratSelect" marginheight="0" marginwidth="0" ></iframe>
							</div>
							<html:select property="ojratId" size="1">
								<html:options collection="ojratList1" property="eid" labelProperty="name" />
							</html:select>
							<a href="javascript:selectOjrat()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/refresh.jpg" border="0" id="dimg3"></a>
						</td>
					</tr>

					<!----------------------------------------->


                    <logic:notEqual name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
                        <tr class="editRow0">
                            <td class="editLabel">شماره فني قطعه:</td>
                            <td class="editStar"> </td>
                            <td class="readData">
                                <html:text property="qateIdCode" size="11" maxlength="11" styleClass="field" onchange="qateIdCodeChanged()"/>
                                <input type="hidden" name="qateId" value=""/>
                                <a href="javascript:qateDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg4"></a>
                                &nbsp;
                                <input type="button" value="جستجو" onClick="javascript:qateSearch();" />
                            </td>
                        </tr>

                        <!----------------------------------------->

                        <tr class="editRow0">
                            <td colspan="3">
                                <div   style="display:none;height:100px;" id="showQate">
                                    <iframe width="100%" height="100%" src="" frameborder="1" name="qdtl" marginheight="0" marginwidth="0" ></iframe>
                                </div>
                            </td>
                        </tr>
					<!----------------------------------------->
                        <tr class="editRow1">
                            <td class="editLabel">تعداد قطعه مصرفی:</td>
                            <td class="editStar"> </td>
                            <td> <html:text property="tedadQate" size="2" maxlength="2" styleClass="field"/> </td>
                        </tr>
                    </logic:notEqual>


                    <logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
                        <html:hidden property="qateIdCode" value="0"/>
                        <html:hidden property="qateId" />
                        <html:hidden property="tedadQate" value="0"/>
                    </logic:equal>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">هزینه متعارف:</td>
						<td class="editStar"> </td>
						<td class="readData">
							<html:text property="hazinehDefault" size="11" maxlength="11" styleClass="field" readonly="true"/><span class="fieldDescription">&nbsp;ريال</span>
							<input type="button" value="محاسبه" onclick="javascript:computeHazineh();" />
							<div style="display:none;height:100px;" id="showHazineh">
								<iframe width="120" height=60 src="" frameborder="1" name="hazinehFrame" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">هزینه طبق گفته سرویس دهنده:</td>
						<td class="editStar">*</td>
						<td>
							<html:text property="hazineh" size="11" maxlength="11" styleClass="field"/><span class="fieldDescription">&nbsp;ريال</span>
						</td>
					</tr>

					<!----------------------------------------->

                    <logic:notEqual name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
                        <tr class="editRow0">
                            <td class="editLabel">مشمول گارانتی:</td>
                            <td class="editStar">*</td>
                            <td>
                                <html:select property="guarantee" size="1">
                                    <html:options collection="guaranteeList" property="id" labelProperty="name" />
                                </html:select>
                            </td>
                        </tr>
                    </logic:notEqual>

                    <logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
                        <html:hidden property="guarantee" value="2"/>
                    </logic:equal>

				</logic:equal>

				<!----------------------------------------->

				<logic:notEqual name="isIjadKonandeh" value="1" >

					<tr class="editRow1">
						<td class="editLabel">دستورکار:</td>
						<td class="editStar">*</td>
						<td class="readData">
							<html:hidden property="dastorkar"/>
							<bean:write property="dastorkar" name="jozeatKhedmatForm"/>
							<a href="javascript:emdadDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg1"></a>
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

					<tr class="editRow0">
						<td class="editLabel">کد ايراد:</td>
						<td class="editStar"> </td>
						<td class="readData">
							<html:text property="iradIdCode" size="10" maxlength="8" styleClass="field" onchange="javascript:iradIdCodeChanged();"/>
							<input type="hidden" name="iradId" value=""/>
							<a href="javascript:iradDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg2"></a>
							&nbsp;
							<input type="button" value="جستجو" onClick="javascript:iradSearch();" />
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td colspan="3">
							<div   style="display:none;height:100px;" id="showIrad">
								<iframe width="100%" height="100%" src="" frameborder="1" name="idtl" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">اجرت:</td>
						<td class="editStar"> </td>
						<td class="readData">
							<div   style="display:none;height:100px;" id="ojratCombo">
								<iframe width="120" height=60 src="" frameborder="1" name="ojratSelect" marginheight="0" marginwidth="0" ></iframe>
							</div>
							<html:select property="ojratId" size="1">
								<html:options collection="ojratList1" property="eid" labelProperty="name" />
							</html:select>
							<a href="javascript:selectOjrat()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/refresh.jpg" border="0" id="dimg3"></a>
						</td>
					</tr>

					<!----------------------------------------->


                    <logic:notEqual name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
                        <tr class="editRow0">
                            <td class="editLabel">قطعه:</td>
                            <td class="editStar"> </td>
                            <td class="readData">
								<html:hidden property="qateIdCode" />
								<html:hidden property="qateId" />
								<%= request.getAttribute("qateName")%>
                                <a href="javascript:qateDetails()" ><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif" border="0" id="dimg4"></a>
                            </td>
                        </tr>

                        <!----------------------------------------->

                        <tr class="editRow0">
                            <td colspan="3">
                                <div   style="display:none;height:100px;" id="showQate">
                                    <iframe width="100%" height="100%" src="" frameborder="1" name="qdtl" marginheight="0" marginwidth="0" ></iframe>
                                </div>
                            </td>
                        </tr>
						
						<!----------------------------------------->
                        
						<tr class="editRow1">
                            <td class="editLabel">تعداد قطعه مصرفی:</td>
                            <td class="editStar"> </td>
                            <td>
								<html:hidden property="tedadQate" />
								<bean:write property="tedadQate" name="jozeatKhedmatForm"/>
							</td>
                        </tr>
                    </logic:notEqual>


                    <logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
                        <html:hidden property="qateIdCode" value="0"/>
                        <html:hidden property="qateId" />
                        <html:hidden property="tedadQate" value="0"/>
                    </logic:equal>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">هزینه متعارف:</td>
						<td class="editStar"> </td>
						<td class="readData">
							<html:hidden property="hazinehDefault"/>
							<bean:write property="hazinehDefault"  name="jozeatKhedmatForm"/>
							<span class="fieldDescription">&nbsp;ريال</span>
							<div style="display:none;height:100px;" id="showHazineh">
								<iframe width="120" height=60 src="" frameborder="1" name="hazinehFrame" marginheight="0" marginwidth="0" ></iframe>
							</div>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">هزینه طبق گفته سرویس دهنده:</td>
						<td class="editStar">*</td>
						<td class="readData">
							<html:hidden property="hazineh"/>
							<bean:write property="hazineh"  name="jozeatKhedmatForm"/>
							<span class="fieldDescription">&nbsp;ريال</span>
						</td>
					</tr>

					<!----------------------------------------->

					<tr class="editRow0">
						<td class="editLabel">مشمول گارانتی:</td>
						<td class="editStar">*</td>
						<td class="readData">
							<html:hidden property="guarantee" />
							<%= request.getAttribute("guaranteeName")%>
						</td>
					</tr>

				</logic:notEqual>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تأیید حسابدار عملیات:</td>
						<td class="editStar">*</td>
						<td class="readData">
							<logic:equal name="role" value="hesabdar" >
                                <logic:equal name="canChange" value="true" >
                                    <html:select property="taeedHesabdar" size="1">
                                        <html:options collection="taeedHesabdarList" property="id" labelProperty="name" />
                                    </html:select>
                                </logic:equal>
                                <logic:notEqual name="canChange" value="true" >
                                    <html:hidden property="taeedHesabdar"/>
                                    <%= request.getAttribute("taeedHesabdarName")%>
                                </logic:notEqual>
							</logic:equal>
							<logic:notEqual name="role" value="hesabdar" >
								<html:hidden property="taeedHesabdar"/>
								<%= request.getAttribute("taeedHesabdarName")%>
							</logic:notEqual>
						</td>
					</tr>
					<!----------------------------------------->

                    <logic:notEqual name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
                        <tr class="editRow0">
                            <td class="editLabel">تأیید گارانتی:</td>
                            <td class="editStar">*</td>
    						<td class="readData">
                                <logic:equal name="role" value="guarantee" >
                                    <logic:equal name="canChange" value="true" >
                                        <html:select property="taeedGuarantee" size="1">
                                            <html:options collection="taeedGuaranteeList" property="id" labelProperty="name" />
                                        </html:select>
                                    </logic:equal>
                                    <logic:notEqual name="canChange" value="true" >
                                        <html:hidden property="taeedGuarantee"/>
                                        <%= request.getAttribute("taeedGuaranteeName") %>
                                     </logic:notEqual>
                                </logic:equal>
                                <logic:notEqual name="role" value="guarantee" >
                                    <html:hidden property="taeedGuarantee"/>
                                    <%= request.getAttribute("taeedGuaranteeName") %>
                                </logic:notEqual>
                            </td>
                        </tr>
                    </logic:notEqual>

                    <logic:equal name="jozeatKhedmatForm" property="noeTasvieh" value="jarsaghil" >
                        <html:hidden property="taeedGurantee" value="0"/>
                    </logic:equal>

					<!----------------------------------------->

					<tr class="editRow1">
						<td class="editLabel">تأیید نماینده مدیریت:</td>
						<td class="editStar">*</td>
						<td class="readData">
							<logic:equal name="role" value="namayandeh" >
								<html:select property="taeedNamayandegi" size="1">
									<html:options collection="taeedNamayandegiList" property="id" labelProperty="name" />
								</html:select>
							</logic:equal>
							<logic:notEqual name="role" value="namayandeh" >
								<html:hidden property="taeedNamayandegi"/>
								<%= request.getAttribute("taeedNamayandegiName") %>
							</logic:notEqual>
						</td>
					</tr>
                    <html:hidden property="ijadKonandeh" />
                    <html:hidden property="noeTasvieh" />
                    <html:hidden property="actionName" />
                    <html:hidden property="popup" />


<script>
	document.jozeatKhedmatForm.dastorkar.changed = true;
	document.jozeatKhedmatForm.iradId.changed = true;
	document.jozeatKhedmatForm.iradIdCode.changed = true;
	document.jozeatKhedmatForm.qateId.changed = true;
	document.jozeatKhedmatForm.qateIdCode.changed = true;
</script>
