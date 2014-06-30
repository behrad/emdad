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
						<option  value="namayandegi.namayandegiId" id="Integer">شناسه نمايندگي</option >
						<option  value="namayandegi.name" id="String">نام نمايندگي</option >
						<option  value="namayandegi.noeNamayandegi" id="Integer">نوع نمايندگي</option >
						<option  value="namayandegi.codeMantaghe" id="Integer">کد منطقه</option >
						<option  value="namayandegi.namayandegiTel" id="String">تلفن</option >
						<option  value="namayandegi.telZaroori" id="String">تلفن ضروري</option >
						<option  value="namayandegi.namayandegiMobile" id="String">موبايل</option >
						<option  value="namayandegi.namayandegiFax" id="String">فاکس</option >
						<option  value="namayandegi.namayandegiAddress" id="String">آدرس</option >
						<option  value="namayandegi.email" id="String">آدرس پست الکترونيکي</option >
						<option  value="namayandegi.emdadgar" id="String">امدادگر</option >
						<option  value="namayandegi.tarikhTahvil" id="Date">تاريخ تحويل خودرو</option >
						<option  value="namayandegi.sabegheFaaliat" id="Integer">سابقه فعاليت</option >
						<option  value="namayandegi.sabegheNoroozi" id="Integer">سابقه فعاليت نوروزي</option >
						<option  value="namayandegi.tarikhGharardad" id="Date">تاريخ عقد قرارداد</option >
						<option  value="namayandegi.shomarehGharardad" id="String">شماره قرارداد</option >
						<option  value="namayandegi.tahtePooshesh" id="String">محدوده تحت پوشش</option >
						<option  value="namayandegi.nazarIsaco" id="Integer">نظريه ايساکو</option >
						<option  value="namayandegi.tarikhAkharinEstelam" id="Date">تاريخ آخرين استعلام</option >
						<option  value="namayandegi.vazGharardad" id="Integer">وضعيت فعلي قرارداد</option >
						<option  value="namayandegi.olaviat" id="Integer">اولويت</option >
						<option  value="namayandegi.saghfeRiali" id="Integer">سقف ريالي</option >
						<option  value="namayandegi.hadaksarKar" id="Integer">حداکثر تعداد امداد ارجاعي</option >
						<option  value="namayandegi.hadaksarKar2" id="Integer">حداکثر تعداد تعمير ارجاعي</option >
						<option  value="namayandegi.dastgahEybyab" id="String">دستگاه عيب ياب</option >
						<option  value="namayandegi.telZaroori" id="String">تلفن ضروري</option >
					</select > 
				</td>

<!----------------------------------------->
<jsp:include page="/com/objectj/resources/jsp/tiles/emdad/filter-but.jsp" flush="true" />
<!----------------------------------------->
