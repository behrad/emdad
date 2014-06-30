<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>
<html dir="rtl">
<head>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<title> فهرست رخدادها</title>
<style>
.headerCol{
    height:30px;
    padding-left:10px;
    padding-right:10px;
    font-family:tahoma;
    font-size:12px;
    color:white;
    background-color:gray;
    border:1px solid black;
    text-align:center;
}
.field{
    padding-left:10px;
    padding-right:10px;
    font-family:tahoma;
    font-size:10px;
    border:1px solid black;
    text-align:center;
}
</style>

<%@ page import ="java.lang.*,com.objectj.emdad.ejb.util.EntityList,com.objectj.emdad.ejb.EntityAccess,
                  java.sql.DriverManager,
                  java.sql.Connection,
                  java.sql.Statement,
                  java.sql.ResultSet,java.util.*" %>
</head>
    <%
       response.setContentType("application/vnd.ms-excel");
    %>

<body onload="doRefresh()" dir="rtl">


 <div dir="rtl">


	<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="0" cellspacing="0">
<tr>
	<%
       /* String s="";
        for(int i=1;i<=cols;i++){
        s=rs.getMetaData().getColumnName(i);
	*/%>
    <!--<td class="headerCol">&nbsp;<%//=s%></td>-->
 	<%/* }

        } catch ( Exception e ) {
            out.println( e );
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch ( Exception e ) {
                out.println( e );
                return;
            }
        }
    */%>
<!--<td class="headerCol" style="width:150px;">توضيحات</td>-->
    <td class="headerCol">&nbsp;رديف</td>
 	
    <td class="headerCol">&nbsp;شماره اشتراك</td>
 	
    <td class="headerCol">&nbsp;شماره بدنه</td>
 	
    <td class="headerCol">&nbsp;شماره پلاك</td>
 	
    <td class="headerCol">&nbsp;تلفن</td>
 	
    <td class="headerCol">&nbsp;ايراد خودرو</td>
 	
    <td class="headerCol">&nbsp;كيلومتر كاركرد</td> 	
 	
    <td class="headerCol">&nbsp;آدرس </td>

    <td class="headerCol">&nbsp;دستور كار</td>
 	
    <td class="headerCol">&nbsp;پيشبيني زمان انجام تعمير(روز)</td>
 	
    <td class="headerCol">&nbsp;نوع خدمت ويژه</td>

    <td class="headerCol">&nbsp;قيمت(ريال)</td>
 	
    <td class="headerCol">&nbsp;تاريخ تحويل كارخانه</td>
 	
    <td class="headerCol">&nbsp;شمارة كارت تعميراتي</td>
 	
    <td class="headerCol">&nbsp;پايان كار</td>
 	
    <td class="headerCol">&nbsp;انجام</td>
 	
<td class="headerCol" style="width:150px;">توضيحات</td>
<td class="headerCol" style="width:150px;">علت عدم صدور دستورکار</td>

</tr>

		<!------------------------------------------------>

		<logic:iterate id="value_object" name="value_object_list" >
			<tr>


				<td class = "field"><bean:write property="sabetSayar" name="value_object"/></td>


				<td class = "field"><bean:write property="moshtarakEshterakId" name="value_object"/></td>

				<td class = "field"><bean:write property="shahrShahrName" name="value_object"/></td>

				<td class = "field"><bean:write property="shomarePelak" name="value_object"/></td>

				<td class = "field"><bean:write property="tel" name="value_object"/></td>

                <td class = "field"><bean:write property="irad" name="value_object"/></td>

                <td class = "field"><bean:write property="noeDarkhastKonandehName" name="value_object"/></td>

                <td class = "field"><bean:write property="address" name="value_object"/></td>

                <td class = "field"><bean:write property="dastorkarGhabli" name="value_object"/></td>

                <td class = "field"><bean:write property="eghdamShodeh" name="value_object"/></td>

                <td class = "field"><bean:write property="akharinTaghyirDahandehName" name="value_object"/></td>

                <td class = "field"><bean:write property="mantagheh" name="value_object"/></td>

                <td class = "field"><bean:write property="sabtKonandeh" name="value_object"/></td>

                <td class = "field"><bean:write property="moshtarakName" name="value_object"/></td>

	<td class = "field"><bean:write property="mobile" name="value_object"/></td>

	<td class = "field"><bean:write property="id" name="value_object"/></td>


<logic:equal name="value_object" property="moshtarakYaNa" value="1" >
<td class="field" style="color:red">شماره شاسي معتبر نيست</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="2" >
<td class="field" style="color:red">عدم انطباق شاسي با اشتراک</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="3" >
<td class="field" style="color:red">غير مشترک</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="4" >
<td class="field" style="color:red">کد اشتراک غير معتبر است</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="5" >
<td class="field" style="color:green">توسط اعزامگر کنسل شد</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="6" >
<td class="field" style="color:red">-عدم صحت طول يکي از ستونها</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="7" >
<td class="field" style="color:red">قيمت اشتباه </td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="8" >
<td class="field" style="color:red">تاريخ پايان نامعتبر است</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="9" >
<td class="field" style="color:red">دستور کار نامعتبر است</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="10" >
<td class="field" style="color:red">عدم انطباق اشتراک و دستور کار</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="11" >
<td class="field" style="color:red">امداد شروع نشده يا پايان خورده</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="12" >
<td class="field" style="color:red">تاريخ پايان قبل از شروع</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="13" >
<td class="field" style="color:red">عدم صدور پايان کار</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="14" >
<td class="field" style="color:red">کد نمايندگي نامعتبراست</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="15" >
<td class="field" style="color:red">فرمت فايل نامعتبر</td>
</logic:equal>

<logic:equal name="value_object" property="moshtarakYaNa" value="16" >
<td class="field" style="color:red">کد امدادگر نامعتبر</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="17" >
<td class="field" style="color:red">نوع امداد نامعتبر</td>
</logic:equal>

<logic:equal name="value_object" property="moshtarakYaNa" value="18" >
<td class="field" style="color:red">ثابت و سيار نامعتبر است</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="19" >
<td class="field" style="color:red">درخواست کننده نامعتبر</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="20" >
<td class="field" style="color:red">وضعيت خدمت نامعتبر</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="21" >
<td class="field" style="color:red">نوع خدمت نامعتبر</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="22" >
<td class="field" style="color:red">ظرفيت امداد نمايندگی تکميل است</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="23" >
<td class="field" style="color:red">ظرفيت امداد امدادگر تکميل است</td>
</logic:equal>

<logic:equal name="value_object" property="moshtarakYaNa" value="24" >
<td class="field" style="color:red">شخص کد کاربری پذيرشگر ندارد</td>
</logic:equal>

<logic:equal name="value_object" property="moshtarakYaNa" value="26" >
<td class="field" style="color:red">نوع سرويس نامعتبر</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="27" >
<td class="field" style="color:red">کد دستور کار نامعتبر</td>
</logic:equal>
<logic:equal name="value_object" property="moshtarakYaNa" value="28" >
<td class="field" style="color:red">مدت نامعتبر</td>
</logic:equal>


<logic:equal name="value_object" property="moshtarakYaNa" value="0" >
<td class="field" style="color:blue">انجام شد</td>
</logic:equal>
	<td class = "field"><bean:write property="daftarOstaniId" name="value_object"/></td>
			</tr>
        </logic:iterate>

</table>
</div>

</body>
</html>