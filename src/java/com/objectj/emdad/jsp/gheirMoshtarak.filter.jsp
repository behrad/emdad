<%@ page contentType="text/html; charset=UTF-8" %>

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
						<option  value="gheirMoshtarak.moshtarakId" id="String">شماره اشتراک</option >
						<option  value="gheirMoshtarak.nameKhanevadegi" id="String">نام خانوادگي</option >
						<option  value="gheirMoshtarak.name" id="String">نام</option >
						<option  value="gheirMoshtarak.tel" id="String">تلفن</option >
						<option  value="gheirMoshtarak.saleSakht" id="Integer">سال ساخت خودرو</option >
						<option  value="gheirMoshtarak.shomarePelak" id="String">شماره پلاک</option >
					</select >
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
