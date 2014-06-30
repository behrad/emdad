<script>
//    if (top.creator) {
    	//top.creator.location.href = top.creator.location.href;
  //  }
 // alert("<%=request.getAttribute("hdnPage").toString()%>");
	<%if(request.getAttribute("hdnPage")!=null && !request.getAttribute("hdnPage").toString().trim().equals("")) {
			%>top.creator.value="<%=request.getAttribute("hdnPage").toString()%>";<%
		}
			%>
	
	top.creator.click();
	top.close();
</script>