<%@ page import="java.util.Enumeration, javax.servlet.*, javax.servlet.http.*, java.io.*, com.oreilly.servlet.multipart.*" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<%

    File dir = null;
    String fileName = null;
    String urlName = null;
    boolean success = true;
    String mostanadatRokhdadId=null;
    File dir2 = null;
    String id = (String) request.getAttribute("mostanadatRokhdadId");
	//=-= System.out.println("id +" + id);


  try {
    dir = new File(com.objectj.emdad.web.util.Util.getUrl());
    dir2 = new File(com.objectj.emdad.web.util.Util.getUrl2());

    MultipartParser mp = new MultipartParser(request, 10*1024*1024); // 10MB
    Part part;
    while ((part = mp.readNextPart()) != null) {
      String name = part.getName();
      if (part.isParam()) { // it s a parameter part
        ParamPart paramPart = (ParamPart) part;
        String value = paramPart.getStringValue();
        if (name.equals("id")) {
            mostanadatRokhdadId = value;
			//=-= System.out.println("idddddddddddddd"+mostanadatRokhdadId);
          //doc = doc.getObject(id);
        } else {   }

      }
      else {
          if (part.isFile()) {  // it s a file part
            FilePart filePart = (FilePart) part;
            fileName = filePart.getFileName();
            long size = 0;
            if (fileName != null) {
              // the part actually contained a file
              size = filePart.writeTo(dir);
              urlName = dir2+"/"+fileName;
              fileName = dir+"\\"+fileName;
              //=-= System.out.println("upload file; name=" + name + "; filename=" + fileName +
              //  ", filePath=" + filePart.getFilePath() +
              //  ", content type=" + filePart.getContentType() +
              //  ", size=" + size);
            }
            //doc.setSize((int)(size/1024));
            success = size!=0;
          }
      }
    }
    if (success) {
      //com.objectj.emdad.util.Util.logger.info("u="+u+" user="+user);
      //doc.addNewTextDocument(dir+java.io.File.separator+fileName,(int)id);
    }
  }
  catch (IOException lEx) {
    //=-= System.out.println("upload ERROR "+ lEx);
    lEx.printStackTrace(System.out);
    success = false;
  }
%>
<form name="mostanadatRokhdadForm" method="post" action="/emdad/s/mostanadatRokhdad.run">

<input type="hidden" name="id" value="<%=mostanadatRokhdadId%>"/>
<input type="hidden" name="action_type" value="specific,uploaded" />
<input type="hidden" name="nameParvande" value="<%=urlName%>" />
<input type="hidden" name="fromPopUp" value="<%=request.getParameter("fromPopUp")%>" />
<%//=-= System.out.println("~~~~~~~~~~~~~~ fromPopUp (JSP): " + request.getParameter("fromPopUp"));%>
</form>
<script>
document.mostanadatRokhdadForm.submit();
</script>
</body>

</html>
