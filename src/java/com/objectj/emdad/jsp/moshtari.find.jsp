﻿<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %><HEAD>

<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>

<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/fast-combo.jsp" flush="true" />
<%@ page import ="java.lang.*,com.objectj.emdad.ejb.util.EntityList,com.objectj.emdad.ejb.EntityAccess,java.util.ArrayList" %>
<script>
function toggleVisibility(){
var op = document.all("moreOptions");
//alert(op.style.visibility);
op.style.display = (op.style.display == "inline")?"none":"inline";
}
</script>
</head>

<!------------------------------------------------>
<html:base/>

<body onLoad="javascript:parent.window.resizeTo(screen.width,500);moshtarakForm.eshterakId.focus();">

	<html:form method="post" action="/s/moshtarak">
		<jsp:setProperty name="entity_access" property="deleteAccess" value= "false" />
		<jsp:setProperty name="entity_access" property="updateAccess" value= "false" />
		<jsp:setProperty name="entity_access" property="createAccess" value= "false" />
	
		<div dir="rtl">
		<table border="0" cellpadding="2" class="listTable" cellspacing="0" width="70%" >
			<tr>
				<td height="20" background="/emdad/com/objectj/resources/jsp/tiles/emdad/images/caption.jpg" class="textBw" align="center">&nbsp;شرطهاي لازم جهت يافتن مشتري&nbsp;&nbsp;</td>
				<td ><a href="javascript:toggleVisibility()">جستجوي&nbsp;دقيق&nbsp;تر</a></td>
				<td >
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/help.jsp" flush="true">
   <jsp:param name="help_url" value="search.help.html" />	
