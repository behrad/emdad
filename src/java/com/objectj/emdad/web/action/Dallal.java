/**
 * Created by IntelliJ IDEA.
 * User: xxxx
 * Date: Feb 5, 2004
 * Time: 1:32:36 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.web.action;

import java.net.*;
import java.io.*;
import java.util.Iterator;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.*;

public class Dallal extends HttpServlet {
    static Logger logger = Logger.getLogger(Dallal.class.getName());

    public String getServletInfo() {
        return "Application Initialization";
    }

    public void init() {
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    String appURL = "http://222.192.55.220/reports/index.jsp%3FreportId=3";
//    String appURL = "http://222.192.55.220/reports/toefl_tips.pdf";
//        String appURL = "http://222.192.55.220/reports/compile.xls";
//        String appURL = "http://222.192.55.220/reports/compile.jsp%3freportId=3%26type=excel";
        try {
//        logger.info(request.getParameter("strURL"));
            String param = request.getParameter("strURL") + "?";
//        logger.info("--param="+param);
            Enumeration enu = request.getParameterNames();
            String paramName = null;
            String paramValue = null;
            while (enu.hasMoreElements()) {
                paramName = enu.nextElement().toString();
                paramValue = request.getParameter(paramName);
                if (!paramName.equalsIgnoreCase("strURL") && !paramName.equalsIgnoreCase("sub_but"))
                    param += paramName + "=" + paramValue + "&";
//           logger.info("param="+param);
            }
            param = param.substring(0, param.length() - 1);
//        param = "http://222.192.55.220/reports/compile.jsp?reportId=3&type=excel";
            URL url = new URL(param); //URLEncoder.encode(param, "UTF-8"));
            URLConnection urlc = url.openConnection();
            String ErrorStr = null;
            logger.info(urlc.getContentType());
            if (urlc.getContentType().startsWith("text/html") || urlc.getContentType().startsWith("text/plain")) {
//                response.setContentType("text/html; charset=UTF-8");
                InputStreamReader in = null;
                OutputStreamWriter out = null;
                char[] cc = new char[4096];
                try {
                    response.setContentType(urlc.getContentType());
                    in = new InputStreamReader(urlc.getInputStream(), "UTF-8");
                    out = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
                    int dat;
                    while ((dat = in.read(cc, 0, cc.length)) != -1) {
                        out.write(cc, 0, dat);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ErrorStr = "Error Streaming the Data";
                    response.getOutputStream().print(ErrorStr);
                } finally {
                    cc = null;
                    if (in != null) {
                        in.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                    if (response.getOutputStream() != null) {
                        response.getOutputStream().flush();
                        response.getOutputStream().close();
                    }
                }
            } else {
                BufferedInputStream bis = null;
                BufferedOutputStream bos = null;
                byte[] buff = new byte[4096];
                try {
                    int length = urlc.getContentLength();
                    response.setContentType(urlc.getContentType());
                    response.setContentLength(length);
                    InputStream in = urlc.getInputStream();
                    bis = new BufferedInputStream(in);
                    bos = new BufferedOutputStream(response.getOutputStream());
                    int bytesRead;
                    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                        bos.write(buff, 0, bytesRead);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ErrorStr = "Error Streaming the Data";
                    response.getOutputStream().print(ErrorStr);
                } finally {
                    buff = null;
                    if (bis != null) {
                        bis.close();
                    }
                    if (bos != null) {
                        bos.close();
                    }
                    if (response.getOutputStream() != null) {
                        response.getOutputStream().flush();
                        response.getOutputStream().close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
