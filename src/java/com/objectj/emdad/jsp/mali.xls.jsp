<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<TITLE>سیستم گزارش گیری</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="image/emdad.css" type="text/css" rel="STYLESHEET">
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


</HEAD>
<%@ page import="java.util.HashMap,
  		         java.util.Map,
                 java.sql.Connection,
                 java.sql.Statement,
                 java.sql.ResultSet,
                 java.sql.SQLException,
                 java.util.Iterator,
                 java.util.ArrayList,
                 com.objectj.emdad.reports.utils.*"%>
<%
    Connection c = null;
    Statement sqlSt = null;
    try {
        c = com.objectj.emdad.reports.utils.DBUtil.getConnection();
        sqlSt = c.createStatement();
        //ResultSet rs = sqlSt.executeQuery("SELECT * from view_mali where zamanEzam between "+reqest.getParameter("paramaza")+" and "+  reqest.getParameter("paramata"));
        String query ="SELECT * from view_mali where zamanEzam between " +
                "'"+HejriUtil.hejriToChris(request.getParameter("paramaz")) +"'"+
                " and " +
                "'"+HejriUtil.hejriToChris(HejriUtil.reverse(HejriUtil.incDayInHejriDate(request.getParameter("paramta"))))+"'"+
                " and (DATEDIFF(dd,'1900/1/1',zamanEzam)- DATEDIFF(dd,'1900/1/1','" +HejriUtil.hejriToChris(request.getParameter("paramaz"))+"'"+
                "))< 7 and maliDone=2"+
                " order by zamanEzam desc";
        System.out.println(query);
        ResultSet rs = sqlSt.executeQuery(query);
       String rep_name=null;
       String tozihat = null;
        response.setContentType("application/vnd.ms-excel");

%>

<BODY leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" dir="rtl"/>
<table width="100%" dir="rtl" align="center" class="generalText" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td class="headerCol">&nbsp;کد حساب</td>

    <td class="headerCol">&nbsp;شرح</td>

    <td class="headerCol">&nbsp;بدهکار</td>

    <td class="headerCol">&nbsp;بستانکار</td>

    <td class="headerCol">&nbsp;شماره فاکتور</td>

    <td class="headerCol">&nbsp;تاريخ فاکتور</td>

    <td class="headerCol">&nbsp;مشمول گارانتي؟</td>

    <td class="headerCol">&nbsp;نقدي </td>

    <td class="headerCol">&nbsp;شماره اشتراک</td>

    <td class="headerCol">&nbsp;نوع اشتراک</td>

    <td class="headerCol">&nbsp;مشترک؟</td>

    <td class="headerCol">&nbsp;دستورکار</td>

    <td class="headerCol">&nbsp;نوع امداد</td>

    <td class="headerCol">&nbsp;تاريخ دستورکار</td>

    <td class="headerCol" style="width:150px;">عامل صورتحساب</td>

    <td class="headerCol" style="width:150px;">نام عامل صورتحساب</td>
</tr>
<%
        String propsPath = "/home/emdad/reports/resources/";
        while(rs.next()){
            for(int i=1;i<=2;i++){
%>
<tr>
<td class = "field"></td>
<td class = "field"><%=rs.getString("eshterakId")+","+rs.getString("emdadId")+","+((rs.getString("sharhOjrat")!=null)?rs.getString("sharhOjrat"):"-")+","+((rs.getString("quateName")!=null)?rs.getString("quateName"):"-")+","+((rs.getString("shomarehFactor")!=null)?rs.getString("shomarehFactor"):"-")%></td>
<td class = "field"><%=(i==1)?((rs.getString("hazineh")!=null)?rs.getString("hazineh"):"-"):""%></td>
<td class = "field"><%=(i==2)?((rs.getString("hazineh")!=null)?rs.getString("hazineh"):"-"):""%></td>
<td class = "field"><%=(rs.getString("shomarehFactor")!=null)?rs.getString("shomarehFactor"):"-"%></td>
<td class = "field"><%=HejriUtil.reverse(HejriUtil.chrisToHejri(rs.getDate("zamanEzam")))%></td>
<td class = "field"><%=new PropsFile(propsPath,"yesNo").getValue(rs.getInt("guarantee"))  %></td>
<td class = "field"><%=new PropsFile(propsPath,"yesNo").getValue(rs.getInt("nahveyePardakht"))%></td>
<td class = "field"><%=rs.getString("eshterakId")%></td>
<td class = "field"><%=new PropsFile(propsPath,"noeEshterak").getValue(rs.getInt("noeEshterak"))%></td>
<td class = "field"><%=new PropsFile(propsPath,"yesNo").getValue(rs.getInt("moshtarakYaNa"))%></td>
<td class = "field"><%=rs.getString("emdadId")%></td>
<td class = "field"><%=new PropsFile(propsPath,"noeEmdad").getValue(rs.getInt("noeEmdad"))%></td>
<td class = "field"><%=HejriUtil.reverse(HejriUtil.chrisToHejri(rs.getDate("zamanEzam")))%></td>
<td class = "field"><%=(rs.getString("noeEmdadgarName")==null)?new PropsFile(propsPath,"noeNamayandegi").getValue(rs.getInt("noeNamayandegi")):"امدادگر-"+rs.getString("noeEmdadgarName")%></td>
<td class = "field"><%=(rs.getString("nameNamayandegi")!=null)?rs.getString("nameNamayandegi"):rs.getString("nameEmdadgar")%></td>

</tr>

<%
            }
        }
%>
</table>
<%
    } catch (SQLException se) {
        se.printStackTrace();
    } finally {
        try {
            sqlSt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

%>
</BODY>
</html>