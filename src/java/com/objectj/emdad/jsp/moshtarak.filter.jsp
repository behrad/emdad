﻿<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
<link href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" rel="stylesheet" type="text/css">
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/filter.js"> </script>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="moshtarak.eshterakId" id="String">شماره اشتراک</option >
						<option  value="moshtarak.noeEshterak" id="Integer">نوع اشتراک</option >
						<option  value="moshtarak.noeService" id="Integer">نوع سرويس</option >
						<option  value="moshtarak.vazeat" id="Integer">وضعيت اشتراک</option >
						<option  value="moshtarak.nameKhanevadegi" id="String">نام خانوادگي</option >
						<option  value="moshtarak.name" id="String">نام</option >
						<option  value="moshtarak.tarikhTavalod" id="Date">تاريخ تولد</option >
						<option  value="moshtarak.address" id="String">آدرس</option >
						<option  value="moshtarak.postCode" id="String">کد پستي</option >
						<option  value="moshtarak.email" id="String">پست الکترونيکي</option >
						<option  value="moshtarak.tel" id="String">تلفن</option >
						<option  value="moshtarak.mobile" id="String">تلفن همراه</option >
						<option  value="moshtarak.saleSakht" id="Integer">سال ساخت خودرو</option >
						<option  value="moshtarak.shomarePelak" id="String">شماره پلاک</option >
						<option  value="moshtarak.shomareMotor" id="String">شماره موتور</option >
						<option  value="moshtarak.shomareShasi" id="String">شماره شاسي</option >
						<option  value="moshtarak.shomareVIN" id="String">VIN شماره</option >
						<option  value="moshtarak.tarikhShoro" id="Date">تاريخ شروع اشتراک</option >
						<option  value="moshtarak.tarikhAkharinTamdid" id="Date">تاريخ آخرين تمديد</option >
						<option  value="moshtarak.tarikhEngheza" id="Date">تاريخ انقضاي اشتراک</option >
						<option  value="moshtarak.tarikhTahvil" id="Date">تاريخ تحويل خودرو</option >
						<option  value="moshtarak.guarantee" id="Integer">ضمانت</option >
						<option  value="moshtarak.tarikhEnghezaGuarantee" id="Date">تاريخ انقضاي ضمانت</option >
						<option  value="moshtarak.tarikhServiceAvalieh" id="Date">تاريخ سرويس اوليه</option >
						<option  value="moshtarak.mahaleServiceAvalieh" id="String">محل سرويس اوليه</option >
						<option  value="moshtarak.tarikhAkharinEmail" id="Date">تاريخ آخرين نامه الکترونيکي</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->