</jsp:include>
	</td>
				<td  align="left" id="searching" style="display:none;"><span style="font-family:tahoma;font-size:11px;color:brown;"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/search.gif" border="0">در حال جستجو ...</span></td>
			</tr>
		</table>
		</div>
		<!------------------------------------------------>
	<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="0" cellspacing="0"><tr><td>	
		<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
		<tr>
 				<td class="filterFindCell">شماره اشتراک:</td>
				<td class="filterFindEditCell"><html:text property="eshterakId" size="10" maxlength="10" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return submitenter(this,event)" styleClass="field"/></td>
				<td class="filterFindCell">شماره شاسي:</td>
				<td class="filterFindEditCell"><html:text property="shomareShasi" size="10" maxlength="20" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return submitenter(this,event)" styleClass="field"/></td>
				<td class="filterFindCell">شماره پلاک:</td>
				<td class="filterFindEditCell"><html:text property="shomarePelak" size="6" maxlength="12" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return submitenter2(this,event)" styleClass="field"/>&nbsp;
					<html:text property="shomarePelak2" size="6" maxlength="12" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return submitenter2(this,event)" styleClass="field"/></td>
				<td class="filterFindCell">نوع خودرو:</td>
				<td class="filterFindEditCell">
					<html:select property="noeKhodroId" size="1" style="width:120px;" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return fastCombo(this)" onfocus="emptyFastCombo()" styleClass="generalText">
						<html:options collection="noeKhodroList"property="eid" labelProperty="name" />
					</html:select>
				</td>
				<td class="filterFindCell">نام خانوادگي:</td>
				<td class="filterFindEditCell"><html:text property="nameKhanevadegi" size="10" maxlength="20" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return submitenter2(this,event)" styleClass="field"/></td>
				<td class="filterFindCell">سال ساخت:</td>
				<td class="filterFindEditCell"><html:text property="saleSakht" size="5" maxlength="4" styleClass="field"/></td>
				<td class="filterFieldCell">
					[تعداد:
					<% 
						ArrayList value_object_list = (ArrayList) request.getAttribute("value_object_list");
						if (value_object_list.size() != 0) { %>
							<bean:write property="totalRecords" name="cur_records"/>
					<%  } else { %>
							0
					<%  }%>
					]
				</td>
				<td class="filterFindEditCell"><a href="javascript:filter_s()"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/filter-apply.jpg" alt="نمايش با فيلتر" width="20" height="20" border="0"></a></td>

		</tr>
		<tr style="height:10px"><td colspan="6"></td></tr>
		</table>
	 </td></tr><tr id="moreOptions" style="display:none;"><td><div>

		<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
			<tr>
	
				<td class="filterFindCell">نوع اشتراک:</td>
				<td class="filterFindEditCell">
					<html:select property="noeEshterak" size="1" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return fastCombo(this)" onfocus="emptyFastCombo()"  styleClass="generalText">
						<html:options collection="noeEshterakList" property="id" labelProperty="name" />
					</html:select>
				</td>
	
				<td class="filterFindCell">نوع سرويس:</td>
				<td class="filterFindEditCell">
					<html:select property="noeService" size="1" styleClass="generalText">
						<html:options collection="noeServiceList" property="id" labelProperty="name" />
					</html:select>
				</td>
	
				<td class="filterFindCell">وضعيت:</td>
				<td class="filterFindEditCell">
					<html:select property="vazeat" size="1" styleClass="generalText">
						<html:options collection="vazeatList" property="id" labelProperty="name" />
					</html:select>
				</td>

				<td class="filterFindCell">نام:</td>
				<td class="filterFindEditCell"><html:text property="name" size="14" maxlength="20" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return submitenter(this,event)" styleClass="field"/></td>
			</tr>
			<tr>
				<td class="filterFindCell">آدرس:</td>
				<td class="filterFindEditCell"><html:text property="address" size="14" maxlength="20" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return submitenter(this,event)" styleClass="field"/></td>
				<td class="filterFindCell">تلفن:</td>
				<td class="filterFindEditCell"><html:text property="tel" size="14" maxlength="20" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return submitenter(this,event)" styleClass="field"/></td>
				<td class="filterFindCell">رنگ خودرو:</td>
				<td class="filterFindEditCell">
					<html:select property="rangeKhodroId" size="1" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return fastCombo(this)" onfocus="emptyFastCombo()" styleClass="generalText">
						<html:options collection="rangeKhodroList"property="eid" labelProperty="name" />
					</html:select>
				</td>
				<td class="filterFindCell">شهر:</td>
				<td class="filterFindEditCell">
					<html:select property="shahrId" size="1" style="width:150px;" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return fastCombo(this)" onfocus="emptyFastCombo()" styleClass="generalText">
						<html:options collection="shahrList"property="eid" labelProperty="name" />
					</html:select>
				</td>
			</tr>
	
			<tr>
				<td class="filterFindCell">بازارياب:</td>
				<td class="filterFindEditCell">
					<html:select property="bazaryabId" size="1" style="width:150px;" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return fastCombo(this)" onfocus="emptyFastCombo()" styleClass="generalText">
						<html:options collection="bazaryabList"property="eid" labelProperty="name" />
					</html:select>
	
				</td>
				<td class="filterFindCell">شماره موتور:</td>
				<td class="filterFindEditCell"><html:text property="shomareMotor" size="10" maxlength="20" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return submitenter(this,event)" styleClass="field"/></td>
				<td class="filterFindCell">شروع اشتراک:</td>
				<td class="filterFindEditCell"><html:text property="tarikhShoro" size="7" maxlength="10" styleClass="field"/></td>
				<td class="filterFindCell">شماره VIN:</td>
				<td class="filterFindEditCell"><html:text property="shomareVIN" size="10" maxlength="20" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return submitenter(this,event)" styleClass="field"/></td>
			</tr>
	
			<tr>
				<td class="filterFindCell">انقضاي اشتراک:</td>
				<td class="filterFindEditCell"><html:text property="tarikhEngheza" size="7" maxlength="10" styleClass="field"/></td>
				<td class="filterFindCell">گارانتي:</td>
				<td class="filterFindEditCell">
					<html:select property="guarantee" size="1" styleClass="generalText">
						<html:options collection="guaranteeList" property="id" labelProperty="name" />
					</html:select>
				</td>
				<td class="filterFindCell">مشترک:</td>
				<td class="filterFindEditCell">
					<html:select property="moshtarakYaNa" onkeypress="javascript:if (window.event.keyCode == 13) {filter_s();} return submitenter(this,event)" size="1" styleClass="generalText">
						<html:options collection="moshtarakYaNaList" property="id" labelProperty="name" />
					</html:select>
				</td>
				<td class="filterFindCell">تاريخ سرويس اوليه:</td>
				<td class="filterFindEditCell"><html:text property="tarikhServiceAvalieh" size="7" maxlength="10" styleClass="field"/></td>
			</tr>
		</table></div>
		</td></tr></table>
		<!------------------------------------------------>

		<div dir="rtl">
			<table border="0" cellpadding="2" class="listTable" cellspacing="0" width="30%" >
				<tr>
					<td height="20" background="/emdad/com/objectj/resources/jsp/tiles/emdad/images/caption.jpg" class="textBw" align="center">&nbsp;فهرست مشتريان داراي شرايط فوق&nbsp;&nbsp;</td>
				</tr>
			</table>
		</div>

		<!------------------------------------------------>

		<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="3" cellspacing="0">
				<tr class="listTableHeader">
					<td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "eshterakId"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره اشتراک"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</td>
					<td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "shoamreShasi"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره شاسي"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</td>
	
					<td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "shomarePelak"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "شماره پلاک"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</td>
	
	
					<td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "noeKhodroOnvan"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "نوع خودرو"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</td>
	
					<td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "rangeKhodroOnvan"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "رنگ خودرو"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</td>
					<td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "nameKhanevadegi"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام خانوادگي"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</td>
	
					<td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "name"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "نام"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</td>
	
					<!--td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "shahrId"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "شهر"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</td-->
	
						
					<td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "tarikhEngheza"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "تاريخ انقضا"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</td>

					<td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "moshtarakYaNa"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "مشترک"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</td>
	
					<td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "noeService"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "سرويس"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</td>

					<!--td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "tel"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "تل(f)ن"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</td-->

					<!--td class = "listRow0Col">
						<jsp:setProperty name="cur_records" property="columnName" value= "address"
						/><jsp:setProperty name="cur_records" property="columnTitle" value= "آدرس"
						/><jsp:getProperty name="cur_records" property="sortableColumnString" />
					</td-->
				</tr>

				<!------------------------------------------------>

				<% int i = 0; %>
				<logic:iterate id="value_object" name="value_object_list" >
					<tr  class="listRow<%=i%2%>">
						<td class = "listRow1Col">
								<a  href='javascript:select("<bean:write name="value_object" property="id" />",<%=i%>);'>
							<span id="eshterakId<%=i%>"><bean:write property="eshterakId" name="value_object"/></span>
								</a>
						</td>
	
						<td class = "listRow1Col"><span id="shomareShasi<%=i%>"><bean:write property="shomareShasi" name="value_object"/></span></td>

						<td class = "listRow1Col"><span id="shomarePelak<%=i%>"><bean:write property="shomarePelak" name="value_object"/></span></td>

						<td class = "listRow1Col"><span id="noeKhodroOnvan<%=i%>"><bean:write property="noeKhodroOnvan" name="value_object"/></span></td>
	
						<td class = "listRow1Col"><span id="rangeKhodroOnvan<%=i%>"><bean:write property="rangeKhodroOnvan" name="value_object"/></span></td>

						<td class = "listRow1Col"><span id="nameKhanevadegi<%=i%>"><bean:write property="nameKhanevadegi" name="value_object" /></span></td>
	
						<td class = "listRow1Col"><span id="name<%=i%>"><bean:write property="name" name="value_object"/></span></td>
						
						<td class = "listRow1Col"><span id="tarikhEnghezaHejri<%=i%>"><bean:write property="tarikhEnghezaHejri" name="value_object" /></span></td>
						
						<td class = "listRow1Col"><span id="moshtarakYaNaName<%=i%>"><bean:write property="moshtarakYaNaName" name="value_object" /></span></td>
	
						<!--td class = "listRow1Col"><span id="shahrId<%=i%>"><bean:write property="shahrId" name="value_object"/></span></td-->
	
	

						<td class = "listRow1Col"><span id="khadamateVijeh<%=i%>" style="display:none;"><bean:write property="noeService" name="value_object"/></span><bean:write property="noeServiceName" name="value_object"/>
							<span id="shahrId<%=i%>" style="display:none;"><bean:write property="shahrId" name="value_object"/></span>
							<span id="address<%=i%>" style="display:none;"><bean:write property="address" name="value_object"/></span>
							<span id="tel<%=i%>" style="display:none;"><bean:write property="tel" name="value_object"/></span>
						</td>

						<!--td class = "listRow1Col"><span id="tel<%=i%>"><bean:write property="tel" name="value_object"/></span></td-->

						<!--td class = "listRow1Col"><span id="address<%=i%>"><bean:write property="address" name="value_object"/></span></td-->
					</tr>
					<%i++;%>
				</logic:iterate>
				<script>document.all("searching").style.display ="none";</script>
		</table>
	
		<!------------------------------------------------>
		<html:hidden property="action_type"/>
		<html:hidden property="curpage" />
		<html:hidden property="order"/>
		<html:hidden property="sorttype" />
		<html:hidden property="id"/>
		<!------------------------------------------------>
	
		<table width=100% dir="rtl">
			<tr class="filterFindCell">
				<td background="/emdad/com/objectj/resources/jsp/tiles/emdad/images/filter-bk.jpg">
					<table border="0" cellspacing="0" cellpadding="0" align="center" class="generalText">
						<tr align="center"  class="filterFindCell">
		
							<!------------------------------>
		
		
							<td width="20"><a href='javascript:changePage(1)'><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/first.gif" alt="صفحه اول" border="0"></a></td>
		
							<!------------------------------>
		
							<logic:greaterThan name="cur_records" property="curPage" value="1" >
								<td width="20"><a href='javascript:changePage(<bean:write property="prevPage" name="cur_records"/>)'><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/previous.gif" alt="صفحه قبلي" border="0"></a></td>
							</logic:greaterThan>
		
							<!------------------------------>
		
		
							<td>
								<a href="javascript:refreshPage()">صفحه</a>
								<input id="pageInput" name="tmpPage" value="<bean:write property="curPage" name="cur_records"/>" size="2" maxlength="5" class="field" onKeyPress="pageKeyPress()">
							</td>
		
							<!------------------------------>
		
							<logic:equal name="cur_records" property="hasNextPage" value="true" >
								<td width="20"><a href='javascript:changePage(<bean:write property="nextPage" name="cur_records"/>)'><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/next.gif" alt="صفحه بعد" border="0"></a></td>
							</logic:equal>
		
							<!------------------------------>
		
							<td width="20" align="right"><a href='javascript:changePage(<bean:write property="totalPages" name="cur_records"/>)'><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/last.gif" alt="صفحه آخر" border="0"></a></td>
		
							<!------------------------------>
		
						</tr>
					</table>
				</td>
			</tr>
		</table>
	
	</html:form>
