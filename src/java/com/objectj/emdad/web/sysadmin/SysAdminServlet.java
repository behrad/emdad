/**
 * Created by IntelliJ IDEA.
 * User: ramtin
 * Date: Jun 28, 2003
 * Time: 7:30:58 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.web.sysadmin;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class SysAdminServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("store"))
            handleStore(request, response);
        else if (action.equals("entity"))
            handleEntity(request, response);
    }

    protected void handleEntity(HttpServletRequest request, HttpServletResponse response) {
        EntityModel em = new EntityModel();
        em.setEntityName(request.getParameter("entityName"));
        em.setEntityTitle(request.getParameter("entityTitle"));
        em.setEntityDescr(request.getParameter("entityDescr"));

        char[] op = {'c', 'r', 'u', 'd', 'l', 'p'};
        for (int i = 0; i < op.length; i++) {
            UseCaseModel ucm = new UseCaseModel();
            ucm.setUcName(op[i] + "-" + em.getEntityName());
            ucm.setUcTitle(request.getParameter(op[i] + "Caption"));
            ucm.setUcURL("/" + op[i] + "/" + em.getEntityName() + ".run");
            ucm.setUcOperation(Character.toString(op[i]));
        }

        try {
            if (SysAdminDAO.insertEntity(em, Integer.parseInt(request.getParameter("bpId")))) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/com/objectj/emdad/jsp/sysadmin/ACL-frames.jsp");
                dispatcher.forward(request, response);
            } else {
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<h1>natoonessi doros kaareto anjaam bedi!</h1>");
            }
        } catch (ServletException e) {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }

    }

    protected void handleStore(HttpServletRequest request, HttpServletResponse response) {
        Enumeration en = request.getParameterNames();
        SysAdminDAO.backupACL();
        SysAdminDAO.insertSuperuserACL();
        int superuserId = SysAdminDAO.getSuperuserId();

        while (en.hasMoreElements()) {
            String paramName = (String)en.nextElement();
            if (!paramName.startsWith("cb-"))
                continue;
            paramName = paramName.substring(3);     // drop cb- prefix
            int ucId = Integer.parseInt(paramName.substring(0, paramName.indexOf(',')));
            int roleId = Integer.parseInt(paramName.substring(paramName.indexOf(',') + 1));
            if (roleId == superuserId)
                continue;
            SysAdminDAO.insertACL(roleId, ucId);
        }
    }


}
