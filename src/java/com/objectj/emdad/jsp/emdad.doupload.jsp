<%@ page import="java.util.Enumeration, javax.servlet.*, javax.servlet.http.*, java.io.*, com.oreilly.servlet.multipart.*" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<%

    File dir = null;
    String fileName = null;
    boolean success = true;
    int noeService = 0;    

  try {
    dir = new File(com.objectj.emdad.web.util.Util.getUploadPath());
    MultipartParser mp = new MultipartParser(request, 10*1024*1024); // 10MB
    Part part;
	int i = 0;
    while ((part = mp.readNextPart()) != null) {
      String name = part.getName();
      if (part.isParam()) { // it s a parameter part
        ParamPart paramPart = (ParamPart) part;
        String value = paramPart.getStringValue();
        if (name.equals("noeService")) {
            noeService = Integer.parseInt(value);
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
              fileName = dir+File.separator+fileName;
              System.out.println("upload file; name=" + name + "; filename=" + fileName +
                ", filePath=" + filePart.getFilePath() +
                ", content type=" + filePart.getContentType() +
                ", size=" + size);
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
<form name="emdadupload" method="post" action="/emdad/com/objectj/emdad/jsp/xlsParser.jsp">
	<input type="hidden" name="xlsType" value="emdadXLS"/>
	<input type="hidden" name="noeTasvieh" value="namayandegi"/>		
	<input type="hidden" name="xlsFile" value="<%=fileName%>" />
</form>
<script>
	document.emdadupload.submit();
</script>
</body>

</html>