</body>

<!------------------------------------------------>

<script language="JavaScript" type="text/JavaScript">
	function pageKeyPress() {
	  if (window.event.keyCode == 13) {
		changePage(document.all.pageInput.value);
		window.event.keyCode == 0;
	  }
	}

	var creator;
	setForm(document.moshtarakForm);
	setEntity("Moshtarak");

	function sort(type){
	    sort2(type);
	}

	function changePage(page) {
		theForm.curpage.value = page;
		theForm.action_type.value = "specific,dummy";
		theForm.action="/emdad/s/moshtarak.run";
		theForm.submit();
	}

	function pElem(elemId,index) {
		elem = document.getElementById(elemId+index);
		if (elem) {
			exst = eval("creator."+elemId);
			if (exst!=null) {
				eval("creator."+elemId+".value= elem.innerText");
			}
		}
	}

	function select(id,index) {
		creator = top.creator;
		if (creator!=null) {
			if (creator.moshtarakId != null) {
				creator.moshtarakId.value = id;
				creator.moshtarakId.changed = true;
			}
			//pElem("eshterakId" ,index);

			if (creator.eshterakId != null) {
				creator.eshterakId.value = document.getElementById("eshterakId"+index).innerText;
				creator.eshterakId.changed = true;
			}

			if (creator.eshterakId1 != null) {
				creator.eshterakId1.value = document.getElementById("eshterakId"+index).innerText;
				creator.eshterakId1.changed = true;
			}

			if (creator.tel != null) {
				creator.tel.value = document.getElementById("tel"+index).innerText;
				creator.tel.changed = true;
			}

			if (creator.shahrId != null) {
				creator.shahrId.value = document.getElementById("shahrId"+index).innerText;
				creator.shahrId.changed = true;
			}

			if (creator.address != null) {
				creator.address.value = document.getElementById("address"+index).innerText;
				creator.address.changed = true;
			}
		}
		top.close();
	}
</script>
<!--<Script language="vbs" src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/farsi.inc"></Script>-->
