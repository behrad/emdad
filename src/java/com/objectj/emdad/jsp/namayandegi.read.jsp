<!-- Start of head.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<html:form method="post" action="/r/namayandegi">
	<table width="100%" align="center" dir=rtl class="generalText">

		<!---------------------------------------->

		<tr>
			<td align="center"> 
				<table border="0" cellpadding="4" cellspacing="0" class="readTable">
	
					<!---------------------------------------->
	
					<tr class="readRow1">
						<td class="readLabel">شناسه نمايندگي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="namayandegiId" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0">
						<td class="readLabel">نام نمايندگي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="name" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1">
						<td class="readLabel">نوع نمايندگي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeNamayandegiName" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">نام شهر:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shahrName" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0">
						<td class="readLabel">کد منطقه:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="codeMantaghe" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">&#1578;&#1604;&#1601;&#1606;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="namayandegiTel" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">تلفن ضروري:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="telZaroori" name="value_object"/></td>
					</tr>

					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">موبايل:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="namayandegiMobile" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">&#1601;&#1575;&#1705;&#1587;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="namayandegiFax" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">آدرس:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="namayandegiAddress" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">آدرس پست الکترونيکي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="email" name="value_object"/></td>
					</tr>

					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">امدادگر:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="emdadgar" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">نوع خودرو امداد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="noeKhodroOnvan" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">نام دفتر استاني:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="daftarOstaniName" name="value_object"/></td>
					</tr>

					<!---------------------------------------->
	
					<tr class="readRow0">
						<td class="readLabel">تاريخ تحويل خودرو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="tarikhTahvil"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1">
						<td class="readLabel">&#1587;&#1575;&#1576;&#1602;&#1607; &#1601;&#1593;&#1575;&#1604;&#1610;&#1578;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="sabegheFaaliat"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0">
						<td class="readLabel">&#1587;&#1575;&#1576;&#1602;&#1607; &#1601;&#1593;&#1575;&#1604;&#1610;&#1578; &#1606;&#1608;&#1585;&#1608;&#1586;&#1610;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="sabegheNoroozi"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1">
						<td class="readLabel">تاريخ عقد قرارداد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="tarikhGharardad"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0">
						<td class="readLabel">شماره قرارداد:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="shomarehGharardad" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1">
						<td class="readLabel">محدوده تحت پوشش:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tahtePooshesh" name="value_object"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0">
						<td class="readLabel">نظريه ايساکو:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="nazarIsaco"/></td>
					</tr>
						
					<!---------------------------------------->
					<tr class="readRow1">
						<td class="readLabel">تاريخ آخرين استعلام:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="tarikhAkharinEstelamHejri" name="value_object"/></td>
					</tr>

					<!---------------------------------------->

					<tr class="readRow1">
						<td class="readLabel">&#1608;&#1590;&#1593;&#1610;&#1578; &#1601;&#1593;&#1604;&#1610; &#1602;&#1585;&#1575;&#1585;&#1583;&#1575;&#1583;:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write name="vazGharardad"/></td>
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow0">
						<td class="readLabel">اولويت:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="olaviat" name="value_object"/></td>
					</tr>
					
					<!---------------------------------------->
	
					<tr class="readRow1">
						<td class="readLabel">سقف ريالي:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="saghfeRiali" name="value_object"/>&nbsp;<span class="fieldDescription">ريال</span></td>
					</tr>
					
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">حداکثر تعداد امداد همزمان:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="hadaksarKar" name="value_object"/></td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">تعداد امداد در حال انجام:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="karDarDast" name="value_object"/></td>						
					</tr>
					
					<!---------------------------------------->
	
					<tr class="readRow0"> 
						<td class="readLabel">حداکثر تعداد تعميرات همزمان:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="hadaksarKar2" name="value_object"/></td>						
					</tr>
						
					<!---------------------------------------->
	
					<tr class="readRow1"> 
						<td class="readLabel">تعداد تعمير در حال انجام:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="karDarDast2" name="value_object"/></td>						
					</tr>
						
					<!---------------------------------------->

					<tr class="readRow0">
						<td class="readLabel">دستگاه عيب ياب:</td>
						<td width="5%"></td>
						<td class="readData"><bean:write property="dastgahEybyab" name="value_object"/></td>
					</tr>

		<!---------------------------------------->
		<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/read-but.jsp" flush="true" />
		<!---------------------------------------->

	</table>
</html:form>

<!---------------------------------------->

<script>
	setForm(document.namayandegiForm);
	setEntity("Namayandegi");
</script>
		<!-- Start of foot.jsp -modified -->

 <!-- End of foot.jsp -modified -->
