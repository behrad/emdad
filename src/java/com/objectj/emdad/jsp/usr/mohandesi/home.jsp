<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.objectj.emdad.ejb.UserAccessEntity,
                 com.objectj.emdad.ejb.util.HejriUtil"%>
<%
{
    String fullName = "";
	String userRole = "";
	String doName = "";
	try {
        String username = request.getUserPrincipal().getName();
        userRole = UserAccessEntity.getUserRoleFarsi(username);
        fullName = UserAccessEntity.getUserFullName(username);
		doName = UserAccessEntity.getDaftarOstaniName(username);
    } catch (Exception e) {
        fullName = "";
		userRole = "";
		doName = "";
    }
%>
		  	<table width="100%" cellpadding="3" bgcolor="#666699">

                <td width="100%" class="textTitle"><div align="center">به سيستم عمليات شرکت امداد خودرو خوش آمديد!</div></td>
              </tr>
			</table>
			<p>
<span class="tilesHeader">نام کاربر: <%= fullName %></span>
			<p>
<span class="tilesHeader">نقش کاربر: <%= userRole %></span>
			<p>
<span class="tilesHeader">دفتر استاني: <%= doName %></span>
<p><span class="tilesHeader"> تاريخ : <%=com.objectj.emdad.ejb.util.HejriUtil.getCurDate()%></span>
<p><p><span class="tilesHeader"> ساعت: <%=com.objectj.emdad.ejb.util.HejriUtil.getCurTime()%></span>
<p></p>
<p></p>
<hr>
<center>
<p></p>
<span class="text">لطفاً يکي از گزينه هاي سمت راست را انتخاب کنيد</span>
</center>
<%
}
%>