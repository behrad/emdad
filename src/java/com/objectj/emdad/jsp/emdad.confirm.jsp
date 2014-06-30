<script>
	<%if(request.getAttribute("hdnPage")!=null && !request.getAttribute("hdnPage").toString().trim().equals("")) {
			%>		top.creator.execScript("myParentRefresh(\"document.emdadForm.hdnPage.value='<%=request.getAttribute("hdnPage").toString()%>'\")");		
			<%
		}
		else{
			%>
			top.creator.execScript("myParentRefresh(\"\")");		
			<%
		}
			%>
	top.creator.execScript("myRefresh()");		
	
	top.close();
</script>
