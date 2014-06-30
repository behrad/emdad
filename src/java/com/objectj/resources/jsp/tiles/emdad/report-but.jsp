<%@ page import="java.sql.ResultSet,java.sql.Connection"%>
<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" %>
    <%
        String[] fields = (String[])request.getAttribute("fields");
        String[] titles = (String[])request.getAttribute("titles");
        ResultSet rs = (ResultSet)request.getAttribute("report");
        Connection connection = (Connection)request.getAttribute("connection");
        //=-= //=-= //=-= System.out.println("rs="+rs);
    %>

	<tr class="reportTableHeader">
    <%  for (int i=0; i<titles.length; i++) { %>
		<td class = "reportRow0Col"><%=titles[i]%></td>
    <%}%>
	</tr>

	<!------------------------------------------------>
	<%  int i = 1;
        while (rs.next()) {
    %>

		<tr  class="reportRow<%=i%2%>">
    <%  for (int j=0; j<fields.length; j++) { %>
			<td class = "reportRow1Col"><%=rs.getString(fields[j])%></td>
		<%i++;
        }}
            try {
                rs.close();
            } catch (Exception exception) {
                exception.printStackTrace(System.out);
            }
        %>
	<!------------------------------------------------>

</table>
