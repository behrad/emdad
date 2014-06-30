<%@ page contentType="text/html; charset=UTF-8" import="com.objectj.emdad.web.util.Util, java.sql.*, java.util.*, java.io.IOException, com.objectj.emdad.ejb.UserAccessEntity, java.io.File,
                                                         com.objectj.emdad.web.util.*" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>
<HTML>
<head>
<html:base/>
<TITLE>تاييد فايل XLS</TITLE>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>
<script language="JavaScript">
	function tands() {
//		alert( importService. );
		form = document.importService;
		form.taeed.value = "true";
		form.submit();
	}
</script>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">
</head>
<BODY dir="rtl">
    <%
	String uploadPage = "";
	try {
		XlsValidator validator = null;
		String file = request.getParameter( "xlsFile" );
		String type = request.getParameter( "xlsType" );	
		String noeTasvieh = "";	
		if ( type.equals( "emdadXLS" ) ) {
			noeTasvieh = request.getParameter( "noeTasvieh" );			
			if	( noeTasvieh.equals( "namayandegi" ) ) {
				uploadPage = "/emdad/com/objectj/emdad/jsp/emdad.requpload.jsp";
				validator = new NamayandegiXls( file );
			}
			else if	( noeTasvieh.equals( "emdadgar" ) ) {
				uploadPage = "/emdad/com/objectj/emdad/jsp/emdadgar.requpload.jsp";
				validator = new EmdadgarXls( file );
			}
			else if	( noeTasvieh.equals( "jarsaghil" ) ) {
				validator = new JarsaghilXls( file );
			} else {
				throw new Exception( "NotSupported XLS file type for XlsParser" );				
			}		
		} else if ( type.equals( "serviceDoreiXLS" ) ) {
			validator = new ServiceDoreiXls( file );
			uploadPage = "/com/objectj/emdad/jsp/serviceDorei.requpload.jsp";
		} else {
			throw new Exception( "NotSupported XLS file type for XlsParser" );
		}
	%>
			<TABLE style="font-family: tahoma;font-size: 12px;" align="center" border="1" bordercolor="#4444AA" bgcolor="#CCCCEE" cellpadding="5" >
				<tr>
	<%

			for( int i = 0; i < validator.colSize(); i++ ) {
	%>
					<th><%= validator.getHeader( i ) %></th>
	<%
			}
	%>
				</tr>
	<%
			for( int row = 0; row <validator.rowSize(); row++ ) {
	%>
				<tr>
                <%
                    for( int col = 0; col < validator.colSize(); col++ ) {
                        validator.validateCell( row, col );
                %>
                    <td>

                        <%= validator.printCell( row, col ) + "&nbsp;" %>
                    </td>
                <%
                    }
                %>
				</tr>
	<%
            }
	%>

			</TABLE>
			<br>
			<table align="center">
				<tr>
					<td>
						<% if( type.equals( "emdadXLS" ) ) { %>
							<form name="importEmdad" action="/emdad/s/jozeatKhedmat.run" method="post" >
								<% if ( validator.isImportable() ) { %>
									<input type="submit" name="submit" value="  انتقال به سيستم  " class="emdadButton">
								<% } else { %>
									<center><font face="tahoma" color="#FF0000">لطفاَ فايل موردنظر را مجدداَ برسي کرده و نسبت به دريافت آن اقدام نماييد</font></center>
									<br>
								<% } %>
								<input type="button" name="back" value="  دريافت مجدد فايل XLS  " class="emdadButton" onClick="document.location='<%=uploadPage%>';">
								<input type="hidden" name="xlsFile" value="<%=request.getParameter( "xlsFile" )%>">
								<input type="hidden" name="page" value="<%=uploadPage%>"/>
								<input type="hidden" name="noeTasvieh" value="<%= noeTasvieh %>"/>
								<input type="hidden" name="action_type" value="specific,importEmdad"/>
							</form>
						<% } else if ( type.equals( "serviceDoreiXLS" ) ) {	%>
							<form name="importService" action="/emdad/s/serviceDorei.run" method="post" >
								<% if ( validator.isImportable() ) { %>
									<input type="submit" name="s1" value="  انتقال به سيستم  " class="emdadButton">
									<input type="button" name="a2" value=" تاييد و انتقال به سيستم " class="emdadButton" onClick="javascript:tands();">
								<% } else { %>
									<center><font face="tahoma" color="#FF0000">لطفاَ فايل موردنظر را مجدداَ برسي کرده و نسبت به دريافت آن اقدام نماييد</font></center>
									<br>
								<% } %>
								<input type="hidden" name="taeed" value="false"/>
								<input type="hidden" name="page" value="<%=uploadPage%>"/>
								<input type="button" name="back" value="  دريافت مجدد فايل XLS  " class="emdadButton" onClick="document.location='/emdad/com/objectj/emdad/jsp/serviceDorei.requpload.jsp';">
								<input type="hidden" name="xlsFile" value="<%=request.getParameter( "xlsFile" )%>"/>								
								<input type="hidden" name="action_type" value="specific,importServiceDorei"/>
							</form>
						<% } %>
					</td>
				</tr>
			</table>
	<%
		} catch ( Exception e ) {
			e.printStackTrace();
			String message = "فايل موردنظر داراي مشکل مي باشد! آنرا بررسي کرده و مجددا امتحان کنيد";
			request.setAttribute( "message", message );
			pageContext.forward( uploadPage );
		}
	%>
</BODY>
</HTML>