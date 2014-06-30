<% if (request.getAttribute("noeEmdad") == null){ %>
<script>
	top.creator.location = "/emdad/s/emdad.run?action_type=specific,forceNoeEmdad";
	top.close();
</script>
<%}else if (((Integer)request.getAttribute("noeEmdad")).intValue() == 1){ %>
<script>
	top.creator.location = "/emdad/s/emdad.run?action_type=specific,forceNoeEmdad&noeEmdad=1";
	top.close();
</script>
<%}else if (((Integer)request.getAttribute("noeEmdad")).intValue() == 2){ %>
<script>
	top.creator.location = "/emdad/s/emdad.run?action_type=specific,forceNoeEmdad&noeEmdad=2";
	top.close();
</script>
<%}else if (((Integer)request.getAttribute("noeEmdad")).intValue() == 3){ %>
<script>
		top.creator.location = "/emdad/s/emdad.run?action_type=specific,forceNoeEmdad&noeEmdad=3";
	top.close();
</script>
<%}%>
