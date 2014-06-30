<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tld/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>


<META http-equiv=Content-Type content="text/html; charset=utf-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<LINK href="/emdad/com/objectj/resources/jsp/tiles/emdad/css/emdad.css" type="text/css" rel="STYLESHEET">

<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/list.js"> </script>
<script src="/emdad/com/objectj/resources/jsp/tiles/emdad/css/edit.js"> </script>

<%@ page import ="java.lang.*,com.objectj.emdad.ejb.util.EntityList,com.objectj.emdad.ejb.EntityAccess" %>


<html:base/>
<script>
    var size=500;
    function zoom(z){
        if(z==1)
            document.i.document.im.width=(size*=1.5);
        else
            document.i.document.im.width=(size/=1.5);
    }

    function checkSabt(elem) {
        elem.disabled = true;
//        top.creator.click();
//		top.close();
        theForm.submit();
    }

    function CloseWindow(){
        close();
    }

	var lastCreator;
</script>

<table width="100%" dir=rtl class="generalText">

    <tr class="editRow1">
        <td colspan="3">
            <iframe width="100%" height="100%" src="map.jsp" frameborder="1" name="edtl" marginheight="0" marginwidth="0" ></iframe>
        </td>
    </tr>

    <tr align="left">
        <td height="70" colspan="20" align="center">
            <p align="center"><a href="javascript:zoom(1);">Zoom In</a>
            <a href="javascript:zoom(-1);">Zoom Out</a> </p>
        </td>
    </tr>

  </table>


