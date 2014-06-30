<%@ page contentType="text/html; charset=UTF-8" %>

<script>

    function jozeatKhedmatList(dastorkar) {
		top.document.jozeatKhedmatForm.dastorkar.value = dastorkar;
        top.document.getElementById("jozeatKhedmatFrame").src="/emdad/s/jozeatKhedmat.run?action_type=specific,tasvieHesabNamayandegiList&id=" + dastorkar;
		top.document.getElementById("mostanadatRokhdadFrame").src="/emdad/s/mostanadatRokhdad.run?action_type=specific,tasvieHesabList&id=" + dastorkar;
		top.document.all.emdadId2.innerText = dastorkar;
    }
	
	function viewJozeatKhedmatList( id ) {    	
		w = screen.width - 10 ;
		h = screen.height - 70;
		args = "width=" + w + ", height=" + h + " , left=0, top=0, resizable=yes, scrollbars=yes, status=0";
		windowTitle = "TasvieNamayandegi";
		win3 = window.open("/emdad/s/jozeatKhedmat.run?action_type=specific,tasvieHesabNamayandegiListEdit&id="+id, windowTitle,args);
		//win3.resizeTo(screen.width*0.7,screen.height*0.94);
		win3.creator=document;
    }
</script>

<jsp:include page="/com/objectj/emdad/jsp/emdad.tasvieHesab.list.jsp" flush="true" />
