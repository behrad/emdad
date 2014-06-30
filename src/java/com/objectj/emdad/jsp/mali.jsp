<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<TITLE>سیستم گزارش گیری</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="image/emdad.css" type="text/css" rel="STYLESHEET">
</HEAD>
<%@ page import="java.util.HashMap,
  		         java.util.Map,
                 java.sql.Connection,
                 java.sql.Statement,
                 java.sql.ResultSet,
                 java.sql.SQLException,
                 java.util.Iterator,
                 java.util.ArrayList,
                 com.objectj.emdad.reports.utils.PropsFile"%>
<%
    Connection c = null;
    Statement sqlSt = null;
    try {
        c = com.objectj.emdad.reports.utils.DBUtil.getConnection();
        sqlSt = c.createStatement();
        ResultSet rs = sqlSt.executeQuery("SELECT * from report_main where  report_main.id="+request.getParameter("reportId"));
       String rep_name=null;
       String tozihat = null;
       if (rs.next())  {rep_name =  rs.getString("report_name");tozihat = rs.getString("tozihat");
           if(tozihat!=null)
           tozihat = tozihat.replaceAll("tozihTarikh","تاريخ آغاز و پايان هر دو در گزارش آورده ميشود").replaceAll("nemooneTarikh","  تاريخ نمونه :<INPUT READONLY=READONLY TYPE=TEXT VALUE=82/9/27 STYLE=BORDER:NONE;BACKGROUND-COLOR:GREEN;COLOR:WHITE>").replaceAll("tozihSaat","ساعت : 23-0").replaceAll("tozihdaghigheh","دقيقه : 59-0").replaceAll("shiftExample","مثلا شيفت کاري 8 صبح تا 1 بعدازظهر : 8:00 تا 12:59 محسوب ميشود");}
%>

<BODY leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" dir="rtl" background="./image/strips-w.jpg" />
<form method="post" action="mali.xls.jsp">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
<tr><td valign="top">

	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
		<tr>
			<td width="120" valign="top" background="image/strips-rt.jpg">&nbsp;</td>
			<td width="*" height="*" align="center" valign="top" bgcolor="#FFFFFF">

	<table width="100%" height="100" border="0" cellpadding="0" cellspacing="0" dir="rtl">
	  <tr valign="top">
		<td width="130" background="image/strips-rt.jpg">&nbsp;</td>
		  <td valign="middle" width="*" align="center" class="text" bgcolor="#FFFFFF">
		  	<table width="100%" cellpadding="3" bgcolor="#666699">

              <tr>
                <td width="100%" class="textTitle">
<div align="center"><%=rep_name%></div></td>
              </tr>
			</table>
              <%
        if((tozihat!=null && !tozihat.equalsIgnoreCase(""))){
              %>
		  	<table width="100%" cellpadding="3" bgcolor="green">
              <tr>
                <td width="100%" style="font-family:tahoma;font-size:12px;color:white">
<div align="center"><%=tozihat%></div></td>
              </tr></table>

              <%
        }
              %>
        </td>
		<td width="110" background="image/strips-lft.jpg">&nbsp;</td>
	  </tr>
	</table>
	  <table width="100%" height="800" border="0" cellpadding="0" cellspacing="0" dir="rtl">
		    <tr valign="top">
		  <td width="130" background="image/strips-rt.jpg">&nbsp;</td>
          <td width="*" align="center" class="textB" bgcolor="#FFFFFF">
<!---->
<table width="*" border="0" cellspacing="0" cellpadding="10" dir="rtl">
<%
        rs = sqlSt.executeQuery("SELECT * from report_parameters where  reportId="+request.getParameter("reportId"));
        String name = "";
        String staticName = "";
        String type="";
        String query = null;
        int hidden=0;
        int i = 0;
        while (rs.next()){
		    name=rs.getString("name");
		    staticName=rs.getString("staticName");
		    type=rs.getString("type");
            query = rs.getString("query");
            hidden = rs.getInt("hidden");
            if (hidden == 1) {
%>
        <input type="hidden" name = "<%=name%>" value="<%=request.getParameter(name)%>">
<%
            } else {
%>
	 <tr class="editRow<%=i%2%>">
		<td class="editLabel"><%=staticName%>:</td>
		<td class="editStar"></td>
        <td>
        <%
            if (query != null && !query.equalsIgnoreCase("")) {
                if (query.startsWith("select")) {
                Statement statement = c.createStatement();
                ResultSet xxx = statement.executeQuery(query);
        %>
            <select  name=<%=name%>><option value="-">----------</option>
        <%
                while (xxx.next()) {
        %>
              <option value="<%=xxx.getString(1)%>"><%=xxx.getString(2)%></option>
        <%
                }
        %>

            </select>
        <%       } else {
                    PropsFile pro = new PropsFile("/home/emdad/reports/resources/",query);
        %>
            <select  name=<%=name%>>
        <%
                    int ii=0;
                    int len = pro.getLength();
                    for (ii=0; ii<len;ii++){
        %>
              <option value="<%=ii%>"><%=pro.getValue(ii)%></option>
        <%
                    }
        %>

            </select>

        <%       }
            } else {
        %>
            <input type="text"  name="<%=name%>" size="10" maxlength="15">
        <%
            }
        %>
        </td>
	    </tr>
<%
		    i++;
            }
       		}

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

        <!--<tr class="editRow0">
        <td class="editLabel">نوع گزارش درخواستی:</td>
       <td colspan="2" align="right"><input name="type" type="radio" value="pdf" checked>PDF</td>
        </tr>
        <tr class="editRow0">
        <td class="editLabel"></td>
        <td colspan="2"  align="right"><input name="type" type="radio" value="html">html</td>
        </tr>
        <tr class="editRow0">
        <td class="editLabel"></td>
        <td colspan="2"  align="right"><input name="type" type="radio" value="excel">excel</td>
        </tr>-->
		<tr>
		<td  colspan="3" align="center">
          <input type="hidden" name="reportId" value="<%=request.getParameter("reportId")%>">
          <input type="hidden" name="type" value="excel">
          <input name="sub_but" type="submit" value="انجام گزارش" class="emdadButton"/>
          <input name="exit" type="button" class="emdadButton" onclick="self.close()" value="خروج" class="emdadButton">
          </td>
		</tr>
        </table>
            <br>
            <table width="100%" border="0" cellpadding="10" cellspacing="0" bgcolor="#CCCCFF" class="text">

              <tr>
                <td align="right"> تاريخ : <%=com.objectj.emdad.reports.utils.HejriUtil.getCurDate()%></td>
                <td align="left"> ساعت: <%=com.objectj.emdad.reports.utils.HejriUtil.getCurTime()%></td>
              </tr>
	<!--tr><td><a href="layout.jsp" target="_blank">layout</a></td></tr-->
            </table>
            <p>&nbsp;</p></td>
          <th width="110" background="image/strips-lft.jpg">&nbsp;</th>
        </tr>
	</table>



			</td>
			<td width="50" valign="top" background="image/strips-lft.jpg"><img src="image/strips-lft.jpg"></td>
		</tr>

	</table>

</td></tr></table>

<map name="emdadkhodro" id="emdadkhodro">
  <area shape="rect" coords="12,59,101,72" href="http://emdad-khodro.com">
</map>
</form>
</BODY>
</html>