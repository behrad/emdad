<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>

<html:base/>
﻿<link href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" rel="stylesheet" type="text/css">
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/filter.js"> </script>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-top.jsp" flush="true" />
<!----------------------------------------->

				<td class="filterCol"> 
					<select  class="generalText" id="field">
						<option  value="darkhastTagheer.eshterakId" id="String">شماره اشتراک</option >
						<option  value="darkhastTagheer.ijadKonandeh" id="String">ایجادکننده</option >
						<option  value="darkhastTagheer.noeService" id="Integer">نوع سرويس</option >
						<option  value="darkhastTagheer.nameKhanevadegi" id="String">نام خانوادگي</option >
						<option  value="darkhastTagheer.name" id="String">نام</option >
						<option  value="darkhastTagheer.tarikhTavalod" id="Date">تاريخ تولد</option >
						<option  value="darkhastTagheer.address" id="String">آدرس</option >
						<option  value="darkhastTagheer.postCode" id="String">کد پستي</option >
						<option  value="darkhastTagheer.email" id="String">پست الکترونيکي</option >
						<option  value="darkhastTagheer.tel" id="String">تلفن</option >
						<option  value="darkhastTagheer.mobile" id="String">تلفن همراه</option >
						<option  value="darkhastTagheer.shomarePelak" id="String">شماره پلاک</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
