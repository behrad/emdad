<script>
	<%if(request.getAttribute("hdnPage")!=null && !request.getAttribute("hdnPage").toString().trim().equals("")) {
			%>	top.creator.execScript("document.rokhdadForm.hdnPage.value=\"<%=request.getAttribute("hdnPage").toString()%>\"");
			<%
		}
			%>
	
	top.creator.execScript("document.rokhdadForm.hdnPage.click()");
	top.creator.focus();
	top.close();
</script>