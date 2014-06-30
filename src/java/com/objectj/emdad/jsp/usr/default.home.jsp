<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %><HEAD>
<TITLE>ورود به سيستم عمليات</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>

</HEAD>


<BODY leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" dir="rtl" background="/emdad/com/objectj/resources/jsp/tiles/emdad/images/strips-w.jpg" />

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
<tr><td valign="top">

	<table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
	  <tr>
		<td width="100%" valign="top">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
			  <tr dir="rtl" valign="top">
				<td width="120"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/toprt.jpg" width="120" height="90" border="0" usemap="#emdadkhodro"></td>
				<td width="227"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/title.jpg" width="227" height="90"></td>
				<td width="*" height="79" valign="bottom" background="/emdad/com/objectj/resources/jsp/tiles/emdad/images/mid.jpg">&nbsp;
				</td>
			  </tr>
			</table>
		</td>
		<td width="50" dir="rtl"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/toplft1.jpg"></td>
		</tr>
	</table>

	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" dir="rtl">
		<tr>
			<td width="120" valign="top" background="/emdad/com/objectj/resources/jsp/tiles/emdad/images/strips-rt.jpg">&nbsp;</td>
			<td width="*" height="*" align="center" valign="top" bgcolor="#FFFFFF">

	<table width="100%" height="100" border="0" cellpadding="0" cellspacing="0" dir="rtl">
	  <tr valign="top">
		<td width="130" background="/emdad/com/objectj/resources/jsp/tiles/emdad/images/strips-rt.jpg">&nbsp;</td>
		  <td valign="middle" width="*" align="center" class="text" bgcolor="#FFFFFF">
		  	<table width="100%" cellpadding="3" bgcolor="#666699">
				
              <tr>
                <td width="100%" class="textTitle">مشتري گرامي
<div align="center">به سيستم عمليات شرکت امداد خودروي ايران خوش آمديد!</div></td>
              </tr>
			</table>
        </td>
		<td width="110" background="/emdad/com/objectj/resources/jsp/tiles/emdad/strips-lft.jpg">&nbsp;</td>
	  </tr>
	</table>
	  <table width="100%" height="800" border="0" cellpadding="0" cellspacing="0" dir="rtl">
	    <tr valign="top">
		  <td width="130" background="/emdad/com/objectj/resources/jsp/tiles/emdad/images/strips-rt.jpg">&nbsp;</td>
          <td width="*" align="center" class="textB" bgcolor="#FFFFFF">
		
			<table width="*" border="0" cellspacing="0" cellpadding="10" dir="rtl">

              <tr>
                <td><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/pgblue.jpg" width="235" height="143" border="0"></td>
                <td width="*">

						<table bordercolor="#666699" cellpadding=7 class="text" dir="rtl">
                    <tr>
                      <td>
							  
                          <table width="100%" border="0">
								  
                            <tr>
									
                              <td align="right" class="text"><a href="/emdad/s/moshtariDarkhastEshterak.run?action_type=specific,request">درخواست اشتراک</a><br>&nbsp;</td>
                            </tr>
								  
                            <tr>
									
                              <td align="right" class="text"><a href="/emdad/s/moshtari.run?action_type=specific,reqPeygiri">پي گيري مورد امداد</a><br>&nbsp;</td>
                            </tr>
								  
                            <tr>
									
                              <td align="right" class="text"><a href="/emdad/s/moshtariDarkhastTagheer.run?action_type=specific,request">درخواست تغيير اطلاعات مشترک</a><br>&nbsp;</td>
                            </tr>

                            <tr>
									
                              <td align="right" class="text">&nbsp;<br>&nbsp;</td>
                            </tr>
                            <tr>
									
                              <td align="left" class="text"><a href="/emdad/usr/home.run"><b>ورود به سيستم عمليات</b></a></td>
                            </tr>
								
                          </table>
                       </td>
                    </tr>
                  </table></td>
              </tr>
			</table>
            <br>
            <table width="100%" border="0" cellpadding="10" cellspacing="0" bgcolor="#CCCCFF" class="text">
              <tr>
                <td align="right"> تاريخ : <%=com.objectj.emdad.ejb.util.HejriUtil.getCurDate()%></td>
                <td align="left"> ساعت: <%=com.objectj.emdad.ejb.util.HejriUtil.getCurTime()%></td>
              </tr>
            </table>
            <p>&nbsp;</p></td>     
          <th width="110" background="/emdad/com/objectj/resources/jsp/tiles/emdad/images/strips-lft.jpg">&nbsp;</th>
        </tr>
	</table>



			</td>
			<td width="50" valign="top" background="/emdad/com/objectj/resources/jsp/tiles/emdad/images/strips-lft.jpg"><img src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/strips-lft.jpg"></td>
		</tr>
	</table>

</td></tr></table>

<map name="emdadkhodro" id="emdadkhodro">
  <area shape="rect" coords="12,59,101,72" href="http://emdad-khodro.com">
</map>
</BODY>
